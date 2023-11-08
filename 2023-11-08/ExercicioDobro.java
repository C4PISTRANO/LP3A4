import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExercicioDobro{
    public static void main(String[] args) {
    // Lista Inicial
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
        
        //Cria nova lista e realiza as Operações 
        List<Integer> dobro = numeros.stream()
                .map(n -> 2 * n)
                .collect(Collectors.toList());

        System.out.println("Dobro dos números: " + dobro);
    }
}