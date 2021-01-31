/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Админ
 */
public class ArticleValidator implements Validator {

    @Override
    public boolean supports(Class clazz) {
      return FindForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
      FindForm article = (FindForm) target;
      if(article.getDescription()==""&&article.getMaxChangeDate()==""&&article.getMaxCreateDate()==""
      &&article.getMinChangeDate()==""&&article.getMinCreateDate()==""&&article.getSpecificChangeDate()==""
      &&article.getSpecificCreateDate()==""&&article.getTheme()=="")
        errors.rejectValue("MaxCreateDate", "test error", "enter anything");  
        System.out.println("jdhkj: "+article.getSpecificChangeDate());
      if((article.getSpecificChangeDate()!=""&&article.getMaxChangeDate()!="")||
          (article.getSpecificChangeDate()!=""&&article.getMinChangeDate()!=""))
       errors.rejectValue("MaxCreateDate", "test error", "test error");
    }
}
