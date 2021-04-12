package src;

public class Filosofo extends Thread{

	private int id;
	private String nome;
	private Mesa mesa;


	public Filosofo(Mesa mesa, int id, String nome) {
		this.mesa = mesa;
		this.id = id;
		this.nome = nome;
	}

	public void run(){
		while(true) {
			this.pensar();
			this.tentarComer();
		}
	}

	private void pensar() {
		System.out.println(nome + " Esta pensando...\n");
		try {
			sleep((this.id + 1) * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private synchronized void tentarComer() {
		System.out.println(nome + " Esta tentando comer.");
		if(mesa.PegaOs2(this.id, this.nome)){
			mesa.pegarGarfoDireito(this.id, this.nome);
			mesa.pegarGarfoEsquerdo(this.id, this.nome);
			comer();
			devolverGarfos();
		}else{
			System.out.println(nome + " NAO conseguiu comer");
		}
	}

	private void comer() {
		System.out.println(nome + " Esta comendo....\n");
		try {
			sleep((this.id + 1) * 3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void devolverGarfos() {

		mesa.devolverGarfos(this.id, this.nome);
	}


}