package di.container.service.impl;

import di.container.annotation.Inject;
import di.container.model.Gift;
import di.container.model.Person;
import di.container.service.GiftChooseHelper;
import di.container.service.Recommender;

public class SmartGiftChooseHelper implements GiftChooseHelper {

    @Inject
    private Recommender recommender;

    @Override
    public Gift choose(Person person) {
        return new Gift("Smart watches", 10000);
    }
}
