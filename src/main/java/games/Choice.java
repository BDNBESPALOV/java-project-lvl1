package games;

import java.io.IOException;

public class Choice {
    public static void main(String [] args) throws Exception {
       // System.out.println("Select a game:\n" +"1 - \"one-armed bandit\", 2 - \"drunkard\"");
        System.out.println("Выберите игру:\n1 - \"однорукий бандит\", 2 - \"пьяница\"");
        switch (System.in.read()) {
            case '1': Slot.main(); break;
            case '2': Drunkard.main(); break;
            default: System.out.println("Игры с таким номером нет!");
            //default: System.out.println("There are no games with this number!");
        }

    }
}
