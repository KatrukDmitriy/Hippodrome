package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    private List<Horse> horses = new ArrayList<>();

    public Hippodrome(List<Horse> horses){
        this.horses = horses;
    }

    static Hippodrome game;

    public List<Horse> getHorses(){
        return this.horses;
    }

    public static void main(String[] args) {
        game = new Hippodrome(new ArrayList<Horse>());
        game.getHorses().add(new Horse("Dasha", 3, 0));
        game.getHorses().add(new Horse("Masha", 3, 0));
        game.getHorses().add(new Horse("Sasha", 3, 0));

        game.run();
        game.printWinner();
    }

    public void run(){

        for (int i = 0; i < 100; i++){
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void move(){
        for (Horse horse: horses){
            horse.move();
        }
    }

    public void print(){
        for (Horse horse: horses){
            horse.print();
        }
        for (int i = 0; i < 10; i++){
            System.out.println();
        }
    }

    public Horse getWinner(){
        Horse winnerHorse = null;

        for (int i = 0; i < horses.size() - 1; i++){
            if (horses.get(i).getDistance() > horses.get(i + 1).getDistance()){
                winnerHorse = horses.get(i);
            }else winnerHorse = horses.get(i + 1);
        }

        return winnerHorse;
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
