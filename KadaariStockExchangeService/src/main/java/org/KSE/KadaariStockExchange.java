package org.KSE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class KadaariStockExchange {
    private final List<Investor> investorList;
    private final List<BuyingEntity> buyingEntityList;

    @Autowired
    private BuyingEntityFactory buyingEntityFactory;
    @Autowired
    private InvestorFactory investorFactory;

    KadaariStockExchange(){
        this.investorList = new ArrayList<>();
        this.buyingEntityList = new ArrayList<>();
    }

    public void registerCompany(Scanner inputScanner) {
        String companyName = inputScanner.next();
        Integer countOfShares = inputScanner.nextInt();
        Float initialPricePerShare = inputScanner.nextFloat();
        Float initialCompanyWorth = inputScanner.nextFloat();
        BuyingEntity buyingEntity = buyingEntityFactory.getBuyingEntity("company", companyName, countOfShares, initialPricePerShare, initialCompanyWorth);
        buyingEntityList.add(buyingEntity);
        System.out.println("Company " + companyName + " registered successfully with KSE!");
    }

    public void registerInvestor(Scanner inputScanner){
        String name = inputScanner.next();
        Investor investor = investorFactory.getInvestor(name);
        investorList.add(investor);
        System.out.println("Investor " + name + " registered successfully with KSE!");
    }

    public void buyForInvestor(Scanner inputScanner) {
        String stockName = inputScanner.next();
        String investorName = inputScanner.next();
        Integer quantity = inputScanner.nextInt();
        Investor investor = isInvestorRegistered(investorName);
        if(investor == null){
            System.out.println("The investor " + investorName + " is not registered with KSE yet. Please register and try again.\n");
            return;
        }
        Company company = isCompanyRegistered(stockName);
        if(company == null){
            System.out.println("The company " + stockName + " is not registered with KSE yet. Please register and try again.\n");
            return;
        }
        investor.addCompanyToPortfolio(stockName, quantity);
        Float avgBuyingPrice = calculateBuyingMspForQuantity(company, quantity);
        if(avgBuyingPrice < 0)
            System.out.println("Quantity asked is higher than the maximum available for the company.\n");
        else
            System.out.println("Success, Avg buying price : " + avgBuyingPrice + ", total buying price: " + avgBuyingPrice*quantity + ".");
    }

    private Float calculateBuyingMspForQuantity(Company company, Integer quantity) {
        Float currentAvgMsp = company.getCurrentPricePerShare();
        Float finalCurrentWorth = company.getCurrentCompanyWorth();
        Integer totalQuantity = company.getTotalShares();
        if(quantity > totalQuantity) return -1f;
        Float sumMsps = 0f; Integer count=0;
        while(quantity > 0){
            sumMsps += currentAvgMsp;
            finalCurrentWorth += currentAvgMsp;
            currentAvgMsp = (Float) finalCurrentWorth/totalQuantity;
            quantity--;
            count++;
        }
        company.setCurrentShares(company.getCurrentShares()-count);
        company.setCurrentCompanyWorth(finalCurrentWorth);
        company.setCurrentPricePerShare(currentAvgMsp);
        return (Float)sumMsps/count;
    }

    public void sellForInvestor(Scanner inputScanner) {
        String stockName = inputScanner.next();
        String investorName = inputScanner.next();
        Integer quantity = inputScanner.nextInt();
        Investor investor = isInvestorRegistered(investorName);
        if(investor == null){
            System.out.println("The investor " + investorName + " is not registered with KSE yet. Please register and try again.\n");
            return;
        }
        Company company = isCompanyRegistered(stockName);
        if(company == null){
            System.out.println("The company " + stockName + " is not registered with KSE yet. Please register and try again.\n");
            return;
        }

        Float avgSellingPrice = calculateSellingMspForQuantity(company, quantity, investor);
        if(avgSellingPrice < 0)
            System.out.println("The selling quantity is higher than what the investor has. Please enter valid quantity.");
        else
            System.out.println("Success, Avg selling price : " + avgSellingPrice + ", total selling price: " + avgSellingPrice*quantity + ".");
    }

    private Float calculateSellingMspForQuantity(Company company, Integer quantity, Investor investor){
        Float currentAvgMsp = company.getCurrentPricePerShare();
        Float finalCurrentWorth = company.getCurrentCompanyWorth();
        Integer totalQuantity = company.getTotalShares();
        Integer currentHoldingQuantity = investor.getQuantity(company.getCompanyName());
        if(quantity > currentHoldingQuantity) return -1f;
        Float sumMsps = 0f; Integer count=0;
        while(quantity > 0){
            sumMsps += currentAvgMsp;
            finalCurrentWorth -= currentAvgMsp;
            currentAvgMsp = (Float) finalCurrentWorth/totalQuantity;
            quantity--;
            count++;
        }
        company.setCurrentShares(company.getCurrentShares()+count);
        company.setCurrentCompanyWorth(finalCurrentWorth);
        company.setCurrentPricePerShare(currentAvgMsp);
        investor.reduceQuantity(company.getCompanyName(), quantity);
        return (Float)sumMsps/count;
    }

    public void getInvestorDetails(Scanner inputScanner) {
        String nameInvestor = inputScanner.next();
        Investor investor = isInvestorRegistered(nameInvestor);
        if(investor == null) System.out.println("This investor does not exist. Please input correct name.");
        else
            investor.getPortfolio();
    }

    public void getCompanyDetails(Scanner inputScanner) {
        String nameCompany = inputScanner.next();
        Company company = isCompanyRegistered(nameCompany);
        if(company != null) company.getStats();
    }

    private Investor isInvestorRegistered(String name){
        for(Investor investor: investorList)
            if(name.equals(investor.getInvestorName()))
                return investor;
        return null;
    }

    private Company isCompanyRegistered(String name){
        for(BuyingEntity entity: buyingEntityList) {
            if(entity instanceof Company) {
                Company company = (Company) entity; //type-casting entity (of type BuyingEntity) to Company
                if (name.equals(company.getCompanyName()))
                    return company;
            }
        }
        return null;
    }

//    public void getListOfCompaniesRegistered() {
//        for(Company iCompany: buyingEntityList){
//            System.out.println(iCompany.getCompanyName() + " " + iCompany.getTotalShares() + " " + iCompany.getInitialSharePrice() + " " + iCompany.getInitialCompanyWorth()) ;
//        }
//    }

    public void getListOfInvestorsRegistered() {
        for(Investor iInvestor: investorList){
            System.out.println(iInvestor.getInvestorName());
        }
    }

}
