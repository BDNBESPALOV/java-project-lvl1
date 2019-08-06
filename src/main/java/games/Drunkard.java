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
    private static int T2=0;
    private static int playersCardHead2=18;
    private static int count1=18;
    private static int count2=18;
    private static int draw=0;
    private static int Idraw=0;
    private static int [] ArrDraw=new int [CARDS_TOTAL_COUNT];

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
            //заполнение ArrDraw для ничей, значениями которые не могут быть в imap
            ArrDraw[i]=-2;
            i++;
        }

    }


    public static void main(String ... __) throws  Exception{
        System.out.println(toString(35));
        System.out.println("Масть 36-й карты -  " + getSuit(35));
        System.out.println("Размерность 36-й карты -  " + getPar(35));
        fillMap();
//    boolean on=true;
//    int i=0;
//    while(i<100){
//        System.out.println("incrementIndex " + incrementIndex(i)+" i "+i);
//        i++;
//    }


        for(int q=0;q<36;q++){
            //  System.out.println(q+") "+toString(playersCards[0][q])+" number
            //  "+playersCards[0][q]+" | "+toString(playersCards[1][q])+" number "+playersCards[1][q]);
        }

        boolean on=true;
        int i=0;

        while(on){

            System.out.println("Итерация №"+i+" Игрок №1 карта: " + toString(playersCards[0][playersCardTail])
                    +"; игрок №2 карта: "+toString(playersCards[1][playersCardTail])+" .");


            //"Выиграл игрок 1! ""Выиграл игрок 1! ""Выиграл игрок 1! ""Выиграл игрок 1! ""Выиграл игрок 1! ""Выиграл игрок 1! ""Выиграл игрок 1! "
            if(( playersCards[0][playersCardTail] % PARS_TOTAL_COUNT >playersCards[1][playersCardTail] % PARS_TOTAL_COUNT)){
                System.out.println("Выиграл игрок 1! ");
                if ( M1()!=-7) {
                    if (playersCards[0][playersCardTail] != -1) {
                        playersCards[0][M1()] = playersCards[0][playersCardTail];
                        playersCards[0][playersCardTail] = -1;

                    }
                    if (playersCards[1][playersCardTail] != -1) {
                        playersCards[0][M1()] = playersCards[1][playersCardTail];
                        playersCards[1][playersCardTail] = -1;
                        count1++;
                        count2--;
                    }
                }
                System.out.println("У игрока №1 "+count1+" карт, у игрока №2 "+count2+" карт");
                if( count1==CARDS_TOTAL_COUNT){
                    System.out.println("Выиграл первый  игрок! Количество произведённых итераций: "+i);
                    on=false;
                    break;
                }

    } else if(( playersCards[0][playersCardTail] % PARS_TOTAL_COUNT == playersCards[1][playersCardTail] % PARS_TOTAL_COUNT)){
                System.out.println(" Нечя ");
                System.out.println("У игрока №1 "+count1+" карт, у игрока №2 "+count2+" карт");

            }
            else if (( playersCards[0][playersCardTail] % PARS_TOTAL_COUNT < playersCards[1][playersCardTail] % PARS_TOTAL_COUNT)){
                //Выиграл игрок 2! Выиграл игрок 2! Выиграл игрок 2!Выиграл игрок 2!Выиграл игрок 2!Выиграл игрок 2!Выиграл игрок 2!
                System.out.println("Выиграл игрок 2! ");
                if ( M2()!=-7){
                    if (playersCards[0][playersCardTail]!=-1  ){
                        playersCards[1][M2()]=playersCards[0][playersCardTail];
                        playersCards[0][playersCardTail]=-1;
                        count1--;
                        count2++;
                    }
                    if (playersCards[1][playersCardTail]!=-1){
                        playersCards[1][M2()]=playersCards[1][playersCardTail];
                        playersCards[1][playersCardTail]=-1;
                    }
                }

                System.out.println("У игрока №1 "+count1+" карт, у игрока №2 "+count2+" карт");
                if( count2==CARDS_TOTAL_COUNT ){
                    System.out.println("Выиграл второй игрок! Количество произведённых итераций: "+i);
                    on=false;
                    break;
                }
            }
            playersCardTail=incrementIndex(i);
            i++;

            if (i>10000 ){
                if (count1>count2){
                    System.out.println("Выиграл первый игрок! Количество произведённых итераций: "+i);
                    on=false;
                    break;
                }else {
                    System.out.println("Выиграл второй игрок! Количество произведённых итераций: "+i);
                    on=false;
                    break;
                }

            }
        }


        for(int q=0;q<36;q++){
            System.out.println(q+") "+toString(playersCards[0][q])+" | "+toString(playersCards[1][q]));
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



    public static int M1(){
        for (int f1=0;f1<CARDS_TOTAL_COUNT;f1++){
            if (playersCards[0][f1]==-1){

                return f1;
            }
        }
        return -7;

    }
    public static int M2(){
        for (int f1=0;f1<CARDS_TOTAL_COUNT;f1++){
            if (playersCards[1][f1]==-1){

                return f1;
            }
        }
        return -7;

    }

}