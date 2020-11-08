package com.sabrouch.msscbrewery.web.server;

import com.sabrouch.msscbrewery.web.model.SodaDto;

import java.util.UUID;

/**
 * Created by sabrouch.
 * Date: 11/8/2020
 */

public interface SodaService {

    SodaDto getSodaById(UUID id);
}
