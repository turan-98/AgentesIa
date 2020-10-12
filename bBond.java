package primeiroAgente;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class bBond extends SimpleBehaviour{
	private static final long serialVersionUID = 1L;
	private static final MessageTemplate msn = MessageTemplate.MatchPerformative(ACLMessage.REQUEST);
	ACLMessage msgAgente;
	int countBond = 0;
	
	public bBond(Agent agent) {
		super (agent);
	}
	
	@Override
	public void action() {
		if(countBond == 0) {
			enviaPrimeiraMsg();
		}else {
			msgAgente = myAgent.receive(msn);
			if(msgAgente != null) {
				System.out.println(msgAgente.getContent());
				enviaMsg();
			} else {
				this.block();
			}
		}
	}

	private void enviaPrimeiraMsg() {
		// TODO Auto-generated method stub
		AID agenteRecebedor = new AID("smith", AID.ISLOCALNAME);
		ACLMessage priMsgAgente = new ACLMessage(ACLMessage.REQUEST);
		priMsgAgente.addReceiver(agenteRecebedor);
		priMsgAgente.setContent(myAgent.getLocalName() + " what's up partty people ?");
		myAgent.send(priMsgAgente);
	}
	
	private void enviaMsg() {
		ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
		msg.addReceiver(msgAgente.getSender());
		msg.setContent(myAgent.getLocalName() + " all good man, what about u ??");
		myAgent.send(msg);
	}
	
	
	@Override
	public boolean done() {
		if(countBond == 1)
			myAgent.doDelete();
		else
			countBond++;
		
		return false;
		
	}

}
