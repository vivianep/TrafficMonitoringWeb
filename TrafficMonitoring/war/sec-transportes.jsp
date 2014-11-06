<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import ="com.monitoring.objectify.*"%>

<!DOCTYPE html>
<!--
	Escape Velocity by HTML5 UP
	html5up.net | @n33co
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<title>Secretaria de Transportes</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->
		<script src="js/jquery.min.js"></script>
		<script src="js/jquery.dropotron.min.js"></script>
		<script src="js/skel.min.js"></script>
		<script src="js/skel-layers.min.js"></script>
		<script src="js/init.js"></script>
		<script src="https://www.google.com/jsapi"></script>
		<script src="js/charts.js"></script>
		<script src="//code.jquery.com/jquery-1.10.2.js"></script>
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
		<style type="text/css">
		${demo.css}
		</style>
		<script type="text/javascript">
			$(function () {
			    $('#bar-chart').highcharts({
			        chart: {
			            type: 'column'
			        },
			        title: {
			            text: 'Ocorrencias'
			        },
			        subtitle: {
			            text: 'trafficmonitoringlv.appspot.com'
			        },
			        xAxis: {
			            categories: [
			                'Salgado Filho',
			                'Prudente de Morais',
			                'Amintas Barros',
			                'Hermes da Fonseca',
			                'Eng Roberto Freire',
			                'Antonio Basílio',
			                'Bernardo Vieira'
			            ]
			        },
			        yAxis: {
			            min: 0,
			            title: {
			                text: 'N de Ocorrencias'
			            }
			        },
			        tooltip: {
			            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
			            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
			                '<td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>',
			            footerFormat: '</table>',
			            shared: true,
			            useHTML: true
			        },
			        plotOptions: {
			            column: {
			                pointPadding: 0.2,
			                borderWidth: 0
			            }
			        },
			        series: [{
			            name: 'Congestionado',
			            data: [49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6]

			        }, {
			            name: 'Livre',
			            data: [83.6, 78.8, 98.5, 93.4, 106.0, 84.5, 105.3]

			        }]
			    });
			});
		</script>
		<script src="js/highcharts.js"></script>
		<script src="js/exporting.js"></script>
		<noscript>
			<link rel="stylesheet" href="css/skel.css" />
			<link rel="stylesheet" href="css/style.css" />
			<link rel="stylesheet" href="css/style-desktop.css" />
		</noscript>
		<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
	</head>
	<body class="left-sidebar">

		<!-- Header -->
			<div id="header-wrapper" class="wrapper">
				<div id="header">
					
					<!-- Logo -->
						<div id="logo">
							<h1><a href="index.html">Traffic Monitoring</a></h1>
						</div>
					
					<!-- Nav -->
						<nav id="nav">
							<ul>
								<li ><a href="index.html">Home</a></li>
								<li class="current"><a href="sec_transportes.jsp">Sec Transportes</a></li>
								<li><a href="samu.jsp">SAMU</a></li>
								
							</ul>
						</nav>

				</div>
			</div>
		
		<!-- Main -->
			<div class="wrapper style2">
				<div class="title">Secretaria Transportes</div>
				
				<div id="main" class="container">
						<div class="secretaria">
							<h1>Situação das Vias </h1>
							<br>
							<table id="refresh" class="center">
	  							<tr>
	    							<th>Via</th>
	    							<th>Qtd de carros</th> 
	    							<th>Situação</th>
	    							<th>Date</th>
	  							</tr>
	  							<%
	  							StartupServlet s= new StartupServlet();
	  							Iterable<ViaEntity> iterator= s.loadVias();
								Iterator<ViaEntity> iter=iterator.iterator();
	  							while(iter.hasNext()){
									ViaEntity via=iter.next();
		  						%>	<tr>
		  								<td><%=via.getViaNome()%></td>
		  								<td><%=via.getQtdCarros()%></td>
		  								<td><%=via.getSituacaoVia()%></td>
		  								<td><%=via.getDate()%></td>
		  								
		  							</tr>
		  						<%
	  							}
	  							%>
	  						</table>
	  						<br>
	  						<h1>Acidentes Registrados</h1>
	  						<br>
	  						<table id="refresh" class="center">
	  							<tr>
	    							<th>Via</th>
	    							<th>Acidente</th>
	    							<th>Data</th> 
	  							</tr>
	  							<%
	  							
	  							Iterable<AcidenteEntity> iterable_aci= s.loadAcidentes();
								Iterator<AcidenteEntity> iterator_aci=iterable_aci.iterator();
	  							while(iterator_aci.hasNext()){
									AcidenteEntity acidente=iterator_aci.next();
		  						%>	<tr>
		  								<td><%=acidente.getId_via()%></td>
		  								<td><%=acidente.getAcidenteString()%></td>
		  								<td><%=acidente.getDate()%></td>
		  							</tr>
		  						<%
	  							}
	  							%>
	  						</table>
	  						
	  					</div>
	  				<div id="bar-chart" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
				</div>
			</div>

		
		<!-- Footer -->
		<div id="footer-wrapper" class="wrapper">
				<div class="title">The Rest Of It</div>
				<div id="copyright">
					<p> Application by <strong>TroubleTeam</strong></p>
					<p>Repository:<a href="https://github.com/vivianep/TrafficMonitoringWeb.git"><strong>GitHub</strong></a></p>
					<ul>
						<li>&copy; Untitled.</li><li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
					</ul>
				</div>
			</div>
			<script>
			$( "" ).load( "/resources/load.html #projects li" );
			</script>
 

	</body>
</html>