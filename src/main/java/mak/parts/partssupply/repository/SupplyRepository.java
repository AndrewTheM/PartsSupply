package mak.parts.partssupply.repository;

import mak.parts.partssupply.model.Supply;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplyRepository extends MongoRepository<Supply, String> {
}
