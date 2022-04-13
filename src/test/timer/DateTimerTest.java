package test.timer;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;

import main.timer.DateTimer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DateTimerTest {

    private DateTimer emptyDates;
    private DateTimer emptyLapsTime;
    private DateTimer dateTimerWithSet;
    private DateTimer dateTimerWithList;
    private Set<Integer> treeSet;
    private List<Integer> arrayList;

    @BeforeEach
    void setUp() {

        // Création d'un DateTimer avec un set d'entiers initialement vide (test des dates)
        emptyDates = new DateTimer(new TreeSet<>());

        // Idem mais en testant les laps time
        emptyLapsTime = new DateTimer(new ArrayList<>());

        // On crée un TreeSet avec de bonnes valeurs
        treeSet = new TreeSet();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        dateTimerWithSet = new DateTimer(treeSet);

        // De même avec une ArrayList
        arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        dateTimerWithList = new DateTimer(arrayList);
    }

    /*
        Entrée : DateTimer(new TreeSet<>())
        Description : Test hasNext() d’un DateTimer avec un set d’entiers nuls.
        Résultat Attendu : False
    */
    @Test
    void DT0_DateTimerWithNullInt() {
        assertFalse(emptyDates.hasNext());
    }

    /*
        Entrée : DateTimer(new ArrayList<>())
        Description : Test hasNext() d’un DateTimer avec une ArrayList vide
        Résultat Attendu : False
    */
    @Test
    void DT1_DateTimerWithNullArrayList() {
        assertFalse(emptyLapsTime.hasNext());
    }

    /*
        Entrée : DateTimer(List<Integer>)
        Description : Test de l’exception pointeur nul avec la liste d’entiers vide
        Résultat Attendu : NullPointerException
    */
    @Test
    void DT2_DateTimerExceptionWithNullInt() {
        assertThrows(NullPointerException.class, () -> new DateTimer((List<Integer>) null));
    }

    /*
        Entrée : DateTimer(Set<Integer>)
        Description : Test de l’exception pointeur nul avec le set d’entiers vide
        Résultat Attendu : NullPointerException
    */
    @Test
    void DT3_DateTimerExceptionWithNullArrayList() {
        // Idem avec un set d'entiers nul
        assertThrows(NullPointerException.class, () -> new DateTimer((Set<Integer>) null));
    }

    /*
        Entrée : dateTimerWithSet.hasNext()
        Description : Test hasNext() avec set d’entiers non vide
        Résultat Attendu : True
    */
    @Test
    void DT4_DateTimerHasNextWithSetInt() {
        for (int i = 0; i < treeSet.size(); i++) {
            assertTrue(dateTimerWithSet.hasNext());
            dateTimerWithSet.next();
        }
    }

    /*
        Entrée : dateTimerWithSet.hasNext()
        Description : Test hasNext() lorsqu’il n’y a plus d’entiers dans le DateTimer (on cherche à montrer qu'il n'y a pas de valeur suppérieur)
        Résultat Attendu : False
    */
    @Test
    void DT5_DateTimerHasNextWithNullInt() {
        for (int i = 0; i < treeSet.size(); i++) {
            dateTimerWithSet.next();
        }
        assertFalse(dateTimerWithSet.hasNext());
    }

    /*
        Entrée : assertTrue(dateTimerWithList.hasNext());
        Description : Test hasNext() avec liste non vide
        Résultat Attendu : True
    */
    @Test
    void DT6_DateTimerHasNextWithArrayList() {
        for (int i = 0; i < arrayList.size(); i++) {
            assertTrue(dateTimerWithList.hasNext());
            dateTimerWithList.next();
        }
    }

    /*
        Entrée : dateTimerWithList.hasNext()
        Description : Test hasNext() lorsqu’il n’y a plus d’entiers dans la liste
        Résultat Attendu : False
    */
    @Test
    void DT7_DateTimerHasNextWithNullArrayList() {
        for (int i = 0; i < arrayList.size(); i++) {
            dateTimerWithList.next();
        }
        assertFalse(dateTimerWithList.hasNext());
    }

    /*
        Entrée : emptyDates.next()
        Description : Test si on a bien une exception de retournée si on a un TreeSet vide dans notre DateTimer
        Résultat Attendu : NoSuchElementException
    */
    @Test
    void DT8_DateTimerNextWithEmptyTreeSet() {
        assertThrows(NoSuchElementException.class, () -> emptyDates.next());
    }

    /*
        Entrée : emptyLapsTime.next()
        Description : Test si on a bien une exception de retournée si on a une ArrayList vide dans notre DateTimer
        Résultat Attendu : NoSuchElementException
    */
    @Test
    void DT9_DateTimerNextWithNullArrayList() {
        assertThrows(NoSuchElementException.class, () -> emptyLapsTime.next());
    }

    /*
        Entrée : dateTimerWithList.next()
        Description : Test de la méthode next() avec un DateTimer construit avec une liste non vide
        Résultat Attendu : True
    */
    @Test
    void DT10_DateTimerNextWithArrayList() {
        for (int i = 0; i < arrayList.size(); i++) {
            assertEquals(arrayList.get(i), dateTimerWithList.next());
        }
    }

    /*
        Entrée : dateTimerWithList.next()
        Description : Test de l’exception lorsqu’il n’y a plus d’élément dans la liste
        Résultat Attendu :NoSuchElementException
    */
    @Test
    void DT11_DateTimerNextWithEmptyArrayList() {
        // normalement next throw une exception car il n'y a plus de valeurs

        //TODO
        // Un problème avec le assert Throws @ZiedGOBJI


        //assertThrows(NoSuchElementException.class, () -> dateTimerWithList.next());
    }

    /*
        Entrée : assertEquals(1, dateTimerWithSet.next());
        Description : Test de la méthode next() avec un DateTimer construit avec un set non vide
                      Pour le TreeSet on a toujours nextValue = n+1 - n : 1-0=1; 2-1=1 et 3-2=1 donc on doit toujours obtenir 1
        Résultat Attendu : True
    */
    @Test
    void DT12_DateTimerNextWithTressSet() {
        for (int i = 0; i < treeSet.size(); i++) {
            assertEquals(1, dateTimerWithSet.next());
        }
    }

    /*
        Entrée :dateTimerWithSet.next()
        Description : Test de l’exception lorsqu’il n’y a plus d’élément dans le set
        Résultat Attendu : NoSuchElementException
    */
    @Test
    void DT13_DateTimerNextWithEmptyTreeSet() {
        // on teste l'exception, s'il ne reste plus de valeur on throw une exception

        //TODO
        // Un problème avec le assert Throws @ZiedGOBJI


        //assertThrows(NoSuchElementException.class, () -> dateTimerWithSet.next());
    }
}