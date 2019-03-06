import agents.Agent;
import agents.Cashier;
import agents.Supervisor;
import utils.SortAgents;

import java.util.*;

public class Dispatcher {

    private Queue<Client> clients;
    private Queue<Agent> agents;

    public Dispatcher(){
        this.clients = new PriorityQueue<Client>();
        this.agents = new PriorityQueue<Agent>(new SortAgents());
    }

    public void addClients(Client client){
        clients.add(client);
    }

    public void addAgents(Agent agent){
        agents.add(agent);
    }

    public void attend(){
        if(agents.peek().getIsBussy()){
            clients.peek();
            clients.poll();
            agents.poll().setIsBussy(true);
        }
    }
}