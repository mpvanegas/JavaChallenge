package agents;

import client.Client;
import operations.CustomerIssues;
import operations.Deposit;
import operations.Withdraw;

public abstract class Agent {

    private int workId;
    private boolean isBusy;

    public Agent(int workId ){
        this.workId = workId;
        this.isBusy = false;
    }

    public int getWorkId(){
        return workId;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void attendClient(Client client){

        this.isBusy = true;

        if(client.getType() == Client.Operation.DEPOSIT) {
            Deposit deposit = new Deposit(client);
            deposit.operation();
        }else if(client.getType() == Client.Operation.WITHDRAW){
            Withdraw withdraw = new Withdraw(client);
            withdraw.operation();
        }else{
            CustomerIssues customerIssues = new CustomerIssues(client);
            customerIssues.operation();
        }

        this.isBusy = false;
    }

    public abstract int getPriority();
}