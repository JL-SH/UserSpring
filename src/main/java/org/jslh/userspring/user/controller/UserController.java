package org.jslh.userspring.user.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.jslh.userspring.user.entity.User;
import org.jslh.userspring.user.service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User newUser = userService.createUser(user);
        return ResponseEntity.ok(newUser);
    }

    @GetMapping
    public ResponseEntity<List<User>> userList() {
        return ResponseEntity.ok(userService.userList());
    }

    @GetMapping("/buscar")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {
        return userService.findByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}