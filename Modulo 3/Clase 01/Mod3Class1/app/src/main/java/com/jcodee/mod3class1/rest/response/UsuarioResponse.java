package com.jcodee.mod3class1.rest.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by johannfjs on 22/06/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class UsuarioResponse {
    private int id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;
    @SerializedName("address")
    private AdressResponse adressResponse;
    @SerializedName("company")
    private CompanyResponse companyResponse;

    public CompanyResponse getCompanyResponse() {
        return companyResponse;
    }

    public void setCompanyResponse(CompanyResponse companyResponse) {
        this.companyResponse = companyResponse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public AdressResponse getAdressResponse() {
        return adressResponse;
    }

    public void setAdressResponse(AdressResponse adressResponse) {
        this.adressResponse = adressResponse;
    }
}
