package com.gfg;

public class EnumDemo {

    public static void main(String[] args) {
       // Day day = new Day();
        Day day = Day.SUNDAY;

        String weekDay = "Sunday";
        String weekDay1 = "Sun";


        System.out.println(day.getName());

        System.out.println(Day.MONDAY.getName());


    }
}


enum Day{
    SUNDAY("SUN",1),MONDAY("MON",2);
    private String name;

    private Integer no;


    private Day(String name, Integer no) {
        this.name = name;
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }
}


enum Status{
    UPCOMING("Upcoming"),LIVE("Live"),ARCHIVED("Archived");
    String value;

    Status(String value) {
        this.value = value;
    }
}

class Lecture{
    String name;
    String mentor;

    //String status;
    Status status;
}