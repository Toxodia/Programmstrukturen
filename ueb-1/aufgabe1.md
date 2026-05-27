Zu erstellen ist ein Java Programm, welches für einen gegebenen Bereich von 
Zahlen die folgenden Untersuchungen für jede Zahl durchführt:

- ist die Zahl aufsteigend
- ist die Zahl fröhlich
- enthält die Zahl eine Folge von binären 1en. 

## Vorgaben und Vorgehensweise

Erstellt im Paket `ueb` eine Klasse `Main` mit _main()_-Funktion.  
 
#### Hilfsfunktionen

Legt mindestens folgende Hilfsfunktionen an und prüft ihre Funktionalität 
durch (später zu löschende) Testaufrufe aus der _main()_.

- `public static int getDigitCount(int num)`: liefert die Anzahl der Ziffern der Dezimalzahl
- `public static int getDigitAt(int num, int index)`: liefert die Ziffer der Zahl am Index. Die Ziffer, die die Einerstelle beschreibt, hat den Index 1 (Bsp: getDigitAt(456, 1) → 6)
- `public static String toBinaryString(int num)`: Liefert die Binärdarstellung der Zahl. Beispiel: `toBinaryString(11)` => `"1011"`  
  In dieser Methode soll mit Bitverschiebung und/oder [Bitmaskierung](https://en.wikipedia.org/wiki/Mask_(computing)) gearbeitet werden (kein Potenzieren, Multiplizieren, Subtrahieren, Dividieren). Der Ergebnisstring darf durch Konkatenation von Strings entstehen.

#### Für jede der folgend erklärten Prüfungen 

  soll eine `public static boolean` Funktion erstellt werden, die als Parameter mindestens die zu
  prüfende Zahl erhält. Es dürfen weitere Funktionen erstellt werden, um eine
  bessere Modularisierung zu erreichen.

- Eine Zahl gilt als **aufsteigend** (ascending), wenn ihre Ziffern von links
  nach rechts streng größer werden (also auch nicht gleich bleiben).
  Da eine Ziffer eine positive Zahl ist, gilt dies gleichermaßen für
  positive und negative Zahlen.

  Beispiele:

  - `isAscending(1)` => `true`
  - `isAscending(11)` => `false`, 1 ≤ 1
  - `isAscending(21)` => `false`, 2 > 1
  - `isAscending(12)` => `true`
  - `isAscending(121)` => `false`, 2 > 1
  - `isAscending(122)` => `false`, 2 ≤ 2
  - `isAscending(123)` => `true`


- Eine Zahl gilt als **fröhlich** (happy), wenn das wiederholte Aufsummieren
  der quadrierten Ziffern in der Zahl 1 endet und **nicht** in der Zahl 4.
  Das folgende Beispiel zeigt Schritt für Schritt, warum die Zahl 13 (und auch
  die Zahl 10) eine fröhliche Zahl ist:

  - Die Ziffern von 13 sind 1 und 3. 1² bleibt 1, 3² ist 9, die Summe der beiden ist 10.
  - Die Ziffern von 10 sind 1 und 0. 1² bleibt 1, 0² ist 0, die Summe der beiden ist 1.

  Im Gegensatz dazu ist die Zahl 42 (und auch die Zahl 20) nicht fröhlich:

  - Die Ziffern von 42 sind 4 und 2. 4² ist 16, 2² ist 4, die Summe der beiden ist 20.
  - Die Ziffern von 20 sind 2 und 0. 2² ist 4, 0² ist 0, die Summe der beiden ist 4.

  Beispiele:

  - `isHappy(1)` => `true`, 1
  - `isHappy(2)` => `false`, 2 → 4
  - `isHappy(7)` => `true`, 7 → 49 → 97 → 130 → 10 → 1
  - `isHappy(13)` => `true`, 13 → 10 → 1
  - `isHappy(14)` => `false`, 14 → 17 → 50 → 25 → 29 → 85 → 89 → 145 → 42 → 20 → 4
  - `isHappy(15)` => `false`, 15 → 26 → 40 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4


- Eine Zahl hat eine **Folge von binären 1**, wenn die Länge der Folge (Anzahl der aufeinanderfolgenden binären 1en) größer oder gleich einer gegebenen Mindestlänge ist.  
  Die Methode dafür benötigt also zwei Parameter: Die zu untersuchende Zahl kommt zuerst, die erforderliche Mindestlänge als Zweites.  
  Dieser Teil der Aufgabe darf nicht mit Multiplikation, Division, Modulo-Operation oder Potenzieren gelöst, sondern es muss mit [Bitmaskierung](https://en.wikipedia.org/wiki/Mask_(computing)) und/oder Bitverschiebung gearbeitet werden.

  _**TIPP**: Der Compiler wandelt die von uns dezimal angegebenen Werte zum Ablegen im Speicher selbsttätig in ein Binärformat um. Zum Anzeigen in der Ausgabe wird die Zahl wieder in ein Dezimalformat gewandelt. Um eine Zahl im Binärformat zu untersuchen, muss sie also nicht konvertiert werden! Nur wenn sie binär angezeigt werden soll, müssen wir eine Konvertierung vornehmen
  (dafür haben wir toBinaryString() erstellt)._

  Beispiele:

  - `hasOnesStreak(0b1, 3)` => `false`, maximale Folgenlänge ist 1
  - `hasOnesStreak(0b010101, 3)` => `false`, maximale Folgenlänge ist 1
  - `hasOnesStreak(0b110110, 3)` => `false`, maximale Folgenlänge ist 2
  - `hasOnesStreak(0b110110, 2)` => `true`, maximale Folgenlänge ist 2
  - `hasOnesStreak(0b111011, 3)` => `true`, maximale Folgenlänge ist 3
  - `hasOnesStreak(0b111111, 3)` => `true`, maximale Folgenlänge ist 6
  - `hasOnesStreak(127, 2)` => `true`, maximale Folgenlänge ist 7
  - `hasOnesStreak(-126, 2)` => `true`, maximale Folgenlänge ist 25

### main()-Funktion

In jedem Programmlauf untersucht das Programm Zahlen in einem Bereich, der durch konstante Vorgaben bestimmt wird. Wenn mindestens eine der oben genannten Eigenschaften für die untersuchte Zahl zutrifft, wird die Zahl und ihre Eigenschaft(en) ausgegeben.  

* **Drei konstante Werte** sollen erstellt werden: zwei definieren den Anfang
  und das Ende des zu untersuchenden Zahlenbereichs, eine bestimmt die minimale
  Länge der jeweils zu suchenden binären 1er-Folge.
* Wir werden diese drei Werte ändern und erwarten, dass die aufgelisteten Zahlen immer bündig
  ausgegeben werden. Dafür wird ein vierter konstanter Wert `outputLength`
  benötigt, dessen Wert aus den konstanten Werten `start` und `end` ermittelt
  wird, sodass er folgendermaßen eingesetzt werden kann:  
  `System.out.printf("%" + outputLength + "d: ", i);`.

Die Ausgabe beginnt mit den festgelegten Grenzwerten. Jede aufgelistete Zahl ist rechtsbündig in einer Spalte auszugeben, deren Breite durch die breiteste untersuchte Zahl bestimmt wird (10 ist breiter als 9, -1 ist breiter als 2). Für die anderen Spalten muss keine Breite per Code berechnet, sondern darf direkt mit einer Zahl angegeben werden.

### Ausgabe des Programms

Das Programm soll bei Angabe entsprechender Grenzen folgende Ausgaben erzeugen:  

    Testing numbers from 7 to 15, minStreakLength = 3
     7: ascending happy onesStreak (0b111)
     8: ascending                  (0b1000)
     9: ascending                  (0b1001)
    10:           happy            (0b1010)
    12: ascending                  (0b1100)
    13: ascending happy            (0b1101)
    14: ascending       onesStreak (0b1110)
    15: ascending       onesStreak (0b1111)

    Testing numbers from -15 to -10, minStreakLength = 10
    -15: ascending       onesStreak (0b11111111111111111111111111110001)
    -14: ascending       onesStreak (0b11111111111111111111111111110010)
    -13: ascending happy onesStreak (0b11111111111111111111111111110011)
    -12: ascending       onesStreak (0b11111111111111111111111111110100)
    -11:                 onesStreak (0b11111111111111111111111111110101)
    -10:           happy onesStreak (0b11111111111111111111111111110110)

    Testing numbers from 999999 to 1000000, minStreakLength = 6
     999999:                 onesStreak (0b11110100001000111111)
    1000000:           happy            (0b11110100001001000000) 

    Testing numbers from -332 to -322, minStreakLength = 24
    -331:           happy            (0b11111111111111111111111010110101)
    -329:           happy            (0b11111111111111111111111010110111)
    -326:           happy            (0b11111111111111111111111010111010)


#### Testen

* In dieser Aufgabe erfolgt das Testen noch durch Überprüfen der Ausgabe.
* Es sollten mindestens die Werte getestet werden, für die Ausgaben in der
  Aufgabenstellung gezeigt wurden.
* Negative Zahlen müssen beachtet werden. In den ersten beiden Methoden werden nur die Ziffern einer Zahl beachtet, also müssen die Ergebnisse für negative Zahlen gleich denen der jeweiligen positiven Zahl sein.  
  Bei der Betrachtung der Zahl in Binärdarstellung wird jeweils nur die binäre
  Ziffer `1` bzw. `0` betrachtet, sodass es unerheblich sein sollte, ob die
  Zahl in Dezimaldarstellung positiv oder negativ ist.
* Auch die Zahl `0` muss getestet werden!


### Vorgaben für diese und folgende Aufgaben

* **Arrays oder Strings dürfen nicht für das Prüfen der Zahlen verwendet werden**.  
  Die Verwendung von Strings für die *Ausgabe* ist notwendig und natürlich erlaubt.
* Es dürfen keine zum Zeitpunkt der Aufgabenveröffentlichung noch nicht in der
  Vorlesung vorgestellten Konstrukte oder **Bibliotheken** genutzt werden, dazu
  gehören z.B. `Integer.max()`, `Integer.toBinaryString()`, `String.valueOf()`,
  `Math.pow()`, `Math.max()` und andere Methoden. Bei Bedarf muss eine eigene
  Methode erstellt werden.
* Die **Hinweise und Warnungen** von _IntelliJ_ sollen beachtet werden.
  Führen diese allerdings zu nicht erlaubten oder zu diesem Zeitpunkt
  unverständlichen Konstrukten, müssen sie ignoriert werden. Beispielsweise der
  Hinweis von _IntelliJ_, dass `Math.max()` eingesetzt werden könnte, muss also
  ignoriert werden.
* Der [Programmierstil](https://lms.fh-wedel.de/mod/wiki/view.php?pageid=328) muss unseren Vorgaben folgen, z.B. darf eine
  Schleife nicht mit `break` oder `return` verlassen werden, trotzdem aber
  nicht unnötig lang laufen.
* Jede Funktion/Methode und jede Klasse muss einen **sinnvollen Javadoc-Kommentar** erhalten. Kann ein Parameterwert nicht zu einem sinnvollen Rückgabewert führen, so muss im tag `@return` angegeben werden, welcher Wert in diesem Fall zurückgegeben wird.  
  Beispiel:
```
    /**
     * Liefert die Ziffer einer Zahl an einem gegebenen Index, 
     * wobei der Index 1 die Einer-Stelle der Zahl liefert.
     *
     * @param n die Zahl, von der eine Ziffer ermittelt werden soll
     * @param index der Index, an dem die Ziffer steht
     * @return die Ziffer an dem gegebenen Index, -1 bei invalidem Index
     */
     public static int getDigitAt(int n, int index) 
```
Bei den Routinen zum Ermitteln der Eigenschaften einer Zahl muss in der
Beschreibung der Routine die Definition für die Eigenschaft mit dokumentiert
werden, damit auch in einem Monat sofort ersichtlich ist, was beispielsweise
eine fröhliche Zahl auszeichnet.

## Mindestanforderungen

* Es müssen 6 Funktionen außer der _main()_ erstellt worden sein.
* Die oben gezeigten Ausgaben müssen bei entsprechenden Zuweisungen an die 
  Konstanten wie oben abgebildet aussehen.

Für diese und folgende Aufgaben gilt (wird dort nicht mehr gesondert aufgelistet):

  * Geprüft wird der Stand des Repos von 7.00 Uhr des Abnahmetages.
  * Sollte eine Gruppe zu Beginn des Abnahmetermins nicht anwesend sein oder eine wissentlich bzw. offensichtlich nicht vollständig gelöste Aufgabe präsentieren wollen, so gilt diese Aufgabe als nicht bestanden.
  * Der Code muss an jeder Stelle von jedem Gruppenmitglied erklärt werden können.
  * Schleifen müssen live innerhalb von maximal 10 Minuten umgestellt werden 
    können, auch zu einer weniger sinnvollen Variante.

## Viel Erfolg!