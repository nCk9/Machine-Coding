package org.cafe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CoffeeFactory {
    Map<String, Coffee> coffeesAvailable;

    @Autowired
    public CoffeeFactory(Map<String, Coffee> coffeesAvailable){
        this.coffeesAvailable = coffeesAvailable;
    }

    public Map<String, Coffee> getCoffeesList(){
        return coffeesAvailable;
    }

    public Coffee getCoffee(String coffeeName){
        return coffeesAvailable.get(coffeeName);
    }
}
