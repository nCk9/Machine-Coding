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
                case "RC": kadaariStockExchange.registerCompany(inputScanner);
                    break;
                case "RI": kadaariStockExchange.registerInvestor(inputScanner);
                    break;
                case "Buy": kadaariStockExchange.buyForInvestor(inputScanner);
                    break;
                case "Sell": kadaariStockExchange.sellForInvestor(inputScanner);
                    break;
                case "I": kadaariStockExchange.getInvestorDetails(inputScanner);
                    break;
                case "C": kadaariStockExchange.getCompanyDetails(inputScanner);
                    break;
                default:
                    System.out.println("In the default case!");
            }
        }
    }

}