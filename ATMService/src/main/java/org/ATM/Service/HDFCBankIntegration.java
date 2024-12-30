package org.ATM.Service;


import org.ATM.Account;
import org.ATM.Repository.HDFCBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

import static org.ATM.ATMApplication.context;

@Service
public class HDFCBankIntegration implements BankIntegration {

    @Override
    public Account getAccountDetails(String cardNumber){
        //call HDFC bank repository and fetch account details against the card number.
        System.out.println("========> Fetching account details of the customer <==========");
        try {
            HDFCBankRepository hdfcBankRepository = context.getBean(HDFCBankRepository.class);
            return hdfcBankRepository.getAccountDetails(cardNumber);
        }catch (Exception e){
            System.out.println("Exception occurred while fetching customer details from DB.\n");
            throw e;
        }
    }

    @Override
    public void debitAmount(String amount){

    }
}
