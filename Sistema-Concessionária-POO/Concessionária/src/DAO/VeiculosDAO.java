/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.Connection;
import Conection.Conexao;
import Model.veiculos;
import java.awt.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Reiel
 */
public class VeiculosDAO {
   private  Connection con =null;
   public VeiculosDAO(){
     con= Conexao.getConnection();
   }
   public void insert(veiculos veiculo) throws SQLException, Exception{
       String sql="INSERT INTO veiculos (Modelo,Ano,Fabricante,Cor,Chassi,Preco) VALUES(?,?,?,?,?,?)";
      PreparedStatement stmt = con.prepareStatement(sql);
       try {
           
           stmt.setString(1,veiculo.getModelo());
           stmt.setString(2,veiculo.getAno());
           stmt.setString(3, veiculo.getFabricante());
           stmt.setString(4, veiculo.getCor());
           stmt.setString(5, veiculo.getChassi());
           stmt.setString(6, veiculo.getPreco());
           stmt.executeUpdate();
           JOptionPane.showMessageDialog(null, "Cadastrado com Suceso!");
           
       } catch (SQLException ex) {
           System.out.println("Erro: "+ ex);
           
       }finally{
               Conexao.closeConnection(con, stmt);
           
       }
   }
   public ArrayList<veiculos> listarVeiculos() throws SQLException{
		ArrayList<veiculos> listarveiculos = new ArrayList<>();
		
		String sql = "Select * from veiculos";
		veiculos veiculo = null ;
		
		try(PreparedStatement preparedStatement = con.prepareStatement(sql)) {
			
			ResultSet result = preparedStatement.executeQuery();
			
			/*
			 * Dentro do while estou verificando se tem registro no banco de dados, enquanto tiver registro vai 
			 * adcionando um a um na lista e no final fora do while retorna todos os registro encontrados. 
			 */
			while(result.next()){
				veiculo = new veiculos();
				veiculo.setCod(result.getString("Cod"));
                                veiculo.setCor(result.getString("Cor"));
                                veiculo.setAno(result.getString("Ano"));
                                veiculo.setFabricante(result.getString("Fabricante"));
                                veiculo.setModelo(result.getString("Modelo"));
                                veiculo.setChassi(result.getString("Chassi"));
                                veiculo.setPreco(result.getString("Preco"));
                                
				// Adcionando cada registro encontro, na lista .
				listarveiculos.add(veiculo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listarveiculos;
	}
  
    public void deletar(veiculos v) throws SQLException, Exception{
        //Connection con = Conexao.getConnection();
        PreparedStatement stmt= null;
        try{
        stmt=con.prepareStatement("DELETE FROM veiculos WHERE Cod=?");
        stmt.setString(1, v.getCod());
        stmt.executeUpdate();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "erro"+e);
        }finally{
        Conexao.closeConnection(con, stmt);
        }
    }
    public void update(veiculos v) throws Exception {

        //Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE veiculos SET Modelo = ? ,Ano = ?,Fabricante = ?,Cor = ?,Chassi = ?,Preco = ? WHERE Cod = ?");
            stmt.setString(1, v.getModelo());
            stmt.setString(2, v.getAno());
            stmt.setString(3, v.getFabricante());
            stmt.setString(4, v.getCor());
            stmt.setString(5, v.getChassi());
            stmt.setString(6, v.getPreco());
            stmt.setString(7, v.getCod());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            Conexao.closeConnection(con, stmt);
        }

    }

}
