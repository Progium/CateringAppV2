<section class="main padder">
	<div class="clearfix">
		<h4>
			<i class="fa fa-table"></i>Mis Paquetes
		</h4>
	</div>
	<div class="row">
		<div class="col-lg-8">
			<section class="panel">
				<div>

					<table class="table table-striped m-b-none text-small">
						<thead>
							<tr>
								<th>Nombre</th>
								<th>Catering</th>
								<th>Tipo Evento</th>
								<th>Costo</th>
								<th width="70"></th>
							</tr>
						</thead>
						<tbody ng-repeat="paquete in paquetesLista">
							<tr>
								<td>{{paquete.nombre}}</td>
								<td>{{paquete.catering_id}}</td>
								<td>{{paquete.evento_id}}</td>
								<td>{{paquete.precio}}</td>
								<td class="text-right">
									<div class="btn-group">
										<button type="button" class="btn btn-primary"
											ng-click="openModal(paquete)">Mostrar Detalle</button>
									</div>
								</td>
								<!-- <td class="text-right">
									<div class="btn-group">
										<button type="button" class="btn btn-primary"
											ng-click="modificar(paquete.idPaquete)">Modificar</button>
									</div>
								</td> -->
							</tr>
						</tbody>
					</table>
			</section>
			<button type="submit" class="btn btn-primary" ng-click="registrar()">Registrar
				Paquete</button>
		</div>
	</div>
</section>
