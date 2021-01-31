/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Админ
 */
public class EqualFieldsValidator implements ConstraintValidator<EqualFields, FindForm>{

    @Override
    public void initialize(EqualFields constraint) {
    }

    @Override
    public boolean isValid(FindForm ff, ConstraintValidatorContext cvc) {
        System.out.println(ff.getMaxChangeDate()+" : "+ff.getMaxCreateDate()+" : "+ff.getMinCreateDate());
        if(ff.getSpecificChangeDate()!=null&&ff.getMinChangeDate()!=null)
            return false;
        return true; 
    }
}
