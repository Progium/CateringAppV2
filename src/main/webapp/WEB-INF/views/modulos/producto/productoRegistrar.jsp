<section class="main padder" ng-controller="ProductoRegistrarController">

	<div class="row">
		<div class="col-sm-2"></div>
		<div class="col-sm-8">
			<div class="clearfix">
				<h4>
					<i class="fa fa-edit"></i>Mi Cat�logo
				</h4>
			</div>
			<div class="col-xs-6">
				<section class="panel">
					<header class="panel-heading bg-white">
						<div class="text-center h5">Productos seleccionados</div>
						<div class="panel-body pull-in text-center">
							Buscar: <input type="search" ng-model="a" placeholder="b�squeda de productos"
							style="margin-bottom: 10px">
						<table class="table-bordered table">
							<th>
							<th>Nombre</th>
							<th>A�adir a cat�logo</th>
							<tr ng-repeat="productoSelec in productosSelecc | filter:a as results">
								<td>
									<button type="button"  class="fa fa-arrow-right" title="Remover" ng-click="removido(productoSelec, 'removido')"></button>
								</td>
								<td>
									<span>{{productoSelec.nombre}}</span>
								</td>
								<td><button type="button" class="fa fa-cutlery" title="A�adir" ng-click="openModal(productoSelec)"></button></td>
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
							Buscar: <input type="search" ng-model="q" placeholder="b�squeda de productos"
							style="margin-bottom: 10px">
						<table class="table-bordered table">
							<th>
							<th>Nombre</th>
							<tr ng-repeat="producto in productos | filter:q as results" >
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