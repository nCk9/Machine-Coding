package org.cafe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.Map;

@Component
public class CoffeeVendingMachine {

    @Autowired
    CoffeeFactory coffeeFactory;

    public void getMenu(){
        Map<String, Coffee> menu =  coffeeFactory.getCoffeesList();
        for(Map.Entry<String, Coffee> coffee: menu.entrySet()){
            if(coffee.getValue() instanceof Espresso){
                Espresso espresso = (Espresso) coffee.getValue();
            System.out.println(coffee.getKey() + " for Rs" + espresso.getPrice());
            }
        }
    }

    public Float buyCoffee(String coffeeRequired){
        Coffee coffee = coffeeFactory.getCoffee(coffeeRequired);
        if(coffee instanceof Espresso){
            return ((Espresso) coffee).getPrice();
        }
        return 0F;
    }

    public Float reduceQuantity(String coffeeRequired){
        Coffee coffee = coffeeFactory.getCoffee(coffeeRequired);
        if(coffee instanceof Espresso){
            Float remQuantity = (((Espresso) coffee).getRemainingQuantity());
            ((Espresso) coffee).setRemainingQuantity(remQuantity-0.5F);
            return ((Espresso) coffee).getRemainingQuantity();
        }
        return 0F;
    }
}
