package ru.neoflex.dev.spring.profile_specific.stuff;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles({"mock","test"})
public class MockMyServiceInTestModeTest {

    @Autowired
    private MyService myService;


    @Test
    public void testMyService() {
        Assert.assertEquals("In mock In test", myService.generateString());
    }
}
