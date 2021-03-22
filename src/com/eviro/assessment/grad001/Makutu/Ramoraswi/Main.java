package com.eviro.assessment.grad001.Makutu.Ramoraswi;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        System.out.println("Testing savingsAccount");
        System.out.println("====================================");
        SavingsAccount sa = new SavingsAccount(13, BigDecimal.valueOf(8000),0.045,"5588787444");
        sa.withdraw(sa.getAccountNum(), BigDecimal.valueOf(1000));



        System.out.println("Testing currentAccount (set overdraft)");
        System.out.println("====================================");
        CurrentAccount ca =new CurrentAccount(11,BigDecimal.valueOf(2000),0.045,"5224892555",BigDecimal.valueOf(5000));
        ca.withdraw(ca.getAccountNum(),BigDecimal.valueOf(5000));
    }
}