package br.com.carlosjunior.lojavirtual.domain.acesso;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "acesso")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Acesso implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao; /* Acesso ex: ROLE_ADMIN ou ROLE_SECRETARIO */

    @Override
    public String getAuthority() {
        return descricao;
    }
}
