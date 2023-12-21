package org.zloebok.financialbudget.api.user.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;
import org.zloebok.financialbudget.api.financialCondition.service.FinancialConditionService;
import org.zloebok.financialbudget.exception.user.UserConstraintValidationException;
import org.zloebok.financialbudget.exception.user.UserNotFoundException;
import org.zloebok.financialbudget.user.dto.UserDto;
import org.zloebok.financialbudget.user.entity.UserEntity;
import org.zloebok.financialbudget.user.mapper.UserMapper;
import org.zloebok.financialbudget.user.repository.UserRepository;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final FinancialConditionService financialConditionService;

    public UserDto getUserByUsername(String username) {
        return userMapper.EntityToDto
                (userRepository.findByUsername(username)
                        .orElseThrow(() -> new UserNotFoundException("User did not find by username: " + username)));
    }

    public void saveUser(UserDto user) {
        try {
            if (user.getPassword() == null) {
                throw new UserConstraintValidationException("User can not be null");
            }

            user.setPassword(passwordEncoder.encode(user.getPassword()));

            UserEntity entity = userMapper.DtoToEntity(user);
            userRepository.save(entity);

            financialConditionService.saveFinancialConditionByUser(entity);
        } catch (TransactionSystemException transactionSystemException) {
            throw new UserConstraintValidationException("User validation exception", transactionSystemException);
        }
    }
}
