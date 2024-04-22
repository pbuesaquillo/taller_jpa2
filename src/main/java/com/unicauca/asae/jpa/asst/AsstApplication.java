package com.unicauca.asae.jpa.asst;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.print.Doc;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.unicauca.asae.jpa.asst.models.Cuestionario;
import com.unicauca.asae.jpa.asst.models.Departamento;
import com.unicauca.asae.jpa.asst.models.Docente;
import com.unicauca.asae.jpa.asst.models.Pregunta;
import com.unicauca.asae.jpa.asst.models.Respuesta;
import com.unicauca.asae.jpa.asst.models.Telefono;
import com.unicauca.asae.jpa.asst.models.TipoPregunta;
import com.unicauca.asae.jpa.asst.repositories.CuestionarioRepository;
import com.unicauca.asae.jpa.asst.repositories.DepartamentoRepository;
import com.unicauca.asae.jpa.asst.repositories.DocenteRepository;
import com.unicauca.asae.jpa.asst.repositories.PersonaRepository;
import com.unicauca.asae.jpa.asst.repositories.PreguntaRepository;
import com.unicauca.asae.jpa.asst.repositories.RespuestaRepository;
import com.unicauca.asae.jpa.asst.repositories.TipoPreguntaRepository;

@SpringBootApplication
public class AsstApplication implements CommandLineRunner{

	@Autowired
	private DepartamentoRepository servicioBDDepartamento;

	@Autowired
	private TipoPreguntaRepository servicioBDTipoPregunta;

	@Autowired
	private CuestionarioRepository servicioBDCuestionario;

	@Autowired
	private DocenteRepository servicioBDDocente;

	@Autowired
	private PersonaRepository servicioBDPersona;

	@Autowired
	private RespuestaRepository servicioBDRespuesta;

	public static void main(String[] args) {
		SpringApplication.run(AsstApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Inicio de la aplicacion");

		//almacenarDepartamento();
		//almacenarCuestionario();
		//almacenarDepartamento();
		//almacenarTipoPregunta();
		//consultarTipoPregunta();
		//almacenarDocente();
		//almacenarRespuestas();
		//consultarDocente();
		//respuestas();
		//consultarCuestionarios();
		consultarCuestionarios2();
		System.out.println("fin de la aplicacion");
	}

	private void almacenarDepartamento() {
		Departamento objDepartamento = new Departamento();
		objDepartamento.setNombre("Departamento de sistemas");
		objDepartamento.setDescripcion("FIET");

		Departamento objDepartamento2 = new Departamento();
		objDepartamento2.setNombre("Departamento de telematica");
		objDepartamento2.setDescripcion("FIET");

		this.servicioBDDepartamento.save(objDepartamento);
		this.servicioBDDepartamento.save(objDepartamento2);
	}

	private void almacenarTipoPregunta() {
		TipoPregunta tp1 = new TipoPregunta();
		tp1.setNombre("Seleccion multiple");
		tp1.setDescripcion("Preguntas de seleccion multiple");

		TipoPregunta tp2 = new TipoPregunta();
		tp2.setNombre("Abierta");
		tp2.setDescripcion("Preguntas abiertas");

		this.servicioBDTipoPregunta.save(tp1);
		this.servicioBDTipoPregunta.save(tp2);
	}


	//Punto 1
	private void almacenarCuestionario() {
		Cuestionario cuestionario = new Cuestionario();
		cuestionario.setDescripcion("Primer cuestionario almacenado");
		cuestionario.setTitulo("Primero");

		//preguntas de seleccion multiple
		List<Pregunta> preguntasTipo1 = new ArrayList<>();
		

		Pregunta pregunta1 = new Pregunta();
		pregunta1.setEnunciado("¿Cuál de los siguientes elementos es más importante para la seguridad en su área de trabajo?");
		pregunta1.setObjTipoPregunta(this.servicioBDTipoPregunta.findById(1).get());
		preguntasTipo1.add(pregunta1);

		Pregunta pregunta2 = new Pregunta();
		pregunta2.setEnunciado("¿Cuales de los siguientes equipos utliza con mayor frecuencia?");
		pregunta2.setObjTipoPregunta(this.servicioBDTipoPregunta.findById(1).get());
		preguntasTipo1.add(pregunta2);

		//this.servicioBDTipoPregunta.findById(1).get().setPreguntas(preguntasTipo1);

		
		pregunta1.setObjCuestionario(cuestionario);
		pregunta2.setObjCuestionario(cuestionario);
		
		//preguntas abiertas
		List<Pregunta> preguntasTipo2 = new ArrayList<>();

		Pregunta pregunta3 = new Pregunta();
		pregunta3.setEnunciado("¿Describa cualquier incidente reciente relacionado con la seguridad que haya observado o experimentado y cómo se manejó.?");
		pregunta3.setObjTipoPregunta(this.servicioBDTipoPregunta.findById(2).get());
		preguntasTipo2.add(pregunta3);

		Pregunta pregunta4 = new Pregunta();
		pregunta4.setEnunciado("Comparta sus pensamientos sobre cómo la cultura de seguridad en su departamento podría mejorarse.");
		pregunta4.setObjTipoPregunta(this.servicioBDTipoPregunta.findById(2).get());
		preguntasTipo2.add(pregunta4);

		//this.servicioBDTipoPregunta.findById(2).get().setPreguntas(preguntasTipo2);
		
		pregunta3.setObjCuestionario(cuestionario);
		pregunta4.setObjCuestionario(cuestionario);

		List<Pregunta> todasLasPreguntas = new ArrayList<>();
		todasLasPreguntas.addAll(preguntasTipo1);//seleccion multiple
		todasLasPreguntas.addAll(preguntasTipo2);//abiertas

		cuestionario.setPreguntas(todasLasPreguntas);

		servicioBDCuestionario.save(cuestionario);
	}

	//Punto 2
	private void almacenarDocente() {
		Docente objDocente1 = new Docente();
		Telefono objtTelefono1 = new Telefono();
		objDocente1.setTipoIdentificacion("Cedula de Ciudadanía");
		objDocente1.setNumeroIdentificacion("123454321");
		objDocente1.setNombres("Valentina");
		objDocente1.setApellidos("Bolaños");
		objDocente1.setCorreo("valentina@mail.com");

		objtTelefono1.setNumero("3214456234");
		objtTelefono1.setTipoTelefono("Celular");

		objDocente1.setObjTelefono(objtTelefono1);
		objtTelefono1.setObjDocente(objDocente1);
		objDocente1.setVinculacion("De planta");

		List<Departamento> departamentos = new ArrayList<>();
		departamentos.add(this.servicioBDDepartamento.findById(1).get());
		departamentos.add(this.servicioBDDepartamento.findById(2).get());

		objDocente1.setDepartamentos(departamentos);

		Docente objDocente2 = new Docente();
		objDocente2.setTipoIdentificacion("Pasaporte");
		objDocente2.setNumeroIdentificacion("23557554");
		objDocente2.setNombres("Sandra Lorena");
		objDocente2.setApellidos("Buitron Ruiz");
		objDocente2.setCorreo("sandrita@mail.com");

		Telefono telefono2 = new Telefono();
		telefono2.setTipoTelefono("Fijo");
		telefono2.setNumero("7452345");

		objDocente2.setObjTelefono(telefono2);
		telefono2.setObjDocente(objDocente2);

		objDocente2.setVinculacion("De planta");
		objDocente2.setDepartamentos(departamentos);

		List<Docente> docentes = new ArrayList<>();
		docentes.add(objDocente1);
		docentes.add(objDocente2);

		this.servicioBDDocente.saveAll(docentes);
	}

	//Punto 3
	private void almacenarRespuestas() {
		Docente objDocente = this.servicioBDDocente.findById(1).get();
		List<Pregunta> preguntas = this.servicioBDCuestionario.findById(1).get().getPreguntas();
		List<Respuesta> respuestas = new ArrayList<>();

		Respuesta objRespuesta1 = new Respuesta();
		objRespuesta1.setDescripcion("a) casco");
		objRespuesta1.setObjDocente(objDocente);
		objRespuesta1.setObjPregunta(preguntas.get(0));
		respuestas.add(objRespuesta1);

		Respuesta ojbRespuesta2 = new Respuesta();
		ojbRespuesta2.setDescripcion("A) Formación en seguridad para nuevos empleados");
		ojbRespuesta2.setObjDocente(objDocente);
		ojbRespuesta2.setObjPregunta(preguntas.get(1));
		respuestas.add(ojbRespuesta2);

		Respuesta objRespuesta3 = new Respuesta();
		objRespuesta3.setDescripcion("Alguien se cayó de cabeza");
		objRespuesta3.setObjDocente(objDocente);
		objRespuesta3.setObjPregunta(preguntas.get(2));
		respuestas.add(objRespuesta3);

		Respuesta objRespuesta4 = new Respuesta();
		objRespuesta4.setDescripcion("Se podria mejorar añadiendo salidas de emergencia");
		objRespuesta4.setObjDocente(objDocente);
		objRespuesta4.setObjPregunta(preguntas.get(3));
		respuestas.add(objRespuesta4);

		objDocente.setRespuestas(respuestas);
		this.servicioBDDocente.save(objDocente);
	}


	//Punto 4
	private void consultarCuestionarios() {
		Iterable<Cuestionario> cuestionarios = this.servicioBDCuestionario.findAll();

		
		System.out.println("Cuestionarios");
		for (Cuestionario cuestionario : cuestionarios) {
			System.out.println("id: "+cuestionario.getIdCuestionario());
			System.out.println("Titulo: "+cuestionario.getTitulo());
			System.out.println("Descripcion:"+cuestionario.getDescripcion());
			System.out.println("\nPreguntas");
			Iterable<Pregunta> prreguntas = cuestionario.getPreguntas();
			for (Pregunta pregunta : prreguntas) {
				System.out.println("Id pregunta:"+pregunta.getIdPregunta());
				System.out.println("enunciado: "+pregunta.getEnunciado());
				System.out.println("Tipo de pregunta: "+pregunta.getObjTipoPregunta().getDescripcion());
				System.out.println("\n--------------------------------------------------------------");
			}
		}
	}

	//Punto 5
	private void consultarCuestionarios2() {
		Iterable<Cuestionario> cuestionarios = this.servicioBDCuestionario.findAll();
		int i=0;

		for (Cuestionario cuestionario : cuestionarios) {
			System.out.println("Cuestionario #"+i+1);
			System.out.println("Id: "+cuestionario.getIdCuestionario());
			System.out.println("Descripción: "+cuestionario.getDescripcion());
			System.out.println("Docente que respondió: "+cuestionario.getPreguntas().get(i).getRespuestas().get(i).getObjDocente().getNombres()+" "+cuestionario.getPreguntas().get(i).getRespuestas().get(i).getObjDocente().getApellidos());
			System.out.println("\nPreguntas");
			Iterable<Pregunta> preguntas = cuestionario.getPreguntas();

			for (Pregunta pregunta : preguntas) {
				System.out.println("	Id pregunta:"+pregunta.getIdPregunta());
				System.out.println("	enunciado: "+pregunta.getEnunciado());
				System.out.println("	Tipo de pregunta: "+pregunta.getObjTipoPregunta().getDescripcion());
				System.out.println("\n\tRespuestas: ");
				Iterable<Respuesta> respuestas = pregunta.getRespuestas();

				for (Respuesta respuesta : respuestas) {
					System.out.println("\t\tId: "+respuesta.getIdRespuesta());
					System.out.println("\t\tDescripcion respuesta: "+respuesta.getDescripcion());
				}
				System.out.println("\n--------------------------------------------------------------");
			}
			i++;
		}

	}

}
