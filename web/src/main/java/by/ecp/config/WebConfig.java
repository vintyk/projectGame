package by.ecp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Vinty on 25.06.2017.
 */
@Configuration
@ComponentScan(basePackages = "by.ecp")
@EnableWebMvc
@Import(value = {InternationalizationConfig.class, ThymeleafConfig.class})
public class WebConfig {

}
