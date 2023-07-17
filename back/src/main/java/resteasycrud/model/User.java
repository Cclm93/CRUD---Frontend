package resteasycrud.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import resteasycrud.model.Endereco;
import resteasycrud.model.Telefone;


@XmlRootElement
public class User {
    private String id;
    private String name;
    private String estadocivil;
    private String nacionalidade;
    private String sexo;
    private String nasc;
    private String ocupacao;
    private String email;
    private String cpf;
    private String cadastradoem;
    private String modificadoem;
    private Endereco endereco;
	private  List < Telefone > telefonesarray = new ArrayList < Telefone > ();
    
    

    public User() {

    }

    public User(String id, String name , String estadocivil,String nacionalidade,
    		String sexo , String nasc, String ocupacao ,String email,String cpf, String cadastradoem, String modificadoem,
    		 Endereco endereco , List<Telefone> telefonesarray ){
       
    	super();
        this.id = id;
        this.name = name;
        this.estadocivil = estadocivil;
        this.nacionalidade = nacionalidade;
        this.sexo = sexo;
        this.nasc = nasc;
        this.ocupacao = ocupacao;
        this.email = email;
        this.cpf = cpf;
        this.cadastradoem = cadastradoem;
        this.modificadoem = modificadoem;
        this.endereco = endereco;
        this.telefonesarray = telefonesarray;
       
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEstadoCivil() {
        return estadocivil;
    }

    public void setEstadoCivil(String estadocivil) {
        this.estadocivil = estadocivil;
    }
            
    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade (String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
    
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo ) {
        this.sexo = sexo ;
    }
    
    public String getNasc() {
        return nasc;
    }

    public void setNasc (String nasc) {
        this.nasc = nasc;
    }
    
    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }
        
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
        
    public String getCPF() {
        return cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf ;
    }
    
    public String getCadastradoem() {
        return cadastradoem;
    }

    public void setCadastradoem (String cadastradoem) {
        this.cadastradoem= cadastradoem ;
    }
   
    public String getModificadoem() {
        return modificadoem;
    }

    public void setModificadoem (String modificadoem) {
        this.modificadoem= modificadoem ;
    }
    
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco (Endereco endereco) {
        this.endereco =endereco;
    }
    
    public List<Telefone> getTelefonesarray() {
        return telefonesarray;
    }

    public void setTelefonesarray (Telefone telefone) {
        this.telefonesarray.add(telefone);   }
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", email=" + email +", estadocivil=" + estadocivil+
        		 ", nacionalidade=" + nacionalidade + ", sexo=" + sexo +", nasc=" + nasc +", ocupacao=" + ocupacao+   ", cpf=" + cpf +"cadastradoem="+ cadastradoem + "modificadoem="+modificadoem +"]";
    }
}