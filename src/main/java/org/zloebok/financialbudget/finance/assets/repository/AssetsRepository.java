package org.zloebok.financialbudget.finance.assets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zloebok.financialbudget.finance.assets.entity.AssetsEntity;

import java.util.UUID;

@Repository
public interface AssetsRepository extends JpaRepository<AssetsEntity, UUID> {

}
