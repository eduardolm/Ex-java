package TestesHelper;

import java.util.Calendar;
import java.util.Random;

public class Program {

    public static void main(String[] args) {

        System.out.println(Calendar.JANUARY);

        Random random = new Random();
        random.setSeed(2995202011L);
        for (int i = 0; i < 100; i++) {
            System.out.println((int)(Math.random() * (9999999 - (-9999999) + 1) + (-9999999)));
        }

        int id = 2154;
        int month = 12;
        var quantity = Integer.parseInt(String.valueOf(id).substring(0, 1)) * month;

        int[] x = getTransactionValue(id, quantity);
        System.out.println();
        for (int item : x) {
            System.out.println("Valor: " + item);
        }

        System.out.println();
        var boo = testing(3);

        for (String a : boo) {
            System.out.println(a);
        }


        System.out.println();
        int[] anos = new int[] {2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013,
        2014, 2015, 2016, 2017, 2018, 2019, 2020, 2010};
        for (int ano : anos) {
            System.out.println(isLeapYear(ano));
        }
    }

    public static String[] testing(int quantity) {

        String[] consonants = new String[] {"b", "c", "d", "f", "g", "h", "nh", "lh", "ch", "j",
                "k", "l", "m", "n", "p", "qu", "r", "rr", "s", "ss", "t", "v", "w", "x", "y", "z"};
        String[] vowels = new String[] {"a", "e", "i", "o", "u"};
        String vowel = "";
        String consonant = "";
        String sylable = "";
        int length = 5;
        String[] response = new String[quantity];

        for (int i = 0; i < quantity; i++) {
            int j = 0;
            while (j < 2) {
                Random random = new Random();
                StringBuilder str = new StringBuilder();
                int count = 0;
                while (count < length) {
                    vowel = vowels[random.nextInt(vowels.length - 1)];
                    consonant = consonants[random.nextInt(consonants.length - 1)];
                    sylable = consonant + vowel;
                    str.append(sylable);
                    count++;
                }
                if (j != 1) {
                    response[i] = str.toString();
                }
                else {
                    response[i] += (" " + str.toString());
                }
                j++;
            }
        }
        return response;
    }


    public static boolean isLeapYear(int year) {
        if (year % 4 != 0) return false;
        else if (year % 400 == 0) return true;
        else return year % 100 != 0;
    }

    public static int[] getTransactionValue(int id, int quantity) {

        int c = Integer.parseInt(String.valueOf(id).substring(1, 3));
        int[] values = new int[quantity];

        for (int i = 0; i < quantity; i++) {
            values[i] = 3 * (int) (Math.pow(i, 3) - 30 * i + c + quantity);
        }
        return values;
    }
}


