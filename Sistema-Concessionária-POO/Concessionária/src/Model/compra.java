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
public class compra {
    private int cod;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
    private String FK_Cliente_Cod;
    private String FK_Veiculos_Cod;
    private String Forma_Pagamento;
    private String ServicosAdicionais;
    private String Desconto;
    private String Valor_Total;
    private String Chassi;

    public String getFK_Cliente_Cod() {
        return FK_Cliente_Cod;
    }

    public void setFK_Cliente_Cod(String FK_Cliente_Cod) {
        this.FK_Cliente_Cod = FK_Cliente_Cod;
    }

    public String getFK_Veiculos_Cod() {
        return FK_Veiculos_Cod;
    }

    public void setFK_Veiculos_Cod(String FK_Veiculos_Cod) {
        this.FK_Veiculos_Cod = FK_Veiculos_Cod;
    }

    public String getForma_Pagamento() {
        return Forma_Pagamento;
    }

    public void setForma_Pagamento(String Forma_Pagamento) {
        this.Forma_Pagamento = Forma_Pagamento;
    }

    public String getServicosAdicionais() {
        return ServicosAdicionais;
    }

    public void setServicosAdicionais(String ServicosAdicionais) {
        this.ServicosAdicionais = ServicosAdicionais;
    }

    public String getDesconto() {
        return Desconto;
    }

    public void setDesconto(String Desconto) {
        this.Desconto = Desconto;
    }

    public String getValor_Total() {
        return Valor_Total;
    }

    public void setValor_Total(String Valor_Total) {
        this.Valor_Total = Valor_Total;
    }

    public String getChassi() {
        return Chassi;
    }

    public void setChassi(String Chassi) {
        this.Chassi = Chassi;
    }
   
    
}
