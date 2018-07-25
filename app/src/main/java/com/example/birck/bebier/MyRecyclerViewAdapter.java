package com.example.birck.bebier;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.birck.bebier.models.Beer;

import java.util.ArrayList;

import static com.example.birck.bebier.utils.JSONReader.getBeerData;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

    private ArrayList<String> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private Context mContext;

    // data is passed into the constructor
    MyRecyclerViewAdapter(Context context, ArrayList<String> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        mContext = context;
    }

    // inflates the row layout from xml when needed
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.user_row_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final Beer beer = getBeerData(this.mContext, mData.get(position));
        holder.name.setText(beer.getName());
        holder.phone.setText(beer.getBeer_style());

        Glide.with(this.mContext)
                .load(beer.getPhoto_url())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.thumbnail);
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(mContext);
                dialog.setContentView(R.layout.beer_dialog);
                dialog.setTitle(beer.getName());
                TextView beerName = dialog.findViewById(R.id.beerNameTV);
                TextView abv = dialog.findViewById(R.id.abvTV);
                TextView beerStyle = dialog.findViewById(R.id.beerStyleTV);
                TextView ibu = dialog.findViewById(R.id.ibuTV);
                TextView estCal = dialog.findViewById(R.id.estCalTV);
                ImageView img = dialog.findViewById(R.id.imageView);
                Glide.with(mContext)
                        .load(beer.getPhoto_url())
                        .apply(RequestOptions.circleCropTransform())
                        .into(img);
                beerName.setText(beer.getName());
                abv.setText(beer.getAbv());
                beerStyle.setText(beer.getBeer_style());
                ibu.setText(beer.getIbu());
                estCal.setText(beer.getEst_cal());

                dialog.show();
//
//                // set the custom dialog components - text, image and button
//                TextView text = (TextView) dialog.findViewById(R.id.text);
//                text.setText("Android custom dialog example!");
//                ImageView image = (ImageView) dialog.findViewById(R.id.image);
//                image.setImageResource(R.drawable.ic_launcher);

            }
        });

    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, phone;
        public ImageView thumbnail;
        public RelativeLayout card;
        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            phone = view.findViewById(R.id.phone);
            thumbnail = view.findViewById(R.id.thumbnail);
            card = view.findViewById(R.id.card);
//            view.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    // send selected contact in callback
//                    listener.onBeerSelected(beerListFiltered.get(getAdapterPosition()));
//                }
//            });
        }
    }

    // convenience method for getting data at click position
    String getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}