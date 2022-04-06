package timerTest;

import org.junit.jupiter.api.Test;

import timer.PeriodicTimer;
import timer.RandomTimer;
import java.util.Random;



import static org.junit.jupiter.api.Assertions.*;

class PeriodicTimerTest {

    @Test
    void getPeriod() {

        // Création de PeriodicTimer et récupération de leur période
    	
        PeriodicTimer periodicTimer1 = new PeriodicTimer(1);
        assertEquals(1, periodicTimer1.getPeriod());

        PeriodicTimer periodicTimer2 = new PeriodicTimer(1, 1);
        assertEquals(1, periodicTimer2.getPeriod());

        RandomTimer randomTimer = null;


        	randomTimer = new RandomTimer(RandomDistribution.EXP, 1.0);
        	
        	assertThrows(Exception.class, () -> {
                RandomTimer.next();
                RandomTimer.spendTime(-50);
            });
            
            } 
    	
    		
    
   catch (IncorrectDistributionException e) {
            e.printStackTrace();
        }
  
        PeriodicTimer periodicTimer3 = new PeriodicTimer(1, randomTimer);
        assertEquals(1, periodicTimer3.getPeriod());

        PeriodicTimer periodicTimer4 = new PeriodicTimer(1, 1, randomTimer);
        assertEquals(1, periodicTimer4.getPeriod());

        
        
        
        
    }

    

    
    
    
}


enum RandomDistribution {
    POISSON, EXP, UNIFORM, GAUSSIAN;
}