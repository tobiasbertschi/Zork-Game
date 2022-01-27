package ch.bbw;

import ch.bbw.zork.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class Itemtest {

    Item key, paper, weapon;


    @BeforeEach
    protected void setUp(){
        key = new Item(Item.Types.KEY,1,"Key", "A key");
        paper = new Item(Item.Types.PAPER,2,"Paper", "A paper");
        weapon = new Item(Item.Types.WEAPON,3,"Weapon", "A weapon");


    }

    @Test
    void itemTypes(){
        assertTrue(key.getType() == Item.Types.KEY);
        assertTrue(paper.getType() == Item.Types.PAPER);
        assertTrue(weapon.getType() == Item.Types.WEAPON);
        key.setType(Item.Types.PAPER);
        assertTrue(key.getType() == Item.Types.PAPER);
    }
    @Test
    void itemId(){
        assertEquals(1,key.getId());
        key.setId(4);
        assertEquals(4,key.getId());
    }
    @Test
    void itemNote(){
        assertTrue(key.getNote() == "Key");
        key.setNote("Testkey");
        assertTrue(key.getNote() == "Testkey");
    }
    @Test
    void itemDescription(){
        assertTrue(key.getDescription() == "A key");
        key.setDescription("Test");
        assertTrue(key.getDescription() == "Test");
    }



}
