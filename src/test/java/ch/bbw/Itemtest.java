package ch.bbw;

import ch.bbw.zork.Game;
import ch.bbw.zork.Item;
import ch.bbw.zork.Room;
import ch.bbw.zork.riddles.Calculate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;



class Itemtest {

    Item key;
    Item paper;
    Item weapon;


    @BeforeEach
    protected void setUp(){
        key = new Item(Item.Types.KEY,1,"Key", "A key");
        paper = new Item(Item.Types.PAPER,2,"Paper", "A paper");
        weapon = new Item(Item.Types.WEAPON,3,"Weapon", "A weapon");


    }

    @Test
    void item(){
        //item Types
        assertTrue(key.getType() == Item.Types.KEY);
        assertTrue(paper.getType() == Item.Types.PAPER);
        assertTrue(weapon.getType() == Item.Types.WEAPON);
        key.setType(Item.Types.PAPER);
        assertTrue(key.getType() == Item.Types.PAPER);
        //item id
        assertEquals(1,key.getId());
        key.setId(4);
        assertEquals(4,key.getId());
        //item note
        assertTrue(key.getNote() == "Key");
        key.setNote("Testkey");
        assertTrue(key.getNote() == "Testkey");
        //item Description
        assertTrue(key.getDescription() == "A key");
        key.setDescription("Test");
        assertTrue(key.getDescription() == "Test");

    }


}
