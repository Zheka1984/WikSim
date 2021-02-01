/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Entities.FileDB;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Админ
 */
@Repository
public interface FileRepository extends CrudRepository<FileDB, Long>{
    @Query(value="Insert into filedb (description, file) values (?1, ?2)", nativeQuery = true)
    public void save(String s, byte[] b);
    
    
}
