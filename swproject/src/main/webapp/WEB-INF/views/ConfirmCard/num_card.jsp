<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>크기 정하기</title>
<style>
#divking {
	position: relative;
	width: 430px;
	height: 770px;
	margin: auto;
	display: block;
}

#divframe {
	position: relative;
	width: 410px;
	height: 710px;
	float: left;
}

#divbottom {
	position: relative;
	width: 410px;
	height: 32px;
	text-align: center;
}

#numview {
	width: 40px;
	height: 25px;
	position: relative;
	float: left;
}

#btnclick {
	position: relative;
	float: right;
}

.arrow {
	font-size: 20px;
}

.carddiv {
	border: 1px solid;
	background-color: #FFFFFF;
	height: 692px;
	width: 400px;
	margin: 5px;
	float: left;
	position: absolute;
	display: none;
}

.onediv {
	border: 1px solid;
	width: 194px;
	height: 225px;
	float: left;
	margin: 2px;
	text-align: center;
}

.twodiv {
	border: 1px solid;
	width: 194px;
	height: 225px;
	float: left;
	margin: 2px;
	text-align: center;
}

.threediv {
	border: 1px solid;
	width: 194px;
	height: 225px;
	float: left;
	margin: 2px;
	text-align: center;
}

.fourdiv {
	border: 1px solid;
	width: 194px;
	height: 167px;
	float: left;
	margin: 2px;
	text-align: center;
}

.fivediv {
	border: 1px solid;
	width: 194px;
	height: 167px;
	float: left;
	margin: 2px;
	text-align: center;
}

img {
	width: 45%;
}

video {
	width: 82%;
}
</style>
</head>

<body>
	<%@ include file="../include/header.jsp"%>
	<div id="divking">
		<div id="divframe">
			<div class="carddiv" onclick="divclick()">
				<div class="onediv" style="height: 340px;">
					<p>
						헤헤 후후 <br> 냥냥펀치! <br>냥냐라냥냥 <br> 히히헤후
					</p>
					<video controls="controls">
						<source src="/resources/img/catcat.mp4" type="video/mp4" />
					</video>
				</div>
				<div class="onediv" style="height: 340px;">
					<p>
						엉덩이 공격! <br> 시바시바!
					</p>
					<video controls="controls">
						<source src="/resources/img/siba.mp4" type="video/mp4" />
					</video>
				</div>
				<div class="onediv" style="height: 340px;">
					<p>
						밥이다 밥 <br> 밥먹는 멍뭉이!
					</p>
					<video controls="controls">
						<source src="/resources/img/dog.mp4" type="video/mp4" />
					</video>
				</div>
				<div class="onediv" style="height: 340px;">
					<p>
						안녕하세요. <br> 고양이에용 냐옹 <br> 귀요미에용 <br> 마이네임 <br>
						이스 <br> 귀요밍 ~
					</p>
					<img src="/resources/img/cat.jpg">
				</div>
			</div>
			<div class="carddiv" onclick="divclick()">
				<div class="twodiv">
					<p>
						헤헤 후후 <br> 냥냥펀치!
					</p>
					<video controls="controls">
						<source src="/resources/img/catcat.mp4" type="video/mp4" />
					</video>
				</div>
				<div class="twodiv">
					<p>
						밥이다 밥 <br> 밥먹는 멍뭉이!
					</p>
					<video controls="controls">
						<source src="/resources/img/dog.mp4" type="video/mp4" />
					</video>
				</div>
				<div class="twodiv">
					<p>
						헤헤 후후 <br> 냥냥펀치!
					</p>
					<video controls="controls">
						<source src="/resources/img/catcat.mp4" type="video/mp4" />
					</video>
				</div>
				<div class="twodiv" style="height: 455px;">
					<p>
						안녕하세요. <br> 고양이에용 냐옹 <br> 귀요미에용 <br> 마이네임 <br>
						이스 <br> 귀요밍 ~
					</p>
					<img src="/resources/img/cat.jpg">
				</div>
				<div class="twodiv" style="position: relative; bottom: 231px;">
					<p>
						안녕하세요. <br> 고양이에용 냐옹
					</p>
					<img src="/resources/img/cat.jpg">
				</div>
			</div>
			<div class="carddiv" onclick="divclick()">
				<div class="threediv">
					<p>
						밥이다 밥 <br> 밥먹는 멍뭉이!
					</p>
					<video controls="controls">
						<source src="/resources/img/dog.mp4" type="video/mp4" />
					</video>
				</div>
				<div class="threediv">
					<p>
						헤헤 후후 <br> 냥냥펀치!
					</p>
					<video controls="controls">
						<source src="/resources/img/catcat.mp4" type="video/mp4" />
					</video>
				</div>
				<div class="threediv">
					<p>
						밥이다 밥 <br> 밥먹는 멍뭉이!
					</p>
					<video controls="controls">
						<source src="/resources/img/dog.mp4" type="video/mp4" />
					</video>
				</div>
				<div class="threediv">
					<p>
						안늉안늉! <br> 멍뭉이에용! 멍!
					</p>
					<img src="/resources/img/dogdog.jpg">
				</div>
				<div class="threediv">
					<p>
						안늉안늉! <br> 멍뭉이에용! 멍!
					</p>
					<img src="/resources/img/dogdog.jpg">
				</div>
				<div class="threediv">
					<p>
						안늉안늉! <br> 멍뭉이에용! 멍!
					</p>
					<img src="/resources/img/dogdog.jpg">
				</div>
			</div>
			<div class="carddiv" onclick="divclick()">
				<div class="fourdiv">
					<p>
						헤헤 후후 <br> 냥냥펀치!
					</p>
					<video controls="controls">
						<source src="/resources/img/catcat.mp4" type="video/mp4" />
					</video>
				</div>
				<div class="fourdiv">
					<p>
						안녕하세요. <br> 고양이에용 냐옹
					</p>
					<img src="/resources/img/cat.jpg">
				</div>
				<div class="fourdiv">
					<p>
						안늉안늉! <br> 멍뭉이에용! 멍!
					</p>
					<img src="/resources/img/dogdog.jpg">
				</div>
				<div class="fourdiv">
					<p>
						엉덩이 공격! <br> 시바시바!
					</p>
					<video controls="controls">
						<source src="/resources/img/siba.mp4" type="video/mp4" />
					</video>
				</div>
				<div class="fourdiv">
					<p>
						엉덩이 공격! <br> 시바시바!
					</p>
					<video controls="controls">
						<source src="/resources/img/siba.mp4" type="video/mp4" />
					</video>
				</div>
				<div class="fourdiv" style="height: 340px;">
					<p>
						헤헤 후후 <br> 냥냥펀치! <br> 냥냐라냥냥~! <br> 빠샤! <br>
						후훗!
					</p>
					<video controls="controls">
						<source src="/resources/img/catcat.mp4" type="video/mp4" />
					</video>
				</div>
				<div class="fourdiv" style="position: relative; bottom: 173px;">
					<p>
						밥이다 밥 <br> 밥먹는 멍뭉이!
					</p>
					<video controls="controls">
						<source src="/resources/img/dog.mp4" type="video/mp4" />
					</video>
				</div>
			</div>
			<div class="carddiv" onclick="divclick()">
				<div class="fivediv">
					<p>
						안늉안늉! <br> 멍뭉이에용! 멍!
					</p>
					<img src="/resources/img/dogdog.jpg">
				</div>
				<div class="fivediv">
					<p>
						밥이다 밥 <br> 밥먹는 멍뭉이!
					</p>
					<video controls="controls">
						<source src="/resources/img/dog.mp4" type="video/mp4" />
					</video>
				</div>
				<div class="fivediv">
					<p>
						안늉안늉! <br> 멍뭉이에용! 멍!
					</p>
					<img src="/resources/img/dogdog.jpg">
				</div>
				<div class="fivediv">
					<p>
						엉덩이 공격! <br> 시바시바!
					</p>
					<video controls="controls">
						<source src="/resources/img/siba.mp4" type="video/mp4" />
					</video>
				</div>
				<div class="fivediv">
					<p>
						안녕하세요. <br> 고양이에용 냐옹
					</p>
					<img src="/resources/img/cat.jpg">
				</div>
				<div class="fourdiv">
					<p>
						헤헤 후후 <br> 냥냥펀치!
					</p>
					<video controls="controls">
						<source src="/resources/img/catcat.mp4" type="video/mp4" />
					</video>
				</div>
				<div class="fourdiv">
					<p>
						헤헤 후후 <br> 냥냥펀치!
					</p>
					<video controls="controls">
						<source src="/resources/img/catcat.mp4" type="video/mp4" />
					</video>
				</div>
				<div class="fivediv">
					<p>
						엉덩이 공격! <br> 시바시바!
					</p>
					<video controls="controls">
						<source src="/resources/img/siba.mp4" type="video/mp4" />
					</video>
				</div>
			</div>
		</div>
		<div id="divbottom">
			<p id="numview"></p>
			<button class="arrow" onclick="moveA(-1)">&#60;</button>
			<button class="arrow" onclick="moveA(1)">&#62;</button>
			<button id="btnclick" onclick="btnclick()">submit</button>
		</div>
	</div>
	<div id="footdiv">
		<%@ include file="../include/footer.jsp"%>
	</div>
	<script>
		var num = 0;
		var ArrayF = new Array();
		var colorG = '#01DF01';
		var colorR = '#FF0000';
		var numview = document.getElementById('numview');
		numview.innerHTML = "1/5";
		var carddiv = document.getElementsByClassName('carddiv');
		carddiv[0].style.display = 'block';
		for (var i = 0; i < carddiv.length; i++) {
			ArrayF[i] = false;
		}
		function cunfirmdiv() {
			for (var j = 0; j < carddiv.length; j++) {
				if (carddiv[j].style.display == 'block') {
					console.log(j);
					return j;
				}
			}
		}
		function confirmnum(nb) {
			if (nb == -1) {
				return 4;
			} else if (nb == 5) {
				return 0;
			} else {
				return nb;
			}
		}
		function moveA(number) {
			num = cunfirmdiv();
			carddiv[num].style.display = 'none';
			num = confirmnum(num + number);
			numview.innerHTML = num + 1 + "/5";
			carddiv[num].style.display = 'block';
		}
		function divclick() {
			num = cunfirmdiv();
			if (ArrayF[num] == false) {
				carddiv[num].style.backgroundColor = '#01DF01';
				ArrayF[num] = true;
			} else {
				carddiv[num].style.backgroundColor = '#FF0000';
				ArrayF[num] = false;
			}
		}

		function btnclick() {
			
			location.href = "testvalue.html?ArrayF=" + ArrayF;
		}
	</script>
</body>

</html>