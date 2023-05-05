# MongoDB-Facade-Crud
Inlämningsuppgift Jin23DA
## Uppgiften
Du ska skapa en modell för Person, den ska sedan ärvas av Kund och Anställd.
+ [x] Klart programmet hanterar tre typer av Person objekt, Person, Customer och Employee. 
Skapa en Java-modell för "Person" med följande egenskaper: "namn", "ålder" och "adress".
+ [x] Klart blev flera fält för adressen
Skapa två underklasser av Person: "Kund" och "Anställd". Kund ska ha en ytterligare egenskap "kundnummer" och Anställd ska ha en ytterligare egenskap "anställningsnummer".
+ [x] Klart
Skapa en MongoDB-fasad som kan hantera CRUD (Create, Read, Update, Delete) för både Person och Anställd.
+ [x] Klart 
Använda MongoDB Java Driver för att interagera med MongoDB.
+ [x] Klart använder mongodb-jdbc-2.0.2-all.jar
Skapa en Main-metod där du skapar ett antal Person-objekt, Kund-objekt och Anställd-objekt, och sedan sparar dem i MongoDB-fasad. Du kan sedan uppdatera och ta bort dem från databasen.
+ [x] fungerar lite på samma sätt som test
Tänk på att om programmet inte kan hitta en nyckel till servern, ska den utgå ifrån att connectionstring är mongodb://localhost:27017/{dinDatabas}
+ [x] Skapat möjlighet är dock otestat. 
Projektet ska lämnas in som zipfil hämtad från Github
I Readme filen ska det finnas förklaringar till alla MongoDB-anrop i MongoDB-fasaden.
+ connect() ansluter till databasen
+ insertOne() tar emot ett personobjekt och konverterar till Document som läggs upp i databasen
+ findName() findById() findByAge() findByCustomerNo() findByEmployeeNo() Tar imot String eller int sökning i specifika fält
+ delete() tar emot objectId och tar bort ifrån databasen
+ update() tar emot ett String med _id och ett uppdaterat personobjekt
+ find() tar emot en string för namn och retunerar en lista med Person objekt
+ findType() tar emot String hittar Dokument i databasen som har det fältet
+ findAll() Hittar alla Dokument som har fältet "namn"
+ close() stänger anslutningen till databasen

Checklista finns i filen checklist.md

