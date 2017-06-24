package com.jcodee.mod3class1.rest.response;

/**
 * Created by johannfjs on 22/06/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class CompanyResponse {
    private String name;
    private String catchPhrase;
    private String bs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }
}
