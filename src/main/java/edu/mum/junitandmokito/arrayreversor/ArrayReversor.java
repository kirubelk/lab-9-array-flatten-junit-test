package edu.mum.junitandmokito.arrayreversor;

public class ArrayReversor {

    ArrayFlattenerService service;

    public ArrayReversor(ArrayFlattenerService service) {
        this.service = service;
    }


    public int[] reverseArray(int[][] a_in) {
        if(a_in==null){
            return null;
        }

        int[] flattend = service.flattenArray(a_in);
        int[] reversed = reversedArray(flattend);

        return reversed;
    }

    private int[] reversedArray(int[] arr) {
        int[] reversedArray = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            reversedArray[i] = arr[arr.length - 1 - i];
        }

        return reversedArray;
    }


}
