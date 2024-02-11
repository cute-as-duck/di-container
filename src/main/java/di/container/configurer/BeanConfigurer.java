package di.container.configurer;

import org.reflections.Reflections;

public interface BeanConfigurer {
    <T> Class<? extends T> getImplementationClass(Class<T> interfaceClass);
    Reflections getScanner();
}
