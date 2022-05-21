public class CMachine {
    enum types {LATTE, MOCHA, ESPRESSO}
    double current_money = 0;
    int price = 14;

    public void insert_current_money(int current_money){
        this.current_money = current_money;
        System.out.println("Inserted: " + current_money);
    }

    public void brew(types types_1){
        if(current_money >= price){
            System.out.println("Please Wait for the brewing of " + types_1.toString());
            System.out.println("Change: " + (current_money - price) );
            current_money = 0;
        }
    }

}
