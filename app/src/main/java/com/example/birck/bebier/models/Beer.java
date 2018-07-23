package com.example.birck.bebier.models;

public class Beer {
    private String name;
    private String abv;
    private String about;
    private String beerStyle;
    private String photoUrl;
    private String estCal;
    private String brewer;
    private String ibu;

    public Beer(String name, String abv, String about, String beerStyle, String photoUrl, String estCal, String brewer, String ibu) {
        this.name = name;
        this.abv = abv;
        this.about = about;
        this.beerStyle = beerStyle;
        this.photoUrl = photoUrl;
        this.estCal = estCal;
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

    public String getBeerStyle() {
        return beerStyle;
    }

    public void setBeerStyle(String beerStyle) {
        this.beerStyle = beerStyle;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getEstCal() {
        return estCal;
    }

    public void setEstCal(String estCal) {
        this.estCal = estCal;
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
