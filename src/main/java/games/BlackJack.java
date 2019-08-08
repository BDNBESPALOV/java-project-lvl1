package games;

import java.io.IOException;

public class BlackJack {
    private static int[] cards; // Основная колода
    private static int cursor; // Счётчик карт основной колоды

    private static int[][] playersCards; // карты игроков. Первый индекс - номер игрока
    private static int[] playersCursors; // курсоры карт игроков. Индекс - номер игрока

    private static int[] playersMoney = {100, 100};

    private static final int MAX_VALUE = 21;
    private static final int MAX_CARDS_COUNT = 8;

    public static void main(String ... __) throws IOException {

        while(playersMoney[0]>0 && playersMoney[1]>0){
            initRound();
            System.out.println("Вам выпала карта "+CardUtils.toString(addCard2Player(0)));
            System.out.println("Вам выпала карта "+CardUtils.toString(addCard2Player(0)));
           System.out.println("Сумма ваших очков -  "+getFinalSum(0));
           boolean et=true;
           if(getFinalSum(0)>0){
               boolean et1=true;
              do{
                  et1 =Choice.confirm("Берём ещё? ");
                  if (et1){
                      System.out.println("Вам выпала карта "+CardUtils.toString(addCard2Player(0)));
                      //   System.out.println("Сумма ваших очков -  "+getFinalSum(0));
                      if(getFinalSum(0)==21){
                          playersMoney[0]+=10;
                          playersMoney[1]-=10;
                          System.out.println("Сумма ваших очков - "+getFinalSum(0)+"Сумма очков компьютера -  "+getFinalSum(1));
                          System.out.println("Вы выйграли раунд! Получаете 10$ ");

                      }else if (getFinalSum(0)<1) {
                          //  System.err.println("Вы проиграли раунд! Теряете 10$ ");


                      }
                  }

              }

               while (getFinalSum(0)>0 && et1);


           }



            //ход ПК
            System.out.println("Компьютеру выпала карта "+CardUtils.toString(addCard2Player(1)));
            System.out.println("Компьютеру выпала карта "+CardUtils.toString(addCard2Player(1)));
            while (et){
                if(getFinalSum(1)==21){
                    playersMoney[0]-=10;
                    playersMoney[1]+=10;
                    System.out.println("Сумма ваших очков - "+getFinalSum(0)+"Сумма очков компьютера -  "+getFinalSum(1));
                    System.out.println("Вы проиграли раунд! Теряете 10$ ");
                    et=false;
                }else if (getFinalSum(1)<1) {

                    et=false;
                }
                else if (getFinalSum(1)<=16 && getFinalSum(1)> 0 ) {
                    System.out.println("Компьютер решил взять ещё и ему выпала карта "+CardUtils.toString(addCard2Player(1)));
                }else {
                    break;
                }

            }


            if(getFinalSum(1)> getFinalSum(0)){
                playersMoney[1]+=10;
                playersMoney[0]-=10;

                System.out.println("Вы проиграли раунд! Теряете 10$ ");
            } else if (getFinalSum(1)< getFinalSum(0)) {
                playersMoney[1]-=10;
                playersMoney[0]+=10;
                System.out.println("Вы выйграли раунд! Получаете 10$ ");
            }else {
                System.out.println("Ничья, все остаются при своих $ ");
            }



            //ход ПК






        }
        if (playersMoney[0] > 0)
            System.out.println("Вы выиграли! Поздравляем!");
        else
            System.err.println("Вы проиграли. Соболезнуем...");


    }

   /*  Метод извлекающий следующую карту из колоды и
     помещающий её в стопку карт указанного игрока */
    private static int addCard2Player(int player) {
        int temp=cards[cursor];
        playersCards[player][playersCursors[player]++]=temp;
        cursor++;
        return temp;
    }
   /* метод который будет суммировать очки игрока. */
    static int sum(int player) {
        int temp=0;
        for (int i=0;i<playersCards[player].length;i++){
            if (playersCards[player][i]>0){
                temp+= value(playersCards[player][i]);
            }

        }
        return temp;
    }

    /* метод, который вызывает  sum и возвращает
    кол-во очков только если оно не превышает максимального значения - 21,
    в ином случае возвращал бы 0: */
    static int getFinalSum(int player) {
        int temp=0;
        if (sum(player)<MAX_VALUE){
            return sum(player);
        }
        return temp;
    }

    private static void initRound() {
        System.out.println("\nУ Вас " + playersMoney[0] + "$, у компьютера - " + playersMoney[1] + "$. Начинаем новый раунд!");
        cards = CardUtils.getShaffledCards();
        playersCards = new int[2][MAX_CARDS_COUNT];
        playersCursors = new int[]{0,0};
        cursor = 0;
    }
    private static int value(int card) {
        switch (CardUtils.getPar(card)) {
            case JACK: return 2;
            case QUEEN: return 3;
            case KING: return 4;
            case SIX: return 6;
            case SEVEN: return 7;
            case EIGHT: return 8;
            case NINE: return 9;
            case TEN: return 10;
            case ACE:
            default: return 11;
        }
    }

}
