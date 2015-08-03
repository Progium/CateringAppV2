<section class="main padder">
	<div class="clearfix">
		<h4>
			<i class="fa fa-edit"></i> Ver Perfil
		</h4>
	</div>
	<div class="row">
		<form class="form-horizontal" name="PerfilUsuario"
			data-validate="parsley">

			<div class="col-sm-6">
				<section class="panel">
					<div class="panel-body">
						<div class="form-group">
							<h4 class="posicion">Datos Personales</h4>
						</div>
						<!-- Foto -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Foto</label>
							<div class="col-lg-8 media">
								<div
									class="bg-light pull-left text-center media-large thumb-large">
									<i ng-show="mostrarImagen == false"
										class="fa fa-user inline fa fa-light fa fa-3x m-t-large m-b-large"></i>
									<i ng-show="mostrarImagen == true"
										class="fa inline fa fa-light fa fa-3x m-t-large"><img
										ng-src={{usuario.fotografia}} /></i>
								</div>
								
							</div>
						</div>

						<!-- Nombre -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Nombre</label>
							<div class="col-lg-8">
								<input ng-model="usuario.nombre" type="text" name="nombre"
									class="form-control" ng-disabled="true" />
							</div>
						</div>

						<!-- Primer Apellido -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Primer Apellido</label>
							<div class="col-lg-8">
								<input ng-model="usuario.apellido1" type="text" name="apellido1"
									class="form-control" ng-disabled="true" />
							</div>
						</div>

						<!-- Segundo Apellido -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Segundo Apellido</label>
							<div class="col-lg-8">
								<input ng-model="usuario.apellido2" type="text" name="apellido2"
									class="form-control" ng-disabled="true" />
							</div>
						</div>

						<!-- Correo -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Correo</label>
							<div class="col-lg-8">
								<input ng-model="usuario.correo" type="email" id="email"
									class="form-control" ng-disabled="true" />
							</div>
						</div>

						<!-- Teléfono1 -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Teléfono1</label>
							<div class="col-lg-8">
								<input ng-model="usuario.telefono1" type="text" name="telefono1"
									class="form-control" ng-disabled="true" />
							</div>
						</div>

						<!-- Teléfono2 -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Teléfono2</label>
							<div class="col-lg-8">
								<input ng-model="usuario.telefono2" type="text" name="telefono2"
									class="form-control" ng-disabled="true" />
							</div>
						</div>
					</div>
				</section>
			</div>

			<!-- Datos de la cuenta -->
			<div class="col-sm-6">
				<section class="panel">
					<div class="panel-body">
						<div class="form-group">
							<h4 class="posicion">Datos de la Cuenta</h4>
						</div>
						<div class="form-group"></div>
						<div class="form-group"></div>
						<!-- Tipo de usuario -->
						<div class="form-group">
							<div class="col-lg-8">
								<!-- checkbox -->
								<div class="checkbox">
									<label class="control-label"> <input
										ng-model="usuario.tipoUsuarioId" type="checkbox"
										name="checkbox" ng-true-value="2" ng-false-value="1" ng-disabled="true">
										Quiero ser usuario administrador.
									</label>
								</div>
							</div>
						</div>
						<div class="form-group"></div>
						<!-- Contraseña -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Contraseña</label>
							<div class="col-lg-8">
								<input ng-model="usuario.contrasenna" type="password"
									name="password" placeholder="Password"
									class="form-control" ng-disabled="true" />
							</div>
						</div>
						<div class="form-group"></div>
						<!-- Repetir Contraseña -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Repetir Contraseña</label>
							<div class="col-lg-8">
								<input ng-model="usuario.repetirContrasenna" type="password"
									name="password" placeholder="Password"
									class="form-control" ng-disabled="true"/>
							</div>
						</div>
						<div class="form-group"></div>
						<div class="form-group"></div>
						<div class="form-group"></div>
						<div class="form-group">
							<div class="col-lg-9 col-lg-offset-7">
								<button type="submit" class="btn btn-white" ng-show="false"
									ng-click="cancelar()">Cancelar</button>
								<button type="submit" class="btn btn-info" ng-show="false" ng-click="guardar()">Guardar</button>
							</div>
						</div>
						<div class="form-group"></div>
						<div class="form-group"></div>
						<div class="form-group"></div>
						<div class="form-group"></div>
						<div class="form-group"></div>
						<div class="form-group"></div>
					</div>
				</section>
			</div>

		</form>
	</div>
</section>
