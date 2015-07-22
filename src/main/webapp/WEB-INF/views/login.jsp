<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html lang="en" xmlns:ng="http://angularjs.org" class="ng-app:PrototipoProgium" id="ng-app" ng-app="PrototipoProgium">

<head>
    <meta charset="utf-8">
    <title>Catering App</title>
    
    <!--Template-->
    <meta name="description" content="mobile first, app, web app, responsive, admin dashboard, flat, flat ui">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"> 
    <link rel="stylesheet" href="resources/first/src/css/bootstrap.css">
    <link rel="stylesheet" href="resources/first/src/css/font-awesome.min.css">
    <link rel="stylesheet" href="resources/first/src/js/select2/select2.css">
    <link rel="stylesheet" href="resources/first/src/css/plugin.css">
    <link rel="stylesheet" href="resources/first/src/css/font.css">
    <link rel="stylesheet" href="resources/first/src/css/style.css">

    <!--Template scripts-->
    <!--Jquery-->
    <script src="resources/first/src/js/jquery.min.js"></script>
    <!--JStorage-->
    <script src="resources/js/lib/jstorage.js"></script>
    <!--Underscore-->
    <script src="resources/js/lib/underscore-min.js"></script>
    <!--JSon2-->
    <script src="resources/js/lib/json2.js"></script>
    <!-- Bootstrap -->
    <script src="resources/first/src/js/bootstrap.js"></script>
    <!-- app -->
    <script src="resources/first/src/js/app.js"></script>
    <script src="resources/first/src/js/app.plugin.js"></script>
    <script src="resources/first/src/js/app.data.js"></script>
    <!-- fuelux -->
    <script src="resources/first/src/js/fuelux/fuelux.js"></script>
    <!-- datepicker -->
    <script src="resources/first/src/js/datepicker/bootstrap-datepicker.js"></script>
    <!-- slider -->
    <script src="resources/first/src/js/slider/bootstrap-slider.js"></script>
    <!-- file input -->
    <script src="resources/first/src/js/file-input/bootstrap.file-input.js"></script>
    <!-- combodate -->
    <script src="resources/first/src/js/combodate/moment.min.js"></script>
    <script src="resources/first/src/js/combodate/combodate.js"></script>
    <!-- parsley -->
    <script src="resources/first/src/js/parsley/parsley.min.js"></script>
    <!-- select2 -->
    <script src="resources/first/src/js/select2/select2.min.js"></script>

    <!--Angular-->
    <script src="resources/js/lib/angular/1.3.9/angular.js"></script>
    <script src="resources/js/lib/angular/1.3.9/angular-route.js"></script>
    <script src="resources/js/lib/angular/1.3.9/angular-md5.js"></script>
    <script src="resources/js/lib/uploadfile/angular-file-upload.min.js"></script>
    
    <!--Aplicacion-->
    <script src="resources/js/login-app.js"></script>
    <script src="resources/js/services.js"></script>

    <!--Controladores-->
    <script src="resources/modulos/seguridad/iniciar-sesion-controller.js"></script>
    <script src="resources/modulos/seguridad/usuario-controller.js"></script>
    <script src="resources/modulos/catering/catering-controller.js"></script>
    <script src="resources/modulos/catering/catering-buscar-controller.js"></script>
    <script src="resources/modulos/catering/catering-listar-controller.js"></script>
    <script src="resources/modulos/cotizacion/cotizacion-registrar-controller.js"></script>
    <script src="resources/modulos/producto/producto-registrar-controller.js"></script>
</head>

<body ng-controller="MainController">
        
        <!-- content -->
        <section id="content" ng-view> 
        
        </section>
        <!-- content -->

        <!-- footer -->
        <footer id="footer">
            <div class="text-center padder clearfix">
                <p>
                    <small>&copy; Catering Service App 2015</small>
                    <br>
                    <br>
                    <a href="" class="btn btn-xs btn-circle btn-twitter"><i class="fa fa-twitter"></i></a>
                    <a href="" class="btn btn-xs btn-circle btn-facebook"><i class="fa fa-facebook"></i></a>
                    <a href="" class="btn btn-xs btn-circle btn-gplus"><i class="fa fa-google-plus"></i></a>
                </p>
            </div>
        </footer>
        <!-- / footer -->
</body>

</html>