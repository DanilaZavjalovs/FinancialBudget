package org.zloebok.financialbudget.finance.expense.mapper;

import org.springframework.stereotype.Component;
import org.zloebok.financialbudget.finance.expense.dto.ExpenseDto;
import org.zloebok.financialbudget.finance.expense.entity.ExpenseEntity;

@Component
public class ExpenseMapper {
    public ExpenseEntity DtoToEntity(ExpenseDto dto) {
        ExpenseEntity entity = new ExpenseEntity();

        entity.setDescription(dto.getDescription());
        entity.setName(dto.getName());
        entity.setExpense(dto.getExpense());
        entity.setFinancialCondition(dto.getFinancialCondition());

        return entity;
    }
}
