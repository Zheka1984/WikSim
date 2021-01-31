/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Админ
 */
@Entity
public class Article implements Serializable {

    public Article() {
    }

//    public Article(String theme, String header, String description, String linkTo, Date createDate, Date lastChange) {
//        this.theme = theme;
//        this.header = header;
//        this.description = description;
//        this.linkTo = linkTo;
//        this.createDate = createDate;
//        this.lastChange = lastChange;
//    }
    
    @Id
//   @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(columnDefinition="SERIAL")
    private long id;
   //тема статьи, выбирается из списка в ГУИ
    @Column(columnDefinition="TEXT")
   private String theme;
    //заголовок статьи
    @Column(columnDefinition="TEXT")
    private String header;
   //текст статьи, или описание или внешнего ресурса
   @Column(columnDefinition="TEXT")
   private String description;
   //url ссылка на статью в интернете
    @Column(columnDefinition="TEXT")
   private String linkTo;
    //дата создания записи
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    //время последнего изменения записи
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastChange;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLinkTo() {
        return linkTo;
    }

    public void setLinkTo(String linkTo) {
        this.linkTo = linkTo;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastChange() {
        return lastChange;
    }

    public void setLastChange(Date lastChange) {
        this.lastChange = lastChange;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
    
}
