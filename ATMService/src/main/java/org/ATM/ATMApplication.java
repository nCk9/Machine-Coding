package org.ATM;

import org.ATM.Service.BankIntegration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class ATMApplication {

    public static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    public static void main(String[] args) {
        System.out.println("Welcome to Canara Bank ATM.\nPlease swipe in your card (enter card number and Bank's name).");
        //to mock card reading behavior, we'll need the user to input card number and the Bank's name.
        Scanner inputScanner = new Scanner(System.in);

        //creating a factory for card doesn't make much sense here cuz differentiating if its an HDFC bank card or Axis bank card
        // doesn't make any significant difference for current use-case. So, we'll use the one created in the spring context.

        try {
            String cardNumber = inputScanner.next(); //    TODO: add validation for cardNumber
            String bankName = inputScanner.next(); //      TODO: add validation for bankName
            Card debitCard = context.getBean(Card.class);
            debitCard.setCardNumber(cardNumber); debitCard.setBankName(bankName);
            System.out.println("=========> Card details set successfully <==========");
            BankIntegrationFactory bankIntegrationFactory = context.getBean(BankIntegrationFactory.class); //check if this is required or only doing @Autowired works since we've added it as @Service, so bean should be there in the context
            BankIntegration bankService = bankIntegrationFactory.getBankIntegrator(bankName);
            Account accDetails = bankService.getAccountDetails(cardNumber);

            System.out.println("Account holder name: " + accDetails.getAccountHolderName() + "\n"
                    + "Account number: " + accDetails.getAccountNumber() + "\n"
                    + "Card number: " +  accDetails.getCardNumber() + "\n"
                    + "Balance available: " + accDetails.getBalanceAmount());

            System.out.println("Above are your bank details. Please enter the amount you desire to withdraw: ");
            String withdrawalAmount = inputScanner.next();
            //TODO: add validation to check if ATM has that amount and if customer has enough balance.

            bankService.debitAmount(withdrawalAmount);

            System.out.println("Please collect your cash.\nThanks for banking with us.");

        }catch (Exception e){
            System.out.println("Exception thrown:" + e.toString());
        }
    }
}