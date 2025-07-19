package com.projectAdi.Journal.repository;

import com.projectAdi.Journal.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface JournalRepo extends MongoRepository<JournalEntry, ObjectId> {
}
