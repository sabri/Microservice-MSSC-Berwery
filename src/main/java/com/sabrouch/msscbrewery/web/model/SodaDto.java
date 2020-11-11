package com.sabrouch.msscbrewery.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Created by sabrouch.
 * Date: 11/8/2020
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SodaDto {
    private UUID id;
    private String name;
    private String cocaStyle;
    private Long upc;
}
