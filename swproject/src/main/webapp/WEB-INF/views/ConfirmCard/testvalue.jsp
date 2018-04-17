<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>

<%@ include file="../include/header.jsp"%>
<head>
    <title>result!</title>
    <style>
        #divking {
            width: 200px;
        }
    </style>
</head>

<body>
    <h1>ê²°ê³¼</h1>
    <div id="divking">
        01<input type="text" class="valueview">
        02<input type="text" class="valueview">
        03<input type="text" class="valueview">
        04<input type="text" class="valueview">
        05<input type="text" class="valueview">
        06<input type="text" class="valueview">
        07<input type="text" class="valueview">
        08<input type="text" class="valueview">
        09<input type="text" class="valueview">
        10<input type="text" class="valueview">
        11<input type="text" class="valueview">
        12<input type="text" class="valueview">
        13<input type="text" class="valueview">
        14<input type="text" class="valueview">
        15<input type="text" class="valueview">
    </div>
<div style="bottom: 0px;">
	<%@ include file="../include/footer.jsp"%>
</div>
    <script>
        var urlvalue = location.href.substr(location.href.lastIndexOf('=') + 1);
        var urlsplit = urlvalue.split(',');
        var valueview = document.getElementsByClassName('valueview');
        var viewp = document.getElementsByTagName('p');
        for (var i in urlsplit) {
            valueview[i].value = urlsplit[i];
            viewp[i] = i+1;
        }
    </script>
</body>

</html>
<!-- ëì : http://blog.opid.kr/431 -->