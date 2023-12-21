package org.zloebok.financialbudget.api.liabilities.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zloebok.financialbudget.api.liabilities.service.LiabilitiesService;
import org.zloebok.financialbudget.finance.assets.dto.AssetsDto;
import org.zloebok.financialbudget.finance.liabilities.dto.LiabilitiesDto;
import org.zloebok.financialbudget.user.entity.UserEntity;

@RestController
@RequestMapping("/api/liabilities")
@AllArgsConstructor
public class LiabilitiesRestController {
    private final LiabilitiesService liabilitiesService;

    @PostMapping
    public ResponseEntity<Void> saveLiabilities(@RequestBody LiabilitiesDto dto, @AuthenticationPrincipal UserEntity user) {
        liabilitiesService.saveLiabilities(dto, user);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
