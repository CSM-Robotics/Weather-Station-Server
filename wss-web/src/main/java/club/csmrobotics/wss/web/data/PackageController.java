package club.csmrobotics.wss.web.data;

import club.csmrobotics.wss.domain.data.Package;
import club.csmrobotics.wss.service.data.PackageService;
import club.csmrobotics.wss.web.data.holder.DateRange;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wss")
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

    @GetMapping("/getAllByDateRange")
    public Iterable<Package> getAllByDateRange(@RequestBody DateRange range) {
        Iterable<Package> result;
        if (range.hasEnd() && range.hasStart()) {
            result = service.getAllByDateBetween(range.getStart(), range.getEnd());
        } else if (range.hasEnd()) {
            result = service.getAllByDateBefore(range.getEnd());
        } else if (range.hasStart()) {
            result = service.getAllByDateAfter(range.getStart());
        } else {
            result = service.getAll();
        }
        return result;
    }

}
