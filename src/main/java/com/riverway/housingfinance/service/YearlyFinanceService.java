package com.riverway.housingfinance.service;

import com.riverway.housingfinance.domain.Bank;
import com.riverway.housingfinance.domain.YearlyFinance;
import com.riverway.housingfinance.domain.YearlyFinanceRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class YearlyFinanceService {

    private final YearlyFinanceRepository yearlyFinanceRepository;

    public YearlyFinanceService(YearlyFinanceRepository yearlyFinanceRepository) {
        this.yearlyFinanceRepository = yearlyFinanceRepository;
    }

    public void saveYearlyFinaces(Map<Integer, Map<Bank, Integer>> yearlyFinances) {
        for (Integer year : yearlyFinances.keySet()) {
            Map<Bank, Integer> amountByBank = yearlyFinances.get(year);
            for (Bank bank : amountByBank.keySet()) {
                Integer amount = amountByBank.get(bank);
                YearlyFinance yearlyFinance = new YearlyFinance(year, amount, bank);
                yearlyFinanceRepository.save(yearlyFinance);
            }
        }
    }
}
