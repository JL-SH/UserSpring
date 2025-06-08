package org.jslh.userspring.user.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.jslh.userspring.user.dto.UserDTO;
import org.jslh.userspring.user.mapper.UserMapper;
import org.jslh.userspring.user.entity.User;
import org.jslh.userspring.user.service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final IUserService userService;
    private final UserMapper userMapper;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO dto) {
        User created = userService.createUser(userMapper.toEntity(dto));
        return ResponseEntity.ok(userMapper.toDto(created));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> listUsers() {
        List<UserDTO> dtoList = userService.userList()
                .stream()
                .map(userMapper::toDto)
                .toList();
        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/search")
    public ResponseEntity<UserDTO> getByEmail(@RequestParam String email) {
        return userService.findByEmail(email)
                .map(userMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
