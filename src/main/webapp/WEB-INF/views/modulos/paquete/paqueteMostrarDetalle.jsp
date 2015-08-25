<section class="main padder">
	<div class="clearfix">
		<h4 class="title-detalle">
			<i class="fa fa-edit title-detalle"></i> Detalle del paquete
		</h4>
	</div>
	<div class="row">
		<form class="form-horizontal" method="get" name="crearPaquete"
			data-validate="parsley">
			<div class="col-sm-6 detalle-style">
				<section class="panel">
					<div class="panel-body">
						<!-- Nombre -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Nombre</label>
							<div class="col-lg-8">
								<input ng-model="paquete.nombre" type="text" name="nombre"
									placeholder="Platillos Mexicanos" class="form-control"
									data-trigger="keyup" ng-disabled="true" />
							</div>
						</div>
						<!-- Cantidad de personas -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Cantidad de
								personas</label>
							<div class="col-lg-8">
								<input type="number" class="input-sm spinner-input form-control"
									name="cantidadPersonas" maxlength="3"
									ng-model="paquete.cantidadPersonas" min="1" max="5000"
									ng-disabled="true" />
							</div>
						</div>
						<!--Descripción-->
						<div class="form-group">
							<label class="col-lg-3 control-label">Descripción</label>
							<div class="col-lg-8">
								<textarea ng-model="paquete.descripcion" name="descripcion"
									placeholder="No incluye el transporte" rows="5"
									class="form-control" data-trigger="keyup" ng-maxlength="250"
									ng-disabled="true"></textarea>
							</div>
						</div>
						<!-- Catering -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Catering</label>
							<div class="col-lg-8">
								<input type="text" class="form-control" name="nombreCatering"
									maxlength="3" ng-model="paquete.nombreCatering"
									ng-disabled="true" />
							</div>
						</div>
						<!-- Tipo eventos -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Tipo de Evento</label>
							<div class="col-lg-8">
								<input type="text" class="form-control" name="nombreTipoEvento"
									maxlength="3" ng-model="paquete.nombreTipoEvento"
									ng-disabled="true" />
							</div>
						</div>

					</div>
				</section>
			</div>
			<!-- Datos del catalogo -->
			<div class="col-sm-6">
				<section class="panel">
					<div class="panel-body">
						<!-- Lista productos relacionados al catalogo -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Productos</label>
							<div class="col-lg-8">
								<select name="idCatalogoProducto" id="idCatalogoProducto"
									class="form-control" multiple ng-multiple="true"
									ng-model="catalogo.productos"
									ng-options="lp.idProducto as lp.nombre for lp in listaProductos"
									ng-disabled="true">
								</select>

							</div>
						</div>
						<!-- Precio por persona -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Precio por persona</label>
							<div class="col-lg-8 input-group">
								<span class="input-group-addon">¢</span><input
									ng-model="paquete.precio" type="text" name="precio"
									placeholder="5000.00" class="form-control inputMonto"
									data-trigger="keyup"
									aria-label="Amount (to the nearest dollar)" ng-disabled="true" />
							</div>
						</div>
						<!-- Total del paquete sin descuento -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Total</label>
							<div class="col-lg-8 input-group">
								<span class="input-group-addon">¢</span> <input
									ng-model="paquete.total" type="text" name="total"
									placeholder="100,000.00" class="form-control inputMonto"
									data-trigger="keyup" ng-readonly="true" ng-disabled="true" />
							</div>
						</div>
						<!-- Descuento -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Porcentaje de
								descuento</label>
							<div class="col-lg-8 input-group porcentaje">
								<input ng-model="paquete.descuento" type="text" name="descuento"
									placeholder="30" class="form-control input-porcentaje"
									aria-label="Amount (to the nearest dollar)"
									data-trigger="keyup" ng-disabled="true" /> <span
									class="input-group-addon">%</span>

							</div>
						</div>
						<!-- Monto total con el descuento-->
						<div class="form-group">
							<label class="col-lg-3 control-label">Monto total</label>
							<div class="col-lg-8 input-group">
								<span class="input-group-addon">¢</span> <input
									ng-model="paquete.montoTotal" type="text" name="montoTotal"
									placeholder="100,000.00" class="form-control inputMonto"
									data-trigger="keyup"
									aria-label="Amount (to the nearest dollar)" ng-disabled="true" />
							</div>
						</div>
					</div>
				</section>
			</div>
		</form>
	</div>
</section>