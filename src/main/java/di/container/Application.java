package di.container;

import di.container.client.NewYearOrganizer;
import di.container.context.ApplicationContext;
import di.container.factory.BeanFactory;

public class Application {

    public ApplicationContext run() {
        ApplicationContext applicationContext = new ApplicationContext();
        BeanFactory beanFactory = new BeanFactory(applicationContext);
        applicationContext.setBeanFactory(beanFactory);

        return applicationContext;
    }

    public static void main(String[] args) {
        Application application = new Application();
        ApplicationContext applicationContext = application.run();

        NewYearOrganizer newYearOrganizer = applicationContext.getBean(NewYearOrganizer.class);
        newYearOrganizer.prepareToCelebration();

    }
}
