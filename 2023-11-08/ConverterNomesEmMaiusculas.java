import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConverterNomesEmMaiusculas {
    public static void main(String[] args) {
        String[] nomes = {"João", "Maria", "Pedro", "Ana"};

        List<String> nomesMaiusculos = Arrays.stream(nomes)
                .map(String::toUpperCase) // referência de método que converte para maiusculas
                .collect(Collectors.toList());

        System.out.println("Nomes em maiúsculas:");
        nomesMaiusculos.forEach(System.out::println);
    }
}