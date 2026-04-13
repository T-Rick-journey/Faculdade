package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_emprestimo")
public class Emprestimo {

    @Id
	@GeneratedValue(strategy= GenerationType.AUTO) 	
    private Long id;

    @Column(name = "dataDevolucao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDevolucao;

    @Column(name = "dataEmprestimo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEmprestimo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_aluno")
    private Aluno aluno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_publicacao")
    private Publicacao publicacao;

    public Emprestimo(){}

    public Emprestimo(Long id, Date dataDevolucao, Date dataEmprestimo) {
        this.id = id;
        this.dataDevolucao = dataDevolucao;
        this.dataEmprestimo = dataEmprestimo;
    }

    public Emprestimo(Long id, Date dataDevolucao, Date dataEmprestimo, Aluno aluno,
            Publicacao publicacao) {
        this.id = id;
        this.dataDevolucao = dataDevolucao;
        this.dataEmprestimo = dataEmprestimo;
        this.aluno = aluno;
        this.publicacao = publicacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Publicacao getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(Publicacao publicacao) {
        this.publicacao = publicacao;
    }

}
