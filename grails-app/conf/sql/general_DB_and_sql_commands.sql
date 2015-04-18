
CREATE USER 'startu60_serrano' @'localhost' IDENTIFIED BY 'oGo-S84-RLR-ogf';
GRANT ALL PRIVILEGES ON *.* TO 'startu60_serrano'@'localhost' WITH GRANT OPTION;

mysql --host=localhost --user='startu60_serrano' --password='oGo-S84-RLR-ogf' startu60_StartupEcosystemCanvas

mysqldump -u 'startu60_serrano' --password='oGo-S84-RLR-ogf' startu60_StartupEcosystemCanvas > '/Users/proyectoweb/Documents/RSN/grails_apps/dumpfilename.sql'

CREATE TEMPORARY TABLE SalesSummary (product_name VARCHAR(50) NOT NULL);


select * from tablename   INTO OUTFILE  '/tmp/filename.csv'  FIELDS TERMINATED BY ',' LINES TERMINATED BY '\n';

mysqldump -u [username] -p [database_name] > [dumpfilename.sql]