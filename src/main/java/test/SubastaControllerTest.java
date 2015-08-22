/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.progium.catering.config.ProgiumApplication;
import com.progium.catering.contracts.PropuestaSubastaResponse;
import com.progium.catering.contracts.SubastaResponse;
import com.progium.catering.ejb.Catalogoproducto;
import com.progium.catering.ejb.Paquete;
import com.progium.catering.ejb.Propuestasubasta;
import com.progium.catering.ejb.Subasta;
import com.progium.catering.ejb.Tipo;
import com.progium.catering.ejb.Usuario;
import com.progium.catering.services.GeneralServiceInterface;
import com.progium.catering.services.PaqueteServiceInterface;
import com.progium.catering.services.PropuestaSubastaServiceInterface;
import com.progium.catering.services.SubastaServiceInterface;

/**
* Esta clase se encarga de testear todo el modulo de subasta
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/21
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=ProgiumApplication.class)
@WebAppConfiguration
public class SubastaControllerTest {
	
	@Autowired
	GeneralServiceInterface generalService;
	
	@Autowired
	SubastaServiceInterface subastaService;
	
	
	@Autowired
	PaqueteServiceInterface paqueteService;
	
	@Autowired
	PropuestaSubastaServiceInterface propuestaSubastaService;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link com.progium.catering.controllers.SubastaController#create(com.progium.catering.contracts.SubastaRequest)}.
	 */
	@Test
	public final void testCreate() {
		
		try{
			
			Date fecha = new Date();
			Tipo objTipo = generalService.getTipoById(3);
			Usuario objUsuario = generalService.getUsuarioById(4);
			
			Subasta objSubasta = new Subasta();
			objSubasta.setNombre("juan Perez");
			objSubasta.setDescripcion("Fiesta de matrimonio");
			objSubasta.setCantidadPersonas(20);
			objSubasta.setMontoMaximo(200000);
			objSubasta.setFechaEvento(fecha);
			objSubasta.setTipo(objTipo);
			objSubasta.setUsuario(objUsuario);
					
			Boolean state = subastaService.saveSubasta(objSubasta);
			
			assertTrue(state);
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Not yet implemented"); // TODO
		}
		
	}

	/**
	 * Test method for {@link com.progium.catering.controllers.SubastaController#getSubastaLista(com.progium.catering.contracts.SubastaRequest)}.
	 */
	@Test
	public final void testGetSubastaLista() {
		try {
			Subasta objSubasta = subastaService.getSubastaById(1);
			
			assertNotNull(objSubasta);
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Not yet implemented"); // TODO
		}
	}

	
	/**
	 * Test method for {@link com.progium.catering.controllers.SubastaController#createPropuestaSubasta(com.progium.catering.contracts.PropuestaSubastaRequest)}.
	 */
	@Test
	public final void testCreatePropuestaSubasta() {
		try{
			
			Paquete objPaquete = paqueteService.getPaqueteById(1);
			Subasta objSubasta = subastaService.getSubastaById(1);
			Propuestasubasta objPropuesta = new Propuestasubasta();
			
			objPropuesta.setTipoTransaccion(0);
			objPropuesta.setPaquete(objPaquete);
			objPropuesta.setSubasta(objSubasta);
					
			Boolean state = propuestaSubastaService.savePropuestaSubasta(objPropuesta);
			assertTrue(state);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Not yet implemented"); // TODO
		}
		
	}

	/**
	 * Test method for {@link com.progium.catering.controllers.SubastaController#getPropuestaSubastaBySubasta(com.progium.catering.contracts.PropuestaSubastaRequest)}.
	 */
	@Test
	public final void testGetPropuestaSubastaBySubasta() {
		try {
			List<Propuestasubasta> listaPropuesta = propuestaSubastaService.getPropuestaSubastaBySubasta(1);
			
			assertNotNull(listaPropuesta);
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Not yet implemented"); // TODO
		}
	}

	/**
	 * Test method for {@link com.progium.catering.controllers.SubastaController#getReservarPropuestaSubasta(com.progium.catering.contracts.PropuestaSubastaRequest)}.
	 */
	@Test
	public final void testGetReservarPropuestaSubasta() {
		try {
			Propuestasubasta propuestaGanadora = propuestaSubastaService.getPropuestaSubastaById(1);
			propuestaGanadora.setTipoTransaccion(2);
			Boolean state = propuestaSubastaService.savePropuestaSubasta(propuestaGanadora);
			assertTrue(state);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Not yet implemented"); // TODO
		}
	}

}
