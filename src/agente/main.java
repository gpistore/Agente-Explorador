package agente;

public class main {
	
	public static void main(String [ ] args)
	{
		tela tela = new tela();
		ambiente marte = new ambiente(tela);
		agente robo = new agente(marte);
		robo.buscar();
	}
}
