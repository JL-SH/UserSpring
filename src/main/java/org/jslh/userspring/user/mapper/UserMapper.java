package org.jslh.userspring.user.mapper;

import org.jslh.userspring.user.dto.UserDTO;
import org.jslh.userspring.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toEntity(UserDTO dto);
    UserDTO toDto(User entity);
}
