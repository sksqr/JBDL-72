package com.gfg;

import java.security.InvalidParameterException;

public class Lecture {

    private String name;
    public String status;
    private String mentor;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if(!"Live".equals(status) || !"Upcoming".equals(status) ){
            throw new InvalidParameterException();
        }
        // add validation
        this.status = status;
    }

    public String getMentor() {
        return mentor;
    }

    public void setMentor(String mentor) {
        this.mentor = mentor;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", mentor='" + mentor + '\'' +
                '}';
    }
}
