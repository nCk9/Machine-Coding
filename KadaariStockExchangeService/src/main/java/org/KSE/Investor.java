package org.KSE;

import java.util.HashMap;

public class Investor {

    String investorName;
    HashMap<String, Integer> companiesHeld;

    Investor(String name){
        this.investorName = name;
        this.companiesHeld = new HashMap<>();
    }

    void addCompanyToPortfolio(String companyName, String quantity){

    }

}
