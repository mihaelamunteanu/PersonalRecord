# PersonalRecord
 Application that keeps a record history

# Installation of PostgreSQL: 
https://www.labkey.org/Documentation/wiki-page.view?name=installPostgreSQLWindows
StackBuilder Application to install other PostgreS related  apps

pgAdmin4 - app 
pass root 

#14.12.2018
TODO:
GABI: - add prenume in fields; 
      - arrange search Panel: distance between fields on y axe and bigger size text field: maybe 25;
	  - calendar in loc de String date (nu facem pana nu discutam, s-ar putea sa ii fie mai usor sa scrie de mana.

- if the connection with DB is down try t reset it in he singleton.
- add fotos with the drawn screens;
- add instructions for DB;
- add sql for DB; 
- fix the screen display (buttons, text, labels etc.) according to the images;
- fix the Date for Java and DB and swing throughout the app;
- add BLOB attachments to Consultation;
- generate PDF from a Consultation;
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
   
   