//package com.projectAdi.Journal.controller;
//
//import com.projectAdi.Journal.entity.JournalEntry;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/journal")
//public class journalController {
//    private Map<Long,JournalEntry> journal=new HashMap<>();
//    @GetMapping
//    public List<JournalEntry> getall(){
//        return new ArrayList<>(journal.values());
//    }
//    @PostMapping
//    public boolean createEntry(@RequestBody JournalEntry entry){
//        journal.put(entry.getId(),entry);
//        return true;
//    }
//    @GetMapping("/id/{id}")
//    public JournalEntry update(@PathVariable long id){
//        return journal.get(id);
//    }
//    @DeleteMapping("/id/{id}")
//    public JournalEntry delete(@PathVariable long id){
//       return journal.remove(id);
//    }
//    @PutMapping("/id/{id}")
//    public JournalEntry updateJournal(@PathVariable long id, @RequestBody JournalEntry entry){
//        return journal.put(id,entry);
//    }
//}
