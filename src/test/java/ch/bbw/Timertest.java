package ch.bbw;


import ch.bbw.zork.Timer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class Timertest {


    Timer timer;

    @BeforeEach
    void setUp(){
        timer = new Timer();
    }

    @Test
    void calculateTimeTest(){
        timer.setStarttime(1000);
        timer.setEndtime(40272000);

        assertEquals("11:11:11", timer.caluculateTime());

    }
    @Test
    void settergetter(){
        timer.setStarttime(1000);
        assertEquals(1000, timer.getStarttime());
        timer.setEndtime(1000);
        assertEquals(1000, timer.getEndtime());
    }
}
