<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>result!</title>
<style>
h1 {
	text-align: center;
}

#divking {
	width: 180px;
	margin: auto;
}

#divbottom {
	margin-top : 5px;
}
</style>
</head>

<body>
	<h1>결과</h1>
	<form method="post">
		<div id="divking">
			01<input type="text" class="valueview" name="val"> 02<input type="text"
				class="valueview" name="val"> 03<input type="text" class="valueview" name="val">
			04<input type="text" class="valueview" name="val"> 05<input type="text"
				class="valueview" name="val"> 06<input type="text" class="valueview" name="val">
			07<input type="text" class="valueview" name="val"> 08<input type="text"
				class="valueview" name="val"> 09<input type="text" class="valueview" name="val">
			10<input type="text" class="valueview" name="val"> 11<input type="text"
				class="valueview" name="val"> 12<input type="text" class="valueview" name="val">
			13<input type="text" class="valueview" name="val"> 14<input type="text"
				class="valueview" name="val"> 15<input type="text" class="valueview" name="val">
			<div id="divbottom">
				<button type="submit" class="btn btn-warning">OK</button>
			</div>
		</div>
	</form>
	<script>
		var urlvalue = location.href.substr(location.href.lastIndexOf('=') + 1);
		var urlsplit = urlvalue.split(',');
		var valueview = document.getElementsByClassName('valueview');
		var viewp = document.getElementsByTagName('p');
		for ( var i in urlsplit) {
			valueview[i].value = urlsplit[i];
			viewp[i] = i + 1;
		}
		
		for (var j in valueview) {
			valueview[j].readOnly = true;
		}
	</script>
</body>

</html>