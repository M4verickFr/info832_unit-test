package test.timer;

import main.timer.DateTimer;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class DateTimerTest {


    @Test
    void hasNext() {

        // Création d'un DateTimer avec un set d'Integer vide, on devrait avoir False
        DateTimer emptyDates = new DateTimer(new TreeSet<>());
        assertFalse(emptyDates.hasNext());

        // Idem
        DateTimer emptyLapsTime = new DateTimer(new ArrayList<>());
        assertFalse(emptyLapsTime.hasNext());

        // On donne une liste Null dans notre constrcuteur pour avoir un Null Pointer Exception
        assertThrows(NullPointerException.class, () -> new DateTimer((List<Integer>) null));

        // On donne un TreeSet et Null dans notre constrcuteur pour avoir un Null Pointer Exception
        assertThrows(NullPointerException.class, () -> new DateTimer((TreeSet<Integer>) null));


        // On ajoute quelques valeurs à notre liste
        Set<Integer> treeSet = new TreeSet();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        DateTimer dateTimerWithSet = new DateTimer(treeSet);

        // On a besoin de la taille de notre Set
        for (int i = 0; i < treeSet.size(); i++) {
            assertTrue(dateTimerWithSet.hasNext());
            dateTimerWithSet.next();
        }

        // Normalement on a False car on a aucune next value
        assertFalse(dateTimerWithSet.hasNext());

        // On ajoute quelques valeurs à notre liste et on répète le processus
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        DateTimer dateTimerWithList = new DateTimer(arrayList);

        for (int i = 0; i < arrayList.size(); i++) {
            assertTrue(dateTimerWithList.hasNext());
            dateTimerWithList.next();
        }
        assertFalse(dateTimerWithList.hasNext());
    }

    @org.junit.jupiter.api.Test
    void next() {

        // On teste le cas où notre DateTimer n'a pas de next value
        DateTimer emptyDates = new DateTimer(new TreeSet<>());
        assertThrows(NoSuchElementException.class, () -> emptyDates.next());

        DateTimer emptyLapsTime = new DateTimer(new ArrayList<>());
        assertThrows(NoSuchElementException.class, () -> emptyLapsTime.next());

        // On veut avoir la next value d'un datetimer qui possède un array de timelaps
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        DateTimer dateTimerWithList = new DateTimer(arrayList);

        // Normalement les next value devraient être 1,2 et 3
        for (int i = 0; i < arrayList.size(); i++) {
            assertEquals(arrayList.get(i), dateTimerWithList.next());
        }

        // On renvoie une exception s'il n'y a pas de next value
        assertThrows(NoSuchElementException.class, () -> dateTimerWithList.next());




        Set<Integer> treeSet = new TreeSet();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        DateTimer dateTimerWithSet = new DateTimer(treeSet);

        // On fait l'opération n+1-n à chaque fois, donc on devrait toujours avoir 1 en tant que next value
        for (int i = 0; i < treeSet.size(); i++) {
            assertEquals(1, dateTimerWithSet.next());
        }

        // On reteste si on renvoie bien une exception si on n'a pas de next value
        assertThrows(NoSuchElementException.class, () -> dateTimerWithSet.next());
    }
}


