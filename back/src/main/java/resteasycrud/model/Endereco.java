package resteasycrud.model;



import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Endereco {

	
	 private String userid;
	 private String bairro;
	 private String rua;
	 private String numero;
	 private String complemento;
	 private String cidade;
	 private String estado;
	 private String cep;
	
	
	 
	 public Endereco(String userid, String bairro,String rua,String numero, String complemento,String cidade, String estado, String cep) {
	       
		 this.userid = userid;
		 this.bairro = bairro;
		 this.rua = rua;
	     this.numero = numero;
	     this.complemento = complemento;
	     this.cidade = cidade;
	     this.estado = estado;
	     this.cep = cep;
	 
	 
	 }
	 
	 
	 public String getUserid() {
	        return userid;
	 }

	 public void setUserid(String userid ) {
	        this.userid =userid ;
	 } 
	 
	 	 
	 public String getBairro() {
	        return bairro;
	 }

	 public void setBairro(String bairro ) {
	        this.bairro =bairro ;
	 } 
	 
	 public String getRua() {
	        return rua;
	    }

	    public void setRua(String rua) {
	        this.rua = rua ;
	    }
	    
	    public String getNumero() {
	        return numero;
	    }

	    public void setNumero(String numero) {
	        this.numero = numero;
	    }
	    
	    public String getComplemento() {
	        return complemento;
	    }

	    public void setComplemento(String complemento) {
	        this.complemento = complemento;
	    }
	    
	    public String getCidade() {
	        return cidade;
	    }

	    public void setCidade (String cidade ) {
	        this.cidade = cidade;
	    }

	    public String getCEP() {
	        return cep;
	    }

	    public void setCEP(String cep) {
	        this.cep = cep ;
	    }
	    
	    public String getEstado() {
	        return estado;
	    }

	    public void setEstado (String estado) {
	        this.estado= estado ;
	    }
	    
	    @Override
	    public String toString() {
	        return "Endereco [ userid=" + userid + ", bairro=" + bairro+ ", rua=" + rua + ", numero=" + numero + 
	        		", complemento=" + complemento + ", cidade=" + cidade + ", estado=" + estado + 
	        		", cep=" + cep+ "]";
	    }
	}


