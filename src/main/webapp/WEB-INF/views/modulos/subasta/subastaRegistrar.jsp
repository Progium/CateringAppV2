<section class="main padder" ng-controller="SubastaRegistrarController">
  <div class="clearfix">
    <h4><i class="fa fa-edit"></i>Registrar Subasta</h4>
  </div>
  <div class="row">
    <div class="col-sm-6">
      <section class="panel">
        <div class="panel-body">
          <form class="form-horizontal" method="get" data-validate="parsley">
            <div class="form-group">
              <label class="col-lg-3 control-label">Fecha del Evento</label>
              <div class="col-lg-9">
                <input type="text" class="combodate form-control" data-format="DD-MM-YYYY" data-template="D  MMM  YYYY" name="datetime" value="29-08-2015">
              </div>
            </div>
            <div class="form-group">
              <label class="col-lg-3 control-label">Hora</label>
              <div class="col-lg-5">
                <input class="input-sm form-control" type="text" placeholder="3:00 pm"></input>
              </div>
            </div>

            <div class="form-group">
              <label class="col-lg-3 control-label">Cantidad de personas</label>
              <div id="cantidadpersonas" class="spinner input-group m-b">
                <input type="text" class="input-sm spinner-input form-control" name="spinner" maxlength="3">
                <div class="btn-group btn-group-vertical input-group-btn">
                  <button type="button" class="btn btn-white spinner-up">
                    <i class="fa fa-chevron-up"></i>
                  </button>
                  <button type="button" class="btn btn-white spinner-down">
                    <i class="fa fa-chevron-down"></i>
                  </button>
                </div>
              </div>
            </div>
            <!-- checkbox -->
            <div class="form-group">
              <label class="col-lg-3 control-label">Categoria</label>
              <div class="col-lg-6">
                <div class="checkbox">
                  <label>
                    <input type="checkbox" name="checkboxA"> Desayuno
                  </label>
                </div>
                <div class="checkbox">
                  <label>
                    <input type="checkbox" name="checkboxA"> Plato Fuerte
                  </label>
                </div>
                <div class="checkbox">
                  <label>
                    <input type="checkbox" name="checkboxA"> Postre
                  </label>
                </div>
                <div class="checkbox">
                  <label>
                    <input type="checkbox" name="checkboxA"> Cena
                  </label>
                </div>
                <div class="checkbox">
                  <label>
                    <input type="checkbox" name="checkboxA"> Manteleria
                  </label>
                </div>
                <div class="checkbox">
                  <label>
                    <input type="checkbox" name="checkboxA"> Otros
                  </label>
                </div>
              </div>
            </div>
            <div class="form-group">
              <label class="col-lg-3 control-label">Observaciones</label>
              <div class="col-lg-8">
                <textarea placeholder="Observaciones" rows="5" class="form-control" data-trigger="keyup" data-rangelength="[20,200]"></textarea>
              </div>
            </div>

            <div class="form-group">
              <label class="col-lg-3 control-label">Monto Disponible</label>
              <div class="col-lg-8">
                <input type="text" ng-model="montodisponible" placeholder="100000" data-required="true" class="form-control">
              </div>
            </div>

            <div class="form-group">
              <div class="col-lg-9 col-lg-offset-3">
                <button type="submit" class="btn btn-white">Cancelar</button>
                <button type="submit" class="btn btn-primary">Guardar</button>
              </div>
            </div>
          </form>
        </div>
      </section>
</section>