package com.eks.LoanCalculator.service;

import org.springframework.stereotype.Service;

import com.eks.LoanCalculator.pojo.LoanDecision;

@Service
public class LoanService {

    private final CreditModifierRegistry creditModifierRegistry;

    public LoanService(CreditModifierRegistry creditModifierRegistry) {
        this.creditModifierRegistry = creditModifierRegistry;
    }

    public LoanDecision getLoanDecision(String personalCode, int loanAmount, int loanPeriod) {
        int creditModifier = creditModifierRegistry.getCreditModifier(personalCode);
        double creditScore = (double) creditModifier / loanAmount * loanPeriod;

        if (creditScore >= 1) {
            int maxLoanAmount = getMaxLoanAmount(loanPeriod, creditModifier);
            return new LoanDecision("positive", maxLoanAmount);
        } else {
            for (int i = loanPeriod + 12; i <= 60; i += 12) {
                double newCreditScore = (double) creditModifier / loanAmount * i;
                if (newCreditScore >= 1) {
                    int maxLoanAmount = getMaxLoanAmount(i, creditModifier);
                    return new LoanDecision("positive", maxLoanAmount, i);
                }
            }
            return new LoanDecision("negative", 0);
        }
    }

    private int getMaxLoanAmount(int loanPeriod, int creditModifier) {
        int maxLoanAmount = creditModifier / loanPeriod * 100;
        return Math.min(maxLoanAmount, 10000);
    }
}
