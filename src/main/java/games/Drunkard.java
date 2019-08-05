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
          //  System.out.println(q+") "+toString(playersCards[0][q])+" number "+playersCards[0][q]+" | "+toString(playersCards[1][q])+" number "+playersCards[1][q]);
        }

        boolean on=true;
        int i=0;
        while(i<90){



//            if(playersCardHead==playersCardTail || playersCardHead2==playersCardTail){
//                System.out.println("EROR_404__"+i);
//                on=false;
//                break;
//            }

//            if(playersCardTail==CARDS_TOTAL_COUNT){
//                playersCardTail=0;
//            }



            System.out.println("Итерация №"+i+" Игрок №1 карта: " + toString(playersCards[0][playersCardTail])
                    +"; игрок №2 карта: "+toString(playersCards[1][playersCardTail])+" ."+" playersCardTail  "
                    +"count1= "+count1+" count2= "+count2+" |"
                    +playersCardTail+"  playersCardHead  "+playersCardHead+"  playersCardHead2  "+
                    playersCardHead2+" playersCards[1][playersCardTail] "+playersCards[1][playersCardTail]+
                    " playersCards[0][playersCardTail] "+playersCards[0][playersCardTail]);


            //"Выиграл игрок 1! ""Выиграл игрок 1! ""Выиграл игрок 1! ""Выиграл игрок 1! ""Выиграл игрок 1! ""Выиграл игрок 1! ""Выиграл игрок 1! "
            if(( playersCards[0][playersCardTail] % PARS_TOTAL_COUNT >playersCards[1][playersCardTail] % PARS_TOTAL_COUNT)){
                System.out.println("Выиграл игрок 1! ");


                System.out.println("У игрока №1 "+count1+" карт, у игрока №2 "+count2+" карт");


                if(playersCardHead==CARDS_TOTAL_COUNT){
                    System.out.println(CARDS_TOTAL_COUNT+" CARDS_TOTAL_COUNT playersCardHead  "+playersCardHead);
///если playersCardTail наткнулся на null в конце
                    if(CheckPlayerCards1() && CheckPlayerCards2()){
                        //   playersCardHead=0;
                    }else if (CheckPlayerCards1() || CheckPlayerCards2()){
                        if(!CheckPlayerCards2() && playersCards[0][0]==-1){

                            playersCards[0][0]=playersCards[1][playersCardTail];
                            playersCards[1][playersCardTail]=-1;
                            playersCardHead=0;
                            count1++;
                            count2--;

                        }
                        if(!CheckPlayerCards1() && playersCards[0][0]==-1){
                            playersCards[0][0]=playersCards[0][playersCardTail];
                            playersCards[0][playersCardTail]=-1;
                            playersCardHead=0;
                            count1++;
                            count2--;

                        }
                    } else {
                        if(CheckPlayerCards1() || CheckPlayerCards2()){
                            System.out.println("FAAAAAAAAAAAAAAAAAAAA");
                            throw new Exception();

                        }
                        playersCards[0][0]=playersCards[1][playersCardTail];
                        playersCards[0][playersCardTail]=-1;
                        playersCards[0][1]=playersCards[0][playersCardTail];
                        playersCards[1][playersCardTail]=-1;
                        playersCardHead=2;
                        count1++;
                        count2--;

                    }


///если playersCardTail наткнулся на null
                }
                ///если playersCardTail наткнулся на null
                else if(playersCardHead==CARDS_TOTAL_COUNT-1){
                    if(CheckPlayerCards1() && CheckPlayerCards2()){
                        //   playersCardHead=35;
                        System.out.println("<<<<<<<<<<<<<№1 3.3!!!!1!!!");
                    } else if (CheckPlayerCards1() || CheckPlayerCards2()){
                        if(!CheckPlayerCards2() && playersCards[0][playersCardHead]==-1){
                            playersCards[0][playersCardHead]=playersCards[1][playersCardTail];
                            playersCards[1][playersCardTail]=-1;
                            playersCardHead=35;
                            count1++;
                            count2--;

                        }
                        if(!CheckPlayerCards1()  && playersCards[0][playersCardHead]==-1){
                            playersCards[0][playersCardHead]=playersCards[0][playersCardTail];
                            playersCards[0][playersCardTail]=-1;
                            playersCardHead=35;
                            count1++;
                            count2--;

                        }
                    } else {
                        if(CheckPlayerCards1() || CheckPlayerCards2()){
                            System.out.println("FAAAAAAAAAAAAAAAAAAAA");
                            throw new Exception();

                        }
                        playersCards[0][playersCardHead]=playersCards[1][playersCardTail];
                        playersCards[1][playersCardTail]=-1;
                        playersCards[0][0]=playersCards[0][playersCardTail];
                        playersCards[0][playersCardTail]=-1;
                        playersCardHead=1;
                        count1++;
                        count2--;


                    }

                }

                else {
                    if(CheckPlayerCards1() && CheckPlayerCards2()){
                        // playersCardHead++;

                    } else if (CheckPlayerCards1() || CheckPlayerCards2()){
                        if(!CheckPlayerCards2()  && playersCards[0][playersCardHead]==-1){
                            playersCards[0][playersCardHead]=playersCards[1][playersCardTail];
                            playersCards[1][playersCardTail]=-1;
                            playersCardHead++;
                            count1++;
                            count2--;


                        }
                        if(!CheckPlayerCards1() && playersCards[0][playersCardHead]==-1){
                            playersCards[0][playersCardHead]=playersCards[0][playersCardTail];
                            playersCards[0][playersCardTail]=-1;
                            playersCardHead++;
                            count1++;
                            count2--;


                        }
                    } else {
                        if(CheckPlayerCards1() || CheckPlayerCards2()){
                            System.out.println("FAAAAAAAAAAAAAAAAAAAA");
                            throw new Exception();

                        }
                        playersCards[0][playersCardHead]=playersCards[1][playersCardTail];
                        playersCards[1][playersCardTail]=-1;
                        playersCards[0][playersCardHead+1]=playersCards[0][playersCardTail];
                        playersCards[0][playersCardTail]=-1;
                        playersCardHead+=2;
                        count1++;
                        count2--;


                    }

                }
                //  playersCardTail++


                if( count1==CARDS_TOTAL_COUNT){
                    System.out.println("Выиграл первый  игрок! Количество произведённых итераций: "+i);
                    on=false;
                    break;
                }



            } else if(( playersCards[0][playersCardTail] % PARS_TOTAL_COUNT == playersCards[1][playersCardTail] % PARS_TOTAL_COUNT)){
                System.out.println(" Нечя ");
                System.out.println("У игрока №1 "+count1+" карт, у игрока №2 "+count2+" карт");
//                if(count2>count1){
//                    count1++;
//                    count2++;
//                }else {
//                    count1++;
//                    count2++;
//                }
//
//                    if(playersCardHead==CARDS_TOTAL_COUNT-1 || playersCardHead2==CARDS_TOTAL_COUNT-1){
//                        if (playersCardHead==CARDS_TOTAL_COUNT-1){
//                            if(CheckPlayerCards1()){
//                                playersCards[0][0]=playersCards[0][playersCardTail];
//                            }
//                            playersCards[0][playersCardTail]=-1;
//                            //затереть ничьи
//                            playersCardHead=1;
//
//
//                        }else if(playersCardHead2==CARDS_TOTAL_COUNT-1 ) {
//                            if(CheckPlayerCards2()){
//                                playersCards[1][playersCardHead2]=playersCards[1][playersCardTail];
//                            }
//                            playersCards[1][playersCardTail]=-1;
//                            playersCardHead2=1;
//                        }
//
//                    }else {
//
//                        if(CheckPlayerCards2()){
//                            playersCards[1][playersCardHead2]=playersCards[1][playersCardTail];
//                        }
//                        if(CheckPlayerCards1()){
//                            playersCards[0][playersCardHead]=playersCards[0][playersCardTail];
//                        }
//                        playersCards[0][playersCardTail]=-1;
//                        playersCards[1][playersCardTail]=-1;
//                        playersCardHead+=1;
//                        playersCardHead2+=1;
//
//                    }

                // playersCardHead++;
                //   playersCardHead2++;
                //  playersCardTail++
            }
            else if (( playersCards[0][playersCardTail] % PARS_TOTAL_COUNT < playersCards[1][playersCardTail] % PARS_TOTAL_COUNT)){
                //Выиграл игрок 2! Выиграл игрок 2! Выиграл игрок 2!Выиграл игрок 2!Выиграл игрок 2!Выиграл игрок 2!Выиграл игрок 2!
                System.out.println("Выиграл игрок 2! ");

                System.out.println("У игрока №1 "+count1+" карт, у игрока №2 "+count2+" карт");

                if(playersCardHead2==CARDS_TOTAL_COUNT ){


                    if(CheckPlayerCards1() && CheckPlayerCards2()){
                        // playersCardHead++;
                    } else if (CheckPlayerCards1() || CheckPlayerCards2()){
                        if(!CheckPlayerCards2() && playersCards[1][0]==-1){
                            playersCards[1][0]=playersCards[1][playersCardTail];
                            playersCards[1][playersCardTail]=-1;
                            playersCardHead2=0;
                            count1--;
                            count2++;
                        }
                        if(!CheckPlayerCards1() && playersCards[1][0]==-1){
                            playersCards[1][0]=playersCards[0][playersCardTail];
                            playersCards[0][playersCardTail]=-1;
                            playersCardHead2=0;
                            count1--;
                            count2++;
                        }
                    } else {
                        if(CheckPlayerCards1() || CheckPlayerCards2()){
                            System.out.println("FAAAAAAAAAAAAAAAAAAAA");
                            throw new Exception();

                        }
                        playersCards[1][0]=playersCards[1][playersCardTail];
                        playersCards[1][1]=playersCards[0][playersCardTail];
                        playersCards[0][playersCardTail]=-1;
                        playersCards[1][playersCardTail]=-1;
                        playersCardHead2=1;
                        count1--;
                        count2++;

                    }

                } else if(playersCardHead2==CARDS_TOTAL_COUNT-1){
                    if(CheckPlayerCards1() && CheckPlayerCards2()){
                        // playersCardHead++;
                    } else if (CheckPlayerCards1() || CheckPlayerCards2()){
                        if(!CheckPlayerCards2() && playersCards[1][playersCardHead2]==-1){
                            playersCards[1][playersCardHead2]=playersCards[1][playersCardTail];
                            playersCards[1][playersCardTail]=-1;
                            playersCardHead2=35;
                            count1--;
                            count2++;
                        }
                        if(!CheckPlayerCards1() && playersCards[1][playersCardHead2]==-1) {
                            playersCards[1][playersCardHead2]=playersCards[0][playersCardTail];
                            playersCards[0][playersCardTail]=-1;
                            playersCardHead2=35;
                            count1--;
                            count2++;
                        }
                    } else {

                        if(CheckPlayerCards1() && CheckPlayerCards2()){
                            System.out.println("FAAAAAAAAAAAAAAAAAAAA");
                            on=false;
                            break;
                        }
                        playersCards[1][playersCardHead2]=playersCards[1][playersCardTail];
                        playersCards[1][35]=playersCards[0][playersCardTail];
                        playersCards[0][playersCardTail]=-1;
                        playersCards[1][playersCardTail]=-1;
                        playersCardHead2=0;
                        count1--;
                        count2++;
                    }
                }

                else {

                    if(CheckPlayerCards1() && CheckPlayerCards2()){
                        // playersCardHead++;
                    } else if (CheckPlayerCards1() || CheckPlayerCards2()){
                        if(!CheckPlayerCards2() && playersCards[1][playersCardHead2]==-1){
                            playersCards[1][playersCardHead2]=playersCards[1][playersCardTail];
                            playersCards[1][playersCardTail]=-1;
                            playersCardHead2++;
                            count1--;
                            count2++;
                        }
                        if(!CheckPlayerCards1() && playersCards[1][playersCardHead2]==-1){
                            playersCards[1][playersCardHead2]=playersCards[0][playersCardTail];
                            playersCards[0][playersCardTail]=-1;
                            playersCardHead2++;
                            count1--;
                            count2++;
                        }
                    } else {
                        if(CheckPlayerCards1() || CheckPlayerCards2()){
                            System.out.println("FAAAAAAAAAAAAAAAAAAAA");
                            throw new Exception();

                        }
                        playersCards[1][playersCardHead2]=playersCards[1][playersCardTail];
                        playersCards[1][playersCardHead2+1]=playersCards[0][playersCardTail];
                        playersCards[0][playersCardTail]=-1;
                        playersCards[1][playersCardTail]=-1;
                        playersCardHead2+=2;
                        count1--;
                        count2++;

                    }
                }

                if( count2==CARDS_TOTAL_COUNT){
                    System.out.println("Выиграл второй игрок! Количество произведённых итераций: "+i);
                    on=false;
                    break;
                }
            }
            playersCardTail=incrementIndex(i);
            i++;


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

    public static boolean CheckPlayerCards1() {
        return (playersCards[0][playersCardTail]==-1);
    }
    public static boolean CheckPlayerCards2() {
        return (playersCards[1][playersCardTail]==-1);
    }
}


