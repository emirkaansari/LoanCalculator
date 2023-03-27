package com.eks.LoanCalculator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import com.eks.LoanCalculator.service.CreditModifierRegistry;


@Configuration
public class AppConfig {
 
    @Bean
    public CreditModifierRegistry creditModifierRegistry() {
        return new CreditModifierRegistry();
    }

}
