package com.ecalazaes.ErickReceptorMicroservico.repositories;

import com.ecalazaes.ErickReceptorMicroservico.entities.UsuarioPlanoSaude;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioPlanoSaudeRepository extends JpaRepository<UsuarioPlanoSaude, Long> {
}
