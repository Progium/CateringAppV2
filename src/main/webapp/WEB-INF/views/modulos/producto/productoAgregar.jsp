<section class="main padder">   
        	  <section class="panel">
              	<header class="panel-heading text-center">
            	  	A�adir Producto 
              	</header>
              	<div class="panel-body">
  	      		  <form name="registroCatalogo" class="form-horizontal" method="get" data-validate="parsley">
  	      		  	<div  class="form-group">
                    	<input type="text"  name="id" ng-model="productoSelec.id" hidden/>
                  	</div>
                  <div class="form-group">
                    <label class="col-lg-3 control-label">Producto</label>
                  	<div class="col-lg-8">
                  	<input type="text"  name="producto" ng-model="productoSelec.nombre" readonly/>
                  </div>
                </div>
                  <div class="form-group">
                    <label class="col-lg-3 control-label">Precio</label>
                    <div class="col-lg-8">
                      <input type="text"  name="precio" required/>
                      <span class="error" ng-model="requestObject.catalogo.precio" ng-show="registroCatalogo.precio.$error.required">Requerido</span>
                    </div>
                  </div>   
                  
					<div class="form-group">
						<label class="col-lg-3 control-label">Catering</label>
  					    <div class="col-lg-8">
							<select ng-model="seleccionarCatering" ng-options="catering as catering.nombre for catering in caterings">
							</select>
						</div>
					</div>
  				
					<div class="form-group">
						<label class="col-lg-3 control-label">Fotograf�a</label>
						<div class="col-lg-9 media">
							<div class="bg-light pull-left text-center media-large thumb-large">
								<i class="fa fa-user inline fa fa-light fa fa-3x m-t-large m-b-large"></i>
							</div>
							<div class="media-body">
								<input ng-file-select="onFileSelect($files)" type="file" name="fotografia" title="Examinar" class="btn btn-sm btn-info m-b-small" /> <br>
							</div>
						</div>
					</div>
					

                </form>
                
              <br>
	                <div class="form-group">
	                  <div class="col-lg-9 col-lg-offset-5">                      
	                    <button type="submit" class="btn btn-white" ng-click="cancel()">Cancelar</button>
	                    <button type="submit" class="btn btn-primary">Guardar</button>
	                  </div>
	                </div>
	              
            </section>
    </section>