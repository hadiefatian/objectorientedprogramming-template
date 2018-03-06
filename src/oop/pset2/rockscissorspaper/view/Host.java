package oop.pset2.rockscissorspaper.view;

import oop.pset2.rockscissorspaper.model.Result;

public class Host {

    public void sayHi() {
        System.out.println("\nHost: Welcome to the Rock, Scissors, Paper tournament! ");
    }

    public void show(Result result) {
        System.out.println("\n---------------------------------\n\nThe result of this round is.... !\n");
        System.out.println("Player 1 move: " + result.getPlayer1move().getType());
        System.out.println("Player 2 move: " + result.getPlayer2move().getType());
        System.out.println(result.getWinner());


    }

    public void sayGoodbye() {
        System.out.println("Goodbye...!");
    }
}
