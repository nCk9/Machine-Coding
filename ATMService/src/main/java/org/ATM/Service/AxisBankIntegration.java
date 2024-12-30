package org.ATM.Service;

import org.ATM.Account;
import org.ATM.Repository.AxisBankRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import static org.ATM.ATMApplication.context;

@Service
public class AxisBankIntegration extends BankIntegration{

    @Override
    public Account getAccountDetails(String cardNumber){
        //call HDFC bank repository and fetch account details against the card number.
        System.out.println("========> Fetching account details of the customer <==========");
        try {
            AxisBankRepository axisBankRepository = context.getBean(AxisBankRepository.class);
            return axisBankRepository.getAccountDetails(cardNumber);
        }catch (Exception e){
            System.out.println("Exception occurred while fetching customer details from DB.\n");
            throw e;
        }
    }

    @Override
    public void debitAmount(String amount){

    }
}
