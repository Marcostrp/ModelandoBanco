import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Map para armazenar as contas e as chaves
        Map<String, Conta> contasMap = new HashMap<>();

        // Criando clientes e contas
        Cliente tulio = new Cliente();
        tulio.setNome("Tulio");
        Conta ccTulio = new ContaCorrente(tulio);
        contasMap.put(tulio.getNome(), ccTulio);

        Cliente ligia = new Cliente();
        ligia.setNome("Ligia");
        Conta poupancaLigia = new ContaPoupanca(ligia);
        contasMap.put(ligia.getNome(), poupancaLigia);

        Cliente junior = new Cliente();
        junior.setNome("Junior");
        Conta ccJunior = new ContaCorrente(junior);
        contasMap.put(junior.getNome(), ccJunior);

        Cliente nestor = new Cliente();
        nestor.setNome("Nestor");
        Conta poupancaNestor = new ContaPoupanca(nestor);
        contasMap.put(nestor.getNome(), poupancaNestor);
//
        Scanner sc = new Scanner(System.in);
        String usuario = null;
        String numeroConta = null;

        // laço para logar na conta e recuperar os dados através do Map
        for (int i = 0; i < 3; i++) {
            System.out.println("Entre com o usuario:");
            usuario = sc.next();
            System.out.println("Entre com a conta:");
            numeroConta = sc.next();
            if (contasMap.containsKey(usuario)) {
                Conta conta = contasMap.get(usuario);
                // Implementação de um menu
                System.out.println(" ===== Bem Vindo ao Banco Caseiro ===== ");
                System.out.println("|                                      |");
                System.out.println("|    ** Escolha um dos serviços **     |");
                System.out.println("|                                      |");
                System.out.println("|   1 - Extrato da conta               |");
                System.out.println("|   2 - Efetuar SAQUE                  |");
                System.out.println("|   3 - Efetuar DEPOSITO               |");
                System.out.println("|   4 - Solicitar empréstimo           |");
                System.out.println("|   5 - Fazer TRANSFERÊNCIA            |");
                System.out.println("|                                      |");
                System.out.println("|______________________________________|");

                System.out.println("Opção de serviço:");
                int opcaoServico = sc.nextInt();

                switch (opcaoServico) { //switch case para as opções
                    case 1:
                        conta.imprimirExtrato();
                        break;

                    case 2:
                        conta.sacar();
                        break;

                    case 3:
                        conta.depositar();
                        break;

                    case 4:
                        conta.tomarEmprestimo();
                        break;

                    case 5:
                        conta.transferir(contasMap);

                }
                return;
            }
            System.out.println("Operação efetuada com sucesso");
            return;
        }

    }

}