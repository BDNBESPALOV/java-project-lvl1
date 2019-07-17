package main.java.games;

public class Slot {
    //счет
    int my_money=100;
    //ставка
    private final int RATE=10;

    int size=7;
    int firstCounter=0;
    int secondCounter=0;
    int thirdCounter=0;

    Slot(){
        System.out.println("У Вас "+my_money+"$, ставка - 10$");
        for(int i=0;i<my_money;i++){
            firstCounter = (firstCounter + (int) Math.round(Math.random() * 100)) % size;
            secondCounter = (secondCounter + (int) Math.round(Math.random() * 100)) % size;
            thirdCounter = (thirdCounter + (int) Math.round(Math.random() * 100)) % size;
            System.out.println("Крутим барабаны! Розыгрыш принёс следующие результаты:");
            System.out.println("первый барабан - "+firstCounter+", второй - "+secondCounter+", третий - "+thirdCounter);
            if(thirdCounter == secondCounter && secondCounter == firstCounter){
                my_money+=1000;
                System.out.println("Выйгрыш 1000$, ваш капитал теперь составляет: "+my_money+"$");
                return;
            }else {
                my_money-=RATE;
                System.out.println("Проигрыш 10$, ваш капитал теперь составляет: "+my_money+"$");
            }
        }
    }

    public static void main(String... __) {
        Slot slot=new Slot();
    }
}
