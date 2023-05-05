# MongoDB-Facade-Crud
Inlämningsuppgift Jin23DA
## Uppgiften
Du ska skapa en modell för Person, den ska sedan ärvas av Kund och Anställd.
+ [x] Klart progamet hanterar tre typer av Person objekt, Person, Customer och Employee. 
Skapa en Java-modell för "Person" med följande egenskaper: "namn", "ålder" och "adress".
+ [x] Klart blev flera fält för addressen
Skapa två underklasser av Person: "Kund" och "Anställd". Kund ska ha en ytterligare egenskap "kundnummer" och Anställd ska ha en ytterligare egenskap "anställningsnummer".
+ [x] Klart
Skapa en MongoDB-fasad som kan hantera CRUD (Create, Read, Update, Delete) för både Person och Anställd.
+ [x] Klart 
Använda MongoDB Java Driver för att interagera med MongoDB.
+ [x]
Skapa en Main-metod där du skapar ett antal Person-objekt, Kund-objekt och Anställd-objekt, och sedan sparar dem i MongoDB-fasad. Du kan sedan uppdatera och ta bort dem från databasen.
+ [x] fungerar lite på samma sätt som test
Tänk på att om programmet inte kan hitta en nyckel till servern, ska den utgå ifrån att connectionstring är mongodb://localhost:27017/{dinDatabas}
+ [ ] har ej provat att köra lokalt, 
Projektet ska lämnas in som zipfil hämtad från Github
I Readmefilen ska det finnas förklaringar till alla MongoDB-anrop i MongoDB-fasaden.
+ 

Checklista finns i filen checklist.md

