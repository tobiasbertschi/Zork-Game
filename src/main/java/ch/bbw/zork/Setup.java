package ch.bbw.zork;

import ch.bbw.zork.riddles.Calculate;
import ch.bbw.zork.riddles.Guess;
import ch.bbw.zork.riddles.Higherlower;

public class Setup {

    public Higherlower higherlower1, higherlower2, higherlower3, higherlower4;
    public Guess guess;
    public Calculate calculate1, calculate2, calculate3;
    public Item key, new_key, old_key, tipp1, tipp2, tipp3, sword, old_sword;


    public Setup() {

        guess = new Guess("what is our school called?", "bbw");

        higherlower1 = new Higherlower(100);
        higherlower2 = new Higherlower(10);
        higherlower3 = new Higherlower(1000);
        higherlower4 = new Higherlower(400);

        calculate1 = new Calculate(100);
        calculate2 = new Calculate(200);
        calculate3 = new Calculate(500);


        key = new Item(Item.Types.KEY, 1, "key", "This is a Key.");
        new_key = new Item(Item.Types.KEY, 2, "new key", "This is a Key");
        old_key = new Item(Item.Types.KEY, 3, "old key", "This is a Key");
        tipp1 = new Item(Item.Types.PAPER, 4, "tipp", "If you want to go to the bath you need the sword.");
        tipp2 = new Item(Item.Types.PAPER, 5, "tipp", "The end of the game is in study.");
        tipp3 = new Item(Item.Types.PAPER, 6, "tipp", "Nice work you can do it.");
        sword = new Item(Item.Types.WEAPON, 7, "sword", "This weapon is used to enter a room.");
        old_sword = new Item(Item.Types.WEAPON, 8, "old-sword", "Well done you found de valuable Sword from the medieval.");
    }


}
