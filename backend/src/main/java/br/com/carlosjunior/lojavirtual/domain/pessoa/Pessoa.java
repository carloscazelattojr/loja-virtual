package br.com.carlosjunior.lojavirtual.domain.pessoa;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

@Entity
@Table(name = "pessoa")
public abstract class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 4, message = "O nome deve ter no minimo 4 letras")
    @NotBlank(message = "Nome deve ser informado")
    @NotNull(message = "Nome deve ser informado")
    @Column(nullable = false)
    private String nome;

    @Email
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String telefone;

    @Column
    private String tipoPessoa;

//    @OneToMany(mappedBy = "pessoa", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Endereco> enderecos = new ArrayList<Endereco>();


    @ManyToOne(targetEntity = Pessoa.class)
    @JoinColumn(name = "empresa_id", nullable = true,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "empresa_id_fk"))
    private Pessoa empresa;
}