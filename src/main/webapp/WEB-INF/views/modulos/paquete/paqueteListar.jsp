<section class="main padder">
  <div class="clearfix">
    <h4><i class="fa fa-edit"></i>Lista de Paquetes</h4>
  </div>
  <div class="col-sm-6">
			<section class="panel">
				<header class="panel-heading">Paquetes</header>
				<div class="table-responsive">
					<table class="table table-striped b-t text-small">
						<thead>
							<tr>
								<th>Nombre</th>
								<th>Catering</th>
								<th>Tipo Evento</th>
								<th>Costo</th>
								<th width="60"></th>
								
							</tr>
						</thead>
						<tbody ng-repeat="paquete in paqueteLista">
							<tr>
								<td>{{paquete.nombre}}</td>
								<td>{{paquete.catering_id}}</td>
								<td>{{paquete.evento_id}}</td>
								<td>{{paquete.precio}}</td>
								<td class="text-right">
									<div class="btn-group">
										<button type="button" class="btn btn-primary"
											ng-click="openModal(paquete)">Ver Paquete</button>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				
				<footer class="panel-footer">
					<div class="row">
						<div class="col-sm-2 text-center">
							<small class="text-muted inline m-t-small m-b-small">{{}}
								{{totalItems}}</small>
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
		<button type="submit" class="btn btn-primary" ng-click="registrar()">Registrar Paquete</button>
		</div>
	
</section>