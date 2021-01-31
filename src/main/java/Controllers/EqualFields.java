/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import org.springframework.messaging.handler.annotation.Payload;

/**
 *
 * @author Админ
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EqualFieldsValidator.class})
public @interface EqualFields {
    String message() default "{com.dolszewski.blog.EqualPasswords.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
