package com.securities.trading.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//Trade store which is a ConcurrentHashMap to support multiThreading.
public class TradeStore {

    public static Map<String, Trade> tradeStore = new ConcurrentHashMap<String,Trade>();
    //public static Map<String, Trade> dailytradeStoreArchive = new ConcurrentHashMap<String,Trade>();


}
