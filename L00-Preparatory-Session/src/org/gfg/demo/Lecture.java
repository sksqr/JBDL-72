package org.gfg.demo;

public class Lecture {

    private String name;
    private String status;
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
