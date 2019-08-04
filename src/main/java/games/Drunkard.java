package games;
import org.apache.commons.math3.util.MathArrays;

public class Drunkard {

    private static final int PARS_TOTAL_COUNT = Par.values().length; //9
    private static final int CARDS_TOTAL_COUNT = PARS_TOTAL_COUNT * Suit.values().length; //36
    private static int[][] playersCards = new int[2][CARDS_TOTAL_COUNT];
    private static int[] playerCardTails = new int[2];
    private static int[] playerCardHeads = new int[2];
    private static int playersCardHead=18;
    private static int playersCardTail=0;
    private static int playersCardTail2=0;
    private static int playersCardHead2=18;
    private static int count1=18;
    private static int count2=18;

    private static String [] map=new String[CARDS_TOTAL_COUNT];
    private static int[] imap= new int[CARDS_TOTAL_COUNT];

    public static void fillMap(){
        int i=0;
        while(i<36){
          //  map[i]=toString(i);
          //  System.out.println("Остаток от деления  "+(i%9)+" i "+i);
            imap[i]=i;

                    i++;
        }

        MathArrays.shuffle(imap);
        i=0;
        while(i<36){
            playersCards[0][i]=imap[i];
            playersCards[1][i]=imap[35-i];

            if (i>17){
                playersCards[0][i]=-1;
                playersCards[1][i]=-1;
            }
            i++;
        }

    }



       

    private static String toString(int cardNumber) {
        return getPar(cardNumber) + " " + getSuit(cardNumber);
    }
    private static int incrementIndex(int i) {
        return (i + 1) % CARDS_TOTAL_COUNT;
    }





    private static boolean playerCardsIsEmpty(int playerIndex) {
        int tail = playerCardTails[playerIndex];
        int head = playerCardHeads[playerIndex];
        return tail == head;
    }

    private static Suit getSuit(int cardNumber) {
        return Suit.values()[cardNumber / PARS_TOTAL_COUNT];
    }

    enum Suit {
        SPADES, // пики
        HEARTS, // червы
        CLUBS, // трефы
        DIAMONDS // бубны
    }
///Размерность
    enum Par {
        SIX6,
        SEVEN7,
        EIGHT8,
        NINE9,
        TEN10,
        JACK, // Валет
        QUEEN, // Дама
        KING, // Король
        ACE // Туз
    }

    private static Par getPar(int cardNumber) {
        if(cardNumber==-1){
            return null;
        }
        return Par.values()[cardNumber % PARS_TOTAL_COUNT];
    }
}


