package mak.parts.partssupply.repository;

import mak.parts.partssupply.model.Part;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends MongoRepository<Part, String> {
}
