package client;

public class Client {

    public enum Operation{
        DEPOSIT,
        WITHDRAW,
        ISSUES
    }

    private int balance;
    private int attentionTime;
    private Operation type;
    private int amount;

    public Client(int balance, int attentionTime, Operation type){
        this.balance = balance;
        this.attentionTime = attentionTime;
        this.type = type;
    }

    public Client(int balance, int attentionTime, Operation type, int amount){
        this.balance = balance;
        this.attentionTime = attentionTime;
        this.type = type;
        this.amount = amount;
    }

    public int getAttentionTime() {
        return attentionTime;
    }

    public int getBalance() {
        return balance;
    }

    public int getAmount() {
        return amount;
    }

    public Operation getType() {
        return type;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

}
