import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.OptionalDouble;

public class Exercicio_03 {

    static class FatDia {	// abreviacao de faturamento Dia 
        public int dia;

        @JsonProperty("valor")
        public double fat;	//abreviacao de faturamento

        public FatDia() {}

        public int getDia() {
            return dia;
        }

        public double getFaturamento() {
            return fat;
        }

        @Override
        public String toString() {
            return "Dia: " + dia + ", Faturamento: " + fat;
        }
    }

    public static void main(String[] args) {
        try {
            List<FatDia> faturamentos = carregaDadosFat("src/dados.json");

            if (faturamentos.isEmpty()) {
                System.out.println("Nenhum dado de faturamento encontrado.");
                return;
            }

            List<FatDia> diasValidos = faturamentos.stream()
                    .filter(d -> d.getFaturamento() > 0)
                    .toList();

            double menorFat = calcMenorFat(diasValidos);
            double maiorFat = calcMaiorFat(diasValidos);
            double mediaFat = calcMediaFat(diasValidos);
            long diasAcimaDaMedia = contDiasMaiorMedia(diasValidos, mediaFat);

            showResult(menorFat, maiorFat, diasAcimaDaMedia);

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo JSON: " + e.getMessage());
        }
    }

    private static List<FatDia> carregaDadosFat(String caminhoArquivo) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(caminhoArquivo), new TypeReference<List<FatDia>>() {});
    }

    private static double calcMenorFat(List<FatDia> dias) {
        return dias.stream()
                .mapToDouble(FatDia::getFaturamento)
                .min()
                .orElse(0);
    }

    private static double calcMaiorFat(List<FatDia> dias) {
        return dias.stream()
                .mapToDouble(FatDia::getFaturamento)
                .max()
                .orElse(0);
    }

    private static double calcMediaFat(List<FatDia> dias) {
        OptionalDouble mediaOptional = dias.stream()
                .mapToDouble(FatDia::getFaturamento)
                .average();
        return mediaOptional.orElse(0);
    }

    private static long contDiasMaiorMedia(List<FatDia> dias, double media) {
        return dias.stream()
                .filter(d -> d.getFaturamento() > media)
                .count();
    }

    private static void showResult(double menorFaturamento, double maiorFaturamento, long diasAcimaDaMedia) {
        System.out.println("Menor faturamento: " + menorFaturamento);
        System.out.println("Maior faturamento: " + maiorFaturamento);
        System.out.println("Dias com faturamento acima da média: " + diasAcimaDaMedia);
    }
}
