/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.Connection;
import Conection.Conexao;
import Model.funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.ArrayList;
/**
 *
 * @author Reiel
 */
public class FuncionarioDAO {
   private  Connection con =null;
   public FuncionarioDAO(){
     con= Conexao.getConnection();
   }
   public void insert(funcionario funcionario) throws SQLException, Exception{
       String sql="INSERT INTO funcionario (Nome,CPF,NumeroPIS,RG,Login,Senha) VALUES(?,?,?,?,?,MD5(?))";
      PreparedStatement stmt = con.prepareStatement(sql);
       try {
           
           stmt.setString(1, funcionario.getNome());
           stmt.setString(2, funcionario.getCPF());
           stmt.setString(3, funcionario.getNumeroPIS());
           stmt.setString(4, funcionario.getRG());
           stmt.setString(5, funcionario.getLogin());
           stmt.setString(6, funcionario.getSenha());
           stmt.executeUpdate();
           JOptionPane.showMessageDialog(null, "Cadastrado com Suceso!");
           
       } catch (SQLException ex) {
           System.out.println("Erro: "+ ex);
           
       }finally{
               Conexao.closeConnection(con, stmt);
           
       }
   }
   public List<funcionario> listar() throws SQLException{
      
       PreparedStatement stmt=null;
       ResultSet rs=null;
       List<funcionario> funcionarios = new ArrayList<>();
       stmt=con.prepareStatement("SELECT * FROM  funcionario");
       rs=stmt.executeQuery();
       while(rs.next()){
           funcionario f = new funcionario();
           f.setCod(rs.getInt("Cod"));
           f.setCPF(rs.getString("CPF"));
           f.setNome(rs.getString("nome"));
           f.setLogin(rs.getString("Login"));
           f.setNumeroPIS(rs.getString("NumeroPIS"));
           f.setRG(rs.getString("RG"));
           
       funcionarios.add(f);
       
       }
       return funcionarios;
   
   
   }
   public void deletar(funcionario f) throws SQLException, Exception{
        //Connection con = Conexao.getConnection();
        PreparedStatement stmt= null;
        try{
        stmt=con.prepareStatement("DELETE FROM funcionario WHERE Cod=?");
        stmt.setInt(1, f.getCod());
        stmt.executeUpdate();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "erro"+e);
        }finally{
        Conexao.closeConnection(con, stmt);
        }
    }
    public void update(funcionario f) throws Exception {

        //Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE funcionario SET RG = ? ,CPF = ?,nome = ?,NumeroPIS = ? WHERE Cod = ?");
            stmt.setString(1,f.getRG());
            stmt.setString(2,f.getCPF());
            stmt.setString(3,f.getNome());
            stmt.setString(4,f.getNumeroPIS());
            stmt.setInt(5,f.getCod());
            stmt.executeUpdate();

           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            Conexao.closeConnection(con, stmt);
        }

    }
}
