[title]Protokoll der Entstehung der Version 5.0[/title]

[chapter]Vorüberlegungen[/chapter]

[section]Motivation[/section]

Die Betreiber des cKalender-Portals kündigen seit einiger Zeit eine neue Version an. Dazu wird eine Testversion bereitgestellt um die neue Funktionalität kennen zu lernen und aktiv am Entwicklungsprozess teilnehmen zu können.

In einem separaten Menüpunkt werden die verschiedenen Schnittstellen zum cKalender-Portal zum Testen angeboten, so auch die XML-Schnittstelle. Diese weist grundsätzliche Veränderungen gegenüber der aktuell produktiven Version auf. Die Bezeichner werden jetzt in englischer statt in deutscher Sprache geschrieben. Das allein würde kaum Änderungsaufwand bedeuten.

Jeder Eintrag im cKalender hat eine eigene eindeutige ID. Diese wird aus dem alten System nicht übernommen und hat im neuen System außerdem noch eine ganz andere Zusammensetzung. Eine weitere Änderung ist die Einführung von zwei getrennten Variablen für die Zeitangabe (von, bis). Hier ist der Änderungsaufwand erheblich.

[chapter]Realisierung[/chapter]

In dem Test der neuen Software kann ich dem Entwicklerteam einige Fehler melden und bitte um eine Zuordnungsliste aller alten und neuen IDs. In der Zwischenzeit ändere ich den Code auf unserer Seite und kann noch einige Verbesserungen in der cKalender-Anbindung einbringen, vor allem in dem [i]generator.pl[/i].

Das [i]hpgyear.pl[/i]-Skript zum CSV-Export der cKalender-Einträge zur Weiterverarbeitung in EXCEL ist von den Änderungen auch betroffen.

Ich bereinige die Logik insofern, dass keine Termine mehr angenommen werden, die über Mitternacht hinaus reichen. Sind solche Termine im cKalender vorhanden, ist die tätgliche Wiederholung auszuwählen und eine von-bis Zeit zu wählen. Bei diesem Vorgehen erzeugt der XML-Export einen cKalender-Eintrag pro Tag. Sollten abweichende Heizzeiten pro Tag gewünscht werden, kann das bei den einzelnen Einträgen der Serie abweichend vom Haupteintrag angegeben werden.

[section]Aufbau der neuen XML-Schnittstelle[/section]

In dem Codebeispiel stelle ich die alte und neue Schnittstelle vergleichend dar. Im generellen Aufbau verändert sich wenig. Die Bezeichner werden englisch und bei Schreibweise wechselt der Autor von der Intercapnotation zur Kleinschreibung mit Worttrennung durch Unterstrich. Im Feld [i]Benutzergruppe[/i] in der alten Schnittstelle wird in der neuen im entsprechenden [i]Feld Groups[/i] eine Ebene [i]Group[/i] eingefügt.

[code]
##################################  ALTE SCHNITTSTELLE  ##################################

$VAR1 = {
  'CKTerminResponse' => {
    'CKCopyrightText' => '&#38;#169;
                          &#60;a href=&#39;https://www.ckalender.de/manual/&#39;
                          target=&#39;_blank&#39;&#62;CKalender&#60;/a&#62;
                          -Service 2021 - Ein Produkt von
                          &#60;a href=&#39;https://www.medialines.de&#39;
                          target=&#39;_blank&#39;&#62;medialines Online-Systeme
                          &#60;/a&#62;',
    'CKTermin' => [
      {
        'Text' => '',
        'Verantwortlich' => 'Gemeinde',
        'Benutzergruppe' => [
                              'Gruppenraum',
                              'Jugendtreff'
                            ],
        'Von' => '18.12.2021',
        'Zeitangabe' => '15:00-21:00',
        'Notiz' => '',
        'Titel' => 'Jugend -2C',
        'ID' => '3023216',
        'Bis' => '18.12.2021',
        'Ort' => 'Gruppenraum / Jugendtreff'
      },
      {
        'Verantwortlich' => 'Vermietung',
        'Text' => '',
        'Von' => '28.12.2021',
        'Benutzergruppe' => 'Pfarrsaal',
        'Titel' => 'Joga',
        'Notiz' => 'Frau Thieser',
        'Zeitangabe' => '18.00-21.00',
        'Bis' => '28.12.2021',
        'Ort' => 'Pfarrsaal',
        'ID' => '2165946'
      }
    ]
  }
};


##################################  NEUE SCHNITTSTELLE  ##################################

$VAR1 = {
  'ck_events' => {
    'ck_copyright_text' => '&#38;#169;
                           &#60;a href=&#39;https://v2.ckalender.de/&#39;
                           target=&#39;_blank&#39;&#62;CKalender&#60;/a&#62;
                           -Service 2021 - Ein Produkt von
                           &#60;a href=&#39;https://www.medialines.de&#39;
                           target=&#39;_blank&#39;&#62;medialines Online-Systeme
                           &#60;/a&#62;',
    'ck_event' => [
      {
        'mapping' => 'public',
        'place' => 'Gruppenraum / Jugendtreff',
        'groups' => {
                      'group' => [
                                   'Gruppenraum',
                                   'Jugendtreff'
                                 ]
                    },
        'cycle' => 'weekly',
        'cycle_interval' => '2',
        'until_date' => '2021-12-18',
        'id' => '1149552_2021-12-18',
        'title' => 'Jugend -2C',
        'from_date' => '2021-12-18',
        'plan_state' => 'fix',
        'until_time' => '21:00',
        'updated_at' => '2020-03-11 16:24:38',
        'from_time' => '15:00',
        'responsible' => 'Gemeinde'
      },
      {
        'note' => 'Frau Thieser',
        'mapping' => 'public',
        'groups' => {
                      'group' => 'Pfarrsaal'
                    },
        'place' => 'Pfarrsaal',
        'cycle_interval' => '1',
        'cycle' => 'weekly',
        'id' => '1149551_2021-12-28',
        'title' => 'Joga',
        'until_date' => '2021-12-28',
        'until_time' => '21:00',
        'plan_state' => 'fix',
        'from_date' => '2021-12-28',
        'updated_at' => '2020-03-06 19:40:05',
        'from_time' => '18:00',
        'responsible' => 'Vermietung'
      }
    ]
  }
};
[/code]

[section]Aufbau der einzelnen Datensätze[/section]

Im Folgenden stelle ich die alte und neue Schnittstelle in drei Beispiel-Datensätzen gegenüber. Im Wesentlichen wird hier 1:1 aus dem Deutschen ins Englische übersetzt. Was jedoch auffällt ist, dass das alte Feld [i]Benutzergruppe[/i] in ein neues Feld [i]Groups[/i] mit einer neue Ebene [i]Group[/i] übersetzt wird. Das kostet nur eine Zeile Veränderung. Die Umsetzung des Feldes [i]Zeitangabe[/i] in die neuen Felder [i]from_time[/i] und [i]until_time[/i] bedeutet für die Skripte [i]generator.pl[/i] und [i]hpgyear.pl[/i] eine größere Änderung.

[code]
######## ALTE SCHNITTSTELLE ##############      ######## NEUE SCHNITTSTELLE ##############
{                                               {
  'ID' => '3023216',                              'id' => '1149552_2021-12-18',
  'Titel' => 'Jugend -2C',                        'title' => 'Jugend -2C',
  'Text' => '',                                 
  'Von' => '18.12.2021',                          'from_date' => '2021-12-18',
  'Bis' => '18.12.2021',                          'until_date' => '2021-12-18',
  'Zeitangabe' => '15:00-21:00',                  'from_time' => '15:00',
                                                  'until_time' => '21:00',
  'Notiz' => '',                                
  'Verantwortlich' => 'Gemeinde',                 'responsible' => 'Gemeinde',
  'Ort' => 'Gruppenraum / Jugendtreff',           'place' => 'Gruppenraum / Jugendtreff',
  'Benutzergruppe' => [                           'groups' => {                            
                        'Gruppenraum',              'group' => [               
                        'Jugendtreff'                  'Gruppenraum',
                      ]                                'Jugendtreff'
},                                                  ]
                                                  },
                                                
                                                  'cycle' => 'weekly',
                                                  'cycle_interval' => '2',
                                                  'mapping' => 'public',
                                                  'plan_state' => 'fix',
                                                  'updated_at' => '2020-03-11 16:24:38'
                                                },
{                                               {
  'ID' => '2165946',                              'id' => '1149551_2021-12-21',
  'Titel' => 'Joga',                              'title' => 'Joga',
  'Text' => '',                                  
  'Von' => '21.12.2021',                          'from_date' => '2021-12-21',
  'Bis' => '21.12.2021',                          'until_date' => '2021-12-21',
  'Zeitangabe' => '18.00-21.00',                  'from_time' => '18:00',
                                                  'until_time' => '21:00',
  'Ort' => 'Pfarrsaal',                           'place' => 'Pfarrsaal',
  'Notiz' => 'Frau Thieser',                      'note' => 'Frau Thieser',
  'Verantwortlich' => 'Vermietung',               'responsible' => 'Vermietung',
  'Benutzergruppe' => 'Pfarrsaal'                 'groups' => {
},                                                  'group' => 'Pfarrsaal'
                                                  },
                                                  'cycle' => 'weekly',
                                                  'cycle_interval' => '1',
                                                  'mapping' => 'public',
                                                  'plan_state' => 'fix',
                                                  'updated_at' => '2020-03-06 19:40:05'
                                                },
                                                
{                                               
  'ID' => '5003088',                              **** Die Gruppe Ferien wird über die ****
                                                  **** Aufruf URL herausgefiltert. ****
  'Titel' => 'Weihnachsferien 24.12. - 8.1.',
  'Text' => '',
  'Von' => '24.12.2021',
  'Bis' => '08.01.2022',
  'Zeitangabe' => '',
  'Ort' => '',
  'Notiz' => '',
  'Verantwortlich' => '',
  'Benutzergruppe' => 'Ferien'
},                                              
{                                               {
  'ID' => '2165946',                              'id' => '1149551_2021-12-28',
  'Titel' => 'Joga',                              'title' => 'Joga',
  'Text' => '',                                 
  'Von' => '28.12.2021',                          'from_date' => '2021-12-28',
  'Bis' => '28.12.2021',                          'until_date' => '2021-12-28',
  'Zeitangabe' => '18.00-21.00',                  'from_time' => '18:00',
                                                  'until_time' => '21:00',
  'Ort' => 'Pfarrsaal',                           'place' => 'Pfarrsaal',
  'Notiz' => 'Frau Thieser',                      'note' => 'Frau Thieser',
  'Verantwortlich' => 'Vermietung',               'responsible' => 'Vermietung',
  'Benutzergruppe' => 'Pfarrsaal'                 'groups' => {
}                                                   'group' => 'Pfarrsaal'
                                                  },
                                                  'cycle' => 'weekly',
                                                  'cycle_interval' => '1',
                                                  'mapping' => 'public',
                                                  'plan_state' => 'fix',
                                                  'updated_at' => '2020-03-06 19:40:05'
                                                }
[/code]

[section]Aufruf der neuen Schnittstelle[/section]

Der Aufbau der alten und neuen Schnittstelle unterscheiden sich in einigen sehr wichtigen Eigenschaften. Die neue Schnittstelle wirft ohne eine Angabe eines Benutzers keine Datensätze aus. Die Angabe eines Admin-Benutzers wird notwendig, was sehr irritierend ist. Der Betreiber stellt unter dem Menüpunkt [i]Administration[/i] einige Schnittstellen bereit, so auch die von uns benötigte XML-Schnittstelle. Dort kann man die URL zusammenbauen lassen, je nachdem welche Parameter man auswählt. Im Default-Angebot wird kein Datensatz ausgegeben.

Um auch zykliche Termine zu erhalten ist im oberen Bereich [i]auch zyklische Termine[/i] zu markieren.

In dem optionalen Punkt [i]Optionale Einblendungen nicht öffentlicher Inhalte - nur mit Spezialberechtigung möglich[/i] muss dann ein Benutzer und die entsprechenden Gruppen ausgewählt werden. Hier kommt es darauf an, dass ein Admin ausgewählt wird, ansonsten werden nur die Einträge gelistet, die ein einfacher Benutzer sehen kann.

Die Gruppen [i]AN_ALLE[/i] und [i]Ferien[/i] sind zu deselektieren; alle anderen auszuwählen. Damit ändert sich auch die "config.ini".

[code]
##################################  ALTE SCHNITTSTELLE  ##################################

https://www.ckalender.de/system/modul_termine_xml.php
        ?OrgID=4980
        &OrgPW=***
        &Zyklisch=ja
        &VonDatumD=tt.mm.jjjj
        &BisDatumD=tt.mm.jjjj
        &Planungsstatus=alle
        &Anzeigestatus=alle
        &Gruppen=*


##################################  NEUE SCHNITTSTELLE  ##################################

https://v2.ckalender.de/module.xml.php
        ?org_id=4980
        &user_id=16277
        &user_code=***
        &group_ids=9891%2C9899%2C9892%2C9893%2C9894%2C9895%2C9897%2C9898
        &show_cyclic=1
        &from_date=yyyy-mm-dd
        &until_date=yyyy-mm-dd
        &plan_states=fix
        &mappings=public
[/code]

[section]Ändeurngen in der config.ini[/section]

In der [i]config.ini[/i] der Applikationssoftware wird der Eintrag [i]General - cKalender[/i] geändert. Dort wird statt des [i]OrgCode[/i] zwei neue Felder eingefügt: [i]UserId[/i] und [i]UserCode[/i]. Ebenfalls wird das Feld [i]GroupIds[/i] eingeführt, in dem jetzt alle anzuzeigende Gruppen aufgelistet werden. Damit entfällt die Angabe [i]Filter[/i] (z.B. [i]Ferien[/i]) in der [i]config.ini[/i].

[code]
            ; OrgId, UserId,  UserCode, GroupIds,                   Preview (Days)
            ;  |      |        |         |                                      |
cKalender = ("4980", "16277", "***","9891,9899,9892,9893,9894,9895,9897,9898", 21)
[/code]

Da die Spezifikation vorangegangener Version der Steuersoftware keine Termine zulassen sollte, die über Mitternacht hinaus gehen, wird die Angabe von [i]History (Days)[/i] nicht mehr benötigt und das versteckte Feature konsequent entfernt und durch Fehlermeldungen ersetzt.

[section]Umwandlung der neuen ID[/section]

Die neue ID ist für das entsprechende Feld in unserer Datenbank zu lang und hat das falsche Format. Unter- und Bindestriche sind für die Darstellung in einem [i]bigint(14) unsigned[/i] nicht geeignet. Daher werden diese Zeichen benutzt um die einzelnen Felder voneinander zu trennen und dann wird die ID in einer sinnvollen Weise wieder zusammen gesetzt und so in unserem System verwendet. Das ist möglich, da in unserem System ein späterer Rückgriff auf die cKalender Daten nicht von Nöten ist.

[code]
# Komprimierung der neuen ID. So passt die ID in das entsprechende Datenbankfeld ;-)
# "*ID****_YYYY-MM-DD" ===>> "YYMMDD*ID****"
my ($tid,$tyy,$tmm,$tdd) = ($id =~ m/(\d+)_20(\d+)-(\d+)-(\d+)/);
my $id = $tyy.$tmm.$tdd.$tid;
[/code]

[section]Weitere Neuerungen[/section]

Der Preview, der in der [i]config.ini[/i] derzeit auf 21 Tage eingestellt ist, wird nun auf der Internetseite unter [i]status[/i] - auf Wunsch der Benutzer - vollständig angezeigt.

[latest]

[chapter]Noch zu tun !!![/chapter]

[list]
[*][b]setup2.pl[/b] auf [b]setup.pl[/b] umbenennen. [done]
[*][b]generator2.pl[/b] auf [b]generator.pl[/b] umbenennen. [done]
[*][b]hpgyear2.pl[/b] auf [b]hpgyear.pl[/b] umbenennen. [done]
[*][b]TdkRO[/b] aus [b]config.ini[/b] entfernen. [done]
[*][b]Controller[/b] in [b]config.ini[/b] auf lokalen Betrieb zurücksetzen. [done]
[*]Testen des [b]setup.pl --write[/b]. [done]
[*]Testen des [b]generator.pl --check --debug[/b]. [done]
[*]Testen des [b]generator.pl --check[/b]. [done]
[*]Testen des [b]generator.pl --write[/b]. [done]
[*]Testen des [b]commander.pl --debug[/b]. [done]
[/list]