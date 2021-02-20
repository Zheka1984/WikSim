/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Repository.UserRepository;
import java.util.Arrays;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
/**
 *
 * @author nalog_ot01
 */
@Service
public class UserService implements UserDetailsService {

   private final UserRepository repository;

   public UserService(UserRepository repository) {
       this.repository = repository;
   }

   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = repository.findByEmail(username).orElseThrow(() -> new RuntimeException("User not found: " + username));
       GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().name());
       return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), Arrays.asList(authority));
   }
}
