<section class="main padder">
	<div class="clearfix">
		<h4>
			<i class="fa fa-table"></i>Catálogo de producto
		</h4>
	</div>
	<!-- Lista de caterings -->
	<label class="col-lg-1 titleLista">Caterings</label>
	<div class="col-lg-3">
		<select name="idCatering" id="idCatering" class="form-control"
			ng-model="objPaquete.idCatering"
			ng-options="lc.idCatering as lc.nombre for lc in listaCaterings"
			ng-change="llenarCatalogoProducto()" required>
		</select>
	</div>
	<div class="row">
		<div class="col-lg-8 paddingTable">
			<section class="panel">
				<table class="table table-striped m-b-none text-small">
					<thead>
						<tr>
							<th>Categoría</th>
							<th>Producto</th>
							<th>Precio</th>
						</tr>
					</thead>
					<tbody ng-repeat="producto in listaProductos">
						<tr>
							<td>{{producto.categoriaNombre}}</td>
							<td>{{producto.nombre}}</td>
							<td>{{producto.precio}}</td>
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
			<button type="submit" class="btn btn-primary"
				ng-click="agregarProducto()">Agregar productos al catalogo</button>
		</div>
	</div>
</section>
