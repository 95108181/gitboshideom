<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>出错啦！</title>
  <style>
    :root {
      --X: 0;
      --Y: 0;
    }

    * {
      box-sizing: border-box;
      -webkit-animation: fadeIn 0.5s;
      animation: fadeIn 0.5s;
    }

    body {
      background-color: #111;
      color: #fafafa;
      display: -webkit-box;
      display: -ms-flexbox;
      display: flex;
      -webkit-box-align: center;
      -ms-flex-align: center;
      align-items: center;
      -webkit-box-pack: center;
      -ms-flex-pack: center;
      justify-content: center;
      overflow: hidden;
      height: 100vh;
      width: 100vw;
    }

    @media ( max-width: 768px) {
      h2 {
        font-size: 16px;
      }
    }

    h1 {
      font-size: 110px;
      margin: 4px;
      display: inline-block;
    }

    @media ( max-width: 768px) {
      h1 {
        -webkit-transition: all 0.25s ease 0s;
        transition: all 0.25s ease 0s;
        font-size: 60px;
      }
    }

    h1:nth-of-type(1) {
      color: #f00;
      --scaleX: 40;
      --scaleY: -40;
      --translateX: calc((var(--X)) * var(--scaleX) * 1px);
      --translateY: calc((var(--Y)) * var(--scaleY) * 1px);
      -webkit-transform: translate(var(--translateX), var(--translateY));
      transform: translate(var(--translateX), var(--translateY));
      z-index: 3;
    }

    h1:nth-of-type(2) {
      color: #ffa500;
      --scaleX: -50;
      --scaleY: 50;
      --translateX: calc((var(--X)) * var(--scaleX) * 1px);
      --translateY: calc((var(--Y)) * var(--scaleY) * 1px);
      -webkit-transform: translate(var(--translateX), var(--translateY));
      transform: translate(var(--translateX), var(--translateY));
      z-index: 2;
    }

    h1:nth-of-type(3) {
      color: #008000;
      --scaleX: 30;
      --scaleY: 30;
      --translateX: calc((var(--X)) * var(--scaleX) * 1px);
      --translateY: calc((var(--Y)) * var(--scaleY) * 1px);
      -webkit-transform: translate(var(--translateX), var(--translateY));
      transform: translate(var(--translateX), var(--translateY));
      z-index: 1;
    }

    h1:nth-of-type(4) {
      z-index: 4;
      --scaleX: -50;
      --scaleY: -50;
      --translateX: calc((var(--X)) * var(--scaleX) * 1px);
      --translateY: calc((var(--Y)) * var(--scaleY) * 1px);
      -webkit-transform: translate(var(--translateX), var(--translateY));
      transform: translate(var(--translateX), var(--translateY));
    }

    @
    -webkit-keyframes fadeIn {

    from {
      opacity: 0;

    }

    to {
      opacity: 1;
    }

    }
    @
    keyframes fadeIn {

    from {
      opacity: 0;

    }

    to {
      opacity: 1;
    }

    }
  </style>
</head>
<body>
<h1>e</h1>
<h1>r</h1>
<h1>r</h1>
<h1>0</h1>
<h1>r</h1>
<h2 onclick="window.location.href='/pc/user/login'">${errorMsg}</h2>
<script type="text/javascript">
  const root = document.documentElement

  const update = (e) =
  >
  {
    if (e.acceleration && e.acceleration.x !== null) {
      root.style.setProperty('--X', e.acceleration.x)
      root.style.setProperty('--Y', e.acceleration.y)
    } else {
      root.style.setProperty('--X', (e.pageX / innerWidth) - 0.5)
      root.style.setProperty('--Y', (e.pageY / innerHeight) - 0.5)
    }
  }

  document.body.addEventListener('mousemove', update)
  window.ondevicemotion = update;
</script>
</body>
</html>