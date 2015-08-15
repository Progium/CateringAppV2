<section class="main padder">
	<div class="clearfix">
		<h4>
			<i class="fa fa-edit"></i> Ver Perfil
		</h4>
	</div>
	<div class="row">
		<form class="form-horizontal" name="perfilUsuario"
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
								<div class="media-body">
									<input ng-file-select="onFileSelect($files)" type="file"
										name="foto" title="Examinar"
										class="btn btn-sm btn-info m-b-small" /> <br>
								</div>
							</div>
						</div>
						<!-- Nombre -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Nombre</label>
							<div class="col-lg-8">
								<input ng-model="usuario.nombre" type="text" name="nombre"
									placeholder="Marcela" class="form-control" required
									ng-pattern="/^(\D)+$/" /> <span class="error-message"
									ng-show="perfilUsuario.nombre.$error.pattern">Debe
									ingresar solo letras</span>
							</div>
						</div>

						<!-- Primer Apellido -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Primer Apellido</label>
							<div class="col-lg-8">
								<input ng-model="usuario.apellido1" type="text" name="apellido1"
									placeholder="Leandro" class="form-control" required
									ng-pattern="/^(\D)+$/" /> <span class="error-message"
									ng-show="perfilUsuario.apellido1.$error.pattern">Debe
									ingresar solo letras</span>
							</div>
						</div>

						<!-- Segundo Apellido -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Segundo Apellido</label>
							<div class="col-lg-8">
								<input ng-model="usuario.apellido2" type="text" name="apellido2"
									placeholder="Picado" class="form-control"
									ng-pattern="/^(\D)+$/" /> <span class="error-message"
									ng-show="perfilUsuario.apellido2.$error.pattern">Debe
									ingresar solo letras</span>
							</div>
						</div>

						<!-- Correo -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Correo</label>
							<div class="col-lg-8">
								<input ng-model="usuario.correo" type="email" id="email"
									placeholder="marce@gmail.com" class="bg-focus form-control"
									required ng-disabled="true" />
							</div>
						</div>

						<!-- Teléfono1 -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Teléfono</label>
							<div class="col-lg-8">
								<input ng-model="usuario.telefono1" type="text" name="telefono1"
									placeholder="2574-5432" class="form-control"
									ng-pattern="/^\d{4}-?\d{4}$/" required /> <span
									class="error-message"
									ng-show="perfilUsuario.telefono1.$error.pattern">Debe
									ingresar solo números, el formato de télefono es ####-####,
									debe ingresar 8 números.</span>
							</div>
						</div>

						<!-- Teléfono2 -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Teléfono
								alternativo</label>
							<div class="col-lg-8">
								<input ng-model="usuario.telefono2" type="text" name="telefono2"
									placeholder="4051-7645" class="form-control"
									ng-pattern="/^\d{4}-?\d{4}$/" /> <span class="error-message"
									ng-show="perfilUsuario.telefono2.$error.pattern">Debe
									ingresar solo números, el formato de télefono es ####-####,
									debe ingresar 8 números.</span>
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
										name="checkbox" ng-true-value="2" ng-false-value="1"
										ng-disabled="true" readOnly="true"> Quiero ser usuario administrador.
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
									class="bg-focus form-control" required />
							</div>
						</div>
						<div class="form-group"></div>
						<!-- Repetir Contraseña -->
						<div class="form-group">
							<label class="col-lg-3 control-label">Repetir Contraseña</label>
							<div class="col-lg-8">
								<input ng-model="usuario.repetirContrasenna" type="password"
									name="password" placeholder="Password"
									class="bg-focus form-control" required />
							</div>
						</div>
						<div class="form-group"></div>
						<div class="form-group"></div>
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
						<div class="form-group"></div>
						<div class="form-group"></div>
						<div class="form-group"></div>
					</div>
				</section>
			</div>

		</form>
	</div>
</section>
