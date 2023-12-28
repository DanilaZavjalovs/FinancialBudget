package org.zloebok.financialbudget.finance.income.mapper;

import org.springframework.stereotype.Component;
import org.zloebok.financialbudget.finance.income.dto.IncomeDto;
import org.zloebok.financialbudget.finance.income.entity.IncomeEntity;

@Component
public class IncomeMapper {
    public IncomeEntity DtoToEntity(IncomeDto dto) {
        IncomeEntity entity = new IncomeEntity();

        entity.setDescription(dto.getDescription());
        entity.setName(dto.getName());
        entity.setIncome(dto.getIncome());
        entity.setFinancialCondition(dto.getFinancialCondition());

        return entity;
    }
}
