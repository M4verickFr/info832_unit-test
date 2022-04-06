package timerTest;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Executable;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class DateTimerTest {

    @Test
    void hasNext() {

        // Création d'un DateTimer avec un set d'entiers initialement vide (test des dates)
        DateTimer emptyDates = new DateTimer(new TreeSet<>());
        assertFalse(emptyDates.hasNext());

        // Idem mais en testant les laps time
        DateTimer emptyLapsTime = new DateTimer(new ArrayList<>());
        assertFalse(emptyLapsTime.hasNext());

        // On teste l'exception pointeur nul en mettant en input une liste d'entier nulle
        assertThrows(NullPointerException.class, () -> new DateTimer((List<Integer>) null));

        // Idem avec un set d'entiers nul
        assertThrows(NullPointerException.class, () -> new DateTimer((Set<Integer>) null));


        // test pour voir si ça marche bien avec de vraies données
        Set<Integer> treeSet = new TreeSet();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        DateTimer dateTimerWithSet = new DateTimer(treeSet);

        // On test si on a bien des valeurs dans notre DateTimer
        for (int i = 0; i < treeSet.size(); i++) {
            assertTrue(dateTimerWithSet.hasNext()); // On test si c'est vrai pour les n éléments du TreeSet
            dateTimerWithSet.next(); // On passe à la suite
        }
        // normalmeent on n'a pas de next value car on a déjà passé toutes les valeurs dans la boucle for donc cette assertion doit être fausse
        assertFalse(dateTimerWithSet.hasNext());



        // on refait le même procédé avec le constructeur avec les listes

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

        // test de l'exception
        // s'il n'y a pas de next value, on a une exception (test avec TreeSet vide et ArrayList vide)
        DateTimer emptyDates = new DateTimer(new TreeSet<>());
        assertThrows(NoSuchElementException.class, () -> emptyDates.next());

        DateTimer emptyLapsTime = new DateTimer(new ArrayList<>());
        assertThrows(NoSuchElementException.class, () -> emptyLapsTime.next());

        // on teste l'obtention des next value pour les arraylist (liste de timelaps) et pour les TreeSet
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        DateTimer dateTimerWithList = new DateTimer(arrayList);

        // on doit obtenir 1,2 et 3
        for (int i = 0; i < arrayList.size(); i++) {
            assertEquals(arrayList.get(i), dateTimerWithList.next());
        }

        // normalement next throw une exception car il n'y a plus de valeurs
        assertThrows(NoSuchElementException.class, () -> dateTimerWithList.next());

        // pour les TreeSet
        Set<Integer> treeSet = new TreeSet();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        DateTimer dateTimerWithSet = new DateTimer(treeSet);

        // pour le TreeSet on a toujours nextValue = n+1 - n : 1-0=1; 2-1=1 et 3-2=1 donc on doit toujours obtenir 1
        for (int i = 0; i < treeSet.size(); i++) {
            assertEquals(1, dateTimerWithSet.next());
        }

        // on teste l'exception, s'il ne reste plus de valeur on throw une exception
        assertThrows(NoSuchElementException.class, () -> dateTimerWithSet.next());
    }
}
