package org.ATM.Service;

import org.ATM.Account;

public interface BankIntegration {
    public Account getAccountDetails(String cardNumber);
    public void debitAmount(String amount);

}
