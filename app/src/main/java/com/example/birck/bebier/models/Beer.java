package com.example.birck.bebier.models;

public class Beer {
    private String name;
    private String abv;
    private String about;
    private String beer_style;
    private String photo_url;
    private String est_cal;
    private String brewer;
    private String ibu;

    public Beer(String name, String abv, String about, String beer_style, String photo_url, String est_cal, String brewer, String ibu) {
        this.name = name;
        this.abv = abv;
        this.about = about;
        this.beer_style = beer_style;
        this.photo_url = photo_url;
        this.est_cal = est_cal;
        this.brewer = brewer;
        this.ibu = ibu;
    }

    public Beer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbv() {
        return abv;
    }

    public void setAbv(String abv) {
        this.abv = abv;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getBeer_style() {
        return beer_style;
    }

    public void setBeer_style(String beer_style) {
        this.beer_style = beer_style;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public String getEst_cal() {
        return est_cal;
    }

    public void setEst_cal(String est_cal) {
        this.est_cal = est_cal;
    }

    public String getBrewer() {
        return brewer;
    }

    public void setBrewer(String brewer) {
        this.brewer = brewer;
    }

    public String getIbu() {
        return ibu;
    }

    public void setIbu(String ibu) {
        this.ibu = ibu;
    }
}
