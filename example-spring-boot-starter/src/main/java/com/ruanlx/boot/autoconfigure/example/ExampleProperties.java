package com.ruanlx.boot.autoconfigure.example;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * @author ruanlx
 * @ClassName ExampleProperties
 * @DateTime 2019/9/3 21:29
 * @Version 1.0
 */
@Data
@ConfigurationProperties(prefix = "com.ruanlx.boot.autoconfigure.example")
public class ExampleProperties {
    private String name;
    private int age;

    /**
     * 嵌套类
     * 该类下的字段前缀为com.ruanlx.boot.autoconfigure.example.sub1Example.XX
     */
    @Data
    public static class Sub1Example {
        private String sub1Name;
        private int sub1Age;
    }

    /**
     * @NestedConfigurationProperty 注解表示该字段非内部类嵌套字段
     */
    @Data
    public static class Sub2Example {
        @NestedConfigurationProperty
        private String sub2Name;
        @NestedConfigurationProperty
        private int sub2Age;
    }
}
