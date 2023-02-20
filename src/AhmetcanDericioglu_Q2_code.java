import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


// Author: Ahmetcan Dericioglu

public class AhmetcanDericioglu_Q2_code {

    static void quickSort(int[] arr, int low, int high)
    {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high)
    {
        int pivot = arr[low];   // choose the lowest value for pivot
        int pivotLoc = low;
        int i = low, j = high;

        while (true) {
            while (arr[j] > pivot)
            {
                j--;    //decrease until find a value that lower than pivot
            }
            int temp = arr[pivotLoc];   //swap the pivot and number that lower than it
            arr[pivotLoc] = arr[j];
            arr[j] = temp;
            pivotLoc = j;


            while (arr[i] < pivot)
            {
                i++;    //increase until find a value that greater than pivot
            }

            int temp2 = arr[pivotLoc];  // swap the pivot and number that greater than pivot
            arr[pivotLoc] = arr[i];
            arr[i] = temp2;
            pivotLoc = i;


            if (i >= j)
                return pivotLoc;
        }
    }

    static void displayArray(int[] array){
        System.out.print("Array: ");
        for (int i: array){
            System.out.print(i + " ");
        }
    }
    static void shuffleArray(int[] ar) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    public static void main(String[] args) {
        // you can try this for 10k, 20k, 30k, ... arrays
        /*
        int[] array = new int[1000000];
        for (int i = 0;i< array.length; i++){
            array[i] = i;
        }
        shuffleArray(array);

        Instant start = Instant.now();
        quickSort(array, 0 , array.length-1);
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);

        System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds"); */

        int [] array = {3,0,1,8,7,2,5,4,9,6};
        displayArray(array);
        quickSort(array,0, array.length-1);
        System.out.println();
        displayArray(array);

    }
}
