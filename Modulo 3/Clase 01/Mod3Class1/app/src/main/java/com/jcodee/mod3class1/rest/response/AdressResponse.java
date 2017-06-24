package com.jcodee.mod3class1.rest.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by johannfjs on 22/06/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class AdressResponse {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    @SerializedName("geo")
    private GeoResponse geoResponse;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public GeoResponse getGeoResponse() {
        return geoResponse;
    }

    public void setGeoResponse(GeoResponse geoResponse) {
        this.geoResponse = geoResponse;
    }
}
