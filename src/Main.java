import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        String example = scn.nextLine();
        Main main = new Main();
        System.out.println(main.Calculate(example));


    }

    public String Calculate(String example) {

        int a;
        int b;

        int sum = 0;
        boolean rim = false;
        String exampleInParts[] = example.split(" ");

        if(exampleInParts.length != 3 ){
            //TODO: бросить исключение отсутсвуют пробелы или неправильное количество операндов
        }


        if(systemOfNumbers(exampleInParts[0])&&!systemOfNumbers(exampleInParts[2]) || !systemOfNumbers(exampleInParts[0])&&systemOfNumbers(exampleInParts[2])){
            //TODO бросить свое исключение что цифры в разных системах счисления
        }
        rim = systemOfNumbers(exampleInParts[0]);



//        int a =  Numburs.valueOf(exampleInParts[0]).getVskobkah();

        if(rim) {
            Numburs aEnum = Numburs.valueOf(exampleInParts[0]);
            Numburs bEnum = Numburs.valueOf(exampleInParts[2]);
            a = aEnum.getVskobkah();
            b = bEnum.getVskobkah();
        }
        else {
            a = Integer.parseInt(exampleInParts[0]);
            b = Integer.parseInt(exampleInParts[2]);
        }

        switch (exampleInParts[1]) {
            case "+":
                sum = a + b;
                break;
            case "-":
                sum = a - b;
                break;
            case "/":
                sum = a / b;
                break;
            case "*":
                sum = a * b;
                break;
            default:
                //TODO бросить исключение - о том что не валидный знак
                break;
        }


        if (!rim) {
            return String.valueOf(sum);
        }

        String sumStr = String.valueOf(sum);
        String sumArray[] = sumStr.split("");


        if (sum < 11) {
            return getGlavnoeZnachenyeEnum(sum);
        } else {
            int desytki = Integer.parseInt(sumArray[0] + "0");
            return getGlavnoeZnachenyeEnum(desytki) + getGlavnoeZnachenyeEnum(Integer.parseInt(sumArray[1]));
        }

    }


    public String getGlavnoeZnachenyeEnum(int chtoVscobkah) {
        for (Numburs numbur : Numburs.values()) {
            if (numbur.getVskobkah() == chtoVscobkah) {
                return numbur.name();
            }

        }
        return null;
    }


    public boolean systemOfNumbers(String decimal) {

        switch (decimal) {
            case "I":
            case "II":
            case "III":
            case "IV":
            case "V":
            case "VI":
            case "VII":
            case "VIII":
            case "IX":
            case "X":
                return true;

            default:
                int y = Integer.parseInt(decimal);
                return  y == 1 ? false : y == 2 ? false : y == 3 ? false : y == 4 ? false : y == 5 ? false : y == 6 ? false : y == 7 ? false : y == 8 ? false : y == 9 ? false : true; //TODO бросить исключение - о том что некоректный символ




        }

    }
}