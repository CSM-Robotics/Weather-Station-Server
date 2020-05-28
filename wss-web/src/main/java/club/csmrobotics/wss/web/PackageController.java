package club.csmrobotics.wss.web;

import club.csmrobotics.wss.domain.data.Package;
import club.csmrobotics.wss.service.PackageService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wss")
@AllArgsConstructor
public class PackageController {
    private final PackageService service;

    @PreAuthorize("hasAnyRole('ADMIN', 'STATION')")
    @PostMapping("/addPackage")
    public Package addPackage(@RequestBody Package p) {
        return service.addPackage(p);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'STATION')")
    @PostMapping("/addPackages")
    public Iterable<Package> addPackages(@RequestBody Iterable<Package> packages) {
        return service.addAllPackages(packages);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'STATION')")
    @DeleteMapping("/deleteById")
    public Package deletePackage(@RequestBody Long id) {
        return service.deleteById(id);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'STATION')")
    @DeleteMapping("/deleteByIds")
    public Iterable<Package> deletePackages(@RequestBody Iterable<Long> ids) {
        return service.deleteByIds(ids);
    }

    @CrossOrigin(origins = "https://csmrobotics.club")
    @GetMapping("/getAll")
    public Iterable<Package> getAll() {
        return service.getAll();
    }
}
