package edu.mum.junitandmokito.arrayreversor;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ArrayReversorTest {

    private ArrayFlattenerService arrayFlattenerService= Mockito.mock(ArrayFlattenerService.class);
    private ArrayReversor arrayReversor=new ArrayReversor(arrayFlattenerService);

    @Test
    public void reverseArrayHappySecenario() {
        int[][] a_in={{1, 3}, {0}, {4, 5, 9}};
        int[] flatArray={1,3,0,4,5,9};
        int[] expected = {9,5,4,0,3,1};

        when(arrayFlattenerService.flattenArray(a_in)).thenReturn(flatArray);
        int[] reverseArray=arrayReversor.reverseArray(a_in);

        verify(arrayFlattenerService, times(1)).flattenArray(a_in);
        assertArrayEquals(expected, reverseArray);

    }

    @Test
    public void nullInput() {
        int[][] a_in=null;
        int[] expected = null;

        when(arrayFlattenerService.flattenArray(a_in)).thenReturn(null);
        int[] reverseArray=arrayReversor.reverseArray(a_in);

        assertArrayEquals(expected, reverseArray);

    }



}