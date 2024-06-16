package org.KSE;
import java.util.ArrayList;
import java.util.List;

public class KadaariStockExchange {
    List<Investor> investorList;
    List<Company> companyList;

    KadaariStockExchange(){
        this.investorList = new ArrayList<Investor>();
        this.companyList = new ArrayList<Company>();
    }

    public String registerCompany(Company company) {
        companyList.add(company);
        return "Registered";
    }

    public String registerInvestor(Investor investor){
        this.investorList.add(investor);
        return "Registered";
    }
}
