package ch.bbw;

import ch.bbw.zork.Item;
import ch.bbw.zork.Room;
import ch.bbw.zork.riddles.Calculate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;


class Roomtest {
    Item key, note;
    Calculate calculate;
    Room room;

    @BeforeEach
    protected void setUp() {
        key = new Item(Item.Types.KEY, 1, "Key", "A key for a door");
        note = new Item(Item.Types.PAPER, 2, "Note", "Nötli");
        calculate = new Calculate(100);
        room = new Room("A Test Room", null, calculate, true, key);

    }

    @Test
    void lockTest() {
        assumeTrue(room.getKey() == key);
        assumeTrue(room.isLocked());
        ArrayList<Item> backpack = new ArrayList<Item>();
        backpack.add(key);
        assumeTrue(room.unlock(backpack));
    }

    @Test
    void itemTest() {
        assertNull(room.getItem());
        room.setItem(note);
        assertNotNull(room.getItem());
    }

    @Test
    void descriptionTest() {
        assertNotNull(room.getDescription());
    }


}
