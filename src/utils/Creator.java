package utils;

import agents.Agent;
import agents.Cashier;
import agents.Director;
import agents.Supervisor;
import client.Client;
import dispatcher.Dispatcher;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Creator {

    public static void createCashiers(Dispatcher dispatcher){
        Random rand = new Random();
        int numCashiers = rand.nextInt(4) + 1;

        for(int i = 1; i<=numCashiers; i++){
            int id = Integer.parseInt("1" + i);
            Agent cashier = new Cashier(id);
            dispatcher.addAgents(cashier);
        }
    }

    public static void createSupervisors(Dispatcher dispatcher){
        Random rand = new Random();
        int numSupervisors = rand.nextInt(3) + 1;

        for(int i = 1; i<=numSupervisors; i++){
            int id = Integer.parseInt("2" + i);
            Agent supervisor = new Supervisor(id);
            dispatcher.addAgents(supervisor);
        }
    }

    public static void createDirectors(Dispatcher dispatcher){
        Random rand = new Random();
        int numDirectors = rand.nextInt(2) + 1;

        for(int i = 1; i<=numDirectors; i++){
            int id = Integer.parseInt("3" + i);
            Agent director = new Director(id);
            dispatcher.addAgents(director);
        }
    }

    public static void createClients(Dispatcher dispatcher){
        Random rand = new Random();
        int numClients = rand.nextInt(9) + 1;

        for(int i = 1; i<=numClients; i++){

            Random rand2 = new Random();
            int balance = rand2.nextInt(1_000_000_000);
            int attentionTime = rand2.nextInt(5000)+10000;
            int amount = rand2.nextInt(500_000_000);

            List<Client.Operation> VALUES = Collections.unmodifiableList(Arrays.asList(Client.Operation.values()));
            int SIZE_TYPES = VALUES.size();
            Client.Operation type = VALUES.get(rand2.nextInt(SIZE_TYPES));

            Client client;
            if(type == Client.Operation.DEPOSIT || type == Client.Operation.WITHDRAW){
                client = new Client(balance, attentionTime, type, amount);
            }else {
                client = new Client(balance, attentionTime, type);
            }
            dispatcher.addClients(client);
        }
    }
}