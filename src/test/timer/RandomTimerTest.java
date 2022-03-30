package test.timer;

import main.timer.RandomTimer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 *
 */
class RandomTimerTest {

    @Test
    void exceptionTest() { // A RENOMMER

        // ON TESTE SI L'EXCEPTION DES CONSTRUCTEURS EST BIEN LEVEE
        // REFAIRE PLEINS DE FONCTIONS
        // Création d'un RandomTimer pour la loi exponentielle

        double param = 1.0;

        Exception thrown = assertThrows(Exception.class, () -> {
            RandomTimer randomTimerPOSIBILIST = new RandomTimer(RandomTimer.randomDistribution.POSIBILIST, param);

        });
        assertEquals("Bad Timer constructor for selected distribution",thrown.getMessage());
    }


    @Test
    void getDistributionParams() { // A RENOMMER

        // ON TESTE LES DISTRIBUTIONS SI ELLES SONT BONNES OU PAS, SI L'EXCEPTION EST BIEN LEVEE
        // REFAIRE PLEINS DE FONCTIONS

        // Création d'un RandomTimer pour la loi exponentielle
        int lolim = -1;
        int hilim = 1;

        Exception thrown = assertThrows(Exception.class, () -> {
            RandomTimer randomTimerPOSIBILIST = new RandomTimer(RandomTimer.randomDistribution.POSIBILIST, lolim, hilim);

        });
        assertEquals("Bad Timer constructor for selected distribution",thrown.getMessage());
    }


/*
        // Création d'un RandomTimer pour la loi de Poisson
        assertThrows(Exception.class, () -> {
            RandomTimer randomTimerPOISSON = new RandomTimer(RandomTimer.randomDistribution.POISSON, param);
            // On doit avoir mean = 1.0
            assertEquals("mean: " + param, randomTimerPOISSON.getDistributionParam());

        });



        // Création d'un RandomTimer pour la Normale (Gauss)
        int limitInferior = -1;
        int limitSuperior = 1;
        assertThrows(ExceptionInInitializerError.class, () -> {
            RandomTimer randomTimerGAUSSIAN = new RandomTimer(RandomTimer.randomDistribution.GAUSSIAN, limitInferior, limitSuperior);
            // On doit avoir une limite inférieure et une limite supérieure
            assertEquals("Inferior limit: " + limitInferior + " Superior limit: " + limitSuperior, randomTimerGAUSSIAN.getDistributionParam());

        });



        // Création d'un RandomTimer pour la loi Uniforme

        assertThrows(ExceptionInInitializerError.class, () -> {
            RandomTimer randomTimerPOSSIBILIST = new RandomTimer(RandomTimer.randomDistribution.POSIBILIST, limitInferior, limitSuperior);
            // On doit avoir une limite inférieure et une limite supérieure
            assertEquals("Inferior limit: " + limitInferior + " Superior limit: " + limitSuperior, randomTimerPOSSIBILIST.getDistributionParam());

        });


 */
    }











