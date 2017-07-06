package by.ecp.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by Vinty on 05.07.2017.
 */
@Aspect
public class SystemArchitecture {

    @Pointcut("within(by.ecp..*)")
    public void inDataAccessLayer() {}
}
