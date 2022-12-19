package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Reiel
 */
public class gerente {
    private int Cod;
    private String Nome;
    private String Login;
    private String Senha;
    private String CPF;
    private String RG;
    private int FK_Admin_Cod;

    public int getCod() {
        return Cod;
    }

    public void setCod(int Cod) {
        this.Cod = Cod;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public int getFK_Admin_Cod() {
        return FK_Admin_Cod;
    }

    public void setFK_Admin_Cod(int FK_Admin_Cod) {
        this.FK_Admin_Cod = FK_Admin_Cod;
    }
    
    
    
}
