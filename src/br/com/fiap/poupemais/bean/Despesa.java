package br.com.fiap.poupemais.bean;

import java.util.Calendar;

public class Despesa {

    private int idDespesa;
    private String dsDespesa;
    private double vlrDespesa;
    private Calendar dtDespesa;
    private String tpDespesa;
    private int idUsuario;
    public Despesa(int idDespesa, String dsDespesa, double vlrDespesa, Calendar dtDespesa, String tpDespesa, int idUsuario) {
    	super();
    	this.idDespesa = idDespesa;
    	this.dsDespesa = dsDespesa;
        this.vlrDespesa = vlrDespesa;
        this.dtDespesa = dtDespesa;
        this.tpDespesa = tpDespesa;
        this.idUsuario = idUsuario;
    }


    public Despesa(String dsDespesa, double vlrDespesa, Calendar data, String tpDespesa, int idUsuario) {
    	super();
        this.dsDespesa = dsDespesa;
        this.vlrDespesa = vlrDespesa;
        this.dtDespesa = data;
        this.tpDespesa = tpDespesa;
        this.idUsuario = idUsuario;
    }



    public int getIdDespesa() {
        return idDespesa;
    }

    public void setIdDespesa(int idDespesa) {
        this.idDespesa = idDespesa;
    }

    public String getDsDespesa() {
        return dsDespesa;
    }

    public void setDsDespesa(String dsDespesa) {
        this.dsDespesa = dsDespesa;
    }

    public double getVlrDespesa() {
        return vlrDespesa;
    }

    public void setVlrDespesa(double vlrDespesa) {
        this.vlrDespesa = vlrDespesa;
    }

    public Calendar getDtDespesa() {
        return dtDespesa;
    }

    public void setDtDespesa(Calendar dtDespesa) {
        this.dtDespesa = dtDespesa;
    }

    public String getTpDespesa() {
        return tpDespesa;
    }

    public void setTpDespesa(String tpDespesa) {
        this.tpDespesa = tpDespesa;
    }
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }


    @Override
    public String toString() {
        return
                "idDespesa=" + idDespesa +
                        ", dsDespesa='" + dsDespesa + '\'' +
                        ", vlrDespesa=" + vlrDespesa +
                        ", dtDespesa=" + dtDespesa +
                        ", tpDespesa='" + tpDespesa + 
                        ", IdUsuario='" + idUsuario +
                        '\''
                ;
    }


}