package com.example.testinglab3;


public class ATM_Machine {

    boolean allowToContinue = false;

    int accountID;
    int password;
    int accBalance;
    int loan_amount;
    boolean is_allowed_to_get_loan;

    ATM_Machine(int accountID, int password, int accBalance){
        this.accountID = accountID;
        this.password = password;
        this.accBalance = accBalance;
        this.loan_amount = 0;
        this.is_allowed_to_get_loan = true;
    }
    public int displayBalance(){
        return this.accBalance;
    }
    public void depositMoney(int amount){
       this.accBalance += amount;
    }
    public void withdrawMoney(int amount){
        if (amount <= this.accBalance)
            this.accBalance -= amount;
        else
            System.out.println("Not enough balance");
    }
    public void setLoanAbility(){
        if (this.loan_amount == 0)
            this.is_allowed_to_get_loan = true;
    }
    public void getLoan(int amount){
        if (this.is_allowed_to_get_loan) {
            this.loan_amount = amount;
            this.accBalance += amount;
            this.is_allowed_to_get_loan = false;
        }else{
            System.out.println("Not allowed to get loan");
        }
    }
    public void repayLoanAmount(int amount) {
        if (this.accBalance >= amount) {
            if (this.loan_amount >= amount) {
                this.accBalance -= amount;
                this.loan_amount -= amount;
            }
            this.setLoanAbility();
        }else{
            System.out.println("Invalid.");
        }
    }
    public void checkID_and_password(int accountID, int password){
        if (this.accountID == accountID && this.password == password)
            allowToContinue = true;
        else
            allowToContinue = false;
    }

    public void atm(char choiceToDo, int amount){
        if (allowToContinue){
            if (choiceToDo == 'a'){
                this.displayBalance();
            }else if (choiceToDo == 'b'){
                this.depositMoney(amount);
            }else if (choiceToDo == 'c'){
                this.withdrawMoney(amount);
            }else if (choiceToDo == 'd'){
                this.getLoan(amount);
            }else if (choiceToDo == 'e'){
                this.repayLoanAmount(amount);
            }else{
                System.out.println("Not a valid choice.");
            }
        }
        this.allowToContinue = false;
    }

    public void driver_setsLoanAbilityToFalseThenCalls_setLoanAbility(){
        this.is_allowed_to_get_loan = false;
        this.setLoanAbility();
    }
    public void driver_setsLoanAbilityToFalseThenCallsGetLoan(int amount){
        this.is_allowed_to_get_loan = false;
        this.getLoan(amount);
    }
    public int atm_with_stubs(char choiceToDo) {
        int x;
        if (true) {
            if (choiceToDo == 'a') {
                x = 1;
            } else if (choiceToDo == 'b') {
                x = 2;
            } else if (choiceToDo == 'c') {
                x = 3;
            } else if (choiceToDo == 'd') {
                x = 4;
            } else if (choiceToDo == 'e') {
                x = 5;
            } else {
                x = 6;
            }
        }
        return x;
    }
}
