package com.eks.LoanCalculator.pojo;

public class LoanDecision {

    private final String decision;
    private final int amount;
    private final Integer newLoanPeriod;

    public LoanDecision(String decision, int amount) {
        this(decision, amount, null);
    }

    public LoanDecision(String decision, int amount, Integer newLoanPeriod) {
        this.decision = decision;
        this.amount = amount;
        this.newLoanPeriod = newLoanPeriod;
    }

    public String getDecision() {
        return decision;
    }

    public int getAmount() {
        return amount;
    }

    public Integer getNewLoanPeriod() {
        return newLoanPeriod;
    }
}

