package com.ruanlx.boot.spring;

import org.springframework.core.env.Environment;

import javax.annotation.Resource;

/**
 * @author ruanlx
 * @ClassName EnvironmentProvider
 * @DateTime 2019/8/31 16:26
 * @Version 1.0
 */
public class EnvironmentProvider {

    @Resource
    Environment environment;



}
