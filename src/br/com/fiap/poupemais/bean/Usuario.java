package br.com.fiap.poupemais.bean;
import java.util.Calendar;

import br.com.fiap.poupemais.util.CriptografiaUtils;

public class Usuario {
	private int idUsuario;
    private String nmUsuario;
    private String dsEmail;
    private Calendar dtNascimento;
    private String senha;
    private String nmrCelular;
    
    public Usuario(int idUsuario, String nmUsuario, String dsEmail, Calendar dtNascimento, String senha, String nmrCelular) {
    	super();
    	 this.idUsuario = idUsuario;
         this.nmUsuario = nmUsuario;
         this.dsEmail = dsEmail;
         this.dtNascimento = dtNascimento;
         setSenha(senha);
         this.nmrCelular = nmrCelular;
    }
	
    public Usuario( String nmUsuario, String dsEmail, Calendar dtNascimento, String senha, String nmrCelular) {
    	super();
         this.nmUsuario = nmUsuario;
         this.dsEmail = dsEmail;
         this.dtNascimento = dtNascimento;
         setSenha(senha);
         this.nmrCelular = nmrCelular;
    }
    
    public Usuario(int idUsuario, String nmUsuario, String dsEmail, Calendar dtNascimento) {
    	super();
    	 this.idUsuario = idUsuario;
         this.nmUsuario = nmUsuario;
         this.dsEmail = dsEmail;
         this.dtNascimento = dtNascimento;
    }
    
    public Usuario(String nmUsuario, String dsEmail, Calendar dtNascimento) {
    	super();
         this.nmUsuario = nmUsuario;
         this.dsEmail = dsEmail;
         this.dtNascimento = dtNascimento;
    }
    
    public Usuario() {
    	super();
    }
    
    public int getidUsuario() {
    	return idUsuario;
    }
    
    public void setIdUsuario(int idUsuario) {
    	this.idUsuario = idUsuario;
    }
    
    public String getNmUsuario() {
    	return nmUsuario;
    }
    
    public void setNmUsuario(String nmUsuario) {
    	this.nmUsuario = nmUsuario;
    }
    
    public String getDsEmail() {
    	return dsEmail;
    }
    
    public void setDsEmail(String dsEmail) {
    	this.dsEmail = dsEmail;
    }
    
    public Calendar getDtNascimento() {
    	return dtNascimento;
    }
    
    public void setDtNascimento(Calendar dtNascimento) {
    	this.dtNascimento = dtNascimento;
    }
    
    public String getSenha() {
    	return senha;
    }
    
    public void setSenha(String senha) {
    	try {
    		this.senha = CriptografiaUtils.criptografar(senha);
    	}catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public String getNmrCelular() {
    	return nmrCelular;
    }
    
    public void setNmrCelular(String nmrCelular) {
    	this.nmrCelular = nmrCelular;
    }

    public String toString() {
        return
                "idDespesa=" + idUsuario +
                        ", nmUsuario='" + nmUsuario + '\'' +
                        ", dsEmail=" + dsEmail +
                        ", dtNascimento=" + dtNascimento +
                        ", senha='" + senha + 
                        ", nmrCelular='" + nmrCelular +
                        '\''
                ;
    }


}

    
