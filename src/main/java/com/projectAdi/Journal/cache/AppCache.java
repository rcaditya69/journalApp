package com.projectAdi.Journal.cache;

import com.projectAdi.Journal.entity.ConfigJournalEntity;
import com.projectAdi.Journal.repository.ConfigJournalRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppCache {
    @Autowired
    ConfigJournalRepo journalRepo;
    public Map<String,String>cache=new HashMap<>();
    @PostConstruct
    public void init(){
        List<ConfigJournalEntity> entity=journalRepo.findAll();
       for(ConfigJournalEntity configJournalEntity:entity){
           cache.put(configJournalEntity.getKey(), configJournalEntity.getValue());
       }
    }
}
