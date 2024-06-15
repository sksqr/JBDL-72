package com.gfg.thread.mmtDemo;

import java.util.List;

public interface FlightSearchInterface {
    List<FlightData> getFlightsBySrcDes(String src, String des);
}
