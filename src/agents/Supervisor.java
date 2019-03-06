package agents;

public class Supervisor extends Agent {

    private static final int PRIORITY = 2;

    public Supervisor(int workId){
        super(workId);
    }

    @Override
    public int getPriority() {
        return PRIORITY;
    }
}
