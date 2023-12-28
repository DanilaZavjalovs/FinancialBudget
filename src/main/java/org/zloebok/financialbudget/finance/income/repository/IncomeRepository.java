package org.zloebok.financialbudget.finance.income.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zloebok.financialbudget.finance.income.entity.IncomeEntity;

import java.util.UUID;

@Repository
public interface IncomeRepository extends JpaRepository<IncomeEntity, UUID> {

}
