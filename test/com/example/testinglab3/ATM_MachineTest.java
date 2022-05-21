package com.example.testinglab3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ATM_MachineTest {

    ATM_Machine test;

    @BeforeEach
    void before(){
        test = new ATM_Machine(1, 0000, 1000);
    }

    //Top-down testing. Test atm function with stubs to ensure if condition works.
    @Test
    void atm_with_stubs_test_choice_a() {
        assertEquals(1, test.atm_with_stubs('a'));
    }
    @Test
    void atm_with_stubs_test_choice_b() {
        assertEquals(2, test.atm_with_stubs('b'));
    }
    @Test
    void atm_with_stubs_test_choice_c() {
        assertEquals(3, test.atm_with_stubs('c'));
    }
    @Test
    void atm_with_stubs_test_choice_d() {
        assertEquals(4, test.atm_with_stubs('d'));
    }
    @Test
    void atm_with_stubs_test_choice_e() {
        assertEquals(5, test.atm_with_stubs('e'));
    }
    @Test
    void atm_with_stubs_test_choice_x() {
        assertEquals(6, test.atm_with_stubs('x'));
    }

    //Top-down testing
    @Test
    void testGetLoanFail1(){
        test.driver_setsLoanAbilityToFalseThenCallsGetLoan(1900);
        assertEquals(0, test.loan_amount);
        assertEquals(false, test.is_allowed_to_get_loan);
        assertEquals(1000, test.accBalance);
    }
    @Test
    void testGetLoanFail2(){
        test.driver_setsLoanAbilityToFalseThenCallsGetLoan(500);
        assertEquals(0, test.loan_amount);
        assertEquals(false, test.is_allowed_to_get_loan);
        assertEquals(1000, test.accBalance);
    }

    //Top-down testing
    @Test
    void testAbilityToGetLoanTrue(){
        test.driver_setsLoanAbilityToFalseThenCalls_setLoanAbility();
        assertEquals(true, test.is_allowed_to_get_loan);
    }

    @Test
    void testcheckNameAndID_true(){
        test.checkID_and_password(1, 0000);
        assertEquals(true, test.allowToContinue);
    }
    @Test
    void testcheckNameAndID_falseID(){
        test.checkID_and_password(5, 0000);
        assertEquals(false, test.allowToContinue);
    }
    @Test
    void testcheckNameAndID_falsePassword(){
        test.checkID_and_password(1, 5271);
        assertEquals(false, test.allowToContinue);
    }


    //Unit Testing
    @Test
    void depositMoney901() {
        test.depositMoney(901);
        assertEquals(1901, test.accBalance);
    }
    @Test
    void depositMoney1307() {
        test.depositMoney(1307);
        assertEquals(2307, test.accBalance);
    }

    @Test
    void withdrawMoney901() {
        test.withdrawMoney(901);
        assertEquals(99, test.accBalance);
    }
    @Test
    void withdrawMoney5() {
        test.withdrawMoney(5);
        assertEquals(995, test.accBalance);
    }
    @Test
    void testGetLoan500(){
        test.getLoan(500);
        assertEquals(500, test.loan_amount);
        assertEquals(false, test.is_allowed_to_get_loan);
        assertEquals(1500, test.accBalance);
    }
    @Test
    void testGetLoan1000(){
        test.getLoan(1000);
        assertEquals(1000, test.loan_amount);
        assertEquals(false, test.is_allowed_to_get_loan);
        assertEquals(2000, test.accBalance);
    }
    @Test
    void repayLoanAmountSome() {
        test.getLoan(500);
        test.repayLoanAmount(466);
        assertEquals(34, test.loan_amount);
        assertEquals(1034, test.accBalance);
        assertEquals(false, test.is_allowed_to_get_loan);
    }
    @Test
    void repayLoanAmountAll() {
        test.getLoan(1000);
        test.repayLoanAmount(1000);
        assertEquals(0, test.loan_amount);
        assertEquals(1000, test.accBalance);
        assertEquals(true, test.is_allowed_to_get_loan);
    }
    @Test
    void testDisplayBalance(){
        assertEquals(1000, test.displayBalance());
    }

    @Nested
    class atm{
        @BeforeEach
        void begin(){
            test.allowToContinue = true;
        }
        @Test
        void atmTest1() {
            test.atm('b', 1);
            assertEquals(1001, test.accBalance);
        }
        @Test
        void atmTest2() {
            test.atm('c', 1);
            assertEquals(999, test.accBalance);
        }
        @Test
        void atmTest3() {
            test.atm('d', 1);
            assertEquals(1001, test.accBalance);
            assertEquals(1, test.loan_amount);
        }
        @Test
        void atmTest4() {
            test.loan_amount = 5;
            test.is_allowed_to_get_loan = false;
            test.atm('e', 5);
            assertEquals(995, test.accBalance);
            assertEquals(0, test.loan_amount);
            assertEquals(true, test.is_allowed_to_get_loan);
        }
    }

    @AfterEach
    void after(){
        test = null;
    }
}