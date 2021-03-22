package com.eviro.assessment.grad001.Makutu.Ramoraswi;

import java.math.BigDecimal;

public class CurrentAccount implements AccountService{

    private  int id;
    private  BigDecimal balance;
    private double annualInterestRate;
    private String accountNum;
    private BigDecimal overdraft;

    public CurrentAccount(int id, BigDecimal balance, double annualInterestRate, String accountNum, BigDecimal overdraft) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
        this.accountNum = accountNum;
        this.overdraft = overdraft;
    }


    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getAccountNum() {
        return accountNum;
    }

    @Override
    public void withdraw(String accountNum, BigDecimal amountToWithdraw) {
        String currentAccountNumLastDigit = "555";
        String lastThreeValues = accountNum.substring(accountNum.length() -3);
        BigDecimal val=amountToWithdraw.subtract(getBalance());

        if(!currentAccountNumLastDigit.equals(lastThreeValues)){
            System.out.println ( "Please confirm your account number" );
            return;
        }else
        if((overdraft.compareTo(BigDecimal.valueOf(100000)) >= 0)){
            System.out.println ( "Enviro-Bank overdraft limit is R100,000" +" "+"not allowed to apply overdraft of R :"+ overdraft);
            return ;
        }else
        if (amountToWithdraw.compareTo(getBalance())<0||amountToWithdraw.equals(getBalance())){
            setBalance(getBalance().subtract(amountToWithdraw));
            System.out.println ( "available balance R:" +getBalance());
        }else
        if (val.compareTo(overdraft) <=0){
            setBalance(BigDecimal.valueOf(0));
            overdraft = overdraft.subtract(val);
            System.out.println ( "remaining amount of consumption R:" + overdraft);
        }
        else{
            System.out.println ( "You exceed the overdraft limit R:" + overdraft);
        }

    }

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
        System.out.println ( "deposit has been successful, the current balance is" + balance);
    }

}
