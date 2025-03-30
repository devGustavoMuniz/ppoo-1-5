import java.util.Scanner;

public class ATM {
    private final Scanner input;
    private boolean isOn;
    private Account account;

    public ATM() {
        this.isOn = true;
        this.input = new Scanner(System.in);
    }

    public void execute() {
        try (this.input) {
            while (this.isOn) {
                this.showMenu();
                int option = Integer.parseInt(this.input.nextLine());
                switch (option) {
                    case 1 -> this.createAccount();
                    case 2 -> this.checkBalance();
                    case 3 -> this.depositBalance();
                    case 4 -> this.withdrawBalance();
                    case 5 -> this.exit();
                    default -> this.invalidInput();
                }
            }
        }
    }

    private void showMenu() {
        System.out.println("");
        System.out.println("#####");
        System.out.println("1 - Criar Conta");
        System.out.println("2 - Consultar Saldo");
        System.out.println("3 - Depositar");
        System.out.println("4 - Sacar");
        System.out.println("5 - Sair");
        System.out.println("");
        System.out.println("Digite sua opção:");
        System.out.println("#####");
        System.out.println("");
    }

    private void createAccount() {
        System.out.println("Digite o nome do titular da conta: ");
        String name = this.input.nextLine();

        this.account = new Account(name);

        System.out.println("Conta criada com sucesso!");
    }

    private void checkBalance() {
        if (this.account == null) {
            System.out.println("Nenhuma conta criada!");
            return;
        }

        System.out.println("Titular: " + this.account.getName());
        System.out.println("Saldo: " + this.account.getBalance());
    }
    
    private void depositBalance() {
        if (this.account == null) {
            System.out.println("Nenhuma conta criada!");
            return;
        }

        System.out.println("Digite o valor do depósito: ");
        double amount = Double.parseDouble(this.input.nextLine());

        this.account.depositBalance(amount);

        System.out.println("Depósito realizado com sucesso!");
    }
    
    private void withdrawBalance() {
        if (this.account == null) {
            System.out.println("Nenhuma conta criada!");
            return;
        }

        System.out.println("Digite o valor do saque: ");
        double amount = Double.parseDouble(this.input.nextLine());

        if (this.account.withdrawBalance(amount)) {
            System.out.println("Saque realizado com sucesso!");
            return;
        }
        
        System.out.println("Saldo insuficiente!");
    }

    private void exit() {
        this.isOn = false;
    }

    private void invalidInput() {
        System.out.println("Opção inválida! Tente outra.");
    }
}
