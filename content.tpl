<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css" href="styles/fonts.css">
    <link rel="stylesheet" type="text/css" href="styles/content.css">
    <!--[if IE]>
     <link rel="stylesheet" type="text/css" href="styles/content-ie.css">
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="styles/highlight.css">
    <script type="text/javascript" src="jscripts/highlight.pack.js"></script>
    <script type="text/javascript">
       function latest () {
          window.location= '#latest';
       }
       hljs.tabReplace = '   ';
       hljs.initHighlightingOnLoad();
       window.onload = function() {
          setTimeout(latest, 1000*2);
       };
    </script>
  </head>
  <body>
    <div id="content">
      <?=$html?>
    </div>
  </body>
</html>
