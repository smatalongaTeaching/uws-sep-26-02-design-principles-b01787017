package com.uws.excercise3;

import java.util.ArrayList;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {

        Bird simpleBird = new Bird("Generic Bird");
        Flyable sparrow = new Sparrow("Jack");
        Swimmable penguin = new Penguin("Pingu");

        ArrayList<Bird> birds = new ArrayList<>();
        birds.add(simpleBird);
        birds.add((Bird) sparrow);
        birds.add((Bird) penguin);

        ArrayList<Flyable> flyingThings = new ArrayList<>();
        flyingThings.add(sparrow);

        MainClass.letBirdsFly(flyingThings);

        penguin.swim();
    }

    public static void letBirdsFly(List<Flyable> birds) {
        for (Flyable bird : birds) {
            bird.fly();
        }
    }
}
