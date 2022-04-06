package test.timer;

import main.exceptions.UnexpectedTimerConstructorException;
import main.timer.PeriodicTimer;
import main.timer.RandomTimer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.timer.RandomTimer.randomDistribution;

import static org.junit.jupiter.api.Assertions.*;

class PeriodicTimerTest {

    private PeriodicTimer periodicTimer1;
    private PeriodicTimer periodicTimer2;
    private PeriodicTimer periodicTimer3;
    private PeriodicTimer periodicTimer4;
    private RandomTimer randomTimer;
    private int nextValue;
    private int periodValue;
    private PeriodicTimer periodicTimerWithRandomTimer;


    @BeforeEach
    void setUp() throws UnexpectedTimerConstructorException {
        periodicTimer1 = new PeriodicTimer(1);
        periodicTimer2 = new PeriodicTimer(1, 1);
        randomTimer = null;
        periodicTimer3 = new PeriodicTimer(1, randomTimer);
        periodicTimer4 = new PeriodicTimer(1, 1, randomTimer);

        nextValue = 1;
        periodicTimer1 = new PeriodicTimer(nextValue);
        periodValue = 2;
        periodicTimer2 = new PeriodicTimer(periodValue, nextValue);

        randomTimer = new RandomTimer(randomDistribution.POSIBILIST, 1, 1);
        periodicTimerWithRandomTimer = new PeriodicTimer(periodValue, nextValue, randomTimer);
        randomTimer = new RandomTimer(randomDistribution.POSIBILIST, 1, 1);
        periodicTimerWithRandomTimer = new PeriodicTimer(nextValue, randomTimer);


        periodicTimer1 = new PeriodicTimer(1);

        periodicTimer2 = new PeriodicTimer(1, 1);
        randomTimer = null;
        periodicTimer3 = new PeriodicTimer(1, randomTimer);
        periodicTimer4 = new PeriodicTimer(1, 1, randomTimer);
    }

    /*
        Entrée : PeriodicTimer(1)
        Description : Test d'avoir la période avec un Periodic Timer de base
        Résultat Attendu : True
     */
    @Test
    void PT1() {
        assertEquals(1, periodicTimer1.getPeriod());
    }

    /*
        Entrée : PeriodicTimer(1,1)
        Description : Test d'avoir la période avec un Periodic Timer de base
        Résultat Attendu : True
     */
    @Test
    void PT2() {
        assertEquals(1, periodicTimer2.getPeriod());
    }

    /*
        Entrée : PeriodicTimer(1, randomTimer)
        Description : Test d'avoir la période avec un Periodic Timer
        Résultat Attendu : True
     */
    @Test
    void PT3() {
        assertEquals(1, periodicTimer3.getPeriod());
    }

    /*
        Entrée : PeriodicTimer(1, 1, randomTimer)
        Description : Test d'avoir la période avec un Periodic Timer
        Résultat Attendu : True
     */
    @Test
    void PT4() {
        assertEquals(1, periodicTimer4.getPeriod());
    }

    /*
        Entrée : PeriodicTimer(nextValue)
        Description : Test de next()
        Résultat Attendu : True
     */
    @Test
    void PT5() {
        assertEquals(nextValue, periodicTimer1.next());
        assertEquals(nextValue, periodicTimer1.next());
    }

    /*
        Entrée : PeriodicTimer(periodValue, nextValue)
        Description : Test de next()
        Résultat Attendu : True
    */
    @Test
    void PT6() {
        assertEquals(nextValue, periodicTimer2.next());
        assertEquals(periodValue, periodicTimer2.next());
    }

    /*
         Entrée : PeriodicTimer(periodValue, nextValue, randomTimer)
         Description : Test de next avec un RandomTimer et une loi Uniforme
         Résultat Attendu : True
    */
    @Test
    void PT7() {
        assertEquals(nextValue, periodicTimerWithRandomTimer.next());
    }

    /*
         Entrée : PeriodicTimer(nextValue, randomTimer)
         Description : Test avec un RandomTimer et une loi Uniforme
         Résultat Attendu : True, True
    */
    @Test
    void PT8() {

        assertEquals(nextValue, periodicTimerWithRandomTimer.next());
        assertEquals(periodValue, periodicTimerWithRandomTimer.next());

    }

    /*
        Entrée : PeriodicTimer(1)
        Description : Test d'avoir une période à partir d'un Periodic Timer
        Résultat Attendu : True
    */
    @Test
    void PT9() {
        assertTrue(periodicTimer1.hasNext());
    }

    /*
         Entrée : PeriodicTimer(1, 1)
         Description : Test d'avoir une période à partir d'un Periodic Timer
         Résultat Attendu : True
    */
    @Test
    void PT10() {
        assertTrue(periodicTimer2.hasNext());
    }

    /*
        Entrée : PeriodicTimer(1, randomTimer)
        Description : Test d'avoir la periode avec un Periodic Timer
        Résultat Attendu : True
    */
    @Test
    void PT11() {
        assertTrue(periodicTimer3.hasNext());

    }

    /*
        Entrée : PeriodicTimer(1, 1, randomTimer)
        Description : Test d'avoir la periode avec un Periodic Timer
        Résultat Attendu : True
    */
    @Test
    void PT12() {
        assertTrue(periodicTimer4.hasNext());

    }
}





