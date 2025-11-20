package com.oglcnkrty.controller.impl;

import com.oglcnkrty.controller.IRestCarController;
import com.oglcnkrty.controller.RestBaseController;
import com.oglcnkrty.dto.DtoCar;
import com.oglcnkrty.dto.DtoCarIU;
import com.oglcnkrty.dto.RootEntity;
import com.oglcnkrty.service.ICarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class RestCarControllerImpl extends RestBaseController implements IRestCarController {
    @Autowired
    ICarService carService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoCar> saveCar(@Valid @RequestBody DtoCarIU dtoCarIU) {
        return ok(carService.saveCar(dtoCarIU));
    }
}
