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
        int i=1;
        for(Map.Entry<String, Coffee> coffee: menu.entrySet()){
            System.out.println(Integer.toString(i) + ".) " + coffee.getKey() + " for Rs" + coffee.getValue().getCoffeePrice());
            i++;
        }
    }

    public Float buyCoffee(String coffeeRequired){
        Coffee coffee = coffeeFactory.getCoffee(coffeeRequired);
        return coffee.getCoffeePrice();
    }

    public Float reduceQuantity(String coffeeRequired){
        Coffee coffee = coffeeFactory.getCoffee(coffeeRequired);
        coffee.setRemainingQuantity(); //reduces the current quantity buy 0.5L
        return coffee.getRemainingQuantity();
    }
}
