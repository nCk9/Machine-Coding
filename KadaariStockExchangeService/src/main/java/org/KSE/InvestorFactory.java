package org.KSE;

import org.springframework.stereotype.Component;

@Component
public class InvestorFactory {

    public Investor getInvestor(String investorName){
        return new Investor(investorName);
    }
}
