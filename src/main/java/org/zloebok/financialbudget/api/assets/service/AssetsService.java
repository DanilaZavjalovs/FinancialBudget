package org.zloebok.financialbudget.api.assets.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.zloebok.financialbudget.api.financialCondition.service.FinancialConditionService;
import org.zloebok.financialbudget.finance.assets.dto.AssetsDto;
import org.zloebok.financialbudget.finance.assets.mapper.AssetsMapper;
import org.zloebok.financialbudget.finance.assets.repository.AssetsRepository;
import org.zloebok.financialbudget.user.entity.UserEntity;

@Service
@AllArgsConstructor
public class AssetsService {
    private final AssetsRepository assetsRepository;
    private final FinancialConditionService financialConditionService;
    private final AssetsMapper mapper;

    public void saveAssets(AssetsDto dto, UserEntity user) {
        dto.setFinancialCondition(
                financialConditionService.findFinancialConditionByUserId(user));


        assetsRepository.save(mapper.DtoToEntity(dto));
    }
}
