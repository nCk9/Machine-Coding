package org.ATM.Repository;

import org.ATM.Account;
import org.springframework.stereotype.Repository;

import javax.lang.model.element.NestingKind;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Repository
public class HDFCBankRepository {

    Map<String, ArrayList<String>> bankRepository; //map of cardNumber (key) mapped to other account details (value)

    public HDFCBankRepository(){
        bankRepository = new HashMap<String, ArrayList<String>>(){{
            put("123337672", new ArrayList<>(Arrays.asList("4344238763478369","Nitya", "80000")));
            put("789438333", new ArrayList<>(Arrays.asList("6785041304724789","AC", "800000")));
            put("981234764", new ArrayList<>(Arrays.asList("2894044676954917","ANIL", "1000000")));
        }};
    }
    //assuming the bank will expose a view for the sake of ATMs containing appropriate columns. Bank db might have more columns but everything does not need to be shared with the ATMs.
    public Account getAccountDetails(String cardNumber){
        ArrayList<String> customerDetails = bankRepository.get(cardNumber);
        String accountNumber = customerDetails.get(0);
        String accountHolderName = customerDetails.get(1);
        String balance = customerDetails.get(2);
        return new Account(cardNumber, accountNumber, accountHolderName, balance);
    }


}
