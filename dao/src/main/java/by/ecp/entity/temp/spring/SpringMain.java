package by.ecp.entity.temp.spring;

import by.ecp.RootConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Vinty on 14.06.2017.
 */
public class SpringMain{
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(RootConfig.class);
    }
}
