package com.eviro.assessment.grad001.Makutu.Ramoraswi;

import java.math.BigDecimal;

public class SavingsAccount implements AccountService{
    private  int id;
    private  BigDecimal balance;
    private double annualInterestRate;
    private String accountNum;

    public SavingsAccount(int id, BigDecimal balance, double annualInterestRate, String accountNum) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
        this.accountNum = accountNum;
    }

    public String getAccountNum() {
        return accountNum;
    }
    public double getMonthlyInterest(){
        double monthlyInterest=annualInterestRate/12;
        return monthlyInterest;
    }

    @Override
    public void withdraw(String accountNum, BigDecimal amountToWithdraw) {
        String savingAccountNumLastDigit = "444";
        String lastThreeValues = accountNum.substring(accountNum.length() -3);

        if(savingAccountNumLastDigit.equals(lastThreeValues)){
            if((balance.compareTo(BigDecimal.valueOf(1000))< 0)){
                System.out.println ( "Your current balance is less than R: 1000 , & withdrawal cant be processed!" );
                return;
            }
        }
        else {
            System.out.println ( "Please confirm your account number" );
            return ;
        }

        if(balance.compareTo(amountToWithdraw) > 0||balance.equals(amountToWithdraw)){
            this.balance=balance.subtract(amountToWithdraw);
            System.out.println ( "Withdrawal Successful, the current balance is R:" + balance + "\n" + "current monthly interest rate is R:" + getMonthlyInterest () + "\n");
        }else{
            System.out.println ( "lack of balance, not withdrawals");
            System.out.println ( "Your current balance is R:" + balance + "\n");
        }
    }

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
        System.out.println ( "deposit has been successful, the current balance is R:" + balance);
    }

}
