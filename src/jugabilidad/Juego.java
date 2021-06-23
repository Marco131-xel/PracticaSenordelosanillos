package src.jugabilidad;

import src.combatientes.*;
import src.dados.*;

public class Juego{
	
	private Bestias ejercitoMalos[];
	private Heroes ejercitoBuenos[];
	
	private final int CANTIDAD = 5;
	 
	public Juego(){
		ejercitoMalos = new Bestias[CANTIDAD];
		ejercitoBuenos = new Heroes[CANTIDAD];
	}
	
	public void visualizarCombatientes(Combatientes ejercito[]){
		 if (ejercito.length> 0 ){
			String tempo = "";
			if (ejercito[0] instanceof Bestias){
				tempo = "Bestia";
			}
			else{
				tempo = "Heroe";
			}
			System.out.println("\nPreparando Ejercito de "+tempo);
			for (int i = 0; i < ejercito.length; i++) {
					ejercito[i].saludar();
			}
		}
		else {
			System.out.println("No hay un ejercito ");
		}
    }	
	
	public void jugar(){
        System.out.println("\n\n***Bienvenido al juego del señor de los anillos*** \n\n");
        
        this.inicializarHeroes();
        this.inicializarBestias();

        this.visualizarCombatientes(ejercitoMalos);
        this.visualizarCombatientes(ejercitoBuenos);

		System.out.println("\n\n\n");
        System.out.println("***Primera Batalla***");
        this.iniciarBatalla();
        System.out.println("\n\n\n");
        System.out.println("***Segunda Batalla***");
        this.iniciarBatalla();
        System.out.println("\n\n\n");
        System.out.println("***Tercera Batalla***");
        this.iniciarBatalla();
    }

    public void iniciarBatalla(){
        ejercitoMalos[0].recibirAtaque(ejercitoBuenos[0]);
        ejercitoBuenos[0].recibirAtaque(ejercitoMalos[0]);
    }

    public void inicializarHeroes(){
        int random = 0;
        for (int i = 0; i < ejercitoBuenos.length; i++) {
            random = Dados.lanzarDados(0, 2, 1, false);
            switch (random) {
                case 0:
                    ejercitoBuenos[i] = new Humanos("Humano "+Humanos.getInstancias());
                    break;
                case 1:
                    ejercitoBuenos[i] = new Elfos("Elfo "+Elfos.getInstancias());
                    break;
                case 2:
                    ejercitoBuenos[i] = new Hobbits("Hobbit "+Hobbits.getInstancias());
                    break;
                default:
                    ejercitoBuenos[i] = new Elfos("Elfo "+Elfos.getInstancias());
                    break;
            }
        }
    }

    public void inicializarBestias(){
        int random = 0;
        for (int i = 0; i < ejercitoBuenos.length; i++) {
            random = Dados.lanzarDados(0, 1, 1, false);
            switch (random) {
                case 0:
                    ejercitoMalos[i] = new Trasgos("Trasgo "+Trasgos.getInstancias());
                    break;
                case 1:
                    ejercitoMalos[i] = new Orcos("Orco "+Orcos.getInstancias());
                    break;
                default:
                    ejercitoMalos[i] = new Orcos("Orco "+Orcos.getInstancias());
                    break;
            }
        }
    }
}