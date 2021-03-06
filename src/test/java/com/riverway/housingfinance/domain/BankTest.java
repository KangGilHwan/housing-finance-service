package com.riverway.housingfinance.domain;

import com.riverway.housingfinance.bank.BankName;
import com.riverway.housingfinance.bank.domain.Bank;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BankTest {

    @Test
    public void match() {
        Bank bank = new Bank("bnk1001", "주택도시기금");

        assertTrue(bank.match(BankName.JUTAEK.getBankName()));
    }

    @Test
    public void match_false() {
        Bank bank = new Bank("bnk1002", "국민은행");

        assertFalse(bank.match(BankName.EXCHANGE.getBankName()));
    }
}