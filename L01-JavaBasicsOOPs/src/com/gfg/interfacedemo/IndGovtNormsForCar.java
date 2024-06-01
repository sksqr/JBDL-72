package com.gfg.interfacedemo;

public interface IndGovtNormsForCar {

    String getRC();
    String getInsurance();

    String getCompanyName();

//    String getCarGPSLocation();

    default String getCarGPSLocation(){
        return "Not available";
    }

}
