import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String anwer = "";
        System.out.println("Введите два числа от 1 до 10 и знак операции над ними (+, -, /, *) как в примере: 1 + 1. Числа могут быть как в римском формате 'I, II, III, VI..' так и в десятичном '1, 2, 3, 4...' но не смешивайте форматы иначе программа выдаст ошибку и завершится.");
        while (true) {
                anwer = Main.calc(scanner.nextLine());
                System.out.println(anwer);
        }
    }

    public static String calc(String input) throws IOException {
        String[] a = input.trim().split(" ");
        if(a.length > 3) {
            throw new IOException();
        }
        String numOne = "";
        String numTwo = "";
        boolean isRome = false;
        String result;
        String separator = a[1];
        if(InnerMain.isRoman(a[0], a[2])) {
            isRome = true;
            numOne = Integer.toString(InnerMain.getDigit(a[0]));
            numTwo = Integer.toString(InnerMain.getDigit(a[2]));
        }
        if(!isRome) {
            numOne = a[0];
            numTwo = a[2];
        }
        if((!isRome) & (!isCorrectDigit(numOne, numTwo))) {
            throw new IOException();
        }
        switch (separator) {
            case "+":
                result = Integer.toString(Integer.parseInt(numOne) + Integer.parseInt(numTwo));
                break;
            case "-":
                result = Integer.toString(Integer.parseInt(numOne) - Integer.parseInt(numTwo));
                break;
            case "*":
                result = Integer.toString(Integer.parseInt(numOne) * Integer.parseInt(numTwo));
                break;
            case "/":
                result = Integer.toString(Integer.parseInt(numOne) / Integer.parseInt(numTwo));
                break;
            default:
                throw new IOException();
        }
        if(isRome) {
            if(Integer.parseInt(result) < 1) {
                throw new IOException();
            } else {
                return InnerMain.getRoman(Integer.parseInt(result));
            }
        }
        return result;
    }

    public static boolean isCorrectDigit(String numOne, String numTwo) throws IOException {
        try {
            if(Integer.parseInt(numOne) > 0 & Integer.parseInt(numOne) <= 10 & Integer.parseInt(numTwo) > 0 & Integer.parseInt(numTwo) <= 10) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new IOException();
        }
    }
}


class InnerMain {
    static String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
            };

    static String getRoman(int digit) {
        String r = roman[digit];
        return r;
    }
    
    static int getDigit(String value) {
        int digit = -1;
        for(int i = 1; i <= 10; i++) {
            if(roman[i].equals(value)) {
                digit = i;
                return digit;
            }
        }
        return digit;
    }

    static boolean isRoman(String numOne, String numTwo) {
        if(InnerMain.getDigit(numOne) != -1 & InnerMain.getDigit(numTwo) != -1) {
            return true;
        } else {
            return false;
        }
    }
} 