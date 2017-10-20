<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Hotel Sheraton</title>

    <!-- Bootstrap Core CSS -->
    <link href="./css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="./cliente/css/fotorama.css" rel="stylesheet">
    <link href="./cliente/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
    <link href="./cliente/css/estilos.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="./cliente/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<!--    <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">-->

    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <!-- Navigation -->
    <a id="menu-toggle" href="#" class="btn btn-dark btn-lg toggle"><i class="fa fa-bars"></i></a>
    <nav id="sidebar-wrapper">
        <ul class="sidebar-nav">
            <a id="menu-close" href="#" class="btn btn-light btn-lg pull-right toggle"><i class="fa fa-times"></i></a>
            <li class="sidebar-brand text-center">
                <a href="#top" onclick="$('#menu-close').click();">Hotel Sheraton</a>
            </li>
            <li>
                <a href="#top" onclick="$('#menu-close').click();">Inicio</a>
            </li>
            <li>
                <a href="#about" onclick="$('#menu-close').click();">Reservar</a>
            </li>
            <li>
                <a href="#services" onclick="$('#menu-close').click();">Servicios</a>
            </li>
            <li>
                <a href="#portfolio" onclick="$('#menu-close').click();">Habitaciones</a>
            </li>
            <li>
                <a href="#contact" onclick="$('#menu-close').click();">Contacto</a>
            </li>
            <li><hr></li>
            <li>
                <a href="login.jsp">Administración</a>
            </li>
        </ul>
    </nav>

    <!-- Header -->
    <header id="top" class="header">
        <div class="text-vertical-center c_blanco">
            <h1>Hotel Sheraton</h1>
            <br>
            <a href="#about" class="btn btn-dark btn-lg">HAGA SU RESERVA</a>
        </div>
    </header>

    <!-- About -->
    <section id="about" class="about">
        <div class="container">
         	<div class="text-center">
	            <h2>Haga su reserva ahora mismo</h2>
            </div>
            
        	<div class="row">
        	    <div id="reservaAlert" class="text-center" style="display:none;">
        	    	<h3>Su reserva fue enviada correctamente!</h3>
        	    </div>
               	<form action="" method="post" data-toggle="validator" id="form_reserva">
               		<div class="col-md-6">
               			<p class="text-muted">Datos de contacto</p>
               			 <div class="form-group">
                            <label>Dni</label>
                            <input type="number" class="form-control" name="dni" required>
                            <div class="help-block with-errors"></div>
                        </div>
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" class="form-control" name="nombre" required>
                            <div class="help-block with-errors"></div>
                        </div>
                         <div class="form-group">
                            <label>Apellido</label>
                            <input type="text" class="form-control" name="apellido" required>
                            <div class="help-block with-errors"></div>
                        </div>
                        
                        <div class="form-group">
                            <label>Email</label>
                            <input type="email" class="form-control" name="email" required>
                            <div class="help-block with-errors"></div>
                        </div>
                        <div class="form-group">
                        <% int id=0;%>
			<label for="inputPassword3" class="col-sm-2 control-label">Tipo de Habitacion</label>
			<div class="col-sm-10">
				<select class="form-control" name="id" ">
					<option value="1" <%=(id == 1) ? "selected" : ""%>>Suite</option>
					<option value="2" <%=(id == 2) ? "selected" : ""%>>opcion 2</option>
					<option value="3" <%=(id == 3) ? "selected" : ""%>>opcion 3</option>
					<option value="4" <%=(id == 4) ? "selected" : ""%>>opcion 4</option>
					

				</select>
			</div>
		</div>
                	<div class="col-md-6">
                		<p class="text-muted">¿Cuándo se hospedará con nosotros?</p>
                		<div class="row">
                			<div class="form-group col-sm-6">
                				<label>Desde</label>
					            <div class='input-group date' id='datetimepicker6'>
					                <input type="text" class="form-control" name="fdesde" required>
					                <span class="input-group-addon">
					                    <span class="glyphicon glyphicon-calendar"></span>
					                </span>
					            </div>
					        </div>
	                		<div class="form-group col-sm-6">
	                			<label>Hasta</label>
					            <div class='input-group date' id='datetimepicker7'>
					                <input type="text" class="form-control" name="fhasta" required>
					                <span class="input-group-addon">
					                    <span class="glyphicon glyphicon-calendar"></span>
					                </span>
					            </div>
					        </div>
                        
	                        <div class="form-group col-sm-6">
	                            <label>Nº Adultos</label>
	                            <input type="number" class="form-control" value="2" min="1" name="capacidad" required>
	                        </div>
	                        <div class="form-group text-right col-sm-6">
	                        	<label>&nbsp;</label>
	                        	<button type="submit" class="btn btn-primary btn-block" data-loading-text="Reservando...">Reservar</button>
	                        </div>
                        </div>
                	</div>
                	
                 </form>
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container -->
    </section>

    <!-- Services -->
    <!-- The circle icons use Font Awesome's stacked icon classes. For more information, visit http://fontawesome.io/examples/ -->
    <section id="services" class="services bg-primary">
        <div class="container">
            <div class="row text-center">
                <div class="col-lg-10 col-lg-offset-1">
                    <h2>Nuestros servicios</h2>
                    <hr class="small">
                    <div class="row">
                        <div class="col-md-3 col-sm-6">
                            <div class="service-item">
                                <span class="fa-stack fa-4x">
                                <i class="fa fa-circle fa-stack-2x"></i>
                                <i class="fa fa-wifi fa-stack-1x text-primary"></i>
                            </span>
                                <h4>
                                    <strong>Wi-Fi</strong>
                                </h4>
                                <p>Gratis en todas la habitaciones.</p>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6">
                            <div class="service-item">
                                <span class="fa-stack fa-4x">
                                <i class="fa fa-circle fa-stack-2x"></i>
                                <i class="fa fa-hand-paper-o fa-stack-1x text-primary"></i>
                            </span>
                                <h4>
                                    <strong>Masajes &amp; SPA</strong>
                                </h4>
                                <p>&nbsp;</p>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6">
                            <div class="service-item">
                                <span class="fa-stack fa-4x">
                                <i class="fa fa-circle fa-stack-2x"></i>
                                <i class="fa fa-cutlery fa-stack-1x text-primary"></i>
                            </span>
                                <h4>
                                    <strong>Restaurante</strong>
                                </h4>
                                <p>Atención las 24hs.</p>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6">
                            <div class="service-item">
                                <span class="fa-stack fa-4x">
                                <i class="fa fa-circle fa-stack-2x"></i>
                                <i class="fa fa-gamepad fa-stack-1x text-primary"></i>
                            </span>
                                <h4>
                                    <strong>Juegos en red</strong>
                                </h4>
                                <p>Para los jóvenes.</p>
                            </div>
                        </div>
                    </div>
                    <!-- /.row (nested) -->
                </div>
                <!-- /.col-lg-10 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container -->
    </section>

    <!-- Portfolio -->
    <section id="portfolio" class="portfolio">
        <div class="container">
            <div class="row">
                <div class="col-lg-10 col-lg-offset-1 text-center">
                    <h2>Nuestras Habitaciones</h2>
                    <hr class="small">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="fotorama" data-width="100%" data-ratio="16/8" data-loop="true" data-autoplay="true" data-nav="thumbs" data-fit="cover">
                                <img class="img-portfolio img-responsive" src="./cliente/img/1.jpg">
                                <img class="img-portfolio img-responsive" src="./cliente/img/2.jpg">
                                <img class="img-portfolio img-responsive" src="./cliente/img/3.jpg">
                                <img class="img-portfolio img-responsive" src="./cliente/img/4.jpg">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    
    <aside class="call-to-action bg-primary">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h4>Se encuentra ubicado en el barrio de San Telmo, patrimonio histórico de la Ciudad. Entre edificios centenarios, iglesias antiguas, galerías de arte y antiguedades, ferias, bares tradicionales y variedad de restaurantes permitiendo al visitante disfrutar de toda la bohemia de Bs. As. y a poco minutos encontrarse en el centro de la ciudad o en el mismo Puerto Madero. </h4>
                </div>
            </div>
        </div>
    </aside>
    

<style>
    .mapa_bg{
        background-image: url(cliente/img/mapa.JPG);
        background-position: center;
        background-size: cover;
        height: 100%;
        width: 100%;
    }    
</style>
   
    <!-- Map -->
    <section id="contact" class="map">
        <div class="mapa_bg"></div>
        
    </section>

    <!-- Footer -->
    <footer>
        <h2 class="text-center">Contáctenos</h2>
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    <form method="post" data-toggle="validator">
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Email</label>
                            <input type="email" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Teléfono</label>
                            <input type="tel" class="form-control" placeholder="Opcional">
                        </div>
                        <div class="form-group">
                            <textarea name="mensaje" class="form-control" rows="6" required></textarea>
                        </div>
                        <button type="submit" class="btn btn-primary">Enviar Consulta</button>
                    </form>
                </div>
                <div class="col-sm-6 text-center">
                    <h4><strong>Hotel Sheraton</strong>
                    </h4>
                    <p>3481 Melrose Place
                        <br>Beverly Hills, CA 90210</p>
                    <ul class="list-unstyled">
                        <li><i class="fa fa-phone fa-fw"></i> (123) 456-7890</li>
                        <li><i class="fa fa-envelope-o fa-fw"></i> <a href="mailto:name@example.com">hotel@sheraton.com</a>
                        </li>
                    </ul>
                    <br>
                    <ul class="list-inline">
                        <li>
                            <a href="#"><i class="fa fa-facebook fa-fw fa-3x"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-twitter fa-fw fa-3x"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-dribbble fa-fw fa-3x"></i></a>
                        </li>
                    </ul>
                    <hr class="small">
                    <p class="text-muted">Copyright &copy; Hotel Sheraton - UNLa 2016</p>
                </div>
            </div>
        </div>
        <a id="to-top" href="#top" class="btn btn-dark btn-lg"><i class="fa fa-chevron-up fa-fw fa-1x"></i></a>
    </footer>

    <!-- jQuery -->
    <script src="./js/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="./js/bootstrap.min.js"></script>
    <script src="./js/validator.js"></script>
    <script src="./cliente/js/fotorama.js"></script>
    <script src="./cliente/js/Moment.js"></script>
    <script src="./cliente/js/bootstrap-datetimepicker.min.js"></script>
    <script src="./cliente/js/lang_es.js"></script>

    <!-- Custom Theme JavaScript -->
    <script>
    // Closes the sidebar menu
    $("#menu-close").click(function(e) {
        e.preventDefault();
        $("#sidebar-wrapper").toggleClass("active");
    });
    // Opens the sidebar menu
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#sidebar-wrapper").toggleClass("active");
    });
    // Scrolls to the selected menu item on the page
    $(function() {
    	$('[data-toggle="tooltip"]').tooltip()
    	
        $('a[href*=#]:not([href=#],[data-toggle],[data-target],[data-slide])').click(function() {
            if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') || location.hostname == this.hostname) {
                var target = $(this.hash);
                target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
                if (target.length) {
                    $('html,body').animate({
                        scrollTop: target.offset().top
                    }, 1000);
                    return false;
                }
            }
        });
        
        $('#datetimepicker6').datetimepicker({
        	format: 'DD-MM-YYYY',
            locale: 'es',
            defaultDate: moment(),
            showTodayButton: true,
            allowInputToggle:true

        });
        $('#datetimepicker7').datetimepicker({
        	format: 'DD-MM-YYYY',
            locale: 'es',
            showTodayButton: true,
            allowInputToggle:true,
            useCurrent: false //Important! See issue #1075

        });
        $("#datetimepicker6").on("dp.change", function (e) {
            $('#datetimepicker7').data("DateTimePicker").minDate(e.date);
        });
        $("#datetimepicker7").on("dp.change", function (e) {
            $('#datetimepicker6').data("DateTimePicker").maxDate(e.date);
        });
        
        $("#datetimepicker6").trigger("dp.change");
        
    });
    //#to-top button appears after scrolling
    var fixed = false;
    $(document).scroll(function() {
        if ($(this).scrollTop() > 250) {
            if (!fixed) {
                fixed = true;
                // $('#to-top').css({position:'fixed', display:'block'});
                $('#to-top').show("slow", function() {
                    $('#to-top').css({
                        position: 'fixed',
                        display: 'block'
                    });
                });
            }
        } else {
            if (fixed) {
                fixed = false;
                $('#to-top').hide("slow", function() {
                    $('#to-top').css({
                        display: 'none'
                    });
                });
            }
        }
    });
    
    $('#form_reserva').validator().on('submit', function (e) {
   	  if (e.isDefaultPrevented()) {
   	    // handle the invalid form...
   	  } else {
   		$.ajax({
	    	url: "./AltaPrueba",
	    	method:'POST',
	    	data: $(this).serialize(),
	    	beforeSend: function(){
	    		$('#form_reserva').find('button[type=submit]').button('loading')
	    	},
	    	success: function(data){
	    		$("#form_reserva").fadeOut(function(){
	    			$("#reservaAlert").fadeIn();
	    		});
	    	}
	    });
	    
	    return false;
   	  }
   	})
    </script>

</body>

</html>
