import dispatcher.Dispatcher;
import utils.Creator;

public class main {

    public static void main(String[] args) {

        Dispatcher juan = new Dispatcher();

        Creator.createCashiers(juan);
        Creator.createSupervisors(juan);
        Creator.createDirectors(juan);

        Creator.createClients(juan);

        while(!juan.getClients().isEmpty()){
            juan.attend();
        }
    }
}