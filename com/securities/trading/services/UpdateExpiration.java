package com.securities.trading.services;

import com.securities.trading.model.Trade;
import com.securities.trading.model.TradeStore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
//Class for updating all the trades whose dates fall below the maturity dates to expired.
public class UpdateExpiration {

    Map<String, Trade> tradeStore = null;
    public UpdateExpiration(){
        //TradeStore store = new TradeStore();
        tradeStore = TradeStore.tradeStore;
    }

    public List<Trade> updateExpirationDate(){
    List<Trade> listOfupdates = new ArrayList<>();
        tradeStore.forEach((tradeId,trade)->{
          if(trade.getMaturityDate().before(new Date())){
              trade.setExpired(true);
              listOfupdates.add(trade);
          }
        });
        return listOfupdates;
    }

}
