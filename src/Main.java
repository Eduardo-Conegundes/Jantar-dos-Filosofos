/* Dupla: André Teixeira
	  Luiz Eduardo Oliveira*/

package src;

public class Main {

	private static void init(Mesa mesa) {
		String nome[] = {"Sócrates", "Platão","Aristóteles","Maquiavel", "Descartes"};
		for (int i = 0; i < 5; i++) {
			new Filosofo(mesa, i, nome[i]).start();
		}
	}

	public static void main(String[] args) {

		Mesa mesa = new Mesa();

		init(mesa);




	}
}
