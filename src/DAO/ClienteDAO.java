/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import Conection.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Model.cliente;
/**
 *
 * @author Reiel
 */
public class ClienteDAO {
   private  Connection con =null;
   public ClienteDAO(){
     con= Conexao.getConnection();
   }

    /**
     *
     * @param cliente
     * @throws SQLException
     * @throws Exception
     */
    public void insert(cliente cliente) throws SQLException, Exception{
       String sql="INSERT INTO cliente (Primeiro_Nome,Segundo_Nome,Ultimo_Nome,CPF,RG,CNH,Cidade,Estado,Login,Senha) VALUES(?,?,?,?,?,?,?,?,?,MD5(?))";
      PreparedStatement stmt = con.prepareStatement(sql);
       try {
           stmt.setString(1,cliente.getPrimeiro_Nome());
           stmt.setString(2,cliente.getSegundo_Nome());
           stmt.setString(3, cliente.getUltimo_Nome());
           stmt.setString(4,cliente.getCPF());
           stmt.setString(5,cliente.getRG());
           stmt.setString(6,cliente.getCNH());
           stmt.setString(7, cliente.getCidade());
           stmt.setString(8,cliente.getEstado());
           stmt.setString(9, cliente.getLogin());
           stmt.setString(10, cliente.getSenha());
           stmt.executeUpdate();
           JOptionPane.showMessageDialog(null, "Cadastrado com Suceso!");
           
       } catch (SQLException ex) {
           System.out.println("Erro: "+ ex);
           
       }finally{
            Conexao.closeConnection(con, stmt);
       }
    }

    /**
     *
     * @return 
     * @throws java.sql.SQLException 
     */
    public List<cliente> listar() throws SQLException, Exception{
        PreparedStatement stmt = null;
        ResultSet rs=null;

        List<cliente> clientes;
            clientes = new ArrayList<>();
        try{
            String sql="SELECT * FROM cliente";
            stmt=con.prepareStatement(sql);
            rs=stmt.executeQuery();
            while(rs.next()){
                cliente c= new cliente();
                c.setCod(rs.getInt("Cod"));
                c.setCNH(rs.getString("CNH"));
                c.setPrimeiro_Nome(rs.getString("Primeiro_Nome"));
                c.setSegundo_Nome(rs.getString("Segundo_Nome"));
                c.setUltimo_Nome(rs.getString("Ultimo_Nome"));
                c.setCidade(rs.getString("Cidade"));
                c.setEstado(rs.getString("Estado"));
                c.setRG(rs.getString("RG"));
                c.setCPF(rs.getString("CPF"));
                c.setSenha(rs.getString("Login"));
                clientes.add(c);
            }
            return clientes;
        } catch(SQLException e){
            System.out.println(e);
            return null;
        } finally {
            Conexao.closeConnection(con,stmt,rs);
        }
    }
    
    public void deletar(cliente c) throws SQLException, Exception{
        //Connection con = Conexao.getConnection();
        PreparedStatement stmt= null;
        try{
        stmt=con.prepareStatement("DELETE FROM cliente WHERE Cod=?");
        stmt.setInt(1, c.getCod());
        stmt.executeUpdate();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "erro"+e);
        }finally{
        Conexao.closeConnection(con, stmt);
        }
    }
    public void update(cliente c) throws Exception {

        //Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE cliente SET Primeiro_Nome = ? ,Segundo_Nome = ?,Ultimo_Nome = ?,CPF = ?,RG = ?,CNH = ?,Cidade = ?,Estado = ? WHERE Cod = ?");
            stmt.setString(1, c.getPrimeiro_Nome());
            stmt.setString(2, c.getSegundo_Nome());
            stmt.setString(3, c.getUltimo_Nome());
            stmt.setString(4, c.getCPF());
            stmt.setString(5, c.getRG());
            stmt.setString(6, c.getCNH());
            stmt.setString(7, c.getCidade());
            stmt.setString(8, c.getEstado());
            stmt.setInt(9, c.getCod());

            stmt.executeUpdate();

        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            Conexao.closeConnection(con, stmt);
        }

    }
}