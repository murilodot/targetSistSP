import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercicio_02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FiboCheck check = new FiboCheck();
        int number = 0;
        boolean numValido = false;

        // Entrada e validação de usuarios
        while (!numValido) {
            try {
                System.out.print("Informe um número inteiro: ");
                String input = scanner.nextLine().trim();

                if (input.isEmpty()) {
                    System.out.println("Erro - A entrada não pode ser vazia");
                } else {
                    number = Integer.parseInt(input);
                    check.setNumero(number);
                    numValido = true;
                }

            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Erro - Entrada inválida");
            }
        }

        // verifica se pertence a fibonnaci
        if (check.isFibonacci()) {
            System.out.println(check.getNumero() + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println(check.getNumero() + " não pertence à sequência de Fibonacci.");
        }

        scanner.close();
    }
}


//Classe de getters e setters para verificar fibonacci

class FiboCheck {
    private int numero;

    // Getter
    public int getNumero() {
        return numero;
    }

    // Setter
    public void setNumero(int numero) {
        this.numero = numero;
    }

    // Método para verificar se o número faz parte da sequência de Fibonacci
    public boolean isFibonacci() {
        int a = 0;
        int b = 1;

        if (numero == 0 || numero == 1) {
            return true;
        }

        while (b < numero) {
            int aux = b;
            b = a + b;
            a = aux;
        }

        return b == numero;
    }
}
