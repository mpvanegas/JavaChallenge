package utils;

import agents.Agent;
import agents.Cashier;

import java.util.Comparator;

public class SortAgents implements Comparator<Agent> {

    @Override
    public int compare(Agent agent1, Agent agent2) {
        return agent1.getPriority() - agent2.getPriority();
    }
}
