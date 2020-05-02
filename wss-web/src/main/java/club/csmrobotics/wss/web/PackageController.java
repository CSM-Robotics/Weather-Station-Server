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

    @CrossOrigin(origins = "https://csmrobotics.club")
    @GetMapping("/getAll")
    public Iterable<Package> getAll() {
        return service.getAll();
    }
}

//[
//    {
//        "id": 1,
//        "temp": 9.0,
//        "pressPa": 7.0,
//        "hum": 5.0,
//        "count": 3,
//        "packetNum": 6,
//        "deviceInfo": 4,
//        "version": 0,
//        "tvocpp": 8.0,
//        "co2ppm": 2.0
//    }
//]