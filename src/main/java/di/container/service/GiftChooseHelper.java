package di.container.service;

import di.container.model.Gift;
import di.container.model.Person;

public interface GiftChooseHelper {
    Gift choose(Person person);
}
