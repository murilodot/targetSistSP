import java.util.Scanner;

public class Exercicio_05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // armazena string para modificao no futuro
        System.out.print("Digite uma string que deseje inverter: ");
        String respUsuario = scanner.nextLine();

        // For para inverter a string
        String respInvertida = "";
        for (int i = respUsuario.length() - 1; i >= 0; i--) {
            respInvertida += respUsuario.charAt(i);
        }

        // exibe a frase invertida
        System.out.println("String invertida: " + respInvertida);

        scanner.close();
    }
}
