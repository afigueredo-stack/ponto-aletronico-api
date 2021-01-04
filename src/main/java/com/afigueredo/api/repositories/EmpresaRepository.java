package com.afigueredo.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.afigueredo.api.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

	/*
	 * @Transactional(readOnly = true) Apenas leitura, evitando bloqueios no banco
	 * de dados, indicado para consultas
	 */
	@Transactional(readOnly = true)
	Empresa findByCnpj(String cnpj);

}
