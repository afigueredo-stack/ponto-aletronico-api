package com.afigueredo.api.repositories;

import static org.junit.Assert.assertEquals;

import com.afigueredo.api.entities.Empresa;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class EmpresaRepositoryTest {

	@Autowired
	private EmpresaRepository empresaRepository;

	private static final String CNPJ = "51463645000100";

	private static final Logger log = LoggerFactory.getLogger(EmpresaRepositoryTest.class);

	@BeforeEach
	public void setUp() throws Exception {
		Empresa empresa = new Empresa();
		empresa.setRazaoSocial("Empresa de exemplo");
		empresa.setCnpj(CNPJ);
		log.info("Empresa criada: " + empresa.getRazaoSocial() + ", CNPJ: " + empresa.getCnpj());
		this.empresaRepository.save(empresa);
	}

	@AfterEach
	public final void tearDown() {
		log.info("Excluindo Empresas... " + this.empresaRepository);
		this.empresaRepository.deleteAll();
	}

	@Test
	public void testBuscarPorCnpj() {
		log.info("Buscando Empresa... ");
		Empresa empresa = this.empresaRepository.findByCnpj(CNPJ);
		assertEquals(CNPJ, empresa.getCnpj());
	}

}
