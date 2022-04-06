package timerTest;

import org.junit.jupiter.api.Test;

import timer.RandomTimer;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class RandomTimerTest {

    @Test
    void getDistributionParams() {

        // Créer un timer pour la loi exponentielle
        try {
            double param = 1.0;
            RandomTimer randomTimerEXP = new RandomTimer(RandomDistribution.EXP, param);

            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            // We need to get a rate of 1.0 (as this is an exponential law)
            assertEquals("rate: " + randomTimerEXP.getRate(), randomTimerEXP.getDistributionParams());
        } catch (IncorrectDistributionException e) {
            e.printStackTrace();
        }

        // Create a RandomTimer of a poisson law
        try {
            double param = 1.0;
            RandomTimer randomTimerPOISSON = new RandomTimer(RandomDistribution.POISSON, param);

            // We need to get a mean of 1.0 (as this is a poisson law)
            assertEquals("mean: " + randomTimerPOISSON.getMean(), randomTimerPOISSON.getDistributionParams());
        } catch (IncorrectDistributionException e) {
            e.printStackTrace();
        }

        // Create a RandomTimer of a gaussian law
        try {
            double limitInferior = -1.0;
            double limitSuperior = 1.0;
            RandomTimer randomTimerGAUSSIAN = new RandomTimer(RandomDistribution.GAUSSIAN, limitInferior,limitSuperior);

            // We need to get an inferior limit and a superior limit (as we got a gaussian law)
            assertEquals("Inferior limit: " + randomTimerGAUSSIAN.getLimitInferior() + " Superior limit: " + randomTimerGAUSSIAN.getLimitSuperior(), randomTimerGAUSSIAN.getDistributionParams());
        } catch (IncorrectDistributionException e) {
            e.printStackTrace();
        }

        // Create a RandomTimer of a uniform law
        try {
            double limitInferior = -1.0;
            double limitSuperior = 1.0;
            RandomTimer randomTimerUNIFORM = new RandomTimer(RandomDistribution.UNIFORM, limitInferior,limitSuperior);

            // We need to get an inferior limit and a superior limit (as we got a uniform law)
            assertEquals("Inferior limit: " + randomTimerUNIFORM.getLimitInferior() + " Superior limit: " + randomTimerUNIFORM.getLimitSuperior(), randomTimerUNIFORM.getDistributionParams());
        } catch (IncorrectDistributionException e) {
            e.printStackTrace();
        }
    }

    // Get the mean of the RandomTimer
    @Test
    void getMean() {

        // Create a RandomTimer of an exponential law
        try {
            double param = 1.0;
            RandomTimer randomTimerEXP = new RandomTimer(RandomDistribution.EXP, param);

            assertEquals(param, randomTimerEXP.getMean());
        } catch (IncorrectDistributionException e) {
            e.printStackTrace();
        }

        // Create a RandomTimer of a poisson law
        try {
            double param = 1.0;
            RandomTimer randomTimerPOISSON = new RandomTimer(RandomDistribution.POISSON, param);

            assertEquals(param, randomTimerPOISSON.getMean());
        } catch (IncorrectDistributionException e) {
            e.printStackTrace();
        }

        // Create a RandomTimer of a gaussian law
        try {
            double limitInferior = -1.0;
            double limitSuperior = 1.0;
            RandomTimer randomTimerGAUSSIAN = new RandomTimer(RandomDistribution.GAUSSIAN, limitInferior,limitSuperior);

            assertEquals((limitSuperior + limitInferior) / 2.0, randomTimerGAUSSIAN.getMean());
        } catch (IncorrectDistributionException e) {
            e.printStackTrace();
        }

        // Create a RandomTimer of a uniform law
        try {
            double limitInferior = -1.0;
            double limitSuperior = 1.0;
            RandomTimer randomTimerUNIFORM = new RandomTimer(RandomDistribution.UNIFORM, limitInferior,limitSuperior);

            assertEquals((limitSuperior + limitInferior) / 2.0, randomTimerUNIFORM.getMean());
        } catch (IncorrectDistributionException e) {
            e.printStackTrace();
        }
    }

    // Not need to test hasNext() as it returns always true (to show it we will call hasNext() 100 times)
    @Test
    void hasNext() {
        try {
            double limitInferior = -1.0;
            double limitSuperior = 1.0;
            RandomTimer randomTimerUNIFORM = new RandomTimer(RandomDistribution.UNIFORM, limitInferior,limitSuperior);

            for (int i = 0; i < 100; i++) {
                assertTrue(randomTimerUNIFORM.hasNext());
            }

        } catch (IncorrectDistributionException e) {
            e.printStackTrace();
        }

        // Then we will create a RandomTimer with the wrong arguments for the distribution and this will throw an IncorrectDistributionException
        assertThrows(IncorrectDistributionException.class, () -> new RandomTimer(RandomDistribution.UNIFORM, 1));

        assertThrows(IncorrectDistributionException.class, () -> new RandomTimer(RandomDistribution.EXP, -1, 1));

        // If the user create a RandomTimer with the constructor containing the limits and that the inferior one is greater than the superior one we should throw an IncorrectDistributionException
        assertThrows(IncorrectDistributionException.class, () -> new RandomTimer(RandomDistribution.UNIFORM, 1, -1));

    }

    // Here we want to know if the law is working, we will simulate 100 000 next appeals and we will compare it to the mean of the law to know if the law is working (with a minor error of 1%)
    // And we will checking if the nextValue are between the inferiorLimit and the superiorLimit
    @Test
    void next() {

        // The number of times we want to get hasNext()
        final int numberIterations = 100000;

        // Create a RandomTimer of an exponential law
        try {
            double param = 0.0001;
            RandomTimer randomTimerEXP = new RandomTimer(RandomDistribution.EXP, param);
            int total = 0;
            Integer currentNext;

            for (int i = 0; i < numberIterations; i++) {

                currentNext = randomTimerEXP.next();

                // We check that this value is between the min and the max values it can go through
                assertTrue(randomTimerEXP.getLimitInferior() <= currentNext && currentNext <= randomTimerEXP.getLimitSuperior());

                // And we add this value to the sum
                total += currentNext;
            }

            // Here we check that the sum / numberIterations is nearly equal to the mean with a 1% risk
            assertEquals(randomTimerEXP.getMean(), (total * 1.0) / (numberIterations * 1.0), 1 * randomTimerEXP.getMean());
            
        } catch (IncorrectDistributionException e) {
            e.printStackTrace();
        }

        // Create a RandomTimer of a poisson law
        try {
            double param = 0.1;
            RandomTimer randomTimerPOISSON = new RandomTimer(RandomDistribution.POISSON, param);
            int total = 0;
            Integer currentNext;

            for (int i = 0; i < numberIterations; i++) {

                currentNext = randomTimerPOISSON.next();

                // We check that this value is between the min and the max values it can go through
                assertTrue(randomTimerPOISSON.getLimitInferior() <= currentNext && currentNext <= randomTimerPOISSON.getLimitSuperior());

                // And we add this value to the sum
                total += currentNext;
            }

            // Here we check that the sum / numberIterations is nearly equal to the mean with a 1% risk
            assertEquals(randomTimerPOISSON.getMean(), (total * 1.0) / (numberIterations * 1.0), 0.01);

        } catch (IncorrectDistributionException e) {
            e.printStackTrace();
        }

        // Create a RandomTimer of a gaussian law
        try {
            double limitInferior = -10000;
            double limitSuperior = 10000;
            RandomTimer randomTimerGAUSSIAN = new RandomTimer(RandomDistribution.GAUSSIAN, limitInferior, limitSuperior);

            int total = 0;
            Integer currentNext;

            for (int i = 0; i < numberIterations; i++) {

                currentNext = randomTimerGAUSSIAN.next();

                // Here we cannot test if the value is between two bounds as a gaussian value can be everywhere between Double.MIN_VALUE and Double.MAX_VALUE (negative infinity and positive infinity)

                // And we add this value to the sum
                total += currentNext;
            }



            // Here we check that the sum / numberIterations is nearly equal to the mean with a 1% risk
            assertEquals(randomTimerGAUSSIAN.getMean(), (total * 1.0) / (numberIterations * 1.0), 0.01 * randomTimerGAUSSIAN.getLimitSuperior());
        } catch (IncorrectDistributionException e) {
            e.printStackTrace();
        }

        // Create a RandomTimer of a uniform law
        try {
            double limitInferior = -100.0;
            double limitSuperior = 100.0;
            RandomTimer randomTimerUNIFORM = new RandomTimer(RandomDistribution.UNIFORM, limitInferior,limitSuperior);

            int total = 0;
            Integer currentNext;

            for (int i = 0; i < numberIterations; i++) {

                currentNext = randomTimerUNIFORM.next();

                // Here we cannot test if the value is between two bounds as a gaussian value can be everywhere between Double.MIN_VALUE and Double.MAX_VALUE (negative infinity and positive infinity)

                // And we add this value to the sum
                total += currentNext;
            }

            // Here we check that the sum / numberIterations is nearly equal to the mean with a 1% risk
            assertEquals(randomTimerUNIFORM.getMean(), (total * 1.0) / (numberIterations * 1.0), 0.01 * randomTimerUNIFORM.getLimitSuperior());

        } catch (IncorrectDistributionException e) {
            e.printStackTrace();
        }

    }

    // Test the toString() method
    @Test
    void testToString() {

        // Create a RandomTimer of an exponential law
        try {
            double param = 1.0;
            RandomTimer randomTimerEXP = new RandomTimer(RandomDistribution.EXP, param);

            // We need to get a rate of 1.0 (as this is an exponential law)
            assertEquals(randomTimerEXP.getDistributionName() + " rate: " + randomTimerEXP.getRate(), randomTimerEXP.toString());
        } catch (IncorrectDistributionException e) {
            e.printStackTrace();
        }

        // Create a RandomTimer of a poisson law
        try {
            double param = 1.0;
            RandomTimer randomTimerPOISSON = new RandomTimer(RandomDistribution.POISSON, param);

            // We need to get a mean of 1.0 (as this is a poisson law)
            assertEquals(randomTimerPOISSON.getDistributionName() + " mean: " + randomTimerPOISSON.getMean(), randomTimerPOISSON.toString());
        } catch (IncorrectDistributionException e) {
            e.printStackTrace();
        }

        // Create a RandomTimer of a gaussian law
        try {
            double limitInferior = -10000.0;
            double limitSuperior = 10000.0;
            RandomTimer randomTimerGAUSSIAN = new RandomTimer(RandomDistribution.GAUSSIAN, limitInferior,limitSuperior);

            // We need to get an inferior limit and a superior limit (as we got a gaussian law)
            assertEquals(randomTimerGAUSSIAN.getDistributionName() + " Inferior limit: " + randomTimerGAUSSIAN.getLimitInferior() + " Superior limit: " + randomTimerGAUSSIAN.getLimitSuperior(), randomTimerGAUSSIAN.toString());
        } catch (IncorrectDistributionException e) {
            e.printStackTrace();
        }

        // Create a RandomTimer of a uniform law
        try {
            double limitInferior = -1.0;
            double limitSuperior = 1.0;
            RandomTimer randomTimerUNIFORM = new RandomTimer(RandomDistribution.UNIFORM, limitInferior,limitSuperior);

            // We need to get an inferior limit and a superior limit (as we got a uniform law)
            assertEquals(randomTimerUNIFORM.getDistributionName() + " Inferior limit: " + randomTimerUNIFORM.getLimitInferior() + " Superior limit: " + randomTimerUNIFORM.getLimitSuperior(), randomTimerUNIFORM.toString());
        } catch (IncorrectDistributionException e) {
            e.printStackTrace();
        }
    }
    
    
}



/*

package test.timer;

import main.timer.RandomTimer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


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
        double param = 1.0;

        Exception thrown = assertThrows(Exception.class, () -> {
            RandomTimer randomTimerPOSIBILIST = new RandomTimer(RandomTimer.randomDistribution.POSIBILIST, param);

        });
        assertEquals("Bad Timer duhouhzhudou for selected distribution",thrown.getMessage());
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












*/