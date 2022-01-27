package ch.bbw;

import ch.bbw.zork.CommandWords;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CommandWordstest {
    CommandWords cw;

    @BeforeEach
    protected void setUp(){
      cw = new CommandWords();

    }

    @Test
    void commandWordsTest(){
        assertTrue(cw.isCommand("go"));
        assertTrue(cw.isCommand("quit"));
        assertTrue(cw.isCommand("help"));
        assertTrue(cw.isCommand("items"));
        assertTrue(cw.isCommand("search"));
        assertTrue(cw.isCommand("map"));
        assertTrue(cw.isCommand("back"));
        assertFalse(cw.isCommand("test"));
    }
}
