package org.ATM;

import org.ATM.Service.AxisBankIntegration;
import org.ATM.Service.BankIntegration;
import org.ATM.Service.HDFCBankIntegration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import static org.ATM.ATMApplication.context;

@Component
public class BankIntegrationFactory {

    public BankIntegration getBankIntegrator(String bankName){
        if("hdfc".equalsIgnoreCase(bankName))
            return context.getBean(HDFCBankIntegration.class);
        else if("axis".equalsIgnoreCase(bankName))
            return context.getBean(AxisBankIntegration.class);
        return context.getBean(HDFCBankIntegration.class);
    }
}
