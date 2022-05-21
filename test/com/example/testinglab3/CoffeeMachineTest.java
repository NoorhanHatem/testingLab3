package com.example.testinglab3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoffeeMachineTest {
    CoffeeMachine test;
    @BeforeEach
    public void before() {
        test = new CoffeeMachine();
    }
    //Bottom-up testing. Driver to call startCoffee. Test that number of coffees increments.
    @Test
    void startCoffeeTestExpected6() {
        assertEquals(6, test.driver_sets_totalCoffee_to_value(5));
    }
    @Test
    void startCoffeeTestExpected32() {
        assertEquals(32, test.driver_sets_totalCoffee_to_value(31));
    }

    //Bottom-up testing. Driver to call stopCoffee. Test that m decrements.
    @Test
    void stopCoffeeTestExpected47(){
        assertEquals(47, test.driver_sets_m_to_value(48));
    }
    @Test
    void stopCoffeeTestExpected0(){
        assertEquals(0, test.driver_sets_m_to_value(1));
    }

    //Top-down testing. Stub sets machine to on. Test that the machine executes from m = input down to 0
    //Test that the number of coffees made increases
    @Test
    void coffeeMachineTest1() {
        test.stub_setsToOn();
        test.coffeeMachine(9);
        assertEquals(9, test.totalNumOfCoffeesMade);
        assertEquals(0, test.m);
    }
    @Test
    void coffeeMachineTest2() {
        test.totalNumOfCoffeesMade = 30;
        test.stub_setsToOn();
        test.coffeeMachine(24);
        assertEquals(54, test.totalNumOfCoffeesMade);
        assertEquals(0, test.m);
    }

    //Bottom-up testing. Test the function flips the boolean value.
    @Test
    void turnON_or_OFFTestExpectedOn() {
        test.isOn = false;
        test.turnON_or_OFF();
        assertEquals(true, test.isOn);
    }
    @Test
    void turnON_or_OFFTestExpectedOff() {
        test.isOn = true;
        test.turnON_or_OFF();
        assertEquals(false, test.isOn);
    }
    @AfterEach
    public void after(){
        test = null;
    }
}