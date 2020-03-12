package rclub.wss.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rclub.wss.domain.data.Package;
import rclub.wss.persistance.rep.PackageRep;

@Service
@AllArgsConstructor
public class PackageService {
    @Autowired
    private PackageRep packageRep;

    public Package addPackage(Package p) {
        return packageRep.save(p);
    }

    public Package getPackage(Long id) {
        return packageRep.findById(id).orElse(null);
    }
}
