package com.securities.trading.services;

import com.securities.trading.exception.HigerVersionPresentException;
import com.securities.trading.model.Trade;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//Validation class where all the validations before a trade is inserted into a store.
public class ValidateTrading {

    //Storing all the trades in HashMap keeping TradeId as Key and Trade object as Value.
    // In real world all these values will be present in time series DB

    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    //Method to validate version.
    public boolean validateVersion(Trade trade,Map<String,Trade> tradeStore){

        String tradeId = trade.getId();


        if(tradeStore.containsKey(tradeId)) {
            long versionInStore = tradeStore.get(tradeId).getVersion();
            if (trade.getVersion() < versionInStore) {
                try {
                    throw new HigerVersionPresentException("Higer Version Present for trade ID::" + tradeId);
                } catch (HigerVersionPresentException e) {
                    return false;
                }
            }
        }
        return true;
    }
    //Method to validate Matuirty Date vs Current Date.
    public boolean validateMaturityDate(Trade trade){

        Date maturityDate = trade.getMaturityDate();
        Date localDate = new Date();

         if(maturityDate.before(localDate)){
             return false;
         }
         return true;
    }

}
