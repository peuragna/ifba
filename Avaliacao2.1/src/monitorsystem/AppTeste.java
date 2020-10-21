package monitorsystem;

import gui.JMonitor;
import persistence.*;

class AppTeste {
	private Sistema sistema = new Sistema(new MemUnity());
	private JMonitor ui;
	
	public AppTeste() {
		this.ui = new JMonitor(this.sistema);
	};
	
	public void run() throws Exception {
		this.asm();
		this.ui.run();
	};

	private void asm() throws Exception {
		this.sistema.addUnidadeEuclidiana("2", 20, 4, true, false, false, false);
		this.sistema.addUnidadeManhattan("3", 3, 17, true, true, false, false);
		this.sistema.addUnidadeManhattan("4", 1, 5, false, true, true, false);
		this.sistema.addUnidadeEuclidiana("5", 9, 7, false, true, true, false);
		this.sistema.addUnidadeManhattan("6", 6, 16, true, true, true, true);
		this.sistema.addUnidadeManhattan("7", 4, 14, true, true, true, true);
	};
	
	public static void main(String[] args) throws Exception {
		(new AppTeste()).run();
		System.out.println("Finalizando...");
	};
}