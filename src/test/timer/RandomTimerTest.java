package test.timer;

import main.timer.RandomTimer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.timer.RandomTimer.randomDistribution;

import static org.junit.jupiter.api.Assertions.*;


class RandomTimerTest {

    private RandomTimer randomTimerEXP;
    private double param;
    private RandomTimer randomTimerPOISSON;
    private double limitInferior;
    private double limitSuperior;
    private RandomTimer randomTimerGAUSSIAN;
    private RandomTimer randomTimerUNIFORM;

    private int numberIterations;
    private int total;
    private Integer currentNext;

    private double param2;



    @BeforeEach
    void setUp() {

        param = 1.0;
        randomTimerEXP = new RandomTimer(randomDistribution.EXP, param);
        randomTimerPOISSON = new RandomTimer(randomDistribution.POISSON, param);

        limitInferior = -1.0;
        limitSuperior = 1.0;
        randomTimerGAUSSIAN = new RandomTimer(randomDistribution.GAUSSIAN, limitInferior, limitSuperior);

        randomTimerUNIFORM = new RandomTimer(randomDistribution.POSIBILIST, limitInferior, limitSuperior);

        randomTimerEXP = new RandomTimer(randomDistribution.EXP, param);

        randomTimerPOISSON = new RandomTimer(randomDistribution.POISSON, param);

        randomTimerGAUSSIAN = new RandomTimer(randomDistribution.GAUSSIAN, limitInferior,limitSuperior);

        randomTimerUNIFORM = new RandomTimer(randomDistribution.POSIBILIST, limitInferior,limitSuperior);

        randomTimerUNIFORM = new RandomTimer(randomDistribution.POSIBILIST, limitInferior,limitSuperior);

        numberIterations = 100000;
        total = 0;
        param2 = 0.0001;




    }


    /*
Entrée : RandomTimer(RandomDistribution.EXP, param)
Description : Test du rate
Résultat Attendu : True
 */
    @Test
    void RT1() {
        try {
            assertEquals("rate: " + randomTimerEXP.getRate(), randomTimerEXP.getDistributionParams());
        } catch (IncorrectDistributionException e) {
            e.printStackTrace();
        }
    }


    /*
Entrée : RandomTimer(RandomDistribution.POISSON, param)
Description : Create a RandomTimer of a poisson law
Résultat Attendu : True
 */
    @Test
    void RT2() {
        try {
            assertEquals("mean: " + randomTimerPOISSON.getMean(), randomTimerPOISSON.getDistributionParams());
        } catch (IncorrectDistributionException e) {
            e.printStackTrace();
        }
    }

    /*
Entrée : RandomTimer(RandomDistribution.GAUSSIAN, limitInferior,limitSuperior)
Description : Teste d'un Random Timer avec une loi Gaussienne
Résultat Attendu : True
*/
    @Test
    void RT3() {
        try {
            assertEquals("Inferior limit: " + randomTimerGAUSSIAN.getLimitInferior() + " Superior limit: " + randomTimerGAUSSIAN.getLimitSuperior(), randomTimerGAUSSIAN.getDistributionParams());
        } catch (IncorrectDistributionException e) {
            e.printStackTrace();
        }
    }

    /*
Entrée :  RandomTimer(RandomDistribution.UNIFORM, limitInferior,limitSuperior)
Description : Teste d'un Random Timer avec une loi Uniforme
Résultat Attendu : True
*/
    @Test
    void RT4() {
        try {
            // We need to get an inferior limit and a superior limit (as we got a uniform law)
            assertEquals("Inferior limit: " + randomTimerUNIFORM.getLimitInferior() + " Superior limit: " + randomTimerUNIFORM.getLimitSuperior(), randomTimerUNIFORM.getDistributionParams());
        } catch (IncorrectDistributionException e) {
            e.printStackTrace();
        }
    }

    /*
Entrée : RandomTimer(RandomDistribution.EXP, param)
Description : Test d'une moyenne exponentielle
Résultat Attendu : True
*/
    @Test
    void RT5() {
        try {
            assertEquals(param, randomTimerEXP.getMean());
        } catch (IncorrectDistributionException e) {
            e.printStackTrace();
        }

    }

    /*
Entrée : RandomTimer(RandomDistribution.POISSON, param)
Description : Test d'une moyenne de Poisson
Résultat Attendu : True
*/
    @Test
    void RT6() {
        try {
            assertEquals(param, randomTimerPOISSON.getMean());
        } catch (IncorrectDistributionException e) {
            e.printStackTrace();
        }

    }

    /*
Entrée : RandomTimer(RandomDistribution.GAUSSIAN, limitInferior,limitSuperior)
Description : Test d'une moyenne de Gaussienne
Résultat Attendu : True
*/
    @Test
    void RT7() {
        try {
            assertEquals((limitSuperior + limitInferior) / 2.0, randomTimerGAUSSIAN.getMean());
        } catch (IncorrectDistributionException e) {
            e.printStackTrace();
        }

    }

    /*
Entrée : RandomTimer(RandomDistribution.UNIFORM, limitInferior,limitSuperior)
Description : Test d'une moyenne Uniforme
Résultat Attendu : True
*/
    @Test
    void RT8() {
        try {
            assertEquals((limitSuperior + limitInferior) / 2.0, randomTimerUNIFORM.getMean());
        } catch (IncorrectDistributionException e) {
            e.printStackTrace();
        }
    }

    /*
Entrée : RandomTimer(RandomDistribution.UNIFORM, 1)
Description : Test Exception avec distribution uniforme avec mauvais arguments
Résultat Attendu : IncorrectDistributionException
*/
    @Test
    void RT9() {
        assertThrows(IncorrectDistributionException.class, () -> new RandomTimer(RandomDistribution.UNIFORM, 1));

    }






            /*
Entrée : RandomTimer(RandomDistribution.EXP, -1, 1)
Description : Test Exception avec ditribution exponentielle avec mauvais arguments
Résultat Attendu : IncorrestDistributionException
*/
@Test
    void RT10() {
    assertThrows(IncorrectDistributionException.class, () -> new RandomTimer(RandomDistribution.EXP, -1, 1));


}

            /*
Entrée : RandomTimer(RandomDistribution.UNIFORM, 1, -1)
Description : Test limite inférieure > limite supérieure loi Uniforme
Résultat Attendu : IncorrectDistributionException
*/
@Test
    void RT11() {
            assertThrows(IncorrectDistributionException.class, () -> new RandomTimer(RandomDistribution.UNIFORM, 1, -1));
            }

            /*
Entrée : RandomTimer(RandomDistribution.EXP, param)
Description : Test du fonctionnement de la distribution exponentielle, on simule 100000 expériences et on les compare à la moyenne (mean) avec un intervaale d'erreur de 1%
On teste en même temps si la nextValue est entre inferiorLimit et superiorLimit
Résultat Attendu : True, True
*/
@Test
    void RT12() {
            try {
            RandomTimer randomTimerEXP = new RandomTimer(RandomDistribution.EXP, param);
            for (int i = 0; i < numberIterations; i++) {
        currentNext = randomTimerEXP.next();
        // si la valeur est entre la limite inférieure et la limite supérieure
        assertTrue(randomTimerEXP.getLimitInferior() <= currentNext && currentNext <= randomTimerEXP.getLimitSuperior());

        total += currentNext;
        }

        // Comparaison à la moyenne
        assertEquals(randomTimerEXP.getMean(), (total * 1.0) / (numberIterations * 1.0), 1 * randomTimerEXP.getMean());

        } catch (IncorrectDistributionException e) {
        e.printStackTrace();
        }
            }

/*
Entrée : RandomTimer(RandomDistribution.POISSON, param)
Description : Idem avec une distribution de Poisson
Résultat Attendu : True, True
*/
@Test
    void RT13() {
            try {
            double param = 0.1;
            RandomTimer randomTimerPOISSON = new RandomTimer(RandomDistribution.POISSON, param);
            int total = 0;
            Integer currentNext;

            for (int i = 0; i < numberIterations; i++) {
        currentNext = randomTimerPOISSON.next();
        assertTrue(randomTimerPOISSON.getLimitInferior() <= currentNext && currentNext <= randomTimerPOISSON.getLimitSuperior());
        total += currentNext;
        }
        assertEquals(randomTimerPOISSON.getMean(), (total * 1.0) / (numberIterations * 1.0), 0.01);
        } catch (IncorrectDistributionException e) {
        e.printStackTrace();
        }


        }

/*
            Entrée : RandomTimer(RandomDistribution.GAUSSIAN, limitInferior, limitSuperior)
            Description : Idem avec une distribution normale (on n'effectue pas la comparaison car elle n'a aucun sens sur une loi normale, on compare des infinis)
            Résultat Attendu : True
            */
@Test
    void RT14() {
     try {
            double limitInferior = -10000;
            double limitSuperior = 10000;
            RandomTimer randomTimerGAUSSIAN = new RandomTimer(RandomDistribution.GAUSSIAN, limitInferior, limitSuperior);

            int total = 0;
            Integer currentNext;

            for (int i = 0; i < numberIterations; i++) {

        currentNext = randomTimerGAUSSIAN.next();
        total += currentNext;
        }
            assertEquals(randomTimerGAUSSIAN.getMean(), (total * 1.0) / (numberIterations * 1.0), 0.01 * randomTimerGAUSSIAN.getLimitSuperior());
        } catch (IncorrectDistributionException e) {
        e.printStackTrace();
        }

            }
            /*
            Entrée : RandomTimer(RandomDistribution.UNIFORM, limitInferior,limitSuperior)
            Description : Idem avec une loi Uniforme
            Résultat Attendu : True
            */
@Test
    void RT15() {
            try {
            double limitInferior = -100.0;
            double limitSuperior = 100.0;
            RandomTimer randomTimerUNIFORM = new RandomTimer(RandomDistribution.UNIFORM, limitInferior,limitSuperior);

            int total = 0;
            Integer currentNext;

            for (int i = 0; i < numberIterations; i++) {

        currentNext = randomTimerUNIFORM.next();
        total += currentNext;
        }
            assertEquals(randomTimerUNIFORM.getMean(), (total * 1.0) / (numberIterations * 1.0), 0.01 * randomTimerUNIFORM.getLimitSuperior());

        } catch (IncorrectDistributionException e) {
        e.printStackTrace();
        }


        }
        /*
            Entrée : RandomTimer(RandomDistribution.EXP, param)
            Description : Test de la méthode ToString sur une loi exponentielle
            Résultat Attendu : True
            */
@Test
    void RT16() {
            try {
            double param = 1.0;
            RandomTimer randomTimerEXP = new RandomTimer(RandomDistribution.EXP, param);
            assertEquals(randomTimerEXP.getDistributionName() + " rate: " + randomTimerEXP.getRate(), randomTimerEXP.toString());
            } catch (IncorrectDistributionException e) {
            e.printStackTrace();
            }

            }

                    /*
            Entrée : RandomTimer(RandomDistribution.POISSON, param)
            Description : Test de la méthode ToString sur une loi de Poisson
            Résultat Attendu : True
            */
@Test
    void RT17() {
     try {
            double param = 1.0;
            RandomTimer randomTimerPOISSON = new RandomTimer(RandomDistribution.POISSON, param);
            assertEquals(randomTimerPOISSON.getDistributionName() + " mean: " + randomTimerPOISSON.getMean(), randomTimerPOISSON.toString());
            } catch (IncorrectDistributionException e) {
            e.printStackTrace();
            }

            }
                    /*
            Entrée : RandomTimer(RandomDistribution.GAUSSIAN, limitInferior,limitSuperior)
            Description : Test de la méthode ToString sur une loi normale
            Résultat Attendu :True
            */
@Test
    void RT18() {
            try {
            double limitInferior = -10000.0;
            double limitSuperior = 10000.0;
            RandomTimer randomTimerGAUSSIAN = new RandomTimer(RandomDistribution.GAUSSIAN, limitInferior,limitSuperior);

            assertEquals(randomTimerGAUSSIAN.getDistributionName() + " Inferior limit: " + randomTimerGAUSSIAN.getLimitInferior() + " Superior limit: " + randomTimerGAUSSIAN.getLimitSuperior(), randomTimerGAUSSIAN.toString());
            } catch (IncorrectDistributionException e) {
            e.printStackTrace();
            }

            }
                    /*
            Entrée : RandomTimer(RandomDistribution.UNIFORM, limitInferior,limitSuperior)
            Description : Test de la méthode ToString sur une loi uniforme
            Résultat Attendu : True
            */
@Test
    void RT19() {
            try {
            double limitInferior = -1.0;
            double limitSuperior = 1.0;
            RandomTimer randomTimerUNIFORM = new RandomTimer(RandomDistribution.UNIFORM, limitInferior,limitSuperior);
            assertEquals(randomTimerUNIFORM.getDistributionName() + " Inferior limit: " + randomTimerUNIFORM.getLimitInferior() + " Superior limit: " + randomTimerUNIFORM.getLimitSuperior(), randomTimerUNIFORM.toString());
            } catch (IncorrectDistributionException e) {
            e.printStackTrace();
            }

            }




       

}
    








