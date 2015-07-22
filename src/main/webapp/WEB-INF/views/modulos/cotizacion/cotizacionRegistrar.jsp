<section class="main padder"
	ng-controller="CotizacionRegistrarController">
	<div class="row">
		<div class="col-lg-5  col-lg-offset-3">
			<section class="panel">
				<header class="panel-heading text-center"> Creaff
					Cotización </header>
				<div class="panel-body">
					<form class="form-horizontal" method="get" data-validate="parsley">
						<div class="form-group">
							<label class="col-lg-3 control-label">Fecha inicio evento</label>
							<div class="col-lg-5">
								<input type="date" name="fechaInicio" />>
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-3 control-label">Fecha final</label>
							<div class="col-lg-5">
								<input type="date" name="fechaFin" />>
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-3 control-label">Lugar</label>
							<div class="col-lg-5">
								<textarea name="lugar" class="form-control"
									style="max-width: 207px; max-height: 130px; resize: none;"></textarea>
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-3 control-label">Descripcion</label>
							<div class="col-lg-5">
								<textarea name="lugar" class="form-control"
									style="max-width: 207px; max-height: 130px; resize: none;"></textarea>
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-3 control-label">Cantidad de
								personas</label>
							<div class="col-lg-5">
								<input type="text" name="cantPersonas">
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-3 control-label">Cantidad de
								saloneros</label>
							<div class="col-lg-5">
								<input type="text" name="cantSaloneros">
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-3 control-label">Ayudante cocina</label>
							<div class="col-lg-5">
								<input type="radio" name="ayudanteCoc" value="si">Si <input
									type="radio" name="ayudanteCoc" value="no" checked>No
							</div>
						</div>
					</form>
					<br>
					<div class="form-group">
						<div class="col-lg-9 col-lg-offset-5">
							<button type="submit" class="btn btn-primary">Guardar</button>

							<button type="submit" class="btn btn-primary">Cancelar</button>
						</div>
					</div>
			</section>
		</div>
	</div>
	
</section>