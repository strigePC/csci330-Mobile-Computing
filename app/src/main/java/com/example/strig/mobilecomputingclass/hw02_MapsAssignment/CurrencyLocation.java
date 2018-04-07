package com.example.strig.mobilecomputingclass.hw02_MapsAssignment;

import com.google.android.gms.maps.model.LatLng;

public class CurrencyLocation {
    private LatLng location;
    private Double currency;
    private String sign;

    public CurrencyLocation(String sign, Double currency, LatLng location) {
        setSign(sign);
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
}
