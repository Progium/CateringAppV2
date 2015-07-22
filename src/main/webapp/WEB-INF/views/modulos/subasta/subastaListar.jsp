<section class="main padder" ng-controller="SubastaListarController">
    <div class="clearfix">
        <h4><i class="fa fa-table"></i>Lista Subasta</h4>
    </div>
    <div class="row">
        <div class="col-lg-6">
            <section class="panel">
                <div>
                    <table class="table table-striped m-b-none text-small">
                        <thead>
                            <tr>
                                <th>Nombre Usuario</th>
                                <th>Fecha Evento</th>
                                <th>Hora Evento</th>
                                <th width="70"></th>
                            </tr>
                        </thead>
                        <tbody ng-repeat="subasta in listaSubastas">
                            <tr>
                                <td>
                                    {{subasta.nombre}}
                                </td>
                                <td>
                                    {{subasta.fecha}}
                                </td>
                                <td>
                                    {{subasta.hora}}
                                </td>
                                <td class="text-right">
                                    <div class="btn-group">
                                       <button type="button" class="btn btn-primary">Participar</button>
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