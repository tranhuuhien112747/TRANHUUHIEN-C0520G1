package introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class App_read {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số bạn muốn đọc thành chữ");
        int number = scanner.nextInt();
        String result = null;
        int answer = number % 10;
        int answer1 = number / 10;
        int answer2 = number / 100;
        int answer3 = number % 100;
        int answer4 = answer3 / 10;
        int answer5 = answer3 % 10;
        if (0 <= number && number < 10) {
            switch (number) {
                case 0:
                    result = "Zero";
                    break;
                case 1:
                    result = "One";
                    break;
                case 2:
                    result = "Two";
                    break;
                case 3:
                    result = "Three";
                    break;
                case 4:
                    result = "Four";
                    break;
                case 5:
                    result = "Five";
                    break;
                case 6:
                    result = "Six";
                    break;
                case 7:
                    result = "Seven";
                    break;
                case 8:
                    result = "Eight";
                    break;
                case 9:
                    result = "Nine";
                    break;
            }
        } else if (10 <= number && number < 20) {
            switch (number) {
                case 10:
                    result = "Ten";
                    break;
                case 11:
                    result = "Leven";
                    break;
                case 12:
                    result = "Twelve";
                    break;
                case 13:
                    result = "Thirteen";
                    break;
                case 14:
                    result = "Fourteen";
                    break;
                case 15:
                    result = "Fiveteen";
                    break;
                case 16:
                    result = "Sixteen";
                    break;
                case 17:
                    result = "Seventeen";
                    break;
                case 18:
                    result = "Eightteen";
                    break;
                case 19:
                    result = "Nineteen";
                    break;
            }
        } else if (20 <= number && number < 100) {
            switch (answer1) {
                case 2:
                    result = "Twenty";
                    break;
                case 3:
                    result = "Thirty";
                    break;
                case 4:
                    result = "Forty";
                    break;
                case 5:
                    result = "Fifty";
                    break;
                case 6:
                    result = "Sixty";
                    break;
                case 7:
                    result = "Seventy";
                    break;
                case 8:
                    result = "Eightty";
                    break;
                case 9:
                    result = "Ninety";
                    break;
            }
            switch (answer) {
                case 1:
                    result += " one";
                    break;
                case 2:
                    result += " two";
                    break;
                case 3:
                    result += " three";
                    break;
                case 4:
                    result += " four";
                    break;
                case 5:
                    result += " five";
                    break;
                case 6:
                    result += " six";
                    break;
                case 7:
                    result += " seven";
                    break;
                case 8:
                    result += " eight";
                    break;
                case 9:
                    result += " nine";
                    break;
            }
        } else if (100 <= number && number < 1000) {
            switch (answer2) {
                case 1:
                    result = "One hundred ";
                    break;
                case 2:
                    result = "Two hundred  ";
                    break;
                case 3:
                    result = "Three hundred  ";
                    break;
                case 4:
                    result = "Four hundred ";
                    break;
                case 5:
                    result = "Five hundred ";
                    break;
                case 6:
                    result = "Six hundred ";
                    break;
                case 7:
                    result = "Seven hundred ";
                    break;
                case 8:
                    result = "Eight hundred ";
                    break;
                case 9:
                    result = "Nine hundred ";
                    break;
            }
            if (0 < answer3 && answer3 < 10) {
                switch (answer3) {
                    case 1:
                        result += "and one";
                        break;
                    case 2:
                        result += "and two";
                        break;
                    case 3:
                        result += "and three";
                        break;
                    case 4:
                        result += "and four";
                        break;
                    case 5:
                        result += "and five";
                        break;
                    case 6:
                        result += "and six";
                        break;
                    case 7:
                        result += "and seven";
                        break;
                    case 8:
                        result += "and eight";
                        break;
                    case 9:
                        result += "and nine";
                        break;
                }
            } else if (10 <= answer3 && answer3 < 20) {
                switch (answer3) {
                    case 10:
                        result += " and ten";
                        break;
                    case 11:
                        result += " and eleven";
                        break;
                    case 12:
                        result += " and twelve";
                        break;
                    case 13:
                        result += " and thirteen";
                        break;
                    case 14:
                        result += " and fourteen";
                        break;
                    case 15:
                        result += " and fiveteen";
                        break;
                    case 16:
                        result += " and sixteen";
                        break;
                    case 17:
                        result += " and seventeen";
                        break;
                    case 18:
                        result += " and eightteen";
                        break;
                    case 19:
                        result += "and  nineteen";
                        break;
                }
            } else if (20 <= answer3 && answer3 < 100) {
                switch (answer4) {
                    case 2:
                        result += "and twenty";
                        break;
                    case 3:
                        result += "and thirty";
                        break;
                    case 4:
                        result += "and forty";
                        break;
                    case 5:
                        result += "and fifty";
                        break;
                    case 6:
                        result += "and sixty";
                        break;
                    case 7:
                        result += "and seventy";
                        break;
                    case 8:
                        result += "and eightty";
                        break;
                    case 9:
                        result += "and ninety";
                        break;
                }
                switch (answer5) {
                    case 1:
                        result += " one";
                        break;
                    case 2:
                        result += " two";
                        break;
                    case 3:
                        result += " three";
                        break;
                    case 4:
                        result += " four";
                        break;
                    case 5:
                        result += " five";
                        break;
                    case 6:
                        result += " six";
                        break;
                    case 7:
                        result += " seven";
                        break;
                    case 8:
                        result += " eight";
                        break;
                    case 9:
                        result += " nine";
                        break;
                }
            }
        }
        System.out.println(result);

    }
}
