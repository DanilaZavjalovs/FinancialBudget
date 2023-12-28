package org.zloebok.financialbudget.webController.finance;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/finance")
public class FinanceController {

    @GetMapping
    public String finance() {
        return "finance";
    }
}
