package org.ATM;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Card {
    public String cardNumber;
    public String BankName;
}
