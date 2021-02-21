/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Entities.User1;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author nalog_ot01
 */
public interface UserRepository extends PagingAndSortingRepository<User1, Long> {
    Optional<User1> findByEmail(String email);
    Page<User1> findByEmailContains(String email, Pageable pageable);
    Page<User1> findAllByEmail(String email, Pageable pageable);
    Page<User1> findAllByEmailContainsAndEmail(String email, String auth, Pageable pageable);

    Boolean existsByEmail(String email);
}