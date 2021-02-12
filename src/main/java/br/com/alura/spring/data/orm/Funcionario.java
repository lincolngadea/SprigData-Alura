package br.com.alura.spring.data.orm;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "funcionario")
public class Funcionario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cpf;
    private Double salario;
    private LocalDate dataContratacao;
    @ManyToOne
    @JoinColumn(name = "cargo_id", nullable = false)
    private Cargo cargo;
    @Fetch(FetchMode.SELECT)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name= "funcionarios_unidades",joinColumns = {
            @JoinColumn(name = "fk_funcionario")
    },inverseJoinColumns = {@JoinColumn(name="fk_unidade")})
    private List<UnidadeDeTrabalho> unidadeDeTrabalhoList;

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<UnidadeDeTrabalho> getUnidadeDeTrabalhoList() {
        return unidadeDeTrabalhoList;
    }

    public void setUnidadeDeTrabalhoList(List<UnidadeDeTrabalho> unidadeDeTrabalhoList) {
        this.unidadeDeTrabalhoList = unidadeDeTrabalhoList;
    }

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }
}
