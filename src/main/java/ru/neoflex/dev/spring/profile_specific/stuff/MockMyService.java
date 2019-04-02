
package ru.neoflex.dev.spring.profile_specific.stuff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@Profile({"mock","test"})
public class MockMyService implements MyService, EnvironmentAware {

    String status = "In mock";
    private boolean inTest;


    @Override
    public String generateString() {
       if (inTest == true) {
           status +=" In test";
       }
        return status;
    }

    @Override
    public void setEnvironment(Environment environment) {
        String[] profiles = environment.getActiveProfiles();
        if (Arrays.asList(profiles).contains("test"))
            inTest = true;

    }
}