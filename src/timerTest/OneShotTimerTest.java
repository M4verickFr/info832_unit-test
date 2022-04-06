package timerTest;

import org.junit.jupiter.api.Test;

import timer.OneShotTimer;

import static org.junit.jupiter.api.Assertions.*;

class OneShotTimerTest {

    @Test
    void hasNext() {
        
        // Création d'un timer
        int value = 1;
        OneShotTimer oneShotTimer1 = new OneShotTimer(value);

        // 1ere utilisation du timer
        // On vérifie que notre timer n'a jamais été utilisé, donc on a bien un hasNext() True
        assertTrue(oneShotTimer1.hasNext());

        // Comme on n'a jamais utilisé notre timer on peut récupérer la valeur avec next()
        assertEquals(value, oneShotTimer1.next());

        // 2eme utilisation du timer
        // On a déjà utilisé notre timer, donc normalement on n'a pas de valeur suivante, hasNext() doit nous retourner False
        assertFalse(oneShotTimer1.hasNext());

        // De manière analogue, la valeur est null lorsqu'on essaye de la récupérer
        assertNull(oneShotTimer1.next());

    }
}