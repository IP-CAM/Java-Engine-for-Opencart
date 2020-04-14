package br.com.fatecmogidascruzes.security.service;

import java.io.Serializable;
import java.util.Date;

public class CredenciaisDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private String token;
    private String authorities;
    private Date expirationDate;

    public CredenciaisDTO() {
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String Authorities) {
        this.authorities = Authorities;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
    

}
