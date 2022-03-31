package test.timer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import timer.OneShotTimer;
import static org.junit.jupiter.api.Assertions.*;

class OneShotTimerTest {



    @BeforeEach
    void setUp() {
        // Création d'un timer
        int value = 1;
        OneShotTimer oneShotTimer1 = new OneShotTimer(value);
    }

    /*
Entrée : OneShotTimer(15)
Description : Test création OneShotTimer avec at > 0
Résultat Attendu : OSTimer créer avec at initalisé et hasNext = True
 */
    @Test
    void OST1() {
        // 1ere utilisation du timer
        // On vérifie que notre timer n'a jamais été utilisé, donc on a bien un hasNext() True
        assertTrue(oneShotTimer1.hasNext());
    }

    /*
Entrée : OneShotTimer(15)
Description : Test création OneShotTimer avec at > 0
Résultat Attendu : OSTimer créer avec at initalisé et hasNext = True
 */
    @Test
    void OST2(){
        // Comme on n'a jamais utilisé notre timer on peut récupérer la valeur avec next()
        assertEquals(value, oneShotTimer1.next());
    }

    /*
Entrée : OneShotTimer(15)
Description : Test création OneShotTimer avec at > 0
Résultat Attendu : OSTimer créer avec at initalisé et hasNext = True
 */
    @Test
    void OST3(){
        // 2eme utilisation du timer
        // On a déjà utilisé notre timer, donc normalement on n'a pas de valeur suivante, hasNext() doit nous retourner False
        assertFalse(oneShotTimer1.hasNext());

    }

    /*
Entrée : OneShotTimer(15)
Description : Test création OneShotTimer avec at > 0
Résultat Attendu : OSTimer créer avec at initalisé et hasNext = True
 */
    @Test
    void OST4(){
        // De manière analogue, la valeur est null lorsqu'on essaye de la récupérer
        assertNull(oneShotTimer1.next());
    }













}