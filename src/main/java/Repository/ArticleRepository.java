/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Controllers.FindForm;
import Entities.Article;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Админ
 */
@Repository
public interface ArticleRepository extends CrudRepository<Article, Long>{

@Query(value="INSERT INTO article (\n" +
"    create_date\n" +
"    , description\n" +
"    , last_change\n" +
"    , link_to\n" +
"    , theme\n" +
"    , header\n" +   
") values (?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery=true)
@Modifying
@Transactional
   public int saveItem(Date create, String desc, Date change, String link, String theme, String header);
   @Query(value="Select * from article where to_tsvector(description)||to_tsvector(header)@@"
           + "plainto_tsquery(?1)", nativeQuery=true)
   public ArrayList<Article> findByDescription(String description);
   @Query(value="Select * from article where to_tsvector(description)"
           + "||to_tsvector(header)@@ plainto_tsquery(?1) and to_tsvector(header)@@"
           + "plainto_tsquery(?2)", nativeQuery=true)
   public ArrayList<Article> findByDescriptionAndTheme(String desc, String theme);
   @Query(value="Select * from article where to_tsvector(theme)@@"
           + "plainto_tsquery(?1)", nativeQuery=true)
   public ArrayList<Article> findByTheme(String theme);
//   public ArrayList<Article> findByCreationDate
@Query(value="Update article Set description=?2, last_change=?3 where id=?1", nativeQuery=true)
@Modifying
@Transactional
   public int updateDescription(int id, String description, Date change);
}

