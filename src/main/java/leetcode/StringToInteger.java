package leetcode;

import java.util.ArrayList;
import java.util.List;

public class StringToInteger {

    private int getPower(int power) {
        if(power == 0) {
            return 1;
        }

        return (int) Math.pow(10,power);
    }
    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        List<Character> digits = new ArrayList<>();
        boolean isNegative = false;
        for(int i = 0; i < chars.length; i++) {
            switch(chars[i]) {
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    digits.add(Character.valueOf(chars[i]));
                    break;
                case '-':
                    isNegative = true;
                    break;
                case ' ':
                    break;
                default:
                    if(0 == i) {
                        return 0;
                    }
                    break;
            }
        }

        int number = 0;

        for(int i = 0; i < digits.size(); i++) {
            int digit = 0;
            boolean toSkip = false;
            switch(digits.get(i)) {
                case '1':
                    break;
                case '2':
                    digit = 2;
                    break;
                case '3':
                    digit = 3;
                    break;
                case '4':
                    digit = 4;
                    break;
                case '5':
                    digit = 5;
                    break;
                case '6':
                    digit = 6;
                    break;
                case '7':
                    digit = 7;
                    break;
                case '8':
                    digit = 8;
                    break;
                case '9':
                    digit = 9;
                    break;

            }
            if(!toSkip) {
                    number += digit * getPower(digits.size() - i - 1);
            }
        }

        return isNegative ? 0 - number : number;
    }

    public static void main(String[] args) {
        StringToInteger o = new StringToInteger();
        System.out.println(o.myAtoi("43"));
    }
}
