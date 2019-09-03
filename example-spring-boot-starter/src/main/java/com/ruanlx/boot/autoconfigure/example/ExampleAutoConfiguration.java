package com.ruanlx.boot.autoconfigure.example;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ruanlx
 * @ClassName ExampleAutoConfiguration
 * @DateTime 2019/9/3 22:34
 * @Version 1.0
 */
@Configuration
@ConditionalOnProperty(prefix = "example.configuration", name = "enable", havingValue = "true", matchIfMissing = false)
@EnableConfigurationProperties(ExampleProperties.class)
public class ExampleAutoConfiguration {

    private ExampleProperties exampleProperties;

    public ExampleAutoConfiguration(ExampleProperties exampleProperties) {
        this.exampleProperties = exampleProperties;
    }

    @Bean(name = "userInfo")
    public UserInfo userInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setName(exampleProperties.getName());
        userInfo.setAge(exampleProperties.getAge());
        return userInfo;
    }
}
