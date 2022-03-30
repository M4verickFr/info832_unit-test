package test.timer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OneShotTimerTest {

    @BeforeEach
    void setUp() {
    }

    /*
    Entrée : OneShotTimer(15)
    Description : Test création OneShotTimer avec at > 0
    Résultat Attendu : OSTimer créer avec at initalisé et hasNext = True
     */
    @Test
    void OST1_oneShotTimerPositive() {
    }

    /*
    Entrée : OneShotTimer(0)
    Description : Test création OneShotTimer avec at = 0
    Résultat Attendu : ??
     */
    @Test
    void OST2_oneShotTimerZero() {
    }

    /*
    Entrée : OneShotTimer(-10)
    Description : Test création OneShotTimer avec at < 0
    Résultat Attendu : ??
     */
    @Test
    void OST3_oneShotTimerNegative() {
    }

    /*
    Entrée : OneShotTimer(13)
    Description : Test méthode hasNext
    Résultat Attendu : True
     */
    @Test
    void OST4_hasNext() {
    }

    /*
    Entrée : OneShotTimer(13)
    Description : Test méthode next
    Résultat Attendu : 13
     */
    @Test
    void OSTOST5_next() {
    }
}