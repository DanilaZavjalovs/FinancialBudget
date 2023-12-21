package org.zloebok.financialbudget.finance.liabilities.mapper;

import org.springframework.stereotype.Component;
import org.zloebok.financialbudget.finance.liabilities.dto.LiabilitiesDto;
import org.zloebok.financialbudget.finance.liabilities.entity.LiabilitiesEntity;

@Component
public class LiabilitiesMapper {
    public LiabilitiesEntity DtoToEntity(LiabilitiesDto dto) {
        LiabilitiesEntity entity = new LiabilitiesEntity();

        entity.setDescription(dto.getDescription());
        entity.setName(dto.getName());
        entity.setExpense(dto.getExpense());
        entity.setFinancialCondition(dto.getFinancialCondition());

        return entity;
    }
}
