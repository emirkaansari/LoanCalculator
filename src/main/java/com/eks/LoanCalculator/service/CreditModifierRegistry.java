package com.eks.LoanCalculator.service;

import java.util.HashMap;
import java.util.Map;

public class CreditModifierRegistry {
    private static final Map<Integer, Integer> creditModifiers = new HashMap<>();
    
    static {
        creditModifiers.put(0, 0);
        creditModifiers.put(1, 100);
        creditModifiers.put(2, 300);
        creditModifiers.put(3, 1000);
    }
    
    public int getCreditModifier(String personalCode) {
        int mod = (int) (Long.parseLong(personalCode) % 4);
        return creditModifiers.get(mod);
    }
}
