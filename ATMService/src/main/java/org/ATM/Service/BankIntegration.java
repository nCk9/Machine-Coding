package org.ATM.Service;

import org.ATM.Account;

public abstract class BankIntegration {
    public abstract Account getAccountDetails(String cardNumber);
    public abstract void debitAmount(String amount);
}
