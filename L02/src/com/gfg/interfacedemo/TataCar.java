package com.gfg.interfacedemo;

public abstract class TataCar implements IndGovtNormsForCar, IndEnvNorms{

    @Override
    public String getCompanyName(){
        return "Tata";
    }

    public String getMusicSystem(){
        return "Tata Default Music System";
    }

    public String getEBS(){
        return "";
    }
}
