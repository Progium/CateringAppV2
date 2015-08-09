<section class="main padder">
	<div class="clearfix">
		<h4>
			<i class="fa fa-edit"></i>Registrar Paquete
		</h4>
	</div>
	<div class="row">
		<div class="col-sm-6">
			<section class="panel">
				<div class="panel-body">
					<form class="form-horizontal" method="get" name="crearPaquete"
						data-validate="parsley">
						<!-- Nombre -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Nombre</label>
							<div class="col-lg-8">
								<input ng-model="objPaquete.nombre" type="text" name="nombre"
									placeholder="Platillos Mexicanos" class="form-control"
									data-trigger="keyup" required />
							</div>
						</div>
						<!-- Cantidad de personas -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Cantidad de
								personas</label>
							<div class="col-lg-8">
								<div id="MySpinner" class="spinner input-group m-b">
									<input type="text" class="input-sm spinner-input form-control"
										name="spinner" maxlength="3"
										ng-model="objPaquete.cantidadPersonas" min="1" max="99"
										required>
									<div class="btn-group btn-group-vertical input-group-btn">
										<button type="button" class="btn btn-white spinner-up">
											<i class="fa fa-chevron-up"></i>
										</button>
										<button type="button" class="btn btn-white spinner-down">
											<i class="fa fa-chevron-down"></i>
										</button>
									</div>
								</div>
							</div>
						</div>
						<!--Descripción-->
						<div class="form-group">
							<label class="col-lg-3 control-label">Descripción</label>
							<div class="col-lg-8">
								<textarea ng-model="objPaquete.descripcion" name="descripcion"
									placeholder="No incluye el transporte" rows="5"
									class="form-control" data-trigger="keyup" ng-maxlength="250"
									required></textarea>
								<span class="error-message"
									ng-show="crearPaquete.descripcion.$error.maxlength">Solo
									puede ingresar 200 caracteres.</span>
							</div>
						</div>

						<div class="form-group">
							<label class="col-lg-3 control-label">Productos</label>
							<div class="col-lg-8">
								<table class="table table-striped m-b-none text-small">
									<thead>
										<tr>
											<th>Nombre Producto</th>
											<th>Costo</th>
											<th>Seleccionar</th>
										</tr>
									</thead>
									<tbody ng-repeat="producto in productos">
										<tr>
											<td>{{producto.nombre}}</td>
											<td>{{producto.costo}}</td>
											<td><i class="fa fa-check-square"></i></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-3 control-label">Descuento</label>
							<div class="col-lg-8">
								<input class="form-control" type="text" name="descuento"
									required /> <span class="error"
									ng-show="registroPaquete.descuento.$error.required">Requerido</span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-3 control-label">Monto Total</label>
							<div class="col-lg-8">
								<input class="form-control" type="text" name="montoTotal"
									required /> <span class="error"
									ng-show="registroPaquete.montoTotal.$error.required">Requerido</span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-3 control-label">DescripciÃ³n</label>
							<div class="col-lg-8">
								<textarea name="descrip" rows="5" class="form-control"
									data-trigger="keyup" data-rangelength="[20,200]"></textarea>
								<span class="error"
									ng-show="registroPaquete.montoTotal.$error.required">Requerido</span>
							</div>
						</div>
					</form>
					<br>
					<div class="form-group">
						<div class="col-lg-9 col-lg-offset-5">
							<button type="submit" class="btn btn-primary">Guardar</button>
						</div>
					</div>
					</form>
				</div>
			</section>
		</div>
	</div>
</section>