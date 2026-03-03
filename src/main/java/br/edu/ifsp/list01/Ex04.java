package br.edu.ifsp.list01;

import java.util.Scanner;

/*
    Osmar adora chocolates e vai para a loja com N dinheiro no bolso. O preço de cada chocolate é C.
    A loja oferece um desconto: para cada M embalagens que ele dá para a loja, ele ganha um chocolate grátis.
    Quantos chocolates Osmar consegue comer? Por exemplo:

    Para N=10, C=2, M=5, ele pode comprar 5 chocolates por $10 e trocar as 5 embalagens por mais 1 chocolate,
    fazendo com que o número total de chocolates que ele pode comer seja 6.
    Faça um programa que leia inteiros N, C e M e imprima a quantidade de chocolates que Osmar pode comer.
    C e M são inteiros positivos.

    Entrada	Saída
    10      6
    2
    5
 */
public class Ex04 {

    public static void main(String[] args) {
        //Leia o input
        Scanner scanner = new Scanner(System.in);
        int money = scanner.nextInt();
        int chocolatePrice = scanner.nextInt();
        int wraps = scanner.nextInt();
        scanner.close();

        //Crie uma variável do tipo deste arquivo. Exemplo: Ex02 ex = new Ex02();
        Ex04 ex = new Ex04();

        //Escreva o resultado da chamada do método compute() aqui
        System.out.println(ex.compute(money, chocolatePrice, wraps));
    }

    int compute(int n, int c, int m) {
        int output = 0;
        int money = n;
        int chocolateWraps = 0;

        while (money >= c || chocolateWraps >= m) {
            int chocolatesBought = 0;
            if (money >= c) {
                chocolatesBought += money / c;
                money %= c;
                output += chocolatesBought;
            }
            chocolateWraps += chocolatesBought;

            if (chocolateWraps >= m) {
                chocolatesBought = chocolateWraps / m;
                output += chocolatesBought;
                chocolateWraps %= m;
                chocolateWraps += chocolatesBought;
            }
        }

        return output;
    }
}
