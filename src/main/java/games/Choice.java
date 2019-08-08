package games;

import org.slf4j.Logger;

import java.io.IOException;

public class Choice {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(Choice.class);
    static final String LINE_SEPARATOR = System.lineSeparator();
    public static void main(String [] args) throws Exception {
       // log.info("Select a game:\n" +"1 - \"one-armed bandit\", 2 - \"drunkard\"");
        log.info("Выберите игру:\n1 - \"однорукий бандит\", 2 - \"пьяница\", 3 - \"Очко\"");
        switch (getCharacterFromUser()) {
            case '1': Slot.main(); break;
            case '2': Drunkard.main(); break;
            case '3': BlackJack.main(); break;
            default: log.info("Игры с таким номером нет!");
            //default: log.info("There are no games with this number!");
        }

    }

   private static char getCharacterFromUser() throws IOException {
       byte[] input = new byte[1 + LINE_SEPARATOR.length()];
       if (System.in.read(input) != input.length)
           throw new RuntimeException("Пользователь ввёл недостаточное кол-во символов");
       return (char) input[0];
    }
    static boolean confirm(String message) throws IOException {

        log.info(message + " \"Y\" - Да, {любой другой символ} - нет (N)");
        switch (getCharacterFromUser()) {
            case 'Y':
            case 'y': return true;

            default: return false;

        }

    }
}
