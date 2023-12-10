package org.zloebok.financialbudget.user.mapper;

import org.springframework.stereotype.Component;
import org.zloebok.financialbudget.user.dto.UserDto;
import org.zloebok.financialbudget.user.entity.UserEntity;

@Component
public class UserMapper {
    public UserEntity DtoToEntity (UserDto dto) {
        UserEntity entity = new UserEntity();

        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setEmail(dto.getEmail());
        entity.setRole(dto.getRole());

        return entity;
    }

    public UserDto EntityToDto (UserEntity entity) {
        UserDto dto = new UserDto();

        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setEmail(entity.getEmail());
        dto.setRole(entity.getRole());

        return dto;
    }
}
