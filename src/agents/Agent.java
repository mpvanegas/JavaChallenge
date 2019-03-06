package agents;

import client.Client;

public abstract class Agent {

    private int workId;
    private boolean isBusy;
    private Client client;

    public Agent(int workId ){
        this.workId = workId;
        this.isBusy = false;
        this.client = null;
    }

    public int getWorkId(){
        return workId;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public Client getClient() {
        return client;
    }

    public void setWorkId(int workId) {
        this.workId = workId;
    }

    public void setBusy(boolean isBusy){
        this.isBusy = isBusy;
    }

    public void setClient(Client client){
        this.client = client;
    }

    public void attendClient(){
        this.isBusy = true;
        try {
            Thread.sleep(client.getAttentionTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(client.getType() == Client.Operation.DEPOSIT) {
            client.deposit();
        }else if(client.getType() == Client.Operation.WITHDRAW){
            client.withdraw();
        }

        this.isBusy = false;
    }

    public abstract int getPriority();
}