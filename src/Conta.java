import java.util.Map;
import java.util.Scanner;

public abstract class Conta implements Iconta {
    Scanner sc = new Scanner(System.in);

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar() {
        System.out.println("Digite o vaor que deseja sacar:");
        double valor = sc.nextDouble();
        if( valor< saldo){
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    @Override
    public void depositar() {
        System.out.println("Digite o valor que deseja depositar:");
        double valor = sc.nextDouble();
        saldo += valor;
        System.out.println("Seu saldo agora é de " + saldo);
    }

    @Override
    public void transferir(Map<String, Conta> contas) {
        System.out.println("Digite o nome do beneficiário:");
        String nomeDestino = sc.next();
        System.out.println("Digite o valor a transferir:");
        double valorTransfer = sc.nextDouble();

        if (saldo >= valorTransfer) {
            if (contas.containsKey(nomeDestino)) {
                Conta contaDestino = contas.get(nomeDestino);
                this.saldo -= valorTransfer;
                contaDestino.saldo += valorTransfer;
                System.out.println("Transferência efetuada.");
                System.out.println("Novo saldo: " + this.saldo);
            } else {
                System.out.println("Conta de destino não encontrada.");
            }
        } else {
            System.out.println("Saldo insuficiente para transferência.");
        }
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirInfosComuns() {
        System.out.println("Titular: "+ this.cliente.getNome());
        System.out.println("Agencia: "+ this.agencia);
        System.out.println("Numero: " + this.numero);
        System.out.println("Saldo: "+ this.saldo);
    }
}