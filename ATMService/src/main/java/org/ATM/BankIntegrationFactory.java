package org.ATM;

import org.ATM.Service.BankIntegration;
import org.ATM.Service.HDFCBankIntegration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class BankIntegrationFactory {

    public BankIntegration getBankIntegrator(String bankName){
//        if("hdfc".equals(bankName))
//            return new HDFCBankIntegration();
//        else if("axis".equals(bankName))

        return new HDFCBankIntegration();
    }
}
