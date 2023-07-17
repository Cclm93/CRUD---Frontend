package resteasycrud.service;

import java.util.ArrayList;

import java.util.List;

import javax.ws.rs.NotFoundException;

import resteasycrud.model.User;
import resteasycrud.model.Endereco;
import resteasycrud.model.Telefone;

import Banco.BancodeDados;



public class UserService {

    private List < User > users = new ArrayList < User > ();
        
     
    
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
//////READ all (ou coloca todos os usuários do banco em uma lista intermediária )
    
    public List < User > findAll() {
          
    	BancodeDados  banco = new BancodeDados();
    	banco.conectar();
    	
    	if(banco.estaConectado()) {	
			
    		users = banco.listarUsers();	
			
    		banco.desconectar();
    	}
    	else {
    		System.out.println("não foi possível conectar ao banco de dados!");
    	}
      		
    /*	List < Telefone > telefonesarray = new ArrayList < Telefone > ();
        Endereco bufferendereco = new Endereco("3", "Tijuca", "Rua alguma","34","1202","Rio de Janeiro","Rio de Janeiro", "23467854");
    	Telefone buffertelefone = new Telefone("7","3", "934562345");
    	telefonesarray.add(buffertelefone);
    		       
    	users.add(new User("3", "Amir","solteiro","BR","M","12/04/1988","Professor","ramesh@gmail.com","98734567823",null,null , bufferendereco,telefonesarray ));
    	*/	
        	   		
     return users; 
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////READ by id
    
    public User fetchBy(String id) throws NotFoundException {
        for (User user: findAll()) {
            if (id == user.getId()) {
                return user;
            } else {
                throw new NotFoundException("Resource not found with Id :: " + id);
            }
        }
        return null;
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
         
    
    public boolean create(User user) {
      
    	Endereco bufferendereco = user.getEndereco();
    	BancodeDados  banco = new BancodeDados();
    	banco.conectar();
    	
    	
    		if(banco.estaConectado()) {	
			
    		
    		banco.inserirUser(user.getName(), user.getNasc(),user.getNacionalidade(), user.getSexo(), user.getEstadoCivil(),user.getOcupacao(),user.getEmail(),user.getCPF(),
 /*setar o user id como o id do user*/	user.getId(), bufferendereco.getEstado(),bufferendereco.getCidade(), bufferendereco.getBairro(), bufferendereco.getRua(),bufferendereco.getNumero(),bufferendereco.getComplemento(),bufferendereco.getCEP(),
    	   user.getTelefonesarray());
			   		
    		banco.desconectar();
    		}
    		else {
    			System.out.println("não foi possível conectar ao banco de dados!");
    		}
    	
    	
    	
    	
    	
    	return users.add(user);
    }

    
    
    
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    public boolean update(User user) {//recebe um user que ja tem as informações novas
       
    	
    	Endereco bufferendereco = user.getEndereco();
    	BancodeDados  banco = new BancodeDados();
    	banco.conectar();
    	
    	if(banco.estaConectado()) {	
    		
  		banco.editarUser (user.getId(),user.getName(), user.getNasc(),user.getNacionalidade(), user.getSexo(), user.getEstadoCivil(),user.getOcupacao(),user.getEmail(),user.getCPF(),
  				 /*setar o user id como o id do user*/	user.getId(), bufferendereco.getEstado(),bufferendereco.getCidade(), bufferendereco.getBairro(), bufferendereco.getRua(),bufferendereco.getNumero(),bufferendereco.getComplemento(),bufferendereco.getCEP(),
  	    	   user.getTelefonesarray());
  		
  		banco.desconectar();
    	
  		return true;
    	}
    	else {
			System.out.println("não foi possível conectar ao banco de dados!");
		}
    	
    	    	
    	
        return false;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean delete(String id) throws NotFoundException {
        for (User user: users) {
            if (user.getId().equals(id)) {
                users.remove(user);
                return true;
            }
        }
        return false;
    }
}