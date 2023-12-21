package org.zloebok.financialbudget.finance.assets.dto;

import lombok.Data;
import org.zloebok.financialbudget.finance.financialCondition.entity.FinancialConditionEntity;

import java.util.UUID;

@Data
public class AssetsDto {
    private UUID id;
    private FinancialConditionEntity financialCondition;
    private String name;
    private String description;
    private int income;
}
