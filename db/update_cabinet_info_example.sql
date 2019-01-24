--   run: 
--   "C:\Program Files\PostgreSQL\11\bin\psql" -U postgres -a -f "C:\Mihaela\Other projects\Github website\MedicalRecord\db\update_cabinet_info_example.sql"

\connect "CabinetRugina";

UPDATE public.cabinet SET data_modificare=NOW(), folder_salvare='D:\\DosareMedicale\\' WHERE id=1 OR id=2;