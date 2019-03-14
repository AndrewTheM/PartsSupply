package mak.parts.partssupply.repository;

import mak.parts.partssupply.model.Supplier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends MongoRepository<Supplier, String> {
}
