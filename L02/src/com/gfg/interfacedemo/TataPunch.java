package com.gfg.interfacedemo;

public class TataPunch extends TataCar{

    private Engine engine;

    public TataPunch() {
        engine = new Engine("1200");
    }

    public TataPunch(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String getPUC() {
        return null;
    }

    @Override
    public String getRC() {
        return "RC of Punch";
    }

    @Override
    public String getInsurance() {
        return null;
    }

    @Override
    public String getCarGPSLocation() {
        return "";
    }


    @Override
    public String getMusicSystem(){
        return "Punch Music System";
    }
}
