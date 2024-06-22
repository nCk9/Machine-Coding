package org.KSE;
import java.util.ArrayList;
import java.util.List;

public class KadaariStockExchange {
    private List<Investor> investorList;
    private List<Company> companyList;

    KadaariStockExchange(){
        this.investorList = new ArrayList<>();
        this.companyList = new ArrayList<>();
    }

    public String registerCompany(Company company) {
        companyList.add(company);
        return "Registered";
    }

    public String registerInvestor(Investor investor){
        this.investorList.add(investor);
        return "Registered";
    }

    public Investor isInvestorRegistered(String name){
        for(Investor investor: investorList)
            if(name.equals(investor.getInvestorName()))
                return investor;
        return null;
    }

    public Company isCompanyRegistered(String name){
        for(Company company: companyList)
            if(name.equals(company.getCompanyName()))
                return company;
        return null;
    }

    public void getListOfCompaniesRegistered() {
        for(Company iCompany: companyList){
            System.out.println(iCompany.getCompanyName() + " " + iCompany.getTotalShares() + " " + iCompany.getInitialSharePrice() + " " + iCompany.getInitialCompanyWorth()) ;
        }
    }

    public void getListOfInvestorsRegistered() {
        for(Investor iInvestor: investorList){
            System.out.println(iInvestor.getInvestorName());
        }
    }
}
