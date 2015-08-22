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
import com.progium.catering.ejb.Distrito;
import com.progium.catering.ejb.Usuario;
import com.progium.catering.services.CateringServiceInterface;
import com.progium.catering.services.GeneralServiceInterface;
import com.progium.catering.services.UsuarioServiceInterface;
import com.progium.catering.services.EventoCateringServiceInterface;

/**
* Esta clase se encarga de testear todo el modulo de catering
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/21
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=ProgiumApplication.class)
@WebAppConfiguration
public class CateringControllerTest {

	@Autowired
	CateringServiceInterface cateringService;
	
	@Autowired
	GeneralServiceInterface generalService;
	
	@Autowired
	UsuarioServiceInterface usuarioService;
	
	@Autowired
	EventoCateringServiceInterface eventoCateringService;
	
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
	 * Test method for {@link com.progium.catering.controllers.CateringController#registrar(com.progium.catering.contracts.CateringRequest)}.
	 */
	@Test
	public final void testRegistrar() {
		try {
			Usuario objUsuario = generalService.getUsuarioById(4);
			Distrito objDistrito = generalService.getDistritoById(244);
			
			Catering objNuevoCatering = new Catering();
			
			objNuevoCatering.setUsuario(objUsuario);
			objNuevoCatering.setNombre("Isild's Catering");
			objNuevoCatering.setCedulaJuridica("306543212");
			objNuevoCatering.setDireccion("50 metros sur de la iglesia católica");
			objNuevoCatering.setTelefono1("2567-9765");
			objNuevoCatering.setTelefono2("8765-9765");
			objNuevoCatering.setHorario("Lunes a Domingo de 10am a 4pm");
			objNuevoCatering.setProvinciaId(3);
			objNuevoCatering.setCantonId(37);
			objNuevoCatering.setDistrito(objDistrito);
			objNuevoCatering.setEstado(false);

			Boolean status = cateringService.saveCatering(objNuevoCatering);
			
			assertTrue(status);
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Not yet implemented"); // TODO
		}
	}

	/**
	 * Test method for {@link com.progium.catering.controllers.CateringController#getCaterigLista()}.
	 */
	@Test
	public final void testGetCaterigLista() {
		try {
			List<Catering> listaCatering = cateringService.getCateringByIdAdministrador(1);
			
			assertNotNull(listaCatering);
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Not yet implemented"); // TODO
		}
	}

	/**
	 * Test method for {@link com.progium.catering.controllers.CateringController#getCaterigById(com.progium.catering.contracts.CateringRequest)}.
	 */
	@Test
	public final void testGetCaterigById() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.progium.catering.controllers.CateringController#modificar(com.progium.catering.contracts.CateringRequest)}.
	 */
	@Test
	public final void testModificar() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.progium.catering.controllers.CateringController#getAll(com.progium.catering.contracts.CateringRequest)}.
	 */
	@Test
	public final void testGetAll() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.progium.catering.controllers.CateringController#getCateringByTipoEvento(com.progium.catering.contracts.CateringRequest)}.
	 */
	@Test
	public final void testGetCateringByTipoEvento() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.progium.catering.controllers.CateringController#getPorLocalizacion(com.progium.catering.contracts.CateringRequest)}.
	 */
	@Test
	public final void testGetPorLocalizacion() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.progium.catering.controllers.CateringController#getCateringPorNombre(com.progium.catering.contracts.CateringRequest)}.
	 */
	@Test
	public final void testGetCateringPorNombre() {
		fail("Not yet implemented"); // TODO
	}

}
