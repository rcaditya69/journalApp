package com.projectAdi.Journal.service;

import com.projectAdi.Journal.entity.JournalEntry;
import com.projectAdi.Journal.entity.User;
import com.projectAdi.Journal.repository.JournalRepo;
import org.bson.types.ObjectId;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class JournalService {

    @Autowired
    private JournalRepo journalRepo;
    @Autowired UserService userService;

    @Transactional
    public void saveEntry(JournalEntry journalEntry,String userName){
        User user=userService.findByUsername(userName);
        journalEntry.setDate(LocalDateTime.now());
        JournalEntry saved=journalRepo.save(journalEntry);
        user.getJournalEntries().add(saved);
        userService.saveUser(user);


    }

    public void saveEntry(JournalEntry journalEntry){
        journalRepo.save(journalEntry);

    }
    public List<JournalEntry> getAll(){
       return journalRepo.findAll();
    }
    public Optional<JournalEntry> getDetails(ObjectId id){
        return journalRepo.findById(id);
    }
    public boolean delete(ObjectId id,String userName){
        boolean removed=false;
        User user=userService.findByUsername(userName);
        removed=user.getJournalEntries().removeIf(x->x.getId().equals(id));
        if (removed) {
            userService.saveUser(user);
            journalRepo.deleteById(id);
            return removed;
        }
     return removed;
    }




}
