<?php

require_once 'stringparser_bbcode.class.php';

// Zeilenumbrüche verschiedener Betriebsysteme vereinheitlichen
function convertlinebreaks ($text) {
   return preg_replace ("/\015\012|\015|\012/", "\n", $text);
}

// Alles bis auf Neuezeile-Zeichen entfernen
function bbcode_stripcontents ($text) {
   return preg_replace ("/[^\n]/", '', $text);
}

//function nlnl2br ($text) {
//   $text = preg_replace('/\n\n[\t ]*/s', '<br />', $text);
//   $text = preg_replace('/\n[\t ]*/s', ' ', $text);
//   return  $text;
//}

function bbcode ($bb) {
   $bbcode = new StringParser_BBCode ();
   $bbcode->addFilter (STRINGPARSER_FILTER_PRE, 'convertlinebreaks');

   $bbcode->addParser (array ('block', 'inline', 'link', 'listitem'), 'translate');
   $bbcode->addParser (array ('block', 'inline', 'link', 'listitem'), 'nl2br');

   # handle simple repacements
   $bbcode->addCode ('b', 'simple_replace', null, array ('start_tag' => '<b>', 'end_tag' => '</b>'),
                     'inline', array ('listitem', 'block', 'inline', 'link'), array ());
   $bbcode->addCode ('i', 'simple_replace', null, array ('start_tag' => '<i>', 'end_tag' => '</i>'),
                     'inline', array ('listitem', 'block', 'inline', 'link'), array ());
   $bbcode->addCode ('blue', 'simple_replace', null, array ('start_tag' => '<span class="blue">', 'end_tag' => '</span>'),
                     'inline', array ('listitem', 'block', 'inline', 'link'), array ());
   $bbcode->addCode ('red', 'simple_replace', null, array ('start_tag' => '<span class="red">', 'end_tag' => '</span>'),
                     'inline', array ('listitem', 'block', 'inline', 'link'), array ());
   $bbcode->addCode ('green', 'simple_replace', null, array ('start_tag' => '<span class="green">', 'end_tag' => '</span>'),
                     'inline', array ('listitem', 'block', 'inline', 'link'), array ());
   $bbcode->addCode ('gray', 'simple_replace', null, array ('start_tag' => '<span class="gray">', 'end_tag' => '</span>'),
                     'inline', array ('listitem', 'block', 'inline', 'link'), array ());

   $bbcode->addCode ('small', 'simple_replace', null, array ('start_tag' => '<small>', 'end_tag' => '</small>'),
                     'inline', array ('listitem', 'block', 'inline', 'link'), array ());
   $bbcode->addCode ('big', 'simple_replace', null, array ('start_tag' => '<big>', 'end_tag' => '</big>'),
                     'inline', array ('listitem', 'block', 'inline', 'link'), array ());
   $bbcode->addCode ('mono', 'simple_replace', null, array ('start_tag' => '<pre>', 'end_tag' => '</pre>'),
                     'inline', array ('listitem', 'block', 'inline', 'link'), array ());

   $bbcode->addCode ('done', 'simple_replace_single', null, array ('start_tag' => '<img src="images/dialog-ok-apply-5.svg" width="20" alt="[done]" title="done" style="border:0" />'),
                     'inline', array ('listitem', 'block', 'inline', 'link'), array ());
   $bbcode->addCode ('rejected', 'simple_replace_single', null, array ('start_tag' => '<img src="images/edit-delete-6.svg" width="20" alt="[rejected]" title="rejected" style="border:0" />'),
                     'inline', array ('listitem', 'block', 'inline', 'link'), array ());
   $bbcode->addCode ('postponed', 'simple_replace_single', null, array ('start_tag' => '<img src="images/go-down-7.svg" width="20" alt="[postponed]" title="postponed" style="border:0" />'),
                     'inline', array ('listitem', 'block', 'inline', 'link'), array ());
   $bbcode->addCode ('latest', 'simple_replace_single', null, array ('start_tag' => '<a name="latest"></a>'),
                     'inline', array ('listitem', 'block', 'inline', 'link'), array ());

   # handle document structure elements
   $bbcode->addCode ('title', 'simple_replace', null, array ('start_tag' => "<h1>", 'end_tag' => "</h1>\n"),
                     'inline', array ('block'), array ());
   $bbcode->setCodeFlag ('title', 'paragraph_type', BBCODE_PARAGRAPH_BLOCK_ELEMENT);
   $bbcode->addCode ('chapter', 'simple_replace', null, array ('start_tag' => "<h2>", 'end_tag' => "</h2>\n"),
                     'inline', array ('block'), array ());
   $bbcode->setCodeFlag ('chapter', 'paragraph_type', BBCODE_PARAGRAPH_BLOCK_ELEMENT);
   $bbcode->addCode ('section', 'simple_replace', null, array ('start_tag' => "<h3>", 'end_tag' => "</h3>\n"),
                     'inline', array ('block'), array ());
   $bbcode->setCodeFlag ('section', 'paragraph_type', BBCODE_PARAGRAPH_BLOCK_ELEMENT);
   $bbcode->addCode ('block', 'simple_replace', null, array ('start_tag' => "<h4>", 'end_tag' => "</h4>\n"),
                     'inline', array ('block'), array ());
   $bbcode->setCodeFlag ('block', 'paragraph_type', BBCODE_PARAGRAPH_BLOCK_ELEMENT);

   // handle code snipets
   function do_bbcode_code ($action, $attributes, $content, $params, $node_object) {
      if (!isset ($attributes['default'])) {
         $lang = '';
      } else {
         $lang = $attributes['default'];
      }
      if ($action == 'validate') {
         $langs = array("no-highlight", "bash", "diff", "javascript", "css", "xml", "http", "php", "sql", "ini", "perl", "avrasm", "json", "dos", "apache", "cpp");
         if ($lang != '' && $lang != 'none' && !in_array($lang, $langs)) {
            return false;
         }
         return true;
      }
      $text = translate($content);
      if($lang == "none") {
      	$lang = "no-highlight";
      }
      return "<pre><code class=\"$lang\">$text</pre></code>\n";
   }
   $bbcode->addCode ('cde', 'simple_replace', null, array ('start_tag' => '<pre><code>', 'end_tag' => '</pre></code>'),
                     'code', array ('listitem', 'block'), array ());
   $bbcode->addCode ('code', 'usecontent', 'do_bbcode_code', array ('usecontent_param' => 'default'),
                     'code', array ('block'), array ());
   $bbcode->setCodeFlag ('code', 'paragraph_type', BBCODE_PARAGRAPH_BLOCK_ELEMENT);
   $bbcode->setCodeFlag ('code', 'opentag.after.newline', BBCODE_NEWLINE_DROP);
   $bbcode->setCodeFlag ('code', 'closetag.before.newline', BBCODE_NEWLINE_DROP);

   $bbcode->addCode ('important', 'simple_replace', null, array ('start_tag' => '<blockquote class="important">', 'end_tag' => '</blockquote>'),
                     'inline', array ('listitem', 'block'), array ());
   $bbcode->setCodeFlag ('important', 'paragraph_type', BBCODE_PARAGRAPH_BLOCK_ELEMENT);
   $bbcode->setCodeFlag ('important', 'opentag.after.newline', BBCODE_NEWLINE_DROP);
   $bbcode->setCodeFlag ('important', 'closetag.before.newline', BBCODE_NEWLINE_DROP);


   // handle url links
   function do_bbcode_url ($action, $attributes, $content, $params, $node_object) {
      if (!isset ($attributes['default'])) {
         $url = $content;
         $text = translate ($content);
      } else {
         $url = $attributes['default'];
         $text = $content;
      }
      if ($action == 'validate') {
         if (substr ($url, 0, 5) == 'data:' || substr ($url, 0, 5) == 'file:'
             || substr ($url, 0, 11) == 'javascript:' || substr ($url, 0, 4) == 'jar:') {
            return false;
         }
         return true;
      }
      return "<a href=\"$url\" target=\"_blank\"><img src=\"images/text-html.svg\" width=\"20\" style=\"border:0\" class=\"screen\" />$text</a>";
//    return '<a href="'.translate($url).'">'..'</a>';
   }
   $bbcode->addCode ('url', 'usecontent?', 'do_bbcode_url', array ('usecontent_param' => 'default'),
                     'link', array ('listitem', 'block', 'inline'), array ('link'));
   $bbcode->addCode ('link', 'callback_replace_single', 'do_bbcode_url', array (),
                     'link', array ('listitem', 'block', 'inline'), array ('link'));

   // handle local links
   function do_bbcode_local ($action, $attributes, $content, $params, $node_object) {
      if (!isset ($attributes['default'])) {
         $doc = $content;
         $text = translate ($content);
      } else {
         $doc = $attributes['default'];
         $text = $content;
      }
      if ($action == 'validate') {
         preg_match('/^([^\?#]+)/i', $doc, $hits);
         if (!file_exists ('content/'.$hits[1])) {
            return false;
         }
         return true;
      }
      $doc = translate($doc);
      return "<a href=\"index.php?$doc\" target=\"_parent\">$text</a>";
   }
   $bbcode->addCode ('local', 'usecontent?', 'do_bbcode_local', array ('usecontent_param' => 'default'),
                     'link', array ('listitem', 'block', 'inline'), array ('link'));


/*
   // handle images (but only two per page ???)
   function do_bbcode_img ($action, $attributes, $content, $params, $node_object) {
      if ($action == 'validate') {
         if (substr ($content, 0, 5) == 'data:' || substr ($content, 0, 5) == 'file:'
             || substr ($content, 0, 11) == 'javascript:' || substr ($content, 0, 4) == 'jar:') {
            return false;
         }
         return true;
      }
      return '<img src="'.translate($content).'" alt="">';
   }
   $bbcode->addCode ('img', 'usecontent', 'do_bbcode_img', array (),
                     'image', array ('listitem', 'block', 'inline', 'link'), array ());
   $bbcode->setOccurrenceType ('img', 'image');
   $bbcode->setMaxOccurrences ('image', 2);
*/

   // handle images
   function do_bbcode_image ($action, $attributes, $content, $params, $node_object) {
      $src   = "";
      $tn    = "";
      $float = "";

      if (isset ($attributes['src']))
         $src = $attributes['src'];
      if (isset ($attributes['tn']))
         $tn = $attributes['tn'];
      if (isset ($attributes['float']))
         $float = $attributes['float'];

      if ($action == 'validate') {
         if ($src == "" || substr ($src, 0, 5) == 'data:'
                        || substr ($src, 0, 5) == 'file:'
                        || substr ($src, 0, 11) == 'javascript:'
                        || substr ($src, 0, 4) == 'jar:') {
            return false;
         }
         if (substr ($tn, 0, 5) == 'data:'
             || substr ($tn, 0, 5) == 'file:'
             || substr ($tn, 0, 11) == 'javascript:'
             || substr ($tn, 0, 4) == 'jar:') {
            return false;
         }
         if (!file_exists ('content/images/'.$src)) {
            return false;
         }
         if ($tn != "" && !file_exists ('content/images/'.$tn)) {
            return false;
         }
         if ($float != "" && $float != "right" && $float != "left") {
            return false;
         }
         return true;
      }
      if ($tn != "") {
         $html = "<a href=\"content/images/$src\" target=\"_blank\">"
               . "<img src=\"content/images/$tn\" class=\"border $float\">"
               . "</a>";
      } else {
         $html = "<img src=\"content/images/$src\" class=\"border $float\">";
      }
      return $html;
   }
   $bbcode->addCode ('image', 'callback_replace_single', 'do_bbcode_image', array (),
                     'image', array ('listitem', 'block', 'inline', 'link'), array ());


   // handle html ordered and unordered Lists
   function do_bbcode_list ($action, $attributes, $content, $params, $node_object) {
      switch (isset($attributes['default']) ? $attributes['default'] : 'o') {
         case 'o': $type = 'circle';      $list = 'ul'; break;
         case '*': $type = 'disc';        $list = 'ul'; break;
         case 's': $type = 'square';      $list = 'ul'; break;
         case 'o': $type = 'circle';      $list = 'ul'; break;
         case '1': $type = 'decimal';     $list = 'ol'; break;
         case 'I': $type = 'upper-roman'; $list = 'ol'; break;
         case 'i': $type = 'lower-roman'; $list = 'ol'; break;
         case 'A': $type = 'upper-latin'; $list = 'ol'; break;
         case 'a': $type = 'lower-latin'; $list = 'ol'; break;
      }
      if ($action == 'validate') {
         if (!isset($type)) {
            return false;
         }
         return true;
      }
      return "<$list style=\"list-style-type:$type\">$content</$list>\n";
   }
   $bbcode->addParser ('list', 'bbcode_stripcontents');
   $bbcode->addCode ('list', 'callback_replace', 'do_bbcode_list', array (),
                     'list', array ('block', 'listitem'), array ());
   $bbcode->addCode ('*', 'simple_replace', null, array ('start_tag' => '<li>', 'end_tag' => '</li>'),
                     'listitem', array ('list'), array ());
   $bbcode->setCodeFlag ('*', 'closetag', BBCODE_CLOSETAG_OPTIONAL);
   $bbcode->setCodeFlag ('*', 'opentag.before.newline', BBCODE_NEWLINE_DROP);
   $bbcode->setCodeFlag ('*', 'paragraphs', false);
   $bbcode->setCodeFlag ('list', 'paragraph_type', BBCODE_PARAGRAPH_BLOCK_ELEMENT);
   $bbcode->setCodeFlag ('list', 'opentag.after.newline', BBCODE_NEWLINE_DROP);
   $bbcode->setCodeFlag ('list', 'closetag.before.newline', BBCODE_NEWLINE_DROP);


   $bbcode->setRootParagraphHandling (true);

   return $bbcode->parse ($bb);
}

?>
