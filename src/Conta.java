public abstract class Conta implements IConta{

    protected int agencia;
    protected int numero;
    protected int saldo;
    protected Cliente cliente;

    private static final int AGENCIA = 1;
    private static int SEQUENCIAL = 1;

    public Conta(Cliente cliente) {
        this.saldo = 0;
        this.numero = SEQUENCIAL++;
        this.agencia = AGENCIA;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) throws InvalidOperationException {
       if (valor > saldo) {
        throw new InvalidOperationException("Impossível sacar " + valor + " de " + saldo + ". Saldo insuficiente");
       }

       if (valor < 0) {
        throw new InvalidOperationException("Valor inválido");
       }

       this.saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        try {
            this.sacar(valor);
            contaDestino.depositar(valor);
        } catch (InvalidOperationException e) {
            System.out.println("Operação inválida: " + e.getMessage());
        }
    }

    @Override
    public String toString () {
        String tipoConta = this instanceof ContaCorrente ? "Corrente" : "Poupança";
        return "{ agencia: " + agencia + ", numero: " + numero + ", saldo: " + saldo + ", tipoConta: " + tipoConta + " }";
    }


    
}
