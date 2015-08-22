<section class="main padder">
	<div class="clearfix">
		<h4>
			<i class="fa fa-edit imagen-title"></i>Registrar Paquete
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
								<input type="number" class="input-sm spinner-input form-control"
									name="cantidadPersonas" maxlength="3"
									ng-change="actualizarFormulas()" ng-pattern="/^\d*$/"
									ng-model="objPaquete.cantidadPersonas" min="1" max="5000"
									required /><span class="error-message"
									ng-show="crearPaquete.cantidadPersonas.$error.pattern">Debe
									ingresar solo n�meros.</span>
							</div>
						</div>
						<!--Descripci�n-->
						<div class="form-group">
							<label class="col-lg-3 control-label">Descripci�n</label>
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
							<label class="col-lg-3 control-label">Categor�as</label>
							<div class="col-lg-8">
								<select name="idCategoria" id="idCategoria" class="form-control"
									ng-model="objPaquete.idCategoria"
									ng-options="lc.idCategoria as lc.nombre for lc in listaCategorias"
									ng-change="llenarProducto()" required>
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
									<tbody ng-repeat="producto in listaProductos"
										ng-click="productoSeleccionado(producto)">
										<tr>
											<td>{{producto.nombre}}</td>
											<td>{{producto.precio}}</td>
											<td><input type="checkbox" ng-model="producto.done"
												ng-true-value="2" ng-false-value="1" /></td>
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
						<!-- Total del paquete sin descuento -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Total</label>
							<div class="col-lg-8">
								<input ng-model="total" type="text" name="total"
									placeholder="100000" class="form-control" data-trigger="keyup"
									ng-readonly="true" required />
							</div>
						</div>
						<!-- Descuento -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Porcentaje de
								descuento</label>
							<div class="col-lg-8">
								<input ng-model="objPaquete.descuento" type="text"
									ng-change="actualizarFormulas()" name="descuento"
									placeholder="30" class="form-control"
									ng-pattern="/^((0|[1-9]\d?)(\.\d{1,2})?|100)$/"
									data-trigger="keyup" /><span class="error-message"
									ng-show="crearPaquete.descuento.$error.pattern">Debe
									ingresar solo n�meros, el porcentaje va del 0 al 100.</span>
							</div>
						</div>
						<!-- Monto total con el descuento-->
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