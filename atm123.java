public class atm123
{
    public static void main(String[] args) 
    {
        BankAccount account = new BankAccount(1000.0); // Initial balance
        ATM atm = new ATM(account);    // creating object atm
        atm.run();    //
    }
}

class BankAccount
{
    private double balance;

    public BankAccount(double initialBalance)
    {
        balance = initialBalance;
    }

    public double getBalance()
    {
        return balance;
    }

    public void deposit(double amount)
    {
        balance += amount;
    }

    public void withdraw(double amount)
    {
        balance -= amount;
    }
}

class ATM
{
    private final BankAccount account;

    public ATM(BankAccount account)
    {
        this.account = account;
    }

    public void run()
    {
        while (true)
        {
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            int choice = Integer.parseInt(System.console().readLine("Enter your choice: "));

            switch (choice)
            {
                case 1 -> {
                    double depositAmount = Double.parseDouble(System.console().readLine("Enter amount to deposit: "));
                    account.deposit(depositAmount);
                    System.out.println("Deposit successful. New balance: " + account.getBalance());
                }
                case 2 -> {
                    double withdrawAmount = Double.parseDouble(System.console().readLine("Enter amount to withdraw: "));
                    if (withdrawAmount <= account.getBalance())
                    {
                        account.withdraw(withdrawAmount);
                        System.out.println("Withdrawal successful. New balance: " + account.getBalance());
                    }
                    else
                    {
                        System.out.println("Insufficient balance.");
                    }
                }
                case 3 -> System.out.println("Your current balance is: " + account.getBalance());
                case 4 -> System.exit(0);
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}