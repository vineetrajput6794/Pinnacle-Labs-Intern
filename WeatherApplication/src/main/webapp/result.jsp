<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>

<html>

<head>

<title>Weather Result</title>

<link rel="stylesheet" href="css/style.css">

</head>

<body>

<div class="container">

<h2>Weather Report</h2>

<p>

<%= request.getAttribute("weather") %>

</p>

<a href="index.html">

<button>Search Again</button>

</a>

</div>

</body>

</html>