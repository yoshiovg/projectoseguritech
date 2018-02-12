package com.seguritech.practicafinal.controllers;

import com.seguritech.practicafinal.domain.Medico;
import com.seguritech.practicafinal.service.MedicoService;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 *
 * @author surface
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MedicoControllerTest {
    
    private MockMvc mockMvc;
    
    private MedicoController medicoController;
    
    private final String medico = "{\"nombre\" : \"Jose Jose\"},{\"especialidad\" : 1},{\"estado\" : \"HABILITADO\"}";
    private final String medicoup = "{\"medico_id\" : 3},{ \"nombre\" : \"Jose Miguel\"},{\"especialidad\" : 2},{\"estado\" : \"HABILITADO\"}";
    @Mock
    private MedicoService medicoService;
    
    public MedicoControllerTest() {
    }

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        Medico medico = new Medico();
        medico.setMedico_id(1L);
        medico.setNombre("Jose Jose");
        medico.setEspecialidad(2);
        medico.setEstado("HABILITADO");
        Mockito.when(medicoService.findOne(1L)).thenReturn(medico);

        medicoController = new MedicoController(medicoService);
        
        mockMvc = MockMvcBuilders.standaloneSetup(medicoController).build();
    }
    
    
    
//    @Test
//    public void testFindAllMedicos() {
//        System.out.println("findAllMedicos");
//        List<Medico> findAllMedicos = medicoController.findAllMedicos();
//        assertEquals(findAllMedicos.size(), 7);
//    }
    
    

    @Test
    public void testGetMedico_isOkWhenMedicoIsFound() throws Exception {
        System.out.println("getMedico");
        final long id = 1;

        mockMvc.perform(get("/medicos/" + id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.medico_id").isNumber())
                .andExpect(jsonPath("$.medico_id").value(id))
                .andExpect(jsonPath("$.nombre").isString())
                .andExpect(jsonPath("$.especialidad").isNumber())
                .andExpect(jsonPath("$.estado").isString())
                ;
    }

    @Test
    public void testGetMedico_isError404WhenMedicosNotFound() throws Exception {
        System.out.println("getMedico");
        final long id = 2;

        mockMvc.perform(get("/medicos/" + id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().string(""));
    }

    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        
         mockMvc.perform(post("/medicos/")
                 .content(medico)
	         .contentType(APPLICATION_JSON_UTF8))
		 .andExpect(status().isCreated());
    }

    @Test
    public void testListAll_isOkWhenMedicoIsFound() throws Exception {
        System.out.println("listAll");
        final int especialidad = 1;

        mockMvc.perform(get("/medicos/" + especialidad)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.medico_id").isNumber())
                .andExpect(jsonPath("$.nombre").isString())
                .andExpect(jsonPath("$.especialidad").isNumber())
                .andExpect(jsonPath("$.estado").isString())
                ;
     
    }
    
    @Test
    public void testListAll_isError404WhenMedicosNotFound() throws Exception {
        System.out.println("listAll");
        final int especialidad = 10;

        mockMvc.perform(get("/medicos/" + especialidad)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().string(""));
    }

    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        
        mockMvc.perform(put("/medicos/")
                 .content(medicoup)
	         .contentType(APPLICATION_JSON_UTF8))
		 .andExpect(status().isOk());
    }

    @Test
    public void testDeleteMedico() throws Exception {
        System.out.println("deleteMedico");
        Long id = 7L;
        
          mockMvc.perform(delete("/medicos/" + id)
                  .accept(MediaType.APPLICATION_JSON))
                  .andExpect(status().isOk());
        
    }
    
}
