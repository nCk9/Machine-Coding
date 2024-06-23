package org.KSE;

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
        companiesHeld.put(companyName, quantity);
    }

    public void getPortfolio(){
        for(String companyName: companiesHeld.keySet())
            System.out.println(companyName + ",  " + companiesHeld.get(companyName));
    }

    public Integer getQuantity(String companyName) {
        return companiesHeld.get(companyName);
    }

    public void reduceQuantity(String companyName, Integer quantitySold) {
        Integer currentQuantity = companiesHeld.get(companyName);
        int finalQuantity = currentQuantity - quantitySold;
        if(finalQuantity == 0)
            companiesHeld.remove(companyName);
        else
            companiesHeld.put(companyName, finalQuantity);
    }
}
