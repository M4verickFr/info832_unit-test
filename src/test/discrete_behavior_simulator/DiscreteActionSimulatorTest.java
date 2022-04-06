package test.discrete_behavior_simulator;

import main.action.DiscreteAction;
import main.discrete_behavior_simulator.DiscreteActionSimulator;
import main.timer.OneShotTimer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscreteActionSimulatorTest {
    private DiscreteActionSimulator discreteActionSimulator;

    @BeforeEach
    void setUp() {
        discreteActionSimulator = new DiscreteActionSimulator();
    }

    @AfterEach
    void tearDown() {
        discreteActionSimulator = null;
    }

    /*
    Entrée : DiscreteActionSimulatorForLoggerAttribute()
    Description : Test du constructeur (assignation du nom du logger)
    Résultat Attendu : “DAS”
     */
    @Test
    void DAS1_DiscreteActionSimulatorForLoggerAttribute() {
        // Attribute logger is private, cannot be accessed and tested
    }

    /*
    Entrée : DiscreteActionSimulatorForLevelAttribute()
    Description : Test du constructeur (assignation du “level” du logger)
    Résultat Attendu : “Level.ALL”
     */
    @Test
    void DAS2_DiscreteActionSimulatorForLevelAttribute() {
        // Attribute logger is private, cannot be accessed and tested
    }

    /*
    Entrée : DiscreteActionSimulatorForsetUseParentHandlersAttribute()
    Description : Test du constructeur (assignation du “setUseParentHandlers” du logger)
    Résultat Attendu : “true”
     */
    @Test
    void DAS3_DiscreteActionSimulatorForsetUseParentHandlersAttribute() {
        // Attribute logger is private, cannot be accessed and tested
    }

    /*
    Entrée : DiscreteActionSimulatorForFileNameAttribute()
    Description : Test du constructeur (nom du fichier)
    Résultat Attendu : “DiscreteActionSimulator.log”
     */
    @Test
    void DAS4_DiscreteActionSimulatorForFileNameAttribute() {
        // Attribute logFile is private, cannot be accessed and tested
    }

    /*
    Entrée : DiscreteActionSimulator()
    Description : Test du constructeur (assignation du “formatter” du logFile)
    Résultat Attendu : Le formatter est un LogFormatter
     */
    @Test
    void DAS5_DiscreteActionSimulator() {
        // Attribute logFile is private, cannot be accessed and tested
    }

    /*
    Entrée : DiscreteActionSimulator()
    Description : Test du constructeur (assignation de logConsole)
    Résultat Attendu : Le logConsole est un ConsoleHandler
     */
    @Test
    void DAS6_DiscreteActionSimulator() {
        // Attribute logConsole is private, cannot be accessed and tested
    }

    /*
    Entrée : DiscreteActionSimulator()
    Description : Test du constructeur (ajout du “logFile” dans la liste de handlers du logger)
    Résultat Attendu : Le logger contient le logFile dans ses handlers
     */
    @Test
    void DAS7_DiscreteActionSimulator() {
        // Attribute logger is private, cannot be accessed and tested
    }

    /*
    Entrée : DiscreteActionSimulator()
    Description : Test du constructeur (ajout du “logConsole” dans la liste de handlers du logger)
    Résultat Attendu : Le logger contient le logConsole dans ses handlers
     */
    @Test
    void DAS8_DiscreteActionSimulator() {
        // Attribute logger is private, cannot be accessed and tested
    }

    /*
    Entrée : DiscreteActionSimulator()
    Description : Test du constructeur (assignation de globalTime)
    Résultat Attendu : Le globalTime est un Clock
     */
    @Test
    void DAS9_DiscreteActionSimulator() {
        // Attribute globalTime is private, cannot be accessed and tested
    }

    /*
    Entrée : DiscreteActionSimulator()
    Description : Test du constructeur (assignation de t)
    Résultat Attendu : t est un Thread
     */
    @Test
    void DAS10_DiscreteActionSimulator() {
        // Attribute t is private, cannot be accessed and tested
    }

    /*
    Entrée : setNbLoop(0)
    Description : Test de setNbLoop avec un nombre nul de nbLoop
    Résultat Attendu : nbLoop = 0
     */
    @Test
    void DAS11_setNbLoop() {
        // Attributes nbLoop and step are private, cannot be accessed and tested
    }

    /*
    Entrée : setNbLoop(0)
    Description : Test de setNbLoop avec un nombre nul de nbLoop
    Résultat Attendu : step = -1
     */
    @Test
    void DAS12_setNbLoop() {
        // Attributes nbLoop and step are private, cannot be accessed and tested
    }

    /*
    Entrée : setNbLoop(1)
    Description : Test de setNbLoop avec un nombre positif de nbLoop
    Résultat Attendu : nbLoop = 1
     */
    @Test
    void DAS13_setNbLoop() {
        // Attributes nbLoop and step are private, cannot be accessed and tested
    }

    /*
    Entrée : setNbLoop(1)
    Description : Test de setNbLoop avec un nombre positif de nbLoop
    Résultat Attendu : step = 1
     */
    @Test
    void DAS14_setNbLoop() {
        // Attributes nbLoop and step are private, cannot be accessed and tested
    }

    /*
    Entrée : addAction(c)
    Description : Test de addAction avec c qui possède des actions
    Résultat Attendu : Ajoute à la liste d’action la prochaine action de c
     */
    @Test
    void DAS15_setAddAction() {
        assertEquals("------------------\nTestAuto :0---------------------\n", discreteActionSimulator.toString());

        DiscreteAction discreteAction = new DiscreteAction(new Object(), "toString", new OneShotTimer(0));

        discreteActionSimulator.addAction(discreteAction);

        assertEquals("""
                ------------------
                TestAuto :1Object : java.lang.Object
                 Method : toString
                 Stat. : main.timer.OneShotTimer@62bd765
                 delay: 0
                ---------------------
                """, discreteActionSimulator.toString());
    }

    /*
    Entrée : toString()
    Description : Test de toString avec une liste vide de actionsList
    Résultat Attendu : Ajoute à la liste d’action la prochaine action de c
     */
    @Test
    void DAS21_testToString() {
        assertEquals("------------------\nTestAuto :0---------------------\n", discreteActionSimulator.toString());
    }

    /*
    Entrée : getRunning()
    Description : Test de getRunning sur une instance sur laquelle start() n'a jamais ete appele
    Résultat Attendu : false
     */
    @Test
    void DAS22_testGetRunning() {
        assertFalse(discreteActionSimulator.getRunning());
    }

    /*
    Entrée : start()
    Description : Test de start
    Résultat Attendu : true
     */
    @Test
    void DAS23_testStart() {
        assertFalse(discreteActionSimulator.getRunning());

        discreteActionSimulator.start();

        assertTrue(discreteActionSimulator.getRunning());
    }

    /*
    Entrée : stop()
    Description : Test de stop sur une instance qui ne roule pas
    Résultat Attendu : false
     */
    @Test
    void DAS23_testStopNotStarted() {
        discreteActionSimulator.stop();

        assertFalse(discreteActionSimulator.getRunning());
    }

    /*
    Entrée : run()
    Description : Test de run
    Résultat Attendu : getRunning retourne false a la fin de l'execution
     */
    @Test
    void DAS24_testRun() {
        discreteActionSimulator.start();

        discreteActionSimulator.setNbLoop(3);

        discreteActionSimulator.run();

        assertFalse(discreteActionSimulator.getRunning());
    }
}