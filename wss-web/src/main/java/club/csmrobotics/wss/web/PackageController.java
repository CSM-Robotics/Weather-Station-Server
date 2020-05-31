package club.csmrobotics.wss.web;

import club.csmrobotics.wss.domain.data.Package;
import club.csmrobotics.wss.service.PackageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wss")
@AllArgsConstructor
public class PackageController {
    private final PackageService service;

    @PostMapping("/addPackage")
    public Package addPackage(@RequestBody Package p) {
        return service.addPackage(p);
    }

    @PostMapping("/addPackages")
    public Iterable<Package> addPackages(@RequestBody Iterable<Package> packages) {
        return service.addAllPackages(packages);
    }

    @DeleteMapping("/deleteById")
    public Package deletePackage(@RequestBody Long id) {
        return service.deleteById(id);
    }

    @DeleteMapping("/deleteByIds")
    public Iterable<Package> deletePackages(@RequestBody Iterable<Long> ids) {
        return service.deleteByIds(ids);
    }

    @GetMapping("/getAll")
    public Iterable<Package> getAll() {
        return service.getAll();
    }
}
