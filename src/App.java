import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

import classes.Fibonacci;
import classes.MDC;

public class App {
    public static void main(String[] args) throws Exception {

        // Exercicio 1
        System.out.println("Exercicio 1: ");

        Queue<String> fila = new LinkedList<>();

        fila.add("Pedro");  // Posição 1
        fila.add("João");   // Posição 2
        fila.add("Rafael"); // Posição 3
        fila.add("Jorge");  // Posição 4          
        fila.add("Paulo");  // Posição 5
        
        Random foraFila = new Random();
        int num = 0;
        while (num == 0){
            num = foraFila.nextInt(5);
        }
        System.out.println("Batata quente, quente, quente, queimou... na posição: " + num);
        while (fila.size() > 1){
            for (int i = 0; i < num; i++) {
                fila.add(fila.remove()); 
            }
            System.out.println("O eliminado foi: " + fila.remove()); // Remove o indivíduo e reorganiza a fila.
        }

        System.out.println("O ganhador foi o " + fila);

        // Exercicio 2
        System.out.println("Exercicio 2: ");

        Scanner palindromo = new Scanner(System.in);
        String valorPalindromo = "";

        while (!valorPalindromo.equalsIgnoreCase("sair")) {
            System.out.print("Digite uma palavra ou 'sair' para finalizar: ");
            valorPalindromo = palindromo.next();

            String invertida = new StringBuffer(valorPalindromo).reverse().toString();

            if (valorPalindromo.equalsIgnoreCase(invertida)) {
                System.out.printf("A palavra %s é palíndromo.\n", valorPalindromo);
            } else {
                System.out.printf("A palavra %s não é palíndromo.\n", valorPalindromo);
            }
        }

        // Exercicio 3
        System.out.println("Exercicio 3: ");

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o tamanho da sequência de fibonacci: ");
        int valorFibo = sc.nextInt();

        for (int i = 0; i < valorFibo; i++) {
            System.out.print(Fibonacci.fibonacci(i) + " ");
        }

        // Exercicio 4
        System.out.println("\n\nExercicio 4: ");

        Scanner valorEntrada = new Scanner(System.in);
        int sair = 0;

        Stack<Integer> pilha = new Stack<Integer>();
        pilha.push(1);
        pilha.push(2);
        pilha.push(3);
        pilha.push(4); // Populando a pilha

        while (sair != 5) {

            System.out.println("1. Empilhar elemento. ");
            System.out.println("2. Desempilhar elemento. ");
            System.out.println("3. Mostrar o topo. ");
            System.out.println("4. Imprimir tudo zerando a pilha. ");
            System.out.println("5. Sair! \n");

            System.out.print("Selecione a opção desejada: ");
            sair = valorEntrada.nextInt();

            if (sair == 1) {
                System.out.print("Digite o valor para empilhar: ");
                int valorpilha = valorEntrada.nextInt();
                pilha.push(valorpilha);
            } else if (sair == 2) {
                if (!pilha.isEmpty()) { // Tratamento de erros
                    System.out.print("Digite o valor para desempilhar: ");
                    pilha.pop();
                    System.out.println("\nItem desempilhado!");
                } else {
                    System.out.println("Não a elementos na pilha!");
                }
            } else if (sair == 3) {
                if (!pilha.isEmpty()) { // Tratamento de erros
                    System.out.println("O topo da pilha é: " + pilha.lastElement());
                } else {
                    System.out.println("Não há elementos na pilha!");
                }
            } else if (sair == 4) {
                System.out.print("Impressão da pilha: ");
                for (int i = pilha.size() - 1; i >= 0; i--) {
                    System.out.print(pilha.get(i) + " ");
                }
                System.out.println("\nPilha zerada!");
                pilha.clear();
            }
            System.out.println("*---------------------------*");
        }

        // Exercicio 5

        Scanner valorMDC = new Scanner(System.in);

        System.out.println("\nExercicio 5: ");

        MDC mdc = new MDC();

        while (true) {
            System.out.print("Digite o primeiro valor: ");
            int valor1 = valorMDC.nextInt();
            System.out.print("Digite o segundo valor: ");
            int valor2 = valorMDC.nextInt();

            if (valor1 == -1 || valor2 == -1)
                break;

            int resposta = mdc.mdc(valor1, valor2);

            System.out.println("Resultado: " + resposta);
            break;
        }
    }
}
