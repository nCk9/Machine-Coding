package org.ATM;

import org.ATM.Service.AxisBankIntegration;
import org.ATM.Service.BankIntegration;
import org.ATM.Service.HDFCBankIntegration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class BankIntegrationFactory {

    public BankIntegration getBankIntegrator(String bankName){
        if("hdfc".equalsIgnoreCase(bankName))
            return new HDFCBankIntegration();
        else if("axis".equalsIgnoreCase(bankName))
            return new AxisBankIntegration();
        return new HDFCBankIntegration();
    }
}
