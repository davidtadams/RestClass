package dynamic;

//@RunThis
public class RunStuffHere {
//    @RunThis
    private int x;
    
    @SetThis("ninety-nine")
    private String value = "";
    
    @RunThis
    public void doStuff() {
        System.out.println("RunStuffHere.doStuff!");
    }
    
    @RunThis
    public void doMoreStuff() {
        System.out.println("RunStuffHere.doStuff!");
    }
    
    public void dontDoStuff() {
        System.out.println("RunStuffHere.doStuff!");
    }
    
    @RunThis
    @Override
    public String toString() {
        return "From RunStuffHere, value is " + value;
    }
}
