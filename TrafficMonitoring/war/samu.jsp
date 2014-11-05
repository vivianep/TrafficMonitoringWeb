<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import ="com.monitoring.objectify.*"%>
<!DOCTYPE HTML>
<!--
	Escape Velocity by HTML5 UP
	html5up.net | @n33co
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<title>SAMU</title>
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
				<div class="title">SAMU</div>
				<div id="main" class="container">
						<div class="secretaria">
							<table class="center">
	  							<tr>
	    							<th>Via</th>
	    							<th>Acidentes na Via</th>
	  								<th>Ambulância Disponiveis</th>
	  							</tr>
	  							<%
	  							StartupServlet s= new StartupServlet();
	  							Iterable<ViaEntity> iterator= s.loadVias();
								Iterator<ViaEntity> iter=iterator.iterator();
	  							while(iter.hasNext()){
									ViaEntity via=iter.next();
		  						%>	<tr>
		  								<td><%=via.getViaNome()%></td>
		  								<td><%=via.getAcidente()%></td>
		  								<td><select > 
											<option class="under" selected value="State">Ambulância </option> 
											<option>01</option>
											<option>02</option>
											<option>03</option>
											<option>04</option>
											<option>05</option>
											</select> </td> 
											
		  							</tr>
		  						<%
	  							}
	  							%>
	  							</table>
	  					
	  					</div>
				</div>
			</div>

		
		<!-- Footer -->
			<div id="footer-wrapper" class="wrapper">
				<div class="title">The Rest Of It</div>
				<div id="copyright">
					<p> Application by <strong>Team Monitoring</strong></p>
					<p>Repository:<a href="https://github.com/vivianep/TrafficMonitoringWeb.git"><strong>GitHub</strong></a></p>
					<ul>
						<li>&copy; Untitled.</li><li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
					</ul>
				</div>
			</div>

	</body>
</html>