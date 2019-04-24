<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" type="text/css" href="../res/css/base.css"/>
  <link rel="stylesheet" type="text/css" href="../res/css/style.css"/>
  <script type="text/javascript" src="../res/js/jquery-1.7.2.min.js"></script>
  <script type="text/javascript" src="../res/js/comm.js"></script>
  <title>开始测试</title>
</head>
<body class="bg_fff">
<!--公共头部-->
<#--<div class="com_header">-->
<#--<div class="logo">-->
<#--<svg width="179" height="60">-->
<#--<image xlink:href="../res/images/logo_pagtitle.svg" src="../res/images/logo_pagtitle.png" width="179" height="60" />-->
<#--</svg>-->
<#--</div>-->
<#--<div class="right">-->
<#--<div class="zs">-->
<#--<p>测评状态：<span>未完成</span></p>-->
<#--<p>开始时间：<i>2018年04月20日 16:00</i></p>-->
<#--</div>-->
<#--<a href="" class="btn">退出</a>-->
<#--</div>-->
<#--</div>-->
<div class="w12">
  <div class="main3">
    <div class="title">
      <a href="/user/home">主界面</a> <span> >API测验</span>
    </div>
    <div class="cs_tip">
      <img src="../res/images/deng.jpg" alt=""/>
      <p>请填写测试接口信息</p>
    </div>
    <div class="cs_form">
      <form action="">
        <ul>
          <li>
            <div class="line">
              <span>URL</span>
              <p><input id="url" type="text"/></p>
            </div>
          </li>
          <li>
            <div class="line line1">
              <span>请求</span>
              <p>
                <select id="qingQiu">
                  <option value="POST"> POST</option>
                  <option value="GET">GET</option>
                </select>
              </p>
            </div>
            <div class="line line2">
              <span>cookie</span>
              <p><input id="cookie" type="text"/></p>
            </div>
          </li>
          <li>
            <div class="line">
              <span>参数</span>
              <p><input id="chanShu" type="text"/></p>
            </div>
          </li>
        </ul>
      </form>
      <a id="login" onclick="api()" style="cursor: pointer">测试</a>
    </div>
    <div class="cs_tip">
      <pre>  结果如下:</pre>
      <br>
    <#--<p id="show_p">{ "name": "Brett", "address":"北京路23号", "email": "123456@qq.com" }</p>-->
      <pre id="out_pre"></pre>
    </div>
  </div>
</div>
<script src="../Scripts/layer/layer.js"></script>
<script>
  function api() {
    var url = $("#url").val();
    var cookie = $("#cookie").val();
    var chanShu = $("#chanShu").val();
    var qingQiu = $("#qingQiu").val();
    $.ajax({
      url: "/api/cheShe",
      type: "post",
      data: {
        url: url,
        cookie: cookie,
        chanShu: chanShu,
        qingQiu: qingQiu,
      },
      success: function (data) {
        console.log(data);
        if (data.succeed) {
          //将字符串转换成json对象
          var result = JSON.stringify(JSON.parse(data.data), null, 2);
          // var result = data.data;
          document.getElementById('out_pre').innerText = result;
        } else {
          document.getElementById('out_pre').innerText =
              "格式错误或系统繁忙请稍后在试哟亲—(#^.^#)—";
        }
      }
    })
  }
</script>
</body>
</html>
