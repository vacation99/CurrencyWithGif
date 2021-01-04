package com.daniil.currencyWithGifs.Controllers;

import com.daniil.currencyWithGifs.Controllers.Feign.API_Giphy;
import com.daniil.currencyWithGifs.Controllers.Feign.API_Openexchangerates;
import com.daniil.currencyWithGifs.JsonObjects.Currency.DataObjects;
import com.daniil.currencyWithGifs.JsonObjects.Gif.DataGif;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@EnableFeignClients
public class MainController {
    @Autowired
    private API_Openexchangerates API_Openexchangerates;

    @Autowired
    private API_Giphy API_Giphy;

    @GetMapping("/getCurrency")
    public String getCurrency(Model model) {
        DataObjects dataObjectsCurrent = new Gson().fromJson(API_Openexchangerates.getRatesCurrent(), DataObjects.class);
        DataObjects dataObjectsOld = new Gson().fromJson(API_Openexchangerates.getRatesOld(), DataObjects.class);

        DataGif GifRich = new Gson().fromJson(API_Giphy.getGifRich(), DataGif.class);
        DataGif GifBroke = new Gson().fromJson(API_Giphy.getGifBroke(), DataGif.class);

        double currentRub = dataObjectsCurrent.getRates().getRUB();
        double oldRub = dataObjectsOld.getRates().getRUB();
        double result = currentRub - oldRub;

        if (result >= 0) {
            model.addAttribute("modelRich", GifRich.getData().getImages().getDownsized_large().getUrl());
            return "rich";
        } else {
            model.addAttribute("modelBroke", GifBroke.getData().getImages().getDownsized_large().getUrl());
            return "broke";
        }
    }
}
