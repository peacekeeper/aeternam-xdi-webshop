<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.apache.commons.lang.StringEscapeUtils" %>
<%@ page import="aeternam.xdi.WebshopConnectionRequest" %>
<html>

<head>

<title>AETERNAM XDI Demo - WEBSHOP</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset="UTF-8"> 

<link rel="stylesheet" type="text/css" href="style.css"> 
 
<script type="text/javascript" src="jquery-2.0.3.min.js"></script>

</head>

<body>

<img src="images/map.jpg" style="float:right">

<h1><img src="images/logo-webshop.png" height="60"><img src="images/logo-xdi-business.jpg" height="60"></h1>

<h2>Your itinerary Vienna --&gt; Paris</h2>

<%
	String ticket = (String) request.getAttribute("ticket");
%>

<img src="images/trip.jpg"><br><br>

<p>Your ticket has been stored!</p>

<pre>
<%= StringEscapeUtils.escapeHtml(ticket) %>
</pre>

<p><a href="view.jsp">Continue.</a></p>

</body>

</html>
