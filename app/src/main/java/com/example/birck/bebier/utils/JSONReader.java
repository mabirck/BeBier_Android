package com.example.birck.bebier.utils;

import android.content.Context;
import android.util.Log;
import android.util.Pair;

import com.example.birck.bebier.models.Beer;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class JSONReader {
    private static String TAG = JSONReader.class.getSimpleName();
    public static Beer getBeerData(Context context, String beerName){
        try {
            JSONObject json = new JSONObject(loadJSONFromAsset(context, "data.json"));
            Beer beer = new Beer();
            beer.setName(beerName);
            beer.setAbout(json.getJSONObject(beerName).get("about").toString());
            beer.setAbv(json.getJSONObject(beerName).get("abv").toString());
            beer.setBeerStyle(json.getJSONObject(beerName).get("beer_style").toString());
            beer.setPhotoUrl(json.getJSONObject(beerName).get("photo_url").toString());
            beer.setEstCal(json.getJSONObject(beerName).get("est_cal").toString());
            beer.setBrewer(json.getJSONObject(beerName).get("brewer").toString());
            beer.setIbu(json.getJSONObject(beerName).get("ibu").toString());

            Log.d(TAG, beer.getName());
            Log.d(TAG, beer.getBrewer());
            Log.d(TAG, beer.getAbv());
            Log.d(TAG, beer.getPhotoUrl());
            Log.d(TAG, beer.getBeerStyle());
            Log.d(TAG, beer.getEstCal());
            Log.d(TAG, beer.getIbu());
            Log.d(TAG, beer.getAbout());

            return  beer;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Pair<ArrayList<String>, HashMap<String, ArrayList<String>>> beerNames(Context context) {
        ArrayList<String> beerNames = new ArrayList<>();
        HashMap<String, ArrayList<String>> recomendations = new HashMap<>();
        try {
            JSONObject json = new JSONObject(loadJSONFromAsset(context, "recomendations.json"));
            for (Iterator<String> it = json.keys(); it.hasNext(); ) {
                String key = it.next();
                for (int i = 0; i < json.getJSONArray(key).length(); i++) {
                    if (recomendations.get(key) == null)
                        recomendations.put(key, new ArrayList<String>());
                    recomendations.get(key).add(json.getJSONArray(key).get(i).toString());
                }
                beerNames.add(key);
            }
            return new Pair<>(beerNames, recomendations);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String loadJSONFromAsset(Context context, String filename) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            InputStream is = context.getAssets().open(filename);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }

            bufferedReader.close();
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
