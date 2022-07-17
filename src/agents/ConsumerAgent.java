package agents;

import jade.core.Agent;
import jade.wrapper.ControllerException;

public class ConsumerAgent extends Agent {
	@Override
	protected void setup() {
		System.out.println("Initialisation de l'agent: " + this.getAID().getName());
	}

	@Override
	protected void beforeMove() {
		try {
			System.out.println("Before Migration from: " + this.getContainerController().getContainerName());
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void afterMove() {
		try {
			System.out.println("After Migration To: " + this.getContainerController().getContainerName());
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void takeDown() {
		System.out.println("I am going to die....");
		System.out.println("..............................");
	}
}
