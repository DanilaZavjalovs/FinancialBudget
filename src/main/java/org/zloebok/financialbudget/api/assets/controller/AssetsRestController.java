package org.zloebok.financialbudget.api.assets.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.zloebok.financialbudget.api.assets.service.AssetsService;
import org.zloebok.financialbudget.finance.assets.dto.AssetsDto;
import org.zloebok.financialbudget.user.entity.UserEntity;

@RestController
@RequestMapping("/api/assets")
@AllArgsConstructor
public class AssetsRestController {
    private final AssetsService assetsService;

    @PostMapping
    public ResponseEntity<Void> saveAssets(@RequestBody AssetsDto dto, @AuthenticationPrincipal UserEntity user) {
        assetsService.saveAssets(dto, user);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
