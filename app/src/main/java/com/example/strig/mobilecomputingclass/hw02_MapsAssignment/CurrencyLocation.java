package com.example.strig.mobilecomputingclass.hw02_MapsAssignment;

import com.google.android.gms.maps.model.LatLng;

public class CurrencyLocation {
    private String countryName;
    private String sign;
    private String currencyCode;
    private String currencyName;
    private LatLng location;
    private Double currency;

    public CurrencyLocation(String countryName, String sign, String currencyCode, String currencyName, Double currency, LatLng location) {
        setCountryName(countryName);
        setSign(sign);
        setCurrencyCode(currencyCode);
        setCurrencyName(currencyName);
        setCurrency(currency);
        setLocation(location);
    }

    public LatLng getLocation() {
        return location;
    }

    public void setLocation(LatLng location) {
        this.location = location;
    }

    public Double getCurrency() {
        return currency;
    }

    public void setCurrency(Double currency) {
        this.currency = currency;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return String.format("Location [%f, %f], Currency (%s): %f", location.latitude, location.longitude, sign, currency);
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }
}
