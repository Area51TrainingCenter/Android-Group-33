package com.jcodee.mod3class2.rest.response;

/**
 * Created by johannfjs on 27/06/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class LoginResponse {
    private int success;
    private String message;
    private int id;
    private String display;
    private String email;

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
