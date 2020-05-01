package club.csmrobotics.wss.security.controller;

import club.csmrobotics.wss.security.dao.UserRep;
import club.csmrobotics.wss.security.domain.User;
import club.csmrobotics.wss.security.domain.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    private final UserRep userRep;
    private final PasswordEncoder passwordEncoder;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody UserDTO userDTO) {
        try {
            var user = new User();

            user.setUsername(userDTO.getUsername());
            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            user.setRoles(userDTO.getRoles());
            user.setPermissions("");
            user.setAccountNonExpired(true);
            user.setAccountNonLocked(true);
            user.setCredentialsNonExpired(true);
            user.setEnabled(true);
            userRep.save(user);
            return ResponseEntity.ok("Successful" + userDTO.toString());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.ok("Failed" + userDTO.toString());
        }
    }
}
