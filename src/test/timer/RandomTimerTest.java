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
    private RandomTimer randomNull;

    private int numberIterations;
    private int total;
    private Integer currentNext;

    private String distributionNull;
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
        Entr??e : RandomTimer(RandomDistribution.EXP, param)
        Description : Test du rate
        R??sultat Attendu : "Not yet implemented"
     */
    @Test
    void RT1_Rate() {
        assertEquals("rate: " + randomTimerEXP.getRate(), randomTimerEXP.getDistributionParam());

    }

    /*
        Entr??e : RandomTimer(RandomDistribution.POISSON, param)
        Description : Create a RandomTimer of a poisson law
        R??sultat Attendu : True
    */
    @Test
    void RT2_Poisson() {
        assertEquals("mean: " + randomTimerPOISSON.getMean(), randomTimerPOISSON.getDistributionParam());
    }

    /*
        Entr??e : RandomTimer(RandomDistribution.GAUSSIAN, limitInferior,limitSuperior)
        Description : Teste d'un Random Timer avec une loi Gaussienne
        R??sultat Attendu : "Not yet implemented"
    */
    @Test
    void RT3_Gauss() {
        assertEquals("Inferior limit: " + randomTimerGAUSSIAN.getLimitInferior() + " Superior limit: " + randomTimerGAUSSIAN.getLimitSuperior(), randomTimerGAUSSIAN.getDistributionParam());
    }

    /*
        Entr??e :  RandomTimer(RandomDistribution.UNIFORM, limitInferior,limitSuperior)
        Description : Teste d'un Random Timer avec une loi Uniforme
        R??sultat Attendu : "Not yet implemented"
    */
    @Test
    void RT4_Uniforme() {

        assertEquals("Inferior limit: " + randomTimerUNIFORM.getLimitInferior() + " Superior limit: " + randomTimerUNIFORM.getLimitSuperior(), randomTimerUNIFORM.getDistributionParam());


    }

    /*
        Entr??e : RandomTimer(RandomDistribution.EXP, param)
        Description : Test d'une moyenne exponentielle
        R??sultat Attendu : True
    */
    @Test
    void RT5_ExpMean() {

        assertEquals(param, randomTimerEXP.getMean());

    }

    /*
        Entr??e : RandomTimer(RandomDistribution.POISSON, param)
        Description : Test d'une moyenne de Poisson
        R??sultat Attendu : True
    */
    @Test
    void RT6_PoissonMean() {

        assertEquals(param, randomTimerPOISSON.getMean());


    }

    /*
        Entr??e : RandomTimer(RandomDistribution.GAUSSIAN, limitInferior,limitSuperior)
        Description : Test d'une moyenne de Gaussienne
        R??sultat Attendu : True
    */
    @Test
    void RT7_GaussMean() {

        assertEquals((limitSuperior + limitInferior) / 2.0, randomTimerGAUSSIAN.getMean());

    }

    /*
        Entr??e : RandomTimer(RandomDistribution.UNIFORM, limitInferior,limitSuperior)
        Description : Test d'une moyenne Uniforme
        R??sultat Attendu : True
    */
    @Test
    void RT8_UniformeMean() {

        assertEquals((limitSuperior + limitInferior) / 2.0, randomTimerUNIFORM.getMean());

    }

    /*
        Entr??e : RandomTimer(RandomDistribution.UNIFORM, 1)
        Description : Test Exception avec distribution uniforme avec mauvais arguments
        R??sultat Attendu : IncorrectDistributionException
    */
    @Test
    void RT9_UniformWrongArg() {
        assertThrows(Exception.class, () -> new RandomTimer(randomDistribution.POSIBILIST, 1));

    }


    /*
        Entr??e : RandomTimer(RandomDistribution.EXP, -1, 1)
        Description : Test Exception avec ditribution exponentielle avec mauvais arguments
        R??sultat Attendu : IncorrestDistributionException
    */
    @Test
    void RT10_ExpWrongArg() {
        assertThrows(Exception.class, () -> new RandomTimer(randomDistribution.EXP, -1, 1));


    }

    /*
        Entr??e : RandomTimer(RandomDistribution.UNIFORM, 1, -1)
        Description : Test limite inf??rieure > limite sup??rieure loi Uniforme
        R??sultat Attendu : Exception to be thrown, but nothing was thrown.
    */
    @Test
    void RT11_ExpWrongArg() {
        assertThrows(Exception.class, () -> new RandomTimer(randomDistribution.POSIBILIST, 1, -1));
    }

    /*
        Entr??e : RandomTimer(RandomDistribution.EXP, param)
        Description : Test du fonctionnement de la distribution exponentielle, on simule 100000 exp??riences et on les compare ?? la moyenne (mean) avec un intervaale d'erreur de 1%
        On teste en m??me temps si la nextValue est entre inferiorLimit et superiorLimit
        R??sultat Attendu : Not yet implemented
    */
    @Test
    void RT12_Exp() {

        for (int i = 0; i < numberIterations; i++) {
            currentNext = randomTimerEXP.next();

            assertTrue(randomTimerEXP.getLimitInferior() <= currentNext && currentNext <= randomTimerEXP.getLimitSuperior());

            total += currentNext;

            assertEquals(randomTimerEXP.getMean(), (total * 1.0) / (numberIterations * 1.0), 1 * randomTimerEXP.getMean());

        }
    }

    /*
        Entr??e : RandomTimer(RandomDistribution.POISSON, param)
        Description : Idem avec une distribution de Poisson
        R??sultat Attendu : Not yet implemented
    */
    @Test
    void RT13_Poisson() {
        for (int i = 0; i < numberIterations; i++) {
            currentNext = randomTimerPOISSON.next();
            assertTrue(randomTimerPOISSON.getLimitInferior() <= currentNext && currentNext <= randomTimerPOISSON.getLimitSuperior());
            total += currentNext;
        }
        assertEquals(randomTimerPOISSON.getMean(), (total * 1.0) / (numberIterations * 1.0), 0.01);


    }

    /*
        Entr??e : RandomTimer(RandomDistribution.GAUSSIAN, limitInferior, limitSuperior)
        Description : Idem avec une distribution normale (on n'effectue pas la comparaison car elle n'a aucun sens sur une loi normale, on compare des infinis)
        R??sultat Attendu : "Not yet implemented"
    */
    @Test
    void RT14_Gauss() {

        for (int i = 0; i < numberIterations; i++) {

            currentNext = randomTimerGAUSSIAN.next();
            total += currentNext;
        }
        assertEquals(randomTimerGAUSSIAN.getMean(), (total * 1.0) / (numberIterations * 1.0), 0.01 * randomTimerGAUSSIAN.getLimitSuperior());


    }

    /*
        Entr??e : RandomTimer(RandomDistribution.UNIFORM, limitInferior,limitSuperior)
        Description : Idem avec une loi Uniforme
        R??sultat Attendu : "Not yet implemented"
    */
    @Test
    void RT15_Uniform() {

        for (int i = 0; i < numberIterations; i++) {

            currentNext = randomTimerUNIFORM.next();
            total += currentNext;
        }
        assertEquals(randomTimerUNIFORM.getMean(), (total * 1.0) / (numberIterations * 1.0), 0.01 * randomTimerUNIFORM.getLimitSuperior());


    }

    /*
        Entr??e : RandomTimer(RandomDistribution.EXP, param)
        Description : Test de la m??thode ToString sur une loi exponentielle
        R??sultat Attendu : "Not yet implemented"
    */
    @Test
    void RT16_ExpToString() {
        assertEquals(randomTimerEXP.getDistribution() + " rate: " + randomTimerEXP.getRate(), randomTimerEXP.toString());


    }

    /*
        Entr??e : RandomTimer(RandomDistribution.POISSON, param)
        Description : Test de la m??thode ToString sur une loi de Poisson
        R??sultat Attendu : True
    */
    @Test
    void RT17_PoissonToString() {


        assertEquals(randomTimerPOISSON.getDistribution() + " mean:" + randomTimerPOISSON.getMean(), randomTimerPOISSON.toString());


    }

    /*
        Entr??e : RandomTimer(RandomDistribution.GAUSSIAN, limitInferior,limitSuperior)
        Description : Test de la m??thode ToString sur une loi normale
        R??sultat Attendu : "Not yet implemented"
    */
    @Test
    void RT18_GaussToString() {
        assertEquals(randomTimerGAUSSIAN.getDistribution() + " Inferior limit: " + randomTimerGAUSSIAN.getLimitInferior() + " Superior limit: " + randomTimerGAUSSIAN.getLimitSuperior(), randomTimerGAUSSIAN.toString());
    }

    /*
        Entr??e : RandomTimer(RandomDistribution.UNIFORM, limitInferior,limitSuperior)
        Description : Test de la m??thode ToString sur une loi uniforme
        R??sultat Attendu : "Not yet implemented"
    */
    @Test
    void RT19_UniformToString() {
        assertEquals(randomTimerUNIFORM.toString(), randomTimerUNIFORM.getDistribution() + " Inferior limit: " + randomTimerUNIFORM.getLimitInferior() + " Superior limit: " + randomTimerUNIFORM.getLimitSuperior());
    }

    /*
        Entr??e :
        Description :
        R??sultat Attendu :
    */
    @Test
    void RT20_string2Distribution() {
        assertEquals("EXP", randomTimerEXP.getDistribution());
    }


    /*
        Entr??e :
        Description :
        R??sultat Attendu :
    */
    @Test
    void RT21_getDistributionParamEXP() {
        assertEquals(randomTimerEXP.getDistributionParam(),"rate: " + param);
    }

    /*
        Entr??e :
        Description :
        R??sultat Attendu :
    */
    @Test
    void RT22_getDistributionParamPOSIBILIST() {
        assertEquals(randomTimerUNIFORM.getDistributionParam(),"lolim: " + limitInferior + " hilim: " + limitSuperior);
    }


    /*
        Entr??e :
        Description :
        R??sultat Attendu :
    */
    @Test
    void RT23_getDistributionParamGAUSSIAN() {
        assertEquals(randomTimerGAUSSIAN.getDistributionParam(),"lolim: " + limitInferior2 + " hilim: " + limitSuperior2);
    }


    /*
        Entr??e :
        Description :
        R??sultat Attendu : IMPOSSIBLE A TESTER, IL FAUT RAJOUTER DANS LE CODE la possibilit?? de cr??er une randomDistribution, on ne peut pas cr??er de distribution autre que EXP, POSIBILIST, GAUSSIAN et POISSON donc on peut pas tester pour les cas autres que ceux-co
    */
    @Test
    void RT24_getDistributionParamNULL() {


    }

    /*
        Entr??e :
        Description :
        R??sultat Attendu :
    */
    @Test
    void RT25_toStringPOSIBILIST() {
        assertEquals(randomTimerGAUSSIAN.getDistributionParam(),"lolim: " + limitInferior2 + " hilim: " + limitSuperior2);
    }


}