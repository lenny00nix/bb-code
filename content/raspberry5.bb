[title]Installation von Raspberry OS auf RaspberryPi 5[/title]

[chapter]Realisierung[/chapter]

[big][b]Notwendigen Hardware[/b][/big]

[list=1]
[*] Raspberry Pi 5 8 GB ohne Betriebssystem [done]
[*] Gehäuse mit Lüfter [done]
[*] USB-Netzgerät [done]
[*] LAN Kabel [done]
[*] USB-Ladegerät HN Power HNP15-MicroUSBL6 HNP15-MicroUSBL6 (10,95 Euro) [done]
[*] 128GB SD-Karte [done]
[/list]

[chapter]Anleitung zur Installation[/chapter]

[section]Hardware[/section]

- Rasperry Pi db-tronic Starterset 8 GB
- Die vier Gummipads unter das Gehäuse in die vorgesehenen Vertiefungen kleben
- Den Alu-Kühlkörper auf den Prozessor kleben, ganz so wie auf der Zeichnung.
- Die Abdeckung von dem FAN-Anschluss auf dem Board bei den USB Buchsen abnehmen
- Lüfterstecker in den FAN-Anschluss stecken.
- Platine in Unterteil des Gehäuses einlegen und Gehäuse zusammenstecken.

[section]Betriebssystem[/section]

- SD-Karte in mitgelieferten Kartenleser stecken
- Kartenleser in USB-Buchse in Computer stecken
- [url=https://etcher.balena.io/#download-etcher]https://etcher.balena.io/#download-etcher[/url]
- oder für Linux lade hier das deb-File [url=https://github.com/balena-io/etcher/releases]https://github.com/balena-io/etcher/releases[/url]
- Installiere Balena Etcher auf dem Computer
- Gehe nach: [url=https://www.raspberrypi.com/software/operating-systems/#raspberry-pi-os-64-bit]https://www.raspberrypi.com/software/operating-systems/#raspberry-pi-os-64-bit[/url]
- Lade Raspberry Pi OS Lite für 64-bit Systeme und Debian 12 (bookworm) herunter
- Öffne Balena Etcher und öffne als Image die heruntergeladene Datei
- Öffne als SD-Karte die SD-Karte für den Raspberry Pi im Kartenleser
- Starte den Flashvorgang

[b]Navigiere zu der boot Partition und lege dort eine leere Datei namens "ssh" an[/b]

Unter Linux geht das so:

[code=none]
touch /media/[benutzer]/bootfs/ssh
[/code]

[b]Erstelle zu dieser Datei eine neue userconf-Datei mit dem Inhalt: "pi:[verschlüsseltes Passwort]"[/b]

Das geht unter Linux so:

[code=none]
echo '12345678' | openssl passwd -6 -stdin
echo "pi:$6$lkUtSImpvKrYgBg7$Oy2QKrfjfOcvcqkStn3C4/JKq4zt9Oa8ZHghN27fV1Am63LAitHicl9Oq5nXyfDbIOKghT5gsWs20FxEPdvqb." > /media/lenny/bootfs/userconf
[/code]

- Trenne die SD-Karte vom Betriebssystem
- Entferne die SD-Karte aus dem Leser

- Stecke die SD-Karte in den Raspberry Pi
- Verbinde das Netzteil mit dem Raspberry Pi
- Verbinde den Raspberry Pi mit den Router
- Stecke das Netzteil in die Steckdose

[b]Logge Dich in einer shell auf dem Raspberry Pi[/b]
Das geht unter Linux so:

[code=none]
ssh pi@raspberrypi
# benutze das Passwort "12345678"
[/code]

ändere das Passwort in "*******"

[code=none]
passwd
[/code]

Das Betriebssystem aktualisieren

[red]Als root einloggen...[/red]

[code=none]
sudo -i
apt update
apt upgrade
[/code]

**** Jetzt ist Raspberry Pi OS Lite auf Deinem Raspberry Pi installiert und auf dem neuesten Stand. ****

[section]Host benennen und Zeitzone setzen[/section]

[red]Als root agieren...[/red]

[code=none]
echo lion > /etc/hostname
sed -i "s/127.0.1.1.*raspberrypi/127.0.1.1\tlion/g" /etc/hosts
[/code]

[red]Als root agieren...[/red]

[code=none]
rm /etc/localtime
echo "Europe/Berlin" > /etc/timezone
dpkg-reconfigure -f noninteractive tzdata
[/code]

[red]Als root agieren...[/red]

[code=none]
sync
reboot
[/code]

[section]EVCC installieren[/section]

Lese hier die [url=https://docs.evcc.io/docs/installation/linux]Installationsanweisungen[/url] für EVCC auf Raspberry Pi OS.
