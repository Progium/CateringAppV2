/**
 * 
 */
package com.progium.catering.controllers;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;

import com.progium.catering.contracts.BaseResponse;
import com.progium.catering.contracts.UsuarioRequest;
import com.progium.catering.contracts.UsuarioResponse;

/**
 * @author Marce
 *
 */
public class UsuarioControllerTest {

	public UsuarioControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of registrarFoto method, of class UsuarioController.
     */
    @Test
    public void testRegistrarFoto() throws Exception {
        System.out.println("registrarFoto");
        MultipartFile file = null;
        int idUsuario = 0;
        UsuarioController instance = new UsuarioController();
        UsuarioResponse expResult = null;
        UsuarioResponse result = instance.registrarFoto(file, idUsuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registrar method, of class UsuarioController.
     */
    @Test
    public void testRegistrar() throws Exception {
        System.out.println("registrar");
        UsuarioRequest usuarioRequest = null;
        UsuarioController instance = new UsuarioController();
        UsuarioResponse expResult = null;
        UsuarioResponse result = instance.registrar(usuarioRequest);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of PerfilUsuario method, of class UsuarioController.
     */
    @Test
    public void testPerfilUsuario() {
        System.out.println("PerfilUsuario");
        UsuarioController instance = new UsuarioController();
        UsuarioResponse expResult = null;
        UsuarioResponse result = instance.PerfilUsuario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificar method, of class UsuarioController.
     */
    @Test
    public void testModificar() throws Exception {
        System.out.println("modificar");
        UsuarioRequest usuarioRequest = null;
        UsuarioController instance = new UsuarioController();
        UsuarioResponse expResult = null;
        UsuarioResponse result = instance.modificar(usuarioRequest);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of olvidoContrasenna method, of class UsuarioController.
     */
    @Test
    public void testOlvidoContrasenna() throws Exception {
        System.out.println("olvidoContrasenna");
        UsuarioRequest usuarioRequest = null;
        UsuarioController instance = new UsuarioController();
        BaseResponse expResult = null;
        BaseResponse result = instance.olvidoContrasenna(usuarioRequest);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}