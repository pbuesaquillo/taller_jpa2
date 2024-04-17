package com.unicauca.asae.jpa.asst;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.unicauca.asae.jpa.asst.models.Departamento;
import com.unicauca.asae.jpa.asst.repositories.DepartamentoRepository;

@SpringBootApplication
public class AsstApplication implements CommandLineRunner{

	@Autowired
	private DepartamentoRepository servicioBDDepartamento;

	public static void main(String[] args) {
		SpringApplication.run(AsstApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Inicio de la aplicacion");

		almacenarDepartamento();

		System.out.println("fin de la aplicacion");
	}

	private void almacenarDepartamento() {
		Departamento objDepartamento = new Departamento();
		objDepartamento.setNombre("Departamento de sistemas");
		objDepartamento.setDescripcion("FIET");

		this.servicioBDDepartamento.save(objDepartamento);
	}

}
