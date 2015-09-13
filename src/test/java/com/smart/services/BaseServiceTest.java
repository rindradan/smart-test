package com.smart.services;

import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseServiceTest extends TestCase
{
    private ApplicationContext applicationContext;

    protected void setUp() throws Exception
    {
        super.setUp();
        applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
    }

    public ApplicationContext getApplicationContext()
    {
        return applicationContext;
    }
}
