package com.sabrouch.msscbrewery.web.controller;


import com.sabrouch.msscbrewery.web.model.SodaDto;
import com.sabrouch.msscbrewery.web.server.SodaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by sabrouch.
 * Date: 11/8/2020
 */
@RestController
@RequestMapping("/api/v1/soda")
public class SodaController {

    public final SodaService sodaService;

    public SodaController(SodaService sodaService) {
        this.sodaService = sodaService;
    }

    @GetMapping("/{SodaId}")
    public ResponseEntity<SodaDto> getSoda(@PathVariable("SodaId") UUID SodaId){

        return new ResponseEntity<>(sodaService.getSodaById(SodaId), HttpStatus.OK);
    }
}
