package com.example.sim;

public class Animal {

    private int hunger;
    private int happiness;

    public int feed(){
        if(hunger<100){
            int Ch=hunger;
            hunger = Ch+20;
        }
        return hunger;
    }

    public int play(){
        if(happiness<100){
            int Ch=happiness;
            happiness= Ch+20;
        }
        return happiness;
    }

    public boolean isAlive(){
        if(happiness>0 && hunger>0){
            return true;
        } else {
            return false;
        }
    }

}
