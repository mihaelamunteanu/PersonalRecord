---- git commands ---
git pull 
git add fisier
git commit -m "mesaj"
git push -u origin master

# PersonalRecord
 Application that keeps a record history

# Installation of PostgreSQL: 
https://www.labkey.org/Documentation/wiki-page.view?name=installPostgreSQLWindows
*64 bits version for Windows
*root/root sau 123456?
*stackBuilder install: pgJDBC

StackBuilder Application to install other PostgreS related  apps

pgAdmin4 - app 
pass root 

# 16.01.2019
- logs
- validare
- format data preferat
- etichete
- clean code
- comments
- button navigation
- bat for app
- DB tests
- DB backup procedure
- versiune DB in tabel nou
- DB installation procedure
- doc
- testsicon to run app
- organize folders for Db
- sav and open files naming convention and folder


#08.01.2018
- vorbit cu Cosmin  in ce format vrea data, ce vrea la antet, daca sunt ok etichetele
- save pdf locally - 2 h
- (ecran setari cu path unde sa se salveze fisierele, cu path default de unde sa incarce fisierele) - 2h
- upload files - ok 
- rearranged and reimplemented screens x 7 - 14h
- clean code, add comments - 3h
- fix buttons navigation  - 2h 
- validation and throw exception -4h
- logs - 4h 
- tests - 5h 
- icon to run app - 3h 
- DB test- Db back-up: backup users: http://www.postgresonline.com/journal/archives/81-Backing-up-Login-Roles-aka-Users-and-Group-Roles.html - 4h 
- document - 4h 
- automatic DB back-up - 10h
- back-up reminder - 5h
- log in DB?
- versiune DB intr-un tabel nou
-------------------------------------------------------
TOTAL : 63 h

#26.12.2018
TODO:
- arranged screens; 
- scroll - ok
- in list of patients the buttons should be alligned in a table so that is clear which button is for which name
- check another app to see an example (I am not sure that app has scrool?)
- sa se poate selecta datele din consultatie: campuri readonly
- update patient and insert new antecedent
- add examination text area - ok 
- add previous examinations - ok 
- add atasamente - ok 
- generate pdf - ok 
- fix buttons navigation 
- clean code, add comments etc. : 
- scot commit din cod, ca este autocommit pe DB - ok 
- throw Exceptions and display a dialog Box, 
- check flow of application inside code and see if it is ok
- add minimal validation on screens
- tests

#14.12.2018
TODO:
GABI: - add prenume in fields; 
      - arrange search Panel: distance between fields on y axe and bigger size text field: maybe 25;
	  - calendar in loc de String date (nu facem pana nu discutam, s-ar putea sa ii fie mai usor sa scrie de mana.

- ask Cosmin about special characters (romanian)
- if the connection with DB is down try t reset it in he singleton.
- add fotos with the drawn screens;
- add instructions for DB;
- add sql for DB; 
- fix the screen display (buttons, text, labels etc.) according to the images;
- fix the Date for Java and DB and swing throughout the app;
- add BLOB attachments to Consultation;
- generate PDF from a Consultation: refine test and update class;
- save PDFs and attachements also locally;
- add validation on screens (first thing when pressing a button)
- add Cancel buttons;
- add tests (optional);
- code; 
- tables;


#04.12.2018
Dupa discutia cu Cosmin: 
Ecranul de cautare pacient: 
 - cautare dupa nume, cnp, numar de telefon
 - cand se apasa butonul Pacienta noua se deschide ecranul de Pacient noua
 - cand se apasa cautare se merge la ecranul de lista pacienti cu pacientii filtrati dupa campurile completate aici

Ecran Pacient nou: 
 - Campuri de nume, prenume, cnp, data de nastere, nasteri naturale, cezariene, avorturi la cerere, avorturi spontane, 
   text area de Antecedente
   
   
   
<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html> 
<body>
<style type="text/css" media="print"/>

  
  <table style="border: 1px solid;" width="840">
    <tr><td></td><td></td></tr>
    <tr><td></td><td></td></tr>
    <tr bgcolor="#FFFFEA">
      <td style="text-align:left"><h2>C.M. Dr. RUGINA</h2></td>
      <td style="text-align:right">
          Str. Bd. 9Mai, nr. 1, Bl. A13, Ap.2 <br/>
          Telefon: 0233-237969 <br/>
      </td>
    </tr>
    <tr><td></td><td></td></tr>
    <tr><td></td><td></td></tr>
    <tr><td></td><td></td></tr>
    <tr><td></td><td></td></tr>
    <tr><td></td><td></td></tr>
    <tr>
      <td style="text-align:left">Pacient: <xsl:value-of select="catalog/prenume"/>&#160;<xsl:value-of select="catalog/nume"/>&#160;&#160;</td>
      <td style="text-align:right">CNP: <xsl:value-of select="catalog/cnp"/>&#160;&#160;&#160;&#160;Telefon: <xsl:value-of select="catalog/telefon"/></td>
    </tr>
    <tr><td></td><td></td></tr>
    <tr><td></td><td></td></tr>
    <tr><td></td><td></td></tr>
    <tr><td></td><td></td></tr>
    <tr><td></td><td></td></tr>
    <tr><td></td><td></td></tr>
    <tr>
      <td style="text-align:left"> <b>Consultatie din data de <xsl:value-of select="catalog/DataConsultatie"/> </b> </td>
      <td style="text-align:left"></td>
    </tr>
    <tr><td></td><td></td></tr>
    <tr>
       <td colspan="2">
          <textarea rows="80" cols="111"/>
       </td>
    </tr>
    <tr><td></td><td></td></tr>
    <tr><td></td><td></td></tr>
    <tr>
        <td style="text-align:center">Semnatura: </td>
        <td style="text-align:center">Data: </td>
    </tr>
    <tr><td></td><td></td></tr>
    <tr><td></td><td></td></tr>
    <tr><td></td><td></td></tr>
  </table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>





<?xml version="1.0" encoding="UTF-8"?>
<catalog>
  <nume>Munteanu</nume>
  <prenume>Mihaela</prenume>
  <cnp>2830404240024</cnp>
  <telefon>0744489899</telefon>
 
</catalog>

