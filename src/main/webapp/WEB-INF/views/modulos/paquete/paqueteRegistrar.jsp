<section class="main padder">
  <div class="clearfix">
    <h4><i class="fa fa-edit"></i>Registrar Paquete</h4>
  </div>
  <div class="row">
    <div class="col-sm-6">
      <section class="panel">
        <div class="panel-body">
          <form class="form-horizontal" method="get" data-validate="parsley">
            <div class="form-group">
              <label class="col-lg-3 control-label">Nombre</label>
              <div class="col-lg-8">
                <input type="text" class="form-control" name="nombre" required/>
                <span class="error" ng-show="registroPaquete.nombre.$error.required">Requerido</span>
              </div>
            </div>
            <div class="form-group">
              <label class="col-lg-3 control-label">Cantidad de personas</label>
              <div class="col-lg-8">
                <input type="number" class="form-control" name="cantPersonas" ng-model="cantidad.valor" min="1" max="99" required/>
                <span class="error" class="form-control" ng-show="registroPaquete.cantPersonas.$error.required">Requerido</span>
                <span class="error" class="form-control" ng-show="registroPaquete.cantPersonas.$error.number">Not valid number!</span>
              </div>
            </div>
            <div class="form-group">
              <label class="col-lg-3 control-label">Productos</label>
              <div class="col-lg-8">
                <table class="table table-striped m-b-none text-small">
                        <thead>
                            <tr>
                                <th>Nombre Producto</th>
                                <th>Costo</th>
                                <th>Seleccionar</th>
                            </tr>
                        </thead>
                        <tbody ng-repeat="producto in productos">
                            <tr>
                                <td>
                                    {{producto.nombre}}
                                </td>
                                <td>
                                    {{producto.costo}}
                                </td>
                                <td>
                                    <i class="fa fa-check-square"></i>
                                </td>
                            </tr>
                        </tbody>
                    </table>
              </div>
            </div>
            <div class="form-group">
              <label class="col-lg-3 control-label">Descuento</label>
              <div class="col-lg-8">
                <input class="form-control" type="text" name="descuento" required/>
                <span class="error" ng-show="registroPaquete.descuento.$error.required">Requerido</span>
              </div>
            </div>
            <div class="form-group">
              <label class="col-lg-3 control-label">Monto Total</label>
              <div class="col-lg-8">
                <input class="form-control" type="text" name="montoTotal" required/>
                <span class="error" ng-show="registroPaquete.montoTotal.$error.required">Requerido</span>
              </div>
            </div>
            <div class="form-group">
              <label class="col-lg-3 control-label">Descripción</label>
              <div class="col-lg-8">
                <textarea name="descrip" rows="5" class="form-control" data-trigger="keyup" data-rangelength="[20,200]"></textarea>
                <span class="error" ng-show="registroPaquete.montoTotal.$error.required">Requerido</span>
              </div>
            </div>
          </form>
          <br>
          <div class="form-group">
            <div class="col-lg-9 col-lg-offset-5">
              <button type="submit" class="btn btn-primary">Guardar</button>
            </div>
          </div>
          </form>
        </div>
      </section>
    </div>
  </div>
</section>