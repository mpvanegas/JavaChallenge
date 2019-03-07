package dispatcher;

import agents.Agent;
import client.Client;
import utils.SortAgents;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dispatcher {
    private Queue<Client> clients;
    private Queue<Agent> agents;
    private final static Logger LOGGER = Logger.getLogger("subnivel.Dispatcher");

    public Dispatcher(){
        this.clients = new LinkedList<>();
        this.agents = new PriorityQueue<Agent>(new SortAgents());
    }

    public void addClients(Client client){
        clients.add(client);
    }

    public void addAgents(Agent agent){
        if(!agent.isBusy()){
            agents.add(agent);
        }
    }

    public void attend() {

        LOGGER.log(Level.INFO, "============================");

        while(agents.isEmpty()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Agent readyAgent = agents.poll();

        LOGGER.log(Level.INFO, "The assigned agent is a " + readyAgent.getClass().getSimpleName() + " with id " + readyAgent.getWorkId());

        readyAgent.attendClient(clients.poll());
        addAgents(readyAgent);
    }

    public Queue<Client> getClients() {
        return clients;
    }

    public Queue<Agent> getAgents() {
        return agents;
    }
}