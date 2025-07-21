package com.projectAdi.Journal.repository;

import com.projectAdi.Journal.entity.ConfigJournalEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigJournalRepo extends MongoRepository<ConfigJournalEntity, ObjectId> {
}
