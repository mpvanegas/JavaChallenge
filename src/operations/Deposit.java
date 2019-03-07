package operations;

import client.Client;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Deposit implements IOperation {

    private Client client;
    private final static Logger LOGGER = Logger.getLogger("subnivel.Deposit");

    public Deposit(Client client){
        this.client = client;
    }

    @Override
    public void operation() {

        LOGGER.log(Level.INFO, "\nDEPOSIT\n-Current balance: " + client.getBalance() + "\n-Amount to deposit: " + client.getAmount());

        try {
            Thread.sleep(client.getAttentionTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
            LOGGER.log(Level.WARNING, "The precess was interrupted");
        }

        client.setBalance(client.getBalance() + client.getAmount());

        LOGGER.log(Level.INFO, "\nFinal balance: " + client.getBalance());
    }
}
