package top.greenyi.green.common.configuration;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * jvm监控配置类
 * @author Green
 */
@Configuration
public class JvmMonitorConfig {
    @Value("${spring.application.name}")
    private String applicationName;

    @Bean
    public MeterRegistryCustomizer<MeterRegistry> getConfig() {
        return registry -> registry.config().commonTags("application", applicationName);
    }
}
