package test.action;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.TreeSet;
import jdk.jshell.spi.ExecutionControl.NotImplementedException;
import main.action.DiscreteAction;
import main.action.DiscreteActionInterface;
import main.action.DiscreteActionOnOffDependent;
import main.timer.OneShotTimer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DiscreteActionOnOffDependentTest {

    private OneShotTimer ost;
    private OneShotTimer ost2;
    private DiscreteActionOnOffDependent daofdOneShot;
    private DiscreteActionOnOffDependent daofdOneShot2;
    private DiscreteActionOnOffDependent daofdOneShot3;
    private DiscreteActionOnOffDependent daofdOneShot4;
    private DiscreteActionInterface daOneShot;

    @BeforeEach
    void setUp() {
        ost = new OneShotTimer(10);
        ost2 = new OneShotTimer(15);
        daOneShot = new DiscreteAction(ost, "hasNext", ost2);
        daofdOneShot = new DiscreteActionOnOffDependent(ost, "hasNext", ost, "getMethod", ost2);
        // Second Constructor : DatesOn < DateOff
        TreeSet<Integer> datesOn=new TreeSet<Integer>();
        datesOn.add(24);  
        TreeSet<Integer> datesOff=new TreeSet<Integer>();  
        datesOff.add(42);  
        daofdOneShot2 = new DiscreteActionOnOffDependent(ost, "hasNext", datesOn, "getMethod", datesOff);

        // Second Constructor : DatesOn < DateOff
        datesOn=new TreeSet<Integer>();
        datesOff.add(42);  
        datesOff=new TreeSet<Integer>();
        datesOn.add(24);  
        daofdOneShot3 = new DiscreteActionOnOffDependent(ost, "hasNext", datesOn, "getMethod", datesOff);

        // Second Constructor : DatesOn < DateOff
        datesOn=new TreeSet<Integer>();
        datesOn.add(24);  
        datesOff=new TreeSet<Integer>();
        datesOff.add(24);  
        daofdOneShot4 = new DiscreteActionOnOffDependent(ost, "hasNext", datesOn, "getMethod", datesOff);
    }

    /*
        Entrée : DiscreteActionOnOffDependent(Obj,on,timerOn,off,timerOff)
        Description : Test de déclaration de l’objet DiscreteActionOnOffDependent
        Résultat Attendu :Objet créé avec un objet DiscreteAction(obj,on,timerOn) stocké dans la variable onAction, un second objet similaire DiscreteAction(obj,off,timerOff) stocké dans la variable offAction.
        L’instanciation de offAction est également stocké dans current action et le currentLapsTime est instancié à 0.
    */
    @Test
    void DAD00D1_firstConstructor(){
        // Aucune possibilité de récupérer daofdOneShot.onAction
        // Aucune possibilité de récupérer daofdOneShot.offAction
        // assertEquals(daofdOneShot.onAction.getObject(), ost);
        // assertEquals(daofdOneShot.offAction.getObject(), ost);
        assertEquals(daofdOneShot.getObject(), ost2);

    }

    /*
        Entrée : DiscreteActionOnOffDependent(obj, on, datesOn, off, datesOff)
        Description : Test du deuxième constructeur avec la première date de datesOn antérieur à la première date de datesOff
        Résultat Attendu : Objet créé avec un objet DiscreteAction(obj,on, new DateTimer(datesOn)) stocké dans la variable onAction, un second objet similaire DiscreteAction(obj,on, new DateTimer(datesOn)) stocké dans la variable offAction
    */
    @Test
    void DAD00D2_secondConstructorWithFirstDateOnInfFirstDateOff(){
        // Aucune possibilité de récupérer daofdOneShot.onAction
        // Aucune possibilité de récupérer daofdOneShot.offAction
        // assertEquals(daofdOneShot.onAction.getObject(), ost);
        // assertEquals(daofdOneShot.offAction.getObject(), ost);
        assertEquals(daofdOneShot2.getObject(), ost);
    }

    /*
        Entrée : DiscreteActionOnOffDependent(obj, on, datesOn, off, datesOff)
        Description : Test du deuxième constructeur avec la première date de datesOn postérieur à la première date de datesOff
        Résultat Attendu : Objet créé avec un objet DiscreteAction(obj,on, new DateTimer(datesOn)) stocké dans la variable onAction, un second objet similaire DiscreteAction(obj,on, new DateTimer(datesOn)) stocké dans la variable offAction currentAction prend la valeur de offAction

    */

    @Test
    void DAD00D3_secondConstructorWithFirstDateOnSupFirstDateOff(){
        // Aucune possibilité de récupérer daofdOneShot.onAction
        // Aucune possibilité de récupérer daofdOneShot.offAction
        // assertEquals(daofdOneShot.onAction.getObject(), ost);
        // assertEquals(daofdOneShot.offAction.getObject(), ost);
        assertEquals(daofdOneShot3.getObject(), ost2);
    }

    /*
        Entrée : DiscreteActionOnOffDependent(obj, on, datesOn, off, datesOff)
        Description : Test du deuxième constructeur avec la première date de datesOn identique à la première date de datesOff
        Résultat Attendu : Objet créé avec un objet DiscreteAction(obj,on, new DateTimer(datesOn)) stocké dans la variable onAction, un second objet similaire DiscreteAction(obj,on, new DateTimer(datesOn)) stocké dans la variable offAction currentAction prend la valeur de onAction
    */
    @Test
    void DAD00D4_secondConstructorWithFirstDateOnEqualsFirstDateOff(){
        // Aucune possibilité de récupérer daofdOneShot.onAction
        // Aucune possibilité de récupérer daofdOneShot.offAction
        // assertEquals(daofdOneShot.onAction.getObject(), ost);
        // assertEquals(daofdOneShot.offAction.getObject(), ost);
        assertEquals(daofdOneShot4.getObject(), ost2);
    }

    /*
        Entrée : nextAction()
        Description : Test de la méthode avec un currentAction différent de onAction
        Résultat Attendu : Remplacement de la currentAction par l’action suivante de l’action on
    */
    @Test
    void DAD00D5_nextActionWithCurrentActionDiffOnAction(){
        assertEquals(daofdOneShot.getCurrentLapsTime(),null);
        assertEquals(daofdOneShot.getObject(),ost2);
        daofdOneShot.nextAction();
        assertEquals(daofdOneShot.getCurrentLapsTime(),0);
        assertEquals(daofdOneShot.getObject(),ost);

    }

    /*
        Entrée : nextAction()
        Description : Test de la méthode avec un currentAction égale à onAction
        Résultat Attendu : Remplacement de la currentAction par l’action suivante de l’off Action, et on attribu lastOffDelay par le LapsTime de la nouvelle curent action
    */
    @Test
    void DAD00D6_nextActionWithCurrentActionEqualsOnAction(){


        assertEquals(daofdOneShot2.getCurrentLapsTime(),null);
        assertEquals(daofdOneShot2.getObject(),ost);
        daofdOneShot.nextAction();
        assertEquals(daofdOneShot2.getCurrentLapsTime(),24);
        assertEquals(daofdOneShot2.getObject(),ost2);
        // Aucune possibilité de récupérer daofdOneShot.lastOffDelay
        // assertEquals(daofdOneShot2.getLastOffDelay(),24);
    }

    /*
        Entrée :spendTime(4)
        Description : Test de la méthode spendTime : l’action courante se voit tester sur l’action spendTime()
        Résultat Attendu : Retourne void
    */
    @Test
    void DAD00D7_spendTime() throws NotImplementedException {
        // TODO
        // assertEquals(daofdOneShot.spendTime(4), void);
    }

    /*
        Entrée : getMethod()
        Description : Test du Getter pour la récupération de la méthode de l’objet courrant
        Résultat Attendu : Récupération de la méthode de l’objet courant
    */
    @Test
    void DAD00D8_getMethod(){
        assertEquals(daofdOneShot.getMethod(), "getMethod");
    }

    /*
        Entrée : getCurrentLapsTime()
        Description : Test du Getter pour la récupération du laps time de l’objet courant
        Résultat Attendu : Récupération du laps time de l’objet courant
    */
    @Test
    void DAD00D9_getCurrentLapsTime(){
        assertEquals(daofdOneShot.getCurrentLapsTime(), null);
        daofdOneShot.nextAction();
        daofdOneShot.nextAction();
        assertEquals(daofdOneShot.getCurrentLapsTime(), 10);
    }

    /*
        Entrée : getObject()
        Description : Test du Getter pour récupérer l’objet depuis l’action courtante
        Résultat Attendu : Retour l’objet de l’action courante
    */
    @Test
    void DAD00D10_getObject(){
        assertEquals(daofdOneShot.getObject(), ost2);
    }

    /*
        Entrée : compareTo(c)
        Description : Test de compareTo
        Résultat Attendu : Retourne la valeur du compareTo de currentAction avec c
    */
    @Test
    void DAD00D11_compareTo(){
        daofdOneShot.nextAction();
        daofdOneShot.nextAction();
        assertEquals(daofdOneShot.compareTo(daOneShot),-1);
    }

    /*
        Entrée : next()
        Description : Test de next lorsqu’il n’y a pas d’action future
        Résultat Attendu : Retourne False
    */
    @Test
    void DAD00D12_nextWithNoFuturAction(){
        daofdOneShot.next();
        daofdOneShot.next();
        assertEquals(daofdOneShot.next(),true);

    }

    /*
        Entrée : next()
        Description : Test de next lorsqu’il y a une action future
        Résultat Attendu : Retourne True
    */
    @Test
    void DAD00D13_nextWithFuturAction(){
        assertEquals(daofdOneShot.next(),true);
    }

    /*
        Entrée : hasNext()
        Description : Test de hasNext avec onAction et offAction ont une action suivante
        Résultat Attendu : Retourne True
    */
    @Test
    void DAD00D14_hasNextWithOnActionHaveNextAndOffActionHaveNext(){
        assertEquals(daofdOneShot.hasNext(),true);
    }

    /*
         Entrée : hasNext()
         Description : Test de hasNext avec onAction n’a pas d’action suivante et offAction a une action suivante
         Résultat Attendu :Retourne True
     */
    @Test
    void DAD00D15_hasNextWithOnActionHaveNotNextAndOffActionHaveNext(){
        daofdOneShot2.nextAction();
        assertEquals(daofdOneShot2.hasNext(),true);
    }

    /*
         Entrée : hasNext()
         Description : Test de hasNext avec onAction a une action suivante et offAction n’a pas d’action suivante
         Résultat Attendu : Retourne True
     */
    @Test
    void DAD00D16_hasNextWithOnActionHaveNextAndOffActionHaveNotNext(){
        daofdOneShot.nextAction();
        assertEquals(daofdOneShot.hasNext(),true);
    }

    /*
         Entrée : hasNext()
         Description : Test de hasNext avec onAction et offAction n’ont pas d’action suivante
         Résultat Attendu : Retourne False
     */
    @Test
    void DADAD00D17_hasNextWithOnActionHaveNotNextAndOffActionHaveNotNext(){
        daofdOneShot.nextAction();
        daofdOneShot.nextAction();
        assertEquals(daofdOneShot.hasNext(),false);
    }







}