/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.util.Date;

/**
 *
 * @author Админ
 */
//специальный класс, содержащий html-форму поиска статей
public class FindForm {
    private String description="";
    private String theme="";
    private String maxCreateDate="";
    private String minCreateDate="";
    private String specificCreateDate="";
    private String maxChangeDate="";
    private String minChangeDate="";
    private String specificChangeDate="";

    public FindForm() {
    }
    
    public FindForm(String description, String theme, String maxCreateDate, String minCreateDate, String specificCreateDate, String maxChangeDate, String minChangeDate, String specificChangeDate) {
        this.description = description;
        this.theme = theme;
        this.maxCreateDate = maxCreateDate;
        this.minCreateDate = minCreateDate;
        this.specificCreateDate = specificCreateDate;
        this.maxChangeDate = maxChangeDate;
        this.minChangeDate = minChangeDate;
        this.specificChangeDate = specificChangeDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getMaxCreateDate() {
        return maxCreateDate;
    }

    public void setMaxCreateDate(String maxCreateDate) {
        this.maxCreateDate = maxCreateDate;
    }

    public String getMinCreateDate() {
        return minCreateDate;
    }

    public void setMinCreateDate(String minCreateDate) {
        this.minCreateDate = minCreateDate;
    }

    public String getSpecificCreateDate() {
        return specificCreateDate;
    }

    public void setSpecificCreateDate(String specificCreateDate) {
        this.specificCreateDate = specificCreateDate;
    }

    public String getMaxChangeDate() {
        return maxChangeDate;
    }

    public void setMaxChangeDate(String maxChangeDate) {
        this.maxChangeDate = maxChangeDate;
    }

    public String getMinChangeDate() {
        return minChangeDate;
    }

    public void setMinChangeDate(String minChangeDate) {
        this.minChangeDate = minChangeDate;
    }

    public String getSpecificChangeDate() {
        return specificChangeDate;
    }

    public void setSpecificChangeDate(String specificChangeDate) {
        this.specificChangeDate = specificChangeDate;
    }

}
