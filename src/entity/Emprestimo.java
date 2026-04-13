package entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_emprestimo")
public class Emprestimo {
    
    @Id
	@GeneratedValue(strategy= GenerationType.AUTO) 	
    private Long id;

    private LocalDate dataDevolucao;

    private LocalDate dataEmprestimo;

    private Aluno aluno;

    public Emprestimo(){}

    public Emprestimo(Long id, LocalDate dataDevolucao, LocalDate dataEmprestimo) {
        this.id = id;
        this.dataDevolucao = dataDevolucao;
        this.dataEmprestimo = dataEmprestimo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

}
