<section class="main padder">
	<div class="clearfix">
		<h4>
			<i class="fa fa-table imagen-title"></i>Mis Paquetes
		</h4>
	</div>
	<div class="row">
		<div class="col-lg-8">
			<section class="panel">
					<table class="table table-striped m-b-none text-small">
						<thead>
							<tr>
								<th>Nombre Paquete</th>
								<th>Catering</th>
								<th>Tipo Evento</th>
								<th>Costo</th>
								<th width="70"></th>
								<th width="70" ng-show="mostrarBoton"></th>
							</tr>
						</thead>
						<tbody ng-repeat="paquete in paquetesLista">
							<tr>
								<td>{{paquete.nombre}}</td>
								<td>{{paquete.nombreCatering}}</td>
								<td>{{paquete.nombreTipoEvento}}</td>
								<td>¢ {{paquete.montoTotal}}</td>
								<td class="text-right">
									<div class="btn-group">
										<button type="button" class="btn btn-primary"
											ng-click="openModalDetallePaquete(paquete)">Mostrar
											Detalle</button>
									</div>
								</td>
								<td class="text-right" ng-show="mostrarBoton">
									<div class="btn-group">
										<button type="button" class="btn btn-primary"
											ng-click="enviarPaquete(paquete)">Enviar Paquete</button>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
					<footer class="panel-footer">
						<div class="row">
							<div class="col-sm-2 text-center">
								<small class="text-muted inline m-t-small m-b-small">{{cantResult}}
									de {{totalItems}}</small>
							</div>
							<div class="col-sm-10 text-right text-center-sm">
								<ul class="pagination pagination-small m-t-none m-b-none">
									<pagination boundary-links="true" total-items="totalItems"
										page="currentPage" ng-click="setPage(currentPage)"
										class="pagination-sm" items-per-page="5"
										previous-text="&lsaquo;" next-text="&rsaquo;"
										first-text="&laquo;" last-text="&raquo;"></pagination>
								</ul>
							</div>
						</div>
					</footer>
			</section>
			<button type="submit" class="btn btn-primary" ng-click="registrar()">Registrar
				Paquete</button>
		</div>
	</div>
</section>
