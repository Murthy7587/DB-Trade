package com.securities.trading.services;

import com.securities.trading.model.Trade;
import com.securities.trading.model.TradeStore;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TradingRun {

    //Creating map "tradeStore" will keep on storing data into trade store in append mode daily.

    TradeStore store = new TradeStore();
    Map<String, Trade> tradeStore = store.tradeStore;
   // Map<String, Trade> dailytradeStoreArchive = store.dailytradeStoreArchive;

    public TradingRun(){
        //TradeStore store = new TradeStore();
        Map<String, Trade> tradeStore = TradeStore.tradeStore;
    }
    //Method where Trade execution will start
    public boolean runTrade(Trade trade){

        ValidateTrading validate = new ValidateTrading();
        if(tradeStore.size() > 0) {
            //Check for version
            if(!validate.validateVersion(trade, tradeStore)){
                return false;
            }
            //Check for maturityDate
            if(!validate.validateMaturityDate(trade)){
                return false;
            }
        }

        tradeStore.put(trade.getId(),trade);
        System.out.println(tradeStore.toString());
        return true;
    }

    //Used only for testing Expiration Flag Test case
    public void plainInsert(Trade trade){
        tradeStore.put(trade.getId(),trade);
    }

}
