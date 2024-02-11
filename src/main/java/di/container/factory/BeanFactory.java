package di.container.factory;

import di.container.annotation.Inject;
import di.container.config.Configuration;
import di.container.config.JavaConfiguration;
import di.container.configurer.BeanConfigurer;
import di.container.configurer.JavaBeanConfigurer;
import di.container.context.ApplicationContext;
import lombok.Getter;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.Arrays;

public class BeanFactory {

    @Getter
    private final BeanConfigurer beanConfigurer;
    private final Configuration configuration;
    private ApplicationContext applicationContext;

    public BeanFactory(ApplicationContext applicationContext) {
        this.configuration = new JavaConfiguration();
        this.beanConfigurer = new JavaBeanConfigurer(configuration.getPackageToScan(), configuration.interfaceToImplementations());
        this.applicationContext = applicationContext;
    }

    @SneakyThrows
    public <T> T getBean(Class<T> clazz) {
        Class <? extends T> implementationClass = clazz;
        if (implementationClass.isInterface()) {
            implementationClass = beanConfigurer.getImplementationClass(implementationClass);
        }
        T bean = implementationClass.getDeclaredConstructor().newInstance();

        for (Field field : Arrays.stream(implementationClass.getDeclaredFields()).filter(field -> field.isAnnotationPresent(Inject.class)).toList()) {
            field.setAccessible(true);
            field.set(bean, applicationContext.getBean(field.getType()));
        }
        return bean;
    }
}
