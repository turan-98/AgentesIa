package primeiroAgente;
import jade.core.Agent;

public class agentBond extends Agent{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void setup() {
		System.out.println("Hey my name is " + this.getLocalName() );
		addBehaviour(new bBond(this));
	}
}
