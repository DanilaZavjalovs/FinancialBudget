package org.zloebok.financialbudget.user.service;

import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.zloebok.financialbudget.api.financialCondition.service.FinancialConditionService;
import org.zloebok.financialbudget.exception.user.UserConstraintException;
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

    public void saveUser(UserDto user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));

            UserEntity entity = userMapper.DtoToEntity(user);
            userRepository.save(entity);

            financialConditionService.saveFinancialConditionByUser(entity);
        } catch (DataIntegrityViolationException dataIntegrityViolationException) {
            throw new UserConstraintException("User constraint exception", dataIntegrityViolationException);
        }
    }
}
