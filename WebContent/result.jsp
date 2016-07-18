<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>States</title>
</head>
<body>
	<c:choose>
		<c:when test="${! empty stateList}">
			<form action="GetStateData.do" method="GET">
				<input
					type="submit" name="previous" value="Previous State" />
				<input type="submit" name="next" value="Next State" /> 
			</form>
			<h2>${state.name}</h2>
			<div id="stateFlag">
				<img src="${state.flag}" />
			</div>
			<ul>
				<li>Abbreviation: ${state.abbreviation}</li>
				<li>Capitol: ${state.capital}</li>
				<li>Population: ${state.population}</li>
				<li>State Bird: ${state.bird}</li>
			</ul>
			<iframe width="500px" height="300px"
				src="https://maps.google.com/maps?q=${state.latitude },${state.longitude }&hl=es;z=14&amp;output=embed"></iframe>
		</c:when>
		<c:otherwise>
			<p>No state found</p>
		</c:otherwise>
	</c:choose>
</body>
</html>