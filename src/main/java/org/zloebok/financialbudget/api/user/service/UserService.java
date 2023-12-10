package org.zloebok.financialbudget.api.user.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.zloebok.financialbudget.user.dto.UserDto;
import org.zloebok.financialbudget.user.mapper.UserMapper;
import org.zloebok.financialbudget.user.repository.UserRepository;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDto getUserByUsername(String username) {
        return userMapper.EntityToDto(userRepository.findByUsername(username).get());
    }

    public void saveUser(UserDto user) {
        userRepository.save(userMapper.DtoToEntity(user));
    }

}
