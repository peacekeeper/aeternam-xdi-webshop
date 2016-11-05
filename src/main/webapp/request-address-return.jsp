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
	String xdiresponse = (String) request.getAttribute("xdiresponse");
	String xdirequest = WebshopConnectionRequest.storeTicketConnectionRequest(request.getServletContext()).getMessageEnvelope().getGraph().toString("XDI/JSON", null);
%>

<img src="images/trip.jpg"><br><br>

<p>We received your name and address!</p>

<pre>
<%= StringEscapeUtils.escapeHtml(xdiresponse) %>
</pre>

<p>Your ticket has been issued. We can store it in your Personal Cloud.</p>

<form action="<%= request.getServletContext().getInitParameter("connectEndpointUri") %>" method="post">
<input type="hidden" name="xdi" value="<%= StringEscapeUtils.escapeHtml(xdirequest) %>">	
<input type="submit" value="" class="xdiconnect">
</form>

</body>

</html>
