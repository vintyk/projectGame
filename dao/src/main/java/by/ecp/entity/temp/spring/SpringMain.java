package by.ecp.entity.temp.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Vinty on 14.06.2017.
 */
public class SpringMain{
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("application_content.xml");

    }
}
