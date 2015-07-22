<!-- .sidebar -->
<aside class="sidebar bg-lighter"
	ng-controller="CateringBuscarController">
	<div class="bg-light padder padder-v" style="padding-bottom: 5px;">
		<span class="h4 col-lg-offset-1">Busqueda de Catering</span>
	</div>
	<ul class="list-group list-normal m-b-none">
		<li class="list-group-item">Nombre <input type="text"
			name="buscar" placeholder="Buscar..." data-required="true"
			class="form-control input-sm">
		</li>
		<li class="list-group-item">Provincia <select name="marca"
			class="form-control input-sm">
				<option value="0">Todas</option>
		</select>
		</li>
		<li class="list-group-item">Cantón <select name="modelo"
			class="form-control input-sm">
				<option value="0">Todos</option>
		</select>
		</li>
		<li class="list-group-item">Distrito <select name="modelo"
			class="form-control input-sm">
				<option value="0">Todos</option>
		</select>
		</li>
		<li class="list-group-item">Orden por <select name="orden"
			class="form-control input-sm">
				<option value="0">Más cercano</option>
				<option value="1">Mejor calificación</option>
		</select>
		</li>
		<li class="list-group-item pull-right">
			<button type="submit" class="btn btn-info btn-xs">Buscar</button>
		</li>
	</ul>
</aside>