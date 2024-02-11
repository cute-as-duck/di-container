package di.container.service;

import di.container.annotation.Inject;
import di.container.annotation.PostConstruct;
import di.container.model.Gift;
import di.container.model.Person;

public class GiftPresenter {

    @Inject
    private GiftChooseHelper giftChooseHelper;

    @Inject
    private PaymentSystem paymentSystem;

    @Inject
    private DeliverySystem deliverySystem;

    @PostConstruct
    public void postConstruct() {
        System.out.println("Gift presenter has been initialized!");
    }

    public void present(Person person) {
        Gift gift = giftChooseHelper.choose(person);
        System.out.println(String.format("Gift has been chosen for: %s", gift.name()));
        paymentSystem.pay(gift);
        deliverySystem.deliver(gift, person);
    }
}
