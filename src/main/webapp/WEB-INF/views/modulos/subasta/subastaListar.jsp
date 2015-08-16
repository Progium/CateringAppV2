<section class="main padder">
	<div class="clearfix">
		<h4>
			<i class="fa fa-table"></i>Lista Subasta
		</h4>
	</div>
	<div class="row">
		<div class="col-lg-6">
			<section class="panel">
				<table class="table table-striped m-b-none text-small">
					<thead>
						<tr>
							<th>Nombre</th>
							<th>Fecha Evento</th>
							<th>Monto Máximo</th>
							<th width="70"></th>
							<th width="70" ng-show="mostrarBotonSubasta"></th>
							<th width="70" ng-show="mostrarBotonPropuesta"></th>
						</tr>
					</thead>
					<tbody ng-repeat="subasta in subastaLista">
						<tr>
							<td>{{subasta.nombre}}</td>
							<td>{{subasta.fechaEvento}}</td>
							<td>{{subasta.montoMaximo}}</td>
							<td class="text-right">
								<div class="btn-group">
									<button type="button" class="btn btn-primary"
										ng-click="openModalDetalleSubasta(subasta)">Mostrar
										Detalle</button>
								</div>
							</td>
							<td class="text-right" ng-show="mostrarBotonPropuesta">
								<div class="btn-group">
									<button type="button" class="btn btn-primary"
										ng-click="verPropuestas(subasta.idSubasta)">Ver
										Propuesta</button>
								</div>
							</td>
							<td class="text-right" ng-show="mostrarBotonSubasta">
								<div class="btn-group">
									<button type="button" class="btn btn-primary"
										ng-click="participarSubasta(subasta.idSubasta)">Participar</button>
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
			<button ng-show="mostrarBoton" type="submit" class="btn btn-primary"
				ng-click="registrar()">Registrar Subasta</button>
		</div>
		<div class="col-sm-6" ng-show="mostrarTablaListPaquete">
			<section class="panel">
				<header class="panel-heading">Lista de propuestas de paquetes del
					Catering</header>
				<table class="table table-striped m-b-none text-small">
					<thead>
						<tr>
							<th>Catering</th>
							<th>Nombre Paquete</th>
							<th>Costo</th>
							<th>Estado Propuesta</th>
							<th width="70"></th>
							<th width="70"></th>
						</tr>
					</thead>
					<tbody ng-repeat="paquete in listaPaquete">
						<tr>
							<td>{{paquete.nombreCatering}}</td>
							<td>{{paquete.nombre}}</td>
							<td>{{paquete.montoTotal}}</td>
							<td>{{paquete.estadoPropuesta}}</td>
							<td class="text-right">
								<div class="btn-group">
									<button type="button" class="btn btn-primary"
										ng-click="openModalDetallePaquete(paquete)">Mostrar
										Detalle</button>
								</div>
							</td>
							<td class="text-right">
								<div class="btn-group">
									<button type="button" class="btn btn-primary" ng-disabled="paquete.tipoTransaccion != 0"
										ng-click="AcceptarPropuesta(paquete)">Elegir</button>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
			</section>
		</div>
	</div>
</section>
