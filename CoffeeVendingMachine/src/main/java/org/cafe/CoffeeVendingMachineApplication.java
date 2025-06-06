package org.cafe;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class CoffeeVendingMachineApplication {
    public static void main(String[] args) {
        System.out.println("Welcome to Cafe nCk!! \nToday's menu is as follows:");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CoffeeVendingMachine coffeeVendingMachine = context.getBean(CoffeeVendingMachine.class);
        CoffeeVendingMachine coffeeVendingMachine1 = CoffeeVendingMachine.getCoffeeVendingMachineInstance();

        if(coffeeVendingMachine == coffeeVendingMachine1)
            System.out.println("Singleton initialization successful.");

        coffeeVendingMachine.getMenu();

        while (true) {
            try {
                System.out.println("Enter the name of the coffee you need:");
                Scanner inputScanner = new Scanner(System.in);
                String coffeeRequired = inputScanner.next();
                Float pricePaid = coffeeVendingMachine.buyCoffee(coffeeRequired);
                System.out.println("Price paid : " + pricePaid);
                Float remainingQuantity = coffeeVendingMachine.reduceQuantity(coffeeRequired);
                System.out.println("Quantity of " + coffeeRequired + " reduced to " + remainingQuantity.toString());
                System.out.println("Payment done, Purchase successful!!\nEnjoy your coffee.\n\n");
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}