package com.projectAdi.Journal.service;

import com.projectAdi.Journal.entity.User;
import com.projectAdi.Journal.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class UserService {
    @Autowired
    private UserRepo userRepo;
   // private static final Logger logger= LoggerFactory.getLogger(UserService.class);

   private static PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    public boolean saveNewUser(User user){
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER"));
            userRepo.save(user);
            return true;
        } catch (Exception e) {
            //logger.error("error {}",user.getUserName(),e);
            log.error("error for {}",user.getUserName());
            log.info("Hahaha");
            log.warn("Hahaha");
            log.debug("Hahaha");

            return false;
        }
    }
    public void saveUser(User user){
        userRepo.save(user);
    }
    public void saveAdmin(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER","ADMIN"));
        userRepo.save(user);
    }
    public List<User> getAll(){
        return userRepo.findAll();
    }
    public Optional<User> getDetails(ObjectId id){
        return userRepo.findById(id);
    }
    public void delete(ObjectId id){
        userRepo.deleteById(id);
    }
    public User findByUsername(String userName){
        return userRepo.findByUserName(userName);
    }
}
