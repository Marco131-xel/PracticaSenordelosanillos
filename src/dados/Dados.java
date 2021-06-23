package src.dados;



public class Dados{
	
	public Dados(){
	}
	
	public static int lanzarDados(int valMinimo, int valMaximo, int totalDados, boolean verMensaje){
		int dado = valMinimo;
        int resultado = valMinimo;
        for (int i = 1; i <= totalDados; i++) {
            dado =(int) Math.floor(Math.random()*(valMaximo-valMinimo+1)+valMinimo);
            if (verMensaje)
                System.out.println("Se lanzó el "+i+" dado y su resultado fue: "+ dado);
            if (resultado < dado)
                resultado = dado;
        }
        if (totalDados > 1)
            if (verMensaje)
                System.out.println("El resultado mayor de los "+totalDados + " lanzados es: "+resultado);
        return resultado;
	}
	
}