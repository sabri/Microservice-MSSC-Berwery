package com.sabrouch.msscbrewery.web.controller;


import com.sabrouch.msscbrewery.web.model.SodaDto;
import com.sabrouch.msscbrewery.web.server.SodaService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity handlePost(@RequestBody SodaDto sodaDto){

        SodaDto sodaDto1 = sodaService.saveSoda(sodaDto);
      HttpHeaders headers = new HttpHeaders();
      headers.add("location","/api/v1/soda/" +sodaDto1.getId().toString());
      return new ResponseEntity(headers, HttpStatus.CREATED);
    }
    @PostMapping("/{SodaId}")
    public ResponseEntity handleUpdate ( @PathVariable("SodaId") UUID SodaId, @RequestBody SodaDto sodaDto){
sodaService.updateSoda(SodaId, sodaDto);
return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping({"/{sodaId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("sodaId") UUID beerId){
        sodaService.deleteById(beerId);
    }
}
