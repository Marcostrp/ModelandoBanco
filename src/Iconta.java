import java.util.Map;

public interface Iconta {

    void sacar();

    void depositar();

    void transferir(Map<String, Conta> contas);

    void imprimirExtrato();

    void tomarEmprestimo();
}