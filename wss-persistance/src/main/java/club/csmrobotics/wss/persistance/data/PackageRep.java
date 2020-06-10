package club.csmrobotics.wss.persistance.data;

import club.csmrobotics.wss.domain.data.Package;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface PackageRep extends CrudRepository<Package, Long> {
    Iterable<Package> findAllByDateBetween(Date lower, Date upper);

    Iterable<Package> findAllByDateBefore(Date date);

    Iterable<Package> findAllByDateAfter(Date date);
//    public Iterable<Package> findAllByDate_Day(Date date);
}
