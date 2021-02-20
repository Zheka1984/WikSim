/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author nalog_ot01
 */
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {

    RoleEntity findByName(String name);
}
