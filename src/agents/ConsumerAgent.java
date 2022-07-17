package agents;

import jade.core.Agent;
import jade.wrapper.ControllerException;

public class ConsumerAgent extends Agent {
	@Override
	protected void setup() {
		String bookName=null;
		if(this.getArguments().length==1) {
			bookName = (String)this.getArguments()[0];
		}
		System.out.println("Initialisation de l'agent: " + this.getAID().getName());
		System.out.println("I am trying to buy a book: " + bookName);
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
