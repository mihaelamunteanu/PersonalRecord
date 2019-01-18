set dateformatfile=%date:~-4%_%date:~4,2%_%date:~7,2%
echo "" > "C:\\Mihaela\\OTHERP~1\\GITHUB~1\\backup\\PERSON~1\\BackupDB%dateformatfile%.sql"

"C:\Program Files\PostgreSQL\10\bin\pg_dump.exe" --file "C:\\Mihaela\\OTHERP~1\\GITHUB~1\\backup\\PERSON~1\\BackupDB%dateformatfile%.sql" --host "localhost" --port "5432" --username "postgres" --password --verbose --role "postgres" --format=p --create --clean --section=pre-data --section=data --section=post-data --inserts --column-inserts "CabinetRugina"