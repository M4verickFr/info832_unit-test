package test.timer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TimeBoundedTimerTest {

    @BeforeEach
    void setUp() {
    }

    /*
    Entrée : TBTimer(OneShotTimer(10), 0, 5)
    Description : Test création TBTimer avec Timer, startTime, stopTime (0<startTime<stopTime)
    Résultat Attendu : ??
     */
    @Test
    void TBT1_TimeBoundedTimerWithTimerStartAndStop() {
    }

    /*
    Entrée : TBTimer(OneShotTimer(10), 0)
    Description : Test création TBTimer avec Timer, startTime (startTime>0)
    Résultat Attendu : ??
     */
    @Test
    void TBT2_TimeBoundedTimerWithTimerAndStart() {
    }

    /*
    Entrée : TBTimer(OneShotTimer(10), 0, 5)
    Description : Test méthode hasNext
    Résultat Attendu : True
     */
    @Test
    void TBT3_hasNext() {
    }

    /*
    Entrée : TBTimer(OneShotTimer(10), 0, 5)
    Description : Test méthode next
    Résultat Attendu : ??
     */
    @Test
    void TBT4_next() {
    }

    /*
    Entrée : TBTimer(OneShotTimer(10), 5, 0)
    Description : Test création avec startTime>stopTime
    Résultat Attendu : Erreur invalid argument
     */
    @Test
    void TBT5_TimeBoundedTimerStartSupStop() {
    }

    /*
   Entrée : TBTimer(OneShotTimer(10), -3, 19)
   Description : Test création avec startTime<0
   Résultat Attendu : Erreur invalid argument
    */
    @Test
    void TBT6_TimeBoundedTimerStartNegative() {
    }
}