package org.KSE;

import java.util.Scanner;

public class KadaariStockExchangeApplication {
    private static final KadaariStockExchange kadaariStockExchange = new KadaariStockExchange();

    public static void main(String[] args) {
        System.out.println("Hello, world!");
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Welcome to Kadaari Stock Exchange!");
        while(true) {
            System.out.println("Please input your action: ");
            String actionCode = inputScanner.next();
            switch (actionCode) {
                case "RC":
                    String companyName = inputScanner.next();
                    Integer countOfShares = inputScanner.nextInt();
                    Float initialPricePerShare = inputScanner.nextFloat();
                    Float initialCompanyWorth = inputScanner.nextFloat();
                    System.out.println(kadaariStockExchange.registerCompany(new Company(companyName, countOfShares, initialPricePerShare, initialCompanyWorth)));
                    break;
                case "RI":
                    String name = inputScanner.next();
                    System.out.println(kadaariStockExchange.registerInvestor(new Investor(name)));
                    break;
                case "Buy":
                    String stockName = inputScanner.next();
                    String investorName = inputScanner.next();
                    Integer quantity = inputScanner.nextInt();
                    buyForInvestor(stockName, investorName, quantity);
                    break;
                case "I":
                    String nameInvestor = inputScanner.next();
                    Investor investor = kadaariStockExchange.isInvestorRegistered(nameInvestor);
                    investor.getPortfolio();
                    break;
                case "C":
                    String nameCompany = inputScanner.next();
                    Company company = kadaariStockExchange.isCompanyRegistered(nameCompany);
                    company.getStats();
                    break;
                default:
                    System.out.println("In the default case!");
            }
        }
    }

    private static void buyForInvestor(String stockName, String investorName, Integer quantity) {
        Investor investor = kadaariStockExchange.isInvestorRegistered(investorName);
        if(investor == null){
            System.out.println("The investor " + investorName + " is not registered with KSE yet. Please register and try again.\n");
            return;
        }
        Company company = kadaariStockExchange.isCompanyRegistered(stockName);
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

    private static Float calculateBuyingMspForQuantity(Company company, Integer quantity) {
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
}