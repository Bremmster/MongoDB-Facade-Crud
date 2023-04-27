# MongoDB-Facade-Crud
Inlämningsuppgift Jin23DA

Du ska skapa en modell för Person, den ska sedan ärvas av Kund och Anställd.

Skapa en Java-modell för "Person" med följande egenskaper: "namn", "ålder" och "adress".

Skapa två underklasser av Person: "Kund" och "Anställd". Kund ska ha en ytterligare egenskap "kundnummer" och Anställd ska ha en ytterligare egenskap "anställningsnummer".

Skapa en MongoDB-fasad som kan hantera CRUD (Create, Read, Update, Delete) för både Person och Anställd. 
Använda MongoDB Java Driver för att interagera med MongoDB.

Skapa en Main-metod där du skapar ett antal Person-objekt, Kund-objekt och Anställd-objekt, och sedan sparar dem i MongoDB-fasad. Du kan sedan uppdatera och ta bort dem från databasen.

Tänk på att om programmet inte kan hitta en nyckel till servern, ska den utgå ifrån att connectionstring är mongodb://localhost:27017/{dinDatabas}

Projektet ska lämnas in som zipfil hämtad från Github

I Readmefilen ska det finnas förklaringar till alla MongoDB-anrop i MongoDB-fasaden.
