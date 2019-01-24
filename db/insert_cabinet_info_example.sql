--   run: 
--   "C:\Program Files\PostgreSQL\11\bin\psql" -U postgres -a -f "C:\Mihaela\Other projects\Github website\MedicalRecord\db\update_cabinet_info_example.sql"

\connect "CabinetRugina";

INSERT INTO public.cabinet(nume, adresa, telefon, data_modificare, folder_salvare)
	VALUES ('C.M. Dr. RUGINA', 'Str. Bd. 9Mai, nr. 1, Bl. A13, Ap.2', '0233-237969', NOW(), 'D:\\DosareMedicale\\');
			
INSERT INTO public.dbversion(versiune, data_rulare, observatii)
	VALUES ('1.2', NOW(), 'Script noi date pentru cabinet');