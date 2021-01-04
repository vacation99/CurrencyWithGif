package com.daniil.currencyWithGifs.Controllers.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "API-1", url = "https://openexchangerates.org")
public interface API_Openexchangerates {
    @GetMapping("/api/latest.json?app_id=7014792121fc43ab92ea1d0f5b7bd113")
    public String getRatesCurrent();

    @GetMapping("/api/historical/2021-01-03.json?app_id=7014792121fc43ab92ea1d0f5b7bd113")
    public String getRatesOld();
}
