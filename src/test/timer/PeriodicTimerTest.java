package test.timer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PeriodicTimerTest {

    @BeforeEach
    void setUp() {
    }

    /*
    Entrée : PeriodicTimer(10)
    Description : Test création PTimer avec at
    Résultat Attendu : PeriodicTimer(10)
     */
    @Test
    void PT1_ptimerWithAt() {
    }

    /*
    Entrée : PeriodicTimer(2,10)
    Description : Test création PTimer avec at et period
    Résultat Attendu : PeriodicTimer(29,10)
     */
    @Test
    void PT2_ptimerWithAtAndPeriod() {
    }

    /*
    Entrée : PeriodicTimer(2,10)
    Description : Test méthode getPeriod
    Résultat Attendu : 2
     */
    @Test
    void PT3_getPeriod() {
    }

    /*
    Entrée : PeriodicTimer(2,10)
    Description : Test méthode next
    Résultat Attendu : 2
     */
    @Test
    void PT4_next() {
    }

    /*
    Entrée : PeriodicTimer(10)
    Description : Test méthode hasNext
    Résultat Attendu : True
     */
    @Test
    void PT4_hasNext() {
    }
}