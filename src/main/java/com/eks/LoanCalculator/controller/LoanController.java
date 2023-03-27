package com.eks.LoanCalculator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.eks.LoanCalculator.pojo.LoanDecision;
import com.eks.LoanCalculator.service.LoanService;

@Controller
@RequestMapping("/loan")
@CrossOrigin(origins = "http://localhost:3000")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping
    public ResponseEntity<LoanDecision> getLoanDecision(
            @RequestParam("personalCode") String personalCode,
            @RequestParam("loanAmount") int loanAmount,
            @RequestParam("loanPeriod") int loanPeriod) {
        LoanDecision decision = loanService.getLoanDecision(personalCode, loanAmount, loanPeriod);
        return ResponseEntity.ok(decision);
    }

}
