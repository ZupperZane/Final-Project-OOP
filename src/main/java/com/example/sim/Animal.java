package com.example.sim;

public class Animal {

    private int hunger;
    private int happiness;

    public int feed(){
        int Ch=hunger;
        hunger = Ch+20;
        if(hunger>100){
        hunger =100;
        }
        return hunger;
    }

    public int getHunger(){
        return hunger;
    }
    public void setHunger(int i){
        this.hunger= i;
    }

    public int getHappiness(){
        return happiness;
    }
    public void setHappiness(int i){
        this.happiness=i;
    }
    public int petPlay(){
        int Ch=happiness;
        happiness= Ch+20;
        if(happiness>100){
            happiness=100;
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
