package com.gfg.thread.mmtDemo;

import java.util.ArrayList;
import java.util.List;

public class MmtDemo {
    public static void main(String[] args) {
//        MmtSearchService mmtSearchService = new MmtSearchService();
//        System.out.println(mmtSearchService.getAllFlightsBySrcAndDes("DLI","BLR"));

        List<FlightSearchInterface> flightSearchImps = new ArrayList<>();
        flightSearchImps.add(new GoFlightSearchService());
        flightSearchImps.add(new IndigoFlightSearchService());
        //
        //
        MmtSearchService mmtSearchService = new MmtSearchService(flightSearchImps);
        System.out.println(mmtSearchService.getAllFlightsBySrcAndDes("DLI","BLR"));

    }
}
