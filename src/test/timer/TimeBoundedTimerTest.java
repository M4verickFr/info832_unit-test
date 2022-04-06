package test.timer;

import main.exceptions.UnexpectedTimerConstructorException;
import main.timer.OneShotTimer;
import main.timer.RandomTimer;
import main.timer.TimeBoundedTimer;
import main.timer.Timer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

class TimeBoundedTimerTest {

    private OneShotTimer oneShotTimerPriorStartTime;
    private OneShotTimer oneShotTimer1;
    private TimeBoundedTimer timeBoundedTimer1;

    private int startTime;
    private int stopTime;

    private RandomTimer dummyTimer;

    private TimeBoundedTimer timeBoundedTimer2;
    private TimeBoundedTimer timeBoundedTimer3;


    @BeforeEach
    void setUp() throws UnexpectedTimerConstructorException {

        oneShotTimerPriorStartTime = new OneShotTimer(1);
        oneShotTimer1 = new OneShotTimer(10);
        timeBoundedTimer1 = new TimeBoundedTimer(oneShotTimer1, 5);
        dummyTimer = new RandomTimer(RandomTimer.randomDistribution.EXP, 1.0);
        startTime = 3;
        timeBoundedTimer2 = new TimeBoundedTimer(dummyTimer, startTime);
        stopTime = 5;
        timeBoundedTimer3 = new TimeBoundedTimer(dummyTimer, startTime, stopTime);

    }


    /*
       Entrée : OneShotTimer(1)
       Description : Test du OneShotTimer avec une next value plus petite que le temps de départ
       Résultat Attendu : True
    */
    @Test
    void TBT2() {
        assertThrows(NullPointerException.class, () -> new TimeBoundedTimer(oneShotTimerPriorStartTime, 2));
    }

    /*
        Entrée : TimeBoundedTimer(oneShotTimer1, 5)
        Description : Test de la next value avec un TimeBoundedTimer, comme c'est la première fois, on a un True
        Résultat Attendu : True
    */
    @Test
    void TBT3() {
        assertTrue(timeBoundedTimer1.hasNext());
    }

    /*
        Entrée : TimeBoundedTimer(oneShotTimer1, 5)
        Description : Test de la méthode next, on devrait obtenir 10
        Résultat Attendu : True
    */
    @Test
    void TBT4() {
        assertEquals(10, timeBoundedTimer1.next());
    }

    /*
        Entrée : TimeBoundedTimer(oneShotTimer1, 5)
        Description : Test de hasNext, on doit obtenir False car on a plus de valeurs
        Résultat Attendu : True
    */
    @Test
    void TBT5() {
        assertTrue(timeBoundedTimer1.hasNext());
    }

    /*
        Entrée : TimeBoundedTimer(oneShotTimer1, 5)
        Description : Test de l'exception si on utilise un OneShotTimer
        Résultat Attendu : NullPointerException
    */
    @Test
    void TBT6() {
        assertThrows(NullPointerException.class, () -> timeBoundedTimer1.next());
    }

    /*
        Entrée : TimeBoundedTimer(dummyTimer, startTime)
        Description : Test de hasNext
        Résultat Attendu : True
    */
    @Test
    void TBT7() {
        assertTrue(timeBoundedTimer2.hasNext());
    }

    /*
        Entrée : TimeBoundedTimer(dummyTimer, startTime)
        Description : Test de hasNext une seconde fois, comme la valeur de temps est inférieure à Integer.MAX_VALUE, on doit avoir True
        Résultat Attendu : True
    */
    @Test
    void TBT8() {
        assertTrue(timeBoundedTimer2.hasNext());
    }

    /*
        Entrée : dummyTimer.next(), timeBoundedTimer2.next()
        Description : Test obtention de la next value du dummy timer
        Résultat Attendu : False
    */
    @Test
    void TBT9() {
        assertEquals(dummyTimer.next(), timeBoundedTimer2.next());
    }

    /*
        Entrée : TimeBoundedTimer(dummyTimer, startTime, stopTime)
        Description : Test de hasNext et de next
        Résultat Attendu : False, False
    */
    @Test
    void TBT10() {
        assertFalse(timeBoundedTimer3.hasNext());
        assertEquals(startTime, timeBoundedTimer3.next());
    }

}

        










