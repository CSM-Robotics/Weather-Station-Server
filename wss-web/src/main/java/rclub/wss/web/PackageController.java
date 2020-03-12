package rclub.wss.web;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rclub.wss.domain.data.Package;
import rclub.wss.service.PackageService;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class PackageController {
    @Autowired
    private PackageService service;

    @PostMapping("/add")
    public Package addPackage(@RequestBody Package p) {
        return service.addPackage(p);
    }

    @PostMapping("/getAll")
    public Iterable<Package> getAll() {
        return service.getAll();
    }
}
