import java.util.Scanner;

public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }


    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        super.imprimirInfosComuns();
    }

    @Override
    public void tomarEmprestimo() {
        double margem = saldo * 1.5;
        System.out.println("Sua margem é de: " + margem);
        System.out.println("Deseja efetuar o empréstimo? S/N");
        String respostaEmprestimo = sc.next();
        if(respostaEmprestimo.equalsIgnoreCase("s")){
            System.out.println("Digite o valor desejado:");
            double valorDesejado = sc.nextDouble();
            if (valorDesejado <= margem ){
                saldo += valorDesejado;
            } else {
                System.out.println("Margem insuficiente!");
            }
        }
    }


}
