package com.oglcnkrty.controller.impl;

import com.oglcnkrty.controller.IRestGaleristController;
import com.oglcnkrty.controller.RestBaseController;
import com.oglcnkrty.dto.DtoGalerist;
import com.oglcnkrty.dto.DtoGaleristIU;
import com.oglcnkrty.dto.RootEntity;
import com.oglcnkrty.service.IGaleristService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/galerist")
@RestController
public class RestGaleristControllerImpl extends RestBaseController implements IRestGaleristController {
    @Autowired
    private IGaleristService galeristService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoGalerist> saveGalerist(@Valid @RequestBody DtoGaleristIU dtoGaleristIU) {
        return ok(galeristService.saveGalerist(dtoGaleristIU));
    }
}
