public class CoffeeMain {
    public static void main(String[] args) {
        CMachine c = new CMachine();
        c.insert_current_money(114);
        c.brew(CMachine.types.LATTE);
    }
}
