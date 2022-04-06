package test.timer;

import main.exceptions.UnexpectedTimerConstructorException;
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
    private double param3;
    double limitInferior2;
    double limitSuperior2;
    double limitInferior3;
    double limitSuperior3;


    @BeforeEach
    void setUp() throws UnexpectedTimerConstructorException {

        param = 1.0;
        randomTimerEXP = new RandomTimer(randomDistribution.EXP, param);
        randomTimerPOISSON = new RandomTimer(randomDistribution.POISSON, param);

        limitInferior = -1.0;
        limitSuperior = 1.0;
        randomTimerGAUSSIAN = new RandomTimer(randomDistribution.GAUSSIAN, limitInferior, limitSuperior);

        randomTimerUNIFORM = new RandomTimer(randomDistribution.POSIBILIST, limitInferior, limitSuperior);

        randomTimerEXP = new RandomTimer(randomDistribution.EXP, param);

        randomTimerPOISSON = new RandomTimer(randomDistribution.POISSON, param);

        randomTimerGAUSSIAN = new RandomTimer(randomDistribution.GAUSSIAN, limitInferior, limitSuperior);

        randomTimerUNIFORM = new RandomTimer(randomDistribution.POSIBILIST, limitInferior, limitSuperior);

        randomTimerUNIFORM = new RandomTimer(randomDistribution.POSIBILIST, limitInferior, limitSuperior);

        numberIterations = 100000;
        total = 0;
        param2 = 0.0001;
        param3 = 0.1;

        randomTimerPOISSON = new RandomTimer(randomDistribution.POISSON, param3);

        limitInferior2 = -10000;
        limitSuperior2 = 10000;

        randomTimerGAUSSIAN = new RandomTimer(randomDistribution.GAUSSIAN, limitInferior2, limitSuperior2);

        limitInferior3 = -100.0;
        limitSuperior3 = 100.0;

        randomTimerUNIFORM = new RandomTimer(randomDistribution.POSIBILIST, limitInferior, limitSuperior);
        randomTimerEXP = new RandomTimer(randomDistribution.EXP, param);
        randomTimerPOISSON = new RandomTimer(randomDistribution.POISSON, param);
        randomTimerGAUSSIAN = new RandomTimer(randomDistribution.GAUSSIAN, limitInferior2, limitSuperior2);


    }


    /*
        Entrée : RandomTimer(RandomDistribution.EXP, param)
        Description : Test du rate
        Résultat Attendu : "Not yet implemented"
     */
    @Test
    void RT1() {
        assertEquals("rate: " + randomTimerEXP.getRate(), randomTimerEXP.getDistributionParam());

    }

    /*
        Entrée : RandomTimer(RandomDistribution.POISSON, param)
        Description : Create a RandomTimer of a poisson law
        Résultat Attendu : True
    */
    @Test
    void RT2() {
        assertEquals("mean: " + randomTimerPOISSON.getMean(), randomTimerPOISSON.getDistributionParam());
    }

    /*
        Entrée : RandomTimer(RandomDistribution.GAUSSIAN, limitInferior,limitSuperior)
        Description : Teste d'un Random Timer avec une loi Gaussienne
        Résultat Attendu : "Not yet implemented"
    */
    @Test
    void RT3() {
        assertEquals("Inferior limit: " + randomTimerGAUSSIAN.getLimitInferior() + " Superior limit: " + randomTimerGAUSSIAN.getLimitSuperior(), randomTimerGAUSSIAN.getDistributionParam());
    }

    /*
        Entrée :  RandomTimer(RandomDistribution.UNIFORM, limitInferior,limitSuperior)
        Description : Teste d'un Random Timer avec une loi Uniforme
        Résultat Attendu : "Not yet implemented"
    */
    @Test
    void RT4() {

        assertEquals("Inferior limit: " + randomTimerUNIFORM.getLimitInferior() + " Superior limit: " + randomTimerUNIFORM.getLimitSuperior(), randomTimerUNIFORM.getDistributionParam());


    }

    /*
        Entrée : RandomTimer(RandomDistribution.EXP, param)
        Description : Test d'une moyenne exponentielle
        Résultat Attendu : True
    */
    @Test
    void RT5() {

        assertEquals(param, randomTimerEXP.getMean());

    }

    /*
        Entrée : RandomTimer(RandomDistribution.POISSON, param)
        Description : Test d'une moyenne de Poisson
        Résultat Attendu : True
    */
    @Test
    void RT6() {

        assertEquals(param, randomTimerPOISSON.getMean());


    }

    /*
        Entrée : RandomTimer(RandomDistribution.GAUSSIAN, limitInferior,limitSuperior)
        Description : Test d'une moyenne de Gaussienne
        Résultat Attendu : True
    */
    @Test
    void RT7() {

        assertEquals((limitSuperior + limitInferior) / 2.0, randomTimerGAUSSIAN.getMean());

    }

    /*
        Entrée : RandomTimer(RandomDistribution.UNIFORM, limitInferior,limitSuperior)
        Description : Test d'une moyenne Uniforme
        Résultat Attendu : True
    */
    @Test
    void RT8() {

        assertEquals((limitSuperior + limitInferior) / 2.0, randomTimerUNIFORM.getMean());

    }

    /*
        Entrée : RandomTimer(RandomDistribution.UNIFORM, 1)
        Description : Test Exception avec distribution uniforme avec mauvais arguments
        Résultat Attendu : IncorrectDistributionException
    */
    @Test
    void RT9() {
        assertThrows(Exception.class, () -> new RandomTimer(randomDistribution.POSIBILIST, 1));

    }


    /*
        Entrée : RandomTimer(RandomDistribution.EXP, -1, 1)
        Description : Test Exception avec ditribution exponentielle avec mauvais arguments
        Résultat Attendu : IncorrestDistributionException
    */
    @Test
    void RT10() {
        assertThrows(Exception.class, () -> new RandomTimer(randomDistribution.EXP, -1, 1));


    }

    /*
        Entrée : RandomTimer(RandomDistribution.UNIFORM, 1, -1)
        Description : Test limite inférieure > limite supérieure loi Uniforme
        Résultat Attendu : Exception to be thrown, but nothing was thrown.
    */
    @Test
    void RT11() {
        assertThrows(Exception.class, () -> new RandomTimer(randomDistribution.POSIBILIST, 1, -1));
    }

    /*
        Entrée : RandomTimer(RandomDistribution.EXP, param)
        Description : Test du fonctionnement de la distribution exponentielle, on simule 100000 expériences et on les compare à la moyenne (mean) avec un intervaale d'erreur de 1%
        On teste en même temps si la nextValue est entre inferiorLimit et superiorLimit
        Résultat Attendu : Not yet implemented
    */
    @Test
    void RT12() {

        for (int i = 0; i < numberIterations; i++) {
            currentNext = randomTimerEXP.next();

            assertTrue(randomTimerEXP.getLimitInferior() <= currentNext && currentNext <= randomTimerEXP.getLimitSuperior());

            total += currentNext;

            assertEquals(randomTimerEXP.getMean(), (total * 1.0) / (numberIterations * 1.0), 1 * randomTimerEXP.getMean());

        }
    }

    /*
        Entrée : RandomTimer(RandomDistribution.POISSON, param)
        Description : Idem avec une distribution de Poisson
        Résultat Attendu : Not yet implemented
    */
    @Test
    void RT13() {
        for (int i = 0; i < numberIterations; i++) {
            currentNext = randomTimerPOISSON.next();
            assertTrue(randomTimerPOISSON.getLimitInferior() <= currentNext && currentNext <= randomTimerPOISSON.getLimitSuperior());
            total += currentNext;
        }
        assertEquals(randomTimerPOISSON.getMean(), (total * 1.0) / (numberIterations * 1.0), 0.01);


    }

    /*
        Entrée : RandomTimer(RandomDistribution.GAUSSIAN, limitInferior, limitSuperior)
        Description : Idem avec une distribution normale (on n'effectue pas la comparaison car elle n'a aucun sens sur une loi normale, on compare des infinis)
        Résultat Attendu : "Not yet implemented"
    */
    @Test
    void RT14() {

        for (int i = 0; i < numberIterations; i++) {

            currentNext = randomTimerGAUSSIAN.next();
            total += currentNext;
        }
        assertEquals(randomTimerGAUSSIAN.getMean(), (total * 1.0) / (numberIterations * 1.0), 0.01 * randomTimerGAUSSIAN.getLimitSuperior());


    }

    /*
        Entrée : RandomTimer(RandomDistribution.UNIFORM, limitInferior,limitSuperior)
        Description : Idem avec une loi Uniforme
        Résultat Attendu : "Not yet implemented"
    */
    @Test
    void RT15() {

        for (int i = 0; i < numberIterations; i++) {

            currentNext = randomTimerUNIFORM.next();
            total += currentNext;
        }
        assertEquals(randomTimerUNIFORM.getMean(), (total * 1.0) / (numberIterations * 1.0), 0.01 * randomTimerUNIFORM.getLimitSuperior());


    }

    /*
        Entrée : RandomTimer(RandomDistribution.EXP, param)
        Description : Test de la méthode ToString sur une loi exponentielle
        Résultat Attendu : "Not yet implemented"
    */
    @Test
    void RT16() {
        assertEquals(randomTimerEXP.getDistribution() + " rate: " + randomTimerEXP.getRate(), randomTimerEXP.toString());


    }

    /*
        Entrée : RandomTimer(RandomDistribution.POISSON, param)
        Description : Test de la méthode ToString sur une loi de Poisson
        Résultat Attendu : True
    */
    @Test
    void RT17() {


        assertEquals(randomTimerPOISSON.getDistribution() + " mean:" + randomTimerPOISSON.getMean(), randomTimerPOISSON.toString());


    }

    /*
        Entrée : RandomTimer(RandomDistribution.GAUSSIAN, limitInferior,limitSuperior)
        Description : Test de la méthode ToString sur une loi normale
        Résultat Attendu : "Not yet implemented"
    */
    @Test
    void RT18() {
        assertEquals(randomTimerGAUSSIAN.getDistribution() + " Inferior limit: " + randomTimerGAUSSIAN.getLimitInferior() + " Superior limit: " + randomTimerGAUSSIAN.getLimitSuperior(), randomTimerGAUSSIAN.toString());
    }

    /*
        Entrée : RandomTimer(RandomDistribution.UNIFORM, limitInferior,limitSuperior)
        Description : Test de la méthode ToString sur une loi uniforme
        Résultat Attendu : "Not yet implemented"
    */
    @Test
    void RT19() {
        assertEquals(randomTimerUNIFORM.getDistribution() + " Inferior limit: " + randomTimerUNIFORM.getLimitInferior() + " Superior limit: " + randomTimerUNIFORM.getLimitSuperior(), randomTimerUNIFORM.toString());
    }
}