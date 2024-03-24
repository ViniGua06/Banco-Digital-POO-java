

public interface IConta {
    void transferir(double valor, Conta contaDestino);
    void sacar(double valor) throws InvalidOperationException;
    void depositar(double valor);
}
    

