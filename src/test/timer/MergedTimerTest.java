package test.timer;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import main.timer.MergedTimer;
import main.timer.OneShotTimer;
import main.timer.Timer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class MergedTimerTest {

    OneShotTimer oneShotTimer1;
    OneShotTimer oneShotTimer2;
    OneShotTimer oneShotTimer3;
    MergedTimer oneShotAndInfinite;

    @BeforeEach
    void setUp() {

        // Création de 2 timers (OneShotTimer car plus simples)
        oneShotTimer1 = new OneShotTimer(1);
        oneShotTimer2 = new OneShotTimer(2);

        // Création d'un 3eme timer
        oneShotTimer3 = new OneShotTimer(3);

        // Création d'un timer infini, un timer qui a toujours la valeur 10 et réutilisable à l'infini
        Timer infiniteTimer = new Timer() {
            @Override
            public Integer next() {

                return 10;
            }

            @Override
            public boolean hasNext() {

                return true;
            }
        };


        oneShotAndInfinite = new MergedTimer(oneShotTimer3, infiniteTimer);

    }

    /*
Entrée : MergedTimer(null, null)
Description : Test d’une Merge avec 2 timers null
Résultat Attendu : NullPointerException
*/
    @Test
    void MT1() {
        assertThrows(NullPointerException.class, () -> new MergedTimer(null, null));


    }

    /*
Entrée : MergedTimer(oneShotTimer1, null)
Description : Test d’une Merge avec 2eme timer null
Résultat Attendu : NullPointerException
*/
    @Test
    void MT2() {
        assertThrows(NullPointerException.class, () -> new MergedTimer(oneShotTimer1, null));

    }
    /*
Entrée : MergedTimer(null, oneShotTimer2)
Description : Test d’une Merge avec 1er timer null
Résultat Attendu : NullPointerException
*/
    @Test
    void MT3() {
        assertThrows(NullPointerException.class, () -> new MergedTimer(null, oneShotTimer2));

    }
    /*
Entrée : MergedTimer(oneShotTimer1, oneShotTimer2)
Description : Test d’une Merge avec 2 timers OneShotTimer
Résultat Attendu : True
*/
    @Test
    void MT4() {
// test avec nos 2 timers, normalement pas de problèmes
        assertDoesNotThrow(() -> new MergedTimer(oneShotTimer1, oneShotTimer2));

    }
    /*
Entrée :mergedTimer1.hasNext()
Description : Test de hasNext() sur mergedTimer1
Résultat Attendu : True
*/
    @Test
    void MT5() {
        // TODO
        // Normalement on a un next car on a merge le timer 1 avec le timer 2
        // assertTrue(mergedTimer1.hasNext());

    }
    /*
Entrée : assertEquals(3, mergedTimer1.next())
Description : Test si la valeur du mergedTimer1 vaut bien la somme des timers 1 et 2 à partir desquels il est créé
Résultat Attendu : True
*/
    @Test
    void MT6() {
        // TODO
        // On doit avoir 3 car on merge les 2 timers avec 1 et 2 comme valeur, donc 1+2, donc on doit avoir True
        //assertEquals(3, mergedTimer1.next());
    }

    /*
Entrée : oneShotAndInfinite.hasNext()
Description : Test si notre timer “infini” possède une valeur même après avoir été utilisé
Résultat Attendu : True
*/
    @Test
    void MT7() {
        // Normalement on a un next, donc True
        assertTrue(oneShotAndInfinite.hasNext());
    }
    /*
Entrée : assertEquals(13, oneShotAndInfinite.next())
Description : Test si la valeur du Merger vaut bien la somme des timers 3 et “infini” à partir desquels il est créé
Résultat Attendu : True
*/
    @Test
    void MT8() {
        // Car on a merge les 2 timers on doit avoir : 3+10=13
        assertEquals(13, oneShotAndInfinite.next());

    }
    /*
Entrée : oneShotAndInfinite.hasNext()
Description : Test de hasNext
Résultat Attendu : False
*/
    @Test
    void MT9() {
        // Notre timer infini peut être utilisé un nombre illimité de fois (il return toujours true), mais notre timer Timer 3 ne peut être utilisé qu'une fois (oneshot), donc normalement on a True
        assertFalse(oneShotAndInfinite.hasNext());

    }
    /*
Entrée : oneShotAndInfinite.next()
Description : Test si la valeur suivante est null
Résultat Attendu : True
*/
    @Test
    void MT10() {
        // Si on essaye de return la next value, on a donc null
        assertNull(oneShotAndInfinite.next());

    }


}