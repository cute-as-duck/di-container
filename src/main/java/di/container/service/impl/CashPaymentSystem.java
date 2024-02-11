package di.container.service.impl;

import di.container.model.Gift;
import di.container.service.PaymentSystem;

public class CashPaymentSystem implements PaymentSystem {
    @Override
    public void pay(Gift gift) {
        System.out.println("Paying with cash...");
    }
}
