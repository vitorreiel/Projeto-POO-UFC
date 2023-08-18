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
public class cliente {
    private int cod;
    private String Primeiro_Nome;
    private String Segundo_Nome;
    private String Ultimo_Nome;
    private String CPF;
    private String RG;
    private String Login;
    private String Senha;
    private String CNH;
    private String Cidade;
    private String Estado;
    private int FK_Funcionario_Cod;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getPrimeiro_Nome() {
        return Primeiro_Nome;
    }

    public void setPrimeiro_Nome(String Primeiro_Nome) {
        this.Primeiro_Nome = Primeiro_Nome;
    }

    public String getSegundo_Nome() {
        return Segundo_Nome;
    }

    public void setSegundo_Nome(String Segundo_Nome) {
        this.Segundo_Nome = Segundo_Nome;
    }

    public String getUltimo_Nome() {
        return Ultimo_Nome;
    }

    public void setUltimo_Nome(String Ultimo_Nome) {
        this.Ultimo_Nome = Ultimo_Nome;
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

    public String getCNH() {
        return CNH;
    }

    public void setCNH(String CNH) {
        this.CNH = CNH;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public int getFK_Funcionario_Cod() {
        return FK_Funcionario_Cod;
    }

    public void setFK_Funcionario_Cod(int FK_Funcionario_Cod) {
        this.FK_Funcionario_Cod = FK_Funcionario_Cod;
    }
    
    
    
}
