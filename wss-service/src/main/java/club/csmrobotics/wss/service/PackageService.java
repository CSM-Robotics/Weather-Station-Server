package club.csmrobotics.wss.service;

import club.csmrobotics.wss.domain.data.Package;
import club.csmrobotics.wss.persistance.data.PackageRep;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PackageService {
    private final PackageRep packageRep;

    public Package addPackage(Package p) {
        return packageRep.save(p);
    }

    public Package getPackage(Long id) {
        return packageRep.findById(id).orElse(null);
    }

    public Iterable<Package> getAll() {
        return packageRep.findAll();
    }

    public Package deleteById(Long id){
        Package pack = packageRep.findById(id).orElseThrow();
        packageRep.deleteById(id);
        return pack;
    }
}
