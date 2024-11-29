package com.ecalazaes.ErickReceptorMicroservico.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.util.Objects;

@Entity
@Table(name = "tb_usuarios")
public class UsuarioPlanoSaude {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Long id;

    @Column(name = "usuario_nome")
    private String nome;

    @Column(name = "usuario_matricula")
    private String matricula;

    public UsuarioPlanoSaude() {
    }

    public UsuarioPlanoSaude(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioPlanoSaude that = (UsuarioPlanoSaude) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
