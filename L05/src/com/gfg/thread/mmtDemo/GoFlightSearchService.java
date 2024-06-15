package com.gfg.thread.mmtDemo;

import java.util.ArrayList;
import java.util.List;

public class GoFlightSearchService implements FlightSearchInterface{
    @Override
    public List<FlightData> getFlightsBySrcDes(String src, String des) {
        // API call to indigo Server
        //
        List<FlightData> data = new ArrayList<>();
        data.add(new FlightData("DLI", "BLR", 15000.00));
        data.add(new FlightData("DLI", "BLR", 14000.00));
        data.add(new FlightData("DLI", "BLR", 19000.00));
        return data;
    }
}
