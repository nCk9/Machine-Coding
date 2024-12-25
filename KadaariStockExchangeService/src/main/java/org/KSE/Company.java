package org.KSE;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Company implements BuyingEntity {

    private String companyName;
    private Integer totalShares;
    private Float initialSharePrice;
    private Float initialCompanyWorth;
    private Float currentPricePerShare;
    private Float currentCompanyWorth;
    private Integer currentShares;

    public Company(){
        System.out.println("Default Company.\n");
    }

    public Company(String name, Integer shares, Float perSharePrice, Float companyWorth){
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
