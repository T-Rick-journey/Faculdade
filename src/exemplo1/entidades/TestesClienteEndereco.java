 
package exemplo1.entidades;
 
import java.math.BigDecimal;

public class TestesClienteEndereco {
    public static void main(String[] args) {
        // criar um cliente com Endereco com ID=1 
        ClienteDAO dao = new ClienteDAO();
        Endereco e = dao.findEnderecoById(1);
        Cliente c = new Cliente();
        c.setId(1001);
        c.setNome("LUIZ CARLOS BARROSO");
        c.setEndereco(e);
        c.addPedido( dao.novoPedido("NOTEBOOK", 1, new BigDecimal(3000)));
        c.addPedido( dao.novoPedido("MOUSE", 2, new BigDecimal(300)));
        c.addPedido( dao.novoPedido("CANETA", 10, new BigDecimal(120.50)));
        dao.insert(c);
        System.out.println("FIM");
        
        
    }
    
    private void criaUmEndereco(){
        System.out.println("Testando a criacao de um Endereco");
        ClienteDAO dao = new ClienteDAO();
        Endereco e = new Endereco(1, "AV ALM BARROSO", "66030300");
        dao.adicionaEndereco(e);
        
    }
}
