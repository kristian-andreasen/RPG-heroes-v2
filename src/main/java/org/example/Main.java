package org.example;


import org.example.heroes.*;

public class Main {
    public static String greet(){
        return "Hello world";
    }
    public static void main(String[] args) {

        Mage mage = new Mage("Jaina Proudmoore");

        System.out.println(mage.displayStats());

        mage.levelUp();

        System.out.println(mage.displayStats());

    }
}