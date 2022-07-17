package agents;
import jade.core.Agent;
public class ConsumerAgent extends Agent {
	@Override
	protected void setup() {
		System.out.println("Initialisation de l'agent: " + this.getAID().getName());
	}

	@Override
	protected void beforeMove() {
		System.out.println("Before Migration");
		System.out.println("..............................");
	}

	@Override
	protected void afterMove() {
		System.out.println("After Migration");
		System.out.println("..............................");
	}
	@Override
	protected void takeDown() {
		System.out.println("I am going to die....");
		System.out.println("..............................");
	}
}
