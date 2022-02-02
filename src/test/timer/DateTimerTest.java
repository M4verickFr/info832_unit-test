package test.timer;

import main.timer.DateTimer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.TreeSet;
import java.util.Vector;

class DateTimerTest {
private Vector<Integer> lapsTimes;
private Iterator<Integer> it;
private TreeSet<Integer> dates;

    @BeforeEach
    void setUp() {
        Vector<Integer> lapsTimes;

        Iterator<Integer> it;
        TreeSet<Integer> dates = new TreeSet<Integer>();



    }

    @Test
    void DT1_constructor(){
        /*
        Entrée :
    Description :
Résultat attendu :
         */
        dates.add(1);
        dates.add(2);
        dates.add(3);
        dates.add(5);




// Test création avec arbre
        DateTimer timer = new DateTimer(lapsTimes);


// Test création avec vecteur



    }
    @Test
    void hasNext() {
    }

    @Test
    void next() {
    }
}