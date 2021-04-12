package src;


public class Mesa {

	private boolean[] garfos;
	String nome[] = {"Sócrates", "Platão", "Aristóteles" , "Maquiavel", "Descartes"};

	public Mesa() {
		this.garfos = new boolean[5];
		for(int i = 0 ; i < 5; i++) garfos[i] = true; 

	}

	private boolean statusGarfoDireito(int id) {

		return this.garfos[id];	
	}


	private boolean statusGarfoEsquerdo(int id) {

		if(id == 4) return this.garfos[0];

		return this.garfos[id+1];
	}

	private void devolverGarfoDireito(int id) {
		this.garfos[id] = true;
	}


	private void devolverGarfoEsquerdo(int id) {

		if(id == 4) {

			this.garfos[0] = true;
		}else {

			this.garfos[id+1] = true;
		}
	}

	public synchronized boolean PegaOs2(int id, String nome){
		int idnomedir;
		int idnomeesq;
		if(id == 0) {

			idnomedir = 4;
		}else {

			idnomedir = id-1;
		}

		if(id == 4) {

			idnomeesq = 0;
		}else {

			idnomeesq = id+1;
		}
		if(!statusGarfoEsquerdo(id)){
			System.out.println("O seu garfo ESQUERDO esta sendo usado por " + this.nome[idnomeesq]);
			return false;
		} else if(!statusGarfoDireito(id)){
			System.out.println("O seu garfo DIREITO esta sendo usado por " + this.nome[idnomedir]);
			return false;
		}
		return true;
	}


	public synchronized boolean pegarGarfoDireito(int id, String nome) {
		if(this.garfos[id] == false){
			System.err.println("garfo ESQUERDO esta sendo usado, algo deu errado!!!");
			return false;
		}else{
			this.garfos[id] = false;
			System.out.println(nome + " pegou garfo ESQUERDO");
			return true;
		}

	}


	public synchronized boolean pegarGarfoEsquerdo(int id, String nome) {
		int id_ = id;
		if(id == 4) {
			id_ = 0;
		}else {
			id_ +=1;
		}

		if(this.garfos[id_] == false){
			System.err.println("garfo DIREITO esta sendo usado, algo deu errado!!!");
			return false;
		}else{
			this.garfos[id_] = false;
			System.out.println(nome + " pegou garfo DIREITO");
			return true;
		}
	}

	public synchronized void devolverGarfos(int id, String nome) {

		devolverGarfoEsquerdo(id);
		devolverGarfoDireito(id);

		System.out.println(nome +" Retornou os Garfos");

	}


}