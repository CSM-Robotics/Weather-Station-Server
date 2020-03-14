package rclub.wss.persistance.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rclub.wss.domain.data.Package;

@Repository
public interface PackageRep extends CrudRepository<Package, Long> {
}
