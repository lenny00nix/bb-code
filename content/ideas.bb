[title]Ideen für weitere Versionen[/title]

In diesem Dokument sollen alle Ideen für spätere Versionen formuliert werden.

[chapter]Schnelle Ideensammlung[/chapter]

[list=1]
[*] So wie Sensoren einzeln konfiguriert werden können, sollen Relais eigenständig schaltbar konfiguriert werden können.
[*] Für die Schalter und Taster sollen Ruhe- bzw. Initialzustände konfiguriert werden können.
[*] Für "Pfarrzentrum Licht aus" und "Jugendtreff Licht aus" sollen Buttons in den Weboberflächen für PC und Handy entstehen.
[*] Die Weboberfläche soll "responsive" gestaltet werden.
[*] Der cKalender könnte durch eine eigene Applikation ersetzt werden???
[/list]

[chapter]Licht-Aus[/chapter]

[code=ini]
; Configuration file for Iffeldorf Version x
;  ~/local/config.ini

...

[Relay]
;                Controller
;                 |          Module
;                 |           | Type Of Relay (Button or Switch (not yet implemented))
;                 |           |  |      Initial State (On or Off)
;                 |           |  |       |    Long Name
;                 |           |  |       |     |                          Short Name
;                 |           |  |       |     |                           |
PZAus          = (Iffeldorf2, 6, Button, Off, "Pfarrzentrum Gesamt Aus",  "PzG Aus")
JZAus          = (Iffeldorf2, 7, Button, Off, "Jugendzentrum Gesamt Aus", "JzG Aus")
Test           = (Iffeldorf2, 8, Switch, Off, "Test Schalter",            "Test")
[/code]

[blue][17.08.2020][/blue] Nun, da ich noch nicht den blassesten Schimmer habe, wie ich die "LichtAus"-Funktion implementieren soll, hatte ich schon einmal eine Erweiterung der config.ini-Datei definiert, was aber letztlich eine sehr komplizierte Erweiterung des ganzen Systems zur Folge hätte und dafür gibt es kein übergeordnetes Konzept.


[chapter]cKalender ersetzen[/chapter]

[section]Idee[/section]

Um von der cKalender-Schnittstelle unabhängig zu werden, wird ergänzend zur Software auf der Heizungssteuerung eine Kalenderfunktion notwendig. Sollte sich die Schnittstelle ändern, ist jedes Mal eine Änderung der Steuersoftware notwendig. Sollte cKalender seinen Betrieb oder die Schnittstelle einstellen, dann ist die Steuersoftware nicht mehr funktionsfähig, da ihr die Solldaten fehlt.

In cKalender werden bisher Felder abseits ihrer originären Funktion genutzt; z.B. wird der Beginn und das Ende eines Termins in einem Freitextfeld von cKalender übermittelt. Die eingegebenen Daten können somit erst in der Heizungssteuerung interpretiert und ggf. Fehleingaben erkannt werden. In der jährlichen Auswertung werden solche ungeprüften Daten mit verwendet und sind mühsam zu korrigieren.

Die neue Version der Heizungssteuerungssoftware soll all diese Probleme lösen und eine eigene, einfache Web-Applikation mit Kalenderfunktion zur Verfügung stellen. Ebenso soll eine Backup-Funktionalität bereit gestellt werden.

[blue][13.04.2021 hpg][/blue]

[section]Kalenderfunktionen[/section]

Um die Entscheidung zur Durchführung der Entwicklung treffen zu können, die Machbarkeit in endlicher Zeit, muss klar sein, was die Applikation leisten soll. Dazu ist eine Analyse der cKalender Funktionen notwendig. [blue][14.04.2021 hpt][/blue]

[section]Migration[/section]

Die Schnittstelle zwischen Kalender und Steuersoftware ist neu zu definieren und zu implmentieren. Die Kalenderdaten sollen in einer Datenbank abgespeichert werden, aus der die Steuersoftware lesen soll. Dadurch entfällt die bisher genutzte XML-Schnittstelle. Alte Kalenderdaten aus dem cKalender-Portal müssen im Laufe der Migration in die neue Datenbankstruktur übernommen werden. Dazu ist ein eigenes Skript erforderlich. Die bisher gesammelten Daten in der Datenbank müssen ebenfalls per Migrationsskript in die neue Datenbankstruktur übernommen werden.
