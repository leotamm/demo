package ee.bcs.valiiit.controller;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("bank")

public class BankController {

    private Map<String, BigDecimal> account = new HashMap<>();   // paremale keerukam objekt enama infoga
    private Map<String, Account> accounts = new HashMap<>();
    BigDecimal money = new BigDecimal(0);
    BigDecimal minBalance = new BigDecimal(0);

    // createAccount (accountNr)                            CORRECT
    @PostMapping("newAccount")
    public String createAccount(@RequestBody String accountNr) {
        accounts.put(accountNr, new Account(accountNr));
        String replyYes = "Account created";
        return replyYes;
    }

    // check all accounts                                   CORRECT
    @GetMapping("checkAccounts")
    public Map<String, Account> checkBankAccounts() {
        return accounts;
    }

    // depositMoney (accountNr, money)                      CORRECT
    @PutMapping("depositToAccount/{id1}")
    public String depositMoney(@PathVariable("id1") String accountNr,
                               @RequestParam("money") BigDecimal money) {
        Account account = accounts.get(accountNr);
        BigDecimal oldValue = account.getBalance();
        BigDecimal newValue = oldValue.add(money);
        account.setBalance(newValue);
        accounts.put(accountNr, account);
        String replyYes = "Money deposited, new balance: ";
        return replyYes + account.getBalance();
    }

    // withdrawMoney (accountMoney, money))                 CORRECT
    @PutMapping("withdrawFromAccount/{id1}")
    public String withdrawMoney(@PathVariable("id1") String accountNr,
                                @RequestParam("money") BigDecimal money) {
        Account account = accounts.get(accountNr);
        BigDecimal oldValue = account.getBalance();

        if (money.compareTo(oldValue) > 0) {
            String replyNo = "Denied - insufficient funds";
            return replyNo;
        } else {
            BigDecimal newValue = oldValue.subtract(money);
            account.setBalance(newValue);
            accounts.put(accountNr, account);
        }
        String replyYes = "Money withdrawn, new balance: ";
        return replyYes + account.getBalance();
    }

    // transferMoney (fromAccount), toAccount, money        CORRECT
    @PutMapping("transfer/{id1}/{id2}")
    public String transferMoney(@PathVariable("id1") String fromAccountNr,
                                @PathVariable("id2") String toAccountNr,
                                @RequestParam("money") BigDecimal money) {

        Account accountFrom = accounts.get(fromAccountNr);
        BigDecimal oldValue = accountFrom.getBalance();
        Account toAccount = accounts.get(toAccountNr);
        BigDecimal oldValue2 = toAccount.getBalance();

        if (money.compareTo(oldValue) > 0) {
            String replyNo = "Transfer denied - insufficient funds";
            return replyNo;
        } else {
            BigDecimal newValue = oldValue.subtract(money); // deducts from one account
            accountFrom.setBalance(newValue);
            accounts.put(fromAccountNr, accountFrom);

            BigDecimal newValue2 = oldValue2.add(money);    // adds to another account
            toAccount.setBalance(newValue2);
            accounts.put(toAccountNr, toAccount);
            String replyYes = "Money transferred, new balance: ";
            return replyYes + toAccount.getBalance();
        }
    }

    // getAccountBalance (accountNr)                        // CORRECT
    @GetMapping("checkAccount/{id1}")
    public String checkBankAccount(@PathVariable("id1") String accountNr) {
        Account account = accounts.get(accountNr);
        BigDecimal balance = account.getBalance();

        if (balance.compareTo(minBalance) <= 0) {
            String replyNo = "There are no funds on the account";
            return replyNo;
        } else {
            String replyYes = "Your balance is: ";
            return replyYes + balance;
        }
    }

    //
    // createClient(firstName, lastName, .....)
    // muuta createAccount (clientId, accountNr)
    // getBalanceHistory(accountNr)


}

