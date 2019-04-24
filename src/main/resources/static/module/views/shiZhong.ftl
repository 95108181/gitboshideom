<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <script type="text/javascript" src="res/js/jquery-1.7.2.min.js"></script>
  <title>等待页面</title>
  <link rel="stylesheet" href="../module/css/style.css">
</head>
<body>

<div id="watch">
  <div class="digit">
    <span>1</span>
  </div>
  <div class="digit">
    <span>2</span>
  </div>
  <div class="digit">
    <span>请</span>
  </div>
  <div class="digit">
    <span>4</span>
  </div>
  <div class="digit">
    <span>5</span>
  </div>
  <div class="digit">
    <span>稍</span>
  </div>
  <div class="digit">
    <span>7</span>
  </div>
  <div class="digit">
    <span>8</span>
  </div>
  <div class="digit">
    <span>等</span>
  </div>
  <div class="digit">
    <span>10</span>
  </div>
  <div class="digit">
    <span>11</span>
  </div>
  <div class="digit">
    <span>傻瓜</span>
  </div>
  <div id="mickey"></div>
  <div class="left" id="hours"></div>
  <div class="right" id="minutes"></div>
</div>

<script src="../module/js/shiZhong.js"></script>
<script>

  setTimeout( function(){
    window.location.href = "/Appium/huLiApp";
  }, 2 * 1000 );//延迟5000毫米

  // window.onload = function () {
  //   window.location.href = "/Appium/huLiApp";
  // }
</script>
</body>
</html>
