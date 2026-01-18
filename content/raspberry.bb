[title]Protokoll der Entstehung der Version 3.0[/title]

[chapter]Vorüberlegungen[/chapter]

[section]Anforderungen[/section]

Folgende Anforderungen werden an das neue System gestellt:

[list=1]
[*] RaspberryPi mit externer SSD als neue Hardwareplattform. [done]
[*] Migration und Portierung aller bisherigen Systeme von IPC und NAS auf die neue Hardwareplattform RaspberryPi. [done]
[*] Erstellung einer Anleitung zum Wiederaufsetzen des Systems. [done]
[/list]

[section]lfd. Arbeiten[/section]

[list=1]
[*] Folgt eine Meditation auf einen Gymnastiktermin, soll der Fußboden warm sein, obwohl vorher gelüftet wurde.
[*] Der Außenfühler soll Minusgrade messen können. [done]
[*] Alle Diagramme sollen einen weißen Hintergrund bekommen, damit sie beim Drucken weniger Material verbauchen. [done]
[*] Absturzsichere Aktualisierung der Systemzeit. [done]
[*] Erstellung einer Anleitung für die Nutzer des cKalender Systems. [done]
[*] Für die Eichung der Sensoren wird ein ADC Value Logging eingeführt. [done]
[*] Für die Statistik über die Aussentemperatur werden Abfragen benötigt (die letzten 7, 30, 365 Tage). [local=sqlgate/index.html]Hier[/local] kann man die Zahl 365 durch 30 oder 7 ersetzen und die Abfrage ausführen. [done]
[*] Die Jahresstatistik über die Belegung des Pfarrzentrums soll über einen Link leicht erreichbar sein: [b]http://pz-iffeldorf.ddns.net/hpgyears/hpgyear_[JAHR].csv[/b] (Da die Statistik jetzt direkt aus den XML-Daten des cKalender ermittelt werden, wurde die Tabelle "responsible" und "respMatch" gelöscht und aus der Erstellung des Schemas im Setupskript entfernt.). [done]
[*] Die Produktion der Jahresstatistik über die Belegung des Pfarrzentrums könnte automatisiert werden. Am Anfang eines Jahres produziere die Statistik für das gerade vergangene Jahr.
[/list]

[chapter]Realisierung[/chapter]

[section]RaspberryPi mit externer SSD[/section]

[big][b]Notwendigen Hardware[/b][/big]

[list=1]
[*] Raspberry Pi 3 Model B 1 GB ohne Betriebssystem (35,99 Euro) [done]
[*] M.2 SATA SSD Erweiterungs-Platine für den Raspberry Pi (15,99 Euro) [done]
[*] Interne SATA M.2 SSD 2280 250 GB Samsung 850 Evo Retail MZ-N5E250BW M.2 (108,95 Euro) [done]
[*] Kühlungs-Kit Raspberry Pi A, B, B+, Cubieboard, Banana Pi (4,99 Euro) [done]
[*] USB-Ladegerät HN Power HNP15-MicroUSBL6 HNP15-MicroUSBL6 (10,95 Euro) [done]
[*] 16GB SD-Karte [done]
[/list]

Hier ein paar Eindrücke aus meiner mehr Software- als Hardwarewerkstatt.

[image src=updates/20180115a.jpg tn=updates/20180115a-tn.jpg] [image src=updates/20180115b.jpg tn=updates/20180115b-tn.jpg] [image src=updates/20180218a.jpg tn=updates/20180218a-tn.jpg]

[section]Migration und Portierung aller Systeme[/section]

Die Portierung wird nicht gesondert dokumentiert, jedoch eine Anweisung zum Aufsetzen eines kompletten Systems (siehe weiter unten).

[section]Anleitung zum Aufsetzen eines Systems[/section]

Es wird eine Anweisung zum Aufsetzen eines kompletten Systems erstellt, die weiter unten dokumentiert ist.

[section]Aktualisierung der Systemzeit[/section]

Die [b]Aktualisierung der Systemzeit[/b] ist kein Thema mehr. Das Raspbien macht das schon ganz alleine beim Hochfahren. Hier zum Beweis ein Auszug aus dem Protokoll, das auf [i]idefix[/i] nach dem Hochfahren zu finden ist:

[code]
         Starting Network Time Synchronization...
[  OK  ] Started Network Time Synchronization.
[  OK  ] Reached target System Time Synchronized.
[/code]

[section]Der Außenfühler soll Minusgrade messen können.[/section]

Willi und ich haben wochenlang getüftelt und mindestens zwei Fehlstarts hingelegt. Das Ergebnis läßt sich sehen. 3x Messfühler LM335Z in Serie geschaltet brachten den Durchbruch. Hier ein paar Impressionen.

[image src=updates/20180314f.jpg tn=updates/20180314f-tn.jpg] [image src=updates/20180314g.jpg tn=updates/20180314g-tn.jpg]

Hier der Ort, an dem der Fühler am 14.03.2018 montiert wurde.

[image src=updates/20180214c.jpg tn=updates/20180214c-tn.jpg]

Für die Messung von Minusgraden werden also 3 LM335Z Sensoren in Reihe geschaltet. Der äußerste Pluspol wird mit einem Pin an JP3 verbunden, während auch an der selben Stelle ein 4,7kOhm Widerstand gegen die 12V DC Spannungsversorgung und der gegenüberliegende Minuspol an die Masse der Spannungsverorgung angeschlossen wird.

Die Spannungsversorgung erreicht man auf der Breakoutplatine am gleichen Modul, wie jenes, das am JP3 angeschlossen wurde. Das ist deshalb besonders sinnvoll, weil eine Beschaltung am gleichen Pin der Breakoutplatine und am JP3 zur Zerstörung der Schaltung auf der Relaisplatine führen kann. Das zu vermeiden, ist diese Verschaltung wie ein Merker!!!

Die Impementierung in der Steuersoftware machte eine Einführung der Sensortypen in der Konfigurationsdatei notwendig. Diese Einstellungen führen in dem Kommandoskript zu einer unterschiedlichen Behandlung der Sensordaten mit jeweils einem anderen Algorithmus zur Berechnung der Temperaturwerte.

Die alte von uns verwendete Formel für den LM35DZ am JP1 lautet.

[code]
GradCelsius = ADCValue / 4812.8 * 960
[/code]

In der neuesten Dokumentation findet sich eine Formel, die anscheinend nicht auf unsere Hardwareversion passt. Dort wird der Abstand zwischen zwei benachbarten Digitalwerten mit Vref = 1,22 V angegeben. Das Webinterface der Platine verhält sich aber anders. Durch Iteration des Wertes mit der Formel angewandt auf Beispielwerte, die ich auf dem Webinterface beobachtet habe, kam zu dem Schluss, dass der richtige Wert um 1,1246757 V liegen muss. Die Formeln für den LM35DZ an JP1 für die Berechnung der Grad Celsius lautet dort.

[code]
GradCelsius = Vref * (ADCValue / 1024) * (13.8 / 8.2) * 100
[/code]

Für die Berechnung der am analogen Pin anliegenden Spannung aus dem Wert des AD-Wandlers wird dort folgende Formel angegeben.

[code]
V = Vref * (ADCValue / 1024) * (70.2 / 8.2)
[/code]

In der Dokumentation der Relaisplatine aus dem Jahr 2013 gibt es eine andere Annäherung, die ich jetzt in der Steuerungssoftware implementiert habe.

[code]
   my $vRef = 1.2;
   switch ($sType) {
	   case "LM35DZ" {
	         # from ADC direct to degree Celsius
	         $sensor = $vRef * ($sensor / 1024) * (8.0 / 4.7) * 100;
	         # add the correction value from config.ini
	         $sensor = $sensor + $circCorrection;
	      }
	   case "3xLM335Z" {
	         # from ADC Value to Volt
	         $sensor = $vRef * ($sensor / 1024) * (37.7 / 4.7);
	         # from Volt to degree Celsius
	         $sensor = 25 - ((8.94 - $sensor) / 0.03);
	         # add the correction value from config.ini
	         $sensor = $sensor + $circCorrection;
	      }
	   else {
	         die "Unsupported Type of Sensor: '$sType'";
	      }
	}
[/code]


[code]
gC = vRef * (adV / 1024) * (8.0 / 4.7) * 100
gC = (vRef * adV * 8.0 * 100) / (1024 * 4.7)
(gC * 1024 * 4.7) / (vRef * 8.0 * 100) = adV
adV = (gC * 1024 * 4.7) / (vRef * 8.0 * 100)


gC = vRef * adV * (800 / 4812,8)
gC = vRef * adV * 0,166223404255
adV = gC / (vRef * 0,166223404255)
[/code]

Das sind die Formeln, die in der Web-Schnittstelle der Relaiskarten verwendet werden.

[code]
V = ADC / 106,5
°C = ADC / 5
[/code]

[section]Montage des neuen Systems[/section]

Hier ein paar Eindrücke, aufgenommen nach der Montage des RaspberryPi am 14.03.2018.

[image src=updates/20180314a.jpg tn=updates/20180314a-tn.jpg] [image src=updates/20180314b.jpg tn=updates/20180314b-tn.jpg] [image src=updates/20180314c.jpg tn=updates/20180314c-tn.jpg] [image src=updates/20180314d.jpg tn=updates/20180314d-tn.jpg] [image src=updates/20180314e.jpg tn=updates/20180314e-tn.jpg]


[chapter]Recovery-Anleitung[/chapter]

[section]Motivation[/section]

Für den Fall eines Zusammenbruchs von Hardware oder Software braucht es eine detailierte Anleitung um das System wieder aufzubauen... Schließlich soll niemand erfrieren ;-)

[section]Grundsystem bereitstellen[/section]

[block]Boot von SSD aktivieren[/block]

Installiere [i]Raspberry Pi Imager[/i] unter Ubuntu. Wähle dort [i]Raspberry Pi OS (other)[/i] und dann [i]Raspberry Pi OS Lite (64-bit)[/i]. Wähle das [b]korrekte[/b] Medium aus (zuerst eine SSD-Karte; dann die USB-SSD). Anschließend starte denn Schreibvorgang.

Nach dem Schreiben der SD-Karte und der SSD lege im root-Verzeichnis beider [i]boot[/i]-Partitionen eine leere Datei namens SSD an mit z.B.:

[code=none]
touch /media/lenny/boot/ssh
[/code]

Nun trenne die beiden Partitionen im Dateimanager und stecke die SD-Karte in den RaspberryPi. Verbinde das Netzwerkkabel und anschließend das Poweradapter. Nach dem Booten des RaspnerryPi sollte ein login möglich sein:

[code=none]
ssh pi@raspberrypi
[/code]

Jetzt ist es Zeit den Raspberry davon zu überzeugen von USB-Device zu booten.

[b]Den [i]RaspberryPi[/i] überreden nur von USB-Device zu booten...[/b]

[url=https://raspberry.tips/raspberrypi-tutorials/raspberry-pi-von-ssd-festplatte-booten/]Anleitung[/url]

*** als [red][i]root[/i][/red] auf dem RaspberryPi agieren ...
[code=none]
sudo -i
[/code]

Zuerst Raspbien auf den aktuellsten Stand bringen für diese Aufgabe ist keine Systemkonfiguration notwendig...

[code=none]
apt update && apt upgrade
[/code]

Den USB Boot Modus aktivieren: Der Parameter wird beim nächsten Neustart in den OTP des RaspberryPi übernommen...

[code=none]
echo program_usb_boot_mode=1 | tee -a /boot/config.txt
[/code]

Zuletzt den Raspberry Pi rebooten...

[code=none]
reboot
[/code]

Nach dem Reboot prüfen ob der Parameter korrekt gesetzt wurde...

[code=none]
vcgencmd otp_dump | grep 17:
*** Es muss 17:3020000a ausgegeben werden.
[/code]

Nun entferne das Powerkabel vom RaspberryPi und anschließend die SD-Karte. Schließe die SSD per USB an den RaspberryPi und stecke das Netzteil wieder an. Nach dem Bootvorgang sollte jetzt ein Login per ssh möglich sein und Du kannst mit dem Konfigurieren des Respariens beginnen.

[block]Resberien konfigurieren[/block]

[b]Konfiguration starten...[/b]

*** als [red][i]root[/i][/red] auf dem RaspberryPi agieren ...
[code=none]
sudo -i
[/code]

[b]System auf den aktuellsten Stand bringen...[/b]

[code=none]
apt update
apt upgrade
[/code]

[b]Zeitzone ändern...[/b]

[code=none]
rm /etc/localtime
echo "Europe/Berlin" > /etc/timezone
dpkg-reconfigure -f noninteractive tzdata
[/code]

[b]SSH aktivieren...[/b]

*** Zuerst prüfen ob ssh nicht schon aktiviert und gestartet ist...
[code=none]
service ssh status
[/code]

*** wenn nicht, dann wäre was ganz übel schief gegangen, denn Du bist per ssh eingeloggt ...

[code=none]
update−rc.d ssh enable
invoke−rc.d ssh start
[/code]

[b]Passwort ändern...[/b]

[code=none]
passwd pi
[/code]

[b]Hostnamen ändern...[/b]

[code=none]
echo idefix > /etc/hostname
sed -i "s/127.0.1.1.*raspberrypi/127.0.1.1\tidefix/g" /etc/hosts
[/code]

[b]RaspberryPi rebooten...[/b]

[code=none]
sync
reboot
[/code]

[block]sftp installieren und konfigurieren[/block]

[b]*** alle folgende Befehle als [red][i]root[/i][/red] ausführen !!![/b]

[code=none]
apt install ftpd-ssl
[/code]

*** Ein OpenSSL Zertifikat ist notwendig... [url=https://legacy.thomas-leister.de/eine-eigene-openssl-ca-erstellen-und-zertifikate-ausstellen/]Anleitung[/url]

Certificate Authority (CA) erstellen

[code=none]
openssl genrsa -aes256 -out ca-key.pem 2048
[...]
Enter pass phrase for ca-key.pem: **********************
Verifying - Enter pass phrase for ca-key.pem: **********************

openssl req -x509 -new -nodes -extensions v3_ca -key ca-key.pem -days 1024 -out ca-root.pem -sha512
Enter pass phrase for ca-key.pem: **********************
[...]
Country Name (2 letter code) [AU]: DE
State or Province Name (full name) [Some-State]: Bavaria
Locality Name (eg, city) []: Iffeldorf
Organization Name (eg, company) [Internet Widgits Pty Ltd]: .
Organizational Unit Name (eg, section) []: .
Common Name (e.g. server FQDN or YOUR name) []: pz-iffeldorf.ddns.net
Email Address []: hans-peter.gaugele@t-online.de
[/code]

Root-Zertifikat auf den Clients importieren (nicht für idefix!!!)

[code=none]
cp ca-root.pem /usr/share/ca-certificates/myca-root.crt
dpkg-reconfigure ca-certificates
= >>> Neues Zertifikat akzeptieren, alle Mozilla Zertifikatsstellen akzeptieren
[/code]

Ein neues Zertifikat ausstellen

[code=none]
openssl genrsa -out cert-key.pem 4096
[...]

openssl req -new -key cert-key.pem -out cert.csr -sha512
[...]
Country Name (2 letter code) [AU]: DE
State or Province Name (full name) [Some-State]: Bavaria
Locality Name (eg, city) []: Iffeldorf
Organization Name (eg, company) [Internet Widgits Pty Ltd]: .
Organizational Unit Name (eg, section) []: .
Common Name (e.g. server FQDN or YOUR name) []: pz-iffeldorf.ddns.net
Email Address []: hans-peter.gaugele@t-online.de
[...]
A challenge password []:
An optional company name []:

openssl x509 -req -in cert.csr -CA ca-root.pem -CAkey ca-key.pem -CAcreateserial -out cert-pub.pem -days 365 -sha512
Enter pass phrase for ca-key.pem: **********************
[/code]

Einbinden des Zertifikates in den ftpd ...

[code=none]
cat cert-pub.pem cert-key.pem > ftpd.pem
cp ftpd.pem /etc/ftpd-ssl/ftpd.pem
[/code]

Und hier der Testzugriff von einem anderen Rechner aus:

[code=none]
*** von remote
sftp pi@idefix
pi@idefix password: *****
Connected to idefix.
sftp> ls -la
[...]
sftp> exit
[/code]
[latest]
[block]Apache2 installieren und konfigurieren[/block]

[b]*** alle folgende Befehle als [red][i]root[/i][/red] ausführen !!![/b]

[code=none]
apt install apache2
[/code]

Das DOCUMENT_ROOT auf die Applikation umleiten...

[code=none]
*** als pi agieren ...
mkdir /home/pi/html

*** als root agieren ...
cd /var/www
mv html/ html.sav
ln -s /home/pi/html/ .
[/code]

Teste indem Du auf remote im Browser [url=http://idefix]http://idefix[/url] eingibst.

[block]MySQL Apache2 installieren und konfigurieren[/block]

[b]*** alle folgende Befehle als [red][i]root[/i][/red] ausführen !!![/b]

[code=none]
apt install mysql-server mysql-client
mysql_tzinfo_to_sql /usr/share/zoneinfo | mysql -u root mysql
[/code]

[b]MySQL konfigurieren...[/b]

[code=none]
mysql -u root
[/code]

Datenbank "willy" und die Benutzer "pi" und "webuser" anlegen...

[code]
CREATE DATABASE `willy`
   DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE USER 'pi'@'localhost'
   IDENTIFIED WITH 'unix_socket';

GRANT ALL PRIVILEGES
   ON willy.*
   TO 'pi'@'localhost';

FLUSH PRIVILEGES;

CREATE USER 'webuser'@'localhost';

GRANT SELECT
   ON willy.*
   TO 'webuser'@'localhost';

FLUSH PRIVILEGES;
[/code]

[block]PHP7 installieren und konfigurieren[/block]

[b]*** alle folgende Befehle als [red][i]root[/i][/red] ausführen !!![/b]

[code=none]
--------------------------------------------------------
# php7.0 (7.0.3-6) unstable; urgency=medium
#
#   * Several extensions have been split into separate extension packages:
#    - php-dba - Database (dbm-style) Abstraction Layer
#    - php-mbstring - Multibyte String
#    - php-soap - SOAP
#    - php-xml - DOM, SimpleXML, WDDX, XML, XMLReader and XMLWriter
#    - php-zip - Zip
#   * The new packages are not installed automatically, so you will need to
#     install them by hand, if you use the functions in those modules.
#   * Most modules that have been builtin before are now included in
#     php7.0-common package and they are enabled by default for your
#     convenience.  You can disable unneede modules via phpdismod tool.
--------------------------------------------------------

apt install php-xml
apache2ctl graceful
[/code]

In der Datei [i]/etc/php/7.0/apache2/php.ini[/i] die Zeitzone wie folgt einstellen.

[code]
date.timezone = Europe/Berlin
[/code]

[section]Applikationsumgebung schaffen[/section]

[block]Software auf Idefix bringen[/block]

Aus der aktuellen Sicherung die Dateien und Verzeichnisse im Verzeichnis "idefix" ins Homeverzeichnis des Benutzers "pi" entpacken.

[block]Perl-Pakete nachinstallieren (ca. 15 Min.)[/block]

[b]CPAN vorbereiten[/b]

[code=none]
cpan
= >>> beim ersten Mal das automatische Konfigurieren bestätigen
install YAML
install Log::Log4perl
install Term::ReadKey
install CPAN
reload CPAN
install Term::ReadLine
[/code]

[b]Notwendige Pakete installieren[/b]

[code=none]
install List::MoreUtils
install inc::latest # wird für dir vollständige Installation von Net::SNMP benötigt...
install Net::SNMP
install JSON
*** It seems you are running perl version 5.022001, likely the "official" or
*** "standard" version. While there is nothing wrong with doing that,
*** standard perl versions 5.022 and up are not supported by JSON::XS.
*** While this might be fatal, it might also be all right - if you run into
*** problems, you might want to downgrade your perl or switch to the
*** stability branch.
Continue anyways?  [y] n
= >>> Damit wird JSON::XS nicht installiert.
install File::Grep
install Switch
[/code]

[block]PHP7-Pakete nachinstallieren[/block]

[code=none]
sudo apt install php-mysqli
sudo apt install php-bcmath
sudo apt install php-gd
sudo service apache2 restart
[/code]

[block]Datenbank "willy" auf "idefix" sichern[/block]

[red]Das Sichern der Datenbank sollte regelmäßig geschehen![/red] Die Sicherung kann so wie sie ist nicht zum Einspielen benutzt werden. Deshalb sind hier eine Reihe von Filterungen notwendig. Nur die Tabellen dürfen gefüllt werden, die nicht vom "setup.pl" gefüllt werden. "setup.pl" erzeugt außerdem auch alle Tabellen.

[code=none]
mysqldump --user=pi --databases willy > iffeldorf.raw.sql
egrep "^INSERT INTO" iffeldorf.raw.sql > iffeldorf.1.sql
echo "USE willy;" > iffeldorf.tmp
cat iffeldorf.tmp iffeldorf.1.sql > iffeldorf.2.sql
egrep -v '(INSERT INTO `circuit`|INSERT INTO `sensor`)' iffeldorf.2.sql > iffeldorf.sql
zip iffeldorf.sql.zip iffeldorf.sql
adding: iffeldorf.sql (deflated 90%)
[/code]

[block]Datenbank "willy" auf "idefix" einspielen[/block]

Mit der folgenden Prozedur wird die Software initialisiert und konfiguriert und die Datenbank bei einem Recovery wieder aufgebaut.

[code=none]
*** als pi agieren ...
unzip iffeldorf.sql.zip
./setup.pl --startup
mysql < iffeldorf.sql
[/code]
