package by.ecp.entity.temp.spring;

import by.ecp.TestConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Vinty on 14.06.2017.
 */
public class SpringMain{
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(TestConfig.class);
    }
}
