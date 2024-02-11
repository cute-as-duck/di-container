package di.container.postprocessor;

import di.container.annotation.PostConstruct;
import lombok.SneakyThrows;

import java.lang.reflect.Method;

public class PostConstructBeanPostProcessor implements BeanPostProcessor{

    @Override
    @SneakyThrows
    public void process(Object bean) {
        for (Method method : bean.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(PostConstruct.class)) {
                method.invoke(bean);
            }
        }
    }
}
