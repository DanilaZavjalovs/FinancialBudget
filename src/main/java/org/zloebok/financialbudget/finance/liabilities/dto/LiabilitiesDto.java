package org.zloebok.financialbudget.finance.liabilities.dto;

import lombok.Data;
import org.zloebok.financialbudget.finance.financialCondition.entity.FinancialConditionEntity;

import java.util.UUID;

@Data
public class LiabilitiesDto {
    private UUID id;
    private FinancialConditionEntity financialCondition;
    private String name;
    private String description;
    private int expense;
}
