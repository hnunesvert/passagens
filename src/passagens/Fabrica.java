package passagens;

import java.util.ArrayList;

public class Fabrica {

	public static Rota[] inicializacao() {

		ArrayList<Passagem> passagensSP = new ArrayList<Passagem>();
		passagensSP.add(new Passagem("SP001", 800.0));
		passagensSP.add(new Passagem("SP002", 800.0));
		passagensSP.add(new Passagem("SP003", 800.0));
		passagensSP.add(new Passagem("SP004", 800.0));
		passagensSP.add(new Passagem("SP005", 800.0));
		
		Rota SaoPaulo = new Rota("São Paulo", passagensSP);
		
		ArrayList<Passagem> passagensRJ = new ArrayList<Passagem>();
		passagensRJ.add(new Passagem("RJ001", 500.0));
		passagensRJ.add(new Passagem("RJ002", 500.0));
		passagensRJ.add(new Passagem("RJ003", 500.0));
		passagensRJ.add(new Passagem("RJ004", 500.0));
		passagensRJ.add(new Passagem("RJ005", 500.0));
		
		Rota RioJaneiro = new Rota("Rio de Janeiro", passagensRJ);

		ArrayList<Passagem> passagensAC = new ArrayList<Passagem>();
		passagensAC.add(new Passagem("AC001", 250.0));
		passagensAC.add(new Passagem("AC002", 250.0));
		passagensAC.add(new Passagem("AC003", 250.0));
		passagensAC.add(new Passagem("AC004", 250.0));
		passagensAC.add(new Passagem("AC005", 250.0));
		
		Rota Acre = new Rota("Acre", passagensAC);		
		
		Rota[] rotas = {SaoPaulo, RioJaneiro, Acre};
		return rotas;
	}
	
}
