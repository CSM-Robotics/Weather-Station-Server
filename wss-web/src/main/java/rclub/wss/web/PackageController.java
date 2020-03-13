package rclub.wss.web;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import rclub.wss.domain.data.Package;
import rclub.wss.service.PackageService;

@RestController
//@RequestMapping("/api")
@AllArgsConstructor
public class PackageController {
    private final PackageService service;

    @PostMapping("/add")
    public Package addPackage(@RequestBody Package p) {
        return service.addPackage(p);
    }

    @GetMapping("/getAll")
    public Iterable<Package> getAll() {
        return service.getAll();
    }
}
