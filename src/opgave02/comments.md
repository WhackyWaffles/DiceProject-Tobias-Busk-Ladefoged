Fjern sammenligninger med true og false. F. eks. kan 

    (winCon == true || loseCon == true)

skrives som

    (winCon || loseCon)

---

Jeres if statement 

    if (rollCount == 1 && rollSum == 7) {
    winCon = true;
    } else if (rollCount == 1 && rollSum == 11) {
    winCon = true;
    } else if (rollCount == 1 && rollSum == 2) {
    ...

kunne være en del simplere, man kan strukturerer koden således at man ved at det er 
det første slag, så I ikke behøver rollCount tjekket.


