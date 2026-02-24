public class Peso1000Dispenser implements DispenseChain {
    private DispenseChain chain;


    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }


    @Override
    public void dispense(Currency cur) {
        if (cur.getAmount() >= 1000) {
            int num = cur.getAmount() / 1000;
            int remainder = cur.getAmount() % 1000; //800
            System.out.println("Dispensing " + num + " 1000 bills");
             if (remainder != 0 && this.chain != null) { // <--- Added null check!
    this.chain.dispense(new Currency(remainder));
}
       } else if (this.chain != null) { // <--- Added null check!
    this.chain.dispense(cur);
        }
    }
}
