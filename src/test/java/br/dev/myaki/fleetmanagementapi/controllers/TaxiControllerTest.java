package br.dev.myaki.fleetmanagementapi.controllers;

import br.dev.myaki.fleetmanagementapi.models.Taxi;
import br.dev.myaki.fleetmanagementapi.repositories.TaxiRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TaxiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaxiRepository taxiRepository;

    @Mock
    private Taxi taxi;

    @Test
    void findAllTaxis() throws Exception {

        Page<Taxi> page = new PageImpl<>(List.of(taxi));

        Mockito.when(taxiRepository.findAll(ArgumentMatchers.any(Pageable.class))).thenReturn(page);
        Mockito.when(taxi.getPlate()).thenReturn("ABCD-1111");
        Mockito.when(taxi.getId()).thenReturn(1234);

        this.mockMvc.perform(get("/taxis"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].plate").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.pageable").exists());
               // .andExpect(content().json("{'content':[{'id':1234,'plate':'ABCD-1111'}],'pageable':'INSTANCE','last':true,'totalPages':1,'totalElements':1,'first':true,'size':1,'number':0,'sort':{'sorted':false,'empty':true,'unsorted':true},'numberOfElements':1,'empty':false}"));

    }
}