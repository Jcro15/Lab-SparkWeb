package edu.escuelaing.arep;

import edu.escuelaing.arep.Statistics.StatisticsModule;
import edu.escuelaing.arep.utilities.LinkedList;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    @Test
    public void shouldAdd()
    {
        LinkedList<Double> lkl = new LinkedList<>();
        Double[] values={1.0,2.0,3.0,4.0};
        boolean flag=false;
        for (Double value:values) {
            lkl.add(value);
            flag=(lkl.getTail().getValue().equals(value));
        }
        assertTrue(flag);
    }
    @Test
    public void shouldRemove() {
        LinkedList<Double> lkl = new LinkedList<>();
        Double[] values = {1.0, 2.0, 3.0, 4.0};
        for (Double value : values) {
            lkl.add(value);
        }
        lkl.remove(2.0);
        assertEquals(3.0, lkl.getHead().getNext().getValue(), 0.0);
        assertEquals(1.0, lkl.getHead().getNext().getPrev().getValue(), 0.0);
    }
    @Test
    public void shouldCreateEmptyLinkedList(){
        LinkedList<Double> lkl=new LinkedList<>();
        assertEquals(0, lkl.size());
        assertNull(lkl.getHead());
        assertNull(lkl.getTail());
    }
    @Test
    public void shouldCalculateMean(){
        LinkedList<Double> lkl = new LinkedList<>();
        LinkedList<Double> lkl2 = new LinkedList<>();
        Double[] case1 = {160.0, 591.0, 114.0, 229.0, 230.0, 270.0, 128.0, 1657.0, 624.0, 1503.0};
        Double[] case2={15.0, 69.9, 6.5, 22.4, 28.4, 65.9, 19.4, 198.7, 38.8, 138.2};
        for (Double value : case1) {
            lkl.add(value);
        }
        for (Double value : case2) {
            lkl2.add(value);
        }
        assertEquals((Double) 550.6, StatisticsModule.mean(lkl));
        assertEquals((Double) 60.32, StatisticsModule.mean(lkl2));
    }

    @Test
    public void shouldCalculateStandardDeviation(){
        LinkedList<Double> lkl = new LinkedList<>();
        LinkedList<Double> lkl2 = new LinkedList<>();
        Double[] case1 = {160.0, 591.0, 114.0, 229.0, 230.0, 270.0, 128.0, 1657.0, 624.0, 1503.0};
        Double[] case2={15.0, 69.9, 6.5, 22.4, 28.4, 65.9, 19.4, 198.7, 38.8, 138.2};
        for (Double value : case1) {
            lkl.add(value);
        }
        for (Double value : case2) {
            lkl2.add(value);
        }
        assertEquals((Double) 572.03, StatisticsModule.standardDeviation(lkl));
        assertEquals((Double) 62.26, StatisticsModule.standardDeviation(lkl2));
    }
}
