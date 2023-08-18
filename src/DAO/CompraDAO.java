package DAO;
import java.sql.Connection;
import Conection.Conexao;
import Model.compra;
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
public class CompraDAO {
   private  Connection con =null;
   PreparedStatement stmt=null;
   public CompraDAO(){
     con= Conexao.getConnection();
   }
   public void insert(compra compra) throws SQLException, Exception{
       String sql="INSERT INTO compra (Forma_Pagamento,ServicosAdicionais,Desconto,Valor_Total,Chassi) VALUES(?,?,?,?,?)";
      stmt = con.prepareStatement(sql);
       try {
           stmt.setString(1, compra.getForma_Pagamento());
           stmt.setString(2, compra.getServicosAdicionais());
           stmt.setString(3, compra.getDesconto());
           stmt.setString(4, compra.getValor_Total());
           stmt.setString(5, compra.getChassi());
           stmt.executeUpdate();
           JOptionPane.showMessageDialog(null, "Cadastrado com Suceso!");
           
       } catch (SQLException ex) {
           System.out.println("Erro: "+ ex);
           
       }finally{
               Conexao.closeConnection(con, stmt);
           
       }
   }
   public List<compra> listar() throws SQLException, Exception{
    //  Connection con = Conexao.getConnection();
      PreparedStatement stmt = null;
      ResultSet rs=null;
     
        List<compra> compras = new ArrayList<>();
    try{
        String sql="SELECT * FROM compra";
      stmt=con.prepareStatement(sql);
      rs=stmt.executeQuery();
       while(rs.next()){
       compra c =new compra();
       c.setCod(rs.getInt("cod"));
       c.setChassi(rs.getString("Chassi"));
       c.setForma_Pagamento(rs.getString("Forma_Pagamento"));
       c.setValor_Total(rs.getString("Valor_Total"));
       c.setDesconto(rs.getString("Desconto"));
       c.setServicosAdicionais(rs.getString("ServicosAdicionais"));
       
        compras.add(c);
        }
        return compras;
    }catch(Exception e){
        System.out.println(e);
        return null;
    }finally{
        Conexao.closeConnection(con,stmt,rs);
    }
    }
    
    public void deletar(compra c) throws SQLException, Exception{
        //Connection con = Conexao.getConnection();
        PreparedStatement stmt= null;
        try{
        stmt=con.prepareStatement("DELETE FROM compra WHERE cod=?");
        stmt.setInt(1, c.getCod());
        stmt.executeUpdate();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "erro"+e);
        }finally{
        Conexao.closeConnection(con, stmt);
        }
    }
    public void update(compra c) throws Exception {

        try {
            stmt = con.prepareStatement("UPDATE compra SET Forma_Pagamento = ? ,ServicosAdicionais = ?,Desconto = ?,Valor_Total = ?,Chassi = ? WHERE cod = ?");
            stmt.setString(1,c.getForma_Pagamento());
            stmt.setString(2,c.getServicosAdicionais());
            stmt.setString(3,c.getDesconto());
            stmt.setString(4,c.getValor_Total());
            stmt.setString(5,c.getChassi());
            stmt.setInt(6,c.getCod());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            Conexao.closeConnection(con, stmt);
        }

    }
    
}
