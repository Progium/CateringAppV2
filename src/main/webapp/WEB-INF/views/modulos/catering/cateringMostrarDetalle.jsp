<section class="main padder">
	<div class="clearfix">
		<h4>
			<i class="fa fa-edit"></i> Catering {{objCatering.nombre}}
		</h4>
	</div>
	<div class="row">
		<form class="form-horizontal" name="crearCatering"
			data-validate="parsley">

			<div class="col-sm-12">
				<section class="panel">
					<div class="panel-body">
						<!-- Foto -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Logo</label>
							<div class="col-lg-9 media">
								<div
									class="bg-light pull-left text-center media-large thumb-large">
									<i ng-show="mostrarImagen == false"
										class="fa fa-user inline fa fa-light fa fa-3x m-t-large m-b-large"></i>
									<i ng-show="mostrarImagen == true"
										class="fa inline fa fa-light fa fa-3x m-t-large"><img
										ng-src={{catering.fotografia}} /></i>
								</div>
							</div>
						</div>
						<!-- Nombre -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Nombre</label>
							<div class="col-lg-8">
								<input ng-model="catering.nombre" type="text" name="nombre"
									placeholder="Isild's Catering" class="form-control"
									data-trigger="keyup" ng-disabled="true" />
							</div>
						</div>
						<!-- Cedula f�sica o jur�dica -->
						<div class="form-group">
							<label class="col-lg-3 control-label">C�dula</label>
							<div class="col-lg-8">
								<input ng-model="catering.cedula" type="text" name="cedula"
									data-trigger="keyup" class="form-control" ng-disabled="true" />
							</div>
						</div>
						<!--Direcci�n-->
						<div class="form-group">
							<label class="col-lg-3 control-label">Direcci�n</label>
							<div class="col-lg-8">
								<textarea ng-model="catering.direccion" name="direccion"
									placeholder="200 metros sur del walmart" rows="5"
									class="form-control" data-trigger="keyup" ng-maxlength="250"
									ng-disabled="true"></textarea>
							</div>
						</div>
						<!-- Tel�fono1 -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Tel�fono</label>
							<div class="col-lg-8">
								<input ng-model="catering.telefono1" type="text"
									name="telefono1" placeholder="2574-5432" class="form-control"
									data-trigger="keyup" ng-disabled="true" />
							</div>
						</div>
						<!-- Tel�fono2 -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Tel�fono
								alternativo</label>
							<div class="col-lg-8">
								<input ng-model="catering.telefono2" type="text"
									name="telefono2" placeholder="4051-7645" class="form-control"
									ng-disabled="true" />
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
									ng-multiple="true" ng-model="catering.tipoEventos"
									ng-options="te.idTipo as te.nombre for te in listaTipoEvento"
									required>
								</select>
							</div>
						</div>
						<!-- Horario atencion -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Horario atenci�n</label>
							<div class="col-lg-8">

								<textarea ng-model="catering.horarioAtencion"
									name="horarioAtencion" data-trigger="keyup"
									placeholder="Lunes a Viernes de 10am a 5pm" rows="5"
									class="form-control" data-trigger="keyup" ng-maxlength="250"
									ng-disabled="true"></textarea>
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
						<!-- Cant�n -->
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
					</div>
				</section>
			</div>

		</form>
	</div>
</section>