package test.action;

import main.action.DiscreteAction;
import main.action.DiscreteActionInterface;
import main.timer.OneShotTimer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiscreteActionTest {
    private OneShotTimer ost;
    private OneShotTimer ost2;
    private DiscreteAction daOneShot;
    private DiscreteActionInterface daOneShot2;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        ost = new OneShotTimer(10);
        ost = new OneShotTimer(15);
        daOneShot = new DiscreteAction(ost, "hasNext", ost);
        daOneShot2 = new DiscreteAction(ost, "hasNext", ost2);
    }

    @Test
    void DA1_constructorMethodInObject() {
        assertEquals(daOneShot.getObject(), ost);
        assertEquals(daOneShot.getMethod().getName(), "hasNext");
        //Aucune possibilité de récupérer daOneShot.timmer
    }

    @Test
    void DA2_constructorMethodNotInObject() {
        //DiscreteAction daFail = new DiscreteAction(ost1, "notDeclaredMethod", ost2);
        //assertNull(daFail.getMethod());
    }

    /*
        Entrée : spendTime(4)
        Description : Test de la méthode spendTime avec lapsTime = 10 donc lapsTime > 4 > 0
        Résultat Attendu : La valeur de lapsTime devient 4 et la log : “[DA] operate spendTime on objectName : objectHashCode: old time 10 new time 6” a été ajoutée
    */
    @Test
    void DA3_spendTimeWithLapsSupZero() {
        daOneShot.next();
        assertEquals(daOneShot.getCurrentLapsTime(), 10);
        daOneShot.spendTime(4);
        assertEquals(daOneShot.getCurrentLapsTime(),6);

    }

    /*
        Entrée : spendTime(4)
        Description : Test de la méthode spendTime avec lapsTime = null
        Résultat Attendu : La log : “[DA] operate spendTime on objectName : objectHashCode: old time null new time null” a été ajoutée
     */
    @Test
    void DA4_spendTimeWithLapsEqualsNull() {
        daOneShot.next();
        assertEquals(daOneShot.getCurrentLapsTime(), 0);
        daOneShot.next();
        assertEquals(daOneShot.getCurrentLapsTime(), null);
        daOneShot.spendTime(4);
        assertEquals(daOneShot.getCurrentLapsTime(),null);
    }

    /*
        Entrée : DiscreteAction(o, m, timer) getMethod()
        Description : Test du getter de method d’un objet initialisé
        Résultat Attendu : Retourne la méthode m
     */
    @Test
    void DA5_getMethod() {
        assertEquals(daOneShot.getMethod().getName(),"hasNext");
    }

    @Test
    void DA6_getCurrentLapsTime() {
        /*
            Entrée :DiscreteAction(o, m, timer) getCurrentLapsTime()
            Description : Test du getter de lapsTime d’un objet initialisé
            Résultat Attendu : Retourne null
         */
        assertEquals(daOneShot.getCurrentLapsTime(),null);
        daOneShot.next();
        assertEquals(daOneShot.getCurrentLapsTime(),10);
    }

    @Test
    void DA7_getObject() {
        /*
            Entrée : DiscreteAction(o, m, timer) getObject()
            Description : Test du getter de objet
            Résultat Attendu : Retourne l’objet o

         */
        assertEquals(daOneShot.getObject(),ost);
    }

    @Test
    void DA8_compareToWithCurrentLapsTimeNull() {
        /*
            Entrée : compareTo(c)
            Description : Test de comparaison avec lapsTime courant null
            Résultat Attendu : Retourne 1
         */
        daOneShot2.next();
        assertEquals(daOneShot.compareTo(daOneShot2),1);
    }

    @Test
    void DA9_compareToWithParamLapsTimeNull() {
        /*
            Entrée : compareTo(c)
            Description : Test de comparaison avec lapsTime de c null
            Résultat Attendu : Retourne -1
         */
        daOneShot.next();
        assertEquals(daOneShot.compareTo(daOneShot2),-1);
    }

    @Test
    void DA10_compareToWithCurrentLapsTimeSupParamsLapsTime() {
        /*
            Entrée : compareTo(c)
            Description : Test de comparaison avec lapsTime courant > lapsTime de c
            Résultat Attendu : Retourne 1

         */
        daOneShot.next();
        daOneShot2.next();
        daOneShot2.spendTime(10);
        assertEquals(daOneShot.compareTo(daOneShot2),1);
    }

    @Test
    void DA11_compareToWithCurrentLapsTimeInfParamsLapsTime() {
        /*
            Entrée : compareTo(c)
            Description : Test de comparaison avec lapsTime courant < lapsTime de c
            Résultat Attendu : Retourne -1

         */
        daOneShot.next();
        daOneShot2.next();
        assertEquals(daOneShot.compareTo(daOneShot2),-1);
    }

    @Test
    void DA12_compareToWithCurrentLapsTimeEqualsParamsLapsTime() {
        /*
            Entrée : compareTo(c)
            Description : Test de comparaison avec lapsTime courant = lapsTime de c
            Résultat Attendu : Retourne 0

         */
        daOneShot.next();
        daOneShot2.next();
        daOneShot2.spendTime(5);
        assertEquals(daOneShot.compareTo(daOneShot2),0);
    }

    @Test
    void DA13_toString() {
        /*
            Entrée : DiscreteAction(o, m, timer) toString()
            Description : Test du toString d’un objet initialisé
            Résultat Attendu : Retourne le string:
                “Object : oName
                 Method : mName
                Stat. : timer
                delay : lapsTime”
         */
    assertEquals(daOneShot.toString(), "Object : oName\n" +
            "Method : mName\n" +
            "Stat. : timer\n" +
            "delay : lapsTime");
    }

    @Test
    void DA14_next() {
        /*
            Entrée :
            Description :
            Résultat Attendu :

         */
    }

    @Test
    void DA15_hasNextWithTimerNullAndWithNextValue() {
        /*
            Entrée : DiscreteAction(o, m, timer) hasNext()
            Description : Test méthode hasNext() avec timer != null et timer a une prochaine valeur
            Résultat Attendu : Retourne True

         */
    }

    @Test
    void DA16_hasNextWithTimerNullAndWithoutNextValue() {
        /*
            Entrée : DiscreteAction(o, m, timer) hasNext()
            Description : Test méthode hasNext() avec timer != null et timer n’a pas de prochaine valeur
            Résultat Attendu : Retourne False
         */
    }

    @Test
    void DA17_hasNextWithTimerNull() {
        /*
            Entrée : DiscreteAction(o, m, timer) hasNext()
            Description : Test méthode hasNext() avec timer == null
            Résultat Attendu : Retourne False

         */
    }

    @Test
    void DA18_spendTimeWithLapsTimeSupp0() {
        /*
            Entrée : spendTime(4)
            Description : Test de la méthode spendTime avec lapsTime = 3 donc 4 > lapsTime> 0
            Résultat Attendu : Exception : “t > lapsTime"

         */
    }

    @Test
    void DA19_spendTimeWithLapsTimeInf0() {
        /*
            Entrée : spendTime(-4)
            Description : Test de la méthode spendTime avec temps < 0
            Résultat Attendu : Exception “t < 0”

         */
    }

}