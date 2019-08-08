package games;
import org.apache.commons.math3.util.MathArrays;
import org.slf4j.Logger;

import static games.CardUtils.*;

public class Drunkard {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(Drunkard.class);
    private static int[][] playersCards = new int[2][CARDS_TOTAL_COUNT];
    private static int[] playerCardTails = new int[2];
    private static int[] playerCardHeads = new int[2];
    private static int playersCardHead=18;
    private static int playersCardTail=0;
    private static int count1=18;
    private static int count2=18;
    private static int[] imap= new int[CARDS_TOTAL_COUNT];

    public static void fillMap(){
        int i=0;
        while(i<36){
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
//        log.info(CardUtils.toString(35));
//        log.info("Масть 36-й карты -  " + getSuit(35));
//        log.info("Размерность 36-й карты -  " + getPar(35));
        fillMap();





        boolean on=true;
        int i=0;

        while(on){

            log.info("Итерация №"+i+" Игрок №1 карта: " + CardUtils.toString(playersCards[0][playersCardTail])
                    +"; игрок №2 карта: "+CardUtils.toString(playersCards[1][playersCardTail])+" .");


            //"Выиграл игрок 1! ""Выиграл игрок 1! ""Выиграл игрок 1! ""Выиграл игрок 1! ""Выиграл игрок 1! ""Выиграл игрок 1! ""Выиграл игрок 1! "
            if(( playersCards[0][playersCardTail] % PARS_TOTAL_COUNT >playersCards[1][playersCardTail] % PARS_TOTAL_COUNT)){
                log.info("Выиграл игрок 1! ");
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
                log.info("У игрока №1 "+count1+" карт, у игрока №2 "+count2+" карт");
                if( count1==CARDS_TOTAL_COUNT){
                    log.info("Выиграл первый  игрок! Количество произведённых итераций: "+i);
                    on=false;
                    break;
                }

    } else if(( playersCards[0][playersCardTail] % PARS_TOTAL_COUNT == playersCards[1][playersCardTail] % PARS_TOTAL_COUNT)){
                log.info(" Нечя ");
                log.info("У игрока №1 "+count1+" карт, у игрока №2 "+count2+" карт");

            }
            else if (( playersCards[0][playersCardTail] % PARS_TOTAL_COUNT < playersCards[1][playersCardTail] % PARS_TOTAL_COUNT)){
                //Выиграл игрок 2! Выиграл игрок 2! Выиграл игрок 2!Выиграл игрок 2!Выиграл игрок 2!Выиграл игрок 2!Выиграл игрок 2!
                log.info("Выиграл игрок 2! ");
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

                log.info("У игрока №1 "+count1+" карт, у игрока №2 "+count2+" карт");
                if( count2==CARDS_TOTAL_COUNT ){
                    log.info("Выиграл второй игрок! Количество произведённых итераций: "+i);
                    on=false;
                    break;
                }
            }
            playersCardTail=incrementIndex(i);
            i++;

            if (i>10000 ){
                if (count1>count2){
                    log.info("Выиграл первый игрок! Количество произведённых итераций: "+i);
                    on=false;
                    break;
                }else {
                    log.info("Выиграл второй игрок! Количество произведённых итераций: "+i);
                    on=false;
                    break;
                }

            }
        }


        for(int q=0;q<36;q++){
            log.info(q+") "+CardUtils.toString(playersCards[0][q])+" | "+CardUtils.toString(playersCards[1][q]));
                 }
           }



    private static int incrementIndex(int i) {
        return (i + 1) % CARDS_TOTAL_COUNT;
    }

    private static boolean playerCardsIsEmpty(int playerIndex) {
        int tail = playerCardTails[playerIndex];
        int head = playerCardHeads[playerIndex];
        return tail == head;
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