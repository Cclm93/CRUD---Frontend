package Banco;

import Banco.BancodeDados;

public class testebanco {
	public static void  main(String[] args) {
		BancodeDados  banco = new BancodeDados();
		banco.conectar();
		
	if(banco.estaConectado()) {	
		//banco.listarUsers();
	//banco.inserirUser("pablo","1975-07-25", "BR" , "M" , "Solteiro", "Mecanico" , "pauloemail@email.com","12345678234" , "7","MA", "nem sei", "mais algum" , "rua algum expert","20" , "234", "09834565" , "034561234");
	//	banco.editarUser ("8","ada","1988-08-08", "BR" , "F" , "Solteira", "Médica" , "adaanal@email.com","12345678234" , "6","BA", "nem sei+", "mais algum+" , "rua algum expert+","200" , "2340", "09834560" , "000000000");
	   banco.apagarUser("6");
	   banco.listarUsers();
	    
	   banco.desconectar();
	}
	else {
		System.out.println("não foi possível conectar ao banco de dados!");
	}
	}
}
