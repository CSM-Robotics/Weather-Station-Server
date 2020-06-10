package club.csmrobotics.wss.service.data;

import club.csmrobotics.wss.domain.data.Package;
import club.csmrobotics.wss.persistance.data.PackageRep;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class PackageService {
    private final PackageRep packageRep;

    @PreAuthorize("hasAnyRole('ADMIN', 'STATION')")
    public Package addPackage(Package p) {
        return packageRep.save(p);
    }

    public Package getPackage(Long id) {
        return packageRep.findById(id).orElse(null);
    }

    public Iterable<Package> getAll() {
        return packageRep.findAll();
    }

    public Iterable<Package> getAllByDateBetween(Date start, Date end) {
        return packageRep.findAllByDateBetween(start, end);
    }
    public Iterable<Package> getAllByDateBefore(Date date){
        return packageRep.findAllByDateBefore(date);
    }
    public Iterable<Package> getAllByDateAfter(Date date){
        return packageRep.findAllByDateAfter(date);
    }
//    public Iterable<Package> getAllByDate_Day(Date date){
//        return packageRep.findAllByDate_Day(date);
//    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    public Package deleteById(Long id) {
        Package pack = packageRep.findById(id).orElseThrow();
        packageRep.deleteById(id);
        return pack;
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'STATION')")
    public Iterable<Package> addAllPackages(Iterable<Package> packages) {
        return packageRep.saveAll(packages);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    public Iterable<Package> deleteByIds(Iterable<Long> ids) {
        var packages = new ArrayList<Package>();
        ids.forEach(id -> {
            try {
                packages.add(deleteById(id));
            } catch (NoSuchElementException ignore) {}
        });
        return packages;
    }
}
