package agente;

import java.util.Random;

public class agente {
	public ambiente marte;
	private int 	linhabase;
	private int 	colunabase;
	private boolean carregado;
	private int 	linhaatual;
	private int 	colunaatual;
	

	public agente (ambiente amb) {
		this.carregado = false;
		this.marte = amb;
	}
	
	public void buscar() {
		this.pousar();
		while(marte.existe == true){		
			if(linhabase == linhaatual && colunabase == colunaatual) {
				if(carregado == true) {
					descarrega();
				}else{
					movimenta();
				}
			}else{
				if(carregado == true) {
					voltabase();
				}else {
					if(marte.tipo(linhaatual,colunaatual) == 1) {
						carrega();
					}else {
						movimenta();
					}
				}
			}
			marte.desenha(linhaatual,colunaatual,linhabase,colunabase);
		}
	}
	
	private void descarrega() {
		this.carregado = false;
	}
	
	private void carrega() {
		marte.remove(linhaatual,colunaatual);
		this.carregado = true;
	}
	
	private void pousar() {
		Random gerador = new Random();
		boolean pousou = false;
		while(pousou == false) {
			int x = gerador.nextInt(10);
			int y = gerador.nextInt(10);
			if(marte.tipo(x,y)== 0) {
				linhaatual = x;
				linhabase = x;
				colunaatual =y;
				colunabase = y;
				pousou = true;
			}
		}
	}
	
	private void movimenta() {
		boolean permitido = false;
		Random gerador = new Random();
		while (permitido == false) {
			int lado = gerador.nextInt(4);
			switch(lado) {
				case 0:{
					if( (linhaatual +1 < marte.nrlinhas) && marte.tipo(linhaatual+1, colunaatual) != 2) {
						linhaatual++;
						permitido = true;
					}
					break;
				}
				case 1:{
					if((linhaatual > 0) && marte.tipo( linhaatual-1, colunaatual) != 2) {
						linhaatual--;
						permitido = true;
					}
					break;
				}
				case 2:{
					if((colunaatual+1) < marte.nrcolunas && marte.tipo(linhaatual, colunaatual+1) != 2) {
						colunaatual++;
						permitido = true;
					}
					break;
				}
				case 3:{
					if((colunaatual > 0) && marte.tipo(linhaatual, colunaatual-1) != 2) {
						colunaatual--;
						permitido = true;
					}
					break;
				}
			}
		}	
	}
	
	private void voltabase() {
		while(linhaatual != linhabase || colunaatual != colunabase) {
			movimenta();
		}
	}
}