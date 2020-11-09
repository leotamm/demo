package ee.bcs.valiiit.controller;

import java.math.BigDecimal;

public class Account {

    private String accountNr;
    private BigDecimal balance;

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Account(String accountNr) {
        this.accountNr = accountNr;
        this.balance = BigDecimal.ZERO;
    }

    public String getAccountNr() {
        return accountNr;
    }

    public Account setAccountNr(String accountNr) {
        this.accountNr = accountNr;
        return this;
    }

}
