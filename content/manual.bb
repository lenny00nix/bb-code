[title]Benutzeranleitung[/title]

[chapter]Motivation[/chapter]

Ergänzend zur Bedienungsanleitung des cKalender Internetportals gibt es einige Besonderheiten im Zusammenhang mit der Steuerung der Heizungsanlage im Pfarrzentrum Iffeldorf. Diese werden im Folgenden dargestellt.

[chapter]Besonderheiten im cKalender[/chapter]

Im cKalender ist es möglich einen Termin ohne Zeitangabe und über mehrere Tage einzutragen. Beide Varianten wertet die Heizungssteuerung als Eingabefehler und meldet diese per Mail. Möchte man einen Termin über mehrere Tage angeben, dann soll die tägliche Wiederholung angewählt werden und entsprechend der Veranstaltung die von-bis Zeiten eingetragen werden. Gibt es Tage während der Veranstaltung, die andere von-bis Zeiten erfordern, kann dieses am einzelnen cKalender-Eintrag der Serie eingegeben werden.

[section]Wärmer oder kälter im Feld "Titel"[/section]

Um die Heizungssteuerung zu einer abweichenden Zieltemperatur zu überreden wurde das Feld "Titel" in seiner Bedeutung erweitert. Nun ist es möglich zu dem Titel der Veranstaltung eine zusätzliche Angabe zu machen. Diese ist mit einem Leerzeichen vom Titel der Veranstaltung abzutrennen.

Erlaubter Aufbau des Feldinhaltes:
[code=none]
[Titel der Veranstaltung] [+-][D]C
[/code]

Hierbei steht [D] für die gewünschte Abweichung von der im System vorgegebenen Raumtemperatur während der Nutzungzeit. Soll die Abweichnung nach oben erfolgen, wird ein "+" vorangestellt. Für eine Abweichnung nach unten wird ein [-] angegeben. Ein abschließendes "C" kennzeichnet, dass es sich um Grad Celsius handelt. Diese Angabe ist notwendig.

Zulässige Beispiele:
[code=none]
Entspannung in der Gruppe +2C
[/code]

In diesem Beispiel wird für die "Entspannung in der Gruppe" eine um 2°C höhere Zimmertemperatur gewünscht, was bei der Fußbodenheizung auch mehr Wärme von unten mit sich bringt.

[code=none]
Turnen im Zirkeltraining -1C
[/code]

In diesem Beispiel wird für das "Turnen im Zirkeltraining" eine um 1°C niedrigere Zimmertemperatur gewünscht.

[section]Jahres-Belegungsliste[/section]

Am Ende eines Jahres wird die Jahres-Belegungsliste aus den aktuellen XML-Daten des cKalender Portals in eine CSV-Datei geschieben. Diese kann unter folgendem Link abgerufen werden: 

[i][b]http://pz-iffeldorf.ddns.net/hpgyears/hpgyear_[Jahr].csv[/b][/i]


[chapter]Konfiguration der Anlage[/chapter]

[section]Konfigurationsdatei[/section]

[code=ini]
; Configuration file for Iffeldorf Version 3
;  ~/local/config.ini

[General]
; --- modes ---
;           Mode (abgetrennt mit '|')
;            |
;            |   mögliche Werte (sind kombinierbar):
;            |      Debug:   Ausgabe von Debug Meldungen
;            |      TdkSim:  Schreiben und Lesen der Relaiszustände wird lokal
;            |               simmuliert (Denkov Simmulator)
;            |      TdkRO:   Relaiszustände werden remote gelesen und lokal
;            |               gespeichert (Deknov Read Only)
;            |      AdcLog:  Für die Eichung der Sensoren wird der ADC-Wert
;            |               auf die Statusseite und ins error.log geschrieben.
;            |
;            |   "modes = " wird im laufenden Betrieb ganz auskommentiert.
;            |
; modes   = (TdkRO)

; --- cKalender ---
;            orgId   userId   userCode  groupIds                                 noOfDays preview
;             |       |        |         |                                                     |
cKalender = ("4980", "16277", "***", "23141,23149,23142,29552,23143,23144,23145,23147,23148", 21)


; --- atrRange ---
;            atrLow: difference to target value (Degrees Celsius)
;             |   atrHigh: difference to target value (Degrees Celsius)
;             |    |
atrRange  = (-1.0, 1.0)

; --- logging ---
;            logInterval (Minutes) done by commander.pl
;             |   logHistory (Days) done by admin.pl
;             |    |
logging   = (15, 3653) ; logInterval (Minutes), logHistory (Days)

[Controller]
;                 Controller IP-Adr       Community String
;                  |                & Port |        Alias Name
;                  |                   |   |         |
Iffeldorf1     = ("192.168.178.222", 161, "168737", "Iffeldorf 1")
Iffeldorf2     = ("192.168.178.223", 161, "168737", "Iffeldorf 2")

; Für die ferne Steuerung gedacht...
;Iffeldorf1     = ("pz-iffeldorf.ddns.net", 161, "168737", "Iffeldorf 1")
;Iffeldorf2     = ("pz-iffeldorf.ddns.net", 162, "168737", "Iffeldorf 2")
;Iffeldorf1     = ("sf8zwrwvhsrshznz.myfritz.net", 161, "168737", "Iffeldorf 1")
;Iffeldorf2     = ("sf8zwrwvhsrshznz.myfritz.net", 162, "168737", "Iffeldorf 2")

[Circuit]
;                Controller                                                    Forerun Minutes
;                 |          Module                                             |    Trailing Minutes
;                 |           | Type Of Sensor (LM35DZ or 3xLM335Z)             |     |  Mold Protection
;                 |           |  |       Correction (ADC-Value)                 |     |   |  Room Temperature
;                 |           |  |        |    Long Name                        |     |   |   | Utility Room
;                 |           |  |        |     |                Short Name     |     |   |   |  |
;                 |           |  |        |     |                 |             |     |   |   |  |
Pfarrsaal_West = (Iffeldorf1, 1, LM35DZ, -1.8, "Pfarrsaal West", "Pfs West", -360, -120, 14, 21, No)
Pfarrsaal_Ost  = (Iffeldorf1, 2, LM35DZ, -0.6, "Pfarrsaal Ost",  "Pfs Ost",  -360, -120, 14, 21, No)
Foyer_WCEG     = (Iffeldorf1, 3, LM35DZ, -1.2, "Foyer u. WC EG", "Foyer WC", -240, -120, 13, 20, Yes)
Kueche         = (Iffeldorf1, 4, LM35DZ, -1.6, "Kueche",         "Kueche",   -120, -120, 13, 20, Yes)
30er_Raum      = (Iffeldorf1, 5, LM35DZ, -1.4, "30er Raum",      "30 Raum",  -360, -120, 14, 21, No)
40er_Raum      = (Iffeldorf1, 6, LM35DZ, -1.9, "40er Raum",      "40 Raum",  -360, -120, 14, 21, No)
60er_Raum      = (Iffeldorf1, 7, LM35DZ, -2.7, "60er Raum",      "60 Raum",  -360, -120, 14, 21, No)
Gruppenraum    = (Iffeldorf1, 8, LM35DZ, -0.4, "Gruppenraum",    "Gruppe",   -240, -120, 14, 22, No)
Jugendtreff    = (Iffeldorf2, 1, LM35DZ, -0.4, "Jugendtreff",    "Jugend",   -240, -120, 14, 22, No)
WC_Keller      = (Iffeldorf2, 2, LM35DZ,  0.0, "WC Keller",      "WC UG",    -120, -120, 13, 20, Yes)

[Group]
;                Modules
;                 |   ...
Pfarrsaal      = (Pfarrsaal_West, Pfarrsaal_Ost, Foyer_WCEG)

[Sensor]
;                Controller
;                 |          Module
;                 |           | Type Of Sensor (LM35DZ or 3xLM335Z)
;                 |           |  |        Correction (ADC-Value)
;                 |           |  |         |  Long Name
;                 |           |  |         |   |                   Short Name
;                 |           |  |         |   |                    |
Vorlauf        = (Iffeldorf2, 3, LM35DZ,   0, "Heizung Vorlauf",   "Hzg Vorl")
Ruecklauf      = (Iffeldorf2, 4, LM35DZ,   0, "Heizung Ruecklauf", "Hzg Ruel")
Aussen         = (Iffeldorf2, 5, 3xLM335Z, 0, "Aussenfuehler",     "Aussen")
[/code]

[section]Steuerdatei[/section]

[code=bash]
# Crontab template file for Iffeldorf Version 3
#  ~/local/crontab.txt

# Der Generator liest die Konfigurationsdaten, holt die Daten von cKalender,
# generiert die Steuerdaten und speichert sie ab. Das geschieht alle 15 Minuten.
# Dabei ist die Uhrzeit so gewählt, dass die viertelstündlichen Datenbank-
# einträge nicht gestört werden.
1,16,31,46 * * * * {PATH}/generator.pl --runtime

# Der Commander liest die Konfigurationsdaten, liest die Steuerdaten, holt die
# Zustände der Relaisplatine, errechnet die neuen Relaisstellungen, schreibt die
# Statistikdaten und die Schnappschüsse für die Anlagenansicht im Web.
* * * * * {PATH}/commander.pl --runtime

# Der Admin liest die Konfigurationsdaten und löscht Einträge in der Datenbank,
# die älter sind, als in der Konfigurationsdatei definiert.
59 23 * * * {PATH}/admin.pl --runtime

# Am Ende eines Jahres wird die Jahres-Belegungsliste aus den aktuellen XML-
# Daten des cKalender Portals in eine /home/pi/html/hpgyears/hpgyear_[Jahr].csv
# Datei geschieben. Dabei ist die Uhrzeit so gewählt, dass die viertelstünd-
# lichen Datenbankeinträge nicht gestört werden.
48 23 31 12 * {PATH}/hpgyear.pl

# Per Mail wird der Benutzer des cKalenders benachrichtigt, wenn bei der Ein-
# gabe eines Termins ein Fehler gemacht wurde und der entsprechende Eintrag
# nicht verarbeitet werden kann. Ebenso wird dem Anwender gemeldet, wenn der
# Eintrag wieder korrekt ausgewertet werden kann.
6,21,36,51 * * * * {PATH}/../alarm/alarm.pl
[/code]
