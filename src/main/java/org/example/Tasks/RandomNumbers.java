package org.example.Tasks;

import java.util.ArrayList;
import java.util.Random;

public class RandomNumbers {
    public static Integer getRandom(ArrayList<Integer> arr) {
        Random rand = new Random();
        return arr.get(rand.nextInt(arr.size()));
    }

    public static int getRandom(int[] arr) {
        Random rand = new Random();
        return arr[rand.nextInt(arr.length)];
    }
}
