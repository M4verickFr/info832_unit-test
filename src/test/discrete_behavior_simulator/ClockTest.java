package test.discrete_behavior_simulator;

import main.discrete_behavior_simulator.Clock;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClockTest {
    private Clock clock;

    @BeforeEach
    void setUp() {
        this.clock = Clock.getInstance();

    }

    @AfterEach
    void tearDown() {
    }

    /*
    Entrée : getInstanceWithoutAttributeNull()
    Description : Test de getInstance() avec un attribut instance différent de null
    Résultat Attendu : Valeur de la clock
     */
    @Test
    void C2_getInstanceWithoutAttributeNull() {
        Clock clocktest;
        clocktest = Clock.getInstance();
        assertEquals(this.clock, clocktest);
        assertSame(this.clock, clocktest);
    }

    /*
    Entrée : addObserver(observer)
    Description : Test de addObserver avec l’ajout d’un observer à une liste vide
    Résultat Attendu : Ajoute un observer à la liste d'observers
     */
    @Test
    void C3_addObserver() {
        //Aucun accès à la liste d'observers


    }

    /*
    Entrée : removeObserver(observer)
    Description : Test de removeObserver avec la suppression d’un observer présent dans une liste
    Résultat Attendu : Supprime un observer à la liste d'observers
     */
    @Test
    void C4_removeObserver() {
        //Aucun accès à la liste d'observers
    }

    /*
    Entrée : setVirtualWithParamTrue(true)
    Description : Test de setVirtual avec le paramètre à true
    Résultat Attendu : Assigne la valeur de virtuel à true
    */
    @Test
    void C5_setVirtualWithParamTrue() {
        this.clock.setVirtual(true);
        assertTrue(this.clock.isVirtual());
    }

    /*
    Entrée : setVirtualWithParamFalse(false)
    Description : Test de setVirtual avec le paramètre à false
    Résultat Attendu : Assigne la valeur de virtuel à false
     */
    @Test
    void C6_setVirtualWithParamFalse() {
        this.clock.setVirtual(false);
        assertFalse(this.clock.isVirtual());

    }

    /*
    Entrée : isVirtual()
    Description : Test de isVirtual
    Résultat Attendu : Retourne la valeur de virtual
     */
    @Test
    void C7_isVirtual() {
        boolean testTrue = true;
        assertEquals(this.clock.isVirtual(), testTrue);
    }

    /*
    Entrée : setNextJump(currentTime + 10)
    Description : Test de setNextJump sur une liste contenant un observer
    Résultat Attendu : Assigne la valeur nextJump à currentTime + 10 secondes
     */
    @Test
    void C8_setNextJump() {
    }

    /*
    Entrée : increaseTimeEqualNextJump(4)
    Description : Test de increase où le paramètre time est égal a nextJump
    Résultat Attendu : Augmente le temps de chaque observers de 4
    */
    @Test
    void C9_increaseTimeEqualNextJump() {
    }
    /*
    Entrée : increaseTimeDifferentNextJump(5)
    Description : Test de increase où time est différent de nextJump
    Résultat Attendu : Exception
     */
    @Test
    void C10_increaseTimeDifferentNextJump() {
    }

    /*
    Entrée : getTimeWithVirtualTrue()
    Description : Test de getTime lorsque la valeur de virtual est true
    Résultat Attendu : Retourne la valeur de l’attribut time
     */
    @Test
    void C11_getTimeWithVirtualTrue() {
    }

    /*
    Entrée : getTimeWithVirtualFalse()
    Description : Test de getTime lorsque la valeur de virtual est false
    Résultat Attendu : Retourne la valeur du temps courant (Date().getTime())
     */
    @Test
    void C12_getTimeWithVirtualFalse() {
    }

    /*
    Entrée : lockReadAccess()
    Description : Test lockReadAccess
    Résultat Attendu : Bloque la lecture
     */
    @Test
    void C13_lockReadAccess() {
    }

    /*
    Entrée : unlockReadAccess()
    Description : Test unlockReadAccess
    Résultat Attendu : Débloque la lecture
     */
    @Test
    void C14_unlockReadAccess() {
    }

    /*
    Entrée : lockWriteAccess()
    Description : Test lockWriteAccess
    Résultat Attendu : Bloque l'écriture
     */
    @Test
    void C15_lockWriteAccess() {
    }

    /*
    Entrée : unlockWriteAccess()
    Description : Test unlockWriteAccess
    Résultat Attendu : Débloque l'écriture
     */
    @Test
    void C16_unlockWriteAccess() {
    }

    /*
    Entrée : toString()
    Description : Test de toString
    Résultat Attendu : Retourne la valeur de l’attribut time en chaîne de caractères
     */
    @Test
    void C17_toString() {
    }

    /*
    Entrée : ClockForTimeAttribute()
    Description : Test du constructeur (assignation de time)
    Résultat Attendu : La valeur 0 sera assignée à l’attribut time
     */
    @Test
    void C18_ClockForTimeAttribute(){
    }

    /*
    Entrée : ClockForNextJumpAttribute()
    Description : Test du constructeur (assignation de nextJump)
    Résultat Attendu : La valeur 0 sera assignée à l’attribut nextJump
     */
    @Test
    void C19_ClockForNextJumpAttribute(){
    }

    /*
    Entrée : ClockForLockAttribute()
    Description : Test du constructeur (assignation de lock)
    Résultat Attendu : Un ReentrantReadWriteLock sera instancié et assigné à l’attribut lock
     */
    @Test
    void C20_ClockForLockAttribute(){
    }

    /*
    Entrée : ClockForVirtualAttribute()
    Description : Test du constructeur (assignation de virtual)
    Résultat Attendu : La valeur True sera attribuée à virtual
     */
    @Test
    void C21_ClockForVirtualAttribute(){
    }

    /*
    Entrée : ClockForObserversAttribute()
    Description : Test du constructeur (assignation de observers)
    Résultat Attendu : Un HashSet<ClockObserver> vide sera instancié et assigné à l’attribut observers
     */
    @Test
    void C22_ClockForObserversAttribute(){
    }
}