import java.util.Scanner;

class Main {
        public static int flag = 0;
        public static boolean romanFlag = false;


        public static void main(String[] args) throws Exception {
                System.out.println("Enter your arithmetic expression (2 operands, 1 operator)");
                Scanner scanner = new Scanner(System.in);
                String line = scanner.nextLine();
                System.out.println(calc(line));

        }

        public static String intToRoman(int letter) {
                int[] arabic = {100, 90, 50, 40, 10, 9, 5, 4, 1};
                String[] roman = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
                String fin;
                StringBuilder romanStr = new StringBuilder();
                for(int i = 0; i<arabic.length;i++){
                        while(letter>=arabic[i]){
                                letter = letter - arabic[i];
                                romanStr.append(roman[i]);
                        }
                }
                fin = romanStr.toString();
                return fin;
        }

        public static String calc (String input) throws Exception{
                String [] romanNumbers = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
                int [] arabicNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
                input = input.trim();
                String [] strArray = input.split(" ");

                int l = strArray.length;
                int i1 = 0;
                int i3 = 0;
                int outInt;
                if (l!=3){throw new Exception("Not allowed length (2 operands, 1 operator)");}

                String s1 = strArray[0];
                String s2= strArray[1];
                String s3 = strArray[2];
                strArray[1] = null;
                String resultLine;

                for (int i = 0; i<romanNumbers.length; i++){
                        if (romanNumbers[i].equals(s1)) {
                                flag++;
                                i1 = arabicNumbers[i];
                                break;
                        }

                }
                for (int j = 0; j < romanNumbers.length; j++) {
                        if (romanNumbers[j].equals(s3)) {
                                flag++;
                                i3 = arabicNumbers[j];
                                break;
                        }
                }


                switch (flag) {
                        case 0 -> {
                                try{
                                        i1 = Integer.parseInt(s1); i3 = Integer.parseInt(s3);
                                }
                                catch(NumberFormatException e){
                                    throw new Exception("Operands must be Arabic or Roman numbers");
                                }
                                if ((i1>10) || (i1<1) || (i3>10) || (i3<1)){
                                        throw new Exception("Both operands must be from 1 to 10");
                                }
                        }
                        case 1 -> throw new Exception("Both operands must be Arabic or Roman numbers, from 1 to 10");
                        case 2 -> romanFlag = true;
                        default -> throw new Exception();
                }

                outInt = switch (s2) {
                        case "+" -> i1 + i3;
                        case "-" -> i1 - i3;
                        case "*" -> i1 * i3;
                        case "/" -> i1 / i3;
                        default -> throw new IllegalArgumentException("Operator should be '+' or '-' or '/' or '*'");
                };

                if (romanFlag){
                        if(outInt>0){
                                resultLine = intToRoman(outInt);
                        }
                        else{
                                throw new Exception("Result of operation is 0 or negative");
                        }
                }
                else{
                        resultLine = Integer.toString(outInt);
                }

        return resultLine;
        }


}




