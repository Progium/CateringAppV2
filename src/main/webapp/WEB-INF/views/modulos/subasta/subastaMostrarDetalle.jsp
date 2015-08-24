<section class="main padder">
	<div class="clearfix">
		<h4>
			<i class="fa fa-edit imagen-title"></i> Subasta {{subasta.nombre}}
		</h4>
	</div>
	<div class="row">
		<form class="form-horizontal" name="crearSubasta"
			data-validate="parsley">
			<div class="col-sm-12">
				<section class="panel">
					<div class="panel-body">
						<div class="form-group">
							<label class="col-lg-3 control-label">Nombre del
								interesado</label>
							<div class="col-lg-8">
								<input ng-model="subasta.nombre" type="text" name="nombre"
									class="form-control" ng-disabled="true" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-3 control-label">Tipo de evento</label>
							<div class="col-lg-8">
								<input ng-model="subasta.nombreTipoEvento" type="text"
									name="nombreTipoEvento" class="form-control" ng-disabled="true" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-3 control-label">Fecha de evento</label>
							<div class="col-lg-8">
								<input ng-model="subasta.fechaEvento" type="text"
									name="fechaEvento" class="form-control" ng-disabled="true" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-3 control-label">Cantidad de
								personas</label>
							<div class="col-lg-8">
								<input type="number" class="input-sm spinner-input form-control"
									name="cantidadPersonas" maxlength="3"
									ng-model="subasta.cantidadPersonas" min="1" max="5000"
									ng-disabled="true" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-3 control-label">Descripción</label>
							<div class="col-lg-8">
								<textarea ng-model="subasta.descripcion" name="descripcion"
									placeholder="Platillos fuertes y entradas" rows="5"
									class="form-control" data-trigger="keyup" ng-maxlength="250"
									ng-disabled="true"></textarea>
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-3 control-label">Presupuesto
								disponible</label>
							<div class="col-lg-8 input-group">
								<span class="input-group-addon">¢</span> <input
									class="input-sm form-control inputMonto" type="text"
									aria-label="Amount (to the nearest dollar)"
									ng-model="subasta.montoMaximo" placeholder="250000"
									ng-disabled="true" />
							</div>
						</div>
					</div>
				</section>
			</div>
		</form>
	</div>
</section>