package passagens;

public class Fabrica {

	public static Rota[] inicializacao() {

		Passagem[] passagensSP = {
			new Passagem("SP001", 800.0), 
			new Passagem("SP002", 800.0), 
			new Passagem("SP003", 800.0), 
			new Passagem("SP004", 800.0), 
			new Passagem("SP005", 800.0)
		};
		Rota SaoPaulo = new Rota("São Paulo", passagensSP);
		
		Passagem[] passagensRJ = {
			new Passagem("RJ001", 500.0), 
			new Passagem("RJ002", 500.0), 
			new Passagem("RJ003", 500.0), 
			new Passagem("RJ004", 500.0), 
			new Passagem("RJ005", 500.0)
		};
		Rota RioJaneiro = new Rota("Rio de Janeiro", passagensRJ);

		Passagem[] passagensAC = {
				new Passagem("AC001", 250.0), 
				new Passagem("AC002", 250.0), 
				new Passagem("AC003", 250.0), 
				new Passagem("AC004", 250.0), 
				new Passagem("AC005", 250.0)
			};
		Rota Acre = new Rota("Acre", passagensAC);		
		
		Rota[] rotas = {SaoPaulo, RioJaneiro, Acre};
		return rotas;
	}
	
}
