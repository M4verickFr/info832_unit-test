package test.action;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DiscreteActionDependentTest {

    @BeforeEach
    void setUp() {
    }

    /*
        Entrée : DiscreteActionDependent(obj, mtd, timer)
        Description : Test de la création de l’objet DiscreteActionDependent
        Résultat Attendu : Objet créer avec l’objet DiscreteAction(obj, mtd, timer) stocké dans la variable baseAction,, un TreeSet de DiscreteAction créé dans dependentActions, l’itérateur du TreeSet dans it et l’action courante (baseAction) dans currentAction
     */
    @Test
    void DAD1_constructorMethod(){
    }

    /*
        Entrée : addDependence(obj, mtd, timer)
        Description : Test ajout d’une action
        Résultat Attendu : ajout de la discreteAction( obj, mtd, timer) dans le TreeSet
     */
    @Test
    void DAD2_dependence(){
    }

    /*
        Entrée : nextMethod()
        Description : Test de la méthode nextMethod avec currentAction = baseAction
        Résultat Attendu : La variable it prend la valeur de l’itérateur du TreeSet et la currentAction prend la valeur de la prochaine iteration
     */
    @Test
    void DAD3_nextMethod(){
    }

    /*
        Entrée : nextMethod()
        Description : Test de la méthode nextMethod avec currentAction = baseAction
        Résultat Attendu : La variable it prend la valeur de l’itérateur du TreeSet et la currentAction prend la valeur de la prochaine iteration
     */
    @Test
    void DAD3_nextMethodWithCurrentEqualsBase(){
    }



}