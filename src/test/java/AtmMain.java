public class AtmMain {
    public static void main(String[] args) {
        AtmMachine a1 = new AtmMachine("Ahmed Sameh", 100, 127123);
        a1.deposit(10);
        a1.withdraw(5);
        a1.print_info();

        AtmMachine a2 = new AtmMachine("Rengar Shivana", 8000, 912836812);
        a2.deposit(123);
        a2.withdraw(271);
        a2.print_info();

        AtmMachine a3 = new AtmMachine("Mohamed Adham", 19238, 231124);
        a3.deposit(300);
        a3.withdraw(50);
        a3.print_info();
    }
}
