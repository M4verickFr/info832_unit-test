package test.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import main.action.DiscreteAction;
import main.action.DiscreteActionInterface;
import main.timer.OneShotTimer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DiscreteActionTest {
    private OneShotTimer ost;
    private OneShotTimer ost2;
    private DiscreteAction daOneShot;
    private DiscreteActionInterface daOneShot2;

    @BeforeEach
    void setUp() {
        ost = new OneShotTimer(10);
        ost2 = new OneShotTimer(15);
        daOneShot = new DiscreteAction(ost, "hasNext", ost);
        daOneShot2 = new DiscreteAction(ost, "hasNext", ost2);
    }

    @Test
    void DA1_constructorMethodInObject() {
        assertEquals(daOneShot.getObject(), ost);
        assertEquals(daOneShot.getMethod().getName(), "hasNext");
        // Aucune possibilité de récupérer daOneShot.timmer
    }

    @Test
    void DA2_constructorMethodNotInObject() {
        // DiscreteAction daFail = new DiscreteAction(ost1, "notDeclaredMethod", ost2);
        // assertNull(daFail.getMethod());
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
        assertEquals(daOneShot.getCurrentLapsTime(), 10);
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

    /*
        Entrée :DiscreteAction(o, m, timer) getCurrentLapsTime()
        Description : Test du getter de lapsTime d’un objet initialisé
        Résultat Attendu : Retourne null
     */
    @Test
    void DA6_getCurrentLapsTime() {
        assertEquals(daOneShot.getCurrentLapsTime(),null);
        daOneShot.next();
        assertEquals(daOneShot.getCurrentLapsTime(),10);
    }

    /*
        Entrée : DiscreteAction(o, m, timer) getObject()
        Description : Test du getter de objet
        Résultat Attendu : Retourne l’objet o

     */
    @Test
    void DA7_getObject() {
        assertEquals(daOneShot.getObject(),ost);
    }

    /*
        Entrée : compareTo(c)
        Description : Test de comparaison avec lapsTime courant null
        Résultat Attendu : Retourne 1
     */
    @Test
    void DA8_compareToWithCurrentLapsTimeNull() {
        daOneShot2.next();
        assertEquals(daOneShot.compareTo(daOneShot2),1);
    }

    /*
        Entrée : compareTo(c)
        Description : Test de comparaison avec lapsTime de c null
        Résultat Attendu : Retourne -1
     */
    @Test
    void DA9_compareToWithParamLapsTimeNull() {
        daOneShot.next();
        assertEquals(daOneShot.compareTo(daOneShot2),-1);
    }

    /*
        Entrée : compareTo(c)
        Description : Test de comparaison avec lapsTime courant > lapsTime de c
        Résultat Attendu : Retourne 1
     */
    @Test
    void DA10_compareToWithCurrentLapsTimeSupParamsLapsTime() {
        daOneShot.next();
        daOneShot2.next();
        daOneShot2.spendTime(10);
        assertEquals(daOneShot.compareTo(daOneShot2),1);
    }

    /*
        Entrée : compareTo(c)
        Description : Test de comparaison avec lapsTime courant < lapsTime de c
        Résultat Attendu : Retourne -1
     */
    @Test
    void DA11_compareToWithCurrentLapsTimeInfParamsLapsTime() {
        daOneShot.next();
        daOneShot2.next();
        assertEquals(daOneShot.compareTo(daOneShot2),-1);
    }

    /*
        Entrée : compareTo(c)
        Description : Test de comparaison avec lapsTime courant = lapsTime de c
        Résultat Attendu : Retourne 0
     */
    @Test
    void DA12_compareToWithCurrentLapsTimeEqualsParamsLapsTime() {
        daOneShot.next();
        daOneShot2.next();
        daOneShot2.spendTime(5);
        assertEquals(daOneShot.compareTo(daOneShot2),0);
    }

    /*
        Entrée : DiscreteAction(o, m, timer) toString()
        Description : Test du toString d’un objet initialisé
        Résultat Attendu : Retourne le string:
            “Object : oName
             Method : mName
            Stat. : timer
            delay : lapsTime”
     */
    @Test
    void DA13_toString() {
        //Aucun moyen de récupérer le timmer
        //assertEquals(daOneShot.toString(), "Object : " + daOneShot.getObject()+"\n Method : " + daOneShot.getMethod() + "\n Stat. : " + daOneShot.getTimer() + "\n delay : " + daOneShot.getCurrentLapsTime());
    }

    /*
        Entrée : DiscreteAction(o, m, timer) hasNext()
        Description : Test méthode hasNext() avec timer != null et timer a une prochaine valeur
        Résultat Attendu : Retourne True

     */
    @Test
    void DA14_hasNext() {
        assertEquals(daOneShot.getCurrentLapsTime(),null);
        daOneShot.next();
        assertEquals(daOneShot.getCurrentLapsTime(),10);
    }

    /*
        Entrée : DiscreteAction(o, m, timer) hasNext()
        Description : Test méthode hasNext() avec timer != null et timer a une prochaine valeur
        Résultat Attendu : Retourne True
     */
    @Test
    void DA15_hasNextWithTimerNotNullAndWithNextValue() {
        assertTrue(daOneShot.hasNext());
    }

    /*
        Entrée : DiscreteAction(o, m, timer) hasNext()
        Description : Test méthode hasNext() avec timer != null et timer n’a pas de prochaine valeur
        Résultat Attendu : Retourne False
     */
    @Test
    void DA16_hasNextWithTimerNotNullAndWithoutNextValue() {
        daOneShot.next();
        assertFalse(daOneShot.hasNext());
    }

    /*
        Entrée : DiscreteAction(o, m, timer) hasNext()
        Description : Test méthode hasNext() avec timer == null
        Résultat Attendu : Retourne False
     */
    @Test
    void DA17_hasNextWithTimerNull() {
        //Aucun moyen d'avoir un timmer null pour tester
    }

    /*
        Entrée : spendTime(50)
        Description : Test de la méthode spendTime avec lapsTime = 10 donc 50 > lapsTime> 0
        Résultat Attendu : Exception : “t > lapsTime"
     */
    @Test
    void DA18_spendTimeWithParamSupLapsTime() {
        //TODO @Célien

        assertThrows(Exception.class, () -> {
            daOneShot.next();
            daOneShot.spendTime(50);
        });
    }

    /*
        Entrée : spendTime(-50)
        Description : Test de la méthode spendTime avec temps < 0
        Résultat Attendu : Exception “t < 0”
     */
    @Test
    void DA19_spendTimeWithParamEqu0() {
        //TODO @Célien

        assertThrows(Exception.class, () -> {
            daOneShot.next();
            daOneShot.spendTime(-50);
        });
    }

}