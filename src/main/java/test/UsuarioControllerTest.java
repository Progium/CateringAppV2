/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;
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
import com.progium.catering.contracts.UsuarioRequest;
import com.progium.catering.contracts.UsuarioResponse;
import com.progium.catering.ejb.Paquete;
import com.progium.catering.ejb.Tipo;
import com.progium.catering.ejb.Usuario;
import com.progium.catering.services.GeneralServiceInterface;
import com.progium.catering.services.UsuarioService;
import com.progium.catering.services.UsuarioServiceInterface;
import com.progium.catering.utils.GeneradorContrasennaUtil;
import com.progium.catering.utils.SendEmail;

/**
* Esta clase se encarga de testear todo el modulo de usuario
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/21
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=ProgiumApplication.class)
@WebAppConfiguration
public class UsuarioControllerTest {

	@Autowired
	UsuarioServiceInterface usuarioService;

	@Autowired
	GeneralServiceInterface generalService;

	
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
	 * Test method for {@link com.progium.catering.controllers.UsuarioController#getgetUsuarioById(com.progium.catering.contracts.UsuarioRequest)}.
	 */
	@Test
	public final void testRegistrar() {
		try {
			
			Usuario objNuevoUsuario = new Usuario();
			Tipo objTipo = generalService.getTipoById(1);
	
			objNuevoUsuario.setNombre("Anita");
			objNuevoUsuario.setApellido1("Mata");
			objNuevoUsuario.setApellido2("Picado");
			objNuevoUsuario.setCorreo("anita@yahoo.com");
			objNuevoUsuario.setTelefono1("2551-2445");
			objNuevoUsuario.setTelefono2("4556-6543");
			objNuevoUsuario.setTipo(objTipo);
			objNuevoUsuario.setContrasenna("1234");

			Boolean  status = usuarioService.saveUsuario(objNuevoUsuario);
			
			assertTrue(status);	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Not yet implemented"); // TODO
		}
	}
	
	/**
	 * Test method for {@link com.progium.catering.controllers.UsuarioController#modificar(com.progium.catering.contracts.UsuarioRequest)}.
	 */
	@Test
	public final void testModificar() {
		try {
			
			Tipo objTipo = generalService.getTipoById(3);
			Usuario objUsuario = usuarioService.getUsuarioById(1);
			
			objUsuario.setNombre("Marce");
			objUsuario.setApellido1("Leandro");
			objUsuario.setApellido2("Picado");
			objUsuario.setCorreo("marceleap0425@yahoo.com");
			objUsuario.setTelefono1("2551-2447");
			objUsuario.setTelefono2("2222-2222");
			objUsuario.setTipo(objTipo);
			
			Boolean state = usuarioService.saveUsuario(objUsuario);
			
			assertTrue(state);
			 			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Not yet implemented"); // TODO
		}
	}
}
	
	
		


