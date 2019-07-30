package games;

import java.io.IOException;

public class Choice {
    public static void main(String [] args) throws IOException {
        System.out.println("Select a game:\n" +"1 - \"one-armed bandit\", 2 - \"drunkard\"");
        switch (System.in.read()) {
            case '1': Slot.main(); break;
            case '2': Drunkard.main(); break;
            default: System.out.println("There are no games with this number!");
        }

    }
}
