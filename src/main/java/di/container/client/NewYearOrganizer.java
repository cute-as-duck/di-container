package di.container.client;

import di.container.annotation.Inject;
import di.container.model.Person;
import di.container.service.GiftPresenter;

public class NewYearOrganizer {

    @Inject
    private GiftPresenter giftPresenter;

    public void prepareToCelebration() {
        Person friend = new Person("Ariel");
        giftPresenter.present(friend);
    }
}
