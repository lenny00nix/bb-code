[title]Einstieg ins Projekt Iffeldorf mit Version 2.0[/title]

[chapter]Spezifikation Hardware & Software[/chapter]

[section]Voraussetzungen & Gegebenheiten[/section]

So wie in der ersten Version der Steuerungssoftware sollen alle Heizkreisläufe des Pfarrzentrums der Pfarrei St. Vitus in Iffeldorf durch die Daten gesteuert werden, die aus einem Kalenderportal cKalender exportiert werden können. Diese Daten beinhalten alle Termine oder Terminserien den einzelnen Räumen des Pfarrzentrums zugeordnet. Da der Pfarrsaal zwei Heizkreisläufe besitzt und das Forum und die Toiletten im Erdgeschoss und im Keller nicht getrennt im Kalender ausgewählt werden können, muss die zu erstellende Steuersoftware, wie schon in Version 1 eine Gruppenschaltung ermöglichen. Hier eine Liste der vom Kalender bereitgestellten Raumzuordnungen:

[list]
[*]Pfarrsaal
[*]Küche
[*]30er_Raum
[*]40er_Raum
[*]60er_Raum
[*]Gruppenraum
[*]Jugendtreff
[/list]

Die Heizanlage des Pfarrzentrums besitzt 10 Heizkreisläufe, die einzeln angesteuert werden können:

[list]
[*]Pfarrsaal West
[*]Pfarrsaal Ost
[*]Foyer-WC EG
[*]Küche
[*]30er_Raum
[*]40er_Raum
[*]60er_Raum
[*]Gruppenraum
[*]Jugendtreff
[*]WC Keller
[/list]

Nur bei Veranstaltungen im Pfarrsaal werden Foyer und WC's im Erdgeschoss und Keller geheizt. Das bedeutet, dass diese Heizkreisläufe in einer Gruppe dem Raum Pfarrsaal aus dem Kalender zugeschaltet werden. Der Pfarrsaal besitzt zwar zwei Heizkreisläufe, jedoch werden diese ebenfalls in der Gruppe Pfarrsaal gleichzeitig geschaltet. Diese Raumgruppe I besteht also aus Heizkreislauf I, II, III und X.

Eine wichtige neue Anforderung gegenüber der Software Version 1 ist, dass jedem Heizkreislauf eine bestimmte Solltemperatur zugeordnet werden kann, die zwischen einer Schimmelschutz- und einer Nutzungstemperatur umgestellt werden kann. Das Stellen dieser beiden Betriebsarten erfolgt wiederum nach den Angaben aus den Daten aus dem cKalender Portal. Da bei der Anlage durchweg Fussbodenheizung eingebaut wurde, muss eine gewisse Vorlauf- und Nachlaufzeit konfigurierbar sein. Diese Konfiguration, wie auch alle anderen Einstellungen werden in der Version 2 in einer Konfigurationsdatei einzustellen sein.

[section]Folgerungen & Schlüsse[/section]

Aus den Voraussetzungen & Gegebenheiten ergeben sich folgende Schlüsse:

[list]
[*]Da die vorhandene Hardware kein Schalten zwischen verschiedenen Solltemperaturen zuläßt, wird eine neue Steuer Hardware besorgt.
[*]Die Wahl fällt auf eine Steuerplatine, die 8 Sensorkanäle und 8 Relaiskanäle besitzt. Der Hersteller ist Denkovi in Bulgarien: [lnk 'Herstellerdokumentation' 'http://www.denkovi.com/product/57/daenetip2-eight-relay-module-lm35-.html'] Die Karte ist über das Protokoll SNMP (Simple Network Management Protokoll) ansprechbar. Über sogenannte ATR's (Analog Trap Thresholds) sind kann man um eine Solltemperatur herum einen High- und Lowwert einstellen, bei dem das Relais automatisch aus- bzw. wieder einschaltet, ohne dass eine Aktion von außen notwendig ist.
[*]Da die Heizung des Pfarrzentrums 10 Heizkreisläufe besitzt, sind zwei Steuerkarten notwendig. Die verbleibenden Kanäle der zweiten Karte können in einer nächsten Softwareversion für Fühler an Heizungsvor- und rücklauf, bzw. evtl. auch für einen Außentemperaturfühler benutzt werden
[*]Die Temperaturfühler benötigen nicht 2 sondern 3 Drähte, die idealer Weise abgeschirmt sein sollten um Störeinflüsse zu minimieren.
[*]Die vom Kartenhersteller empfohlenen Temperaturfühler haben eine Tolleranz von 2°C, die jedoch nach einer angemessenen Eichprozedur mit einem ausgemessenen Korrekturwert verringert werden kann.
[*]Für die Anschlüsse der Messfühler ist je Karte eine Breakoutplatine herzustellen.
[/list]

[section]Anforderungen für die Umsetzung[/section]

Weitere Anforderungen wurden in der Vorbereitungsphase formuliert:

[list]
[*]Alle Temperaturen und Schaltzeiten sollen in einer Datenbank mitgeloggt werden. Intervall soll 5 Minuten betragen. Es sollen so viele Tage im Log erhalten bleiben, wie ausreichend Speicherplatz zur Verfügung steht.
[*]Über einen Webserver sollen grafische Auswertungen über die Anwärm- und Abkühlphase eines Raumes möglich sein um die optimalen Vor- und Nachlaufzeiten ermitteln zu können. Weitere Auswertungen müssen noch definiert werden, werden aber erst in der nächsten Softwareversion realisiert.
[*]Alle notwendigen Einstellungen sollen in einer Konfigurationsdatei vorgenommen werden können. Eine Webkonfiguration der Heizungssteuerung wird in dieser Version nicht realisiert.
[*]Eine manuelle Steuerung der Heizungsanlage ist nicht vorgesehen, weshalb ein Generator alle Daten, die aus dem cKalender-Portal abgerufen werden, in einem Interval von 15 Minuten neu erzeugen soll. Die Vorschau beträgt dabei 7 Tage (soll in der Konfigurationsdatei geändert werden können), damit im Notfall, z.B. Ausfall der Internetverbindung, alle bis dahin bekannten Veranstaltungen beheizt werden.
[*]Ein Commander soll die Einstellungen für die Sollwerte aller einmal in 5 Minuten an die Karten übertragen.
[*]Alle 10 Sekunden soll ein Collector alle Zustände der Karten an die Heizungssteuerungssoftware Übertragen und damit ein Abbild der Zustände der Karten in der Steuerung zur Verfügung stellen.
[*]Aus diesem Abbild der Zustände der Steuerkarten bedient sich eine dynamische Seite des Webservers, die alle Zustände der Anlage mit Hilfe grafischer Elemente anzeigt.
[*]Aus dem Abbild der Zustände der Steuerkarten bedient sich aber auch der Logger, der in dem schon erwähnten Intervall von 5 Minuten die relevanten Daten und deren Alter in die Datenbank schreibt.
[/list]

[section]Randbedingungen & Folgen für den Entwurf[/section]

Nach Kontaktaufnahme mit dem Hersteller der Controller-Karten konnte kein Konsens gefunden werden, was die Umsetzung von Anforderungen an die Firmware der Karten anging. Von meiner Seite aus bat ich darum, dass die Threadholds nicht mehr nur gleichzeitig in RAM und Flash geschrieben werden und somit die Anzahl der Schreibzyklen auf 10.000 über die Gesamtlebensdauer des Flashes begrenzt ist, sondern dass das Schreiben ins Flash durch Änderung der Einstellungen auf den Controller-Karten abschaltbar ist. Da der Hersteller der Bitte im Moment nicht nachkommen konnte, werde ich nun die Implementierung der Ventilsteuerung abhängig von der gewünschten Raumtemperatur im IPC vornehmen müssen. Eine Idee wäre, die Software-Architektur so zu gestalten, dass - sollte das vorgeschlagene Feature beim Hersteller der Controller-Karten implementiert werden - nur ein Flag des zuständigen Moduls auf dem IPC umzuschalten wäre um die Funktionalität auf den Controller-Karten nutzen zu könnnen.

[chapter]Planung bis zur Inbetriebnahme[/chapter]

Es bedarf nun eines strammen Zeitplans, damit die Heizungssteuerung vor der Heizperiode in das Pfarrzentrum eingebaut werden kann. Der folgende Plan soll als Checkliste dienen, damit zum Schluss nicht entscheidende Punkte unerledigt sind und die Inbetriebnahme verhindern oder verzögern.

[section]Einbau der Thermofühler ins Pfarrzentrum[/section]

[list=I]
[*] Bau einer Eichplatine [done]
[*] Bau eines Eichkastens [done]
[*] Implementierung eines Eich-Skriptes [done]
[*] Eichen der Thermofühler [done]
[*] Anpassung der Initialisierungsdatei [done]
[*] Übergabe der Thermofühler an Hans-Peter (Termin Mitte KW39 2013) [done]
    [b][green]=> 26.09.2013[/green][/b]
[/list]

[section]Einbau der Hardware ins Pfarrzentrum (Platinen und IPC)[/section]

[list=I]
[*] Finden einer geeigneten Architektur für Hard- und Software [done]
[*] Bau von 2 Breakoutplatinen zum Anschluss der Thermofühler im Test- und Produktivbetrieb [done]
[*] Implementierung und Test der Schnittstelle zur Ermittlung und zum Ändern der Daten auf den Controller-Karten [done]
[*] Implementierung eines Initialisierungsskriptes zum Test aller Bibliotheken, der Datenbankanbindung und der Schnittstellen zu den Controller-Karten [done]
[*] Installieren und Konfigurieren des neuen Betriebssystems auf dem IPC [done]
[*] Installieren und Konfigurieren von XAMPP auf dem IPC [done]
[*] Einrichten der Entwicklungs- und Anwendungskennung auf dem IPC [done]
[*] Verlagern der Dokumentations-Homepage auf den IPC [done]
[*] Implementierung des Skriptes zum Auslesen und Aufbereiten der Kalenderdaten für die Steuerdatei der Anlage [done]
[*] Implementierung des Skriptes, das die Hauptsteuerung der Anlage enthält, die auf den Daten der Steuerdatei aufsetzt [done]
[*] Normalisierung und Glättung des Codes, Bilden von gut geschnittenen Bibliohteken [done]
[*] Implementierung eines Überwachungsskriptes (nach Art der top Anwendung in Linux), kann grundsätzlich als Basis für das Eich-Skript verwendet werden! [done]
[*] Einführen einer CRONTAB-Datei, die die CRON-Konfiguration enthält und Implementierung der Programmanteile im Setup-Skript. Dort wird die Datei interpretiert und für den CRON und in die CRONTAB geladen. [done]
[*] Einbau einer Warnung vor Terminen, die so lang sind, dass sie zum Schluss über die Historie nicht mehr erkannt würden. Die Folge wäre, dass die letzten Tage nicht mehr beheizt würden. Korrektur von Einträgen, die über die vordere Grenze der History hinaus gehen mit Notice in die Log-Datei. Debug-Log-Dateieinträge mit lesbaren Zeitangaben ausstatten, damit ein Trocken-Testlauf in einem Review möglich ist. [done]
[*] Im Debug-Modus in der CSV-Steuerdatei einen lesbaren Zeitstempel anfügen, mit dem dann die Validierung der Algorithmen des Generators einfacher wird. [done]
[*] Implementieren eines Verwaltungsskripts, mit dem z.B. Logdatei kopiert und Überschreiben werden sollen, aufzurufen als Cronjob [done]
[*] Test und Anpassungen beim Portieren der Software auf den IPC [done]
[*] Einbau der Controller-Karten und der von mir hergestellten Breakoutkarten für den Anschluss der Thermofühler und Rückmontage des IPC. Anschluss der Karten und des IPC an den Router (Termin Mitte Oktober 2013) [done]
    [b][green]=> 26.09.2013[/green][/b]
[*] Inbetriebnahme der Produktivanlage (Termin Mitte Oktober 2013) [done]
    [b][green]=> 26-28.09.2013[/green][/b]
[*] Test der Produktivanlage ([b]Termin Mitte Oktober 2013[/b]) [done]
[*] Feierliche Einweihung und Übergabe [postponed]
[/list]

[section]Überwachungs-Server[/section]

[list=I]
[*] SNMP-Server implementieren
[*] SNMP-Client implementieren
[*] Server- und Client-Setup auf IPC und z.B. NAS
[*] Inbetriebnahme und Test auf der Produktivanlage ([b]Termin Mitte Dezember 2013[/b])
[/list]

[section]Überwachungs-Webseite[/section]

[list=I]
[*] Entwurf der Datenbankstruktur [done]
[*] Implementierung und Test der Datenbankanbindung [done]
[*] Implementierung einer analogen, runden Thermosstatanzeige [done]
[*] Implementierung einer analogen, linearen Thermosstatanzeige [done]
[*] Implementierung und Test der Schnittstelle zur Ermittlung der Daten auf den Controller-Karten [done]
[*] [b]Entwicklung einer vorrübergehenden Überwachungsfunktion mit Textausgaben des Generators und des Snapshot-Makers.[/b] [done]
[*] Implementierung und Test der AJAX Schnittstelle zwischen Browser und Web-Server auf dem IPC [done]
[*] Implementierung des Skriptes zur Datenerfassung von den Controller-Karten und zum Schreiben derselben in die Datenbank [done]
[*] Erforschen einer Bibliothek zum Erzeugen von Statistikgrafiken
[*] Implementierung des Skriptes zum Auslesen der Daten aus der Datenbank und dem Vorsortieren und Kummulieren in ein Datengerüst, aus dem eine Grafik erzeugt wird
[*] Implementierung des Rahmens und der Steuerung der Web-Anwendung
[*] Inbetriebnahme der Web-Applikation ([b]Termin t.b.d.[/b], könnte 2014 werden)
[*] Feierliche Einweihung und Übergabe
[/list]

[chapter]Schriftwechsel mit Mr. Denkov[/chapter]

[section]Schriftwechsel wegen Flash Lebensdauer[/section]

[blue][06.09.2013][/blue] Aus dem Kurzurlaub zurück. Bis heute gibt es zwischen dem Hersteller der Controller-Karten und mir folgennden Schriftverkehr zur Haltbarkeit des Flash-Speichers.

[blue][12.09.2013][/blue] Das ist also das Aus für die einfache Art die Heizungssteuerung zu programmieren.

[code=ini]
[11.09.2013 Thomas Heptner]

Hello Mr. Denkov.

Thank you very much that you had a look on my problem. I would be very happy if
my suggestion could be realized in the future.

Best regards.

Thomas Heptner.

[11.09.2013 Borislav Denkov]

Hello,

Unfortunately we are not able to change the firmware right now. We will take in
mind your request in the future firmware release and if possible will implement
such option.

Best regards!
Borislav Denkov

[10.09.2013 Thomas Heptner]

Dear Mr. Denkov,

last mail I sent a link to a page that worked only under Google Chrome. Now I
repaired this bug and the demo page should work on other browsers too. I am
sorry for that. Please have a quick view on my demo to explain more, why I need
the thresholds be written only to RAM. http://test.heptner.net/

Best regards,
Thomas Heptner.

[06.09.2013 Thomas Heptner]

Dear Mr. Denkov,

here is a link to a demo of the meter display element of the new
web application of the heating system: http://test.heptner.net/

Please feel free to ask if you have any questions.

Best regards,
Thomas Heptner.

[04.09.2013 Thomas Heptner]

Hello.

Let me try to explain: Your controllers will be used for a heating
control system which gets its data from a calendar system. For each
event in a specified room the heating is switched on with an additional
trailing time ahead and switched off afterwards. Because we have cold
winters and the rooms are used not so often, we need to hold a mold
and freezing protection temperature. Both target temperatures will need
a high and low threshold. Therefore I will have to send this data
continuesly from the controlling indudsty pc to the controller cards.

You would very much help by implementing this feature.
Yours Thomas.

[04.09.2013 Borislav Denkov]

Hello,

Why do you want to save the thresholds only in RAM ? This means each time
when you reset the controller you will have to enter the values again ???

Once you set the settings they are saved in the FLASH and that's it. You
don't have to change them constantly.

Every IP controller today saves its settings in EEPROM or FLASH memory so
they are loaded on boot.

Best regards!
Borislav Denkov

[03.09.2013 Thomas Heptner]

If it's not possible please accept 100 euros by PayPal to implement it. I
can't give more because I write the hole system for the congregation for
free.

[03.09.2013 Thomas Heptner]

And the hresholds?

[03.09.2013 Borislav Denkov]

Hello,

The user can select where to be written the I/O states - in the flash and
RAM OR only in the RAM.

Best regards!
Borislav Denkov

[02.09.2013 Thomas Heptner]

Hello.

Thank you very much for the info.

Is there any possibility to not write the i/o states to flash. Instead
write them only in RAM? Then there wouldn't be any limitations of
writing cycles. In addition to that it would be very helpful to do the
same with the thresholds.

The reason for my question is that the heating system was planned to be
controlled by your controller cards. And the limitation of writing
cycles would limit the lifetime of the hole system to few heating periods.

The system heats all the different rooms by reading calendar data from a
group calendar server the congregation uses. The function of persistency
is not used in our case.

Please help.
Yours Thomas.

[01.09.2013 Borislav Denkov]

Hello,

All settings but I/O states are saved in internal FLASH and they give it
minimum 10000 rewreites.

Save I/O states are in external FLASH and they give it 100000 rewrites.

Best regards!
Borislav Denkov

[29.08.2013 Thomas Heptner]

Hi,

ok, you are right. When I sent a change on Low/High Analog Trap Threshold
over Network SNMP to the controller. The controller stores this data. How
often can I sent this changes till the controllers memory gets "tired".

Best regards,
Thomas Heptner.

[29.08.2013 Borislav Denkov]

Hi,

You can not write data like 1.3.6.1.4.1.19865.1.1.122.*.0 to the memory.
This is trap message and it is not written anywhere. It is sent by the
controller over the network!

Best regards!
Borislav Denkov

[28.08.2013 Thomas Heptner]

Hello Mr. Denkov,

I meen: How often can I write to the memory and change data like
1.3.6.1.4.1.19865.1.1.122.*.0 until the memory is "tired" and does not
function any more?

Best regards,
Thomas Heptner

[28.08.2013 Borislav Denkov]

Hello Mr. Heptner,

1. What do you mean under trap states ? Can you explain ? Maybe you
   mean trap messages ?
2. The trap messages are not written but they are sent by the module.

Best regards!
Borislav Denkov

[28.08.2013 Thomas Heptner]

Hello Mr. Denkov,

I have two questions regarding SNMP 8 Relay Module for Temperature
Measurement LM35DZ.

1. How long will the module hold the trap states after power off?

2. How often is it possible to write new trap data to the modules memory
   until the memory will be "tired"?

Best regards and thank you in advance,
Thomas Heptner.
[/code]

[section]Schriftwechsel wegen Flattern auf Signalleitungen[/section]

[blue][26.09.2013][/blue] Bei der Installation und Inbetriebnahme der Anlage bekommen wir Herzflattern. Das Signal vom ersten Themperaturfühler schwankt ohne Ende um bis zu 5 Grad C um einen eventuell korrekten Wert. Wir können so mit der ganzen bisherigen Arbeit nichts anfangen und ich eröffne also den folgenden Schriftwechsel.

[blue][28.09.2013][/blue] Nun haben wir schon genug Informationen, dass wir das Auflöten der empfohlenen Kondensatoren auf den Karten wagen. Das Ergebnis haut Hans-Peter vom Stuhl. Meine Emotionen sind gebremst, weil ich zuerst meinen Augen nicht traue. Nach einem Einmeessen des Fühlers im 30er-Raum sind wir uns sicher, dass wir die Anweisungen von Herrn Denkov richtig umgesetzt haben. Die Werte sind so genau und das Signal so gleichbleibend ruhig, dass wir aufatmen können. Herrn Denkov sei gedankt, tue ich natürlich auch sofort im Anschluss.

[code=ini]
[28.09.2013 Thomas Heptner]

Dear Mr. Denkov,

we wish a peacful and relaxing weekend and want to say thank you very
much for your great help. Here is a picture of one of our boards. I
made it with the second one in the same way. After this, the temperature
sensors were very silent only sending the right temperature!!! Great.

All the best,
Yours Thomas Heptner.

[28.09.2013 Borislav Denkov]

Hi,

Unfortunately there is not a way to install it otside the board. We have
tested and the only solution is that one i sent you.

Hope that helped.

Best regards!
Borislav Denkov

[27.09.2013 Thomas Heptner]

Hi,

thanks a lot for this help. Is it possible to do the modification outside
the board. I have created a breakout board. Can I connect it somewhere
there? Please see the two attached picures.

Yours Thomas.

[27.09.2013 Borislav Denkov]

Hi,

We have made some tests here. We could reproduce the sutiation with 30m
flat cable. It really jumps with several degrees on a such distance.

The only solution we have managed to find is to add an external capacitor
100nF to the PCB. We know this is not so proffesional but that helps.

I am sending you picture of the modified PCB. Here we have attached
capacitor for the first input, but you can make it for the rest inputs.

Hope that helped.

Best regards!
Borislav Denkov

[26.09.2013 Thomas Heptner]

max 30m my collegue told me now.

[26.09.2013 Borislav Denkov]

Hello,

How far are the sensors from the relay board ?

Best regards!
Borislav Denkov

[26.09.2013 Thomas Heptner]

Dear Mr. Denkov,

we are in the process of installing and setting up the hardware for
the heating system. We have a serios problem with the temperature
sensors. When the sensors are far away from the station the temperature
skips between 3 to 5 degrees +/-. We use telephone wires, none screened.

Please help, what to do with this problem.
Yours Thomas.
[/code]

[section]Schriftwechsel wegen Messen von Minusgraden[/section]

[blue][10.11.2013][/blue] Wir haben nun einen Messfühler für aussen am Haus angebracht. Dieser Fühler kann aber nur 1-100 C messen. Jetzt frage ich nach einer Lösung für unser Problem.</p>

[code=ini]
[10.11.2013 Thomas Heptner]

hello mr. denkov,

now we need again a bit help. we installed a outside temperature
sensor and soon there will be minus degrees.could you help to solve
this problem? i understood that the sensors are giving 0-1V for
0-100 degrees celsius. what could we change to mesure for example
-40 to +60 degrees?

Best regards,

Thomas Heptner.

[13.11.2013 Borislav Denkov]

Hello,
The current boards are optimized to work with LM35DZ (0-100 degrees
celsius).

If you want to use another sensors (for minus degrees, you could use
the 0-10VDC analog inputs) and then make another calibration.

For example you can use LM335 or MCP1900...

We are considering to make another hardware modification of these
boards so they can work for minus degrees but we are still working
on this...

Best regards!
Borislav Denkov

[13.11.2013 Thomas Heptner]

Hello Mr. Denkov.

Great. Thank you. We will try your suggestion and in addition are
waiting your new hardware version.

Yours Thomas Heptner.
[/code]

[chapter]Projekt Dokumentation (Links)[/chapter]

[section]Unsere neue Hardware[/section]

[url=http://www.denkovi.com/product/57/daenetip2-eight-relay-module-lm35-.html]Denkovi Controller Board[/url]
[url=http://www.tvsgmbh.de/html/kontakte.html]Das graue Kästchen[/url]

[section]AJAX Web 2.0[/section]

[url=http://www.html-world.de/program/ajax_8.php]HTML World über SAJAX[/url]
[url=http://www.modernmethod.com/sajax/]SAJAX Simple Ajax Toolkit[/url]
[url=http://www.ajaxtoolbox.com/]AJAX Toolbox[/url]

[section]Statistische Grafiken[/section]

[url=http://www.pchart.net/]pChart Chart Framework[/url]
[url=http://www.chartjs.org/]Chart.js Easy client side graphs[/url]
[url=http://www.rgraph.net/]RGraph HTML5 and JavaScript charts[/url]
[url=http://canvasxpress.org/]canvasXpress[/url]

[section]Grafiken mit canvas[/section]

[url=http://canvas.quaese.de/]Canvas[/url]

[section]Anzeigeelemente[/section]

[url=http://www.3quarks.com/de/]Uhren für Webseiten[/url]
[url=http://www.3quarks.com/de/SVGUhr/index.html]SVG Uhr[/url]
[url=http://www.3quarks.com/de/Bahnhofsuhr/index.html]JavaScript Uhr[/url]

[section]BB-Code[/section]

[url=http://www.bbcode.org/implementations.php]BBCode Referenz[/url]
[url=http://freecode.com/projects/bbcode]BB-Code Projekt bei FreeCode[/url]
[url=http://christian-seiler.de/projekte/php/bbcode/]BB-Code Projektseite[/url]
[url=http://www.phpclasses.org/package/7923-PHP-Parse-and-replace-Markdown-and-BBCode-by-HTML.html]PHP Parse and replace Markdown and BBCode by HTML[/url]
[url=http://www.jsclasses.org/package/216-JavaScript-Format-text-in-a-textarea-with-BBCode-tags.html]JavaScript Format text in a textarea with BBCode tags[/url]
[url=http://bbcparser.recgr.com/index.php]RECRUITING PARSER - the best free bbcode parser, with extras[/url]

[section]Bibliotheken[/section]

[url=http://www.icontem.com/']IconTem[/url] "theptner" mit gmail anmelden
[url=http://www.phpclasses.org/']Collection of free PHP Classes[/url] "theptner" mit gmail anmelden
[url=http://www.jsclasses.org/']Collection of free JavaScript Classes[/url] "theptner" mit gmail anmelden
[url=https://accounts.icontem.com/']Accounts on IconTem[/url] "theptner" mit gmail anmelden
[url=http://www.hotscripts.com/category/scripts/php/scripts-programs/miscellaneous/]Hot Scripts (Verschiedenes)[/url]

[section]Tolle Ausnahmen!!![/section]

[url=http://www.hotscripts.com/listing/phpequations/]phpEquations PHP class solving mathematical equations[/url]
[url=http://naveedurrehman.com/demo/phpequations/?page=demo#output]phpEquations PHP class solving mathematical equations (Homepage)[/url]

[section]WebServer Konfiguration[/section]

[url=http://www.opencodez.com/apache/ssl-certificate-and-install-in-xampp.htm]How to create a SSL Certificate[/url]
