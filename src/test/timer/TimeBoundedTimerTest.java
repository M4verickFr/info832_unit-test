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
    private OneShotTimer oneShotTimer2;


    private int startTime;
    private int stopTime;

    private RandomTimer dummyTimer;
    private RandomTimer dummyTimer2;

    private TimeBoundedTimer timeBoundedTimer1;
    private TimeBoundedTimer timeBoundedTimer2;
    private TimeBoundedTimer timeBoundedTimer3;

    @BeforeEach
    void setUp() throws UnexpectedTimerConstructorException {
        oneShotTimerPriorStartTime = new OneShotTimer(1);
        oneShotTimer1 = new OneShotTimer(10);
        oneShotTimer2 = new OneShotTimer(0);
        timeBoundedTimer1 = new TimeBoundedTimer(oneShotTimer2, 0);
        dummyTimer = new RandomTimer(RandomTimer.randomDistribution.EXP, 2.0);
        startTime = 2;
        timeBoundedTimer2 = new TimeBoundedTimer(dummyTimer,  startTime);
        stopTime = 5;
        timeBoundedTimer3 = new TimeBoundedTimer(dummyTimer, startTime, stopTime);

    }

    /*
       Entrée : OneShotTimer(1)
       Description : Test du OneShotTimer avec une next value plus petite que le temps de départ
       Résultat Attendu : True
    */
    @Test
    void TBT1_OneShotTimer() {
        assertThrows(NullPointerException.class, () -> new TimeBoundedTimer(oneShotTimerPriorStartTime, 2));
    }

    /*
        Entrée : TimeBoundedTimer(oneShotTimer1, 5)
        Description : Test de la next value avec un TimeBoundedTimer, comme c'est la première fois, on a un True
        Résultat Attendu : True
    */
    @Test
    void TBT2_FirstValue() {
        assertTrue(timeBoundedTimer1.hasNext());
    }

    /*
        Entrée : TimeBoundedTimer(oneShotTimer1, 5)
        Description : Test de la méthode next, on devrait obtenir 10
        Résultat Attendu : True
    */
    @Test
    void TBT3_Next() {
        assertEquals(0, timeBoundedTimer1.next());
    }

    /*
        Entrée : TimeBoundedTimer(oneShotTimer1, 5)
        Description : Test de hasNext, on doit obtenir False car on a plus de valeurs
        Résultat Attendu : True
    */
    @Test
    void TBT4_HasNext() {
        assertTrue(timeBoundedTimer1.hasNext());
    }

    /*
        Entrée : TimeBoundedTimer(oneShotTimer1, 5)
        Description : Test de l'exception si on utilise un OneShotTimer
        Résultat Attendu : NullPointerException
    */
    @Test
    void TBT5_Exception() {
        assertThrows(NullPointerException.class, () -> timeBoundedTimer1.next());
    }

    /*
        Entrée : TimeBoundedTimer(dummyTimer, startTime)
        Description : Test de hasNext
        Résultat Attendu : True
    */
    @Test
    void TBT6_HasNext2Timers() {
        assertTrue(timeBoundedTimer2.hasNext());
    }

    /*
        Entrée : TimeBoundedTimer(dummyTimer, startTime)
        Description : Test de hasNext une seconde fois, comme la valeur de temps est inférieure à Integer.MAX_VALUE, on doit avoir True
        Résultat Attendu : True
    */
    @Test
    void TBT7_HasNext2TimersBis() {
        assertTrue(timeBoundedTimer2.hasNext());
    }

    /*
        Entrée : dummyTimer.next(), timeBoundedTimer2.next()
        Description : Test obtention de la next value du dummy timer
        Résultat Attendu : False
    */
    @Test
    void TBT8_NextValueLittle() {
        assertEquals(dummyTimer.next(), timeBoundedTimer1.next());
    }

    /*
        Entrée : TimeBoundedTimer(dummyTimer, startTime, stopTime)
        Description : Test de hasNext et de next
        Résultat Attendu : False, False
    */
    @Test
    void TBT9_hasNext() {
        assertFalse(timeBoundedTimer3.hasNext());

    }

    /*
        Entrée : TimeBoundedTimer(dummyTimer, startTime, stopTime)
        Description : Test de hasNext et de next
        Résultat Attendu : False, False
    */
    @Test
    void TBT10_next() {
        assertNull(timeBoundedTimer3.next());

    }
}

        










