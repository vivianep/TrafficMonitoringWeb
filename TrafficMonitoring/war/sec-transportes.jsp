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
								<li class="current"><a href="sec-transportes.jsp">Sec Transportes</a></li>
								<li><a href="samu.jsp">SAMU</a></li>
								<li><a href="rest.html">Serviço REST</a></li>
								
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
	    							<th>Data</th>
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
	  					<br><br>
	  				<div id="bar-chart" style="max-width: 900px; height: 400px; margin: 0 auto"></div>
				</div>
			</div>

		
		<!-- Footer -->
		<div id="footer-wrapper" class="wrapper">
				
					<div id="copyright">
					<li> Application by <strong>Team Trouble</strong></li>
					<li>Repository:<a href="https://github.com/vivianep/TrafficMonitoringWeb.git"><strong>GitHub</strong></a></li>
					<li>&copy; Untitled.</li><li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
					
				</div>
		</div>
		<script type="text/javascript">
			$(function () {
			    $('#bar-chart').highcharts({
			        chart: {
			            type: 'column'
			        },
			        title: {
			            text: 'Situacão Geral das Vias'
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
			                '<td style="padding:0"><b>{point.y} </b></td></tr>',
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
			        	<%	ArrayList<InfoSituacao> info_situacao=s.getEstSituacao();
							%>
			            data: [<%=info_situacao.get(0).num_congest%>,<%=info_situacao.get(1).num_congest%>,<%=info_situacao.get(2).num_congest%>,<%=info_situacao.get(3).num_congest%>,<%=info_situacao.get(4).num_congest%>,<%=info_situacao.get(5).num_congest%>,<%=info_situacao.get(6).num_congest%>]

			        }, {
			            name: 'Livre',
			            data: [<%=info_situacao.get(0).num_livres%>,<%=info_situacao.get(1).num_livres%>, <%=info_situacao.get(2).num_livres%>, <%=info_situacao.get(3).num_livres%>, <%=info_situacao.get(4).num_livres%>, <%=info_situacao.get(5).num_livres%>, <%=info_situacao.get(6).num_livres%>]
			            
			        }]
			    });
			});
		</script>
	</body>
</html>