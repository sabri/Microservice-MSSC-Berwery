package com.sabrouch.msscbrewery.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sabrouch.msscbrewery.web.model.SodaDto;
import com.sabrouch.msscbrewery.web.server.SodaService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(SodaController.class)
class SodaControllerTest {

        @MockBean
        SodaService sodaService;

        @Autowired
        MockMvc mockMvc;

        @Autowired
        ObjectMapper objectMapper;

       SodaDto validSoda;

        @Before
        public void setUp() {
            validSoda = SodaDto.builder().id(UUID.randomUUID())
                    .name("Coca")
                    .cocaStyle("boite")
                    .upc(123456789012L)
                    .build();
        }

        @Test
        public void getSodaById() throws Exception {
            given(sodaService.getSodaById(any(UUID.class))).willReturn(validSoda);

            mockMvc.perform(get("/api/v1/soda/" + validSoda.getId().toString()).accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.id", is(validSoda.getId().toString())))
                    .andExpect(jsonPath("$.beerName", is("Coca")));
        }


    @Test
        public void handlePost() throws Exception {
            //given
            SodaDto sodaDto = validSoda;
            sodaDto.setId(null);
            SodaDto savedDto = SodaDto.builder().id(UUID.randomUUID()).name("COCA1").build();
            String beerDtoJson = objectMapper.writeValueAsString(sodaDto);

            given(sodaService.saveSoda(any())).willReturn(savedDto);

            mockMvc.perform(post("/api/v1/soda/")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(beerDtoJson))
                    .andExpect(status().isCreated());

        }

        @Test
        public void handleUpdate() throws Exception {
            //given
            SodaDto beerDto = validSoda;
            String beerDtoJson = objectMapper.writeValueAsString(beerDto);

            //when
                mockMvc.perform(put("/api/v1/soda/" + validSoda.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(beerDtoJson))
                    .andExpect(status().isNoContent());

            then(sodaService).should().updateSoda(any(), any());

        }
    }
