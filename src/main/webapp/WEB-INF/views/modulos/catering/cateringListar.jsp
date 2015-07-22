<section class="main padder" ng-controller="CateringListarController">
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
                            </tr>
                        </thead>
                        <tbody ng-repeat="catering in CateringLista">
                            <tr>
                                <td>
                                    {{catering.nombre}}
                                </td>
                                <td>
                                    {{catering.ubicacion}}
                                </td>
                                <td class="text-right">
                                    <div class="btn-group">
                                       <button type="button" class="btn btn-primary">Modificar</button>
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </section>
        </div>
    </div>
</section>