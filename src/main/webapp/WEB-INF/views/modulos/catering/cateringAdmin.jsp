<section class="main padder">
	<div class="clearfix">
		<h4>
			<i class="fa fa-edit"></i> {{tituloPagina}}
		</h4>
	</div>
	<div class="row">
		<form class="form-horizontal" name="crearCatering"
			data-validate="parsley">

			<div class="col-sm-6">
				<section class="panel">
					<div class="panel-body">
						<!-- Nombre -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Nombre</label>
							<div class="col-lg-8">
								<input ng-model="objCatering.nombre" type="text" name="nombre"
									placeholder="Isild's Catering" class="form-control"
									data-trigger="keyup" required ng-pattern="/^(\D)+$/" /><span
									class="error-message"
									ng-show="crearCatering.nombre.$error.pattern">Debe
									ingresar solo letras</span>
							</div>
						</div>
						<!-- Cedula Juridica -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Cédula Jurídica</label>
							<div class="col-lg-8">
								<input ng-model="objCatering.cedulaJuridica" type="text"
									name="cedulaJuridica" placeholder="3-TTT-CCCCCC"
									data-trigger="keyup" class="form-control" required />
							</div>
						</div>
						<!--Dirección-->
						<div class="form-group">
							<label class="col-lg-3 control-label">Dirección</label>
							<div class="col-lg-8">
								<textarea ng-model="objCatering.direccion" name="direccion"
									placeholder="200 metros sur del walmart" rows="5"
									class="form-control" data-trigger="keyup" ng-maxlength="250"
									required></textarea>
								<span class="error-message"
									ng-show="crearCatering.direccion.$error.maxlength">Solo
									puede ingresar 200 caracteres.</span>
							</div>
						</div>
						<!-- Teléfono1 -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Teléfono</label>
							<div class="col-lg-8">
								<input ng-model="objCatering.telefono1" type="text"
									name="telefono1" placeholder="88888888" class="form-control"
									ng-pattern="/^(\d)+$/" ng-maxlength="8" ng-minlength="8"
									data-trigger="keyup" required /> <span class="error-message"
									ng-show="crearCatering.telefono1.$error.pattern">Debe
									ingresar solo números.</span><span class="error-message"
									ng-show="crearCatering.telefono1.$error.maxlength">Debe
									ingresar 8 números como máximo.</span> <span class="error-message"
									ng-show="crearCatering.telefono1.$error.minlength">Debe
									ingresar 8 números como mínimo.</span>
							</div>
						</div>
						<!-- Teléfono2 -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Teléfono
								alternativo</label>
							<div class="col-lg-8">
								<input ng-model="objCatering.telefono2" type="text"
									name="telefono2" placeholder="22223333" class="form-control"
									ng-pattern="/^(\d)+$/" ng-maxlength="8" ng-minlength="8" /> <span
									class="error-message"
									ng-show="crearCatering.telefono2.$error.pattern">Debe
									ingresar solo números.</span><span class="error-message"
									ng-show="crearCatering.telefono2.$error.maxlength">Debe
									ingresar 8 números como máximo.</span> <span class="error-message"
									ng-show="crearCatering.telefono2.$error.minlength">Debe
									ingresar 8 números como mínimo.</span>
							</div>
						</div>
						<div class="form-group">
							<div ng-dropdown-multiselect="" options="listaTipoEvento"
								selected-model="tipoEvento"></div>
						</div>
						<!-- Tipo eventos -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Tipo de Evento</label>
							<div class="col-lg-8">
								<select name="idTipo" id="idTipo" class="form-control" multiple
									ng-multiple="true" ng-model="objCatering.tipoEventos"
									ng-options="te.idTipo as te.nombre for te in listaTipoEvento" required>
								</select>
							</div>
						</div>
					</div>
				</section>
			</div>
			<div class="col-sm-6">
				<section class="panel">
					<div class="panel-body">
						<!-- Horario atencion -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Horario atención</label>
							<div class="col-lg-8">

								<textarea ng-model="objCatering.horarioAtencion"
									name="horarioAtencion" data-trigger="keyup"
									placeholder="Lunes a Viernes de 10am a 5pm" rows="5"
									class="form-control" data-trigger="keyup" ng-maxlength="250"
									required></textarea>
								<span class="error-message"
									ng-show="crearCatering.horarioAtencion.$error.maxlength">Solo
									puede ingresar 200 caracteres.</span>
							</div>
						</div>
						<!-- Provincia -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Provincia</label>
							<div class="col-lg-4">
								<select name="idProvincia" id="idProvincia" class="form-control"
									ng-model="objCatering.idProvincia" ng-change="llenarCanton()"
									ng-options="p.idProvincia as p.nombre for p in listaProvincia">
								</select>
							</div>
						</div>
						<!-- Cantón -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Canton</label>
							<div class="col-lg-4">
								<select name="idCanton" id="idCanton" class="form-control"
									ng-model="objCatering.idCanton" ng-change="llenarDistrito()"
									ng-options="c.idCanton as c.nombre for c in listaCanton">
								</select>
							</div>
						</div>
						<!-- Distrito -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Distrito</label>
							<div class="col-lg-4">
								<select name="idDistrito" id="idDistrito" class="form-control"
									ng-model="objCatering.idDistrito"
									ng-options="d.idDistrito as d.nombre for d in listaDistrito">
								</select>
							</div>
						</div>
						<!-- Foto -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Logo</label>
							<div class="col-lg-9 media">
								<div
									class="bg-light pull-left text-center media-large thumb-large">
									<i
										class="fa fa-user inline fa fa-light fa fa-3x m-t-large m-b-large"></i>
								</div>
								<div class="media-body">
									<input ng-file-select="onFileSelect($files)" type="file"
										name="logo" title="Examinar"
										class="btn btn-sm btn-info m-b-small" /> <br>
								</div>
							</div>
						</div>
						<div class="form-group"></div>
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