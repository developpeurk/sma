package agents;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
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
		/*
		addBehaviour(new Behaviour() {
			private int counter = 0;
			
			@Override
			public boolean done() {
				return (counter==10);
			}
			
			@Override
			public void action() {
				System.out.println("------------------");
				System.out.println("Step " + counter);
				System.out.println("------------------");
				++counter;
			}
		});*/
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
