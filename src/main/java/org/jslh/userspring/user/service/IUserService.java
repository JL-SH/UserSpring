package org.jslh.userspring.user.service;

import org.jslh.userspring.user.entity.User;
import java.util.List;
import java.util.Optional;

public interface IUserService {
    User createUser(User usuario);
    Optional<User> findByEmail(String email);
    List<User> userList();
}
