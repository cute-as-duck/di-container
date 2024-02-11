package di.container.service;

import di.container.model.Gift;
import di.container.model.Person;

public interface DeliverySystem {
    void deliver(Gift gift, Person person);
}
