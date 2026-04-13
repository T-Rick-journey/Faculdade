package exemplo1.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Endereco {
    @Id 
    private Integer id;
    private String nomeLocal;
    private String cep;

    public Endereco() {
    }

    public Endereco(Integer id, String nomeLocal, String cep) {
        this.id = id;
        this.nomeLocal = nomeLocal;
        this.cep = cep;
    }

    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeLocal() {
        return nomeLocal;
    }

    public void setNomeLocal(String nomeLocal) {
        this.nomeLocal = nomeLocal;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    
    
}
