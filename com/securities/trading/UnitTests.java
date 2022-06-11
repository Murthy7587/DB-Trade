package com.securities.trading;

import com.securities.trading.exception.HigerVersionPresentException;
import com.securities.trading.model.Trade;
import com.securities.trading.services.TradingRun;
import com.securities.trading.services.UpdateExpiration;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UnitTests {

    TradingRun run = new TradingRun();
    UpdateExpiration updateExpiration = new UpdateExpiration();

    @Test
    public void testTradeEntries(){
        Trade trade = new Trade();
        trade.setId("T1");
        trade.setExpired(false);
        trade.setBookId("B1");
        trade.setCounterPartyId("CP-1");
        trade.setCreatedDate(new Date());
        trade.setMaturityDate(new Date("07/11/2022"));
        trade.setVersion(1);
        //run.runTrade(trade);
        assertEquals(true,run.runTrade(trade));

        Trade trade1 = new Trade();
        trade1.setId("T2");
        trade1.setExpired(false);
        trade1.setBookId("B1");
        trade1.setCounterPartyId("CP-1");
        trade1.setCreatedDate(new Date());
        trade1.setMaturityDate(new Date("07/11/2022"));
        trade1.setVersion(1);
        assertEquals(true,run.runTrade(trade1));

        Trade trade2 = new Trade();
        trade2.setId("T3");
        trade2.setExpired(false);
        trade2.setBookId("B1");
        trade2.setCounterPartyId("CP-1");
        trade2.setCreatedDate(new Date());
        trade2.setMaturityDate(new Date("08/11/2022"));
        trade2.setVersion(2);
        assertEquals(true,run.runTrade(trade2));



    }

    @Test
    public void testVersionEntries() {
        Trade trade1 = new Trade();
        trade1.setId("T3");
        trade1.setExpired(false);
        trade1.setBookId("B1");
        trade1.setCounterPartyId("CP-1");
        trade1.setCreatedDate(new Date());
        trade1.setMaturityDate(new Date("06/11/2022"));
        trade1.setVersion(1);
        //String msg="Higer Version Present for trade IDT3";
        assertEquals(false,run.runTrade(trade1));
    }

    @Test
    public void testMaturityDate() {
        Trade trade1 = new Trade();
        trade1.setId("T4");
        trade1.setExpired(false);
        trade1.setBookId("B1");
        trade1.setCounterPartyId("CP-1");
        trade1.setCreatedDate(new Date());
        trade1.setMaturityDate(new Date("06/11/2020"));
        trade1.setVersion(1);

        assertEquals(false,run.runTrade(trade1));
    }

    @Test
    public void testExpirationFlag() {
        Trade trade1 = new Trade();
        trade1.setId("T5");
        trade1.setExpired(false);
        trade1.setBookId("B1");
        trade1.setCounterPartyId("CP-1");
        trade1.setCreatedDate(new Date());
        trade1.setMaturityDate(new Date("06/11/2020"));
        trade1.setVersion(1);
        run.plainInsert(trade1);

        Trade trade2 = new Trade();
        trade2.setId("T6");
        trade2.setExpired(false);
        trade2.setBookId("B1");
        trade2.setCounterPartyId("CP-1");
        trade2.setCreatedDate(new Date());
        trade2.setMaturityDate(new Date("07/11/2022"));
        trade2.setVersion(1);
        run.plainInsert(trade2);

        Trade trade3 = new Trade();
        trade3.setId("T6");
        trade3.setExpired(false);
        trade3.setBookId("B1");
        trade3.setCounterPartyId("CP-1");
        trade3.setCreatedDate(new Date());
        trade3.setMaturityDate(new Date("07/11/2021"));
        trade3.setVersion(1);
        run.plainInsert(trade3);


        List<Trade> actualList = updateExpiration.updateExpirationDate();

        assertThat(actualList.size(),is(2));
    }


}
