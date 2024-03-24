import java.util.List;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("Vinícius", 17);
        Cliente cliente2 = new Cliente("Manoela", 14);

        Conta conta1 = new ContaCorrente(cliente1);
        Conta conta2 = new ContaCorrente(cliente2);

        List <Conta> ContasCorrente = new ArrayList<>();
       
        ContasCorrente.add(conta1);
        ContasCorrente.add(conta2);

        System.out.println(ContasCorrente);

        conta1.depositar(300);
        conta2.depositar(100);

        System.out.println(ContasCorrente);

        conta1.transferir(100, conta2);

        System.out.println(ContasCorrente);
        
    }
}
