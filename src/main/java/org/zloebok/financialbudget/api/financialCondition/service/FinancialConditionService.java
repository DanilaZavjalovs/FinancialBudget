package org.zloebok.financialbudget.api.financialCondition.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.zloebok.financialbudget.finance.financialCondition.entity.FinancialConditionEntity;
import org.zloebok.financialbudget.finance.financialCondition.repository.FinancialConditionRepository;
import org.zloebok.financialbudget.user.entity.UserEntity;

@Service
@AllArgsConstructor
public class FinancialConditionService {
    private final FinancialConditionRepository repository;

    public void saveFinancialConditionByUser(UserEntity entity) {
        FinancialConditionEntity financialCondition = new FinancialConditionEntity();
        financialCondition.setUser(entity);

        repository.save(financialCondition);
    }
}
