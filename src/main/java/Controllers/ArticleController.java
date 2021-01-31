/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Article;
import Repository.ArticleRepository;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.json.*;

/**
 *
 * @author Админ
 */
@Controller
public class ArticleController {
 @Autowired
private DataSource dataSource;  
    @Autowired
    ArticleRepository arep;
    @GetMapping("/add")
  public String enter(Model model) {
      Article form = new Article();
      model.addAttribute("form", form);
       return "enter";
   }
   @PostMapping("/enter") 
    public String add(@ModelAttribute("form") Article form, Model model){
        form.setCreateDate(new Date());
        form.setLastChange(new Date());
        arep.save(form);
    model.addAttribute("createdate", form.getCreateDate());
    return "enter";
    }
     @GetMapping("/find")
    public String startFind(Model model){
      FindForm form = new FindForm();
      model.addAttribute("form1", form);  
      return "findArticle";  
    }
    @PostMapping("/find")
    public String startFind( 
            @ModelAttribute("form1")FindForm form, Model model, BindingResult result){
//        System.out.println(form.getDescription()+" : "+form.getTheme()+" : "+form.getSpecificChangeDate()+" : "+form.getMaxChangeDate()+" : "+
//                form.getMaxCreateDate()+" : "+form.getMinCreateDate()+" : "+form.getSpecificCreateDate()+" : "+form.getSpecificCreateDate());
//        System.out.println(bindingResult.getGlobalErrorCount());
ArticleValidator av = new ArticleValidator();
av.validate(form, result);
result.getAllErrors().forEach((t) -> {
    System.out.println(t.toString());});
        List<Article> ff = null;
        JdbcTemplate template = new JdbcTemplate(dataSource);
        String query = "Select * from article where";
        String description = " to_tsvector(description)"
                + "||to_tsvector(header)@@plainto_tsquery('"+form.getDescription()+"')";
        String theme = " and "
                + "to_tsvector(theme)@@plainto_tsquery('"+form.getTheme()+"')";
        String maxCreateDate = " and create_date < '" + form.getMaxCreateDate()+"'";
        String minCreateDate = " and create_date > '" + form.getMinCreateDate()+"'";
        String maxChangeDate = " and last_change < '" + form.getMaxChangeDate()+"'";
        String minChangeDate = " and last_change > '" + form.getMinChangeDate()+"'";
        String specificCreateDate = " and create_date='" + form.getSpecificCreateDate()+"'";
        String specificChangeDate = " and last_change='" + form.getSpecificChangeDate()+"'";
        if(form.getDescription()!=null)
            if(!form.getDescription().equals(""))
                query = query + description;
        if(form.getTheme()!=null)
            if(!form.getTheme().equals(""))
                query = query + theme;
        if(form.getSpecificCreateDate()!=null)
            if(!form.getSpecificCreateDate().equals(""))
               query = query + specificCreateDate; 
        if(form.getSpecificChangeDate()!=null)
            if(!form.getSpecificChangeDate().equals(""))
                query = query + specificChangeDate;
        if(form.getMaxCreateDate()!=null)
            if(!form.getMaxCreateDate().equals(""))
                query = query + maxCreateDate;
        if(form.getMinCreateDate()!=null)
            if(!form.getMinCreateDate().equals(""))
                query = query + minCreateDate;
        if(form.getMinCreateDate()!=null)
            if(!form.getMinCreateDate().equals(""))
                query = query + minCreateDate;
        if(form.getMaxChangeDate()!=null)
            if(!form.getMaxChangeDate().equals(""))
                query = query + maxChangeDate;
        if(form.getMinChangeDate()!=null)
            if(!form.getMinChangeDate().equals(""))
                query = query + minChangeDate;
     query = query.replaceAll("where\\sand", "where");
     query = query + ";";
     System.out.println(query);  
      if(form.getDescription()==""&&form.getMaxChangeDate()==""&&form.getMaxCreateDate()==""
      &&form.getMinChangeDate()==""&&form.getMinCreateDate()==""&&form.getSpecificChangeDate()==""
      &&form.getSpecificCreateDate()==""&&form.getTheme()=="")
          return "findArticle"; 
     ff = template.query(query, (rs, rowNum) -> {
         Article ar = new Article();
         ar.setCreateDate(rs.getDate("create_date"));
         ar.setDescription(rs.getString("description"));
         ar.setHeader(rs.getString("header"));
         ar.setId(rs.getInt("id"));
         ar.setLastChange(rs.getDate("last_change"));
         ar.setLinkTo(rs.getString("link_to"));
         ar.setTheme(rs.getString("theme"));
         return ar; //To change body of generated lambdas, choose Tools | Templates.
     });
     Article article = new Article();
     model.addAttribute("article", article);
     model.addAttribute("ff", ff);
     model.addAttribute(maxCreateDate, maxCreateDate);
     return "findArticle";   
    }
   
    @GetMapping("/findArticle{id}")
    String findById(@PathVariable("id") int id, Model model, @ModelAttribute("form1")FindForm form){
    Article article = arep.findById(new Long(id)).get();
    Article article1 = arep.findById(new Long(id)).get();
    System.out.println(article.getId());
    model.addAttribute("article", article);
        return "newhtml";  
    }
    
    @PostMapping("/saveArticle")
    public String saveArticle(@RequestBody String response, Model model){
        JSONObject obj = new JSONObject(response);
         arep.updateDescription(obj.getInt("id"), obj.getString("text"), new Date());
         System.out.println("response "+response);
       return "newhtml";
    }
      
    }

