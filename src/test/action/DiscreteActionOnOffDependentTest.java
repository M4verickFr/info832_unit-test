package test.action;

import main.action.DiscreteActionDependent;
import main.action.DiscreteActionInterface;
import main.timer.OneShotTimer;
import org.junit.jupiter.api.Test;

class DiscreteActionOnOffDependentTest {

    private OneShotTimer ost;
    private OneShotTimer ost2;
    private DiscreteActionDependent dadOneShot;
    private DiscreteActionInterface dadOneShot2;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        ost = new OneShotTimer(10);
        ost2 = new OneShotTimer(15);
        dadOneShot = new DiscreteActionDependent(ost, "hasNext", ost);
        dadOneShot2 = new DiscreteActionDependent(ost, "hasNext", ost2);
    }

    /*
        Entrée : DiscreteActionOnOffDependent(Obj,on,timerOn,off,timerOff)
        Description : Test de déclaration de l’objet DiscreteActionOnOffDependent
        Résultat Attendu :Objet créé avec un objet DiscreteAction(obj,on,timerOn) stocké dans la variable onAction, un second objet similaire DiscreteAction(obj,off,timerOff) stocké dans la variable offAction.
        L’instanciation de offAction est également stocké dans current action et le currentLapsTime est instancié à 0.
    */
    @Test
    void DAD00D1_firstConstructor(){

    }

    /*
        Entrée : DiscreteActionOnOffDependent(obj, on, datesOn, off, datesOff)
        Description : Test du deuxième constructeur avec la première date de datesOn antérieur à la première date de datesOff
        Résultat Attendu : Objet créé avec un objet DiscreteAction(obj,on, new DateTimer(datesOn)) stocké dans la variable onAction, un second objet similaire DiscreteAction(obj,on, new DateTimer(datesOn)) stocké dans la variable offAction
    */
    @Test
    void DAD00D2_secondConstructorWithFirstDateOnInfFirstDateOff(){

    }

    /*
        Entrée : DiscreteActionOnOffDependent(obj, on, datesOn, off, datesOff)
        Description : Test du deuxième constructeur avec la première date de datesOn postérieur à la première date de datesOff
        Résultat Attendu : Objet créé avec un objet DiscreteAction(obj,on, new DateTimer(datesOn)) stocké dans la variable onAction, un second objet similaire DiscreteAction(obj,on, new DateTimer(datesOn)) stocké dans la variable offAction currentAction prend la valeur de offAction

    */

    @Test
    void DAD00D3_secondConstructorWithFirstDateOnPosterieurFirstDateOff(){

    }

    /*
        Entrée : DiscreteActionOnOffDependent(obj, on, datesOn, off, datesOff)
        Description : Test du deuxième constructeur avec la première date de datesOn identique à la première date de datesOff
        Résultat Attendu : Objet créé avec un objet DiscreteAction(obj,on, new DateTimer(datesOn)) stocké dans la variable onAction, un second objet similaire DiscreteAction(obj,on, new DateTimer(datesOn)) stocké dans la variable offAction currentAction prend la valeur de onAction
    */
    @Test
    void DAD00D4_secondConstructorWithFirstDateOnEqualsFirstDateOff(){

    }

    /*
        Entrée : nextAction()
        Description : Test de la méthode avec un currentAction différent de onAction
        Résultat Attendu : Remplacement de la currentAction par l’action suivante de l’action on
    */
    @Test
    void DAD00D5_nextActionWithCurrentActionDiffOnAction(){

    }

    /*
        Entrée : nextAction()
        Description : Test de la méthode avec un currentAction égale à onAction
        Résultat Attendu : Remplacement de la currentAction par l’action suivante de l’off Action, et on attribu lastOffDelay par le LapsTime de la nouvelle curent action
    */
    @Test
    void DAD00D6_nextActionWithCurrentActionEqualsOnAction(){

    }

    /*
        Entrée :spendTime(4)
        Description : Test de la méthode spendTime : l’action courante se voit tester sur l’action spendTime()
        Résultat Attendu : Retourne void
    */
    @Test
    void DAD00D7_spendTime(){

    }

    /*
        Entrée : getMethod()
        Description : Test du Getter pour la récupération de la méthode de l’objet courrant
        Résultat Attendu : Récupération de la méthode de l’objet courant
    */
    @Test
    void DAD00D8_getMethod(){

    }

    /*
        Entrée : getCurrentLapsTime()
        Description : Test du Getter pour la récupération du laps time de l’objet courant
        Résultat Attendu : Récupération du laps time de l’objet courant
    */
    @Test
    void DAD00D9_getCurrentLapsTime(){

    }

    /*
        Entrée : getObject()
        Description : Test du Getter pour récupérer l’objet depuis l’action courtante
        Résultat Attendu : Retour l’objet de l’action courante
    */
    @Test
    void DAD00D10_getObject(){

    }

    /*
        Entrée : compareTo(c)
        Description : Test de compareTo
        Résultat Attendu : Retourne la valeur du compareTo de currentAction avec c
    */
    @Test
    void DAD00D11_compareTo(){

    }

    /*
        Entrée : next()
        Description : Test de next lorsqu’il n’y a pas d’action future
        Résultat Attendu : Retourne False
    */
    @Test
    void DAD00D12_nextWithNoFuturAction(){

    }

    /*
        Entrée : next()
        Description : Test de next lorsqu’il y a une action future
        Résultat Attendu : Retourne True
    */
    @Test
    void DAD00D13_nextWithFuturAction(){

    }

    /*
        Entrée : hasNext()
        Description : Test de hasNext avec onAction et offAction ont une action suivante
        Résultat Attendu : Retourne True
    */
    @Test
    void DAD00D14_hasNextWithOnActionHaveNextAndOffActionHaveNext(){

    }

    /*
         Entrée : hasNext()
         Description : Test de hasNext avec onAction n’a pas d’action suivante et offAction a une action suivante
         Résultat Attendu :Retourne True
     */
    @Test
    void DAD00D15_hasNextWithOnActionHaveNotNextAndOffActionHaveNext(){

    }

    /*
         Entrée : hasNext()
         Description : Test de hasNext avec onAction a une action suivante et offAction n’a pas d’action suivante
         Résultat Attendu : Retourne True
     */
    @Test
    void DAD00D16_hasNextWithOnActionHaveNextAndOffActionHaveNotNext(){

    }

    /*
         Entrée : hasNext()
         Description : Test de hasNext avec onAction et offAction n’ont pas d’action suivante
         Résultat Attendu : Retourne False
     */
    @Test
    void DADAD00D17_hasNextWithOnActionHaveNotNextAndOffActionHaveNotNext(){

    }







}