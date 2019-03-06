package agents;

public abstract class Agent {

    private int workId;
    private boolean isBussy;

    public Agent(int workId ){
        this.workId = workId;
        this.isBussy = false;
    }

    public int getWorkId(){
        return workId;
    }

    public boolean getIsBussy() {
        return isBussy;
    }

    public void setIsBussy(boolean isBussy){
        this.isBussy = isBussy;
    }

    public abstract int getPriority();
}