package operations;


import client.Client;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerIssues implements IOperation {

    private Client client;
    private final static Logger LOGGER = Logger.getLogger("subnivel.CostumerIssues");

    public CustomerIssues(Client client){
        this.client = client;
    }

    @Override
    public void operation() {

        LOGGER.log(Level.INFO, "\nCUSTOMER ISSUES");


        try {
            Thread.sleep(client.getAttentionTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
            LOGGER.log(Level.WARNING, "The precess was interrupted");
        }

        LOGGER.log(Level.INFO, "\nThe client has resolved their customer issues");
    }
}
