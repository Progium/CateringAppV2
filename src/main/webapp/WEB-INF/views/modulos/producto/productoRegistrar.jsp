<section class="main padder" ng-controller="ProductoRegistrarController">

	<div class="row">
		<div class="col-sm-2"></div>
		<div class="col-sm-8">
			<div class="clearfix">
				<h4>
					<i class="fa fa-edit imagen-title"></i>Mi Catálogo
				</h4>
			</div>
			<div class="form-group">
				<label class="col-lg-8 categoria-style">Categoría:</label>
  				
					<select name="idCategoria" id="idCategoria" ng-model="objCategoria.idCategoria" 
							ng-options="cat.idCategoria as cat.nombre for cat in listaCategorias"
							ng-change="cargarProducto()" class="form-control">
					</select>
			</div>
			<div class="col-xs-6">
				<section class="panel">
					<header class="panel-heading bg-white">
						<div class="text-center h5">Productos seleccionados</div>
						<div class="panel-body pull-in text-center">
							Buscar: <input type="search" ng-model="a" placeholder="búsqueda de productos" class="form-control" style="margin-bottom: 10px">
						<table class="table-bordered table">
							<th>
							<th>Nombre</th>
							<th>Añadir a catálogo</th>
							<tr ng-repeat="productoSelec in productosSelecc | filter:a as results">
								<td>
									<button type="button"  class="fa fa-arrow-right" title="Remover" ng-click="removido(productoSelec, 'removido')"></button>
								</td>
								<td>
									<span>{{productoSelec.nombre}}</span>
								</td>
								<td><button type="button" class="fa fa-cutlery" title="Añadir" ng-click="openModal(productoSelec)"></button></td>
							</tr>
						</table>
						</div>
					</header>
				</section>
			</div>
			
			<div class="col-xs-6">
				<section class="panel">
					<header class="panel-heading bg-white">
						<div class="text-center h5">Lista de productos</div>
						<div class="panel-body pull-in text-center">
							Buscar: <input type="search" ng-model="q" placeholder="búsqueda de productos" class="form-control"
							style="margin-bottom: 10px">
						<table class="table-bordered table">
							<th>
							<th>Nombre</th>
							<tr ng-repeat="producto in productos | filter:q as results"  >
								<td>
									<button type="button" class="fa fa-arrow-left" title="Agregar" ng-click="seleccionado(producto, 'agregar')"></button>
								</td>
								<td>
									<span>{{producto.nombre}}</span>
								</td>
							</tr>
						</table>		
						</div>
					</header>
				</section>
			</div>
	</div>					
	</div>
</section>