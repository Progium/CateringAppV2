/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.progium.catering.config.ProgiumApplication;
import com.progium.catering.ejb.Catering;
import com.progium.catering.ejb.Paquete;
import com.progium.catering.ejb.Tipo;
import com.progium.catering.ejb.Usuario;
import com.progium.catering.services.CataloProductoServiceInterface;
import com.progium.catering.services.CateringServiceInterface;
import com.progium.catering.services.GeneralServiceInterface;
import com.progium.catering.services.PaqueteProductoServiceInterface;
import com.progium.catering.services.PaqueteServiceInterface;
import com.progium.catering.services.ProductoServiceInterface;
import com.progium.catering.services.ReservarPaqueteServiceInterface;
import com.progium.catering.services.UsuarioServiceInterface;

/**
* Esta clase se encarga de testear todo el modulo de paquete
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/21
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=ProgiumApplication.class)
@WebAppConfiguration
public class PaqueteControllerTest {

	@Autowired
	PaqueteServiceInterface paqueteService;
	
	@Autowired
	PaqueteProductoServiceInterface paqueteProductoService;
	
	@Autowired
	GeneralServiceInterface generalService;
		
	@Autowired
	CateringServiceInterface cateringService;
	
	@Autowired
	CataloProductoServiceInterface catalogoProductoService;
	
	@Autowired
	UsuarioServiceInterface usuarioService;
	
	@Autowired
	ReservarPaqueteServiceInterface reservaPaqueteService;
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.progium.catering.controllers.PaqueteController#registrar(com.progium.catering.contracts.PaqueteRequest)}.
	 */
	@Test
	public final void testRegistrar() {
		try {
			Catering objCatering = generalService.getCateringById(4);
			Tipo objTipo = generalService.getTipoById(3);
			Paquete objNuevoPaquete = new Paquete();
			
			objNuevoPaquete.setNombre("Comida Mexicana");
			objNuevoPaquete.setDescripcion("No incluye el precio del transporte");
			objNuevoPaquete.setCantidadPersonas(50);
			objNuevoPaquete.setPrecio(200000);
			objNuevoPaquete.setDescuento(10);
			objNuevoPaquete.setMontoTotal(180000);
			objNuevoPaquete.setCatering(objCatering);
			objNuevoPaquete.setTipo(objTipo);
			
			Boolean  status = paqueteService.savePaquete(objNuevoPaquete);
			
			assertTrue(status);
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Not yet implemented"); // TODO
		}
	}
	
	/**
	 * Test method for {@link com.progium.catering.controllers.PaqueteController#getPaqueteByAdministrador(com.progium.catering.contracts.PaqueteRequest)}.
	 */
	/*@Test
	public final void testgetPaqueteByAdministrador() {
		try {
			Paquete objPaquete = paqueteService.getPaqueteByCateringByIdAdministrador(objPaquete, 1);
			
			List<Paquete> listaPaquete = paqueteService.getPaqueteByCateringByIdAdministrador(,1);

			assertNotNull(listaPaquete);
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Not yet implemented"); // TODO
		}
		}*/
	
	/**
	 * Test method for {@link com.progium.catering.controllers.PaqueteController#getPaqueteByCatering(com.progium.catering.contracts.PaqueteRequest)}.
	 */
	/*@Test
	public final void testgetPaqueteByCatering() {
		try {
			Paquete objPaquete = paqueteService.getPaqueteByCatering(1);
			
			List<Paquete> listaPaquete = paqueteService.getPaqueteByCatering(1);

			assertNotNull(listaPaquete);
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Not yet implemented"); // TODO
		}
		}*/
	
	/**
	 * Test method for {@link com.progium.catering.controllers.PaqueteController#getgetPaqueteById(com.progium.catering.contracts.PaqueteRequest)}.
	 */
	@Test
	public final void testgetPaqueteById() {
		try {
			Paquete paquete = paqueteService.getPaqueteById(1);
			
			assertNotNull(paquete);
					
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Not yet implemented"); // TODO
		}
	}
	
	
	
}
	

