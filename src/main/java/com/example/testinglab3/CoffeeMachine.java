package com.example.testinglab3;


public class CoffeeMachine {
    static boolean isOn = false;
    static boolean isBusy = false;
    static int m;
    static int totalNumOfCoffeesMade = 0;

    public static void turnON_or_OFF(){
        isOn = !isOn;
    }
    public static void startCoffee(){
        isBusy = true;
        System.out.println("Started Making Coffee");
        totalNumOfCoffeesMade++;
    }
    public static void stopCoffee() {
        isBusy = false;
        System.out.println("Finished Making Coffee");
        m--;
    }

    public static void coffeeMachine(int input){
        if (isOn){
            m = input;
            while (m > 0) {
                startCoffee();
                stopCoffee();
            }
            turnON_or_OFF();
        }
    }
    public static int driver_sets_m_to_value(int value){
        m = value;
        stopCoffee();
        return m;
    }
    public static int driver_sets_totalCoffee_to_value(int value){
        totalNumOfCoffeesMade = value;
        startCoffee();
        return totalNumOfCoffeesMade;
    }
    public static void stub_setsToOn(){
        isOn = true;
    }
}