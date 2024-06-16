package org.KSE;

public class Company {

    String companyName;
    Integer totalShares;
    Float initialSharePrice;
    Float initialCompanyWorth;

    Company(String name, Integer shares, Float perSharePrice, Float companyWorth){
        this.companyName = name;
        this.totalShares = shares;
        this.initialSharePrice = perSharePrice;
        this.initialCompanyWorth = companyWorth;
    }


}
