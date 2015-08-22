/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.progium.catering.config.ProgiumApplication;
import com.progium.catering.contracts.CatalogoProductoResponse;
import com.progium.catering.ejb.Catalogoproducto;
import com.progium.catering.ejb.Catering;
import com.progium.catering.ejb.Producto;
import com.progium.catering.services.CataloProductoServiceInterface;
import com.progium.catering.services.GeneralServiceInterface;

/**
* Esta clase se encarga de testear todo el modulo de catalogo
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/21
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=ProgiumApplication.class)
@WebAppConfiguration
public class CatalogoProductoControllerTest {

	@Autowired
	GeneralServiceInterface generalService;
	
	@Autowired
	CataloProductoServiceInterface catalogoproductoservice;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link com.progium.catering.controllers.CatalogoProductoController#create(com.progium.catering.contracts.CatalogoProductoRequest)}.
	 */
	@Test
	public final void testCreate() {
		try{
			
			
				Producto objProducto = generalService.getProductoById(1);
				Catering objCatering = generalService.getCateringById(1);
				
				Catalogoproducto objNuevoCataloProducto = new Catalogoproducto();
				
				objNuevoCataloProducto.setCatering(objCatering);
				objNuevoCataloProducto.setProducto(objProducto);
				objNuevoCataloProducto.setPrecio(2000);
				objNuevoCataloProducto.setEstado(false);

				Boolean state = catalogoproductoservice.saveCatalogoProducto(objNuevoCataloProducto);
			
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Not yet implemented"); // TODO
		}
	
	}

	/**
	 * Test method for {@link com.progium.catering.controllers.CatalogoProductoController#getCatalogoProducto(com.progium.catering.contracts.CatalogoProductoRequest)}.
	 */
	@Test
	public final void testGetCatalogoProducto() {
		try {
			Catalogoproducto objCatalogo = catalogoproductoservice.getCatalogoProductoById(1);
			
			assertNotNull(objCatalogo);
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Not yet implemented"); // TODO
		}
	}

	/**
	 * Test method for {@link com.progium.catering.controllers.CatalogoProductoController#getCatalogoProductoByCatering(com.progium.catering.contracts.CatalogoProductoRequest)}.
	 */
	@Test
	public final void testGetCatalogoProductoByCatering() {
		try {
			List<Catalogoproducto> catalogo = catalogoproductoservice.getCatalogoProductoByIdCatering(1);
			
			assertNotNull(catalogo);
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Not yet implemented"); // TODO
		}
	}

}
