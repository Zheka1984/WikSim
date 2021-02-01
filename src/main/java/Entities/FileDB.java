/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Админ
 */
@Entity
public class FileDB implements Serializable {
    @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(columnDefinition="SERIAL")
    private long id;
    //описание файла, сохраняемого в базу данных
   @Column(columnDefinition="TEXT")
    private String description;
   //название файла
   private String fileName;
   //сохраняемый в таблицу файл в виде массива байт
   private byte[] file; 

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
   
}
