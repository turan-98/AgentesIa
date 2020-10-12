package primeiroAgente;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class bSmith extends SimpleBehaviour {
	private static final long serialVersionUID = 1L;
	private static final MessageTemplate msn = MessageTemplate.MatchPerformative(ACLMessage.REQUEST);
	ACLMessage msgAgente;
	
	int countSmith = 0;
	
	public bSmith(Agent agent) {
		super(agent);
	}
	
	@Override
	public void action() {
		msgAgente = myAgent.receive(msn);
		if(msgAgente != null) {
			System.out.println(msgAgente.getContent());
			enviaMsg();
		}else {
			this.block();
		}
	}

	private void enviaMsg() {
		// TODO Auto-generated method stub
		ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
		msg.addReceiver(msgAgente.getSender());
		msg.setContent(myAgent.getLocalName() + " what's up partt people ??");
		myAgent.send(msg);
	}

	@Override
	public boolean done() {
		// TODO Auto-generated method stub
		if(countSmith == 3)
			myAgent.doDelete();
		else
			countSmith++;
		
		return false;
	}
	
	
	
}
