package org.zloebok.financialbudget.finance.expense.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.zloebok.financialbudget.finance.financialCondition.entity.FinancialConditionEntity;

import java.util.UUID;

@Entity
@Table
@Data
public class ExpenseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "financialCondition_id")
    private FinancialConditionEntity financialCondition;

    private String name;
    private String description;
    private int expense;
}
