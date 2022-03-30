package test.discrete_behavior_simulator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DiscreteActionSimulatorTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    /*
    Entrée : DiscreteActionSimulatorForLoggerAttribute()
    Description : Test du constructeur (assignation du nom du logger)
    Résultat Attendu : “DAS”
     */
    @Test
    void DAS1_DiscreteActionSimulatorForLoggerAttribute() {
    }

    /*
    Entrée : DiscreteActionSimulatorForLevelAttribute()
    Description : Test du constructeur (assignation du “level” du logger)
    Résultat Attendu : “Level.ALL”
     */
    @Test
    void DAS2_DiscreteActionSimulatorForLevelAttribute() {
    }

    /*
    Entrée : DiscreteActionSimulatorForsetUseParentHandlersAttribute()
    Description : Test du constructeur (assignation du “setUseParentHandlers” du logger)
    Résultat Attendu : “true”
     */
    @Test
    void DAS3_DiscreteActionSimulatorForsetUseParentHandlersAttribute() {
    }

    /*
    Entrée : DiscreteActionSimulatorForFileNameAttribute()
    Description : Test du constructeur (nom du fichier)
    Résultat Attendu : “DiscreteActionSimulator.log”
     */
    @Test
    void DAS4_DiscreteActionSimulatorForFileNameAttribute() {
    }

    /*
    Entrée : DiscreteActionSimulator()
    Description : Test du constructeur (assignation du “formatter” du logFile)
    Résultat Attendu : Le formatter est un LogFormatter
     */
    @Test
    void DAS5_DiscreteActionSimulator() {
    }

    /*
    Entrée : DiscreteActionSimulator()
    Description : Test du constructeur (assignation de logConsole)
    Résultat Attendu : Le logConsole est un ConsoleHandler
     */
    @Test
    void DAS6_DiscreteActionSimulator() {
    }

    /*
    Entrée : DiscreteActionSimulator()
    Description : Test du constructeur (ajout du “logFile” dans la liste de handlers du logger)
    Résultat Attendu : Le logger contient le logFile dans ses handlers
     */
    @Test
    void DAS7_DiscreteActionSimulator() {
    }

    /*
    Entrée : DiscreteActionSimulator()
    Description : Test du constructeur (ajout du “logConsole” dans la liste de handlers du logger)
    Résultat Attendu : Le logger contient le logConsole dans ses handlers
     */
    @Test
    void DAS8_DiscreteActionSimulator() {
    }

    /*
    Entrée : DiscreteActionSimulator()
    Description : Test du constructeur (assignation de globalTime)
    Résultat Attendu : Le globalTime est un Clock
     */
    @Test
    void DAS9_DiscreteActionSimulator() {
    }

    /*
    Entrée : DiscreteActionSimulator()
    Description : Test du constructeur (assignation de t)
    Résultat Attendu : t est un Thread
     */
    @Test
    void DAS10_DiscreteActionSimulator() {
    }

    /*
    Entrée : setNbLoop(0)
    Description : Test de setNbLoop avec un nombre nul de nbLoop
    Résultat Attendu : nbLoop = 0
     */
    @Test
    void DAS11_setNbLoop() {
    }

    /*
    Entrée : setNbLoop(0)
    Description : Test de setNbLoop avec un nombre nul de nbLoop
    Résultat Attendu : step = -1
     */
    @Test
    void DAS12_setNbLoop() {
    }

    /*
    Entrée : setNbLoop(1)
    Description : Test de setNbLoop avec un nombre positif de nbLoop
    Résultat Attendu : nbLoop = 1
     */
    @Test
    void DAS13_setNbLoop() {
    }

    /*
    Entrée : setNbLoop(1)
    Description : Test de setNbLoop avec un nombre positif de nbLoop
    Résultat Attendu : step = 1
     */
    @Test
    void DAS14_setNbLoop() {
    }

    /*
    Entrée : addAction(c)
    Description : Test de addAction avec c qui possède des actions
    Résultat Attendu : Ajoute à la liste d’action la prochaine action de c
     */
    @Test
    void DAS15_setNbLoop() {
    }

    /*
    Entrée : toString()
    Description : Test de toString avec une liste vide de actionsList
    Résultat Attendu : Ajoute à la liste d’action la prochaine action de c
     */
    @Test
    void DAS21_testToString() {
    }

    @Test
    void getRunning() {
    }
}