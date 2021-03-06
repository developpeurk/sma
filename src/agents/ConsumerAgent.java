package agents;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.core.behaviours.WakerBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
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
		
		ParallelBehaviour parallelBehaviour = new ParallelBehaviour();
		addBehaviour(parallelBehaviour);
		
		parallelBehaviour.addSubBehaviour(new OneShotBehaviour() {		
			@Override
			public void action() {

				System.out.println("One Shot");
			}
		});
		
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
		
		/*addBehaviour(new OneShotBehaviour() {
			
			@Override
			public void action() {
				System.out.println("One Shot Behavior");
				
			}
		});*/
		
	/*	addBehaviour(new CyclicBehaviour() {
			private int counter = 0;
			
			@Override
			public void action() {
				System.out.println("Counter => " + counter);
				++counter;
				
			}
		});*/
		/*
		addBehaviour(new TickerBehaviour(this, 1000) {
	
			
			@Override
			protected void onTick() {
				System.out.println("Tic " );
				System.out.println(myAgent.getAID().getLocalName());
				
			}
		});*/
		
		
		parallelBehaviour.addSubBehaviour(new CyclicBehaviour() {
			@Override
			public void action() {
				//MessageTemplate messageTemplate = MessageTemplate.MatchPerformative(ACLMessage.CFP);
				MessageTemplate messageTemplate = MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.CFP), 
						MessageTemplate.MatchLanguage("fr"));
				ACLMessage aclMessage = receive(messageTemplate);
				if(aclMessage!=null){
					System.out.println("Sender: " + aclMessage.getSender().getName());
					System.out.println("Content: " + aclMessage.getContent());
					System.out.println("SpeechAct: " + aclMessage.getPerformative(aclMessage.getPerformative()));
					
					ACLMessage reply = new ACLMessage(ACLMessage.CONFIRM);
					reply.addReceiver(aclMessage.getSender());
					reply.setContent("Price=900");
					send(reply);
					
				}else {
					System.out.println("Bloc ......");
					block();
					}
				
			}
		});
		
		
		
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy:HH:mm");
		Date date=null;
		try {
			date = dateFormat.parse("17/07/2022:15:39");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		parallelBehaviour.addSubBehaviour(new WakerBehaviour(this,date) {
			
			@Override
			protected void onWake() {
				System.out.println("Waker Behavior");
			}
		});
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
