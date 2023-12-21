package org.zloebok.financialbudget.api.liabilities.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.zloebok.financialbudget.api.financialCondition.service.FinancialConditionService;
import org.zloebok.financialbudget.finance.liabilities.dto.LiabilitiesDto;
import org.zloebok.financialbudget.finance.liabilities.mapper.LiabilitiesMapper;
import org.zloebok.financialbudget.finance.liabilities.repository.LiabilitiesRepository;
import org.zloebok.financialbudget.user.entity.UserEntity;

@Service
@AllArgsConstructor
public class LiabilitiesService {
    private final FinancialConditionService financialConditionService;
    private final LiabilitiesRepository liabilitiesRepository;
    private final LiabilitiesMapper liabilitiesMapper;

    public void saveLiabilities(LiabilitiesDto dto, UserEntity user) {
        dto.setFinancialCondition(
                financialConditionService.findFinancialConditionByUserId(user));


        liabilitiesRepository.save(liabilitiesMapper.DtoToEntity(dto));
    }
}
