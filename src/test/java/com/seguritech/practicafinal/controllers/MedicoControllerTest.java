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
//
//    @Test
//    public void testCreate() throws Exception {
//        System.out.println("create");
//        Medico medico = null;
//        MedicoController instance = null;
//        ResponseEntity<Medico> expResult = null;
//        ResponseEntity<Medico> result = instance.create(medico);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testListAll() {
//        System.out.println("listAll");
//        int especialidad = 0;
//        MedicoController instance = null;
//        List<Medico> expResult = null;
//        List<Medico> result = instance.listAll(especialidad);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testUpdate() throws Exception {
//        System.out.println("update");
//        Medico medico = null;
//        MedicoController instance = null;
//        ResponseEntity<Medico> expResult = null;
//        ResponseEntity<Medico> result = instance.update(medico);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testDeleteMedico() {
//        System.out.println("deleteMedico");
//        Long id = null;
//        MedicoController instance = null;
//        ResponseEntity<Medico> expResult = null;
//        ResponseEntity<Medico> result = instance.deleteMedico(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
