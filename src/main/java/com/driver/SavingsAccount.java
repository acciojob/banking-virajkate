package com.driver;

public class SavingsAccount extends BankAccount{
   private double rate;
    private double maxWithdrawalLimit;

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public void setMaxWithdrawalLimit(double maxWithdrawalLimit) {
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        super();

        this.setName(name);
        this.setBalance(balance);
        this.setRate(rate);
        this.setMaxWithdrawalLimit(maxWithdrawalLimit);

        // minimum balance is 0 by default
        this.setMinBalance(0);

    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        if(amount>getMaxWithdrawalLimit()){
            throw new Exception("Maximum Withdraw Limit Exceed");
        }
        if(amount>getBalance()){
            throw new InsufficientBalance("Insufficient Balance");
        }
        setBalance(-amount);
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        double interest=0.0;
        double res=getRate()*years;
        interest=getBalance()*(1+res);
        return interest;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double interest=0.0;
        double res=getRate()/times;
        double pow=times*years;
        interest=getBalance()*(Math.pow((1+res),pow));

        return interest;
    }

}
