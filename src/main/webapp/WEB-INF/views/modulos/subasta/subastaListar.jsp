<section class="main padder">
    <div class="clearfix">
        <h4><i class="fa fa-table"></i>Lista Subasta</h4>
    </div>
    <div class="row">
        <div class="col-lg-8">
            <section class="panel">
                <div>
                    <table class="table table-striped m-b-none text-small">
                        <thead>
                            <tr>
                                <th>Nombre</th>
                                <th>Fecha Evento</th>
                                <th>Monto M�ximo</th>
                                <th width="70"></th>
                                <th width="70"></th>
                            </tr>
                        </thead>
                        <tbody ng-repeat="subasta in subastaLista">
                            <tr>
                                <td>
                                    {{subasta.nombre}}
                                </td>
                                <td>
                                    {{subasta.fecha}}
                                </td>
                                <td>
                                    {{subasta.montoMaximo}}
                                </td>
                                <td class="text-right">
                                    <div class="btn-group">
                                       <button type="button" class="btn btn-primary" ngclick="">Mostrar Detalles</button>
                                    </div>
                                </td>
                                <td class="text-right">
                                    <div class="btn-group">
                                       <button type="button" class="btn btn-primary" ngclick="">Participar</button>
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
                </div>
            </section>
        </div>
    </div>
</section>