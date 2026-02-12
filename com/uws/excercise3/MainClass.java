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
        
        try {
            MainClass.letBirdsFly(birds); 
            ((Penguin) penguin).swim(); // This should work fine but is unreachable in the current context
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
        
    }

    public static void letBirdsFly(List<Bird> birds) {
        for (Bird bird : birds) {
            bird.fly(); // This will break for Penguin objects
        }
    }

}
