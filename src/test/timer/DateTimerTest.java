package test.timer;

import main.timer.DateTimer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.TreeSet;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;




class DateTimerTest {
private Vector<Integer> lapsTimes;
private Iterator<Integer> it;
private TreeSet<Integer> dates = new TreeSet<Integer>();

    @BeforeEach
    void setUp() {
        Vector<Integer> lapsTimes;

        Iterator<Integer> it;



    }

    /*
    Entrée : dates = [1,2,3,5]
    Description : test création constructeur avec TreeSet
    Résultat attendu : Objet DateTimer
     */
    @Test
    void DT1_constructor(){


        dates.add(1);
        dates.add(2);
        dates.add(3);
        dates.add(5);

// Test création avec arbre
        DateTimer timer1 = new DateTimer(dates);
        assertNotNull(dates);
        assertNotNull(timer1);

// Test création avec vecteur
        DateTimer timer2 = new DateTimer(lapsTimes);



    }
    @Test
    void hasNext() {
    /*
    Entrée :[1,2,3,5]
    Description : test pour connaître prochain iterator
    Résultat attendu : Not null
     */

    }

    @Test
    void next() {
    }
}