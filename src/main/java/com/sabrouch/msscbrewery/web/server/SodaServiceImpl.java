package com.sabrouch.msscbrewery.web.server;

import com.sabrouch.msscbrewery.web.model.SodaDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by sabrouch.
 * Date: 11/8/2020
 */
@Service
public class SodaServiceImpl implements SodaService {

    @Override
    public SodaDto getSodaById(UUID id) {
        return SodaDto.builder().id(UUID.randomUUID())
                .name("Coca")
                .CocaStyle("boite")
                .build();
    }
}
