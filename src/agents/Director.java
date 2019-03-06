package agents;

public class Director extends Agent {

    private static final int PRIORITY = 3;

    public Director(int workId){
        super(workId);
    }

    @Override
    public int getPriority() {
        return PRIORITY;
    }
}
