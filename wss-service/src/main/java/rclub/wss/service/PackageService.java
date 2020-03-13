package rclub.wss.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rclub.wss.domain.data.Package;
import rclub.wss.persistance.rep.PackageRep;

@Service
@AllArgsConstructor
public class PackageService {
    private final PackageRep packageRep;
//
//    @PostConstruct
//    public void initPackages(){
//        packageRep.saveAll(Stream.of(
//
//                ).collect(Collectors.toList()));
//    }

    public Package addPackage(Package p) {
        return packageRep.save(p);
    }

    public Package getPackage(Long id) {
        return packageRep.findById(id).orElse(null);
    }

    public Iterable<Package> getAll() {
        return packageRep.findAll();
    }
}
