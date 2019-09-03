package com.ruanlx.boot;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author ruanlx
 * @ClassName MyselfBootApplication
 * @DateTime 2019/9/1 13:23
 * @Version 1.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MyselfBootApplication {

    /**
     * springApplication.run,可以在Spring启动时功能扩展
     * @param primarySource
     * @param args
     * @return
     */
    public static ConfigurableApplicationContext run(Class<?> primarySource, String[] args) {
        SpringApplication springApplication = getSpringApplication(new Class[] {primarySource});
        return springApplication.run(args);
    }

    public static ConfigurableApplicationContext run(Class<?>[] primarySources, String[] args) {
        SpringApplication springApplication = getSpringApplication(primarySources);
        return springApplication.run(args);
    }

    public static SpringApplication getDefaultSpringApplication(Class<?> primarySource) {
        return getSpringApplication(new Class[] {primarySource});
    }

    private static SpringApplication getSpringApplication(Class<?>[] primarySources) {
        SpringApplication springApplication = new SpringApplication(primarySources);
        springApplication.setBanner(new MyselfBootBanner());
        return springApplication;
    }
}
