<section class="main padder">
	<div class="clearfix">
		<h4>
			<i class="fa fa-edit"></i>Registrar Paquete
		</h4>
	</div>
	<div class="row">
		<form class="form-horizontal" method="get" name="crearPaquete"
			data-validate="parsley">
			<div class="col-sm-6">
				<section class="panel">
					<div class="panel-body">
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
						<!-- Lista de caterings -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Caterings</label>
							<div class="col-lg-8">
								<select name="idCatering" id="idCatering" class="form-control"
									ng-model="objPaquete.idCatering"
									ng-options="lc.idCatering as lc.nombre for lc in listaCaterings"
									ng-change="llenarTipoEvento()" required>
								</select>
							</div>
						</div>
						<!-- Tipo eventos -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Tipo de Evento</label>
							<div class="col-lg-8">
								<select name="idTipo" id="idTipo" class="form-control"
									ng-model="objPaquete.idTipoEvento"
									ng-options="te.idTipo as te.nombre for te in listaTipoEvento"
									required>
								</select>
							</div>
						</div>
					</div>
				</section>
			</div>
			<!-- Datos del catalogo -->
			<div class="col-sm-6">
				<section class="panel">
					<div class="panel-body">
						<!-- Lista de categorias -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Categorías</label>
							<div class="col-lg-8">
								<select name="idCategoria" id="idCategoria" class="form-control"
									ng-model="objPaquete.idCategoria"
									ng-options="lc.idCategoria as lc.nombre for lc in listaCategorias"
									required>
								</select>
							</div>
						</div>
						<!-- Lista productos relacionados al catalogo -->
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
						<!-- Precio por persona -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Precio por persona</label>
							<div class="col-lg-8">
								<input ng-model="objPaquete.precio" type="text" name="precio"
									placeholder="5000" class="form-control" data-trigger="keyup"
									ng-readonly="true" required />
							</div>
						</div>
						<!-- Descuento -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Descuento</label>
							<div class="col-lg-8">
								<input ng-model="objPaquete.descuento" type="text"
									name="descuento" placeholder="10000" class="form-control"
									data-trigger="keyup" required />
							</div>
						</div>
						<!-- Monto total -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Monto total</label>
							<div class="col-lg-8">
								<input ng-model="objPaquete.montoTotal" type="text"
									name="montoTotal" placeholder="100000" class="form-control"
									data-trigger="keyup" ng-readonly="true" required />
							</div>
						</div>
						<div class="form-group">
							<div class="col-lg-9 col-lg-offset-7">
								<button type="submit" class="btn btn-white"
									ng-click="cancelar()">Cancelar</button>
								<button type="submit" class="btn btn-info" ng-click="guardar()">Guardar</button>
							</div>
						</div>
					</div>
				</section>
			</div>
		</form>
	</div>
</section>