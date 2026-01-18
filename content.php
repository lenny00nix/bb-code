<?php
require_once "scripts/bbcode.php";

header("Cache-Control: no-cache, must-revalidate"); // HTTP/1.1
header("Expires: Sat, 26 Jul 1997 05:00:00 GMT"); // Date in the past
header("Content-Type: text/html; charset=utf-8");

function translate($string) {
   $table = get_html_translation_table(HTML_ENTITIES, ENT_QUOTES | ENT_HTML5, 'utf-8');
   $rev_trans = array_flip($table);
   $string = strtr($string, $rev_trans);
   $string = htmlentities($string, 0|ENT_SUBSTITUTE, 'utf-8');
   return $string;
}

$item = $_SERVER['QUERY_STRING'];

preg_match('/^([^\?]+)/i', $item, $hits);
if(file_exists('content/'.$hits[1])) {
	if(preg_match('/\.txt$/', $item)) {
		$fp = fopen("content/$item", 'r');
		$tmp = fread($fp, 1048576);
		fclose($fp);

        $tmp = translate($tmp);

		for($i=0; $i<=5; $i++)
			$tmp = preg_replace('#\[(h1|h2|h3|h4|h5|p|ol|ul|li|b|i|table|tr|th|td|small|big)](.+?)\[/\1]#si', '<\1>\2</\1>', $tmp);
		$tmp = preg_replace('#\[(th|td|)\s+(nowrap)](.+?)\[/\1]#si', '<\1 class="\2">\3</\1>', $tmp);
		$tmp = preg_replace('#\[(p|h1|h2|h3)\s+([^]]*)](.+?)\[/\1]#si', '<\1 class="\2">\3</\1>', $tmp);
		$tmp = preg_replace('#\[(red|blue|green)](.+?)\[/\1]#si', '<span class="\1">\2</span>', $tmp);
		$tmp = preg_replace('#\[br]#si', '<br />', $tmp);
		$tmp = preg_replace('#\[hr]#si', '<hr /><p class="goto_begin"><a href="#begin">zum Seitenanfang</a></p>', $tmp);
		$tmp = preg_replace('#=&gt;#s', '&rArr;', $tmp);
		$tmp = preg_replace('#\[img\s+\'([^]]*)\'\s+([^]]*)]#si', '<img src="content/images/\1" class="\2" />', $tmp);
		$tmp = preg_replace('#\[img-tn\s+\'([^]]*)\'\s+\'([^]]*)\'\s+([^]]*)]#si', '<a href="content/images/\2" target="_blank"><img src="content/images/\1" class="\3" /></a>', $tmp);
		$tmp = preg_replace('#\[pdf\s+\'([^]]*)\'\s+\'([^]]*)\']#si', '<a href="documents/\2" target="_blank"><img src="images/icons/pdf.gif" style="border:0" class="screen" />\1</a>', $tmp);
		$tmp = preg_replace('#\[lnk\s+\'([^]]*)\'\s+\'([^]]*)\']#si', '<a href="\2" target="_blank"><img src="images/icons/lnk.gif" style="border:0" class="screen" />\1</a>', $tmp);
		$tmp = preg_replace('#\[mailto\s+\'([^\@]+)\@([^\']+)\']#si', '<script language="JavaScript">'."\n".'<!--'."\n".'document.write(\'<a href="mailto:\1\' + \'@\' + \'\2">\1\' + \'@\' + \'\2</a>\');'."\n".'//-->'."\n".'</script>', $tmp);
		$tmp = preg_replace('#\[phone\s+\'([0-9]+)\s+([0-9]+)\s+([0-9]+)\']#si', '<script language="JavaScript">'."\n".'<!--'."\n".'document.write(\'+\' + \'\1\' + \' (\' + \'\2\' + \') \' + \'\3\');'."\n".'//-->'."\n".'</script>', $tmp);
		$tmp = preg_replace('#\[link\s+\'([^]]*)\'\s+\'([^]]*)\']#si', '<a href="\2" target="_blank">\1</a>', $tmp);
		$tmp = preg_replace('#\[local\s+\'([^]]*)\'\s+\'([^]]*)\']#si', '<a href="?item=\2">\1</a>', $tmp);
		$tmp = preg_replace('#\[music\s+\'([^]]*)\']#si', '<embed src="\1" width="200" height="44" type="audio/x-midi" autostart="false"></embed>', $tmp);
		$tmp = preg_replace('#\[window\s+\'([^]]*)\'\s+\'([^]]*)\'\s+\'([^]]*)\'\s+\'([^]]*)\']#si', '<a href="javascript:window.open(\'\2\', \'\3\', \'\4\').focus();">\1</a>', $tmp);
		$tmp = preg_replace('#\[ok]#si', '<img src="images/open_icon_library-0.11/svg/actions/dialog-ok-apply-5.svg" width="20" alt="done" title="done" style="border:0" />', $tmp);

		$html = $tmp;
	} else if(preg_match('/\.php(|\?.*)$/', $item)) {
      header('Location: content/'.$item);
      exit;
   } else if(preg_match('/\.bb$/', $item)) {
      $fp = fopen("content/$item", 'r');
      $bb = fread($fp, 1048576);
      fclose($fp);
      $html = bbcode($bb);
   } else {
      $fp = fopen("content/$item", 'r');
      $html = fread($fp, 1048576);
      fclose($fp);
      print $html;
      exit;
   }
} else {
   $html = "<p>Die Inhaltsdatei kann nicht ge&ouml;ffnet werden.</p>\n";
}

require_once 'content.tpl';

?>
