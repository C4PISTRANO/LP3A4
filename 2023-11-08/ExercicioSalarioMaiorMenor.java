import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExercicioSalarioMaiorMenor {
    public static void main(String[] args) {
        List<Double> numbers = Arrays.asList(2500.00, 4000.00, 4500.00, 3000.00, 6000.00, 8000.00, 3500.00, 10000.00);

        Double menorSalario = numbers.stream()
                .reduce(0, (a, b) -> a < b ? a : b)

        Double maiorSalario = numbers.stream()
                .reduce(0, (a, b) -> a > b ? a : b)
                

        System.out.println("O menor salário é: " + menorSalario);
        System.out.println("O maior salário é: " + maiorSalario);
    }
}