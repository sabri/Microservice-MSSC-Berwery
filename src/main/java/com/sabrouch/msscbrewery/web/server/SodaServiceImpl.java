package com.sabrouch.msscbrewery.web.server;

import com.sabrouch.msscbrewery.web.model.SodaDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by sabrouch.
 * Date: 11/8/2020
 */
@Slf4j
@Service
public class SodaServiceImpl implements SodaService {

    @Override
    public SodaDto getSodaById(UUID id) {
        return SodaDto.builder().id(UUID.randomUUID())
                .name("Coca")
                .cocaStyle("boite")
                .build();
    }

    @Override
    public SodaDto saveSoda(SodaDto sodaDto) {
        return SodaDto.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public void updateSoda(UUID sodaId, SodaDto sodaDto) {

    }

    @Override
    public void deleteById(UUID beerId) {
        log.debug("Deleting a soda...");
    }
}
