package test.timer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import main.timer.OneShotTimer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OneShotTimerTest {

    OneShotTimer oneShotTimer1;

    @BeforeEach
    void setUp() {
        // Création d'un timer
        int value = 1;
        oneShotTimer1 = new OneShotTimer(value);
    }

    /*
Entrée : oneShotTimer1.hasNext()
Description : Test de hasNext sur un timer qui n’a jamais été utilisé
Résultat Attendu : True
 */
    @Test
    void OST1() {
        // 1ere utilisation du timer
        // On vérifie que notre timer n'a jamais été utilisé, donc on a bien un hasNext() True
        assertTrue(oneShotTimer1.hasNext());
    }

    /*
Entrée : assertEquals(value, oneShotTimer1.next())
Description : Test de next sur un timer qui n’a jamais été utilisé
Résultat Attendu : True
 */
    @Test
    void OST2(){
        // Comme on n'a jamais utilisé notre timer on peut récupérer la valeur avec next()
        assertEquals(true, oneShotTimer1.next());
    }

    /*
Entrée : oneShotTimer1.hasNext()
Description : Test de hasNext sur un timer qui n’a jamais été utilisé
Résultat Attendu : False
 */
    @Test
    void OST3(){
        // 2eme utilisation du timer
        // On a déjà utilisé notre timer, donc normalement on n'a pas de valeur suivante, hasNext() doit nous retourner False
        assertFalse(oneShotTimer1.hasNext());

    }

    /*
Entrée :oneShotTimer1.next()
Description : Test de next sur un timer qui n’a jamais été utilisé
Résultat Attendu : Null
 */
    @Test
    void OST4(){
        // De manière analogue, la valeur est null lorsqu'on essaye de la récupérer
        assertNull(oneShotTimer1.next());
    }













}