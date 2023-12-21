package org.zloebok.financialbudget.finance.financialCondition.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zloebok.financialbudget.finance.financialCondition.entity.FinancialConditionEntity;

import java.util.UUID;

@Repository
public interface FinancialConditionRepository extends JpaRepository<FinancialConditionEntity, UUID> {
}
