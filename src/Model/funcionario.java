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
public class funcionario {
    private int cod;
    private String Nome;
    private String Login;
    private String Senha;
    private String CPF;
    private String RG;
    private String NumeroPIS;
    private int FK_Gerente_Cod;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
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

    public String getNumeroPIS() {
        return NumeroPIS;
    }

    /**
     *
     * @param NumeroPIS
     */
    public void setNumeroPIS(String NumeroPIS) {
        this.NumeroPIS = NumeroPIS;
    }

    public int getFK_Gerente_Cod() {
        return FK_Gerente_Cod;
    }

    public void setFK_Gerente_Cod(int FK_Gerente_Cod) {
        this.FK_Gerente_Cod = FK_Gerente_Cod;
    }

    
    
    
}
