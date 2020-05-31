package club.csmrobotics.wss.service;

import club.csmrobotics.wss.domain.data.Package;
import club.csmrobotics.wss.persistance.data.PackageRep;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
