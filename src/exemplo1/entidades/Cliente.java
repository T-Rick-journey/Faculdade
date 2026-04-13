package exemplo1.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cliente")
public class Cliente implements Serializable {

    @Id
    private Integer id;
    private String nome;
   // private String endereco;
    
    @ManyToOne
    private Endereco endereco;

    @OneToMany
    private List<Pedido> pedidos = new ArrayList<Pedido>();

    public Cliente() {
    }

    // metodo para adicionar um novo produto à lista de pedidos
    public void addPedido(Pedido umPedido) {
        this.pedidos.add(umPedido);
    }

    // getters e setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

   
    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    
    
    
}
