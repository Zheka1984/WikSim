/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Article;
import Entities.FileDB;
import Repository.ArticleRepository;
import Repository.FileRepository;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Админ
 */
@Controller
public class FileController {
    @Autowired
    private ArticleRepository rep;
    @Autowired
    private FileRepository fr;
    @GetMapping("/saveFile")
    private String saveFile(Model model){
//        String path = new String();
//        model.addAttribute("path", path);
        return "saveFile";
    }
    @PostMapping("/saveFile")
    private String saveFile(@RequestParam("file") MultipartFile file) 
            throws FileNotFoundException, IOException{        
        byte[] b = file.getBytes();
        fr.save("новый файл", b);
        return "saveFile";
    }
    //отображение страницы для поиска файлов
    @GetMapping("/findFiles")
    private String findFiles(){
//      Iterable<FileDB> list = new ArrayList<>();
//        model.addAttribute("list", list);
        return "findFile";
    }
    @PostMapping("/findFiles")
    private String findFiles(Model model){
        List<FileDB> list = new ArrayList<>();
        Iterable<FileDB> iter = fr.findAll();
        iter.forEach((t) -> {list.add(t);
        });
        model.addAttribute("list", list);
        return "findFile";
    }
    //скачивание файла
    @GetMapping("/getFile{id}")
    private ResponseEntity<ByteArrayResource> getFile(@PathVariable("id") int id){
        byte[] arr;
        ByteArrayResource resource = null;
        try{
       arr = fr.findById((long)id).get().getFile();
        resource = new ByteArrayResource(arr);}
        catch(NoSuchElementException e){
            e.printStackTrace();
        }
       
        return ResponseEntity.ok()
                  .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" 
                          + fr.findById((long)id).get().getFileName())
                // Content-Type
//                .contentType(mediaType) //
//                // Content-Lengh
//                .contentLength(data.length) //
                .body(resource);
    }
//    @GetMapping("/downloadFile")
//    private String downloadFile(){
//        
//    }
}
