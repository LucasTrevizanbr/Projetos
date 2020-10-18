package Pacote;

public class Boss extends Personagens {
	
	Heroi h1 = new Heroi();
	
	public Boss() {
		super();

	  setVida(h1.getVida()-20);
	  setForca(h1.getForca()-2);
	  setDefesa(h1.getDefesa()-2);
	  setAgilidade(h1.getAgilidade()-2);
	  setPrecisao(h1.getPrecisao()-2);
	  
	  
	}

}
