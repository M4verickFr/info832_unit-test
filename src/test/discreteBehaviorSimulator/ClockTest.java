package test.discreteBehaviorSimulator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Clock;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClockTest {
    private Clock clock;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void C1_getInstance() {
        /*
        Entrée : getInstance()
        Description : Test de getInstance() avec un attribut instance null
        Résultat Attendu : Valeur de la clock
         */

        assertEquals(clock, null);
    }

    @Test
    void C2_getInstance() {
        /*
        Entrée : getInstance()
        Description : Test de getInstance() avec un attribut instance différent de null
        Résultat Attendu : Valeur de la clock
         */

    }

    @Test
    void C3_addObserver() {
        /*
        Entrée : addObserver(observer)
        Description : Test de addObserver avec l’ajout d’un observer à une liste vide
        Résultat Attendu : Ajoute un observer à la liste d'observers
         */
    }

    @Test
    void C4_removeObserver() {
        /*
        Entrée : removeObserver(observer)
        Description : Test de removeObserver avec la suppression d’un observer présent dans une liste
        Résultat Attendu : Supprime un observer à la liste d'observers
         */

    }

    @Test
    void C5_setVirtual() {
        /*
        Entrée : setVirtual(true)
        Description : Test de setVirtual avec le paramètre à true
        Résultat Attendu : Assigne la valeur de virtuel à true
         */
    }

    @Test
    void C6_setVirtual() {
        /*
        Entrée : setVirtual(false)
        Description : Test de setVirtual avec le paramètre à false
        Résultat Attendu : Assigne la valeur de virtuel à false
         */
    }

    @Test
    void C7_isVirtual() {
        /*
        Entrée : isVirtual()
        Description : Test de setVirtual avec le paramètre à false
        Résultat Attendu : Assigne la valeur de virtuel à false
         */
    }

    @Test
    void C8_setNextJump() {
        /*
        Entrée : setNextJump(currentTime + 10)
        Description : Test de setNextJump sur une liste contenant un observer
        Résultat Attendu : Assigne la valeur nextJump à currentTime + 10 secondes
         */
    }

    @Test
    void C9_increase() {
        /*
        Entrée : increase(4)
        Description : Test de increase où le paramètre time est égal a nextJump
        Résultat Attendu : Augmente le temps de chaque observers de 4
         */
    }

    @Test
    void C10_increase() {
        /*
        Entrée : increase(5)
        Description : Test de increase où time est différent de nextJump
        Résultat Attendu : Exception
         */
    }

    @Test
    void C11_getTime() {
        /*
        Entrée : getTime()
        Description : Test de getTime lorsque la valeur de virtual est true
        Résultat Attendu : Retourne la valeur de l’attribut time
         */
    }

    @Test
    void C12_getTime() {
    }

    @Test
    void C13_lockReadAccess() {
    }

    @Test
    void C14_unlockReadAccess() {
    }

    @Test
    void C15_lockWriteAccess() {
    }

    @Test
    void C16_unlockWriteAccess() {
    }

    @Test
    void C17_testToString() {
    }

    @Test
    void C18_Clock(){
    }

    @Test
    void C19_Clock(){
    }

    @Test
    void C20_Clock(){
    }

    @Test
    void C21_Clock(){
    }

    @Test
    void C22_Clock(){
    }
}