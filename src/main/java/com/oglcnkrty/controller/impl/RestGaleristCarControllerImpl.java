package com.oglcnkrty.controller.impl;

import com.oglcnkrty.controller.IRestGaleristCarController;
import com.oglcnkrty.controller.RestBaseController;
import com.oglcnkrty.dto.DtoGaleristCar;
import com.oglcnkrty.dto.DtoGaleristCarIU;
import com.oglcnkrty.dto.RootEntity;
import com.oglcnkrty.service.IGaleristCarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/galerist_car")
@RestController
public class RestGaleristCarControllerImpl extends RestBaseController implements IRestGaleristCarController {
    @Autowired
    IGaleristCarService galeristCarService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoGaleristCar> saveGaleristCar(@Valid @RequestBody DtoGaleristCarIU dtoGaleristCarIU) {
        return ok(galeristCarService.saveGaleristCar(dtoGaleristCarIU));
    }
}
