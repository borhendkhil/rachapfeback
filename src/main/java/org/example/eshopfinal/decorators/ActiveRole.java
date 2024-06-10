package org.example.eshopfinal.decorators;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ActiveRole {
    String[] roles() default {};
}
