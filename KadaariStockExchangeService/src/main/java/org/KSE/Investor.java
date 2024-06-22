package org.KSE;

import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.Getter;

import java.util.HashMap;

@Getter
public class Investor {

    private final String investorName;
    HashMap<String, Integer> companiesHeld; //company name, number of shares held

    Investor(String name){
        this.investorName = name;
        this.companiesHeld = new HashMap<>();
    }

    public void addCompanyToPortfolio(String companyName, Integer quantity){
        this.companiesHeld.put(companyName, quantity);
    }

    public void getPortfolio(){
        for(String companyName: companiesHeld.keySet())
            System.out.println(companyName + ",  " + companiesHeld.get(companyName));
    }
}
