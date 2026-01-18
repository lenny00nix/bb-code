[title]Protokoll der Entstehung der Version 2.0[/title]

[chapter]Phase Analyse und Voruntersuchungen[/chapter]

[section]Inbetriebnahme &amp; Konfiguration der Karten[/section]

[blue][22.06.2013][/blue] Löten eines Y-Kabels für die Stromversorgung, Inbetriebnahme und Konfiguration der neuen Schnittstellenkarten.

[image src=history/20130622a.jpg tn=history/20130622a-tn.jpg] [image src=history/20130622b.jpg tn=history/20130622b-tn.jpg] [image src=history/20130622c.jpg tn=history/20130622c-tn.jpg] [image src=history/20130622d.jpg tn=history/20130622d-tn.jpg] [image src=history/20130622e.jpg tn=history/20130622e-tn.jpg] [image src=history/20130622f.jpg tn=history/20130622f-tn.jpg]

[section]Austesten von Flachbandkabel und Traps[/section]

[blue][26.06.2013][/blue] Einen Thermofühler im Abeitszimmer (P6.1) und einen im Heizungsraum (P6.2) angeschlossen. Berührung des Flachbandkabels gibt einen Ausschlag. Ausprobieren der Traps.

[section]Herstellen der 1. Breakoutplatine[/section]

[blue][28.06.2013][/blue] Herstellen einer Breakoutplatine für die Thermofühler (JP1). Bei dem Neuanschluss ging dann ein Fühler kaputt (Rest 12+1, bei jeder Platine war ein geschenkter Fühler dabei. Der aktuell verbleibende Fühler ist im Heizungsraum montiert.

[image src=history/20130628a.jpg tn=history/20130628a-tn.jpg] [image src=history/20130628b.jpg tn=history/20130628b-tn.jpg] [image src=history/20130628c.jpg tn=history/20130628c-tn.jpg] [image src=history/20130628d.jpg tn=history/20130628d-tn.jpg] [image src=history/20130628e.jpg tn=history/20130628e-tn.jpg]

[section][image src=history/20130629a.jpg tn=history/20130629a-tn.jpg float=right] [image src=history/20130629b.jpg tn=history/20130629b-tn.jpg float=right]Aufbau der Testanlage[/section]

[blue][29.06.2013][/blue] Test des Flachbandkabels und der Breakoutplatine auf Miniausschläge an nicht angeschlossenen Ports. In beiden Fällen kommt es zu Ausschlägen von ca. 9,4 mV, was meines Erachtens zu vernachlässigen ist.

Löten der zweiten Breakoutplatine bis auf die Verkablung des + und - Pols. Aufbau der Entwicklungs- und Testanlage. Testanlage funktioniert um 22:17. Letzte Arbeiten in der nächsten Woche an +/- Verdrahtung auf zweiten Breakoutplatine.

[section]Herstellen der 2. Breakoutplatine[/section]

[blue][03.07.2013][/blue] Zweite Breakoutplatine fertig gestellt.

[section][image src=history/20130714a.jpg tn=history/20130714a-tn.jpg float=right] [image src=history/20130714b.jpg tn=history/20130714b-tn.jpg float=right]Herstellen der Eichplatine[/section]

[blue][14.07.2013][/blue] Misslungene Eichplatine entlötet. Alle Bauteile brauchbar. Neue Eichplatine fertig gestellt. Nächster Schritt Eichgehäuse basteln. Feststellung: P5.5 und P5.7 werden vertauscht angezeigt. Ursache noch nicht gefunden.

[section]HW-Problem auf Denkovi Platinen gelöst[/section]

[blue][15.07.2013][/blue] Suche nach Ursache beginnt. Firmware uptodate 1121? Nachricht an Hersteller ... Hersteller meldet sich und weist auf eine andere Stelle der Dokumentation hin und dort ist es dann auch richtig beschrieben. Kleiner HW Designfehler auf den Relaiskarten, den ich nun auf den beiden Breakoutplatinen und der Eichplatine korrigiert habe. Die Pins sind nicht, wie geplant in einer Reihe von 1 - 8 auf der Schnittstellenbuchse aufgeschaltet; Pin 5 und 7 sind im Layout vertauscht worden. Pech, kann passieren; sollte aber nicht!!!

[section][local=clock.html][image src=history/20130720b-tn.jpg float=right][/local]Untersuchung Canvas Systemuhr[/section]

[blue][20.07.2013][/blue] Ich beginne mit der Entwicklung der darstellenden Instrumenten der Web-Oberfläche. Eine Systemuhr zur Darstellung der Zeit auf dem Industrie-PC habe ich schon gefunden und muss sie nun so anpassen, dass sie die Zeit vom Industrie-PC bekommt und sich immer wieder danach stellt. Danach ist in der gleichen Technologie eine Thermometeranzeige dran, die uns zur Darstellung der Fühler- und Relaiszustände dient. Das stellen der Uhr auf die Systemzeit des Industrie-PC muus ich verschieben.

[section][image src=history/20130724a.jpg tn=history/20130724a-tn.jpg float=right] [image src=history/20130724b.jpg tn=history/20130724b-tn.jpg float=right] Bau & Inbetriebnahme Eichbox[/section]

[blue][24.07.2013][/blue] Heute habe ich aus einem Versandkarton eine Eichbox hergestellt und in Betrieb genommen. Aufgabe ist es, die Temperaturabweichungen zwischen zwei nah beieinander montierten Temperaturfühlern zu minimieren. Zugwind, evtl. Strahlungswärme z.B. durch eine Lampe oder andere Wärmequellen bringen schnell auf wenigen Kubikcentimetern markante Temperaturdifferenzen zustande.

[section][local=meter1.html][image src=history/20130731-tn.jpg float=right][/local]Programmierung Canvas Thermometeranzeige[/section]

[blue][31.07.2013][/blue] Ich habe mit der Entwicklung der Thermoanzeige begonnen und dazu die Uhranimation abgewandelt. Wenn Ihr auf das Bild klickt, könnt Ihr mit der Anzeige etwas herumspielen. Es werden zwei Thermoanzeigen dargestellt. Die beiden kleinen Markierungen ausserhalb des Ziffernblattes zeigen die Abschalt- und Einschalttemperatur an. Das Beispiel "Set 1 Low" zeigt eine Situation, die bei der Schimmelschutzschaltung auftreten kann und die "Set 1 High" eine, die bei der normalen Raumtemperatur auftritt. In "Set 2 Low" ist die Schimmelschutztemperatur und in "Set 2 High" die Normaltemperatur noch nicht erreicht .

[section]Programmierung Übersetzer für OID's[/section]

[blue][02.08.2013][/blue] Nun wird es schwieriger das Entwickelte so einfach zu demonstrieren, aber ich versuche es dennoch. Aufgabe ist eigentlich die Aufzeichnung der Temperaturdaten aus den Karten auszulesen und in eine Datenbank zu schreiben. Das soll in der Sprache Perl implementiert werden, da diese Skriptsprache sich für diese Aufgabe zunächst einmal recht gut eignet. Erste Aufgabe ist also die Daten aus den Karten zu lesen. Dazu habe ich heute eine Übersetzungsroutine entwickelt, die aus lesbaren Namen für Register in der Karte die SNMP Adressen erzeugt, also z.B. aus pctrlP5 PIN 1 (hier ist der Schaltzustand des ersten Relais auf der Karte gespreichert) diese SNMP Adresse: 1.3.6.1.4.1.19865.1.2.2.1.0 Die nächste Aufgabe ist dann mit Hilfe dieser Adressem die tatsächlichen Werte auszulesen. Danach ist dann die Erzeugung der Datenbank und das Befüllen der selben mit den gelesenen Daten dran. Sicherlich ist es nicht möglich und sinnvoll den gesamten Programmcode, der entsteht, hier aufzulisten, aber der erste macht sich doch recht schick hier, oder?

[code]
sub name2oid {
   my $name = shift;
   my $pin  = shift || 0;
   my $oid;

   my $prefix = '1.3.6.1.4.1';
   my %oids = (
      cfgTemp => '{$prefix}.19865.1.1.127.0',            # ADC val. int. temp. sens. (ro)
      pctrlP3 => '{$prefix}.19865.1.2.1.{$pin}.0',       # PortP3PinCTRL digital (rw)
      pctrlP5 => '{$prefix}.19865.1.2.2.{$pin}.0',       # PortP5PinCTRL digital (rw)
      pctrlP6 => '{$prefix}.19865.1.2.3.{$pin}.0',       # PortP6PinCTRL analog  (ro)
      aev     => '{$prefix}.19865.1.1.121.{$pin}.0',     # Analog-to-P5 Events   (rw)
      atrLow  => '{$prefix}.19865.1.1.122.{$pin*2-1}.0', # Analog Trap Thresh., low  (rw)
      atrHigh => '{$prefix}.19865.1.1.122.{$pin*2}.0'    # Analog Trap Thresh., high (rw)
   );

   ($oid = $oids{$name}) =~ s/{([^}]*)}/eval($&)/eg;

   return $oid;
}
[/code]

[section]Untersuchung Perl Net::SNMPTrapd Server[/section]

[blue][03.08.2013][/blue] Heute habe ich eigentlich sehr schnell einen Server für die von den Karten gesendeten Trap Event Nachrichten bauen können. Das unten aufgelistete Programm habe ich im Internet gefunden. Nun ist aber die Frage, was ich mit den Werten anfangen kann. Ist der High-Wert über- oder der Low-Wert unterschritten, dann schicken die Karten alle die aktuellen ADC Messwerte einmal in der Sekunde. Das sind einfach zu viele Daten.

[code]
#! /usr/bin/perl

use strict;
use warnings;
use Net::SNMPTrapd;

my $snmptrapd = Net::SNMPTrapd->new()
  or die "Error creating SNMPTrapd listener: ", Net::SNMPTrapd->error;

while (1) {
   my $trap = $snmptrapd->get_trap();

   if (!defined($trap)) {
      printf "$0: %s\n", Net::SNMPTrapd->error;
      exit 1
   } elsif ($trap == 0) {
      next
   }

   if (!defined($trap->process_trap())) {
      printf "$0: %s\n", Net::SNMPTrapd->error
   } else {
      printf "%s\t%i\t%i\t%s\n",
             $trap->remoteaddr,
             $trap->remoteport,
             $trap->version,
             $trap->community;

      my $str = "";
      for my $vals (@{$trap->varbinds}) {
         for (keys(%{$vals})) {
            $str .= sprintf "%s: %s; ", $_, $vals->{$_}
         }
      }
      print "$str\n";
   }
}
[/code]

[section]Untersuchung Perl Net::SNMP Schnittstelle[/section]

[blue][04.08.2013][/blue] Heute habe ich die SNMP-Schnittstelle zwischen einem Perl-Skript und den Karten etwas näher erforscht, da ich zu dem Schluß gekommen bin, daß es keinen Sinn macht die Trap-Event-Nachrichten zum Loggen zu benutzen. Der Grund liegt darin, dass die Informationen, die über diesen Kanal kommen (z.B. beim ACC Event = Ausschalten, wenn High über- und ein, wenn Low unterschritten wird), nur gesendet werden, wenn der Wert ausserhalb der beiden Grenzwerte liegt. Die Temperaturen innerhalb der Grenzwerte sind dann nicht verfügbar.

Das ist der Grund für die Studien an der SNMP-Schnittstelle und dem Pollen der Karten nach ihren aktuellen Werten. Ergebnis ist ein kleines Perl-Skript, das folgende Ausgaben macht und damit alle 10 Sekunden alle aktuellen Werte der beiden Karten ausgibt. Sollten Werte nicht ermittelt werden können, dann wird statt der Werte ein "X" angezeigt und eine Fehlermeldung hinter das Ende der Tabelle geschrieben. Sollte die Verbindung länger nicht verfügbar sein und später wieder hergestellt werden können, so ist eine Wiederaufnahme möglich.

[code]
======================================================================
 Iffeldorf 1 | Module 1 |  26.3°C |  On |     Acc |  26.7°C |  27.9°C
 Iffeldorf 1 | Module 2 |  26.7°C |  On |     Acc |  26.7°C |  27.9°C
 Iffeldorf 1 | Module 3 |  28.5°C | Off |     Acc |  26.7°C |  27.9°C
 Iffeldorf 1 | Module 4 |  27.7°C | Off |     Acc |  26.7°C |  27.9°C
 Iffeldorf 1 | Module 5 |  26.1°C |  On |     Acc |  26.7°C |  27.9°C
 Iffeldorf 1 | Module 6 |  27.7°C | Off |     Acc |  26.7°C |  27.9°C
 Iffeldorf 1 | Module 7 |  26.7°C |  On |     Acc |  26.7°C |  27.9°C
 Iffeldorf 1 | Module 8 |  26.3°C |  On |     Acc |  26.7°C |  27.9°C
======================================================================
 Iffeldorf 2 | Module 1 |  26.7°C | Off |     Acc |  26.7°C |  27.9°C
 Iffeldorf 2 | Module 2 |  26.7°C |  On |     Acc |  26.7°C |  27.9°C
 Iffeldorf 2 | Module 3 |  28.5°C | Off |    None |     --- |     ---
 Iffeldorf 2 | Module 4 |  26.1°C | Off |    None |     --- |     ---
 Iffeldorf 2 | Module 5 |   0.0°C | Off |    None |     --- |     ---
 Iffeldorf 2 | Module 6 |   0.0°C | Off |    None |     --- |     ---
 Iffeldorf 2 | Module 7 |   0.0°C | Off |    None |     --- |     ---
 Iffeldorf 2 | Module 8 |   0.0°C | Off |    None |     --- |     ---
======================================================================
[/code]

[chapter]Phase Architektur und Design[/chapter]

[section][image src=history/20130805b.jpg tn=history/20130805b-tn.jpg float=right] Durchsprache Architektur[/section]

[blue][05.08.2013][/blue] Nun scheint es, dass ich eine angemessene Architektur und ein ansprechendes Design gefunden habe, das auch noch dem Anforderungsprofil an die Heizungssteuerung Version 2 zu entsprechen scheint. Jetzt geht's mit Volldampf an die Realisierung. Zwei Fragen an Hernn Denkovi bleiben aber noch bevor es los geht.

[list=o]
[*] Wie lange hält der Speicherzustand der Traps bei einem Stromausfall?
[*] Wie oft kann man den Speicher beschreiben, bis er aufgibt?
[/list]

Hans-Peter hat sehr geduldig zugehöhrt und durch gut gestellte Fragen und die Erläuterung der Kundenanforderungen wesentlich zum Erfolg beigetragen.
[section]Datenbanktabelle und -anbindung[/section]

[blue][06.08.2013][/blue] Heute habe ich eine Datenbanktabelle angelegt, mit der ich einen Grundstein lege für das Loggen der ACC Module auf den Karten. Mal sehen ob es sich bewährt.

[code]
-- Database: `iffeldorf`
-- Structure for Table: `accLogs`

CREATE TABLE IF NOT EXISTS `accLogs` (
  `jMinute`   int(11) NOT NULL,
  `ageOfData` int(11) NOT NULL,
  `address`   int(3)  NOT NULL,
  `relay`     int(1)  NOT NULL,
  `actual`    float   NOT NULL,
  `target`    float   NOT NULL,
  `atrLow`    float   NOT NULL,
  `atrHigh`   float   NOT NULL,
  KEY `jMinute` (`jMinute`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_german2_ci;
[/code]

Folgendes kleine Testprogramm konnte erfolgreich zur Datenbank verbinden einen Datensatz schreiben und alle vorhandenen Datensätze auslesen.

[code]
#! /usr/bin/perl

use strict;
use warnings;
use Net::MySQL;

my $mysql = Net::MySQL->new(
   hostname => 'localhost',
   database => 'iffeldorf',
   user     => 'root',
   password => '****'
);

$mysql->query(q{
   INSERT INTO `accLogs` (
      `jMinute`, `ageOfData`, `address`, `relay`,
      `actual`, `target`, `atrLow`, `atrHigh`
   ) VALUES (
      '3827234', '0', '7', '0',
      '21.7', '21.2', '19.2', '21.2'
   );
});
printf "Affected row: %d\n", $mysql->get_affected_rows_length;

mysql->query(q{SELECT * FROM accLogs});
my $record_set = $mysql->create_record_iterator;
while (my $record = $record_set->each) {
   foreach my $field (@{$record}) {
      printf " " . $field;
   }
   print "\n";
}
$mysql->close;
[/code]

Ausgabe in der Kommandozeile:

[code]
Affected row: 1
 2384921 0 9 1 19.7 20.2 19.2 21.2
 2132434 0 7 0 21.7 20.2 19.2 21.2
 3827234 0 7 0 21.7 20.2 19.2 21.2
[/code]

[section]Entwurf Initialisierungsdatei[/section]

[blue][07.08.2013][/blue] Zur Entwicklung der einzelnen Komponenten bedarf es einer übergreifenden Konfigurationsdatei, in der alle Einstellungen vorgenommen werden können, die sich im Laufe der Zeit ändern könnten, bzw. zwischen Test- und Produktivbetrieb unterschiedlich sind. Hier ein erster Wurf. Mal sehen ob er den Anforderungen auf Zeit Stand halten kann ;-)

[code]
; Configuration for Iffeldorf Version 2

[General]
debug     = "Off"

; --- cKalender ---
;            orgId   password                           noOfDays preview
;             |       |                                  |
cKalender = ("4980", "********************************", 7)

; --- atrRange ---
;            atrLow difference to target value
;             | atrHigh difference to target value
;             |  |
atrRange  = (-1, 1)

; --- database ---
;            host         database     user    password
;             |            |            |       |
database  = ("localhost", "iffeldorf", "root", "****")


[Controller]
;                 Controller IP-Adr       Community String
;                  |                & Port |        Alias Name
;                  |                   |   |         |
Iffeldorf1     = ("192.168.178.222", 161, "******", "Iffeldorf 1")
Iffeldorf2     = ("192.168.178.223", 161, "******", "Iffeldorf 2")

[Module]
;                Controller                                Forerun Minutes
;                 |          Module                         |   Trailing Minutes
;                 |           |  Correction (ADC-Value)     |    |  Mold Protection
;                 |           |   |   Alias Name            |    |   |  Room Temperature
;                 |           |   |    |                    |    |   |   |
Pfarrsaal_West = (Iffeldorf1, 1,  0,  "Pfarrsaal West",  -180, -60, 14, 20.5)
Pfarrsaal_Ost  = (Iffeldorf1, 2,  0,  "Pfarrsaal Ost",   -180, -60, 14, 20.5)
Foyer_WCEG     = (Iffeldorf1, 3,  0,  "Foyer u. WC EG",  -120, -60, 14, 20.5)
Kueche         = (Iffeldorf1, 4,  0,  "Kueche",           -60, -60, 14, 20.5)
30er_Raum      = (Iffeldorf1, 5,  0,  "30er Raum",        -60, -60, 14, 20.5)
40er_Raum      = (Iffeldorf1, 6,  0,  "40er Raum",       -120, -60, 14, 20.5)
60er_Raum      = (Iffeldorf1, 7,  0,  "60er Raum",       -180, -60, 14, 20.5)
Gruppenraum    = (Iffeldorf1, 8,  0,  "Gruppenraum",     -120, -60, 14, 20.5)
Jugendtreff    = (Iffeldorf2, 1,  0,  "Jugendtreff",     -120, -60, 14, 20.5)
WC_Keller      = (Iffeldorf2, 2,  0,  "WC Keller",        -60, -60, 14, 20.5)

[Group]
;                Modules
;                 |   ...
Pfarrsaal      = (Pfarrsaal_West, Pfarrsaal_Ost, Foyer_WCEG, WC_Keller)
[/code]

[section][local=meter2.html][image src=history/20130812-tn.jpg float=right][/local]Weitere Programmierung Thermometeranzeige[/section]

[blue][12.08.2013][/blue] Nachdem die "Blackbox" in Iffeldorf derzeit wegen Blitzschlags nicht erreichbar ist, setze ich die Entwicklung an der Thermometeranzeige fort. Dort habe ich nun die Anzeige der Solltemperatur und der Relaisstellung eingebaut. Bitte einfach mal ansehen und dann Eure Meinung dazu abgeben. [local=meter2.html]Hier geht's zu den neuen Anzeigen.[/local]

[section]Erster Entwurf der Spezifikation[/section]

[blue][13.08.2013][/blue] Heute beginne ich mit dem Schreiben der [local=started.bb]Spezifikation[/local] um nichts von dem zu vergessen, was zwischen Hans-Peter und mir besprochen wurde.

[section]Auslesen der Initialisierungsdatei[/section]

[blue][14.08.2013][/blue] Nun kann ich die Konfigurationsdatei erfolgreich auslesen. Ich habe überlegt, aber ein Auslesen der Datei in .php wird nicht notwendig sein. Die Konfigurationsdaten müssen im System durchgängig vorhanden sein. So schlage ich vor, dass der Collector oder der Commander eine evtl. neue Konfiguration aus der Konfigurationsdatei Datei liesst und anschliessend in die json Datei schreibt. Damit ist die Konfigurations sofort und zeitgleich zu den gewonnenen Daten verfügbar. Hier in dem folgenden Skript wird die json Struktur erst einmal testweise auf dem Bildschirm ausgegeben.

[code]
package tlib::tini;

require Exporter;
@ISA = (Exporter);
@EXPORT = qw(parse_ini_file);

use strict;

# Lesen einer Zeichenkette als CSV in ein Array
sub parse_csv_string {
   # Felder bei ',' trennen und ',' innerhalb von '""' zulassen
   my @fields = split /,(?=(?:[^\"]*\"[^\"]*[\"^,]*\")*(?![^\"]*\"))/, shift;
   foreach (@fields) {
      # Zahl erkennen und extrahieren
      if (/^\s*(-?[0-9]*\.?[0-9]+)\s*$/) {
         $_ = $1;
      # Bezeichner erkennen und extrahieren
      } elsif (/^\s*([a-z0-9A-Z.\-_]+)\s*$/) {
         $_ = $1;
      # Zeichenkette erkennen und extrahieren
      } elsif (/^\s*"([a-z0-9A-Z.,'\-_ ]+)"\s*$/) {
         $_ = $1;
      } else {
         die 'syntax error in config file';
      }
   }
   return \@fields;
}

# Einlesen einer Initialisierungsdatei in einen Hash
sub parse_ini_file {
   my $filename = shift;
   my %hash = ();
   my ($section, $keyword, $value);

   # Ist zu Anfang keine Sektion angegeben, nehme 'General' an
   $section = "General";

   # Datei öffnen
   open (INI, "$filename") || die "Can't open $filename: $!\n";

   # Datei zeilenweise einlesen
   while (<INI>) {
      chomp;
      # Leerzeilen ignorieren
      if (/^\s*(;.*)?$/) {
         next;
      }
      # Neue Sektion erkennen und setzen
      if (/^\s*\[([a-z0-9A-Z\-_]+)\].*/) {
         $section = $1;
         next;
      }

      # Wert als Zahl erkennen - Schluessel und Wert extrahieren
      if (/^\W*(\w+)\W*=\s*(-?[0-9]*\.?[0-9]+)\s*(;.*)?$/) {
         $keyword = $1;
         $value = $2;
      # Wert als Bezeichner erkennen - Schluessel und Wert extrahieren
      } elsif (/^\W*(\w+)\W*=\s*([a-z0-9A-Z.\-_]+)\s*(;.*)?$/) {
         $keyword = $1;
         $value = $2;
      # Wert als Zeichenkette erkennen - Schluessel und Wert extrahieren
      } elsif (/^\W*(\w+)\W*=\s*"([a-z0-9A-Z.,\-_ ]+)"\s*(;.*)?$/) {
         $keyword = $1;
         $value = $2;
      # Wert als CSV erkennen - Schluessel und Wert extrahieren
      } elsif (/^\W*(\w+)\W*=\s*\(\s*([a-z0-9A-Z.,"'\-_ ]+)\s*\)\s*(;.*)?$/) {
         $keyword = $1;
         $value = parse_csv_string($2);
      } else {
         die 'syntax error in config file ' . $filename;
      }

      if (defined $hash{$section}{$keyword}) {
         die 'double defined section/keyword pair in config file ' . $filename;
      }
      $hash{$section}{$keyword} = $value;
   }
   # Datei schliessen
   close (INI);

   return %hash;
}

1;
[/code]

Der Aufruf der Funktion ist sehr einfach:

[code]
#! /usr/bin/perl

use strict;
use warnings;
use JSON;
use tlib::tini;

my %ini = parse_ini_file("configuration.ini");

print to_json( \%ini, { latin1 => 1, pretty => 1 } );
[/code]

Das Skript erzeugt folgende Ausgabe:

[code]
{
   "Controller" : {
      "Iffeldorf2" : [
         "192.168.178.223",
         "161",
         "******",
         "Iffeldorf 2"
      ],
      "Iffeldorf1" : [
         "192.168.178.222",
         "161",
         "******",
         "Iffeldorf 1"
      ]
   },
   "Module" : {
      "Gruppenraum" : [
         "Iffeldorf1",
         "8",
         "0",
         "Gruppenraum",
         "-120",
         "-60",
         "14",
         "20.5"
      ],
      "Pfarrsaal_Ost" : [
         "Iffeldorf1",
         "2",
         "0",
         "Pfarrsaal Ost",
         "-180",
         "-60",
         "14",
         "20.5"
      ],
      "40_erRaum" : [
         "Iffeldorf1",
         "6",
         "0",
         "40er Raum",
         "-120",
         "-60",
         "14",
         "20.5"
      ],
      "Foyer_WCEG" : [
         "Iffeldorf1",
         "3",
         "0",
         "Foyer u. WC EG",
         "-120",
         "-60",
         "14",
         "20.5"
      ],
      "Pfarrsaal_West" : [
         "Iffeldorf1",
         "1",
         "0",
         "Pfarrsaal West",
         "-180",
         "-60",
         "14",
         "20.5"
      ],
      "Jugendtreff" : [
         "Iffeldorf2",
         "1",
         "0",
         "Jugendtreff",
         "-120",
         "-60",
         "14",
         "20.5"
      ],
      "Kueche" : [
         "Iffeldorf1",
         "4",
         "0",
         "Kueche",
         "-60",
         "-60",
         "14",
         "20.5"
      ],
      "WC_Keller" : [
         "Iffeldorf2",
         "2",
         "0",
         "WC Keller",
         "-60",
         "-60",
         "14",
         "20.5"
      ],
      "60_erRaum" : [
         "Iffeldorf1",
         "7",
         "0",
         "60er Raum",
         "-180",
         "-60",
         "14",
         "20.5"
      ],
      "30_erRaum" : [
         "Iffeldorf1",
         "5",
         "0",
         "30er Raum",
         "-60",
         "-60",
         "14",
         "20.5"
      ]
   },
   "General" : {
      "database" : [
         "localhost",
         "iffeldorf",
         "root",
         "****"
      ],
      "cKalender" : [
         "4980",
         "********************************",
         "7"
      ],
      "atrRange" : [
         "-1",
         "1"
      ],
      "debug" : "Off"
   },
   "Group" : {
      "Pfarrsaal" : [
         "Pfarrsaal_West",
         "Pfarrsaal_Ost",
         "Foyer_WCEG",
         "WC_Keller"
      ]
   }
}
[/code]

[section]Arbeit am Initialisierungsskript[/section]

[blue][19.08.2013][/blue] Heute habe ich mit der Programmierung des Initialisierungsskripts begonnen. Die Prüfung der Initialisierungsdatei 'overall.ini' nach lexikalischen und syntaktischen Fehlern. Danach pro Zeile oder Absatz Test der Verbindung zu dem jeweiligen Gerät oder der Datenbank. Der Ablauf in Stichworten:

[b]Lexikalischer und Syntaktischer Test[/b]
[list=I]
[*] Sektion [b][General][/b] vorhanden?
[*] [b]General.debug[/b] Wert prüfen und Debug entsprechend ein- oder ausstellen.
[*] [b]General.atrRange[/b] Anzahl der Argumente testen und sicherstellen, dass der erste Wert kleiner 0 und der zweite Wert größer 0 ist.
[*] [b]General.cKalender[/b] Anzahl der Argumente testen. Danach den Wert des Arguments noOfDays auf den zulässigen Wertebereich 0 - 100 testen.
[*] [b]General.database[/b] Anzahl der Argumente testen.
[*] Sektion [b][Controller][/b] vorhanden?
[*] [b]Controller.*[/b] auf Anzahl der Argumente testen. Danach jeweils Verbung mit den Controllern aufnehmen und die SNMP-Verbindung durch Abfragen der CPU-Templeratur des Controllers testen.
[*] Sektion [b][Module][/b] vorhanden?
[*] [b]Module.*[/b] Prüfen der Plausibilität de Einträge und Auflösen der Verweise auf die Controller.
[*] Sektion [b][Group][/b] vorhanden?
[*] [b]Group.*[/b] Prüfen der Plausibilität der Einträge und Auflösen der Verweise auf die Module.
[/list]

[b]Hardware-Verbindungstests[/b]
[list=I]
[*] [b]Controller[/b] Mit jedem Controller einen Verbindungsversuch unternehmen und die SNMP-Verbindung durch Abfragen der CPU-Templeratur des Controllers testen.
[*] [b]cKalender[/b] Versuchen die XML-Daten von cKalender abzurufen und das Resultat auf Plausibilität prüfen.
[*] [b]Database[/b] Verbindungsaufnahme zur Datenbank.
[/list]

[b]Systeminitialisierung[/b]
[list=I]
[*] Schreiben der Konfiguration in die JSON-Datei overall.conf, die ab dahin jedem Skript des Systems zur Verfügung steht.
[*] [b]Database[/b] Zuerst die Tabelle accLogs anlegen, falls noch nicht geschehen, dann einen Dummydatensatz hinzufügen und danach gleich wieder löschen.
[*] Initialisieren der Linux CRONTAB.
[/list]

[b]Anmerkung:[/b] Heute hat Hans-Peter den IPC vorbei gerbracht. Der wird nach dem Kurzurlaub auf Blitzschäden zu untersuchen sein. Dann werde ich ihn in meine Testanlage einbauen und evtl. ein neues Betriesbsystem aufspielen, sollte sich das, das im Moment drauf ist, nicht aktualisieren lassen, besonders im Bereich der Perl-Installation.

[blue][25.08.2013][/blue] Die Arbeiten am Initialisierungsskript setzte ich heute fort. Jedoch musste ich an der Reihenfolge der Tests noch Änderungen direkt im Eintrag vom 19.08.2013 vornehmen. Die Verbindungstests zur Hardware und zur Datenbank habe ich an den Schluss gesetzt. Nur wenn die Initialisierungsdatei keine lexikalischen und syntaktischen Fehler mehr enthält, dann werden zunächst die Verbindungen zu den Controllerplatinen, dann zum cKalender-Portal und zur Datenbank geprüft. Danach erfolgt die Systeminitialisierung indem die Konfiguration in eine JSON Datei geschrieben, die Tabellen in der Datenbank die angelegt werden und anschliessend die CRONTAB initialisiert wird.

[code]
#!/usr/bin/perl -w
use strict;
use warnings;

use constant HOME => '/var/www/thomas/Iffeldorf/box';
use constant MYSELF => HOME.'/init';
use constant LOGFILE => HOME.'/overall.log';
use constant INIFILE => HOME.'/overall.ini';
use constant CONFFILE => HOME.'/overall.conf';
use constant DEFCRONTAB => HOME.'/crontab.txt';
use constant SEMAPHORE => HOME.'/overall.lock';
use constant NL => "\n";

use Getopt::Long;
use Data::Dumper;
use JSON;
use Net::MySQL;
use Net::SNMP;

use lib HOME;
use tlib::tini;
use tlib::txml;
use tlib::tdate;
use tlib::tlog;
use tlib::tlock;

sub isNum {
   return shift =~ m/^-?[0-9]*\.?[0-9]+$/;
}
sub isInt {
   return shift =~ m/^-?[0-9]+$/;
}

sub isIP {
   return shift =~ m/^[1-9]{1}[0-9]{0,2}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}$/;
}

sub name2oid {
   my $name = shift;
   my $pin  = shift || 0;
   my $oid;

   my $prefix = '1.3.6.1.4.1';
   my %oids = (
      cfgIp   => '{$prefix}.19865.1.1.1.0',              # IP address of controller board(ro)
      cfgTemp => '{$prefix}.19865.1.1.127.0',            # ADC value of internal temperature sensor (ro)
      digital => '{$prefix}.19865.1.2.1.{$pin}.0',       # PortP3PinCTRL digital (rw)
      relay   => '{$prefix}.19865.1.2.2.{$pin}.0',       # PortP5PinCTRL digital (rw)
      sensor  => '{$prefix}.19865.1.2.3.{$pin}.0',       # PortP6PinCTRL analog  (ro)
      aev     => '{$prefix}.19865.1.1.121.{$pin}.0',     # Analog-to-P5 Events   (rw)
      atrLow  => '{$prefix}.19865.1.1.122.{$pin*2-1}.0', # Analog Trap Thresholds, low  (rw)
      atrHigh => '{$prefix}.19865.1.1.122.{$pin*2}.0'    # Analog Trap Thresholds, high (rw)
   );

   ($oid = $oids{$name}) =~ s/{([^}]*)}/eval($&amp;amp;)/eg;

   return $oid;
}



set_lock(SEMAPHORE);

#system('mv '.LOGFILE.' '.LOGFILE.'.1') if (-f LOGFILE);
start_logging(LOGFILE, MYSELF);

my %ini = parse_ini_file(INIFILE);
my %config;

{  # -----==== [General] ====-----
   if (!defined $ini{General}) {
      die 'Section General missing in ' . INIFILE;
   }
}
{  # -----==== General.debug ====-----
   if (!defined $ini{General}{debug}) {
      die 'General.debug missing in ' . INIFILE;
   }
   my $temp = $ini{General}{debug};
   if ($temp ne 'On' &amp;&amp; $temp ne 'Off') {
      die 'General.debug illegal value, better "On" or "Off" in ' . INIFILE;;
   }
   $config{General}{debug} = ($temp eq "On") ? 1 : 0;

   # -----==== Debug Setting ====-----
   $debug_on = $config{General}{debug};

   # -----==== General.atrRange ====-----
   if (!defined $ini{General}{atrRange}) {
      die 'General.atrRange missing in ' . INIFILE;
   }
   my @temp = @{$ini{General}{atrRange}};
   if (scalar(@temp) != 2) {
      die 'General.atrRange incorrect number of arguments, better (low, high) in ' . INIFILE;
   }
   if (!isNum($temp[0]) || !isNum($temp[1]) || $temp[0] <= -5 || $temp[0] >= 0 || $temp[1] <= 0 || $temp[1] >= 5) {
      die 'General.atrRange illegal value, better -5 < low < 0 and +5 > high > 0 in ' . INIFILE;
   }
   $config{General}{atrRange}{low}  = $temp[0] * 1;
   $config{General}{atrRange}{high} = $temp[1] * 1;
}
{  # -----==== General.cKalender ====-----
   if (!defined $ini{General}{cKalender}) {
      die 'General.cKalender missing in ' . INIFILE;
   }
   my @temp = @{$ini{General}{cKalender}};
   if (scalar(@temp) != 3) {
      die 'General.cKalender incorrect number of arguments, better (orgId, orgPw, noOfDays) in ' . INIFILE;
   }
   if (!isNum($temp[2]) || $temp[2] < 0 || $temp[2] > 100) {
      die 'General.cKalender[noOfDays] illegal value, better between 0 and 100';
   }
   $config{General}{cKalender}{orgId}    = $temp[0];
   $config{General}{cKalender}{orgPw}    = $temp[1];
   $config{General}{cKalender}{noOfDays} = $temp[2] * 1;

   # -----==== General.database ====-----
   @temp = @{$ini{General}{database}};
   if (scalar(@temp) != 4) {
      die 'General.database incorrect arguments, better (host, database, user, pw)' . INIFILE;
   }

   $config{General}{database}{hostname} = $temp[0];
   $config{General}{database}{database} = $temp[1];
   $config{General}{database}{user}     = $temp[2];
   $config{General}{database}{password} = $temp[3];
}
{  # -----==== [Controller] ====-----
   if (!defined $ini{Controller}) {
      die 'Section Controller missing in ' . INIFILE;
   }
}
{  # -----==== Controller.* ====-----
   foreach my $controller (keys %{$ini{Controller}}) {
      my @temp = @{$ini{Controller}{$controller}};
      if (scalar(@temp) != 4) {
         die 'Controller.'.$controller.' incorrect number of arguments, better '
            . '(IP, Port, Community, Name) in ' . INIFILE;
      }
      if (!isIP($temp[0])) {
         die 'Controller.'.$controller.'.IP incorrect format in ' . INIFILE;
      }
      if (!isNum($temp[1]) || !isInt($temp[1]) || $temp[1] <= 0) {
         die 'Controller.'.$controller.'.Port incorrect format in ' . INIFILE;
      }
      $config{Controller}{$controller}{ip}        = $temp[0];
      $config{Controller}{$controller}{port}      = $temp[1] * 1;
      $config{Controller}{$controller}{community} = $temp[2];
      $config{Controller}{$controller}{name}      = $temp[3];
   }
}
{  # -----==== [Module] ====-----
   if (!defined $ini{Module}) {
      die 'Section Module missing in ' . INIFILE;
   }
}
{  # -----==== Module.* ====-----
   foreach my $module (keys %{$ini{Module}}) {
      my @temp = @{$ini{Module}{$module}};
      if (scalar(@temp) != 8) {
         die 'Module.'.$module.' incorrect number of arguments, better '
            . '(Contr, Mod, Corr, Name, Forerun &amp; Trail Min, Mold Prot, Room Temp) in ' . INIFILE;
      }
      if (!exists $config{Controller}{$temp[0]}) {
         die 'Module.'.$module.'.Controller does not exist in Controller.* in ' . INIFILE;
      }
      if (!isInt($temp[1]) || $temp[1] < 1 || $temp[1] > 8 ) {
         die 'Module.'.$module.'.Module incorrect module number, better 1 <= module <= 8 in ' . INIFILE;
      }
      if (!isInt($temp[2]) || $temp[2] < -10 || $temp[2] > 10 ) {
         die 'Module.'.$module.'.Correction incorrect correction value, better -10 <= module <= 10 in ' . INIFILE;
      }
      if (!isInt($temp[4]) || $temp[4] < -240 || $temp[4] > -30 ) {
         die 'Module.'.$module.'.ForerunMinutes incorrect value, better -240 <= module <= -30 in ' . INIFILE;
      }
      if (!isInt($temp[5]) || $temp[5] < -60 || $temp[5] > 180 ) {
         die 'Module.'.$module.'.TrailingMinutes incorrect value, better -60 <= module <= 180 in ' . INIFILE;
      }
      if (!isNum($temp[6]) || $temp[6] < 10 || $temp[6] > 18 ) {
         die 'Module.'.$module.'.MoldProtection incorrect value, better 10.0 <= module <= 18.0 in ' . INIFILE;
      }
      if (!isNum($temp[7]) || $temp[7] < 16 || $temp[7] > 24 ) {
         die 'Module.'.$module.'.RoomTemperature incorrect value, better 16.0 <= module <= 24.0 in ' . INIFILE;
      }

      $config{Module}{$module}{controller}      = $temp[0];
      $config{Module}{$module}{module}          = $temp[1] * 1;
      $config{Module}{$module}{correction}      = $temp[2] * 1;
      $config{Module}{$module}{name}            = $temp[3];
      $config{Module}{$module}{forerunMinutes}  = $temp[4] * 1;
      $config{Module}{$module}{trailingMinutes} = $temp[5] * 1;
      $config{Module}{$module}{moldProtection}  = $temp[6] * 1;
      $config{Module}{$module}{roomTemperature} = $temp[7] * 1;
   }
}
{  # -----==== [Group] ====-----
   if (!defined $ini{Group}) {
      die 'Section Group missing in ' . INIFILE;
   }
}
{  # -----==== Group.* ====-----
   foreach my $group (keys %{$ini{Group}}) {
      my @temp = @{$ini{Group}{$group}};
      if (scalar(@temp) <= 1) {
         die 'Group.$group not a group, a group must contain more than one module in ' . INIFILE;
      }
      foreach my $temp (@temp) {
         if (!exists $config{Module}{$temp}) {
            die 'Group.'.$group.'['.$temp.'] does not exist in Modules.* in ' . INIFILE;
         }
         push @{$config{Group}{$group}}, $temp;
      }
   }
}

{  # -----==== Testing Connection to all Controllers ====-----
   foreach my $controller (keys %{$config{Controller}}) {
      my $ip        = $config{Controller}{$controller}{ip};
      my $port      = $config{Controller}{$controller}{port};
      my $community = $config{Controller}{$controller}{community};
      my $name      = $config{Controller}{$controller}{name};

      notice 'Start testing connection to controller "' . $name . '" ...';

      my($session, $error) = Net::SNMP->session(
         -hostname  => $ip,
         -port      => $port,
         -community => $community);
      if (!defined $session) {
         die 'Failed to create session for host "' . $name . '": ' . $error;
      }
      my $oid = name2oid('cfgIp');
      my $result = $session->get_request(-varbindlist => [ $oid ]);
      if (!defined $result) {
         die 'Failed to retrieve ip for host "' . $name . '": ' . $session->error;
      }
      if ($result->{ $oid } ne $ip) {
         die 'IP comparison failed for host "' . $name . '": ' . $session->error;
      }

      notice '... done';
   }
}
{  # -----==== Testing Connection to cKalender ====-----
   my $orgId    = $config{General}{cKalender}{orgId};
   my $orgPw    = $config{General}{cKalender}{orgPw};
   my $noOfDays = $config{General}{cKalender}{noOfDays};

   my $now      = pctime2jd(time+tzdiff());   # today and
   my $end      = $now + $noOfDays;           # no of days preview
   my $fromDate = strfjd('%d.%m.%y', $now);
   my $toDate   = strfjd('%d.%m.%y', $end);

   notice 'Start testing connection to calendar server ...';

   my $xmlLink  = 'http://www.ckalender.de/system/modul_termine_xml.php?'
                . 'OrgID='.$orgId.'&amp;OrgPW='.$orgPw.'&amp;'
                . 'VonDatumD='.$fromDate.'&amp;BisDatumD='.$toDate.'&amp;'
                . 'Planungsstatus=alle&amp;Anzeigestatus=alle&amp;'
                . 'Zyklisch=ja&amp;Gruppen=*';

   my @temp = `wget -O - \'$xmlLink\' 2> /dev/null`
      or die 'Unable to get xml from calendar server';

   my $xmlString = join '', @temp;
   my %xml         = parse_xml_string($xmlString);

   exists $xml{CKTerminResponse}{CKTermin}
      or die 'CKTerminResponse.CKTermin is missing in xml stream';

   notice '... done';
}
{  # -----==== Testing Connection to my Database ====-----
   my $hostname = $config{General}{database}{hostname};
   my $database = $config{General}{database}{database};
   my $user     = $config{General}{database}{user};
   my $password = $config{General}{database}{password};

   notice 'Start testing connection to database server ...';

   my $mysql = Net::MySQL->new(
      hostname => $hostname,
      database => $database,
      user     => $user,
      password => $password
   );
   if ($mysql->is_error) {
      die $mysql->get_error_message;
      $mysql->close;
   }
   $mysql->close;

   notice '... done';
}

{  # -----==== Writing Configuration to config.json ====-----
   notice 'Start writing configuration to JSON file "' . CONFFILE . '" ...';

   my $jsonText = to_json( \%config, { latin1 => 1, pretty => 1 } );
   open FH, '> '.CONFFILE.'.temp'
      or die 'Could not create configuration JSON file '.CONFFILE.'.temp';
   print FH $jsonText;
   close FH;
   system('mv '.CONFFILE.'.temp '.CONFFILE) if (-f CONFFILE.'.temp');

   notice '... done';
}

{  # -----==== Creating Database Table(s) ====-----
   my $hostname = $config{General}{database}{hostname};
   my $database = $config{General}{database}{database};
   my $user     = $config{General}{database}{user};
   my $password = $config{General}{database}{password};

   my $query;
   my $result1;
   my $result2;

   notice 'Start creating database table(s) ...';

   my $mysql = Net::MySQL->new(
      hostname => $hostname,
      database => $database,
      user     => $user,
      password => $password
   );
   if ($mysql->is_error) {
      die $mysql->get_error_message;
      $mysql->close;
   }

   $query = <<EOT;
      CREATE TABLE IF NOT EXISTS `accLogs` (
         `jMinute` int(11) NOT NULL,
         `ageOfData` int(11) NOT NULL,
         `address` int(3) NOT NULL,
         `relay` int(1) NOT NULL,
         `actual` float NOT NULL,
         `target` float NOT NULL,
         `atrLow` float NOT NULL,
         `atrHigh` float NOT NULL,
         KEY `jMinute` (`jMinute`)
      ) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_german2_ci;
EOT
   $mysql->query($query);
   if ($mysql->is_error) {
      die $mysql->get_error_message;
      $mysql->close;
   }

   $query = <<EOT;
      INSERT INTO `accLogs` (
         `jMinute`, `ageOfData`, `address`, `relay`,
         `actual`, `target`, `atrLow`, `atrHigh`
      ) VALUES (
         '999999', '0', '0', '0',
         '0.0', '0.0', '0.0', '0.0'
      );
EOT
   $mysql->query($query);
   if ($mysql->is_error) {
      die $mysql->get_error_message;
      $mysql->close;
   }
   $result1 = $mysql->get_affected_rows_length;

   $query = <<EOT;
      DELETE FROM `accLogs`
         WHERE `jMinute` = '999999';
EOT
   $mysql->query($query);
   if ($mysql->is_error) {
      die $mysql->get_error_message;
      $mysql->close;
   }
   $result2 = $mysql->get_affected_rows_length;
   $mysql->close;

   if ($result1 != 1 || $result2 != 1) {
      die 'Database test failed';
   }

   notice '... done';
}

{  # -----==== Initialize CRONTAB ====-----
   notice 'Start initializing CRONTAB ...';
   # Hier fehlt noch die Implementierung, kann aber aus v1 abgewandelt und
   # um die neue Architektur aktualisiert, übernommen werden!
   notice '... done';
}

release_lock();
[/code]

Das Skript erzeugt folgende Ausgabe:

[code=ini]
[2013-08-25 22:21:52+02:00] [init] [notice] Start testing connection to controller "Iffeldorf 2" ...
[2013-08-25 22:21:52+02:00] [init] [notice] ... done
[2013-08-25 22:21:52+02:00] [init] [notice] Start testing connection to controller "Iffeldorf 1" ...
[2013-08-25 22:21:52+02:00] [init] [notice] ... done
[2013-08-25 22:21:52+02:00] [init] [notice] Start testing connection to calendar server ...
[2013-08-25 22:21:52+02:00] [init] [notice] ... done
[2013-08-25 22:21:52+02:00] [init] [notice] Start testing connection to database server ...
[2013-08-25 22:21:52+02:00] [init] [notice] ... done
[2013-08-25 22:21:52+02:00] [init] [notice] Start writing configuration to JSON file "/var/www/thomas/Iffeldorf/box/overall.conf" ...
[2013-08-25 22:21:52+02:00] [init] [notice] ... done
[2013-08-25 22:21:52+02:00] [init] [notice] Start creating database table(s) ...
[2013-08-25 22:21:52+02:00] [init] [notice] ... done
[2013-08-25 22:21:52+02:00] [init] [notice] Start initializing CRONTAB ...
[2013-08-25 22:21:52+02:00] [init] [notice] ... done[/code]

Die Initialisierung der CRONTAB, das ist das Einzige, was noch fehlt
        an diesem Skript:

[code]
{  # -----==== Initialize CRONTAB ====-----
   notice 'Start initializing CRONTAB ...';
   # Hier fehlt noch die Implementierung, kann aber, aus v1 abgewandelt und
   # um die neue Architektur aktualisiert, übernommen werden!
   notice '... done';
}
[/code]

[section]Fragen an Denkow[/section]

[blue][26.08.2013][/blue] Heute habe ich Herrn Denkov, dem Hersteller der Controllerplatinen die beiden Fragen per Skype gesendet, die wir am 05.08.2013 formuliert haben. Ich warte nun auf Antwort.

[section]Überdenken der Softwarearchitektur[/section]

[blue][26.08.2013][/blue] Bei der Definition der CRONTAB fällt mir auf, dass der CRON jede Minute nur einmal die CRONTAB nach Aufträgen durchsucht. Das macht ein Überdenken der Softwarearchitektur notwendig, da das gewünschte Aktulaisieren der Zustände der Controller auf der Festplatte des IPC im 10"-Takt mit Hilfe des CRON nicht realisierbar ist.

Das ist aber kein blockierender Punkt und muss erst einmal hinter der Untersuchung des IPC anstehen.

[chapter]Phase Vorbereitung Systemhardware => IPC[/chapter]

[section][image src=history/20130828.jpg tn=history/20130828-tn.jpg float=right] Test des IPC auf Schäden durch Blitzschlag[/section]

[blue][26.08.2013][/blue] Folgende Tätigkeiten sind zum Test des IPC notwendig (alle Punkte bauen auf dem Erfolg des jeweils vorausgegangenen auf; eine Scheitern fordert eine alternative Vorgehensweise, die ich bewusst jetzt noch nicht andenke):

[list=I]
[*] Umsetzen der IP Adresse von 192.168.22.* auf 192.168.178.* oder Umstellen auf DHCP. DHCP kann als Methode verwendet werden, da der Router im Pfarrzentrum eine feste Zuordnung von MAC-Adressen zu IP-Adressen im DHCP Bereich erlaubt.
[*] Speichern der getroffenen Netzwerkeinstellungen im dauerhaften Speicher des IPC.
[*] Verbindungsversuch zum IPC über mein lokales Netzwerk.
[/list]

[blue][27.08.2013][/blue] SLAX Dokumentation ist leicht zu lesen. SLAX habe ich soweit kapiert, dass ich die Domain IP umstellen und die Passwörter ändern konnte. Die überflüssigen Kennungen habe ich auch aus den Dateien passwd und shadow entfernt. Die Änderungen habe ich permanent gemacht. Was also heute noch aussteht ist ein boot in meinem Netzwerk. Die Kennung mbr war nur noch in der passwd vorhanden. D.h. dass Martin seine persönlichen Danten und seine Kennung von unserem System selbständig entfernt hat. Damit sind Punkt I und II auf der Liste vom 26.08.2013 erfolgreich erledigt. Die neue IP für den IPC ist 192.168.178.221. DHCP ist nicht aktiviert ... Der IPC ist mit seiner neuen IP in meinem Netzwerk sichtbar, reagiert auf ping-Anfragen aber leider nicht auf ein Einloggen per ssh-Secure-Shell. Da bleibt eine Menge zu tun ... Naja, die positive Planung ohne Rückfallstrategieen scheint noch Wirkung zu zeigen. Ich habe das VPN abgeschaltet und schon funktioniert das SSH wieder auf dem Standardport und XAMPP mit seinem Apache Webserver und der MySQL Datenbank starten auch wieder ohne Fehlermeldung. Nach Einrichten der Portweiterleitung von 192.168.178.221:80 auf Port 80 des Routers ist der IPC über http://home.heptner.de:81 erreichbar. [b][i]Feststellen kann ich jetzt mit sehr großer Sicherheit, dass der IPC an der Netzwerkkarte keinen Blitzschaden abbekommen hat.[/i][/b]

[blue][28.08.2013][/blue] Heute integriere ich den IPC in meine Testanlage. Foto siehe weiter oben!

[section]Untersuchung der Perl-Installation auf dem IPC[/section]

[blue][28.08.2013][/blue] Folgende Tätigkeiten sind zum Test der Perl-Konfiguration des IPC und zur Überprüfung der Update-Fähigkeit von SLAX notwendig (alle Punkte bauen auf dem Erfolg des jeweils vorausgegangenen auf; eine Scheitern fordert eine alternative Vorgehensweise, die ich wieder bewusst jetzt noch nicht andenke):

[list=I]
[*] Untersuchung der Perl-Konfiguration mit Hilfe des bereits fertiggestellten Initialisierungsskriptes. Das ist eine konfrontative Methode und zeigt gleich, welche Module fehlen.
[*] Kontaktaufnahme mit dem Hersteller des Betriebssystems.
[*] Versuch einer Aktualisierung des Betriebssystems.
[*] Versuch einer Aktualisierung von Perl und seinen CPAN Modulen.
[*] Speichern der Aktualisierungen im dauerhaften Speicher des IPC.
[/list]

Ja, das sieht leider nicht so gut aus. Alle Module sind da, aber ich kannn leider nicht auf mySql zugreifen. Zugriff verweigert ... Mache zunächst ein Gesamt CPAN Upgrade ... Vielleicht hilft das ... Ist aber wahrscheinlich nach dem nächsten Boot wieder weg.

[blue][29.08.2013][/blue] Jetzt ist der Knoten geplatzt. Die Konfrontationsmethode hat funktioniert, nur leider nicht zu unseren Gunsten:

[code=ini]
Running make install
  Make had returned bad status, install seems impossible
Running install for module 'warnings::register'
The most recent version "1.02" of the module "warnings::register"
is part of the perl-5.18.1 distribution. To install that, you need to run
  force install warnings::register   --or--
  install R/RJ/RJBS/perl-5.18.1.tar.gz
Running make test
  Can't test without successful make
Running make install
  *** Make had returned bad status, install seems impossible ***
Could not open '/root/.cpan/build/Pod-LaTeX-0.61-ez0j6W/_build/prereqs': Too many open filesFailed during this command:
 PMQS/DB_File-1.829.tar.gz                    : make NO
 FLORA/Devel-DProf-20110802.00.tar.gz         : make NO
 RJBS/perl-5.18.0.tar.bz2                     : make NO isa perl
 NWCLARK/perl-5.8.6.tar.gz                    : make NO isa perl
 JCRISTY/PerlMagick-6.86.tar.gz               : make NO
 PEVANS/Scalar-List-Utils-1.31.tar.gz         : make_test NO
 DAPM/perl-5.10.1.tar.gz                      : make NO isa perl
 RJBS/perl-5.18.1.tar.bz2                     : make NO isa perl
 RJBS/perl-5.18.1.tar.gz                      : make NO isa perl

cpan[3]>
[/code]

Das ist das Ergebnis eines stundenlangen Aktualisierung von Perl und seinen Modulen. Vieles war erfolgreich, aber zum Schluss ging doch nichts mehr. Und persistent, also dauerhaft, war die Geschichte natürlich auch nicht.

Inzwischen habe ich ein aktuelles SLAX mit den für uns notwendigen Zusatzmodulen herunter geladen. Es besteht aber das Risiko, dass ich das nicht oder nur sehr schleppend schaffe. Hier muss ich also doch eine Worst-Case Szenario malen. Für den Fall, dass ich es nicht schaffe den IPC wieder zum Laufen zu bringen, biete ich ein Notebook oder einen anderen kleinen Rechner an, auf dem wir dann Debian Linux installieren können. Damit kenne ich mich gut genug aus.

Morgen oder Übermorgen hätte ich Zeit fü einen ersten Versuch. Ich beginne allerdings nicht ohne einen Startschuss. Noch kann das System die alte Software bequem verarbeiten, steht also die Version 1 ohne weiteres Dazutun zur Verfügung.

Ok, die Entscheidung ist bei einem Telefonat mit Hans-Peter gefallen:

[list=I]
[*] Sichern des aktuellen Systems auf meinem Rechner und auf der auf der Flash-Disk des IPC.
[*] Danach Installation des neuen Systems.
[*] Für den aller grössten Notfall gibt es meinen kleinen HP Rechner mit einem frischen Debian und der Version 1 meiner Steuersoftware für die nächste Heizperiode. Auch die neue Version 2 ließe sich auf diesem HP Rechner installieren.
[/list]

Mit dem Sichern kann ich gleich beginnen, für die Installation benötige ich mehr Ruhe und deshalb kann das erst in Einsamkeit geschehen. Mal sehen, wann ich das hin bekomme. Von 1. - 6. September gehe ich mit einem Kumpel wandern. Das muss sein. Danach bin ich dann wieder für Iffeldorf und sein Pfarrzentrum da.

[section]Neuinstallation des IPC[/section]

[blue][29.08.2013][/blue] Ich bin eigentlich schon weit gekommen. Ich bin tatsächlich dabei ein neues Embedded Betriebssystem aufzusetzen. Das ist doch sonst eigentlich Sache von vielen Mann-Monaten Arbeit von Spezialisten ihres Fachs. Naja, es ist dann auch schon bald eine Bremse drin gewesen. Das System habe ich gesichert und das neue vorinstalliert. Dabei waren noch Zugriffsrechte falsch und überhaupt war auch ein wenig am BIOS und den Netzwerkkarten verstellt, was ich nachjustiert habe. Nun geht aber das System nicht zu starten. Das ist laut SLAX-Forum schon auch in vorherigen Versionen so vorgekommen, wenn man das System auf einem ext4-Dateisystem installiert. Ich habe eine Anfrage in das Forum gestellt und hoffe auf Antwort. In der Zwischenzeit habe ich ein funktionierendes System auf einem Stick installiert und dieses dann eingesetzt um den IPC über die Hürde zu heben. Das hat geklappt, aber dann kann der IPC seine neu eigestellte IP nicht behalten und reagiert immer noch als wenn er eine DHCP holen würde. Diese Aufgabe hält mich ganz schön auf Trapp. Morgen ist nicht viel Zeit und dann geht es auch schon bald in Urlaub. Mein Kumpel hat die Zimmer gebucht. Wandern solange der Kraftvorrat reicht.

[blue][30.08.2013][/blue] Nun habe ich ein Unwetter ausgelöst, aber bitte lest selbst im [url=http://old.slax.org/forum.php?action=view&parentID=86161&anchorid=86161#postid86161]SLAX Forum[/url]. Nun Thomas, viel Spass beim Lösen eines unlösbaren Problems. Den Text aus China jedenfalls, den Google so "vortrefflich" übersetzt hat, den verstehe ich gar nicht, leider. Ich versuchs mal mit meinem Spührsinn oder wenn es gar nicht geht, dann mit Debian LINUX.

Ich verstehe ja noch, dass SLAX nun nicht mehr weiter entwickelt wird. In dem Forum wurde dann Porteus angekündigt als Nachfolger. Das ist ja nett, aber leider, nachdem ich die Installation erfolgreich hingebracht habe - Hochfahren ohne Hilfsmittel, wie USB-Stick und im Netz ansprechbar und sichtbar per ping - stelle ich bei der Installation der Zusatzpackete fest, dass die Distribution noch so jung ist, dass sie noch kein eigenes Perl, noch gar kein PHP, mySQL oder Apache Webserver zur Verfügung stellen kann. Alles auf Anfang auf der Suche nach einer anderen LINUX Distribution.

[section]Installation von XAMPP auf Porteus V2.1[/section]

[blue][31.08.2013][/blue] Neues Betriebssystem auf dem IPC eingerichtet und ein Web-Server mit allem Zubehör installiert. Wie man [url=http://home.heptner.de:81]hier[/url] sehen kann, ist der Web-Server schon aktiv. Ob nun die Secure-Shell oder alle Zusatzmodule, die in Perl für die Ausführung unserer Software, d.h. des bereits entstandenen Initialisierungsskriptes notwendig sind, weiß ich noch nicht, aber wir sind schon einen riesigen Schritt weiter.

Noch stehen folgende Schritte aus:

[list=I]
[*] Installieren und Konfigurieren des SSH-Secure-Shell-Zugangs. [done]
[*] Konfigurieren des FTP-Servers. [done]
[*] Konfigurieren des Web-Servers. [done]
[*] Konfigurieren des mySql-Servers. [done]
[*] Erzeugen der Datenbank auf dem mySql-Server. [done]
[*] Installieren und Starten des bereits entstandenen Initialisierungsskripts. [done]
[*] Nachinstallieren der noch notwendigen Perl-Module von CPAN. [done]
[/list]

[section]Installation, weitere Schritte[/section]

[blue][08.09.2013][/blue] Ich habe heute 2 weitere Benutzer auf dem IPC eingerichtet. Einmal "thomas" als Entwickler und dann "iffeldorf" als Anwendungskennung, auf der dann alle Perl-Prozesse vom CRON aus laufen. Dann habe ich alle notwendigen Perl-Bibliotheken aus CPAN installiert: CPAN Update und die Module JSON, Net::SNMP und Net::MySQL. Dann habe ich den ftp- und mySQL-Server administriert und das Initialisierungsskript und meine eigenen Perl-Module auf den IPC kopiert und zur Ausführung gebracht. Die Pfade im init.pl-Skript musste ich noch anpassen und die Datenbank iffeldorf im mySQL-Server anlegen. Dann gab der IPC zähneknirschend nach und führte das Skript fehlerlos aus. Den Apache-Web-Server habe ich so konfiguriert, dass im Einklang mit dem FTP-Server ein Erreichen des IPC auf Benutzerebene auf beiden Kanälen sichergestellt ist. Was auf jeden Fall noch geschehen muss, das ist die Konfigurtion des openssl Moduls, das im XAMPP mit geliefert wird, damit wir auch per https auf unseren IPC zugreifen können, genauso wie die Einrichtung des SSH-Servers für den Zugang mittels SSH "Secure Shell".

[blue][09.09.2013][/blue] Heute habe ich den SSH-Server auf dem IPC eingerichtet und so kann der zusätzliche Monitor auf meinem Schreibtisch verschwinden.<p>

Für die Aufgabe den Webserver auf dem IPC noch sicherer zu machen, habe ich eine [url=http://www.opencodez.com/apache/ssl-certificate-and-install-in-xampp.htm]"Anweisung zur Erstellung eines OpenSSL-Zertifikates und der Installation in XAMPP"[/url] gefunden.

[chapter]Phase Implementierung Software[/chapter]

[section][local=meter3.html][image src=history/20130731-tn.jpg float=right][/local]Animation der Termomenteranzeige[/section]

[blue][15.09.2013][/blue] Heute habe ich in wenigen Minuten eine Animation der Thermometeranzeige  gebastelt. Eine Übung um nicht aus der Übung zu kommen ;-) Gleichzeitig aufgeräumt und unnötigen Code entfernt.

[section]Algorithmus für Low- &amp; High-Threshold gefunden[/section]

[blue][16.09.2013][/blue] Ich bin sehr froh, dass ich heute Mittag Hans-Peter getroffen habe. Nicht ganz zufällig, weil er mich zum Mittagessen eingeladen hat. Danke Dir dafür. Ich bin deshalb froh, weil ich gleichzeitig jemand geduldigen zum Zuhöhren hatte, unter dessen immerwährenden Fragen ich einen Algorithmus entwickeln konnte, den ich jetzt in die zentrale Logik der Heizungssteuerung einbauen kann. Es handelt sich dabei um den Ersatz für die von Herrn Denkov nicht eingebrachte Ergänzung in die Firmware der Controller-Karten, um das Nichtabspeichern der Thredholds in das Flash der Karten. Wenn diese Werte nur in das RAM der Karten geschrieben worden wären, hätte ich sie sehr regelmässig schreiben können und so die verschiedenen Temperaturbereiche je nach Zieltemperatur einfach mehr als die 10.000 mal umstellen können, die das Datenblatt als garantierte Anzahl von Schreibvorgängen auf das Flash ausweist.

So also ist der Algorithmus gefunden und sieht eigentlich bestechend einfach aus:

[code]
if (relay == 1)
   if (temp >= atrMax)
      relay = 0
else
   if (temp <= atrMin)
      relay = 1;
[/code]

[section]Implementierung des Generators[/section]

[blue][17.09.2013][/blue] Heute habe ich mit dem Skript generator.pl begonnen. Dieses Skript holt sich die Daten vom cKalender-Portal per über die XML-Schnittstelle und erzeugt aus diesen Daten und den Informationen in der Konfigurationsdatei overall.conf eine Steuerdatei für den commander.pl, das Skript, das den gestern gefundenen Algorithmus immer und immer wieder ausführt und damit die Ventile der Heizung abhängig von der tatsächlichen und der gewünschten Temperatur stellt.

[blue][18.09.2013][/blue] Voll neuer Endergie und die erste Hausarbeitsrunde hinter mir, beginne ich den Tag mit der Überlegung, wie der Cache=Zwischenspeicher von der Struktur her aussehen muss, den ich im ersten Gang beim Interpretieren und Prüfen der Kalenderdaten fülle, damit ich in einem zweiten Gang recht einfach die Steuerdatei erzeugen kann. Mal gespannt, wann der Groschen bei mir fällt.

Ein paar Minuten später machte es klick. So schaut also mein erster Lösungsansatz für die Struktur aus:

[code=ini]
jmin - module - cnt
     | module - cnt
     | module - cnt
     \ module - cnt
[/code]

Die Steuerdatei sieht dann genauso aus, nur dass dort nicht ausschliesslich an den Schaltzeiten je ein Datensatz hinterlegt ist sondern jede Minute für die gesamte Zeit, die aus cKalender eingelesen wurde, ein Datensatz mit dem konkreten Zustand eines jeden Ventils hinterlegt wird. Diese Mimik habe ich heute fertig implementiert.

[section]Implementierung des Commanders[/section]

[blue][18.09.2013][/blue] Der Commander stellt die Schaltzentrale der Anlage dar. Er weiß welches Relais wann wie zu schalten ist. Eine "Entscheidungshilfe" bekommt er aus der Steuerdatei, die der Generator erstellt hat. Aus der Konfigurationsdatei bekommt er das Wissen, wie bei welchen Grenzwerten er schalten darf in Abhängigkeit von dem Wunschzustand eines jeden Raumes (geheizt oder vor Schimmel und Frost geschützt). Hier kommt der zentrale Schaltalgorithmus zum Einsatz, den ich am 16.09.2013 gefunden hatte, gewürzt und angereichert mit all den Korrektur und Grenzwerten, die die Konfigurationsdatei vorgibt.

[blue][19.09.2013][/blue] Der Commander ist soweit fertig zum Blackbox-Test. Hier nur ein wichtiger Teil. Lesen der Daten von den Controller-Karten, berechnen der jetzt anzuwendenden Relay-Schaltzuständen und setzen derselben. Der Tag ist erst eine halbe Stunde alt. Jetzt geht's ab in die Falle.

Erste Runde Haushaltsarbeit geschafft und während dessen auch eine tdenkov.pm Bibliothek gebaut, die alle Kommunikation zu den Controller-Karten erledigt. Der zentrale Schaltstelle der Anlage wirkt dadurch noch "aufgerämter". Macht nun richtig Spaß den Code zu lesen.

[code]
#!/usr/bin/perl -w
use strict;
use warnings;

use constant HOME => '/var/www/thomas/Iffeldorf/box';
use constant MYSELF => HOME.'/commander.pl';
use constant LOGFILE => HOME.'/overall.log';
use constant CONFFILE => HOME.'/overall.conf';
use constant CTRLFILE => HOME.'/overall.ctrl';
use constant SEMAPHORE => HOME.'/overall.lock';

use lib HOME;
use tlib::tdate;
use tlib::tlog;
use tlib::tlock;
use tlib::tjson;

use tlib::tdenkov;


# -----==== Setting up skript ====-----
set_lock(SEMAPHORE);
start_logging(LOGFILE, MYSELF);

# -----==== Reading configuration from overall.conf ====-----
my %config = read_json_file(CONFFILE);

# -----==== Debug Setting ====-----
$debug_on = $config{General}{debug};
debug 'Set Debug '.($debug_on?'ON':'OFF').'. Debug message talking about '
      .'reading config file could not be written to log. Don\'t worry, '
      .'that\'s not a bug!';

# -----==== Reading control file from overall.ctrl ====-----
my %command = read_json_file(CTRLFILE);

# -----==== Setting up connections to all controllers ====-----
my %session = ();
foreach my $ctrl (sort keys %{$config{Controller}}) {
   my $ip        = $config{Controller}{$ctrl}{ip};
   my $port      = $config{Controller}{$ctrl}{port};
   my $community = $config{Controller}{$ctrl}{community};
   my $name      = $config{Controller}{$ctrl}{name};

   $session{$ctrl} = denkov_open_session($ip, $port, $community);
}

# -----==== Retrieving data, calculating and setting relays ====-----
my $nowJMin      = pctime2jm(time+tzdiff());
my $atrRangeLow  = $config{General}{atrRange}{low};
my $atrRangeHigh = $config{General}{atrRange}{high};

foreach my $module (keys %{$config{Module}}) {
   my $ctrl   = $config{Module}{$module}{controller};
   my $pin    = $config{Module}{$module}{module};
   my $name   = $config{Controller}{$ctrl}{name};
   my $switch = $command{$nowJMin}{$module};

   my $correction      = $config{Module}{$module}{correction};
   my $moldProtection  = $config{Module}{$module}{moldProtection};
   my $roomTemperature = $config{Module}{$module}{roomTemperature};

   # Retrieving relay and sensor value for this module
   my $relay  = denkov_get_relay($session{$ctrl}, $pin);
   my $sensor = denkov_get_sensor($session{$ctrl}, $pin);

   # Prepare the variables for the master algorithm !!!
   my $target  = ($switch) ? $roomTemperature : $moldProtection;
   my $atrHigh = $target + $atrRangeHigh;
   my $atrLow  = $target + $atrRangeLow;
   my $actual  = ($sensor + $correction) / 4812.8 * 960;

   # Now it's show time !!! This is the heart! Do your hear it beating?
   if ($relay == 1) {
      if ($actual >= $atrHigh) {
         $relay = 0;
      }
   } else {
      if ($actual <= $atrLow) {
         $relay = 1;
      }
   }

   # Setting new relay status for this module
   denkov_set_relay($session{$ctrl}, $pin, $relay);
}

# -----==== Closing connections to all controllers ====-----
foreach my $ctrl (sort keys %{$config{Controller}}) {
   denkov_close_session($session{$ctrl});
}

release_lock();
[/code]

[section]Normailiseren des Programm-Codes[/section]

Habe alle bisher erstellten Skripte normalisiert, d.h. alle mehrfach vorkommenden Befehlsgruppen als Funktionen in thematisch gegliederte Bibliotheken gepackt. Der Pflegeaufwand und die Fehleranfälligkeit wird dadurch start reduziert, das Weiterentwickeln und Ergänzen von Funktionalität wesentlich erleichtert. Folgende Bibliotheken mit den dazu aufgelisteten Funktionen habe ich somit bisher im System:

[list=I]
[*] tlib::[b]tdate[/b] (hm, min, jmin, jdmin, julian, caldat, wday, _strwday, _strmonth, _stryear, valdate, valtime, pctime2jm, pctime2jd, tzdiff, strfjdcal, strfjmin, strfjd)
[*] tlib::[b]tlog[/b] (start_logging, stop_logging, warning, notice, debug, $debug_on)
[*] tlib::[b]tlock[/b] (set_lock, release_lock)
[*] tlib::[b]tini[/b] (parse_ini_file)
[*] tlib::[b]txml[/b] (parse_xml_file, parse_xml_string)
[*] tlib::[b]tjson[/b] (read_json_file, write_json_file)
[*] tlib::[b]tutils[/b] (is_num, is_int, is_ip, subst_de_uml)
[*] tlib::[b]tdenkov[/b] (denkov_open_session, denkov_close_session, denkov_get_sensor, denkov_get_relay, denkov_set_relay)
[*] tlib:[b]tckalender[/b] (ckalender_retrieve_xml_data)
[/list]

[section]Implementierung der Statusanzeige (like linux top)[/section]

Ich dachte, es dauerte länger, aber es ging dann ganz schnell. Das Status-Skript im Stil des des Anzeigetools top von UNIX konnte ich aus einer Abwandlung des Commander-Skriptes herleiten.

[code]
#!/usr/bin/perl -w
use strict;
use warnings;

use constant HOME => '/var/www/thomas/Iffeldorf/box';
use constant MYSELF => HOME.'/status.pl';
use constant LOGFILE => HOME.'/overall.log';
use constant CONFFILE => HOME.'/overall.conf';
use constant CTRLFILE => HOME.'/overall.ctrl';

use lib HOME;
use tlib::tdate;
use tlib::tlog;
use tlib::tjson;

use tlib::tdenkov;


# -----==== Setting up skript ====-----
start_logging(LOGFILE, MYSELF);

# -----==== Reading configuration from overall.conf ====-----
my %config = read_json_file(CONFFILE);

# -----==== Debug Setting ====-----
$debug_on = $config{General}{debug};
debug 'Set Debug '.($debug_on?'ON':'OFF').'. Debug message talking about '
      .'reading config file could not be written to log. Don\'t worry, '
      .'that\'s not a bug!';

# -----==== Reading control file from overall.ctrl ====-----
my %command = read_json_file(CTRLFILE);

# -----==== Setting up connections to all controllers ====-----
my %session = ();
foreach my $ctrl (sort keys %{$config{Controller}}) {
   my $ip        = $config{Controller}{$ctrl}{ip};
   my $port      = $config{Controller}{$ctrl}{port};
   my $community = $config{Controller}{$ctrl}{community};
   my $name      = $config{Controller}{$ctrl}{name};

   $session{$ctrl} = denkov_open_session($ip, $port, $community);
}

# -----==== Retrieving, calculating and displaying data ====-----
my @relayStatText = ( 'Closed', 'Open' );
my $atrRangeLow   = $config{General}{atrRange}{low};
my $atrRangeHigh  = $config{General}{atrRange}{high};

while(1) {
   my $str = "=" x 58 . "\n";

   my $nowJMin = pctime2jm(time+tzdiff());

   foreach my $module (sort keys %{$config{Module}}) {
      my $ctrl   = $config{Module}{$module}{controller};
      my $pin    = $config{Module}{$module}{module};
      my $name   = $config{Module}{$module}{name};
      my $switch = $command{$nowJMin}{$module};

      my $correction      = $config{Module}{$module}{correction};
      my $moldProtection  = $config{Module}{$module}{moldProtection};
      my $roomTemperature = $config{Module}{$module}{roomTemperature};

      # Retrieving relay and sensor value for this module
      my $relay  = denkov_get_relay($session{$ctrl}, $pin);
      my $sensor = denkov_get_sensor($session{$ctrl}, $pin);

      # Prepare the variables for the master algorithm !!!
      my $target  = ($switch) ? $roomTemperature : $moldProtection;
      my $atrHigh = $target + $atrRangeHigh;
      my $atrLow  = $target + $atrRangeLow;
      my $actual  = ($sensor + $correction) / 4812.8 * 960;

      my $relayStat = $relayStatText[$relay];

      $str .= sprintf " %-15s | %5.2f | %6s | %5.2f | %5.2f | %5.2f\n",
                      $name, $actual, $relayStat, $target, $atrLow, $atrHigh;
   }
   $str .= "=" x 58 . "\n";
   system("clear");
   print $str;
   sleep(5);
}

# -----==== Closing connections to all controllers ====-----
foreach my $ctrl (sort keys %{$config{Controller}}) {
   denkov_close_session($session{$ctrl});
}
[/code]

Die Anzeige sieht dann wie folgt aus:

[code]
==========================================================
 30er Raum       |  0.00 | Closed | 14.00 | 13.00 | 15.00
 40er Raum       |  0.00 | Closed | 14.00 | 13.00 | 15.00
 60er Raum       |  0.00 | Closed | 14.00 | 13.00 | 15.00
 Foyer u. WC EG  |  0.00 | Closed | 20.50 | 19.50 | 21.50
 Gruppenraum     |  0.00 | Closed | 14.00 | 13.00 | 15.00
 Jugendtreff     |  0.00 | Closed | 14.00 | 13.00 | 15.00
 Kueche          |  0.00 | Closed | 14.00 | 13.00 | 15.00
 Pfarrsaal Ost   |  0.00 | Closed | 20.50 | 19.50 | 21.50
 Pfarrsaal West  |  0.00 | Closed | 20.50 | 19.50 | 21.50
 WC Keller       |  0.00 | Closed | 20.50 | 19.50 | 21.50
==========================================================
[/code]

[section]Eichen der Thermofühler[/section]

Eichergebnis bei 21.00 Grad Celsius.

[code=ini]
==========================================================
 30er Raum       | 21.14 | Closed | 14.00 | 13.00 | 15.00
 40er Raum       | 21.14 | Closed | 14.00 | 13.00 | 15.00
 60er Raum       | 21.14 | Closed | 14.00 | 13.00 | 15.00
 Foyer u. WC EG  | 21.14 | Closed | 20.50 | 19.50 | 21.50
 Gruppenraum     | 21.14 | Closed | 14.00 | 13.00 | 15.00
 Jugendtreff     | 21.14 | Closed | 14.00 | 13.00 | 15.00
 Kueche          | 21.14 | Closed | 14.00 | 13.00 | 15.00
 Pfarrsaal Ost   | 21.14 | Closed | 20.50 | 19.50 | 21.50
 Pfarrsaal West  | 21.14 | Closed | 20.50 | 19.50 | 21.50
 WC Keller       | 21.14 | Closed | 20.50 | 19.50 | 21.50
==========================================================[/code]

Folgende Korrekturen musste ich für dieses Eichergebnis
        anwenden:

[code]
; Configuration for Iffeldorf Version 2

[Module]       ; Contr, Mod, Corr, Name, Forerun & Trail Min, Mold Prot, Room Temp
Pfarrsaal_West = (Iffeldorf1, 1, -1,  "Pfarrsaal West",  -180, -60, 14, 20.5)
Pfarrsaal_Ost  = (Iffeldorf1, 2, -2,  "Pfarrsaal Ost",   -180, -60, 14, 20.5)
Foyer_WCEG     = (Iffeldorf1, 3, -2,  "Foyer u. WC EG",  -120, -60, 14, 20.5)
Kueche         = (Iffeldorf1, 4, -2,  "Kueche",           -60, -60, 14, 20.5)
30er_Raum      = (Iffeldorf1, 5,  0,  "30er Raum",        -60, -60, 14, 20.5)
40er_Raum      = (Iffeldorf1, 6,  3,  "40er Raum",       -120, -60, 14, 20.5)
60er_Raum      = (Iffeldorf1, 7, -2,  "60er Raum",       -180, -60, 14, 20.5)
Gruppenraum    = (Iffeldorf1, 8, -1,  "Gruppenraum",     -120, -60, 14, 20.5)
Jugendtreff    = (Iffeldorf2, 1, -3,  "Jugendtreff",     -120, -60, 14, 20.5)
WC_Keller      = (Iffeldorf2, 2, -2,  "WC Keller",        -60, -60, 14, 20.5)
[/code]

[section]Performanceoptimierung auf dem IPC[/section]

Nachdem ich die Portierung auf den IPC durchgefürt habe, tritt ein Perfomanceproblem auf. Die Steuerdatei overall.ctrl ist 1. zu groß (trotz Komprimierung noch 5258881 Bytes groß) und 2. dauert das Schreiben der Datei im Setup-Skript  (ca. 2,4 Minuten) und das Auslesen der Datei im Kommando-Skript aus zu lang (bei 9,5 Minuten habe ich abgebrochen). Es ist also notwendig, eine Optimierung durchzuführen. Meine spontane Idee ist die Steuerdaten in eine CSV-Datei zu schreiben und die entscheidende Zeile wieder per grep herauszufiltern. Das probiere ich jetzt einmal aus.

[code]thomas@idefix:~/box$ ls -la
total 5224
drwxr-xr-x  4 thomas thomas     260 Sep 19 17:22 ./
drwxr-xr-x 10 thomas thomas     120 Sep 19 17:06 ../
-rwxrwxr-x  1 thomas thomas    3069 Sep 19 17:16 commander.pl*
-rwxrwxr-x  1 thomas thomas    6744 Sep 19 17:16 generator.pl*
-rw-r--r--  1 thomas thomas    2285 Sep 19 17:20 overall.conf
-rw-r--r--  1 thomas thomas 5258881 Sep 19 17:22 overall.ctrl
-rw-r--r--  1 thomas thomas    1422 Sep 19 17:20 overall.ini
-rw-r--r--  1 thomas thomas       0 Sep 19 17:21 overall.lock
-rw-r--r--  1 thomas thomas   42685 Sep 19 17:22 overall.log
-rwxrwxr-x  1 thomas thomas   12721 Sep 19 17:16 setup.pl*
-rwxrwxr-x  1 thomas thomas    3039 Sep 19 17:16 status.pl*
-rwxrwxr-x  1 thomas thomas    3016 Sep 19 17:16 status1.pl*
drwxr-xr-x  2 thomas thomas      40 Sep 19 17:07 tlib/
[/code]

Beim Schreiben der selben Daten im CSV Format beträgt die Größe der Steuerdatei nur noch knapp 1/5tel gegenüber der komprimierten JSON-Variante. Mal sehen, wie sich die einfachere Struktur auf die Performancewerte auswirken.

[code]
-rw-r--r-- 1 thomas thomas  982080 Sep 19 18:16 overall.ctrl
[/code]

Und nun die Performancewerte zum Vergleich. Erst die Werte auf dem IPC mit der Steuerdatei im JSON-Format mit einer Größe von 5.258.881 Bytes und danach die Werte mit der Steuerdatei im CSV-Format und einer einer Größe von 982.080 Bytes. Beide enthalten die Schaltinformationen für jeden Heizkreislauf fü 31.680 Minuten.

[code=ini]
Thu Sep 19 17:50:45 CEST 2013
setup.pl
Thu Sep 19 17:50:49 CEST 2013
generator.pl
Thu Sep 19 17:52:14 CEST 2013
commander.pl
Thu Sep 19 19:01:04 CEST 2013[/code]

Ich lasse Euch mal mit den Ergebnissen alleine. Ich glaube, dass die für sich sprechen.

[code=ini]Thu Sep 19 20:10:40 CEST 2013
setup.pl
Thu Sep 19 20:10:44 CEST 2013
generator.pl
Thu Sep 19 20:10:49 CEST 2013
commander.pl
Thu Sep 19 20:10:52 CEST 2013
[/code]

Dabei kann ich die Zeiten noch etwas optimieren, wenn wir uns darauf festlegen, wie lange ein Termin sein darf, der über mehrere Tage hinweg geht. Im Moment werden Termine berücksichtigt, die über 14 Tage lang sein können und die Schaltpunkte für 7 Tage im Voraus berechnet, was in Summe ca. 3 Wochen ausmachen. Eine Warnung einzubauen, die Termine, die in der Zukunft auftauchen und deren Start- und Endetag weiter auseinander liegen, als ich die Historie betrachte, wäre bestimmt eine gute Option. Diese Termine würden zum Schluss nicht mehr beheizt und die Leute würden dann zum Schluss Ihrer Zeit in der Pfarrheim frieren. Ich meine das ernst, denn dass man einen solchen Termin statt einer Terminserie eingibt, wäre nicht auszuschliessen. [b]Hier benötige ich also Deine Entscheidung.[/b]

[blue][20.09.2013][/blue] Roller für 300 Euro an unseren Eismann verkauft. Juchuuuuuu!!!! Erste Runde Hausarbeit erledigt. Normalisierung, Test, Fehlerkorrektur vom lesenden und schreibenden Zurgriff auf die Steuerdatei im CSV-Format.

Hier die aktuellen Performancewerte bei 5 Tagen History und 14 Tagen Preview mit Debug Off. Ich denke, dass sich das sehen lassen kann.

[code=ini]
Fri Sep 20 10:27:47 CEST 2013
setup.pl
Fri Sep 20 10:27:51 CEST 2013
generator.pl
Fri Sep 20 10:27:56 CEST 2013
commander.pl
Fri Sep 20 10:27:59 CEST 2013
[/code]

[section]Implementierung Verwaltungs-Skript &amp; CRONTAB[/section]

Das Verwaltungsskript ist schnell geschrieben und das Laden und Interpretieren der CRONTAB für die Anlage im Setup-Skript auch.

[code]
#!/usr/bin/perl -w
use strict;
use warnings;

use constant HOME => (`hostname` eq "idefix\n") ? '/home/thomas/box' : '/var/www/thomas/Iffeldorf/box';

use constant LOGFILE => HOME.'/overall.log';
use constant SEMAPHORE => HOME.'/overall.lock';

use lib HOME;
use tlib::tlock;

set_lock(SEMAPHORE);
system('mv '.LOGFILE.' '.LOGFILE.'.1') if (-f LOGFILE);
release_lock();
[/code]

Wenn wir neue Funktionalität hinzufügen, wie z.B. die Skripte für die Statistikerfassung, dann muss die folgende Datei overall.cron ergäzt werden.

[code=ini]
0,15,30,45 * * * * {HOME}/generator.pl
* * * * * {HOME}/commander.pl
0 0 * * * {HOME}/admin.pl
[/code]

[section]Vorbereitung Montage[/section]

Zur Vorbereitung der Montage fertige ich Bilder der Testanlage und der Eichplatine an, beschrifte diese und stelle sie hier herein. Da die Thermofühler über die Initialisierungsdatei geeicht wurden, darf kein Fühler vertauscht werden. Deshalb werde ich die F&uul;hler auf der Eichplatine montiert anliefern und sie müssen direkt von dort aus Stück für Stück verbaut werden.

[image src=history/20130920a.jpg tn=history/20130920a-tn.jpg] [image src=history/20130920b.jpg tn=history/20130920b-tn.jpg] [image src=history/20130920c.jpg tn=history/20130920c-tn.jpg]

[section][local=meter4.html][image src=history/20130923a-tn.jpg float=right][/local] [local=meter5.html][image src=history/20130923b-tn.jpg float=right][/local]Programmierung lineare Canvas Thermostatanzeige[/section]

[blue][23.09.2013][/blue] Heute ist mir ein erster voll funktionsfähiger Stand der linearen Thermostatanzeige mit einem Canvas Objekt geglückt. Diese Anzeige habe ich aus der runden Analoganzeige heraus entwickelt. So ist der selbe Programmtext nun für beide Anzeigearten wahlweise nutzbar. Ein Beispiel zeigt einen Stapel von 10 linearen Thermostatanzeigen und das andere die beiden Anzeigearten, die lineare und kreisförmige im Vergleich.

[blue][24.09.2013][/blue] Die Controller-Platinen aus Bulgarien haben ca. 12,2 cm x 8,2 cm und meine Breakout-Platinen messen ca. 12,2 cm x 4,1 cm. Ich würde die Kabelbäume ordentlich binden und mit allen Wendungen und Radien käme ich schätzungsweise auf 40 cm x 40 cm lichte Weite der Box und eine liche Höhe von vielleicht 8 cm. Die Relais werden eine Wärmeentwicklung haben, die ich mit diesen lichten Maßen bestimmt auffangen kann, oder? Wenn Du das Bild von der Testanlage hast, so stelle Dir bitte vor, dass die vier Platinen genauso angeordnet sind, mit einem kleinen aber wesentlichen Unterschied. Da die Kabelbäume sich wohl am Besten auf der jeweils rechten Seite (auf der Seite der Relais) verlegen lassen, brauchen wir einen großzügigen Abstand der jeweils zwei übereinander liegenden Platinen von ihren waagerecht liegeneden Nachbarn.

[section]Aufbau und Inbetriebnahme der Anlage[/section]

[blue][26.09.2013][/blue] Morgens früh versorgt uns Hans-Peter noch mit guten Wünschen und reichlich Getränken und dann ist er auch schon wieder bei seiner Arbeit. Willi und ich montieren fleißig, nachdem ich die alte Anlage erfolgreich demontiert habe und kommen sehr gut voran. Bald ist die zentrale Steuerung an seinem Platz befestigt und Willi nimmt die Starkstromverkabelung der Ventile vor. Dann macht er sich an die Montage der Thermofühler. Ich kann die Software problemlos in Betrieb nehmen, stelle aber dann mit Schrecken fest, dass das Signal vom ersten Themperaturfühler ohne Ende um einen eventuell korrekten Wert bis zu 5 Grad C schwankt. Willi hat bis zu diesem Zeitpunkt 6 Thermofühler montiert. Wir machen eine Pause und beraten uns.

Wir können so mit der ganzen bisherigen Arbeit nichts anfangen. Wir machen einige Tests um der Sache auf den Grund zu gehen. Wir benutzen ein KAT7 Kabel von ebenfalls ca. 30 Metern um den Einfluss von externen Störungen aúszuschliessen, aber es stellt sich keine Besserung des Phänomens ein. Wir messen mit einem Voltmeter, doch damit stellen gar keine Schwankungen fest, auch nicht i Millivoltbereich.

All diese Erkenntnisse fasse ich in einer Mail an Herrn Denkov, den Hersteller der Platinen in Bulgarien, zusammen und bitte um Unterstützung. Dankbar stellen wir fest, dass er sich der Sache auch gleich annimmt. Für diesen Tag unterbrechen wir die Arbeiten. Es ist über all die Sorgen schon wieder dunkel geworden.

[image src=history/20130926a.jpg tn=history/20130926a-tn.jpg] [image src=history/20130926b.jpg tn=history/20130926b-tn.jpg] [image src=history/20130926c.jpg tn=history/20130926c-tn.jpg] [image src=history/20130926d.jpg tn=history/20130926d-tn.jpg] [image src=history/20130926e.jpg tn=history/20130926e-tn.jpg] [image src=history/20130926f.jpg tn=history/20130926f-tn.jpg] [image src=history/20130926g.jpg tn=history/20130926g-tn.jpg] [image src=history/20130926h.jpg tn=history/20130926h-tn.jpg] [image src=history/20130926i.jpg tn=history/20130926i-tn.jpg] [image src=history/20130926j.jpg tn=history/20130926j-tn.jpg] [image src=history/20130926k.jpg tn=history/20130926k-tn.jpg] [image src=history/20130926l.jpg tn=history/20130926l-tn.jpg] [image src=history/20130926m.jpg tn=history/20130926m-tn.jpg]

[blue][28.09.2013][/blue] Ein nächtliches Telefonat mit Gunter Magin, Gespräche mit Herrn Prof. Dr. Dr. Müller an der Technischen Hochschule in Ingolstadt und einem Kommunikations-Elektroniker von der Firma Conrad Elektronik brachten uns genug Informationen, dass wir das Auflöten der von Herrn Denkov empfohlenen Kondensatoren auf die Karten auf den Karten wagen. Das Ergebnis haut Hans-Peter vom Stuhl. Meine Emotionen sind gebremst, weil ich zuerst meinen Augen nicht traue.

Nach einem Einmeessen des Fühlers im 30er-Raum sind wir uns sicher, dass wir die Anweisungen von Herrn Denkov richtig umgesetz haben. Die Werte sind so genau und das Signal so gleichbleibend ruhig, dass wir aufatmen können. Herrn Denkov sei gedankt, tue ich natürlich auch sofort im Anschluss. Doch zunächst baue ich die Karten wieder ein, als sei nichts geschehen und lege noch ein paar LAN-Kabel auf.

Aufräumen und Aufatmen ist angesagt. Der Rest Elektroinstallation ist nun Willis Sache. Ich bin fertig mit den Nerven und auch sonst. Ein gemütlichen Kaffeetrinken mit Hans-Peter und dann geht's auch schon wieder heim an den Rechner, ein paar kleine Fehlerkorrekturen und Verbesserungen an der Software machen, die mir bei der Inbetriebnahme aufgefallen sind.

[image src=history/20130928a.jpg tn=history/20130928a-tn.jpg] [image src=history/20130928b.jpg tn=history/20130928b-tn.jpg] [image src=history/20130928c.jpg tn=history/20130928c-tn.jpg] [image src=history/20130928d.jpg tn=history/20130928d-tn.jpg] [image src=history/20130928e.jpg tn=history/20130928e-tn.jpg] [image src=history/20130928f.jpg tn=history/20130928f-tn.jpg] [image src=history/20130928g.jpg tn=history/20130928g-tn.jpg] [image src=history/20130928h.jpg tn=history/20130928h-tn.jpg]

[blue][29.09.2013][/blue] Heute verbessere ich noch die gestern Abend begonnene Seite "anlage" in die Homepage und erzeuge neue Reports, für die Ausgabe der Warnungen bei der Produktion der Steuerdaten, die aus den cKalender-Daten generiert werden. Diese Warnungen helfen den Pflegern der Einträge Gruppenkalender im cKalender-Portal Fehler bei der Eingabe so zu korrigieren, dass die Heizungssteuerung die Eingaben auch richtig verarbeiten kann. Dies ist leider notwendig, da z.B. die Zeitangaben in einem Freitextfeld eingegeben werden müssen, das keine eigene Verifizierung der Eingaben auf Korrektheit kennt.

[code=ini]
================================================================================
                       ----==== 29.09.2013 22:37 ====----
--------------------------------------------------------------------------------
 Module Name     | Current | Valve  | Target  | Minimum | Maximum | Usage
--------------------------------------------------------------------------------
 30er Raum       | 20.35 C | Closed | 14.00 C | 13.00 C | 15.00 C |  0
 Foyer u. WC EG  | 19.95 C | Closed | 14.00 C | 13.00 C | 15.00 C |  0
 Kueche          | 20.55 C | Closed | 14.00 C | 13.00 C | 15.00 C |  0
 Pfarrsaal Ost   | 19.35 C | Closed | 14.00 C | 13.00 C | 15.00 C |  0
 Pfarrsaal West  | 20.55 C | Closed | 14.00 C | 13.00 C | 15.00 C |  0
 WC Keller       | 19.35 C | Closed | 14.00 C | 13.00 C | 15.00 C |  0
================================================================================


================================================================================
Usage Plan of Today 29.09.2013
================================================================================
Original entry 13.00-15.00 at 29.09.2013, "Bastelgruppe"
--------------------------------------------------------------------------------
                 | From             | To               | Module Name
--------------------------------------------------------------------------------
First iteration  | 29.09.2013 13:00 | 29.09.2013 15:00 |
Second iteration | 29.09.2013 12:00 | 29.09.2013 14:00 | 30er Raum
================================================================================
Original entry 15.30-18.00 at 29.09.2013, "Ministunde"
--------------------------------------------------------------------------------
                 | From             | To               | Module Name
--------------------------------------------------------------------------------
First iteration  | 29.09.2013 15:30 | 29.09.2013 18:00 |
================================================================================
Original entry 16:00-17:00 at 29.09.2013, "Test"
--------------------------------------------------------------------------------
                 | From             | To               | Module Name
--------------------------------------------------------------------------------
First iteration  | 29.09.2013 16:00 | 29.09.2013 17:00 |
Second iteration | 29.09.2013 15:00 | 29.09.2013 16:00 | WC Keller
================================================================================


================================================================================
Actual Warning Report from 29.09.2013 22:30
--------------------------------------------------------------------------------
"60er_Raum" used in cKalender at 29.09.2013, "Ministunde", is missing in config file in section Module or Group
"60er_Raum" used in cKalender at 01.10.2013, "Musikschule", is missing in config file in section Module or Group
"Gruppenraum" used in cKalender at 01.10.2013, "Jugend", is missing in config file in section Module or Group
"Jugendtreff" used in cKalender at 01.10.2013, "Jugend", is missing in config file in section Module or Group
"40er_Raum" used in cKalender at 01.10.2013, "KiGo-Team", is missing in config file in section Module or Group
"60er_Raum" used in cKalender at 01.10.2013, "Musikschule", is missing in config file in section Module or Group
"60er_Raum" used in cKalender at 04.10.2013, "Krabbelgruppe", is missing in config file in section Module or Group
"Gruppenraum" used in cKalender at 05.10.2013, "Jugend", is missing in config file in section Module or Group
"Jugendtreff" used in cKalender at 05.10.2013, "Jugend", is missing in config file in section Module or Group
"40er_Raum" used in cKalender at 07.10.2013, "PGR-Sitzung", is missing in config file in section Module or Group
"60er_Raum" used in cKalender at 07.10.2013, "Capella_vocale_Probe", is missing in config file in section Module or Group
"60er_Raum" used in cKalender at 08.10.2013, "Musikschule", is missing in config file in section Module or Group
"Gruppenraum" used in cKalender at 08.10.2013, "Jugend", is missing in config file in section Module or Group
"Jugendtreff" used in cKalender at 08.10.2013, "Jugend", is missing in config file in section Module or Group
"60er_Raum" used in cKalender at 08.10.2013, "Musikschule", is missing in config file in section Module or Group
"60er_Raum" used in cKalender at 10.10.2013, "Kirchenchor", is missing in config file in section Module or Group
"60er_Raum" used in cKalender at 11.10.2013, "Krabbelgruppe", is missing in config file in section Module or Group
"60er_Raum" used in cKalender at 11.10.2013, "HW-Band", is missing in config file in section Module or Group
"Gruppenraum" used in cKalender at 12.10.2013, "Jugend", is missing in config file in section Module or Group
"Jugendtreff" used in cKalender at 12.10.2013, "Jugend", is missing in config file in section Module or Group
================================================================================
[/code]

[section][local=live.php][image src=history/20131002-tn.jpg float=right][/local]Live Anlagenübersicht[/section]

[blue][02.10.2013][/blue] Heute ist es zwar schon ein paar Tage später, aber dennoch möchte ich diesen Code herzeigen, weil ich doch ein wenig stolz bin darauf, dass er so optimiert gelang und so gut und reibungslos funktioniert. Ich hatte eigentlich vor, diese Funktionalität mit der AJAX Toolbox zu realisieren. Das hätte eindeutig mehr Kontrolle über die Innereien gegeben, wäre aber auch wesentlich aufwendiger gewesen. Da ich mich also überwinden konnte, die vollständige Kontrolle abzugeben, widme ich diese Funktionalität meinem Arzt, der mich seit 1996 durch mein Leben begleitet, durch mehr Tiefen als Höhen und für den ich alles mir mögliche tun würde, wenn er nicht so sehr bescheiden wäre, es anzunehmen. Ich verdanke ihm bei weitem mehr als mein Leben!!!

[code]
<?
require("scripts/sajax.php");

function retrieve_snapshot() {
   $filename = '../../box/snapshot.cache';
   if(!is_file($filename)) {
      die("'$filename' not found!");
   }
   $string = file_get_contents($filename);
   $data = json_decode($string, true);

   $data["Time"]["server"] = time();

   $timestamp = localtime($data["Time"]["cache"], true);
   $data["Clock"]["hours"] = $timestamp["tm_hour"] % 12;
   $data["Clock"]["minutes"] = $timestamp["tm_min"];

	return $data;
}

$sajax_request_type = "GET";
#$sajax_debug_mode = true;
$sajax_remote_uri = "content/live.php";
sajax_init();
sajax_export("retrieve_snapshot");
sajax_handle_client_request();
?>
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=latin1_german2_ci">
    <link rel="stylesheet" type="text/css" href="styles/fonts.css">
    <link rel="stylesheet" type="text/css" href="styles/content.css">
    <!--[if IE]>
     <link rel="stylesheet" type="text/css" href="styles/content-ie.css">
     <script type="text/javascript" src="jscripts/excanvas.js"></script>
    <![endif]-->
    <script type="text/javascript" src="content/jscripts/system-clock.js"></script>
    <script type="text/javascript" src="content/jscripts/acc-meter4.js"></script>
    <script type="text/javascript">
      <?
      sajax_show_javascript();
      ?>

      window.requestAnimFrame = (function(callback) {
         return window.requestAnimationFrame ||
                window.webkitRequestAnimationFrame ||
                window.mozRequestAnimationFrame ||
                window.oRequestAnimationFrame ||
                window.msRequestAnimationFrame ||
                function(callback) {
                   window.setTimeout(callback, 1000/60);
                };
      })();

      var clock = null;
      var meter = Array();
      var cache_time  = 0;
      var server_time = 0;

      function setup_display(data) {
         clock = new SystemClock("Anlagen_Uhr");
         clock.draw();
         for (var module in data["Titles"]) {
            meter[module] = new AccMeter(module);
            meter[module].dialType  = AccMeter.LinarDial;
            meter[module].titleText = data["Titles"][module];
            meter[module].draw();
         }
      }

      function check_validity() {
         var now = new Date();
         var time = ~~(now.getTime() / 1000);
         var app_online = ((time - server_time) < 60) ? true : false;
         var data_valid = ((server_time - cache_time) < 60) ? true : false;

         if (clock) {
            clock.dataValid    = data_valid;
            clock.clockOnline  = app_online;
         }
         for (var module in meter) {
            meter[module].dataValid    = data_valid;
            meter[module].meterOnline  = app_online;
         }
         setTimeout(check_validity, 1000*5);
      }

      function update_display(data) {
         cache_time  = data["Time"]["cache"];
         server_time = data["Time"]["server"];

         if (clock) {
            clock.hours   = data["Clock"]["hours"];
            clock.minutes = data["Clock"]["minutes"];
         }

         for (var module in meter) {
            if (data["Data"][module]) {
               meter[module].relayStatus  = data["Data"][module]["relay"];
               meter[module].actualValue  = data["Data"][module]["actual"];
               meter[module].targetValue  = data["Data"][module]["target"];
               meter[module].atrHighValue = data["Data"][module]["atrHigh"];
               meter[module].atrLowValue  = data["Data"][module]["atrLow"];
            // meter[module].infoText     = (data["Data"][module]["inUse"])
            //                            ? "in use" : "not in use";;
            } else {
               meter[module].dataValid    = false;
            }
         }
      }

      function animate_display() {
         if (clock) {
            clock.draw();
         }
         for (var module in meter) {
            meter[module].draw();
         }
//       window.setTimeout(animate_display, 50);
         requestAnimFrame(function() {
            animate_display();
         });
      }

      function init() {
         x_retrieve_snapshot(setup_display);
      }

      function rotate() {
         x_retrieve_snapshot(update_display);
         setTimeout(rotate, 1000*15);
      }

      window.onload = function() {
         animate_display();
         check_validity();
         setTimeout(rotate, 1000*2);
      };

      init();

    </script>
    <title>Anlagen Status</title>
  </head>
  <body>
    <div id="content" style="width:10%">
      <table>
        <tr>
          <td>
            <fieldset>
            <legend>&nbsp;Obergeschoss&nbsp;</legend>
              <canvas id="30er_Raum" width="300" height="90">
                Fehlermeldung
              </canvas><br />
              <canvas id="40er_Raum" width="300" height="90">
                Fehlermeldung
              </canvas><br />
              <canvas id="60er_Raum" width="300" height="90">
                Fehlermeldung
              </canvas>
            </fieldset>
            <fieldset>
            <legend>&nbsp;Keller&nbsp;</legend>
              <canvas id="WC_Keller" width="300" height="90">
                Fehlermeldung
              </canvas><br />
              <canvas id="Gruppenraum" width="300" height="90">
                Fehlermeldung
              </canvas><br />
              <canvas id="Jugendtreff" width="300" height="90">
                Fehlermeldung
              </canvas>
            </fieldset>
          </td>
          <td>
            <fieldset>
            <legend>&nbsp;Anlagenstatus&nbsp;</legend>
              <table style="width:100%">
                <tr>
                  <td style="text-align:left;vertical-align:middle;">
                    <h1><span class="red">Pfarrzentrum</span><br />
                    St. Vitus<br />
                    Iffeldorf</h1>
                  </td>
                  <td style="text-align:right">
                    <canvas id="Anlagen_Uhr" width="174" height="174">
                      Fehlermeldung
                    </canvas>
                  </td>
                </tr>
              </table>
            </fieldset>
            <fieldset>
            <legend>&nbsp;Erdgeschoss&nbsp;</legend>
              <canvas id="Pfarrsaal_West" width="300" height="90">
                Fehlermeldung
              </canvas><br />
              <canvas id="Pfarrsaal_Ost" width="300" height="90">
                Fehlermeldung
              </canvas><br />
              <canvas id="Kueche" width="300" height="90">
                Fehlermeldung
              </canvas>
              <canvas id="Foyer_WCEG" width="300" height="90">
                Fehlermeldung
              </canvas>
            </fieldset>
          </td>
        </tr>
      </table>
    </div>
  </body>
</html>
[/code]

[section]Besprechung weiteres Vorgehen[/section]

[blue][14.10.2013][/blue] Heute haben wir kleine Erweiterungen beschlossen. Die erste habe ich bereits bis zur Mittagspause implementiert.

[list=I]
[*] Einbau einer General.filter Variable in die Initialisierungsdatei und filtern von Zimmerbezeichnungen, die z.B. Ferien heissen. [done]
[*] cKalender ID überall durchschleifen. [done]
[*] Cache mit Kalenderdaten durch den Generator erzeugen lassen. [done]
[*] Terminbezeichnungen in der Live-Anzeige und im Status Skript darstellen. [done]
[*] Aufrämen der Skripte und Dateien. [done]
[/list]

Weiter habe ich folgende Vorgehensweise für die Implentierung der statistischen Grafiken vorgeschlagen:

[list=I]
[*] Grafik Bibliothek untersuchen. [done]
[*] Skript: mySql Daten schreiben. [done]
[*] Skript: mySql Daten lesen => html Text. [postponed]
[*] Skript: Einzelnen Event filtern & darstellen. [postponed]
[*] cKalender in html lesen => als Menü verarbeiten. [rejected]
[/list]

[section]Implementierung kleiner Erweiterungen[/section]

[blue][14.10.2013][/blue] Heute habe ich gleich mit der Implementierung der kleinen Erweiterungen begonnen. Diese bereiten auch die etwas erweiterten Anforderungen an die Statistikerhebung vor. So wird das Datenbankschema um eine Tabelle erweitert, in dem Informationen zu den Terminen aus dem Kalenderportal gespeichert werden. Dazu muss die Termin ID vom Kalenderserver sowieso auf der Seite des Datenerfassungs Skriptes bekannt sein. Hier schlage ich eine Fliege mit zwei Klappen oder so ähnlich.

[blue][16.10.2013][/blue] Heute bin ich mit den kleinen Erweiterungen fertig geworden. Die [local=live.php]Liveanzeige[/local] habe ich um die Angabe der Termine erweitert, für die gerade geheizt wird.

Das Fortkommen war gebremst durch andere Aktivitäten und Verwirbelungen ausserhalb unseres Projektes. Eigentlich wollte ich noch mit den Änderungen am Datenbankschema beginnen, aber ich bin einfach zu erschöpft von all dem Wirbel um mich herum und in mir drinnen. Also mache ich für heute Schluss. Sorry!!!

[section]Verschiedene Tätigkeiten[/section]

[blue][20.10.2013][/blue] Heute habe ich die Dokumentation auf bb-Codes umgestellt. Damit kann ich nun sehr einfach die Texte schreiben, die ich hier hereinstellen möchte. Ich habe dann nichts mehr mit HTML-Code und sprezieller Behandlung von Sonderzeichen wie z.B. &szlig; für "ß" zu tun. Das macht doch einiges sehr viel einfacher.

[code]
<?php

require_once 'bbcode/src/stringparser_bbcode.class.php';

// Zeilenumbrüche verschiedener Betriebsysteme vereinheitlichen
function convertlinebreaks ($text) {
    return preg_replace ("/\015\012|\015|\012/", "\n", $text);
}

// Alles bis auf Neuezeile-Zeichen entfernen
function bbcode_stripcontents ($text) {
    return preg_replace ("/[^\n]/", '', $text);
}

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

   $bbcode->addCode ('ok', 'simple_replace_single', null, array ('start_tag' => '<img src="images/icons/hak.gif" style="border:0" />'),
                     'inline', array ('listitem', 'block', 'inline', 'link'), array ());
   $bbcode->addCode ('latest', 'simple_replace_single', null, array ('start_tag' => '<a name="latest">&nbsp;</a>'),
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

   # handle code snipets
   function do_bbcode_code ($action, $attributes, $content, $params, $node_object) {
      if (!isset ($attributes['default'])) {
         $lang = '';
      } else {
         $lang = $attributes['default'];
      }
      if ($action == 'validate') {
         if ($lang != '' && $lang != 'ini' && $lang != 'php') {
            return false;
         }
         return true;
      }
      $text = translate($content);
      return "<pre><code class=\"$lang\">$text</pre></code>\n";
   }
   $bbcode->addCode ('cde', 'simple_replace', null, array ('start_tag' => '<pre><code>', 'end_tag' => '</pre></code>'),
                     'code', array ('listitem', 'block'), array ());
   $bbcode->addCode ('code', 'usecontent', 'do_bbcode_code', array ('usecontent_param' => 'default'),
                     'code', array ('block'), array ());
   $bbcode->setCodeFlag ('code', 'paragraph_type', BBCODE_PARAGRAPH_BLOCK_ELEMENT);
   $bbcode->setCodeFlag ('code', 'opentag.after.newline', BBCODE_NEWLINE_DROP);
   $bbcode->setCodeFlag ('code', 'closetag.before.newline', BBCODE_NEWLINE_DROP);

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
      return "<a href=\"$url\" target=\"_blank\"><img src=\"images/icons/lnk.gif\" style=\"border:0\" class=\"screen\" />$text</a>";
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
         if (!file_exists ("content/$doc")) {
            return false;
         }
         return true;
      }
      $doc = translate($doc);
      return "<a href=\"index.php?$doc\" target=\"_parent\">$text</a>";
   }
   $bbcode->addCode ('local', 'usecontent?', 'do_bbcode_local', array ('usecontent_param' => 'default'),
                     'link', array ('listitem', 'block', 'inline'), array ('link'));

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
         if ($src == "" || substr ($src, 0, 5) == 'data:' || substr ($src, 0, 5) == 'file:'
             || substr ($src, 0, 11) == 'javascript:' || substr ($src, 0, 4) == 'jar:') {
            return false;
         }
         if (substr ($tn, 0, 5) == 'data:' || substr ($tn, 0, 5) == 'file:'
             || substr ($tn, 0, 11) == 'javascript:' || substr ($tn, 0, 4) == 'jar:') {
            return false;
         }
         if ($float != "" && $float != "right" && $float == "left") {
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
[/code]

[section]Datenbankschema erweitert[/section]

[blue][21.10.2013][/blue] Heute habe ich das Datenbankschema auf den neuesten Stand gebracht. Es kommt eine Tabelle mit Daten aus dem cKalender-System dazu, die bei der Generierung der Steuerdaten in den control.cache in den calendar.cache geschrieben werden. "24566032337952" ist ein Beispiel für eine tid, welche der "$jMin$cKID" entspricht.

[code]
CREATE TABLE IF NOT EXISTS `accLog` (
    `accLog_id`   bigint(20) unsigned  NOT NULL AUTO_INCREMENT,
    `jMinute`     bigint(20) unsigned  NOT NULL,
    `relay`       tinyint(1)           NOT NULL,
    `actual`      float                NOT NULL,
    `target`      float                NOT NULL,
    `atrLow`      float                NOT NULL,
    `atrHigh`     float                NOT NULL,
    `date_id`     bigint(20) unsigned  NOT NULL,
    `module_id`   bigint(20) unsigned  NOT NULL,
  PRIMARY KEY (`accLog_id`)
);

CREATE TABLE IF NOT EXISTS `date` (
    `date_id`     bigint(20) unsigned  NOT NULL AUTO_INCREMENT,
    `cKalId`      bigint(20) unsigned  NOT NULL,
    `jMinBegin`   bigint(20) unsigned  NOT NULL,
    `jMinEnd`     bigint(20) unsigned  NOT NULL,
    `text`        varchar(30)          NOT NULL,
   PRIMARY KEY (`date_id`)
);

CREATE TABLE IF NOT EXISTS `module` (
    `module_id`   bigint(20) unsigned  NOT NULL AUTO_INCREMENT,
    `module`      char(14)             NOT NULL,
    `correction`  int(2)               NOT NULL,
    `shortName`   varchar(8)           NOT NULL,
    `longName`    varchar(30)          NOT NULL,
   PRIMARY KEY (`module_id`)
);
[/code]

Ebenfalls habe ich heute den Stick mit ext3 formatieren können. Damit können wir dann einmal versuchen, die Datenbank auf ein externes Medium auszulagern.

[blue][25.10.2013][/blue] Ich komme nicht an den phpMyAdmin um die Datenbank umzubauen, weil das Admintool für Zugriffe von localhost konfiguriert ist und ich das der Sicherheit wegen auch nicht anders einrichten mag. Wegen des geringen Speichervorkommens auf dem IPC habe ich auch keine grafische Oberfläche installiert, was dann den Aufruf des Admintools über einen Browser unmöglich macht. So schreibe ich das Setup-Skript um, füge die neue Tabelle ein und lösche mit einem Befehlt "drop table `accLogs` die alte. Mit dieser Mimik bekomme ich das löschen hin. Aber so geht es noch viel bequemer:

[code=ini]
thomas@idefix:~/box$ /opt/lampp/bin/mysqladmin --user=root --password=****** drop iffeldorf
Warning: Using a password on the command line interface can be insecure.
Dropping the database is potentially a very bad thing to do.
Any data stored in the database will be destroyed.

Do you really want to drop the 'iffeldorf' database [y/N] y
Database "iffeldorf" dropped
thomas@idefix:~/box$ /opt/lampp/bin/mysqladmin --user=root --password=****** create iffeldorf
Warning: Using a password on the command line interface can be insecure.
thomas@idefix:~/box$
[/code]

[blue][03.11.2013][/blue] Ich überprüfe die Datenstruktur weiter oben darauf, wie ich später ein ansprechendes und praktisch brauchbares Auswahlmenü bauen kann.

[code=ini]
[Datum auswählen] | Pfs West | Pfs Ost | Foyer | Kueche | 30er | 40er | 60er | Gruppe | Jugend | WCK |
Ganzer Tag        |   OOO    |   OOO   |  OOO  |  OOO   | OOO  | OOO  | OOO  |  OOO   |  OOO   | OOO |
Termin 1          |   XXX    |   XXX   |  OOO  |  XXX   | OOO  | OOO  | OOO  |  OOO   |  OOO   | OOO |
Termin 2          |   OOO    |   OOO   |  OOO  |  OOO   | OOO  | XXX  | OOO  |  OOO   |  OOO   | OOO |
Termin 3          |   OOO    |   OOO   |  OOO  |  OOO   | OOO  | OOO  | OOO  |  XXX   |  XXX   | OOO |
[/code]

[blue][05.11.2013][/blue] Eben beende ich das Gespräch mit Herrn Saal (Techniker) von der [url=http://www.zagmbh.de/html/kontakt.html]ZAG GmbH[/url]. Das ÖKOplus-Modul wurde von einer Firma in Penzberg entwickelt, jedoch nicht dokumentiert. Eine Softwareschnittstelle wurde nicht entwickelt. Während der Entwicklung entstand keine Dokumentation. Die Firma hat inzwischen zugemacht. Es gibt also keine Chance an die Werte des ÖKPplus auf automatisiertem Wege heran zu kommen.

Eine Gehäuse von einem der Messfühler ist gebrochen. Davon bitte ein Bild machen und an mich schicken. Dafür gibt es mit hoher Wahrscheinlichkeit noch ein Ersatzteil. Ich kann die Bestellung an Herrn Saal (saal@zagmbh.com) übernehmen.

[blue][09.11.2013][/blue] Die Einbindung der Sensoren (Vorlauf- und Rücklauf der Heizanlage und der Aussenfühler) ist abgeschlossen. Ein Blick auf die [local=live.php]Anlagenübersicht[/local] zeigt die neuen Fühleranzeigen in Funktion.

[blue][10.11.2013][/blue] Ausserdem frage ich beim Hersteller der Controllerkarten nach, wie man die Messfühler dazu überreden kann, Minustemperaturen zu messen (siehe [local=started.bb#TOC3]Schriftverkehr[/local]).

[blue][13.11.2013][/blue] Herr Denkov hat geantwortet und einen Messfühler genannt, den Hans-Peter dann auch gleich bestellt hat. Dieser wird an den Analogeingang 0-10 Volt angeschlossen. Dafür bedarf es dann noch eines kleinen Flachbandkabels mit einer Lüsterklemme (siehe [local=started.bb#TOC3]Schriftverkehr[/local]).

[blue][18.11.2013][/blue] Heute habe ich zwei neue Features fertig gestellt. Zum einen laufen jetzt Logdaten in die Datenbank zur Erstellung von Statistiken und zum anderen läßt sich das Schreiben in die Datenbank jetzt auch in der Initialisierungsdatei steuern. Einstellbar sind nun:

[list=I]
[*] Das Zeitintervall zum Erfassen der Daten in Minuten (1-20).
[*] Der Zeitraum für den die Daten aufgehoben werden in Tagen (1-366).
[/list]

Inzwischen lohnt es sich, die Initialisierungsdatei wieder einmal zu präsentieren. Sie ist inzwischen fleißig gewachsen, aber nicht weniger übersichtlich.

[code]
; Configuration for Iffeldorf Version 2

[General]
debug     = "On"
cKalender = ("4980", "********************************", 5, 21) ; OrgId, OrgPw, History, Preview
atrRange  = (-1, 1) ; Low, High
database  = ("localhost", "iffeldorf", "root", "******") ; Host, Database, User, PW
filter    = (Ferien) ; drop data for this Circuits
logging   = (15, 5) ; logInterval in Minutes, logHistory in Days

[Controller]   ; IP, Port, Community, Name
Iffeldorf1     = ("192.168.178.222", 161, "******", "Iffeldorf 1")
Iffeldorf2     = ("192.168.178.223", 161, "******", "Iffeldorf 2")

[Circuit]      ; Contr, Mod, Corr, Long-Name, Short-Name, Forerun & Trail Min, Mold Prot, Room Temp
Pfarrsaal_West = (Iffeldorf1, 1, -1, "Pfarrsaal West", "Pfs West", -180, -60, 14, 20.5)
Pfarrsaal_Ost  = (Iffeldorf1, 2, -2, "Pfarrsaal Ost",  "Pfs Ost",  -180, -60, 14, 20.5)
Foyer_WCEG     = (Iffeldorf1, 3, -2, "Foyer u. WC EG", "Foyer WC", -120, -60, 14, 20.5)
Kueche         = (Iffeldorf1, 4, -2, "Kueche",         "Kueche",    -60, -60, 14, 20.5)
30er_Raum      = (Iffeldorf1, 5, -1, "30er Raum",      "30 Raum",  -180, -60, 14, 20.5)
40er_Raum      = (Iffeldorf1, 6,  3, "40er Raum",      "40 Raum",  -180, -60, 14, 20.5)
60er_Raum      = (Iffeldorf1, 7, -2, "60er Raum",      "60 Raum",  -180, -60, 14, 20.5)
Gruppenraum    = (Iffeldorf1, 8, -1, "Gruppenraum",    "Gruppe",   -120, -60, 14, 20.5)
Jugendtreff    = (Iffeldorf2, 1, -3, "Jugendtreff",    "Jugend",   -120, -60, 14, 20.5)
WC_Keller      = (Iffeldorf2, 2, -2, "WC Keller",      "WC UG",     -60, -60, 14, 20.5)

[Group]        ; Modules
Pfarrsaal      = (Pfarrsaal_West, Pfarrsaal_Ost, Foyer_WCEG)

[Sensor]       ; Contr, Mod, Corr, Long-Name, Short-Name
Vorlauf        = (Iffeldorf2, 3, 0, "Heizung Vorlauf",   "Hzg Vorl")
Ruecklauf      = (Iffeldorf2, 4, 0, "Heizung Ruecklauf", "Hzg Ruel")
Aussen         = (Iffeldorf2, 5, 0, "Aussenfuehler",     "Aussen")
[/code]

[chapter]Phase Weiterentwicklung[/chapter]

[section]Wiedereinstieg in die Entwicklung[/section]

[blue][22.01.2014][/blue] Die Seite [b]Aktuelles[/b] habe ich in [i]Phase I[/i] und [i]Phase II[/i] geteilt, wobei die [i]Phase I[/i] die Entwickung der Version 2 umfaßt und die [i]Phase II[/i] deren Weiterentwicklung und Pflege.

Es wird sehr deutlich, daß meine [red]Internetverbindung wesentich zu langsam[/red] ist. Die Frage ist ob ich für ca. 30 - 35 Euro pro Monat und eine einmalige Einrichtungsgebühr eine DSL-Leitung legen lassen soll. Das Geld kommt aber über diese Tätigkeit nicht herein und würde im Moment nur für diese Tätigkeit gebraucht (ausgenommen die Ersteinrichtung von Rechnern mit LINUX).

[section]Neue Entwicklungsumgebung[/section]

[blue][07.03.2014][/blue] Durch eine Verschiebung meines Entwicklungsrechners hin zu einem Server meines Sohnes und der Tatsache, daß die Videokarte des "neuen" Rechners seit einiger Zeit bei der Reparatur ist, habe ich im Moment nur ein Notebook mit amerikanischer Tastatur und einem neuen Lubuntu Betriebssystem. Alles ist noch sehr neu, aber deshalb nicht schlechter als bei Debian. Ich habe bei meinem Auszug den HP LaserJet 1010 zurückgelassen und nunmehr nur noch den HP DeskJet 460. Das ist absolut ausreichend. Ich drucke seit dem wesentlich weniger, nur Briefe, die ich versenden muß. Außerdem bin ich erst einmal geheilt von zuviel Papier. Ich habe jeden Tag eine leidige Aufgabe, Papier auszusortieren und auszumisten, was im Nachgang allerdings ein befreiendes und erleichtertes Gefühl macht.

Wegen meinem Webzugang komme ich nicht recht weiter. Ich habe allerdings ein - so meine ich - günsitges Angebot bei O2 gefunden, das ich im Moment von allen Seiten her prüfe. Dort gibt es auch eine feste IP, ohne Aufpreis, die ich für alle möglichen Anwendungen gebrauchen kann.

Heute habe ich den WebServer auf dem Notebook installiert, den Drucker als Netzdrucker zum Laufen gebracht und nebenbei sogar noch in den Steuerjahren 2000 - 2004 gründlich aussortiert. Lieber Hans-Peter, wenn Du das hier liest, dann sei Dir dessen sicher, daß ich die Wochen über schon immer an die Statistikrealisierung gedacht habe, jedoch die Steuer 2012/13 leider Vorrang hatten. Der Nachteil langer Pausen ist, daß man erst einmal wieder rein kommen muß.

[section]pChart und Datenbankschema im Test[/section]

[blue][17.03.2014][/blue] Während ich wieder auf das "schnelle" Internet warte, d.h., daß die Drosselung meines SIM Karten Internets am nächsten Monatsanfang zurück gesetzt wird, probiere ich die Bibliothek pChart aus. Zur Anwendung kommt die Version pChart 2.1.4, die eine Fülle von Möglichkeiten zur Verfügung stellt.

Hier nun ein erstes Ergebnis mit fiktiven Daten:

[image src=history/graphics002.png]

[image src=history/graphics003.png]

Ich glaube allerdings, daß ein Heizkreislauf pro Grafik leichter zu lesen ist, weshalb ich ab jetzt auf diese Art der Darstellung hin arbeite:

[image src=history/graphics004.png]

Jetzt habe ich den Punkt gefunden, an dem die Sache deutlicher wird. Ich habe die Linien bei allen drei Grafiken fetter gemacht und schon kann man sie sehr deutlich auf dem grauen Hintergrund wahrnehmen. Jetzt also auf zur mySQL-Anbindung.

[blue][25.03.2014][/blue] Um zu wissen, wie ich weiter arbeiten kann, ist es doch erst einmal von Nutzen, zu ergründen, wie das Datenbankschema im Moment aussieht und zu überlegen, ob es so auch sinnvoll erscheint.

[code]
DROP DATABASE IF EXISTS iffeldorf;
CREATE DATABASE iffeldorf;
DEFAULT CHARSET=latin1 COLLATE=latin1_german2_ci;
USE iffeldorf;

CREATE TABLE `circLog` (  `jMinute`     bigint(20) unsigned  NOT NULL,    `relay`       tinyint(1)           NOT NULL,    `actual`      float                NOT NULL,
    `cKalId`      bigint(20) unsigned  DEFAULT NULL,
    `circId`      char(20)             NOT NULL,
   KEY `jMinute` (`jMinute`)
);
CREATE TABLE `cKalender` (
    `cKalId`      bigint(20) unsigned  NOT NULL,
    `jMinBegin`   bigint(20) unsigned  NOT NULL,
    `jMinEnd`     bigint(20) unsigned  NOT NULL,
    `text`        varchar(80)          NOT NULL,
   UNIQUE KEY `cKalId` (`cKalId`)
);
CREATE TABLE `circuit` (
    `circId`      char(20)             NOT NULL,
    `correction`  float                NOT NULL,
    `moldProt`    float                NOT NULL,
    `roomTemp`    float                NOT NULL,
    `longName`    varchar(30)          NOT NULL,
    `shortName`   varchar(8)           NOT NULL,
   UNIQUE KEY `circId` (`circId`)
);

CREATE TABLE `sensLog` (
    `jMinute`     bigint(20) unsigned  NOT NULL,
    `relay`       tinyint(1)           NOT NULL,
    `actual`      float                NOT NULL,
    `sensId`      char(20)             NOT NULL,
   KEY `jMinute` (`jMinute`)
);
CREATE TABLE `sensor` (
    `sensId`      char(20)             NOT NULL,
    `correction`  float                NOT NULL,
    `longName`    varchar(30)          NOT NULL,
    `shortName`   varchar(8)           NOT NULL,
   UNIQUE KEY `sensId` (`sensId`)
);
[/code]

[blue][26.03.2014][/blue] Kurz vor dem Schlafen gehen noch eine kleine Änderung: Fehlermeldungen und Warnungen auf der Statusseite auf den Anfang verschieben.

Und hier noch ein Versuch mit zwei Raumtemperaturverläufen und dem Ventilstatusverlauf für den ersten Heizkeislauf.

[image src=history/graphics005.png]

[blue][27.03.2014][/blue] Neue kleinere, aber wichtige Anforderungen mit Hans-Peter am Telefon gesammelt:

[list]
[*]Liste der Warnungen und Fehlermeldungen auf der Statusseite an erste Stelle stellen. [done]
[*]Ein Warnschild auf jeder Seite soll anzeigen, daß in der Heizungssteuerung Fehlermeldungen oder Warnungen auflaufen [postponed]
[*]Ein Click auf dieses Schild soll direkt zur Statusseite führen [postponed]
[*]ICON-Biblkiothek finden, die den Unterschied zwischen den Systemzuständen deutlich zum Ausdruck bringt, z.B. durch eine Wetteranzeige oder die Darstellung per Verkehrsschilder ... [done]
[/list]

Die Wahl der ICON-Bibliothek fiehl auf die Open Icon Library 0.11.

[local=clock.html][image src=history/20130720b-tn.jpg float=right][/local][blue][04.04.2014][/blue] Fehler in der Animation der Systemuhr korrigiert und einen neuen Test in die entsprechende Testseite eingebracht.

Heute bin ich ansonsten nur matt, total matt. Jetzt steht aber endlich die Einbindung der Datenbank an:

[list]
[*] Entwickeln der Datenbankanbindung. [done]
[*] Entwickeln einer nicht konfigurierbare Statistik. [done]
[*] Entwickeln eines einfachen Termin Auswahlmenüs. [done]
[green]=> 18.04.2014[/green]
[/list]

[section]Zeitserver-Synchronisation[/section]

[blue][06.04.2014][/blue] Heute war eine besondere Nacht und meine Augen brennen im Moment, weil sie so spannend war und deshalb der Liedschlag doch oft vor Spannung ausblieb.

Ich habe eine Methyode gefunden, in der Porteus 2.1 Version eine Zeitserversynchronisation nachzubauen mit einem einfachen Perl Skript, das ich mir als freie Source von Tim Hogard ([url=http://www.abnormal.com/~thogard/ntp/]Source Code[/url]) ausgeliehen und auf unsere Bedürfnisse angepaßt und um das Setzen der Zeit erweitert habe. Es funktioniert schon, muß aber noch in unsere Umgebung integriert werden und heißt dann passender [b]ntpsync.pl[/b].

Ein ntp-Paket aus der Slackware 14.0, die für unser System passen sollte, lies sich erst ganz einfach installieren (activate), aber dann waren die Binaries nicht ausführbar. Eine vom Paketnamen her noch besser passende Version, war im Internet nicht mehr aufzufinden. Da habe ich kurzfristig beschlossen, daß wir die Synchronisation mit Hilfe eines perl-Skriptes leber machen und der Aufwand ist lange nicht so groß, wie bei der Entwicklung eines zum Betriebssystem passenden Paketes und ist sogar Linux weit einsetzbar und immer gleich bei unserem Paket dabei. Ich denke, daß ich die Sychnchronisation in der Nacht machen werde, etwa in der Zeit, wenn admin.pl läuft und die Datenbank beschneidet und die Logdatei auf .log.1 kopiert. In dieser Zeit stört eine Korrektur von wenigen Sekunden nicht.

Volgende Bedingungen müssen für eine Zeitkorrektur erfüllt sein:

[list=1]
[*] Die Zeitsynchronisierung darf nicht zur vollen Viertelstunde laufen. [rejected]
[*] Sie darf nicht ausgeführt werden, wenn mehr als eine Minute korrigiert werden. Dann ist eine Fehlermeldung ins Protokoll zu schreiben. [rejected]
[*] ntpsync.pl muß bei einem Vorstellen der Systemuhr so lange angehalten werden, bis die Zeitdifferenz wieder verstrichen ist, damit in der Datenbank durch das Skript commander.pl nicht "zeitgleiche" Datenbankeinträge getätigt werden, die später nicht mehr korrekt ausgewertet werden können. [done]
[*] Alternativ kann auch vor Schreiben in die Datenbank gefragt werden ob für die aktuelle Minute schon Logeinträge existieren und dann ohne Schreibaktion eine Fehlermeldung ins Logfile geschrieben werden. [rejected]
[/list]

[code]
#!/usr/bin/perl
# ntpdate.pl

# For better clock management see the offical NTP info at:
# http://www.eecis.udel.edu/~ntp/

$HOSTNAME="0.europe.pool.ntp.org";
$PORTNO=123;			# NTP is port 123
$MAXLEN=1024;			# check our buffers

use Socket;

# we use the system call to open a UDP socket
socket(SOCKET, PF_INET, SOCK_DGRAM, getprotobyname("udp")) or die "socket: $!";

# convert hostname to ipaddress if needed
$ipaddr   = inet_aton($HOSTNAME);
$portaddr = sockaddr_in($PORTNO, $ipaddr);

# build a message.  Our message is all zeros except for a one in the protocol version field
# $msg in binary is 00 001 000 00000000 ....  or in C msg[]={010,0,0,0,0,0,0,0,0,...}
# it should be a total of 48 bytes long
$MSG="\010"."\0"x47;

# send the data
send(SOCKET, $MSG, 0, $portaddr) == length($MSG)
or die "cannot send to $HOSTNAME($PORTNO): $!";
print "sent message\n";

$portaddr = recv(SOCKET, $MSG, $MAXLEN, 0)      or die "recv: $!";
# !!! Todo: timeout & or die exit !!!
print "received message\n";
($portno, $ipaddr) = sockaddr_in($portaddr);
$host = gethostbyaddr($ipaddr, AF_INET);
print "$host($portno) said:\n";
# We get 12 long words back in Network order
@l=unpack("N12",$MSG);
foreach(@l) {
   printf("%08x ",$_);
   print "\n" if($x++%4==3);
}

# The high word of transmit time is the 10th word we get back
# tmit is the time in seconds not accounting for network delays which should be
# way less than a second if this is a local NTP server
$tmit=$l[10];	# get transmit time
print "tmit=$tmit\n";

# convert time to unix standard time
# NTP is number of seconds since 0000 UT on 1 January 1900
# unix time is seconds since 0000 UT on 1 January 1970
# There has been a trend to add a 2 leap seconds every 3 years.  Leap
# seconds are only an issue the last second of the month in June and
# December if you don't try to set the clock then it can be ignored but
# this is importaint to people who coordinate times with GPS clock
# sources.
$tmit-= 2208988800;
printf("%d\n", $tmit);

# use unix library function to show me the local time (it takes care of
# timezone issues for both north and south of the equator and places that
# do Summer time/ Daylight savings time.
print scalar localtime ($tmit);
print "\n";

# compare to system time
$t=time();
print " $t  $tmit ",$t-$tmit,"\n";

# set hwclock and sync system clock afterwards
($sec,$min,$hour,$mday,$mon,$year,$wday,$yday,$isdst) = localtime ($tmit);
$tstr = sprintf("%d-%d-%d %02d:%d:%02d",
                $year+1900,$mon+1,$mday,$hour,$min,$sec);
print "sudo /sbin/hwclock --set --date=\"$tstr\"\n";
system ("sudo /sbin/hwclock --set --date=\"$tstr\"");
print  "sudo /sbin/hwclock --hctosys\n";
system ("sudo /sbin/hwclock --hctosys");
[/code]

Macht die Ausgabe:

[code=ini]
thomas@idefix:~/box$ ./ntpdate.pl
sent message
received message
ntp-ext.cosng.net(123) said:
0c0203e9 00000042 000005d2 92d503b5
d6eb9a45 4b9e1dc0 00000000 00000000
d6eb9b12 f1f7e6c0 d6eb9b12 f1fb48bd
tmit=3605764882
1396776082
Sun Apr  6 11:21:22 2014
 1396776082  1396776082 0
sudo /sbin/hwclock --set --date="2014-4-6 11:21:22"
sudo /sbin/hwclock --hctosys
thomas@idefix:~/box$
[/code]

Es ist schon spät, aber ein erfolgreicher Tag liegt hinter mir, der zugegebener Weise erst heute im Nachmittag begann. Die Integration in meine Umgebung ist noch nicht komplett abgeschlossen, aber der Vorgang nähert sich dem Ende.

Hier ein Protokolleintrag, der einen normalen Verlauf im Debugmodus zeigt.

[code=ini]
[2014-04-06 22:42:49+02:00] [ntpsync.pl] [debug] Set Debug ON. Debug message talking about reading config file could not be written to log. Don't worry, that's not a bug!
[2014-04-06 22:42:49+02:00] [ntpsync.pl] [notice] Time sync active ...
[2014-04-06 22:42:49+02:00] [ntpsync.pl] [debug] Try to retrieve data from Time Server ...
[2014-04-06 22:42:49+02:00] [ntpsync.pl] [debug] sent message
[2014-04-06 22:42:49+02:00] [ntpsync.pl] [debug] received message
[2014-04-06 22:42:49+02:00] [ntpsync.pl] [debug] kitty.zeroloop.net(123) said:
[2014-04-06 22:42:49+02:00] [ntpsync.pl] [debug]    0c0203eb 0000032b 00000e32 c05d0214
[2014-04-06 22:42:49+02:00] [ntpsync.pl] [debug]    d6ec33e8 767addc9 00000000 00000000
[2014-04-06 22:42:49+02:00] [ntpsync.pl] [debug]    d6ec3ac9 449d0634 d6ec3ac9 44a37652
[2014-04-06 22:42:49+02:00] [ntpsync.pl] [debug] NTP number of secs since [0000 UT on 1 January 1900]: 3605805769
[2014-04-06 22:42:49+02:00] [ntpsync.pl] [debug] UNIX std time secs since [0000 UT on 1 January 1970]: 1396816969
[2014-04-06 22:42:49+02:00] [ntpsync.pl] [debug] Sun Apr  6 22:42:49 2014
[2014-04-06 22:42:49+02:00] [ntpsync.pl] [debug] before recv = 1396816969  after recv = 1396816969  difference = 0
[2014-04-06 22:42:49+02:00] [ntpsync.pl] [debug] UNIX time   = 1396816969  NTP time   = 1396816969  difference = 0
[2014-04-06 22:42:49+02:00] [ntpsync.pl] [debug] before recv = 1396816969  NTP time   = 1396816969  difference = 0
[2014-04-06 22:42:49+02:00] [ntpsync.pl] [debug] after recv  = 1396816969  NTP time   = 1396816969  difference = 0
[2014-04-06 22:42:49+02:00] [ntpsync.pl] [debug] sudo /sbin/hwclock --set --date="2014-4-6 22:42:49"
[2014-04-06 22:42:49+02:00] [ntpsync.pl] [debug] sudo /sbin/hwclock --hctosys
[2014-04-06 22:42:49+02:00] [ntpsync.pl] [debug] ... done
[/code]

Hier habe ich durch einen intensiven Download einer großen Datei einen Timeout beim Empfangen der Antwort vom Zeitserver provoziert. Mal sehen, was morgen also noch dazu kommt. Auf jeden Fall muß ich noch entscheiden, in welchem Fall überhaupt synchronisiert wird und eben dann auch bei einer negativen Korrektur, d.h. Uhr zurückstellen, die Zeit, die zurückgestellt wurde abwarten, damit im Logfile und in der Datenbank kein Wirrwarr entsteht.

[code=ini]
[2014-04-06 22:36:35+02:00] [ntpsync.pl] [debug] Set Debug ON. Debug message talking about reading config file could not be written to log. Don't worry, that's not a bug!
[2014-04-06 22:36:35+02:00] [ntpsync.pl] [notice] Time sync active ...
[2014-04-06 22:36:35+02:00] [ntpsync.pl] [debug] Try to retrieve data from Time Server ...
[2014-04-06 22:36:35+02:00] [ntpsync.pl] [debug] sent message
[2014-04-06 22:36:36+02:00] [ntpsync.pl] [error] recv error: Timed Out at ./ntpsync.pl line 68.
[/code]

overall.ini hat eine Ergänzung erhalten:

[code]
[General]
debug   = "On"
ntpSync = "On"
[/code]

Damit natürlich auch overall.conf:

[code]
{
   "General" : {
      "ntpSync" : 1,
      "debug" : 1
   }
}
[/code]

[blue][08.04.2014][/blue] Nun bin ich schon sehr weit mit den Arbeiten an der Zeitsynchronisation. Was mir auffällt ist, daß es fast nicht möglich ist, die Systemuhr so exakt einzustellen, daß fast immer eine Sekunde zurückzustellen ist, auch wenn man die Aufrufe direkt hintereinander laufen läßt. Das liegt meiner Meinung nach zum einen in dem Laufzeitverhalten des gesamten Systems begründet, das aufgrund seiner Beschaffenheit als Livedateisystem jede Menge Hintergrundorganisation durchführt, damit Änderungen an Dateien auf der RAM-Disk später mit einem ordentlichen Shutdown oder einem dump-session unter der Kennung root auf der Flashdisk persistent gemacht werden können. Auf der anderen Seite liegt es aber auch an dem Laufzeitverhalten der Implementierungsumgebung, die ich gewählt habe. Mit Perl als Interpreter und einem notwendigen zweimaligen Aufruf des Betriebssystembefehls hwclock über die system-Funktion von Perl, die eine neue Shell für die Ausführung jedes Befehls öffnet, geht auch viel Laufzeit verloren. Was mir aber nicht in den Kopf gehen will ist, daß ich aber immer zurückstellen muß, da doch die Uhr verzögert auf eine bereits vergangene Uhrzeit gestellt wird. Ich nehme mir aber nun nicht ernsthaft Zeit, dieses Problem bis zuende zu lösen. Wir hatten bisher eine um ein paar Minuten vorauslaufende Uhr. Wenn ich die Uhr in dem Admin-Programm jede Nacht einmal stelle, dann wird das genug sein. Wir können die Sache also weiter "aggresiv" beobachten (Spruch meines Onkels, den er mit einem Augenzwinkern tätigt, wenn eine Sache, die sein Patient als schlimm empfindet, seiner Meinung nach aber eigentlich nicht behandlungsbedürftig ist, um diesen Patienten zu beruhigen und zum lächeln zu bringen).

Ok, ich konnte es nicht lassen. Ich habe die Differenz zwischen NTP- und LINUX-Zeit von 2.208.988.800 um eins auf 2.208.988.801 erhöht und alles läuft, wie geschmiert. Es hat mit den Schaltsekunden zu tun, von denen alle 3 Jahre eine im Juni und eine im Dezember eingefügt werden. Ich würde mich nicht wundern, wenn das Datum LINUX Ausgabe und das der nachfolgenden Schaltsekundenkorrekturen inzwischen auseinander gelaufen ist!!! Juchuuuu!!!

[code=ini]
thomas@idefix:~/box$ ./catlog.sh
[2014-04-09 14:39:16+02:00] [admin.pl] [notice] --------------------------------------------------------------------------------
[2014-04-09 14:39:16+02:00] [admin.pl] [notice] Start admin tasks for now ...
[2014-04-09 14:39:16+02:00] [admin.pl] [notice] Doing database tasks ...
[2014-04-09 14:39:16+02:00] [admin.pl] [notice] Setting system clock ...
[2014-04-09 14:39:16+02:00] [admin.pl] [notice] It's time to sync time with udp://0.europe.pool.ntp.org:123 ...
[2014-04-09 14:39:16+02:00] [admin.pl] [notice] got answer from udp://ntp-02.sonnit.dk:123
[2014-04-09 14:39:16+02:00] [admin.pl] [notice] nothing to synchronize !!!
[2014-04-09 14:39:16+02:00] [admin.pl] [notice] Admin tasks completed !!!
[2014-04-09 14:39:16+02:00] [admin.pl] [notice] --------------------------------------------------------------------------------
thomas@idefix:~/box$
[/code]

Und der Programmcode schaut nun so aus:

[code]
package tlib::tntpsync;

require Exporter;
@ISA = (Exporter);
@EXPORT = qw(ntp_sync);

use strict;
use Socket;
use tlib::tlog;

sub ntp_sync {

   # best NTP server pool choice, only change, when install this software outside Europe
   my $HOSTNAME = "0.europe.pool.ntp.org";
   my $PORTNO   =  123;       # NTP is port 123
   my $MAXLEN   = 1024;       # check our buffers

   notice 'It\'s time to sync time with "udp://'.$HOSTNAME.':'.$PORTNO.'" ...';

   my ($host,$portno,$ipaddr,$portaddr,$tmit,$systime,$len,$diff,$wait);
   my ($sec,$min,$hour,$mday,$mon,$year,$wday,$yday,$isdst,$tstr);
   my @list;

   # we use the system call to open a UDP socket
   socket(SOCKET, PF_INET, SOCK_DGRAM, getprotobyname("udp")) or die 'socket: '.$!;

   # convert hostname to ipaddress if needed
   $ipaddr   = inet_aton($HOSTNAME)
      or die 'inet_aton: '.$!;
   $portaddr = sockaddr_in($PORTNO, $ipaddr)
      or die 'sockaddr_in: '.$!;

   # build a message.  Our message is all zeros except for a one in the protocol version field
   # $msg in binary is 00 001 000 00000000 ....  or in C msg[]={010,0,0,0,0,0,0,0,0,...}
   # it should be a total of 48 bytes long
   my $MSG = "\010"."\0"x47;

   # send the data
   $len = send(SOCKET, $MSG, 0, $portaddr)
      or die 'send: '.$!;
   $len == length($MSG)
      or die 'send: could not send full length of telegram';

   eval {
      local $SIG{ALRM} = sub { die 'Timed Out'; };
      alarm 30;
      ($portaddr = recv(SOCKET, $MSG, $MAXLEN, 0)) or die $!;
      alarm 0;
   };
   alarm 0;
   die 'recv: '.$@ if($@);

   # get system time
   $systime = time();

   # get details to write a informative message to the log file
   ($portno, $ipaddr) = sockaddr_in($portaddr);
   $host = gethostbyaddr($ipaddr, AF_INET);
   $host = "[unknown]" if(!$host);

   notice 'got answer from "udp://'.$host.':'.$portno.'"';

   # We get 12 long words back in Network order
   @list = unpack("N12",$MSG);
   if($debug_on) {
      my $t = "   "; my $x = 0;
      foreach(@list) {
         $t .= sprintf("%08x ",$_);
         if($x++%4 == 3) { debug $t; $t = "   "; }
      }
   }

   # The high word of transmit time is the 10th word we get back
   # tmit is the time in seconds not accounting for network delays which should be
   # way less than a second if this is a local NTP server
   ($tmit = $list[10]) or die 'recv message corrupted';

   debug sprintf("NTP number of secs since [0000 UT on 1 January 1900]: %u", $tmit);

   # convert time to unix standard time
   # NTP is number of seconds since 0000 UT on 1 January 1900
   # unix time is seconds since 0000 UT on 1 January 1970
   # There has been a trend to add a 2 leap seconds every 3 years.  Leap
   # seconds are only an issue the last second of the month in June and
   # December if you don't try to set the clock then it can be ignored but
   # this is importaint to people who coordinate times with GPS clock
   # sources.
   $tmit -= 2_208_988_800;
   #$tmit -= 2_208_988_801; # 1 leap second ... better to have an automation here ;-)
   #$tmit -= 2_208_988_802; # 2 leap seconds ... better to have an automation here ;-)
   debug sprintf("UNIX std time secs since [0000 UT on 1 January 1970]: %u", $tmit);

   # use unix library function to show me the local time (it takes care of
   # timezone issues for both north and south of the equator and places that
   # do Summer time/ Daylight savings time.
   debug scalar localtime ($tmit);

   # compare to system time
   $diff = $systime - $tmit;
   debug sprintf("UNIX time = %d  NTP time = %d  difference = %d",
                 $systime, $tmit, $diff);

   if (abs($diff) > 0) {
      if (abs($diff) > 6*60) {
         die 'difference too big ('.$diff.'), please configure manualy !!!';
      }

      # set hwclock and sync system clock afterwards
      ($sec,$min,$hour,$mday,$mon,$year,$wday,$yday,$isdst) = localtime($tmit+1);
      $tstr = sprintf("%d-%d-%d %d:%d:%d",
                      $year+1900,$mon+1,$mday,$hour,$min,$sec);

      debug 'will do: sudo /sbin/hwclock --set --date="'.$tstr.'"';
      debug '    and: sudo /sbin/hwclock --hctosys';
      if ($diff > 0) {
         $wait = abs($diff) + 5;
         debug sprintf("will have to be silent for %d seconds ...", $wait);
      }

      system("sudo /sbin/hwclock --set --date=\"$tstr\"") == 0
         or die 'unable to set hwclock';

      system("sudo /sbin/hwclock --hctosys") == 0
         or die 'unable to sync system clock';

      if ($diff > 0) {
         sleep($wait);
         debug 'awaked again, have a happy time ;-) ...';
      }
      notice sprintf("set system clock %d second(s) %s !!!",
                     abs($diff), (($diff>0)?'backward':'forward'));
   } else {
      notice 'nothing to synchronize !!!';
   }
}

1;
[/code]

[red]BTW: Unser System basiert auf Porteus 2.1 und es gibt keinen automatischen Update Service. Das ist für ein solches System, das als embedded System laufen soll auch das Beste!!! So bin ich auch der Überzeugung, daß wir nicht vorschnell auf Porteus 3.0 gehen sollten, auch wenn es dort ein NTP-Sycnchonisationsmodul gibt, das man dazu laden kann. Stabilität ist das vordringlichste. Vielleicht wechseln wir auf eine nächste Porteusversion, wenn wir mal auf eine andere Systemhardware umsteigen. Da gibt es inzwischen vollständige LINUX-'PCs', die in einem eigenen Gehäuse nur ein paar Zentimeter abmessen und keine Lüftung brauchen. Damit würden sie auch bequem im Elektroschrank unterkommen, evtl. sogar auf die selbe Platte, auf der jetzt die beiden Controllerplatinen untergebracht sind. Kostenpunkt einer solchen Aktualisierung ca. 25-50 Euro incl. Gehäuse.[/red]

Was noch zu tun ist:

[list]
[*] Übertragen und testen der Skripte, die die Synchronisation mit einbeziehen. [done]
[*] Persistent machen der Applikation und ein ordentlicher reboot als Test. [done]
[*] Ein kontrolliertes Stecker ziehen (Stromausfallsimmulation). [postponed]
[/list]

[section]Statistik: Lesen der Logdaten und Erzeugen der Grafik[/section]

[blue][09.04.2014][/blue] Ehrlich gesagt, weiß ich nicht mehr, was ich an diesem Tag geschafft habe, aber ...

[blue][16.04.2014][/blue] Ein Tag voller Auf- und Ab's. Die DSL/ISDN(VOIP)-Leitung wurde geschaltet und nur eine einzige Kabelkombination, die ich sogar noch in meinem Vorrat hatte, war gut genug, das Signal korrekt bis zu meinem Schreibtisch zu bringen. Zwei Kabel umsonst angeschafft, eines zurückgebracht, das andere wartet an der Wohnungstüre um  bei Saturn gegen Geld umgetauscht zu werden. Hoffentlich geht das noch. Jetzt geht alles soweit und ein ISDN Telefon kommt in den nächsten Tagen von CONRAD per Post. Ein Fax-Gerät habe ich nicht und einen Fax-Server tue ich mir nicht an. Ich nutze simple-fax.de für 7 Cent die Seite. Das funktioniert in beiden Richtungen perfekt über mein eMail-Konto. Was wäre da noch zu sagen? Alle neuen Kommunikationsdaten findet Ihr auf [local=contact.txt]meiner Kontakt Seite[/local].

[blue][18.04.2014][/blue] ... heute morgen habe ich die vorerst letzte Korrektur an einer vorläufigen Version der Statistik getätigt. Es ging heute noch darum, daß keine Termine mehr zur Auswahl gestellt werden, deren Logdaten schon gelöscht wurden. Das habe ich nach ein wenig Forschen in einem Befehl abhandeln können: Stolz! Darf an dieser Stelle sein, denn ich finde es nicht leicht in den vielen Foren gescheite Hilfe zu bekommen ohne auch nur einen Thread aufzumachen.

[code]
DELETE FROM k
  USING cKalender as k
LEFT OUTER JOIN circLog as l
  ON k.cKalId = l.cKalId WHERE l.cKalId is NULL
[/code]

So schaut jetzt der Logeintrag aus. Es wurden also alle alten Termineinträge erfolgreich gelöscht!!! Die Logeinträge wurden ja schon heute um Mitternacht gelöscht. Und man kann nebenbei noch leicht erkennen, daß die Uhr von unserer kleinen schwarzen Box immer munter voraus eilt.

[code=ini]
[2014-04-18 10:08:42+02:00] [admin.pl] [notice] --------------------------------------------------------------------------------
[2014-04-18 10:08:42+02:00] [admin.pl] [notice] Start admin tasks for now ...
[2014-04-18 10:08:42+02:00] [admin.pl] [notice] Doing database tasks ...
[2014-04-18 10:08:42+02:00] [admin.pl] [notice] Deleted 0 entries from database table circLog ...
[2014-04-18 10:08:42+02:00] [admin.pl] [notice] Deleted 0 entries from database table sensLog ...
[2014-04-18 10:08:44+02:00] [admin.pl] [notice] Deleted 14 entries from database table cKalender ...
[2014-04-18 10:08:44+02:00] [admin.pl] [notice] Setting system clock ...
[2014-04-18 10:08:44+02:00] [admin.pl] [notice] It's time to sync time with "udp://0.europe.pool.ntp.org:123" ...
[2014-04-18 10:08:44+02:00] [admin.pl] [notice] got answer from "udp://service1-eth3.debrecen.hpc.niif.hu:123"
[2014-04-18 10:08:51+02:00] [admin.pl] [notice] set system clock 2 second(s) backward !!!
[2014-04-18 10:08:51+02:00] [admin.pl] [notice] Admin tasks completed !!!
[2014-04-18 10:08:51+02:00] [admin.pl] [notice] --------------------------------------------------------------------------------
[/code]

Und ausprobieren könnt Ihr die Statistiken [local=statistics.php]hier[/local]. Viel Spaß dabei.

[blue][15.05.2014][/blue] Wechselhaftes Wetter begleitet die Pause, die ich seit der Fertigstellung der Statistikfunktionen eingelegt habe. Auch das sqlGate habe ich eingebunden und es funktioniert bestens. Eine nette Funktion sagt mir, wieviel Prozent der letzten 5 Tage bis zur aktuellen Stunde in allen Heizkeisläufen geheizt wurde. Diese Statistik möchte später noch verfeinern.

[local=sqlgate/dosql.php?sqlstmt=select%20count(*)%20as%20Zyklen_gesamt,sum(relay)%20as%20Zyklen_geheizt,sum(relay)/count(*)*100%20as%20Prozent_geheizt%20from%20circLog&mode=values&format=html]Ergebnis: So sieht's aus[/local]
[code]
select
 count(*) as Zyklen_gesamt,
 sum(relay) as Zyklen_geheizt,
 sum(relay) / count(*) * 100 as Prozent_geheizt
from circLog
[/code]

Für das Ausprobieren der sqlGate-Funktion und zum Exportieren von Daten, also Schreiben eigener select-Statements hier noch einmal die aktuelle Datenstruktur.

[code]
DROP DATABASE IF EXISTS idata;
CREATE DATABASE idata;
DEFAULT CHARSET=latin1 COLLATE=latin1_german2_ci;
USE idata;
GRANT USAGE ON *.* TO 'iadmin'@'localhost' IDENTIFIED BY PASSWORD '*****************************************';
GRANT SELECT, INSERT, UPDATE, DELETE ON `idata`.* TO 'iadmin'@'localhost';
GRANT USAGE ON *.* TO 'iguest'@'localhost';
GRANT SELECT ON `idata`.* TO 'iguest'@'localhost';

CREATE TABLE `circLog` (
    `jMinute`     bigint(10) unsigned  NOT NULL,
    `relay`       tinyint(1)           NOT NULL,
    `actual`      float                NOT NULL,
    `cKalId`      bigint(14) unsigned  DEFAULT NULL,
    `circId`      char(20)             NOT NULL,
   KEY `jMinute` (`jMinute`),
   UNIQUE KEY `jMinCirc` (`jMinute`,`circId`)
);
CREATE TABLE `cKalender` (
    `cKalId`      bigint(14) unsigned  NOT NULL,
    `jMinBegin`   bigint(10) unsigned  NOT NULL,
    `jMinEnd`     bigint(10) unsigned  NOT NULL,
    `longText`    varchar(80)          NOT NULL,
    `shortText`   varchar(40)          NOT NULL,
   UNIQUE KEY `cKalId` (`cKalId`)
);
CREATE TABLE `circuit` (
    `circId`      char(20)             NOT NULL,
    `correction`  float                NOT NULL,
    `moldProt`    float                NOT NULL,
    `roomTemp`    float                NOT NULL,
    `longName`    varchar(30)          NOT NULL,
    `shortName`   varchar(8)           NOT NULL,
   UNIQUE KEY `circId` (`circId`)
);

CREATE TABLE `sensLog` (
    `jMinute`     bigint(10) unsigned  NOT NULL,
    `relay`       tinyint(1)           NOT NULL,
    `actual`      float                NOT NULL,
    `sensId`      char(20)             NOT NULL,
   KEY `jMinute` (`jMinute`),
   UNIQUE KEY `jMinSens` (`jMinute`,`sensId`)
);
CREATE TABLE `sensor` (
    `sensId`      char(20)             NOT NULL,
    `correction`  float                NOT NULL,
    `longName`    varchar(30)          NOT NULL,
    `shortName`   varchar(8)           NOT NULL,
   UNIQUE KEY `sensId` (`sensId`)
);
[/code]

Die nächste Aktion wird sein, die Statistikdaten regelmäßig auf ein entferntes Datenbanksystem zu übertragen und dort die Statistik-Webfunktionaltität ebenfalls zu installieren. Mal sehen...

[blue][23.05.2014][/blue] Heute habe ich die Arbeiten an der Statistikfunktionalität mit einer Fehlerkorrektur abgeschlossen und noch einmal wesentlich in der Softwarequalität und Lesbarkeit zugelegt. Ich bin bis auf ein paar Stellen, die ich in der Datei graphics.php notiert habe, von der Sache nun überzeugt und freue mich schon auf das nächste Teilziel! Bei den noch verbleibenden Stellen in der Datei graphics.php handelt es sich um die Threadholds, der Nutzungs- (20,5 Grad) und Schimmelschutztemperatur (14 Grad) und auch die Schrittweite der Meßwerterfassung (15 Minuten), die bisher statisch vorgeben werden. Diese Werte sollten normaler Weise im letzten Fall aus der Konfigurationsdatei ermittelt werden. Die Konfigurationsdatei ist aber auf dem Statistikserver, der jetzt im nächsten Schritt zu bauen ist, nicht verfügbar. Vielleicht kann man diesen Mangel durch einen zu entwickelnden WebService, der diesen oder auch andere Konfigurationswerte bereit stellt, beheben. [red] Die Temperaturen können jedoch pro Circuit (Heizkreislauf) aus der Datenbank ermittelt werden. Fraglich bleibt, was dann bei einer Darstellung von mehreren Heizkreisläufen darzustellen wäre.[/red]

[section]Implementierung des Statistik-WebServers[/section]

[blue][24.05.2014][/blue] Jetzt geht's wieder richtig zur Sache. Das sqlgate kommt nun richtig zum Tragen, soweit ich nicht eine andere Möglichkeit des Exports aus der Datenbank finde. Aber nun noch einmal ganz von vorn und zum Mitschreiben:

Der Statistik-WebServer soll regelmäßig die Statistikdaten aus der Box exortieren und in eine eigene Datenbank importieren. Auf dem WebServer werden die bereits implementierten Statistikfunktionen installiert. Dazu wird ein Abbild der bisherigen Box-Webanwendung auf den Statistik-WebServer kopiert und entsprechend um die Box internen Funktionen abgespeckt. Ziel ist es, die Statistikdaten über die bisher eingestellten 5 Tage hinaus verfügbar zu machen. Da der Server schneller arbeitet als die Box und eine schnellere Anbindung hat, wird die Erzeugung der Grafiken auch flüssiger von Statten gehen.

Ich stelle mir vor, daß der Statistik-WebServer auf Hans-Peters NAS-Laufwerk installiert werden kann. Während der Implementierungs- und Testphase jedoch wird der Server auf meinem Entwicklungsrechner laufen. Das erspart mir auch den andauernd notwendigen Upload pro Entwicklungszyklus, die bei mir erfahrungsgemäß sehr kurz sind.

[blue][29.05.2014][/blue] Gestern und heute bin ich aus lauter Verzweiflung über fachfremde Angelegenheiten voll in die Programmierung eingestiegen und dabei über einige selbst gelegte Fallstricke gestolpert, was mich sehr gefordert und damit abgelenkt hat.

Die Situation in aller Kürze: Ziel ist, daß die gesamte Webseite der Box 1 zu 1 auf dem NAS gespiegelt werden und dennoch auf beiden Rechnern gleich gut funktionieren soll. Dazu sind viele kleine Änderungen notwendig, die jedoch auch viel Zeit in Anspruch nehmen, weil die Verhaltensweisen der Laufzeitsysteme unterschiedlicher Versionen unterschiedlich bei Zugriffen auf lokale oder ferne Dateien zeigen und auf diese universal reagiert werden muß.

[list]
[*] Cachedateien für die Darstellung im WEB in den Webspace auf der BOX verlegen, damit ein Zugriff von außen genauso gut möglich ist, wie von der Box selbst. [done]
[*] Status-Seite auf fernen und lokalen Zugriff umstellen! [red]Problem: Ferner Zugriff Timeout kommt mit undefiniertem Ergebnis zurück!!![/red]
[*] Live-Ansicht auf fernen und lokalen Zugriff umstellen! [red]Problem: Ferner Zugriff Timeout kommt mit undefiniertem Ergebnis zurück!!![/red]
[*] Statistik-Seite mit Kalenderfunktion ausstatten, da auf dem NAS alle Daten gesammelt werden und damit eine Übersicht von vielen Monaten möglich wird. Diese Ansicht soll immer drei Monate (initial einschließlich des aktuellen Monats) darstellen. Jeder Tag ist anclickbar bis zum aktuellen Tag und jeder Tag mit Terminen bekommt eine andere Farbe als ohne Termine. Tage in der Zukunft werden ausgegraut. Dort wird Link hinterlegt.
[*] Sammeln der Statistikdaten von der BOX auf das NAS.
[*] Regelmäßige Übertragung der WebCache-Dateien in den WebCache auf dem NAS.
[/list]

[blue][24.05.2014][/blue] Heute haben Hans-Peter und ich die NAS/Router-Konfiguration gemeistert. Das Ergebnis:

[code]
Öffentlicher | Privater | Art der Verwendung           | Zugeordnete
Port         | Port     | Applikation                  | IP-Adresse
-------------+----------+------------------------------+-------------
TCP: 21-22   | 21-22    | NAS FTP/SSH                  | 192.168.2.10
TCP: 80      | 8088     | NAS HTTP (Heizungssteuerung) | 192.168.2.10
TCP: 8080    | 8080     | NAS Konfigurator             | 192.168.2.10
TCP: 8081    | 80       | NAS MySQL Konfigurator       | 192.168.2.10
[/code]

[blue][08.06.2014][/blue] Heute habe ich einen neuen Schüler bekommen. Einer meiner Brüder braucht eine Ausbildung in SQL und ich habe Gott sei Dank gerade ein Grundlagenbuch darüber studiert um mich für eine Hausaufgabe für meinen jüngeren Sohn fit zu machen. Das kommt doch jetzt ganz gut... Und ... es ist auch gut für unser Projekt, denn ich kann mit dem aufgefrischten Basiswissen noch einmal über unser Datenbankschema gehen und ein paar Dinge effizienter und besser machen, aber zuvor soll erst einmal die Sache mit dem Abruf der Daten von der BOX auf das NAS funktionieren und das mit dem sqlGate, das ich selbst geschrieben habe.

[blue][12.06.2014][/blue] Daß es dann doch so einfach wurde, hätte ich nicht gedacht. Über viele Umwege habe ich nun eine recht einfache Möglichkeit gefunden, die Daten von der BOX auf das NAS zu holen und gleichzeitig regelmäßíg Log- und Statusdateien auf dem NAS zu spiegeln.

Hier ein Testprogramm auf Seiten des NAS ...

[code]
#!/usr/bin/perl -w
use strict;
use warnings;

use LWP::UserAgent;

my $ua = LWP::UserAgent->new;

my $server_endpoint = "http://vitus.myftp.org/~thomas/content/cache/service.cgi";
$server_endpoint = "http://localhost/thomas/Iffeldorf/html/content/cache/service.cgi";

# set custom HTTP request header fields
my $req = HTTP::Request->new(POST => $server_endpoint);
$req->content_type('application/x-www-form-urlencoded');

# add POST data to HTTP request body
my $post_data = 'f=101&a=3537788895';
$req->content($post_data);

my $resp = $ua->request($req);
if ($resp->is_success) {
   my $message = $resp->decoded_content;
   print "Received reply:\n$message\n";
}
else {
   print "HTTP POST error code: ", $resp->code, "\n";
   print "HTTP POST error message: ", $resp->message, "\n";
}
[/code]

... und hier der Programmtext für den WebService, den ich für die BOX geschrieben habe:

[code]
#!/usr/bin/perl -w
use strict;
use warnings;

use constant LOCAL     => '/home/thomas/local';
use constant CACHE     => '/home/thomas/cache';
use constant CONFFILE  => CACHE.'/config.json';
use constant LOGFILE   => CACHE.'/local.log';
use constant SNAPSHOT  => CACHE.'/snapshot.json';
use constant SHOTFILE  => CACHE.'/snapshot.txt';
use constant TODAYFILE => CACHE.'/today.txt';
use constant WARNFILE  => CACHE.'/warnings.txt';


use Switch;
use File::Slurp;
use Net::MySQL;

use lib LOCAL;
use tlib::tcgi;
use tlib::tjson;
use tlib::tutils;

# -----==== Reading configuration from config.json ====-----
my %config = read_json_file(CONFFILE);

{  # -----==== Switch WebService Functions ====-----
   my $function = (exists($FORM{'function'}) && is_int($FORM{'function'})) ? $FORM{'function'} : 0;

   switch(int($function/100)) {
         case 1 {
            my $mysql = Net::MySQL->new(hostname => $config{General}{database}{hostname},
                                        database => $config{General}{database}{database},
                                        user     => $config{General}{database}{rootUser},
                                        password => $config{General}{database}{rootPass});
            if ($mysql->is_error) {
               my $message = $mysql->get_error_message;
               $mysql->close;
               die $message;
            }
            my $query;
            switch($function % 100) {
               case 1 {
                     my $jMinute = (exists($FORM{'jMinute'}) && is_num($FORM{'jMinute'})) ? $FORM{'jMinute'} : 0;
                     $query = "SELECT `jMinute`,`circId`,`sensor`,`relay`,`cKalId` FROM `circLog` WHERE `jMinute` >= $jMinute;";
                  }
               case 2 {
                     $query = "SELECT `circId`,`correction`,`moldProt`,`roomTemp`,`longName`,`shortName` FROM `circuit`";
                  }
               case 3 {
                     $query = "SELECT `cKalId`,`jMinBegin`,`jMinEnd`,`longText`,`shortText`,`responsible` FROM `cKalender`;";
                  }
               case 4 {
                     my $jMinute = (exists($FORM{'jMinute'}) && is_num($FORM{'jMinute'})) ? $FORM{'jMinute'} : 0;
                     $query = "SELECT `jMinute`,`sensId`,`sensor`,`relay` FROM `sensLog` WHERE `jMinute` >= $jMinute;";
                  }
               case 5 {
                     $query = "SELECT `sensId`,`correction`,`longName`,`shortName` FROM `sensor`;";
                  }
            }
            $mysql->query($query);
            if ($mysql->is_error) {
               my $message = $mysql->get_error_message;
               $mysql->close;
               die $message;
            }
            my $record_iterator = $mysql->create_record_iterator;
            while (my $record = $record_iterator->each) {
               for (my $i = 0; $i < $record_iterator->get_field_length(); $i++) {
                  print "\t" if ($i != 0);
                  print defined($record->[$i]) ? $record->[$i] : 'NULL';
               }
               print "\n";
            }
            $mysql->close;
         }

      case 2 {
            my @filenames;
            switch($function % 100) {
               case 1 { @filenames = (LOGFILE.'.1',LOGFILE); }
               case 2 { @filenames = (SNAPSHOT); }
               case 3 { @filenames = (SHOTFILE); }
               case 4 { @filenames = (TODAYFILE); }
               case 5 { @filenames = (WARNFILE); }
            }
            foreach my $filename (@filenames) {
               print read_file($filename) if (-f $filename);
            }
         }
      case 9 {
            print "Service Ok" if($function % 100 == 99);
         }
   }
}
[/code]

Und hier der Client auf seiten des NAS-Servers:

[code]
#!/opt/bin/perl -w
use strict;
use warnings;

use constant NL => "\n";

use Switch;
use File::Slurp;
use Cwd qw{ abs_path };
use File::Basename qw{ basename dirname };
use List::MoreUtils qw{ any };
use Net::MySQL;


use constant MYSELF    => basename(__FILE__);
use constant PATH      => dirname(abs_path(__FILE__));
use constant LOCAL     => (PATH =~ m/\/local$/) ? 1 : 0;
use constant REMOTE    => (PATH =~ m/\/remote$/) ? 1 : 0;

use constant CACHE     => PATH.'/../cache';

use constant SEMAPHORE => PATH.'/script.lock';
use constant CONFFILE  => CACHE.'/config.json';
use constant LOGFILE   => CACHE.'/remote.log';

use constant BLOGFILE   => CACHE.'/local.log';
use constant BSNAPSHOT  => CACHE.'/snapshot.json';
use constant BSHOTFILE  => CACHE.'/snapshot.txt';
use constant BTODAYFILE => CACHE.'/today.txt';
use constant BWARNFILE  => CACHE.'/warnings.txt';

use lib PATH;
use tlib::tlog;
use tlib::tlock;
use tlib::tjson;
use tlib::tutils;
use tlib::thttpreq;

if (LOCAL && REMOTE || !LOCAL && !REMOTE) {
   die 'Can\'t be LOCAL and REMOTE at the same time !!!';
}
if (LOCAL) {
   die 'This is a only-REMOTE script !!!';
}

# -----==== Setting up skript ====-----
set_lock(SEMAPHORE);
start_logging(LOGFILE, MYSELF);

notice '-' x 80;

# -----==== Reading configuration from overall.conf ====-----
my %config = read_json_file(CONFFILE);
$debug_on = $config{General}{debug};

# -----==== Reading and parsing Setup Skript Options ====-----
my %options = ();
GetOptions("debug"=>\$options{debug},
           "startup"=>\$options{startup},
           "database"=>\$options{database},
           "cache"=>\$options{cache});

if ($options{debug}) {
   notice 'Debug Mode requested manualy !!!' if(!$debug_on);
   $debug_on = 1;
}
if ($options{startup}) {
   notice 'Startup Mode requested !!!';
}
if ($options{database}) {
   notice 'Database Mirror requested !!!';
}
if ($options{cache}) {
   notice 'Cache Mirror requested !!!';
}


if ($options{startup} || $options{database}) {
   # -----==== Mirror Database ====-----
   my $mysql = Net::MySQL->new(hostname => $config{General}{database}{hostname},
                               database => $config{General}{database}{database},
                               user     => $config{General}{database}{rootUser},
                               password => $config{General}{database}{rootPass});
   if ($mysql->is_error) {
      my $message = $mysql->get_error_message;
      $mysql->close;
      die $message;
   }
   for (my $function = 101; $function <= 105; $function++) {
      my $args = "function=$function";
      if ($function == 101 || $function == 104) {
         my $query;
         switch($function % 100) {
            case 1 { $query = "SELECT MAX(`jMinute`) FROM `circLog`"; }
            case 4 { $query = "SELECT MAX(`jMinute`) FROM `sensLog`"; }
         }
         if (defined $query) {
            $mysql->query($query);
            if ($mysql->is_error) {
               my $message = $mysql->get_error_message;
               $mysql->close;
               die $message;
            }
         }
         my $record_iterator = $mysql->create_record_iterator;
         my $record = $record_iterator->each;
         $args .= "&jMinute=$record->[0]";
      }
      my $data = httpRequest($config{General}{service}, $args);
      if (not defined $data) {
         warning 'httpRequest failed for call "'.$args.'" !!!';
      } elsif ($data eq '') {
         warning 'httpRequest data empty for call "'.$args.'" !!!';
      } else {
         debug 'write httpRequest data for call "'.$args.'" ...';
         foreach my $line (split(/\n/, $data)) {
            my @record = split(/\t/, $line);
            my $query;
            switch($function % 100) {
               case 1 {
                     if ($record[4] eq 'NULL') {
                        $query = <<EOT;
                           INSERT INTO `circLog`
                            SET `jMinute` = '$record[0]',
                                `circId`  = '$record[1]',
                                `sensor`  = '$record[2]',
                                `relay`   = '$record[3]',
                                `cKalId`  = NULL
                            ON DUPLICATE KEY UPDATE
                                `sensor`  = '$record[2]',
                                `relay`   = '$record[3]',
                                `cKalId`  = NULL;
EOT
                     } else {
                        $query = <<EOT;
                           INSERT INTO `circLog`
                            SET `jMinute` = '$record[0]',
                                `circId`  = '$record[1]',
                                `sensor`  = '$record[2]',
                                `relay`   = '$record[3]',
                                `cKalId`  = '$record[4]'
                            ON DUPLICATE KEY UPDATE
                                `sensor`  = '$record[2]',
                                `relay`   = '$record[3]',
                                `cKalId`  = '$record[4]';
EOT
                     }
                  }

               case 2 {
                     $query = <<EOT;
                        INSERT INTO `circuit`
                         SET `circId`     = '$record[0]',
                             `correction` = '$record[1]',
                             `moldProt`   = '$record[2]',
                             `roomTemp`   = '$record[3]',
                             `longName`   = '$record[4]',
                             `shortName`  = '$record[5]'
                            ON DUPLICATE KEY UPDATE
                             `correction` = '$record[1]',
                             `moldProt`   = '$record[2]',
                             `roomTemp`   = '$record[3]',
                             `longName`   = '$record[4]',
                             `shortName`  = '$record[5]';
EOT
                  }

               case 3 {
                     $query = <<EOT;
                        INSERT INTO `cKalender`
                         SET `cKalId`      = '$record[0]',
                             `jMinBegin`   = '$record[1]',
                             `jMinEnd`     = '$record[2]',
                             `longText`    = '$record[3]',
                             `shortText`   = '$record[4]',
                             `responsible` = '$record[5]'
                         ON DUPLICATE KEY UPDATE
                             `jMinBegin`   = '$record[1]',
                             `jMinEnd`     = '$record[2]',
                             `longText`    = '$record[3]',
                             `shortText`   = '$record[4]',
                             `responsible` = '$record[5]';
EOT
                  }

               case 4 {
                     $query = <<EOT;
                        INSERT INTO `sensLog`
                         SET `jMinute` = '$record[0]',
                             `sensId`  = '$record[1]',
                             `sensor`  = '$record[2]',
                             `relay`   = '$record[3]'
                            ON DUPLICATE KEY UPDATE
                             `sensor`  = '$record[2]',
                             `relay`   = '$record[3]'
EOT
                  }

               case 5 {
                     $query = <<EOT;
                        INSERT INTO `sensor`
                         SET `sensId`     = '$record[0]',
                             `correction` = '$record[1]',
                             `longName`   = '$record[2]',
                             `shortName`  = '$record[3]'
                            ON DUPLICATE KEY UPDATE
                             `correction` = '$record[1]',
                             `longName`   = '$record[2]',
                             `shortName`  = '$record[3]';
EOT
                  }
            }
            if (defined $query) {
               $mysql->query($query);
               if ($mysql->is_error) {
                  my $message = $mysql->get_error_message;
                  $mysql->close;
                  die $message;
               }
            }
         }
      }
   }

   $mysql->close;
}

if ($options{startup} || $options{cache}) {
   # -----==== Mirror Cache ====-----
   for (my $function = 201; $function <= 205; $function++) {
      my ($filename, $data);
      switch($function % 100) {
         case 1 { $filename = BLOGFILE; }
         case 2 { $filename = BSNAPSHOT; }
         case 3 { $filename = BSHOTFILE; }
         case 4 { $filename = BTODAYFILE; }
         case 5 { $filename = BWARNFILE; }
      }
      $data = httpRequest($config{General}{service}, "f=$function");
      if (not defined $data) {
         warning 'httpRequest failed for "'.$filename.'" !!!';
      } elsif ($data eq '') {
         warning 'httpRequest data empty for "'.$filename.'" !!!';
      } else {
         debug 'write httpRequest data for "'.$filename.'" ...';
         write_file($filename, $data);
      }
   }
}
[/code]

[blue][20.06.2014][/blue] Und nun versuche ich einen größeren Schritt in Richtung UNIX-Konformität der Verzeihnisstruktur, wobei $IHOME das Homeverzeichnis der Anwendung ist, d.h. das HOME des Benutzers der Anwendung. Ich hoffe das gelingt.

[code]
$HOME/local/tlib/tckalender.pm
                 tdate.pm
                 tini.pm
                 tlock.pm
                 tntpsync.pm
                 txml.pm
                 tctrlfile.pm
                 tdenkov.pm
                 tjson.pm
                 tlog.pm
                 tutils.pm
            admin.pl
            commander.pl
            generator.pl
            ntpsync.pl
            setup.pl

            catlog.sh    # zeige tail -f ../var/*.log (fehlt noch!!!)
            cleanup.sh   # loesche rm -f ../var/* ../tmp/*

            config.ini
            crontab.txt

            script.lock
            calender.json
            control.csv

      remote/tlib/tdate.pm
                  tini.pm
                  tlock.pm
                  tjson.pm
                  tlog.pm
                  tutils.pm
             admin.pl
             mirror.pl
             setup.pl (link auf ../local/setuo.pl)

             catlog.sh    # zeige tail -f ../cache/*.log (fehlt noch!!!)
             cleanup.sh   # loesche ???

             config.ini
             crontab.txt

             script.lock

       html/service.cgi
               ...
       cache/config.json
             snapshot.cache
             snapshot.txt
             today.txt
             warnings.txt
             remote.log
             remote.log.1
             local.log
             local.log.1
[/code]

[blue][02.07.2014][/blue] Gestern Abend kommt also eine Mail zu Hans-Peter von NOIP und dort wird die sofortige Abschaltung von Microsoft geclaimten Domains bekannt gegeben. Deshalb gibt es seit gestern keinen Kontakt mehr zu irgendeinem unserer Geräte aus unserem Projekt. Was sagt man dazu???

Hans-Peter hat neue Domains eingetragen:

[code]
Domain                | Verwendung
----------------------+-----------------------------------
nas-hpg.ddns.net      | Hans-Peters NAS-Server
pz-iffeldorf.ddns.net | Black Box (Heizungssteuerung)
stvitus.ddns.net      | frei für eine spätere Verwendung
[/code]

[blue][16.07.2014][/blue] Nun liegt die Fertigstellung der NAS-Software schon einige Tage zurück. Auch die neue Statistik- mit der eingebrachten Kalenderfunktion funktioniert schon ganz passabel. Vielleicht könnte man beim Start der Seite noch das aktuelle Datum sichtbar machen. Mal sehen...

Jetzt aber noch eine kleine Überraschung, die man auch gerne ausbauen kann:

[local=sqlgate/dosql.php?sqlstmt=select%20r.longName%20as%20Rechnungsempfaenger,k.jMinBegin%20as%20Beginn,k.jMinEnd%20as%20Ende,k.shortText%20as%20Veranstaltung%20from%20cKalender%20k%20left%20join%20respMatch%20m%20on%20k.responsible%20=%20m.match%20left%20join%20responsible%20r%20on%20m.respId%20=%20r.respId%20order%20by%20r.respId,k.jMinBegin&mode=values&format=html]Ergebnis: So sieht's aus[/local]
[code]
select
 r.longName as Rechnungsempfaenger,
 k.jMinBegin as Beginn,
 k.jMinEnd as Ende,
 k.shortText as Veranstaltung
from cKalender k
left join respMatch m
  on k.responsible = m.match
left join responsible r
  on m.respId = r.respId
order by
  r.respId, k.jMinBegin;
[/code]

[local=sqlgate/dosql.php?sqlstmt=select%20r.longName%20as%20Rechnungsempfaenger,k.jMinBegin%20as%20Begin,k.jMinEnd%20as%20Ende,%20k.jMinEnd-k.jMinBegin%20as%20Dauer,k.shortText%20as%20Veranstaltung%20from%20cKalender%20k%20left%20join%20respMatch%20m%20on%20k.responsible%20=%20m.match%20left%20join%20responsible%20r%20on%20m.respId%20=%20r.respId%20order%20by%20r.respId,k.jMinBegin&mode=values&format=html]Ergebnis: So sieht's aus[/local]
[code]
select
 r.longName as Rechnungsempfaenger,
 k.jMinBegin as Begin,
 k.jMinEnd as Ende,
 k.jMinEnd-k.jMinBegin as Dauer,
 k.shortText as Veranstaltung
from cKalender k
left join respMatch m
  on k.responsible = m.match
left join responsible r
  on m.respId = r.respId
order by
  r.respId, k.jMinBegin;
[/code]

[local=sqlgate/dosql.php?sqlstmt=select%20r.longName%20as%20Rechnungsempfaenger,sum(k.jMinEnd-k.jMinBegin)%20as%20Summe%20from%20cKalender%20k%20left%20join%20respMatch%20m%20on%20k.responsible=m.match%20left%20join%20responsible%20r%20on%20m.respId=r.respId%20group%20by%20r.longName%20with%20rollup&mode=values&format=html]Ergebnis: So sieht's aus[/local]
[code]
select
 r.longName as Rechnungsempfaenger,
 sum(k.jMinEnd-k.jMinBegin) as Summe
from cKalender k
left join respMatch m
  on k.responsible = m.match
left join responsible r
  on m.respId = r.respId
group by
  r.longName with rollup;
[/code]

[local=sqlgate/dosql.php?sqlstmt=select%20r.longName%20as%20Rechnungsempfaenger,sum(k.jMinEnd-k.jMinBegin)/(select%20sum(k.jMinEnd-k.jMinBegin)%20as%20Summe%20from%20cKalender%20k%20left%20join%20respMatch%20m%20on%20k.responsible%20=%20m.match%20left%20join%20responsible%20r%20on%20m.respId=r.respId)*100%20as%20Anteil%20from%20cKalender%20k%20left%20join%20respMatch%20m%20on%20k.responsible%20=%20m.match%20left%20join%20responsible%20r%20on%20m.respId%20=%20r.respId%20group%20by%20r.longName%20with%20rollup&mode=values&format=html]Ergebnis: So sieht's aus[/local]
[code]
select
 r.longName as Rechnungsempfaenger,
 sum(k.jMinEnd-k.jMinBegin)/(
      select
        sum(k.jMinEnd-k.jMinBegin) as Summe
      from cKalender k
      left join respMatch m
        on k.responsible = m.match
      left join responsible r
        on m.respId = r.respId
    )*100 as Anteil
from cKalender k
left join respMatch m
  on k.responsible = m.match
left join responsible r
  on m.respId = r.respId
group by
  r.longName with rollup;
[/code]

[local=sqlgate/dosql.php?sqlstmt=select%20r.longName%20as%20Rechnungsempfaenger,%20sum(k.jMinEnd-k.jMinBegin)%20as%20Summe,%20sum(k.jMinEnd-k.jMinBegin)/(%20select%20sum(k.jMinEnd-k.jMinBegin)%20as%20Summe%20from%20cKalender%20k%20left%20join%20respMatch%20m%20on%20k.responsible=m.match%20left%20join%20responsible%20r%20on%20m.respId=r.respId%20)*100%20as%20Anteil%20from%20cKalender%20k%20left%20join%20respMatch%20m%20on%20k.responsible=m.match%20left%20join%20responsible%20r%20on%20m.respId=r.respId%20group%20by%20r.longName%20with%20rollup&mode=values&format=html]Ergebnis: So sieht's aus[/local][code]
select
 r.longName as Rechnungsempfaenger,
 sum(k.jMinEnd-k.jMinBegin) as Summe,
 sum(k.jMinEnd-k.jMinBegin)/(
   select
    sum(k.jMinEnd-k.jMinBegin) as Summe
   from cKalender k
   left join respMatch m
     on k.responsible = m.match
   left join responsible r
     on m.respId = r.respId
  )*100 as Anteil
from cKalender k
left join respMatch m
  on k.responsible = m.match
left join responsible r
  on m.respId = r.respId
group by
  r.longName with rollup;
[/code]

Und hier die vorhergehende Abfrage mit den Prozentwerten nicht auf 100 sondern auf 1 normiert.

[local=sqlgate/dosql.php?sqlstmt=select%20r.longName%20as%20Rechnungsempfaenger,%20sum(k.jMinEnd-k.jMinBegin)%20as%20Summe,%20sum(k.jMinEnd-k.jMinBegin)/(%20select%20sum(k.jMinEnd-k.jMinBegin)%20as%20Summe%20from%20cKalender%20k%20left%20join%20respMatch%20m%20on%20k.responsible=m.match%20left%20join%20responsible%20r%20on%20m.respId=r.respId%20)%20as%20Anteil%20from%20cKalender%20k%20left%20join%20respMatch%20m%20on%20k.responsible=m.match%20left%20join%20responsible%20r%20on%20m.respId=r.respId%20group%20by%20r.longName%20with%20rollup&mode=values&format=html]Ergebnis: So sieht's aus[/local][code]
select
 r.longName as Rechnungsempfaenger,
 sum(k.jMinEnd-k.jMinBegin) as Summe,
 sum(k.jMinEnd-k.jMinBegin)/(
   select
    sum(k.jMinEnd-k.jMinBegin) as Summe
   from cKalender k
   left join respMatch m
     on k.responsible = m.match
   left join responsible r
     on m.respId = r.respId
  ) as Anteil
from cKalender k
left join respMatch m
  on k.responsible = m.match
left join responsible r
  on m.respId = r.respId
group by
  r.longName with rollup;
[/code]

[chapter]Phase Wartung & Pflege[/chapter]

[section]Motivation[/section]

Das NAS-Laufwerk, auf dem die Statistikfunktionen laufen, unterstützt im aktuellen Update auf die neue 64bit Betriebssystemvariante PERL nicht mehr. Damit sind wir gezwungen zu handeln.

Zudem sind kleinere Änderungswünsche, Korrekturen und Ergänzungen zu implementieren.

[b]Ideen für die Umsetzung[/b]

[list=1]
[*] Die betroffenen Perl-Skripte mit einem Perl-"Compiler" übersetzen und anschließend auf dem neuen 64bit System zum Laufen bringen. [rejected]
[*] Das Statistiksystem auf einen anderen Rechner bringen und diesen im Pfarrzentrum im Technikraum aufstellen.
[/list]

[b]Notwendige Änderungen / Korrekturen[/b]

[list=1]
[*] Folgt eine Meditation auf einen Gymnastiktermin, soll der Fußboden warm sein, obwohl vorher gelüftet wurde.
[*] Der Außenfühler soll Minusgrade messen können.
[*] Der Update der Systemzeit soll absturzsicher geschehen.
[*] Den Hintergrund der Grafiken auf Weiß setzen.
[/list]

[section]Machbarkeitsstudien[/section]

[blue][30.12.2017][/blue] Ausführen der auf meinem 32bit Linux System erzeugten "Hello Hans-Peter!" Perl-"compilierten" Programms ist auf dem NAS nicht möglich. Ein auf dem NAS compiliertes gleichartiges C-Programm läßt sich problemlos ausführen. Damit fällt die Perl-"Compiler"-Variante aus dem Rennen.

[blue][31.12.2017][/blue] Habe mit Hans-Peter telefoniert und beginne mit der Portierung der Statistikanwendung vom NAS System auf ein herkömmliches Linux (hier Mint 32bit). Es ergeben sich Änderungen, von denen ich in den letzten vielen Monaten nichts mitbekommen habe. Zum Beispiel wird PHP nur noch in der neuesten Version 7 unterstützt. Der Versionshub ist so deutlich, dass sich in der Syntax und der Verarbeitung der Befehle starke Änderungen ergeben. Zudem wird z.B. die funktional gestaltete mysql-Schnittstelle nicht mehr unterstützt. Dadurch ist mein Code in Teilen umzuschreiben.

Inzwischen hat sich auch in der Konfiguration des Apache2 WebServers einiges geändert.

Ein Problem, das ich schon während der Entwicklung der Heizungssteuerung hatte, gehe ich konsequent an, wo es mir auch immer über den Weg läuft. Die Zeichenkodierungen sind in den vielen Dateien nicht einheitlich. So kommt es zur falschen Darstellung von Sonderzeichen. Da bei Skriptsprachen wie PHP eine einheitliche und durchgängige (Aufrufhierarchie der Skripte untereinander) Zeichenkodierung erforderlich ist, da ansonsten Sonderzeichen in Konstanten im Source in verschiedenen Codes erzeugt werden.

[blue][02.01.2018][/blue] Einige kleinere Probleme durchdacht, keine Ahnung mehr welche. Dann war der Plan die Datenbank vom NAS zu exportieren um sie als Testdaten zu verwenden. Das NAS ist so konfiguriert, dass sich phpMyAdmin nicht aufrufen läßt. Egal, ich habe es mit dem PERL-Befehl mysql_dump gemacht und die sql-Datei dann gezippt per ftp zu mir übertragen. mySQL und phpMyAdmin installiert.

[blue][03.01.2018][/blue] Unzip der sql-Datei erfolgreich. Beim Anlaufen der des setup.pl wird klar, dass hier auf dem Rechner noch NET::MySQL fehlt. Es fehlen aber auch noch die System Includes. Also vom 100. ins 1000... wie üblich, nicht schlimm.

[code]*** Vorbereitung ***
sudo -i
sudo apt install libc6-dev
cpan
install Term::ReadKey
install CPAN
reload CPAN
install Term::ReadLine
install Term::ReadLine::Perl
install YAML

*** Installation ***
install Net::MySQL
install JSON
*** It seems you are running perl version 5.022001, likely the "official" or
*** "standard" version. While there is nothing wrong with doing that,
*** standard perl versions 5.022 and up are not supported by JSON::XS.
*** While this might be fatal, it might also be all right - if you run into
*** problems, you might want to downgrade your perl or switch to the
*** stability branch.
Continue anyways?  [y] n[/code]

Noch ein paar Änderungen an setup.pl, z.B. Anlegen des Benutzers iguest. Das hatte noch gefehlt. Danach wurde Benutzer und Datenbank korrekt angelegt. Um die Datenbank umzusetzen auf utf8 (dann können auch alle Sourcen darauf umgestellt werden), habe ich hier schon einmal die Befehle gefunden:

[code]ALTER DATABASE databasename CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
ALTER TABLE tablename CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;[/code]

So, die Datenbank und der User werden nun bei jedem Startup und bei jeder Schema-Reparatur ganz neu erzeugt, nachdem sie für den Fall, dass sie existieren, gelöscht wurden. Das Characterset ist jetzt auf utf8 umgestellt... Alles gut...

Für den Import muss ich aus der dump.sql-Datei des NAS die DROP & CREATE DATABASE & TABLE entfernen, bevor ich den Import wie folgt starte:

[code]mysql --user=root --password iffeldorf < dump.sql[/code]

Das hat den Grund, dass in den CREATE TABLE die CHARSET und COLLATE definiert werden, die im NAS benutzt wurden und damit wird die Datenbank hier total verändert...

Jetzt ist der Import komplett sauber gelaufen!!! Supiiii!!! Im setup.pl hat eine AUTOINCREMENT in der Tabelle "responsible" gestört, das ich mir bei der Entwicklung eingebildet hatte :-(((

Damit stehen die Testdaten für die Portierung der PHP Sourcen auf die neue mySQL-Schnittstelle bereit und die Migration der Datenbank vom NAS auf den neuen Rechner ist vorbereitet.

[blue][04.01.2018][/blue]Seit heute geht es - nach dem letzten Gespräch mit Hans-Peter - um meinen Vorschlag, einen Raspberry PI zu benutzen.

Kontakt zur Datenbank erfolgreich mit folgendem kleinen Testprogramm!!!

[code]
<?php

$mysqli = new mysqli('127.0.0.1', 'iguest', '', 'iffeldorf');

if ($mysqli->connect_errno) {
    echo "Sorry, this website is experiencing problems.";

    echo "Error: Failed to make a MySQL connection, here is why: \n";
    echo "Errno: " . $mysqli->connect_errno . "\n";
    echo "Error: " . $mysqli->connect_error . "\n";

    exit;
}

$sql = "SELECT sensId, shortName, longName FROM sensor;";
if (!$result = $mysqli->query($sql)) {
    echo "Sorry, the website is experiencing problems.";

    echo "Error: Our query failed to execute and here is why: \n";
    echo "Query: " . $sql . "\n";
    echo "Errno: " . $mysqli->errno . "\n";
    echo "Error: " . $mysqli->error . "\n";
    exit;
}

if ($result->num_rows === 0) {
    echo "We could not find anything in table sensor. Please try again.";
    exit;
}

echo "found " . $result->num_rows . " entries to show:<br>\n";
echo "<ul>\n";
while ($sensor = $result->fetch_assoc()) {
    echo "<li>id=" . $sensor['sensId'] . " => ";
    echo $sensor['shortName'] . ' = ' . $sensor['longName'];
    echo "</li>\n";
}
echo "</ul>\n";

$result->free();
$mysqli->close();
?>
[/code]

Der Ergebnis:
[code]
found 3 entries to show:

    id=Aussen => Aussen = Aussenfuehler
    id=Ruecklauf => Hzg Ruel = Heizung Ruecklauf
    id=Vorlauf => Hzg Vorl = Heizung Vorlauf
[/code]
