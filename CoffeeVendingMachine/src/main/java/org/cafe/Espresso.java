package org.cafe;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class Espresso implements Coffee{
    @Setter
    private Float remainingQuantity = 100F;
    private final Float price = 350F;
}
