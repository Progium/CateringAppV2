<section class="main padder">
	<div class="clearfix">
		<h4>
			<i class="fa fa-edit"></i> {{tituloPagina}}
		</h4>
	</div>
	<form class="form-horizontal" name="crearSubasta"
		data-validate="parsley">
			<div class="col-sm-6">
				<section class="panel">
					<div class="panel-body">
						<div class="form-group">
							<label class="col-lg-3 control-label">Nombre del interesado</label>
							<div class="col-lg-8">
								<input ng-model="objSubasta.nombre" type="text"
									name="nombre" placeholder="Pedro" class="form-control"
									required/>
               				</div>
           				</div>
            			<div class="form-group">
              				<label class="col-lg-3 control-label">Tipo de evento</label>
              				<div class="col-lg-8">
								<select name="idTipo" class="form-control" id="idTipo" ng-model="objSubasta.idTipo" 
										ng-options="tip.idTipo as tip.nombre for tip in listaTipoEvento"
										ng-change="cargarProducto()">
								</select>
              				</div>
            			</div>
            			<div class="form-group">
              				<label class="col-lg-3 control-label">Fecha de evento</label>
              				<div class="col-lg-8">
               				 <input class="input-sm form-control" type="date"  ng-model="objSubasta.fechaEvento" required/>
              				</div>
            			</div>
            			<div class="form-group">
              				<label class="col-lg-3 control-label">Cantidad de personas</label>
              				<div class="col-lg-8">
               				 <input class="input-sm form-control" type="text" placeholder="50" ng-model="objSubasta.CantPersonas" required/>
              				</div>
            			</div>
            			<div class="form-group">
              				<label class="col-lg-3 control-label">Descripción</label>
              				<div class="col-lg-8">
               					<textarea ng-model="objSubasta.descripcion" name="descripcion"
									placeholder="Platillos fuertes y entradas" rows="5"
									class="form-control" data-trigger="keyup" ng-maxlength="250"
									required></textarea>
								<span class="error-message"
									ng-show="crearSubasta.descripcion.$error.maxlength">Solo
									puede ingresar 200 caracteres.</span>
               				</div>
            			</div>
            			<div class="form-group">
              				<label class="col-lg-3 control-label">Monto máximo</label>
              				<div class="col-lg-8">
               				 <input class="input-sm form-control" type="text"  ng-model="objSubasta.montoMaximo" placeholder="250000" required/>
              				</div>
            			</div>
						<div class="form-group"></div>
						<div class="form-group">
							<div class="col-lg-9 col-lg-offset-7">
								<button type="submit" class="btn btn-white"
									ng-click="cancelar()">Cancelar</button>
								<button type="submit" class="btn btn-info" ng-click="create()">Guardar</button>
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