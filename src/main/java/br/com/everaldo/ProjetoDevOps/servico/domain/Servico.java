package br.com.everaldo.ProjetoDevOps.servico.domain;

import br.com.everaldo.ProjetoDevOps.categoria.domain.Categoria;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "SERVICOS")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SERVICO")
    private Integer idServico;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "VALOR")
    private Double valor;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;




    public Servico(Integer idServico, String nome, Double valor, Categoria categoria) {
        this.idServico = idServico;
        this.nome = nome;
        this.valor = valor;
        this.categoria = categoria;
    }


}

