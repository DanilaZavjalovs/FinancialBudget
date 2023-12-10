package org.zloebok.financialbudget.finance.financialCondition.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.zloebok.financialbudget.finance.assets.entity.AssetsEntity;
import org.zloebok.financialbudget.finance.liabilities.entity.LiabilitiesEntity;
import org.zloebok.financialbudget.user.entity.UserEntity;

import java.util.List;
import java.util.UUID;

@Entity
@Table
@Data
public class FinancialConditionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "financialCondition")
    private List<LiabilitiesEntity> liabilities;

    @OneToMany(mappedBy = "financialCondition")
    private List<AssetsEntity> assets;
}
