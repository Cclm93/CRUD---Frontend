package resteasycrud.model;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Telefone {

	private String telefoneid;
	private String userid;
    private String telefone;

	
  	
    public Telefone(String telefoneid,String userid , String telefone) {
    	
    	this.telefoneid= telefoneid;
    	this.userid = userid;
    	this.telefone = telefone;
    
    	    	
    }
	
    
    public String getTelefoneid() {
        return telefoneid;
    }

    public void setTelefoneid (String telefoneid) {
        this.telefoneid= telefoneid ;
    }
    
    
    public String getUserid() {
        return userid;
    }

    public void setUserid (String userid) {
        this.userid= userid ;
    }
    
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone (String telefone) {
        this.telefone= telefone ;
    }
    
    @Override
    public String toString() {
        return "Telefone [telefoneid="+telefoneid +"userid=" + userid + ", telefone=" + telefone +"]";
    }
     
    
}
