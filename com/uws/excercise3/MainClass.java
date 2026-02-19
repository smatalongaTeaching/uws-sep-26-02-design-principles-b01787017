package com.uws.excercise3;

import java.util.ArrayList;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        // Create a Sparrow and a Penguin
        Bird simpleBird = new Bird("Generic Bird");
        Bird sparrow = new Sparrow("Jack");
        Bird penguin = new Penguin("Pingu");

        ArrayList<Bird> birds = new ArrayList<>();
        birds.add(simpleBird);
        birds.add(sparrow);
        birds.add(penguin);

        ArrayList<Flyable> flyingThings = new ArrayList<>();
        flyingThings.add((Flyable) sparrow);

        MainClass.letBirdsFly(flyingThings);
        ((Penguin) penguin).swim();
    }

    public static void letBirdsFly(List<Flyable> birds) {
        for (Flyable bird : birds) {
            bird.fly();
        }
    }


}
