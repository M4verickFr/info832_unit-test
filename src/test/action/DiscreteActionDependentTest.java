package test.action;

import main.action.DiscreteActionDependent;
import main.action.DiscreteActionInterface;
import main.timer.OneShotTimer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiscreteActionDependentTest {
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
        Entrée : DiscreteActionDependent(obj, mtd, timer)
        Description : Test de la création de l’objet DiscreteActionDependent
        Résultat Attendu : Objet créer avec l’objet DiscreteAction(obj, mtd, timer) stocké dans la variable baseAction,, un TreeSet de DiscreteAction créé dans dependentActions, l’itérateur du TreeSet dans it et l’action courante (baseAction) dans currentAction
     */
    @Test
    void DAD1_constructorMethod(){
        assertEquals(dadOneShot.getObject(), ost);
        assertEquals(dadOneShot.getMethod().getName(), "hasNext");
        //Aucune possibilité de récupérer daOneShot.timmer
        //Aucune possibilité de récupérer daOneShot.dependentAction
        //Aucune possibilité de récupérer daOneShot.it
        //Aucune possibilité de récupérer daOneShot.currentAction
    }

    /*
        Entrée : addDependence(obj, mtd, timer)
        Description : Test ajout d’une action
        Résultat Attendu : ajout de la discreteAction( obj, mtd, timer) dans le TreeSet
     */
    @Test
    void DAD2_dependence(){
        dadOneShot.addDependence(ost2, "hasNext", ost2);
        // Aucun moyen d'avoir la liste de dépendence pour tester l'ajout
    }

    /*
        Entrée : nextMethod()
        Description : Test de la méthode nextMethod avec currentAction = baseAction
        Résultat Attendu : La variable it prend la valeur de l’itérateur du TreeSet et la currentAction prend la valeur de la prochaine iteration
     */
    @Test
    void DAD3_nextMethodWithCurrentEqualsBase(){
        dadOneShot.addDependence(ost2, "hasNext", ost2);
        dadOneShot.nextMethod();
        //Aucun moyen de tester le bon fonctionnement
        // it et currentAction impossible à atteindre
    }

    /*
        Entrée : nextMethod()
        Description : Test de la méthode nextMethod avec currentAction dernière action de la list
        Résultat Attendu : La variable la currentAction prend la valeur de baseAction
     */
    @Test
    void DAD4_nextMethodWithCurrentIsLastAction(){
        dadOneShot.addDependence(ost2, "hasNext", ost2);
        dadOneShot.nextMethod();
        dadOneShot.nextMethod();
        //Aucun moyen de tester le bon fonctionnement
        // it et currentAction impossible à atteindre
    }




}