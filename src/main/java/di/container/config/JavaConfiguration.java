package di.container.config;

import di.container.service.PaymentSystem;
import di.container.service.impl.CashPaymentSystem;

import java.util.Map;

public class JavaConfiguration implements Configuration{
    @Override
    public String getPackageToScan() {
        return "di.container";
    }

    @Override
    public Map<Class, Class> interfaceToImplementations() {
        return Map.of(PaymentSystem.class, CashPaymentSystem.class);
    }
}
