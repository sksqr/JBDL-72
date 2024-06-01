package com.gfg.interfacedemo;

public abstract class TataCar implements IndGovtNormsForCar, IndEnvNorms{

    @Override
    public String getCompanyName(){
        return "Tata";
    }

    public String getMusicSystem(){
        return "";
    }

    public String getEBS(){
        return "";
    }
}
