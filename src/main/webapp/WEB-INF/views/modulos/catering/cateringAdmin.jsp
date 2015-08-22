<section class="main padder">
	<div class="clearfix">
		<h4>
			<i class="fa fa-edit imagen-title"></i> {{tituloPagina}}
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
									data-trigger="keyup" required />
							</div>
						</div>
						<!-- Cedula física o jurídica -->
						<div class="form-group">
							<label class="col-lg-3 control-label radio-tipo"> <input
								ng-model="objCatering.tipoCedula" type="radio" name="radio"
								ng-change="validarFormatoCedula()" value="1">Cédula
								física
							</label> <label class="col-lg-3 control-label "> <input
								ng-model="objCatering.tipoCedula" type="radio" name="radio"
								ng-change="validarFormatoCedula()" value="2">Cédula
								jurídica
							</label>
							<div class="col-lg-8">
								<input ng-model="objCatering.cedula" type="text" name="cedula"
									placeholder="{{placeholder}}" ng-pattern="exp"
									data-trigger="keyup" class="form-control input-cedula" required />
							</div>
							<div class="col-lg-8 msj-error">
								<span class="error-message"
									ng-show="crearCatering.cedula.$error.pattern">{{msj}}</span>
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
									name="telefono1" placeholder="2574-5432" class="form-control"
									ng-pattern="/^\d{4}-?\d{4}$/" data-trigger="keyup" required />
								<span class="error-message"
									ng-show="crearCatering.telefono1.$error.pattern">Debe
									ingresar solo números, el formato de télefono es ####-####,
									debe ingresar 8 números.</span>
							</div>
						</div>
						<!-- Teléfono2 -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Teléfono
								alternativo</label>
							<div class="col-lg-8">
								<input ng-model="objCatering.telefono2" type="text"
									name="telefono2" placeholder="4051-7645" class="form-control"
									ng-pattern="/^\d{4}-?\d{4}$/" /> <span class="error-message"
									ng-show="crearCatering.telefono2.$error.pattern">Debe
									ingresar solo números, el formato de télefono es ####-####,
									debe ingresar 8 números.</span>
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
									ng-options="te.idTipo as te.nombre for te in listaTipoEvento"
									required>
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
									<i ng-show="mostrarImagen == false"
										class="fa fa-user inline fa fa-light fa fa-3x m-t-large m-b-large"></i> <i ng-show="mostrarImagen == true"
										class="fa inline fa fa-light fa fa-3x m-t-large"><img
										ng-src={{files[0]}} /></i>
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
						<div class="form-group"></div>
						<div class="form-group"></div>
						<div class="form-group"></div>
					</div>
				</section>
			</div>

		</form>
	</div>
</section>