package com.gfg;

public class Laptop {



    public static long laptopCount=0l;

    public static String designData(){
        return "Design Data";
    }

    static
    {
        System.out.println("Executing static block in Laptop");
    }


    //public static CompanyLogo companyLogoAtClass = new CompanyLogo();

    public   CompanyLogo companyLogoAtObject = new CompanyLogo();

    private String os;
    private String processor;



    public Laptop(String os, String processor) {
        this.os = os;
        this.processor = processor;
        laptopCount++;
    }

    public void start(){
        System.out.println("Starting "+os);
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "os='" + os + '\'' +
                ", processor='" + processor + '\'' +
                '}';
    }
}
