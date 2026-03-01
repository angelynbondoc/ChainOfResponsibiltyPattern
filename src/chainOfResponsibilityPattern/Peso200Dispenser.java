package chainOfResponsibilityPattern;

public class Peso200Dispenser implements DispenseChain {
    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(Currency cur) {
        if (cur.getAmount() >= 200) {
            int num = cur.getAmount() / 200;
            int remainder = cur.getAmount() % 200;
            System.out.println("Dispensing " + num + " 200 bills");
            if (remainder != 0 && this.chain != null) {
            	this.chain.dispense(new Currency(remainder));
            	}
       }
        else if (this.chain != null) { 
        	this.chain.dispense(cur);
       }
    }
}