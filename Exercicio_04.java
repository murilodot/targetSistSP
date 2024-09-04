public class Exercicio_04 {

    public static void main(String[] args) {
        // informacoes de cada estado (valores)
        double fatSP = 67836.43;
        double fatRJ = 36678.66;
        double fatMG = 29229.88;
        double fatES = 27165.48;
        double fatOutros = 19849.53;

        // Calculo do faturamento total dos estados
        double fatTotal = fatSP + fatRJ + fatMG + fatES + fatOutros;

        // calcula o percentual de cada um deles
        double percentSP = (fatSP / fatTotal) * 100;
        double percentRJ = (fatRJ / fatTotal) * 100;
        double percentMG = (fatMG / fatTotal) * 100;
        double percentES = (fatES / fatTotal) * 100;
        double percentOutros = (fatOutros / fatTotal) * 100;

        // Print dos resultados
        System.out.printf("Percentual de representação de SP: %.2f%%\n", percentSP);
        System.out.printf("Percentual de representação de RJ: %.2f%%\n", percentRJ);
        System.out.printf("Percentual de representação de MG: %.2f%%\n", percentMG);
        System.out.printf("Percentual de representação de ES: %.2f%%\n", percentES);
        System.out.printf("Percentual de representação de Outros estados: %.2f%%\n", percentOutros);
    }
}