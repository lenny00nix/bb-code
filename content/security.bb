[title]Protokoll der Entstehung der Version 4.0[/title]

[chapter]Vorüberlegungen[/chapter]

[section]Motivation[/section]

Ziel dieser Version ist es die Internetschnittstelle des Raspberry Pi zu sichern. Dazu ist zunächst ein Linux-Update notwendig und anschließend ein sogenanntes Hardening des WebServers und der ssh- und sftp-Schnittstelle durchzuführen. Diesen Vorgang werde ich Schritt für Schritt in diesem Dokument protokollieren.

[section]Referenzanlage[/section]

Um später bei der Inbetriebnahme nur die SSD austauschen und die USB-Festplatte anschließen zu müssen, bedarf es einer Entwicklungsplattform, die der Hardware im Schaltschrank gleicht.

[image src=updates/20180115a.jpg tn=updates/20180115a-tn.jpg] [image src=updates/20180115b.jpg tn=updates/20180115b-tn.jpg]

[list]
[*]Raspberry Pi 3 B+ 1 GB 4 x 1,4 Ghz für 38,49 €
[*]RB-heatsink Kühlkörper-Set passend für: Raspberry Pi, Banana Pi Silber für 2,79 €
[*]SD Karte passend für: Raspberry Pi
[*]Renkforce USB/mSATA-Konverter-Shield passend für Raspberry Pi für 15,99 €
[*]Samsung 860 EVO 250 GB Interne  M.2 SATA SSD 2280 M.2 6 Gb/s Retail MZ-N6E250BW für 44,95 €
[*]Raspberry Pi® Steckernetzteil, Festspannung Passend für Raspberry Pi für 11,99 € 
[*]USB Festplatte
[/list]

[section]bekannte Fehler[/section]

[blue][13.04.2021 hpt][/blue] Bisher haben wir in der aktuellen Version 3.0 Störungen nur durch die Benutzung von mySQL gehabt; Störungen, die durch Steckerziehen behoben werden konnten und in dem Semaphorenmanagement von MariaDB begründet waren. Wir haben schon lange kein Update mehr auf dem Raspberry Pi gefahren. Es mag sein, dass dieses Problem bereits behoben wurde.

[section]Server hardening[/section]

Eine Anleitung findet man hier: [url=https://linux-audit.com/ubuntu-server-hardening-guide-quick-and-secure/]Ubuntu system hardening guide for desktops and servers[/url]

[b]Minimale Installation [done][/b]

Die Paspian Variante [b]Raspberry Pi OS Lite (32-Bit)[/b] erfüllt diese Forderung.

[b]Benutze starke Passwörter [postponed][/b]

Die Passwörter werden bei Auslieferung des Systems auf 25 Zeichen und Symbole gesetzt.

[b]Accounts und Rechte[/b]

Fraglich ist, ob das Modul [b]sudo[/b] incl. Konfigurationsdatei vom System entfernt werden soll. Dann würde [b]su[/b] Verwendung finden und root ein sehr komplexes Passwort bekommen. Der Benutzer [b]pi[/b] wäre als Zugangsbenutzer leicht zu erraten. Dagegen kann ein ebenfalls sehr komplexes Passwort helfen. Um dem Angreifer das Leben zu erschweren wäre eine Entfernung des Banners beim ssh-Login hilfreich.

[b]Use disk encryption [rejected][/b]

Mit Disk Encryption habe ich sehr schlechte Erfahrungen gemacht. Das Passwort vergessen und einige Monate Arbeit dabei vernichtet. Ich bin der Überzeugung, dass ein sehr komplexes Passwort für den ssh-Zugangsbenutzer ausreicht. Auf dem System sind keine geheimen Dokumente und Daten gespeichert. So kommt es meines Erachtens darauf an, nicht automatisierten Angriffen hilflos ausgeliefert zu sein. Ich hoffe sehr, dass ich mit dieser Behauptung richtig liege.

[b]Software Aktialisierung[/b]

Um Sicherheitsaktualisierungen automatisch auf dem System zu installieren, kann man einfach das Paket unattended-upgrades installieren.

[code=none]
apt install unattended-upgrades
[/code]

Obwohl das Paket in der Standardkonfiguration recht gut funktioniert, ist eine Anpassung notwendig, wenn mehr als die Pakete aus dem Security Repository automatisch aktualisiert werden sollen. Sollen externe Pakete in die Sicherheitsaktualisierung einbezogen werden, müssen sie in die Konfigurationsdatei [b]/etc/apt/apt.conf.d/50unattended-upgrades[/b] eingetregen werden. 

Neben den Sicherheits Aktualisierungen wird empfohlen, auf Basis eines regelmäßigen Plans, normale System- und Softwareaktualisierungen per Hand durchzuführen. Besonders auf Servern trägt das zur Stabilität des Systems bei.

[code=none]
apt update
apt upgrade
apt autoremove
apt autoclean
[/code]

[b]Firewall Installation und Konfiguration [rejected][/b]

Ich denke, dass eine Firewall über die der Fritzbox hinaus nicht notwendig ist. Es wird empfohlen eine Firewall zu installieren und zu konfigurieren, wenn man einen Server gegen Angriffe aus dem Intranet schützen will. Ich hoffe, dass im Pfarrzentrum niemand ungefragt ins Intranet kommt und sich dann in unseren Server einhacken will.


[chapter]Grundsystem bereitstellen[/chapter]

[section]Tools installieren[/section]

Installiere Raspberry Pi Imager v1.6.1 im Software Manager unter Ubuntu oder lade [url=https://www.balena.io/etcher/]Etcher Flash[/url] herunter und installiere das AppImage oder [url=https://phoenixnap.com/kb/etcher-ubuntu]installiere Etcher auf Ubuntu mit apt[/url].

Für die Etcher Variante lade [url=https://www.raspberrypi.org/software/operating-systems/]Raspberry Pi OS Lite[/url] als .zip herunter.

[section]SD und SSD vorbereiten[/section]

[b]Raspbian Image[/b] auch als ZIP per [i]Etcher Flash[/i] [b]auf[/b] eine [b]SD-Karte und[/b] auf die [b]SSD flashen[/b]. Alternativ benutze den [i]Raspberry Pi Imager[/i]. Wähle dabei immer das Basissystem ohne Benutzeroberfläche in der 64bit Variante.

[b]Mit einem offiziellen Hack [i]ssh[/i] aktivieren...[/b]

[b][red]Diese Prozedur auf der SD und SSD durchführen...[/red][/b]

[b]Alle folgende Befehle als [red]root[/red] ausführen !!![/b]

Korrektes Device ermitteln...

[code=none]
fdisk -l | grep /dev/sd
Festplatte /dev/sdc: 3,7 GiB, 3959422976 Bytes, 7733248 Sektoren
/dev/sdc1         8192  532479   524288  256M  c W95 FAT32 (LBA)
/dev/sdc2       532480 7733247  7200768  3,4G 83 Linux
[/code]

Dieses Device nutzen, bei mir war es /dev/sdc1 für boot und /dev/sdc2 für rootfs...

[code=none]
mkdir /mnt/raspi /mnt/raspi/boot /mnt/raspi/rootfs
mount /dev/sdc1 /mnt/raspi/boot
mount /dev/sdc2 /mnt/raspi/rootfs

ls -la /mnt/raspi/boot

insgesamt 48178
drwxr-xr-x 3 root root    3584 Jan  1  1970 .
drwxr-xr-x 4 root root    4096 Mai 17 13:26 ..
-rwxr-xr-x 1 root root   25607 Mär  3 14:40 bcm2708-rpi-b.dtb
-rwxr-xr-x 1 root root   25870 Mär  3 14:40 bcm2708-rpi-b-plus.dtb
-rwxr-xr-x 1 root root   25218 Mär  3 14:40 bcm2708-rpi-b-rev1.dtb
...
-rwxr-xr-x 1 root root 5981944 Apr 30 16:01 kernel.img
-rwxr-xr-x 1 root root    1594 Jan  5 08:30 LICENCE.broadcom
drwxr-xr-x 2 root root   18432 Mai  7 16:42 overlays
-rwxr-xr-x 1 root root  793084 Apr 30 16:01 start4cd.elf
-rwxr-xr-x 1 root root 3722504 Apr 30 16:01 start4db.elf
-rwxr-xr-x 1 root root 2228768 Apr 30 16:01 start4.elf
-rwxr-xr-x 1 root root 2981160 Apr 30 16:01 start4x.elf
-rwxr-xr-x 1 root root  793084 Apr 30 16:01 start_cd.elf
-rwxr-xr-x 1 root root 4794472 Apr 30 16:01 start_db.elf
-rwxr-xr-x 1 root root 2952928 Apr 30 16:01 start.elf
-rwxr-xr-x 1 root root 3704712 Apr 30 16:01 start_x.elf
[/code]

Hack durchführen...

[code=none]
touch /mnt/raspi/boot/ssh

ls -la /mnt/raspi/boot/

insgesamt 48179
...
-rw-r--r-- 1 lenny lenny       0 Mai 17 14:47 ssh
...
[/code]

Alle Mounts zurück nehmen...

[code=none]
umount /dev/sdc1 /dev/sdc2
[/code]

[section]Hardware verkabeln[/section]

[list]
[*]SSD an den [i]Rasperry Pi[/i] anschließen
[*]Die SD-Karte in den passenden Slot schieben.
[*][i]Rasperry Pi[/i] an das LAN-Netzwerk anschließen.
[*]Das Netzteil mit dem passenden USB-Port des [i]Rasperry Pi[/i] verbinden
[*]Das Netzteil in die 230 Volt Steckdose stecken.
[/list]

[section]Boot von SSD aktivieren[/section]

Den [i]Raspberry Pi[/i] überreden nur von USB-Device zu booten...

Erstes Login zum [i]Raspberry Pi[/i]...

[code=none]
ssh -l pi raspberrypi
*** Passwort: "raspberry" ***
[/code]

[b]Alle folgende Befehle auf dem [i]Rasperry Pi[/i] als [red][i]root[/i][/red] ausführen !!![/b]

[code=none]
sudo -i
[/code]

Zuerst Raspbian auf den aktuellsten Stand bringen für diese Aufgabe ist keine Systemkonfiguration notwendig...

[code=none]
apt update
apt upgrade
[/code]

Den USB Boot Modus aktivieren: Der Parameter wird beim nächsten Neustart in den OTP des RaspberryPi übernommen...

[code=none]
echo program_usb_boot_mode=1 | tee -a /boot/config.txt
[/code]

Zuletzt den [i]Rasperry Pi[/i] rebooten...

[code=none]
sync
reboot
[/code]

Nach dem Reboot prüfen ob der Parameter korrekt gesetzt wurde...

[code=none]
vcgencmd otp_dump | grep 17:
*** Es muss 17:3020000a ausgegeben werden.
[/code]

Hardwarekonfiguration ändern:

[list]
[*]Netzteil vom Raspberry Pi trennen.
[*]SD-Karte entfernen.
[*]Netzteil-Verbindung wieder herstellen.
[/list]

Im Folgenden kommt es beim nächsten Login zu einem bekannten Problem, dem mit diesem Befehl begegnet werden kann:

[code=none]
ssh-keygen -f "/home/lenny/.ssh/known_hosts" -R "raspberrypi"
[/code]

Danach sollte ein Login funktionieren.


[section]Raspbian konfigurieren[/section]

[b]Alle folgende Befehle auf dem [i]Rasperry Pi[/i] als [red][i]root[/i][/red] ausführen !!![/b]

[code=none]
ssh -l pi raspberrypi
***Passwort: raspberry***
sudo -i
[/code]

Bluetooth deaktivieren...

[code=none]
apt purge pi-bluetooth
[/code]

System auf den aktuellsten Stand bringen und bereinigen...

[code=none]
apt update
apt upgrade
apt autoremove
apt autoclean
[/code]

Zeitzone ändern...

[code=none]
rm /etc/localtime
echo "Europe/Berlin" > /etc/timezone
# locale-gen de_DE.UTF-8
# update-locale LANG=de_DE.UTF-8
dpkg-reconfigure -f noninteractive tzdata
[/code]

SSH aktivieren...

*** Zuerst prüfen ob ssh nicht schon aktiviert und gestartet ist...
[code=none]
service ssh status
[/code]

*** wenn nicht, dann ...

[code=none]
update−rc.d ssh enable
invoke−rc.d ssh start
[/code]

Passwort ändern...

[code=none]
passwd pi
[/code]

Hostnamen ändern...

[code=none]
echo idefix > /etc/hostname
sed -i "s/127.0.1.1.*raspberrypi/127.0.1.1\tidefix/g" /etc/hosts
[/code]

Raspberry Pi rebooten...

[code=none]
sync
reboot
[/code]


Im Folgenden kommt es beim nächsten Login zu einem bekannten Problem, dem mit diesen Befehlen begegnet werden kann:

[code=none]
ssh-keygen -f "/home/lenny/.ssh/known_hosts" -R "raspberrypi"
ssh-keygen -f "/home/lenny/.ssh/known_hosts" -R "idefix"
ssh-keygen -f "/home/lenny/.ssh/known_hosts" -R "192.168.178.23"
[/code]

Danach sollte ein Login funktionieren.


[section]Server Hardening[/section]

[block]sudo verhindern & Passwörter vergeben[/block]

Lokalen Zugang über sudo ohne Passwort verhindern.

[code=none]
sudo -i
passwd # neues Passwort für root vergeben
apt purge sudo
exit
su - # neues Passwort testen
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

Root-Zertifikat auf den Clients importieren [b][red](nicht für idefix!!!)[/red][/b]

[code=none]
###################################################################################
# cp ca-root.pem /usr/share/ca-certificates/myca-root.crt                         #
###################################################################################
# dpkg-reconfigure ca-certificates                                                #
# = >>> Neues Zertifikat akzeptieren, alle Mozilla Zertifikatsstellen akzeptieren #
###################################################################################
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

[section]Apache2 installieren und konfigurieren[/section]

[b]Alle folgende Befehle auf dem [i]Rasperry Pi[/i] als [red][i]root[/i][/red] ausführen !!![/b]

[code=none]
apt install apache2
[/code]

[section]WebServer Hardening[/section]

Zuerst wird der Certbot für die SSL Verschlüsselung der Webseite installiert und konfiguriert. Danach folge ich der Anleitung: [url=https://geekflare.com/de/apache-web-server-hardening-security/]Apache Web Server Hardening Security[/url].

[block]Certbot SSL für Apache[/block]

[url=https://certbot.eff.org/lets-encrypt/debianbuster-apache]Anleitung für Debian Buster[/url]

[b]*** alle folgende Befehle als [red][i]root[/i][/red] ausführen !!![/b]

[code=none]
apt install certbot
apt install python-certbot-apache
certbot --apache
[/code]

[b]Alle folgende Befehle auf dem [i]Rasperry Pi[/i] als [red][i]root[/i][/red] ausführen !!![/b]

[code=none]
lenny@rocky:~$ ssh -l pi idefix
The authenticity of host 'idefix (192.168.178.66)' can't be established.
ECDSA key fingerprint is SHA256:e4gDQU6OhuT/KIjoPi3VudD5LEHn8hTVSy3++iNVdM0.
Are you sure you want to continue connecting (yes/no)? yes
Warning: Permanently added 'idefix,192.168.178.66' (ECDSA) to the list of known hosts.
pi@idefix's password: 
Linux idefix 5.10.17-v7+ #1421 SMP Thu May 27 13:59:01 BST 2021 armv7l

The programs included with the Debian GNU/Linux system are free software;
the exact distribution terms for each program are described in the
individual files in /usr/share/doc/*/copyright.

Debian GNU/Linux comes with ABSOLUTELY NO WARRANTY, to the extent
permitted by applicable law.
Last login: Wed Jun  9 09:13:38 2021 from 192.168.178.26

Wi-Fi is currently blocked by rfkill.
Use raspi-config to set the country before use.

pi@idefix:~ $ su -

Wi-Fi is currently blocked by rfkill.
Use raspi-config to set the country before use.

root@idefix:~# certbot --apache
Saving debug log to /var/log/letsencrypt/letsencrypt.log
Plugins selected: Authenticator apache, Installer apache
Enter email address (used for urgent renewal and security notices) (Enter 'c' to
cancel): hans-peter.gaugele@t-online.de               

- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
Please read the Terms of Service at
https://letsencrypt.org/documents/LE-SA-v1.2-November-15-2017.pdf. You must
agree in order to register with the ACME server at
https://acme-v02.api.letsencrypt.org/directory
- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
(A)gree/(C)ancel: A

- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
Would you be willing to share your email address with the Electronic Frontier
Foundation, a founding partner of the Let's Encrypt project and the non-profit
organization that develops Certbot? We'd like to send you email about our work
encrypting the web, EFF news, campaigns, and ways to support digital freedom.
- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
(Y)es/(N)o: n
No names were found in your configuration files. Please enter in your domain
name(s) (comma and/or space separated)  (Enter 'c' to cancel): pz-iffeldorf.ddns.net            
Obtaining a new certificate
Performing the following challenges:
http-01 challenge for pz-iffeldorf.ddns.net
Enabled Apache rewrite module
Waiting for verification...
Cleaning up challenges
Created an SSL vhost at /etc/apache2/sites-available/000-default-le-ssl.conf
Enabled Apache ssl module
Deploying Certificate to VirtualHost /etc/apache2/sites-available/000-default-le-ssl.conf
Enabling available site: /etc/apache2/sites-available/000-default-le-ssl.conf

Please choose whether or not to redirect HTTP traffic to HTTPS, removing HTTP access.
- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
1: No redirect - Make no further changes to the webserver configuration.
2: Redirect - Make all requests redirect to secure HTTPS access. Choose this for
new sites, or if you're confident your site works on HTTPS. You can undo this
change by editing your web server's configuration.
- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
Select the appropriate number [1-2] then [enter] (press 'c' to cancel): 2
Enabled Apache rewrite module
Redirecting vhost in /etc/apache2/sites-enabled/000-default.conf to ssl vhost in /etc/apache2/sites-available/000-default-le-ssl.conf

- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
Congratulations! You have successfully enabled https://pz-iffeldorf.ddns.net

You should test your configuration at:
https://www.ssllabs.com/ssltest/analyze.html?d=pz-iffeldorf.ddns.net
- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

IMPORTANT NOTES:
 - Congratulations! Your certificate and chain have been saved at:
   /etc/letsencrypt/live/pz-iffeldorf.ddns.net/fullchain.pem
   Your key file has been saved at:
   /etc/letsencrypt/live/pz-iffeldorf.ddns.net/privkey.pem
   Your cert will expire on 2021-09-09. To obtain a new or tweaked
   version of this certificate in the future, simply run certbot again
   with the "certonly" option. To non-interactively renew *all* of
   your certificates, run "certbot renew"
 - Your account credentials have been saved in your Certbot
   configuration directory at /etc/letsencrypt. You should make a
   secure backup of this folder now. This configuration directory will
   also contain certificates and private keys obtained by Certbot so
   making regular backups of this folder is ideal.
 - If you like Certbot, please consider supporting our work by:

   Donating to ISRG / Let's Encrypt:   https://letsencrypt.org/donate
   Donating to EFF:                    https://eff.org/donate-le

root@idefix:~# service apache2 restart
[/code]

Stelle sicher, dass die Datei [b]/etc/apache2/conf-available/security.conf[/b] existiert und auch aktiviert ist.

[code=none]
touch /etc/apache2/conf-available/security.conf
a2enconf security
[/code]

[block]Entfernen des Serverversionsbanners[/block]

Füge folgende Zeilen in [b]/etc/apache2/conf-available/security.conf[/b] ein:

[code]
ServerTokens Prod
ServerSignature Off
[/code]


[block]Verzeichnislisten, HTTP-Methoden, SSI, Rechte[/block]

Verzeichnisinhalte verbergen, HTTP-Anforderungsmethoden einschränken, SSI verbieten, Rechte setzen

Füge folgende Zeilen in [b]/etc/apache2/conf-available/security.conf[/b] ein:

[code]
<Directory />
        # .htaccess Konfiguration verbieten
        AllowOverride None
        # Anfragen von allen IP Adressen sperren
        Require all denied
        # HTTP-Anfragenmethoden einschraenken
        <LimitExcept GET POST HEAD>
                Deny from all
        </LimitExcept>
</Directory>

<Directory /var/www/>
        # Verzeichnisanzeige und SSI verbieten
        Options -Indexes -Includes
        # alle IP Adressen zulassen
        Require all granted
</Directory>
[/code]


[block]Trace ausschalten[/block]

Füge folgende Zeil in [b]/etc/apache2/conf-available/security.conf[/b] ein:

[code]
TraceEnable Off
[/code]


[block]Verschiedene Header setzen[/block]

mod_headers.so aktivieren.

[i]Alle folgende Befehle als [red]root[/red] ausführen !!![/i]

[code=none]
a2enmod headers
[/code]

Füge folgende Zeilen in [b]/etc/apache2/conf-available/security.conf[/b] ein bzw. ändere sie:

[code]
#
# Setting this header will prevent MSIE from interpreting files as something
# else than declared by the content type in the HTTP headers.
# Requires mod_headers to be enabled.
#
Header set X-Content-Type-Options: "nosniff"

#
# Setting this header will prevent other sites from embedding pages from this
# site as frames. This defends against clickjacking attacks.
# Requires mod_headers to be enabled.
#
Header set X-Frame-Options: "sameorigin"

# Cross Site Scripting-Angriffe abschwaechen
Header edit Set-Cookie ^(.*)$ $1;HttpOnly;Secure
# Clickjacking Attack verhindern
Header always append X-Frame-Options SAMEORIGIN
[/code]

[block]Passwort für Webseite vergeben[/block]

Füge folgende Zeilen in [i]000-default.conf[/i] ein ...

[code]
        <Directory "/var/www/html">
                AuthType Basic
                AuthName "Restricted Content"
                AuthUserFile /etc/apache2/.htpasswd
                Require valid-user
        </Directory>
[/code]

... und bestimme Hans-Peter zum ServerAdmin ;-)

[code]
        ServerAdmin hans-peter.gaugele@t-online.de
[/code]

Dann muss als letztes noch die Datei [i]/etc/apache2/.htpasswd[/i] erstellt werden.

[code]
htpasswd -c -B .htpasswd willy
[/code]


[section]Das DOCUMENT_ROOT auf die Applikation umleiten[/section]

[b]Alle folgende Befehle auf dem [i]Rasperry Pi[/i] als [red][i]pi[/i][/red] ausführen !!![/b]

[code=none]
mkdir /home/pi/html
vi /home/pi/html/index.html
---------------------------------
<html>
 <head>
  <title>Hello World</title>
 </head>
 <body>
  <h1>Hello World</h1>
 </body>
</html>
---------------------------------
[/code]

[b]Alle folgende Befehle auf dem [i]Rasperry Pi[/i] als [red][i]root[/i][/red] ausführen !!![/b]

[code=none]
cd /var/www
mv html/ html.sav
ln -s /home/pi/html/ .
[/code]

Teste indem Du im Browser [url=http://idefix]http://idefix[/url] eingibst.

[section]MySQL Apache2 installieren und konfigurieren[/section]

[b]Alle folgende Befehle auf dem [i]Rasperry Pi[/i] als [red][i]root[/i][/red] ausführen !!![/b]

[code=none]
apt update
apt upgrade
apt install mariadb-server mariadb-client
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

[section]PHP7 installieren und konfigurieren[/section]

[b]Alle folgende Befehle auf dem [i]Rasperry Pi[/i] als [red][i]root[/i][/red] ausführen !!![/b]

[code=none]
apt install php
apt install php-xml
[/code]

Setze die Variable "ServerName" in /etc/apache2/sites-enabled/000-default.conf (lokal setzen) und in/etc/apache2/apache2.conf (global hinzufügen):

[code]
ServerName pz-iffeldorf.ddns.net
[/code]

In der Datei [i]/etc/php/7.3/apache2/php.ini[/i] die Zeitzone wie folgt einstellen.

[code]
date.timezone = Europe/Berlin
[/code]

[code=none]
apache2ctl graceful
service apache2 restart
[/code]


[chapter]Applikationsumgebung schaffen[/chapter]

[section]Perl-Pakete nachinstallieren (ca. 15 Min.)[/section]

[b]Alle folgende Befehle auf dem [i]Rasperry Pi[/i] als [red][i]root[/i][/red] ausführen !!![/b]

[b]CPAN vorbereiten[/b]

[code=none]
cpan
= >>> beim ersten Mal das automatische Konfigurieren bestätigen
install CPAN
reload CPAN
install inc::latest # wird für die vollständige Installation von Net::SNMP und anderen benötigt...
install YAML
install Log::Log4perl
install Term::ReadKey
install Term::ReadLine
install Term::ReadLine::Perl
[/code]

[b]Notwendige Pakete installieren[/b]

[code=none]
install List::MoreUtils
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

[section]PHP7-Pakete nachinstallieren[/section]

[b]Alle folgende Befehle als [red]root[/red] ausführen !!![/b]

[code=none]
apt install php7.3-mysql
apt install php-bcmath
apt install php-gd
service apache2 restart
[/code]

[section]Software auf Idefix bringen[/section]

Aus der aktuellen Sicherung die Dateien und Verzeichnisse im Verzeichnis "idefix" ins Homeverzeichnis des Benutzers "pi" entpacken.

[b]Den folgenden Befehl auf dem Quell-[i]Rasperry Pi[/i] als [red][i]pi[/i][/red] ausführen !!![/b]

[code=none]
cd /home/pi
tar -cvf iffeldorf.tar alarm cache html local
[/code]

Datei auf Ziel-[i]Rasperry Pi[/i] übertragen.

[b]Den folgenden Befehl auf dem Ziel-[i]Rasperry Pi[/i] als [red][i]pi[/i][/red] ausführen !!![/b]

[code=none]
cd /home/pi
tar -xvf iffeldorf.tar
[/code]

[section]Setup der Applikation[/section]

[b]Den folgenden Befehl auf dem Ziel-[i]Rasperry Pi[/i] als [red][i]pi[/i][/red] ausführen !!![/b]

[code=none]
cd /home/pi/local
./setup --check # da sollte alles funktionieren
                # ansonsten ist die [i]config.ini[/i] anzupassen

# ./setup --startup # nicht ausführen bevor die [i]config.ini[/i] korrekt ist
[/code]


[section]Datenbank "willy" auf "idefix" sichern[/section]

[red]Das Sichern der Datenbank sollte regelmäßig geschehen![/red] Die Sicherung kann so wie sie ist nicht zum Einspielen benutzt werden. Deshalb sind hier eine Reihe von Filterungen notwendig. Nur die Tabellen dürfen gefüllt werden, die nicht vom "setup.pl" gefüllt werden. "setup.pl" erzeugt außerdem auch alle Tabellen.

[code=none]
mysqldump --user=pi --databases willy > iffeldorf.sql
gzip iffeldorf.sql

# mysqldump --user=pi --databases willy > iffeldorf.raw.sql
# egrep "^INSERT INTO" iffeldorf.raw.sql > iffeldorf.1.sql
# echo "USE willy;" > iffeldorf.tmp
# cat iffeldorf.tmp iffeldorf.1.sql > iffeldorf.2.sql
# egrep -v '(INSERT INTO `circuit`|INSERT INTO `sensor`)' iffeldorf.2.sql > iffeldorf.sql
# gzip iffeldorf.sql
[/code]

Datei auf Ziel-[i]Rasperry Pi[/i] übertragen.


[section]Datenbank "willy" auf "idefix" einspielen[/section]

Mit der folgenden Prozedur wird die Software initialisiert und konfiguriert und die Datenbank bei einem Recovery wieder aufgebaut.

[b]Den folgenden Befehl auf dem Ziel-[i]Rasperry Pi[/i] als [red][i]pi[/i][/red] ausführen !!![/b]

[code=none]
gunzip iffeldorf.sql.gz
mysql < iffeldorf.sql
./setup.pl --write  # nicht ausführen bevor die config.ini korrekt ist.
[/code]

[blue][23.06.2021][/blue] [url=https://github.com/bozhinov/pChart2.0-for-PHP7]pChart benötigt ein Update um mit PHP 7 kompatibel zu sein.[/url] Dieses Update ist merkwürdiger Weise nur auf der Version 2.0 von pChart zu finden, während für pChart unter PHP6 die Version 2.14 implementiert wurde. Die Schnittstellen sind sehr unterschiedlich zueinander, sodaß hier eine größere Arbeit fällig war.


[chapter]Noch zu tun !!![/chapter]

[list]
[*]*** SSD vom Entwicklungsrechner [b]idefix[/b] mit der vom Produktivrechner tauschen *** [done].
[*]Testumgebung in einem Raum des Pfarrzentrums einrichten. [done]
[*]In der [b]certbot[/b]-Konfiguration ist [b]http://sf8zwrwvhsrshznz.myfritz.net/[/b] noch mit aufzunehmen.
[*]Die Passwörter für den Nutzer [b]pi[/b] und [b]root[/b] sind noch zu setzen. [done]
[*]Wechsele zu [b]Noch zu tun !!![/b] der [b]Version 5[/b]. [done]
[/list]

[section]Notizen[/section]

[b][url=https://certbot.eff.org/docs/using.html?#changing-a-certificate-s-domains]Später eine Domain hinzufügen[/url][/b]

[code]
certbot certonly --cert-name pz-iffeldorf.ddns.net --domains pz-iffeldorf.ddns.net,sf8zwrwvhsrshznz.myfritz.net
[/code]