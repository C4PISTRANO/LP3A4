import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExercicioSalario {
    public static void main(String[] args) {
        List<Double> numbers = Arrays.asList(2500.00, 4000.00, 4500.00, 3000.00, 6000.00, 8000.00, 3500.00, 10000.00);

        List<Double> filtraSalarios = numbers.stream()
                .filter(num -> num >= 3500.00)
                .collect(Collectors.toList());

        System.out.println(filtraSalarios);
    }
}