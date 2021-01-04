package com.daniil.currencyWithGifs.Controllers.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "API-2", url = "https://api.giphy.com")
public interface API_Giphy {
    @GetMapping("/v1/gifs/ADgfsbHcS62Jy?api_key=WhqY5XxJPeVPg1EX6KWB0ncuenVXmiEE")
    public String getGifRich();

    @GetMapping("/v1/gifs/yIxNOXEMpqkqA?api_key=WhqY5XxJPeVPg1EX6KWB0ncuenVXmiEE")
    public String getGifBroke();
}
