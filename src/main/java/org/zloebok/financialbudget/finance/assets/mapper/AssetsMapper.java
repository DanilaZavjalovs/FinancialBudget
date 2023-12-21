package org.zloebok.financialbudget.finance.assets.mapper;

import org.springframework.stereotype.Component;
import org.zloebok.financialbudget.finance.assets.dto.AssetsDto;
import org.zloebok.financialbudget.finance.assets.entity.AssetsEntity;

@Component
public class AssetsMapper {
    public AssetsEntity DtoToEntity(AssetsDto dto) {
        AssetsEntity entity = new AssetsEntity();

        entity.setDescription(dto.getDescription());
        entity.setName(dto.getName());
        entity.setIncome(dto.getIncome());
        entity.setFinancialCondition(dto.getFinancialCondition());

        return entity;
    }
}
