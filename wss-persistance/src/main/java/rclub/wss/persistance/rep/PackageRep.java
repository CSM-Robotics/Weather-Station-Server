package rclub.wss.persistance.rep;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rclub.wss.persistance.dto.PackageDTO;

@Repository
public interface PackageRep extends CrudRepository<PackageDTO, Integer> {
}
