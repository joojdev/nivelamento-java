package br.edu.ifsp.list01;

import java.util.ArrayList;
import java.util.Scanner;

/*
    Faça um programa que leia um conjunto de valores que correspondem as idades de pessoas de uma comunidade. Quando
    o valor fornecido for um número negativo, significa que não existem mais idades para serem lidas. Após a leitura,
    o programa deve informar:

    A média das idades das pessoas (com duas casas decimais)
    A quantidade de pessoas maiores de idade
    A porcentagem de pessoas idosas (considere quem uma pessoa idosa tem mais de 75 anos) (com duas casas decimais)

    Exemplos de entrada e saída:
    | Entrada             | Saída          |
    | -------             | ------         |
    | 10 20 30 80 -1      | 35.00 3 25.00% |
    | 25 30 45 -1         | 33.33 3 0.00%  |
    => Exercício gentilmente cedido pelos profs. Jorge Cutigi (IFSP/SCL) e Adenilso Simão (ICMC/USP)
*/
public class Ex09 {

    public static void main(String[] args) {
        //Leia o input
        Scanner scanner = new Scanner(System.in);
        
        boolean reading = true;
        ArrayList<Integer> inputArray = new ArrayList<>();

        while (reading) {
            int input = scanner.nextInt();

            if (input == -1) {
                reading = false;
            }
            inputArray.add(input);
        }
        scanner.close();

        System.out.println(inputArray);

        int[] convertedInput = new int[inputArray.size()];
        for (int i = 0; i < inputArray.size(); i++) {
            convertedInput[i] = inputArray.get(i);
        }

        //Crie uma variável do tipo deste arquivo. Exemplo: Ex02 ex = new Ex02();
        Ex09 ex = new Ex09();

        //Escreva o resultado da chamada do método compute() aqui
        System.out.println(ex.compute(convertedInput));
    }

    String compute(int[] input) {
        double average = 0;
        int adults = 0;
        int older_than_75 = 0;

        for (int i = 0; i < input.length - 1; i++) {
            int age = input[i];

            average += age;

            if (age >= 18) {
                adults++;
            }
            if (age > 75) {
                older_than_75++;
            }
        }

        average /= input.length - 1;
        double older_than_75_percentage = ((double) older_than_75 / (input.length - 1)) * 100;

        return String.format("%.2f %d %.2f%%", average, adults, older_than_75_percentage);
    }
}
