package Banco;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import resteasycrud.model.User;
import resteasycrud.model.Endereco;
import resteasycrud.model.Telefone;

public class BancodeDados {
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultset = null;
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public void conectar() {
		
		String servidor = "jdbc:mysql://127.0.0.1:3306/cruddb";
		String usuario = "root";
		String senha = "qwe123QWE!@#";
		String driver = "com.mysql.jdbc.Driver";
		
		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor ,usuario , senha);
			this.statement = this.connection.createStatement();
		} catch (Exception e ) {
			System.out.println ("Erro:" + e.getMessage());
		}
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public boolean estaConectado() {
		if( this.connection  != null) {
			return true;
		} else {
			return false;
		}
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
////READ	
	
	public List < User > listarUsers() {
		 
		List < User > usersarray = new ArrayList < User > ();
	
			
try {
	String queryid = "SELECT id FROM users;";
	List <String>listaids = new ArrayList <String>();
	this.resultset = this.statement.executeQuery(queryid);
	
	while(this.resultset.next()) {
		
		listaids.add(this.resultset.getString("id"));
	}
	
		
	for(int i = 0; i < listaids.size(); i++)
	{
			
		try {
			
					
			String query1 = "SELECT * FROM users WHERE id ="+ listaids.get(i)+ " ;";
						
			this.resultset = this.statement.executeQuery(query1);
			while(this.resultset.next()) { // começa a checar os usuários um por um e montar a estrutura em java vinda do DB.
			
			User bufferuser = new User();
							
			bufferuser.setId(this.resultset.getString("id"));	//começa a montar um usuário
			bufferuser.setName(this.resultset.getString("nome"));	
			bufferuser.setNasc(this.resultset.getString("nascimento"));

			 if (this.resultset.getString("nacionalidade") != null) {
	        	bufferuser.setNacionalidade(this.resultset.getString("nacionalidade"));
	         }	
			
			 bufferuser.setEstadoCivil(this.resultset.getString("estado_civil"));
				
			 if (this.resultset.getString("ocupacao") != null) {
	        	bufferuser.setOcupacao(this.resultset.getString("ocupacao"));
	         }
			 
			 bufferuser.setEmail(this.resultset.getString("email"));
			 bufferuser.setCPF(this.resultset.getString("cpf"));
			 bufferuser.setCadastradoem( this.resultset.getString("cadastrado_em"));
			 bufferuser.setModificadoem(this.resultset.getString("modificado_em"));
		
			
			 System.out.println("ENTROU NO LOOP USERS PARA O USER : " + bufferuser.getName());	
			
			 
			 				//monta o endereço 
			
						 try {
								String query2 = "SELECT * FROM endereco WHERE user_id = "+ bufferuser.getId() +" ;";
			
								this.resultset = this.statement.executeQuery(query2);
								while(this.resultset.next()) {
								Endereco bufferendereco = new Endereco(null, null, null, null, null, null, null, null);
								
								System.out.println("ENTROU NO LOOP ENDERECO");	
								
						        bufferendereco.setUserid(this.resultset.getString("user_id"));	
								bufferendereco.setEstado(this.resultset.getString("estado"));
								bufferendereco.setCidade(this.resultset.getString("cidade"));
								bufferendereco.setBairro(this.resultset.getString("bairro"));
								bufferendereco.setRua(this.resultset.getString("rua"));
								bufferendereco.setNumero( this.resultset.getString("numero"));
								
								if (this.resultset.getString("complemento") != null) {
							       bufferendereco.setComplemento(this.resultset.getString("complemento"));	 
						        }
								
								bufferendereco.setCEP(this.resultset.getString("cep"));
									
								//atribui o endereco ao user em questão
								bufferuser.setEndereco(bufferendereco); 
								}
							}  catch (Exception e ) {
								System.out.println ("Erro:" + e.getMessage());
							}
						
						
						 
						 //monta o arraylist de telefones
			
						 try {
								String query3 = "SELECT * FROM telefone WHERE user_id ="+ bufferuser.getId() +";";
								this.resultset = this.statement.executeQuery(query3);
								while(this.resultset.next()) { //procura todos os telefones pertencentes ao user
									
									Telefone buffertelefone = new Telefone(null,null, null);
									
									//System.out.println(" 0)Array de telefone  no inicio do loop:" + bufferuser.getTelefonesarray() );
									
									
															
									buffertelefone.setTelefoneid(this.resultset.getString("telefone_id"));
									buffertelefone.setUserid(this.resultset.getString("user_id"));
									buffertelefone.setTelefone( this.resultset.getString("telefone"));
									
									System.out.println(" 1)ENTROU NO LOOP TELEFONE para:" + buffertelefone.getTelefone() );
								//	System.out.println(" 2)Array de telefone  antes de add:" + bufferuser.getTelefonesarray() );
							
									//adiciona cada telefone pertencente ao usuário no array dele		
									bufferuser.setTelefonesarray(buffertelefone);
									
									
								//	System.out.println("3)Array de telefone até agr:" + bufferuser.getTelefonesarray() );
									
																}
							}  catch (Exception e ) {
								System.out.println ("Erro:" + e.getMessage());
							}
			
						 
			//adiciona o usuário montado na lista de usuários			 
			usersarray.add(bufferuser);
			
			}	
		
		
		}	
			catch (Exception e ) {
			System.out.println ("Erro:" + e.getMessage());
		}		
	}	
		
}  catch (Exception e ) {
	System.out.println ("Erro:" + e.getMessage());
}

			
		
		
		
	System.out.println(usersarray);
	return usersarray;
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
///CREATE	
	public void inserirUser(

/*user*/
	
			  String nome,
              String nascimento, 
              String nacionalidade, 
              String sexo,
			  String estadocivil, 
			  String ocupacao,
			  String email,
			  String cpf,
			  
/*endereco*/
			  String userid,
			  String estado,
			  String cidade,
			  String bairro,
			  String rua,
			  String numero,
			  String complemento,
			  String CEP,
/*telefone*/			  
			  List<Telefone> listatelefones) {
		
			
		
		try {
			String query = "INSERT INTO users (nome , nascimento , nacionalidade , sexo , estado_civil, ocupacao, email, cpf , cadastrado_em ,modificado_em) VALUES ('" + nome + "','"+ nascimento + "','"+ nacionalidade + "','"+ sexo + "','"+ estadocivil + "','"+ ocupacao + "','"+ email+ "','"+ cpf + "', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);";
			this.statement.executeUpdate(query);
		} catch (Exception e ) {
			System.out.println ("Erro:" + e.getMessage());
		}		
	
		try {
			String query = "INSERT INTO endereco (user_id , estado , cidade, bairro, rua , numero, complemento, CEP) VALUES ('" + userid + "','"+ estado + "','"+ cidade + "','"+ bairro + "','"+ rua + "','"+ numero + "','"+ complemento+ "','"+ CEP +"');";
			this.statement.executeUpdate(query);
		} catch (Exception e ) {
			System.out.println ("Erro:" + e.getMessage());
		}	
	
		
		for(int i = 0; i < listatelefones.size(); i++)
		{
		   
		    try {
				String query = "INSERT INTO telefone (user_id , telefone ) VALUES ('" + userid + "','"+ listatelefones.get(i).getTelefone() +"');";
				this.statement.executeUpdate(query);
			} catch (Exception e ) {
				System.out.println ("Erro:" + e.getMessage());
			}	
		
		}			
	
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
///UPDATE	
	
	public void editarUser(

			String id,
		/*users*/
			String nome,
			String nascimento, 
			String nacionalidade, 
			String sexo,
			String estadocivil, 
			String ocupacao,
			String email,
			String cpf,
			
		/*endereco*/
			String userid,
			String estado,
			String cidade,
			String bairro,
			String rua,
			String numero,
			String complemento,
			String CEP,
		/*telefone*/			  
			List<Telefone> listatelefones) {
				try {
					String query = "UPDATE users SET nome = '" + nome + "', nascimento = '"+ nascimento +"', nacionalidade = '"+ nacionalidade +"', sexo = '"+ sexo +"', estado_civil = '"+ estadocivil +"', ocupacao = '"+ ocupacao +"', email = '"+ email +"', cpf= '"+ cpf +"', modificado_em = CURRENT_TIMESTAMP WHERE id = "+ id + ";";
					this.statement.executeUpdate(query);
				} catch (Exception e ) {
					System.out.println ("Erro:" + e.getMessage());
				}
				
				try {
					String query = "UPDATE endereco SET user_id = '" + userid + "', estado = '"+ estado +"', cidade = '"+ cidade +"', bairro = '"+ bairro +"', rua = '"+ rua +"', numero = '"+ numero +"', complemento= '"+ complemento +"', CEP = '"+ CEP +"' WHERE user_id = "+ userid + ";";
					this.statement.executeUpdate(query);
				} catch (Exception e ) {
					System.out.println ("Erro:" + e.getMessage());
				}	

			
				for(int i = 0; i < listatelefones.size(); i++)
				{
				
				try {
					String query = "UPDATE telefone SET telefone = '"+ listatelefones.get(i).getTelefone() +"' WHERE telefone_id = "+listatelefones.get(i).getTelefoneid() + ";";
					this.statement.executeUpdate(query);
				} catch (Exception e ) {
					System.out.println ("Erro:" + e.getMessage());
				}	

				}
				
			} 
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
///DELETE	
	public void apagarUser (String id) {
			
		
		try {
			String query = "DELETE FROM endereco WHERE user_id = " + id + ";";
			this.statement.executeUpdate(query);
		}  catch (Exception e ) {
			System.out.println ("Erro:" + e.getMessage());
		}	
		

		try {
			String query = "DELETE FROM telefone WHERE user_id = " + id + ";";
			this.statement.executeUpdate(query);
		}  catch (Exception e ) {
			System.out.println ("Erro:" + e.getMessage());
		}	
		
		try {
			String query = "DELETE FROM users WHERE id = " + id + ";";
			this.statement.executeUpdate(query);
		}  catch (Exception e ) {
			System.out.println ("Erro:" + e.getMessage());
		}	
		
		
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public void desconectar() {
		try {
			this.connection.close();
		} catch (Exception e ) {
			System.out.println ("Erro:" + e.getMessage());
		}		
		
		
	}
	
	
	
	
}
