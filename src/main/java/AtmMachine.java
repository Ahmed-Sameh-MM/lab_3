import java.util.Scanner;

public class AtmMachine {

    private String name;
    private int balance = 0;
    private int card_no;

    AtmMachine(String name, int balance, int card_no) {
        this.name = name;
        this.balance = balance;
        this.card_no = card_no;
    }

    public void deposit(int amount){
        this.balance += amount;
    }

    public void withdraw(int amount){
        this.balance -= amount;
    }

    public void print_info(){
        System.out.println("Name of the customer: " + name);
        System.out.println("Balance: " + balance);
        System.out.println("Card Number: " + card_no);
    }
}
