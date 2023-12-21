package org.zloebok.financialbudget.finance.liabilities.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zloebok.financialbudget.finance.liabilities.entity.LiabilitiesEntity;

import java.util.UUID;

@Repository
public interface LiabilitiesRepository extends JpaRepository<LiabilitiesEntity, UUID> {
}
