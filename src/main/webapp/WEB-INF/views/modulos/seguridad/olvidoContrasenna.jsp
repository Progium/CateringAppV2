<section id="content">
   <div class="main padder">
     <div class="row">
       <div class="col-lg-4 col-lg-offset-4 m-t-large">
         <section class="panel">
           <header class="panel-heading text-center">
            Olvidó su contraseña
           </header>
           <form class="panel-body" method="post" id="frmOlvidoContrasenna">
             <div class="block">
               <label class="control-label">Ingrese el correo electrónico</label>
               <input type="email" id="email" ng-model="objUsuario.correo" placeholder="marce@gmail.com" class="bg-focus form-control" required />  
             </div>
             <button type="submit"  class="btn btn-white" ng-click="cancelar()">Cancelar</button>
             <button type="submit" class="btn btn-info" ng-click="olvidoContrasenna()">Recuperar contraseña</button>
           	
           </form>
         </section>
       </div>
     </div>
   </div>
 </section>