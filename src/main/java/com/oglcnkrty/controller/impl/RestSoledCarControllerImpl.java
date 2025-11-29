package com.oglcnkrty.controller.impl;

import com.oglcnkrty.controller.IRestSoledCarController;
import com.oglcnkrty.controller.RestBaseController;
import com.oglcnkrty.dto.DtoSoledCar;
import com.oglcnkrty.dto.DtoSoledCarIU;
import com.oglcnkrty.dto.RootEntity;
import com.oglcnkrty.service.ISoledCarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/soled_car")
@RestController
public class RestSoledCarControllerImpl extends RestBaseController implements IRestSoledCarController {
    @Autowired
    ISoledCarService soledCarService;

    @PostMapping("/buy")
    @Override
    public RootEntity<DtoSoledCar> buy(@Valid @RequestBody DtoSoledCarIU dtoSoledCarIU) {
        return ok(soledCarService.buy(dtoSoledCarIU));
    }
}
