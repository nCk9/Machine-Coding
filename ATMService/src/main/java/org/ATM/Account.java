package org.ATM;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Account {

    private String accountNumber;
    private String accountHolderName;
    private String cardNumber;
    private String balanceAmount;

    public Account(String cardNumber, String accountNumber, String accountHolderName, String balanceAmount){
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balanceAmount = balanceAmount;
        this.cardNumber = cardNumber;
    }

}
