package timerTest;

import org.junit.jupiter.api.Test;

import timer.MergedTimer;
import timer.OneShotTimer;
import timer.Timer;

import static org.junit.jupiter.api.Assertions.*;

class MergedTimerTest {

    // Here we will do the hasNext() and the next() at the same time

    @Test
    void hasNext() {

        // Création de 2 timers (OneShotTimer car plus simples)
        OneShotTimer oneShotTimer1 = new OneShotTimer(1);
        OneShotTimer oneShotTimer2 = new OneShotTimer(2);

        // On teste la construction d'un MergeTimer avec un ou plusieurs objet(s) nul(s), normalement on a une exception
        assertThrows(NullPointerException.class, () -> new MergedTimer(null, null));
        assertThrows(NullPointerException.class, () -> new MergedTimer(oneShotTimer1, null));
        assertThrows(NullPointerException.class, () -> new MergedTimer(null, oneShotTimer2));

        // test avec nos 2 timers, normalement pas de problèmes
        assertDoesNotThrow(() -> new MergedTimer(oneShotTimer1, oneShotTimer2));

        // Création du mergeTimer 1
        MergedTimer mergedTimer1 = new MergedTimer(oneShotTimer1, oneShotTimer2);

        // Normalement on a un next car on a merge le timer 1 avec le timer 2
        assertTrue(mergedTimer1.hasNext());

        // On doit avoir 3 car on merge les 2 timers avec 1 et 2 comme valeur, donc 1+2, donc on doit avoir True
        assertEquals(3, mergedTimer1.next());



        // Création d'un 3eme timer
        OneShotTimer oneShotTimer3 = new OneShotTimer(3);

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


        MergedTimer oneShotAndInfinite = new MergedTimer(oneShotTimer3, infiniteTimer);

        // Normalement on a un next, donc True
        assertTrue(oneShotAndInfinite.hasNext());

        // Car on a merge les 2 timers on doit avoir : 3+10=13
        assertEquals(13, oneShotAndInfinite.next());

        // Notre timer infini peut être utilisé un nombre illimité de fois (il return toujours true), mais notre timer Timer 3 ne peut être utilisé qu'une fois (oneshot), donc normalement on a True
        assertFalse(oneShotAndInfinite.hasNext());

        // Si on essaye de return la next value, on a donc null
        assertNull(oneShotAndInfinite.next());

    }
}