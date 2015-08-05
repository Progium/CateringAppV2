<!-- .sidebar -->
<section class="main padder">
	<div class="clearfix">
		<h4>
			<i class="fa fa-edit"></i> Busqueda de Catering
		</h4>
	</div>
	<div class="row">
		<div class="col-sm-3">
			<aside class="sidebar bg-lighter"
				ng-controller="CateringBuscarController">
				<div class="bg-light padder padder-v" style="padding-bottom: 5px;">
					<span class="h4 col-lg-offset-1">Criterio de busquedas</span>
				</div>
				<ul class="list-group list-normal m-b-none">
					<li class="list-group-item">
						<!-- radio -->
						<div class="radio">
							<label class="col-lg"> <input
								ng-model="criterioBusqueda" type="radio" name="radio"
								value="1"> <b>Nombre</b>
							</label>
						</div> <input type="text" name="buscar" placeholder="Buscar..."
						data-required="true" class="form-control input-sm">
					</li>
					<!-- radio -->
					<div class="radio">
						<label class="col-lg-2"> <input
							ng-model="criterioBusqueda" type="radio" name="radio"
							value="2"> <b>Localización</b>
						</label>
					</div>

					<li class="list-group-item">Provincia <select
						name="idProvincia" id="idProvincia" class="form-control"
						ng-model="objCatering.idProvincia" ng-change="llenarCanton()"
						ng-options="p.idProvincia as p.nombre for p in listaProvincia">
					</select>
					</li>
					<li class="list-group-item">Cantón <select name="idCanton"
						id="idCanton" class="form-control" ng-model="objCatering.idCanton"
						ng-change="llenarDistrito()"
						ng-options="c.idCanton as c.nombre for c in listaCanton">
					</select>
					</li>
					<li class="list-group-item">Distrito <select name="idDistrito"
						id="idDistrito" class="form-control"
						ng-model="objCatering.idDistrito"
						ng-options="d.idDistrito as d.nombre for d in listaDistrito">
					</select>
					</li>
					<li class="list-group-item">
						<!-- radio -->
						<div class="radio">
							<label class="col-lg-14"> <input
								ng-model="criterioBusqueda" type="radio" name="radio"
								value="3"> <b>Tipo de Evento</b>
							</label>
						</div> <select name="idTipo" id="idTipo" class="form-control"
						ng-model="objCatering.idTipoEvento"
						ng-options="te.idTipo as te.nombre for te in listaTipoEvento"
						required>
					</select>
					</li>
					<li class="list-group-item pull-right">
						<button type="submit" class="btn btn-primary">Buscar</button>
					</li>
				</ul>
			</aside>
		</div>

		<div class="col-sm-6">
			<section class="panel">
				<header class="panel-heading">Lista de Catering Services</header>
				<div class="table-responsive">
					<table class="table table-striped b-t text-small">
						<thead>
							<tr>
								<th>Nombre</th>
								<th>Ubicacion</th>
								<th width="70"></th>
								<th width="70"></th>
							</tr>
						</thead>
						<tbody ng-repeat="catering in cateringLista2">
							<tr>
								<td>{{catering.nombre}}</td>
								<td>{{catering.direccion}}</td>
								<td class="text-right">
									<div class="btn-group">
										<button type="button" class="btn btn-primary"
											ng-click="openModal(catering)">Mostrar Detalle</button>
									</div>
								</td>
								<td class="text-right">
									<div class="btn-group">
										<button type="button" class="btn btn-primary"
											ng-click="openModal(catering)">Ver paquetes</button>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
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
		</div>
	</div>
</section>