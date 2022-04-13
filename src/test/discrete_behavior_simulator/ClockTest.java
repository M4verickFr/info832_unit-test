package test.discrete_behavior_simulator;

import main.discrete_behavior_simulator.Clock;
import main.discrete_behavior_simulator.ClockObserver;
import main.exceptions.UnexpectedTimeChangeException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

class ClockTest {
    private Clock clock;
    private int time;
    private ReentrantReadWriteLock lock;
    HashSet observers = new HashSet();


    @BeforeEach
    void setUp() {
        this.clock = Clock.getInstance();
        this.time = time;
        this.observers = new HashSet<>();
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
        ClockObserver o = null;
        clock.addObserver(o);
        assertTrue(this.observers.contains(o));
    }

    /*
    Entrée : removeObserver(observer)
    Description : Test de removeObserver avec la suppression d’un observer présent dans une liste
    Résultat Attendu : Supprime un observer à la liste d'observers
     */
    @Test
    void C4_removeObserver() {
        ClockObserver o = null;
        clock.removeObserver(o);
        assertTrue(!(this.observers.contains(o)));
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
        int nextJump = 0;
        clock.setNextJump(nextJump);
        assertEquals(nextJump, this.time);

    }

    /*
    Entrée : increaseTimeEqualNextJump(4)
    Description : Test de increase où le paramètre time est égal a nextJump
    Résultat Attendu : Augmente le temps de chaque observers de 4
    */
    @Test
    void C9_increaseTimeEqualNextJump() {
        int nextJump = 0;
        int time = 0;
        try {
            clock.increase(time);
        }catch (UnexpectedTimeChangeException e) {
            e.printStackTrace();
        } ;
        assertEquals(time, this.clock.getTime());
    }
    /*
    Entrée : increaseTimeDifferentNextJump(5)
    Description : Test de increase où time est différent de nextJump
    Résultat Attendu : Exception
     */
    @Test
    void C10_increaseTimeDifferentNextJump() {
        try {
            int time = 5;
            this.clock.setNextJump(1);
            this.clock.increase(time);
        }catch (UnexpectedTimeChangeException e) {
            e.printStackTrace();
        } ;
    }

    /*
    Entrée : getTimeWithVirtualTrue()
    Description : Test de getTime lorsque la valeur de virtual est true
    Résultat Attendu : Retourne la valeur de l’attribut time
     */
    @Test
    void C11_getTimeWithVirtualTrue() {
        this.clock.setVirtual(true);
        assertEquals(this.clock.getTime(),this.time);
    }

    /*
    Entrée : getTimeWithVirtualFalse()
    Description : Test de getTime lorsque la valeur de virtual est false
    Résultat Attendu : Retourne la valeur du temps courant (Date().getTime())
     */
    @Test
    void C12_getTimeWithVirtualFalse() {
        Date date = new Date();
        this.clock.setVirtual(false);
        assertEquals(this.clock.getTime(),date.getTime());
    }

    /*
    Entrée : lockReadAccess()
    Description : Test lockReadAccess
    Résultat Attendu : Bloque la lecture
     */
    @Test
    void C13_lockReadAccess() {
        //TODO @fred & @Clément
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /*
    Entrée : unlockReadAccess()
    Description : Test unlockReadAccess
    Résultat Attendu : Débloque la lecture
     */
    @Test
    void C14_unlockReadAccess() {
        //TODO @fred & @Clément
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /*
    Entrée : lockWriteAccess()
    Description : Test lockWriteAccess
    Résultat Attendu : Bloque l'écriture
     */
    @Test
    void C15_lockWriteAccess() {
        //TODO @fred & @Clément
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /*
    Entrée : unlockWriteAccess()
    Description : Test unlockWriteAccess
    Résultat Attendu : Débloque l'écriture
     */
    @Test
    void C16_unlockWriteAccess() {
        //TODO @fred & @Clément
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /*
    Entrée : toString()
    Description : Test de toString
    Résultat Attendu : Retourne la valeur de l’attribut time en chaîne de caractères
     */
    @Test
    void C17_toString() {
        String expected = "" + this.time;
        assertEquals(expected,clock.toString());
    }

    /*
    Entrée : ClockForTimeAttribute()
    Description : Test du constructeur (assignation de time)
    Résultat Attendu : La valeur 0 sera assignée à l’attribut time
     */
    @Test
    void C18_ClockForTimeAttribute(){
        int time = 0;
        assertEquals(clock.getTime(),time);
    }

    /*
    Entrée : ClockForNextJumpAttribute()
    Description : Test du constructeur (assignation de nextJump)
    Résultat Attendu : La valeur 0 sera assignée à l’attribut nextJump
     */
    @Test
    void C19_ClockForNextJumpAttribute(){
        int nextJump = 0;
        assertEquals(clock.getNextJump(), nextJump);
    }

    /*
    Entrée : ClockForLockAttribute()
    Description : Test du constructeur (assignation de lock)
    Résultat Attendu : Un ReentrantReadWriteLock sera instancié et assigné à l’attribut lock
     */
    @Test
    void C20_ClockForLockAttribute(){
        this.lock = new ReentrantReadWriteLock();
        assertEquals(clock.getLock(), lock);
    }

    /*
    Entrée : ClockForVirtualAttribute()
    Description : Test du constructeur (assignation de virtual)
    Résultat Attendu : La valeur True sera attribuée à virtual
     */
    @Test
    void C21_ClockForVirtualAttribute(){
        boolean virtualTest = true;
        assertEquals(virtualTest, this.clock.isVirtual());
    }

    /*
    Entrée : ClockForObserversAttribute()
    Description : Test du constructeur (assignation de observers)
    Résultat Attendu : Un HashSet<ClockObserver> vide sera instancié et assigné à l’attribut observers
     */
    @Test
    void C22_ClockForObserversAttribute(){
        this.observers = new HashSet<>();
        assertEquals(clock.getObservers(), this.observers);

    }
}