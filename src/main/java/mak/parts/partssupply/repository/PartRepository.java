package mak.parts.partssupply.repository;

import mak.parts.partssupply.model.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends JpaRepository<Part, Integer> {
}
