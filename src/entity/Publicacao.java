package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_publicacao")
public class Publicacao {
    
    @Id
	@GeneratedValue(strategy= GenerationType.AUTO) 	
    private Long id;

    @Column(name = "codigoPublicacao")
    private Integer codigoPublicacao;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "ano")
    private Integer ano;

    @Column(name = "autor")
    private String autor;

    @Column(name = "tipo")
    private String tipo;

    private List<Emprestimo> emprestimos = new ArrayList<>();

    public Publicacao(){}

    public Publicacao(Long id, Integer codigoPublicacao, String titulo, Integer ano, String autor, String tipo) {
        this.id = id;
        this.codigoPublicacao = codigoPublicacao;
        this.titulo = titulo;
        this.ano = ano;
        this.autor = autor;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCodigoPublicacao() {
        return codigoPublicacao;
    }

    public void setCodigoPublicacao(Integer codigoPublicacao) {
        this.codigoPublicacao = codigoPublicacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

}
