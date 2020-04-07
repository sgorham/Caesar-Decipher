package com.company;
//Sean Gorham 2020

public class Cipher {
    private double[] probabilities = {0.07984,0.01511,0.02504,0.04260,0.12452,0.02262,0.02013
    ,0.06384,0.07,0.00131,0.00741,0.03961,0.02629,0.06876,0.07691,0.01741,0.00107,0.05912,0.06333,
    0.09058,0.02844,0.01056,0.02304,0.00159,0.02028,0.00057};

    public String caesarCipher(String cipherMessage){
        double[] alphaCount = new double[26];
        frequency(cipherMessage, alphaCount);
        int key = findMax(cipherMessage, alphaCount);
        return transform(key, cipherMessage);
    }

    public int findMax(String message, double[] array){
        double max = -Double.MAX_VALUE;
        int key = Integer.MIN_VALUE;

        for(int j = 0; j < array.length;j++) {
            double sum = 0;
            for (int i = 0; i < message.length(); i++) {
                int index = (message.charAt(i) - 65) - j;
                if(index < 0){
                    int temp = 25 + index;
                    index = temp;
                }
                sum += array[message.charAt(i) - 65] * probabilities[index];

            }
            if(sum > max){
                max = sum;
                key = j;
            }
        }
        return key;
    }

    public void frequency(String message, double[] alphaCount){
        message.toUpperCase();
        for(int i = 0; i < message.length(); i++){
            int character = (int) message.charAt(i);
            int ascii = character - 65;
            alphaCount[ascii] += 1;
        }
        for(int i = 0; i < alphaCount.length; i++){
            alphaCount[i] = alphaCount[i] / message.length();
        }
    }

    public String transform(int key, String message){
        message.toUpperCase();
        StringBuilder tran = new StringBuilder(message);
        for(int i = 0; i < message.length(); i++){
            int letter = message.charAt(i);
            letter = letter - key;
            if(letter < 65){
                int temp = 90 - (65 - letter - 1);
                letter = temp;
            }
            tran.setCharAt(i, (char) letter);
        }
        return  tran.toString();
    }
}
