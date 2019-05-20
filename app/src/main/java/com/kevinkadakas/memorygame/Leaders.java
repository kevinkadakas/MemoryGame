package com.kevinkadakas.memorygame;

import java.io.Serializable;

public class Leaders implements Serializable {
    String Username, rTime, rPoints;
    Double rArg;

    public Leaders(String username, String time, String points, Double arg) {
        this.Username = username;
        this.rTime = time;
        this.rPoints = points;
        this.rArg = arg;
    }

    public String getUsername() {
        return Username;
    }

    public Double getrArg() {
        return rArg;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getrPoints() {
        return rPoints;
    }

    public String getrTime() {
        return rTime;
    }

    public void setrPoints(String rPoints) {
        this.rPoints = rPoints;
    }

    public void setrTime(String rTime) {
        this.rTime = rTime;
    }
}
