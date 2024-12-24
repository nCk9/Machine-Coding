package org.KSE;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class KadaariStockExchangeApplication {
    static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    static KadaariStockExchange kadaariStockExchange = context.getBean(KadaariStockExchange.class);
    public static void main(String[] args) {
        System.out.println("Hello, world!");
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Welcome to Kadaari Stock Exchange!");
        while(true) {
            System.out.println("Please input your action: ");
            String actionCode = inputScanner.next();
            switch (actionCode.toLowerCase()) {
                case "rc": kadaariStockExchange.registerCompany(inputScanner);
                    break;
                case "ri": kadaariStockExchange.registerInvestor(inputScanner);
                    break;
                case "buy": kadaariStockExchange.buyForInvestor(inputScanner);
                    break;
                case "sell": kadaariStockExchange.sellForInvestor(inputScanner);
                    break;
                case "i": kadaariStockExchange.getInvestorDetails(inputScanner);
                    break;
                case "c": kadaariStockExchange.getCompanyDetails(inputScanner);
                    break;
                case "exit":
                    break;
                default:
                    System.out.println("In the default case! Please put correct input.");
            }
        }
    }

}