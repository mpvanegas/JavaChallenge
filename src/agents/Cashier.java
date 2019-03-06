package agents;

public class Cashier extends Agent {

    private static final int PRIORITY = 1;

    public Cashier(int workId){
        super(workId);
    }

    @Override
    public int getPriority() {
        return PRIORITY;
    }
}