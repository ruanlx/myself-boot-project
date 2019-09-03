package com.ruanlx.boot.autoconfigure.example;

import org.junit.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.junit.Assert.*;

/**
 * @author ruanlx
 * @date 2019/9/3 23:22
 */
public class ExampleAutoConfigurationTest {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner().
            withConfiguration(AutoConfigurations.of(ExampleAutoConfiguration.class));

    @Test
    public void exampleAutoConfigurationTest1() {
        contextRunner.withUserConfiguration(ExampleAutoConfiguration.class).
                withPropertyValues("example.configuration.enable=false").
                run((context -> {
            try {
                ExampleAutoConfiguration bean = context.getBean(ExampleAutoConfiguration.class);
            } catch (Exception e) {
                assertTrue(e instanceof NoSuchBeanDefinitionException);
            }
        }));
    }

    @Test
    public void exampleAutoConfigurationTest2() {
        contextRunner.withUserConfiguration(ExampleAutoConfiguration.class).
                withPropertyValues("example.configuration.enable=true").
                run((context -> {
                    ExampleAutoConfiguration bean = context.getBean(ExampleAutoConfiguration.class);
                    assertTrue(bean != null);
                    UserInfo userInfo = bean.userInfo();
                    assertTrue(userInfo != null);
                }));
    }

    @Test
    public void exampleAutoConfigurationTest3() {
        contextRunner.withUserConfiguration(ExampleAutoConfiguration.class).
                withPropertyValues("example.configuration.enable=true").
                withPropertyValues("com.ruanlx.boot.autoconfigure.example.name=ruanlx").
                withPropertyValues("com.ruanlx.boot.autoconfigure.example.age=20").
                run((context -> {
            ExampleAutoConfiguration bean = context.getBean(ExampleAutoConfiguration.class);
            assertTrue(bean != null);
            UserInfo userInfo = bean.userInfo();
            assertTrue(userInfo != null);
            System.out.println(userInfo);
            assertEquals(userInfo.getName(), "ruanlx");
            assertEquals(userInfo.getAge(), 20);
        }));
    }

}