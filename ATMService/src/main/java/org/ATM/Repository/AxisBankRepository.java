package org.ATM.Repository;

import org.ATM.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AxisBankRepository {
    Map<String, ArrayList<String>> bankRepository;

    public AxisBankRepository(){
        bankRepository = new HashMap<String, ArrayList<String>>(){{
            put("849574894", new ArrayList<>(Arrays.asList("8734639784654094","abc", "80000")));
            put("547368485", new ArrayList<>(Arrays.asList("5634998383364293","def", "800000")));
            put("798459478", new ArrayList<>(Arrays.asList("2958639846383749","ghi", "1000000")));
        }};
    }

    public Account getAccountDetails(String cardNumber){
        ArrayList<String> customerDetails = bankRepository.get(cardNumber);
        String accountNumber = customerDetails.get(0);
        String accountHolderName = customerDetails.get(1);
        String balance = customerDetails.get(2);
        return new Account(cardNumber, accountNumber, accountHolderName, balance);
    }
}
