<section class="main padder" >
    <div class="clearfix">
        <h4><i class="fa fa-table"></i>Mis Catering</h4>
    </div>
    <div class="row">
        <div class="col-lg-6">
            <section class="panel">
                <div>
                
                    <table class="table table-striped m-b-none text-small">
                        <thead>
                            <tr>
                                <th>Nombre</th>
                                <th>Ubicacion</th>
                                <th width="70"></th>
                                <th width="70"></th>
                            </tr>
                        </thead>
                        <tbody ng-repeat="catering in cateringLista">
                            <tr>
                                <td>
                                    {{catering.nombre}}
                                </td>
                                <td>
                                    {{catering.direccion}}
                                </td>
                                 <td class="text-right">
                                    <div class="btn-group">
                                       <button type="button" class="btn btn-primary" ng-click = "openModal(catering)">Mostrar Detalle</button>
                                    </div>
                                </td>
                                <td class="text-right">
                                    <div class="btn-group">
                                       <button type="button" class="btn btn-primary" ng-click = "modificar(catering.idCatering)">Modificar</button>
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    
                 </div>
            </section>
       <button type="submit" class="btn btn-primary" ng-click ="registrar()">Registrar Catering</button>
      </div>
    </div>
</section>