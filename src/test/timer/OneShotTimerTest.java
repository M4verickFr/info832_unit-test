package test.timer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import main.timer.OneShotTimer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OneShotTimerTest {

    private OneShotTimer oneShotTimer;

    @BeforeEach
    void setUp() {
        oneShotTimer = new OneShotTimer(1);
    }

    /*
        Entrée : oneShotTimer.hasNext()
        Description : Test de hasNext sur un timer qui n’a jamais été utilisé (hasNext() toujours existant)
        Résultat Attendu : True
     */
    @Test
    void OST1_OneShotHasNext() {
        assertTrue(oneShotTimer.hasNext());
    }

    /*
        Entrée : assertEquals(value, oneShotTimer.next())
        Description : Test de next sur un timer qui n’a jamais été utilisé (next() toujours existant)
        Résultat Attendu : True
     */
    @Test
    void OST2_OneShotNotUsedNext(){
        assertEquals(1, oneShotTimer.next());
    }

    /*
        Entrée : oneShotTimer.hasNext()
        Description : Test de hasNext sur un timer qui a été utilisé une première  fois
                      On a déjà utilisé notre timer, donc normalement on n'a pas de valeur suivante, hasNext() doit nous retourner False
        Résultat Attendu : False
    */
    @Test
    void OST3_OneShotUsedHasNext(){
        // TODO : @Zied
        assertTrue(oneShotTimer.hasNext());
    }

    /*
        Entrée :oneShotTimer.next()
        Description : Test de next sur un timer qui a été utilisé une première fois
        Résultat Attendu : Null
    */
    @Test
    void OST4_OneShotUsedNext(){
        oneShotTimer.next();
        assertNull(oneShotTimer.next());
    }
}