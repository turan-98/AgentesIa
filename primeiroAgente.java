package primeiroAgente;
import jade.core.Agent;



public class primeiroAgente extends Agent{
	private static final long serialVersionUID = 1L;
	
	public void setup() {
		System.out.println("shout-out to my man " + this.getLocalName() + " in the house ");
		addBehaviour(new bSmith(this));
	}
	

}
