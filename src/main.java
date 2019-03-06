import agents.Agent;
import agents.Cashier;
import agents.Director;
import agents.Supervisor;
import client.Client;
import dispatcher.Dispatcher;

public class main {

    public static void main(String[] args) {
        Agent miguel = new Cashier(1);
        Agent pau = new Supervisor(2);
        Agent cami = new Director(3);

        Dispatcher juan = new Dispatcher();

        Client maria = new Client(1000,10000, Client.Operation.ISSUES,100);

        juan.addAgents(miguel);
        juan.addAgents(pau);
        juan.addAgents(cami);

        juan.addClients(maria);

        juan.attend();

        System.out.println(maria.getBalance());
    }
}
