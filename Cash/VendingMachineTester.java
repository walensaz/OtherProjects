


public class VendingMachineTester 
{
    //Tester
    public static void main(String[] args) {
        Vending_Machine machine = new Vending_Machine();
        machine.addPurchase(40000000.01);
        machine.enterDollars(390000000);
        machine.enterQuarters(50000);
        machine.enterPennies(150000);
        machine.displayChange();
        //System.out.println(machine.theChange());
        
        
    }
    
    
    
}
