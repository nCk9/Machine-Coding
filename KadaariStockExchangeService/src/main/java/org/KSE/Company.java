package org.KSE;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Company {

    String companyName;
    Integer totalShares;
    Float initialSharePrice;
    Float initialCompanyWorth;
    Float currentPricePerShare;
    Float currentCompanyWorth;
    Integer currentShares;

    Company(String name, Integer shares, Float perSharePrice, Float companyWorth){
        this.companyName = name;
        this.totalShares = shares;
        this.initialSharePrice = perSharePrice;
        this.initialCompanyWorth = companyWorth;
        this.currentPricePerShare = perSharePrice;
        this.currentCompanyWorth = companyWorth;
        this.currentShares = shares;
    }

    public void getStats(){
        System.out.println("Company's net worth: " + currentCompanyWorth + ", market share price: " + currentPricePerShare + ", stocks remaining: " + currentShares);
    }
}
