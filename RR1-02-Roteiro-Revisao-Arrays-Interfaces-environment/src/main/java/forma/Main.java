package forma;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Qual forma você quer calcular a área?" + System.lineSeparator() +
        "> Triângulo" + System.lineSeparator() +
        "> Retângulo" + System.lineSeparator() +
        "> Quadrado" + System.lineSeparator() +
        "> Círculo" + System.lineSeparator());

        switch (sc.nextLine()) {
            case "Triângulo":
                System.out.println("Qual o tamanho da base?");
                double baseT = sc.nextDouble();
                System.out.println("Qual o tamanho da altura?");
                double alturaT = sc.nextDouble();

                Triangulo triangulo = new Triangulo(baseT, alturaT);
                System.out.println(triangulo.area());

                break;

            case "Retângulo":
                System.out.println("Qual o tamanho da base?");
                double baseR = sc.nextDouble();
                System.out.println("Qual o tamanho da altura?");
                double alturaR = sc.nextDouble();

                Retangulo retangulo = new Retangulo(baseR, alturaR);
                System.out.println(retangulo.area());
                
                break;

            case "Quadrado":
                System.out.println("Qual o tamanho do lado?");
                double ladoQ = sc.nextDouble();

                Quadrado quadrado = new Quadrado(ladoQ);
                System.out.println(quadrado.area());
                
                break;

            case "Círculo":
                System.out.println("Qual o tamanho do raio?");
                double raioC = sc.nextDouble();

                Circulo circulo = new Circulo(raioC);
                System.out.println(circulo.area());

                break;

            default:
                System.err.println("Forma inválida detectada.");
                break;
        }
    }
}
