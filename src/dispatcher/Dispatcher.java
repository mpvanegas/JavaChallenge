package dispatcher;

import agents.Agent;
import client.Client;
import utils.SortAgents;

import java.util.*;

public class Dispatcher {
    private Queue<Client> clients;
    private Queue<Agent> agents;

    public Dispatcher(){
        this.clients = new LinkedList<>();
        this.agents = new PriorityQueue<Agent>(new SortAgents());
    }

    public void addClients(Client client){
        clients.add(client);
    }

    public void addAgents(Agent agent){
        agents.add(agent);
    }

    public void attend(){
        if( ! agents.peek().isBusy() ){
            Agent readyAgent = agents.poll();
            readyAgent.setClient(clients.poll());
            readyAgent.attendClient();
            addAgents(readyAgent);
        }
    }
}