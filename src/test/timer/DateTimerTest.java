package test.timer;

import main.timer.DateTimer;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Executable;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class DateTimerTest {

    @BeforeEach
    void setUp() {

        // Création d'un DateTimer avec un set d'entiers initialement vide (test des dates)
        DateTimer emptyDates = new DateTimer(new TreeSet<>());

        // Idem mais en testant les laps time
        DateTimer emptyLapsTime = new DateTimer(new ArrayList<>());

        // test pour voir si ça marche bien avec de vraies données
        Set<Integer> treeSet = new TreeSet();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        DateTimer dateTimerWithSet = new DateTimer(treeSet);

        // on refait le même procédé avec le constructeur avec les listes

        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        DateTimer dateTimerWithList = new DateTimer(arrayList);

    }

    /*
Entrée :
Description :
Résultat Attendu :
*/
    @Test
    void DT0() {
        assertFalse(emptyDates.hasNext());

    }

    /*
Entrée :
Description :
Résultat Attendu :
*/
    @Test
    void DT1() {
        assertFalse(emptyLapsTime.hasNext());

    }

    /*
Entrée :
Description :
Résultat Attendu :
*/
    @Test
    void DT2() {
        // On teste l'exception pointeur nul en mettant en input une liste d'entier nulle
        assertThrows(NullPointerException.class, () -> new DateTimer((List<Integer>) null));

    }

    /*
Entrée :
Description :
Résultat Attendu :
*/
    @Test
    void DT3() {
        // Idem avec un set d'entiers nul
        assertThrows(NullPointerException.class, () -> new DateTimer((Set<Integer>) null));

    }

    /*
Entrée :
Description :
Résultat Attendu :
*/
    @Test
    void DT4() {
        // On test si on a bien des valeurs dans notre DateTimer
        for (int i = 0; i < treeSet.size(); i++) {
            assertTrue(dateTimerWithSet.hasNext()); // On test si c'est vrai pour les n éléments du TreeSet
            dateTimerWithSet.next(); // On passe à la suite
        }
    }

    /*
Entrée :
Description :
Résultat Attendu :
*/
    @Test
    void DT5() {
        for (int i = 0; i < treeSet.size(); i++) {
            dateTimerWithSet.next();
        }
        // normalmeent on n'a pas de next value car on a déjà passé toutes les valeurs dans la boucle for donc cette assertion doit être fausse
        assertFalse(dateTimerWithSet.hasNext());

    }

    /*
Entrée :
Description :
Résultat Attendu :
*/
    @Test
    void DT6() {
        for (int i = 0; i < arrayList.size(); i++) {
            assertTrue(dateTimerWithList.hasNext());
            dateTimerWithList.next();
        }

    }

    /*
Entrée :
Description :
Résultat Attendu :
*/
    @Test
    void DT7() {
        for (int i = 0; i < arrayList.size(); i++) {
            dateTimerWithList.next();
        }
        assertFalse(dateTimerWithList.hasNext());
    }

    /*
Entrée :
Description :
Résultat Attendu :
*/
    @Test
    void DT8() {
        assertThrows(NoSuchElementException.class, () -> emptyDates.next());

    }

    /*
Entrée :
Description :
Résultat Attendu :
*/
    @Test
    void DT9() {
        assertThrows(NoSuchElementException.class, () -> emptyLapsTime.next());

    }

    /*
Entrée :
Description :
Résultat Attendu :
*/
    @Test
    void DT10() {
        // on doit obtenir 1,2 et 3
        for (int i = 0; i < arrayList.size(); i++) {
            assertEquals(arrayList.get(i), dateTimerWithList.next());
        }
    }

    /*
Entrée :
Description :
Résultat Attendu :
*/
    @Test
    void DT11() {
        // normalement next throw une exception car il n'y a plus de valeurs
        assertThrows(NoSuchElementException.class, () -> dateTimerWithList.next());

    }

    /*
Entrée :
Description :
Résultat Attendu :
*/
    @Test
    void DT12() {
        // pour le TreeSet on a toujours nextValue = n+1 - n : 1-0=1; 2-1=1 et 3-2=1 donc on doit toujours obtenir 1
        for (int i = 0; i < treeSet.size(); i++) {
            assertEquals(1, dateTimerWithSet.next());
        }

    }

    /*
Entrée :
Description :
Résultat Attendu :
*/
    @Test
    void DT13() {
        // on teste l'exception, s'il ne reste plus de valeur on throw une exception
        assertThrows(NoSuchElementException.class, () -> dateTimerWithSet.next());
    }


}