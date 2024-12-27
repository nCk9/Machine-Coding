package org.cafe;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class Espresso extends Coffee{
    private Float remainingQuantity = 100F;
    private final Float price = 350F;

    @Override
    public Float getCoffeePrice(){
        return price;
    }

    @Override
    public Float getRemainingQuantity(){
        return remainingQuantity;
    }

    @Override
    public void setRemainingQuantity() {
        remainingQuantity -= 0.5F;
    }
}
