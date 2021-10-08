package com.example.m2testing2jorgeaparicio;

import com.example.m2testing2jorgeaparicio.entities.Laptop;
import com.example.m2testing2jorgeaparicio.repository.LaptopRepository;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class M2Testing2JorgeAparicioApplication implements CommandLineRunner {

	@Autowired
	LaptopRepository laptopRepository;

	public static void main(String[] args) {
		SpringApplication.run(M2Testing2JorgeAparicioApplication.class, args);
	}

	public void showMenu() {
		System.out.println("Bienvenido/a a su tienda de informática, seleccione una opción: ");
		System.out.println("0.- SALIR DE LA APLICACIÓN");
		System.out.println("1.- Consultar el número total de ordenadores");
		System.out.println("2.- Consultar todos los ordenadores");
		System.out.println("3.- Consultar un ordenador (utilizando el id)");
		System.out.println("4.- Crear un nuevo ordenador");
		System.out.println("5.- Modificar un ordenador (utilizando el id)");
		System.out.println("6.- Borrar un ordenador (utilizando el id)");
		System.out.println("7.- Borrar todos los ordenadores");
		System.out.println("8.- Consultar todos los ordenadores (utilizando el modelo)");
	}

	@Override
	public void run(String... args) throws Exception {

		Laptop laptop1 = new Laptop(null, "Asus", 32, 4, "black", 1290.99);
		laptopRepository.save(laptop1);
		Laptop laptop2 = new Laptop(null, "HP", 16, 2, "white", 890.99);
		laptopRepository.save(laptop2);
		laptopRepository.save(new Laptop(null, "PackardBell Easynote TJ66", 4, 2,
				"black&white", 755.75));
		laptopRepository.save(new Laptop(null, "Asus", 32, 8,
				"pink", 955.75));
		laptopRepository.save(new Laptop(null, "Apple", 16, 4,
				"black&white", 1755.75));

		List<Laptop> laptops = laptopRepository.findBymodelo("Asus");
		System.out.println(laptops);

		while (true) {
			Scanner scanner = new Scanner(System.in);
			showMenu();


			try {
				int opcion = scanner.nextInt();
				scanner.nextLine();

				if (opcion == 0) {
					System.out.println("Ha seleccionado la opción 0 - SALIR DE LA APLICACIÓN");
					System.out.println("*****************************************************");
					System.out.println("¡HASTA LA PRÓXIMA!");
					break;

				} else if (opcion == 1) {
					System.out.println("Ha seleccionado la opción 1 - CONSULTAR EL Nº TOTAL DE ORDENADORES");
					laptops = laptopRepository.findAll();
					if (laptops.isEmpty()) {
						System.out.println("No hay ordenadores disponibles.");
					} else {
						long numOrdenadores = laptopRepository.count();
						System.out.println("El número de ordenadores es: " + numOrdenadores);
					}

				} else if (opcion == 2) {
					System.out.println("Ha seleccionado la opción 2 - CONSULTAR TODOS LOS ORDENADORES");
					laptops = laptopRepository.findAll();
					if (laptops.isEmpty()) {
						System.out.println("No hay ordenadores disponibles.");
					} else {
						for (Laptop laptop : laptops) {
							System.out.println(laptop);
						}
					}

				} else if (opcion == 3) {
					System.out.println("Ha seleccionado la opción 3 - CONSULTAR UN ORDENADOR (utilizando el id)");
					System.out.println("Por favor, introduzca el id del ordenador que desea consultar: ");
					Long id = scanner.nextLong();
					Optional<Laptop> laptopOpt = laptopRepository.findById(id);
					if (laptopOpt.isPresent()) {
						Laptop laptop = laptopOpt.get();
						System.out.println("Consultando un solo ordenador...");
						System.out.println(laptop);
					} else {
						System.out.println("No existe ningún ordenador con ese id");
					}

				} else if (opcion == 4) {
					System.out.println("Ha seleccionado la opción 4 - CREAR UN NUEVO ORDENADOR");
					System.out.println("Introduzca el MODELO:");
					String modelo = scanner.nextLine();
					System.out.println("Introduzca la cantidad de memoria RAM:");
					Integer ram = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Introduzca la cantidad de CORES:");
					Integer cores = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Introduzca el COLOR:");
					String color = scanner.nextLine();
					System.out.println("Introduzca el PRECIO:");
					Double price = scanner.nextDouble();
					scanner.nextLine();
					Laptop laptop = new Laptop(null, modelo, ram, cores, color, price);
					laptopRepository.save(laptop);
					System.out.println("Ordenador creado correctamente. Actualmente existen "
							+ laptopRepository.count() + " registros.");

				} else if (opcion == 5) {
					System.out.println("Ha seleccionado la opción 5 - MODIFICAR UN ORDENADOR (utilizando el id)");
					System.out.println("Por favor, introduzca el id del ordenador que desea modificar: ");
					Long id = scanner.nextLong();
					Optional<Laptop> laptopOpt = laptopRepository.findById(id);
					if (laptopOpt.isEmpty()) {
						Laptop laptop = laptopOpt.get();
						System.out.println("No existe ningún ordenador con ese id");
						continue;
					}
					Laptop laptop = laptopOpt.get();
					System.out.println("Introduzca un MODELO (actual: " + laptop.getModelo() + ")");
					String modelo = scanner.next();
					laptop.setModelo(modelo);
					System.out.println("Introduzca una cantidad de MEMORIA RAM (actual: " + laptop.getRam() + ")");
					Integer ram = scanner.nextInt();
					scanner.nextLine();
					laptop.setRam(ram);
					System.out.println("Introduzca la cantidad de CORES (actual: " + laptop.getCores() + ")");
					Integer cores = scanner.nextInt();
					scanner.nextLine();
					laptop.setCores(cores);
					System.out.println("Introduzca el COLOR (actual: " + laptop.getColor() + ")");
					String color = scanner.nextLine();
					laptop.setColor(color);
					System.out.println("Introduzca el PRECIO (actual: " + laptop.getPrice() + ")");
					Double price = scanner.nextDouble();
					scanner.nextLine();
					laptop.setPrice(price);
					laptopRepository.save(laptop);
					System.out.println("Ordenador modificado correctamente");

				} else if (opcion == 6) {
					System.out.println("Ha seleccionado la opción 6 - BORRAR UN ORDENADOR (utilizando el id)");
					System.out.println("Por favor, introduzca el id del ordenador que desea borrar: ");
					Long id = scanner.nextLong();
					boolean exists = laptopRepository.existsById(id);
					if (exists) {
						System.out.println("Esta acción eliminará el registro, ¿está seguro? (SÍ=true / NO=false)");
						boolean confirm = scanner.nextBoolean();
						if (!confirm) {
							continue;
						} else {
							laptopRepository.deleteById(id);
							System.out.println("Ordenador borrado correctamente. Actualmente existen "
									+ laptopRepository.count() + " registros.");
						}
					} else {
						System.out.println("Lo sentimos, pero no exsite ningún ordenador con ese Id");
					}

				} else if (opcion == 7) {
					System.out.println("Ha seleccionado la opción 7 - BORRAR TODOS LOS ORDENADORES");
					System.out.println("¿SEGURO QUE DESEA ELIMINAR TODOS LOS REGISTROS? (SÍ / NO)");
					String respuesta = scanner.nextLine();
					if (respuesta.equalsIgnoreCase("si")) {
						laptopRepository.deleteAll();
						System.out.println("Ordenadores borrados correctamente. Actualmente existen "
								+ laptopRepository.count() + " registros.");
					} else {
						System.out.println("¡MENOS MAL QUE NO HAS ELIMINADO TODOS LOS REGISTROS!");
						continue;
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}


}
	/*
	public void crudLaptop (){

		long numOrdenadores = laptopRepository.count();
		System.out.println("El número de ordenadores es: " + numOrdenadores);

		// Operaciones con CRUD: Create Retrieve Update Delete => Crear Buscar Actualizar Borrar
		// CREAR  y GUARDAR REGISTROS
		Laptop laptop1 = new Laptop (null, "Asus", 32, 4, "black", 1290.99);
		laptopRepository.save(laptop1);
		Laptop laptop2 = new Laptop (null, "HP", 16, 2, "white", 890.99);
		laptopRepository.save(laptop2);
		laptopRepository.save (new Laptop(null,"PackardBell Easynote TJ66", 4, 2,
				"black&white", 755.75));
		laptopRepository.save (new Laptop(null,"Asus", 32, 8,
				"pink", 955.75));
		laptopRepository.save (new Laptop(null,"Apple", 16, 4,
				"black&white", 1755.75));

		// LISTADO CON TODOS LOS REGISTROS
		// List<Laptop> laptops = new ArrayList<>(); => .findAll() nos devuelve un ArrayList
		// System.out.println(laptopRepository.findAll());
		List<Laptop> laptops = laptopRepository.findAll();
		for (Laptop laptop : laptops) {
			System.out.println(laptop);
		}
		System.out.println(laptops.get(1).getModelo());
		System.out.println(laptops.get(2).getColor());
		System.out.println(laptops.get(3).getPrice());

		// TOTAL DE REGISTROS
		numOrdenadores = laptopRepository.count();
		System.out.println("El número de ordenadores es: " + numOrdenadores);

		// VER SI EXISTE UN REGISTRO CONCRETO
		boolean exists = laptopRepository.existsById(3L);
		if (exists) {
			System.out.println("Sí, existe el ordenador con ese Id");
		} else {
			System.out.println("Lo sentimos, pero no exsite ningún ordenador con ese Id");
		}

		// ENCONTRAR UN REGISTRO CONCRETO
		Optional<Laptop> laptopOpt = laptopRepository.findById(2L);
		if (laptopOpt.isPresent()) {
			Laptop laptop = laptopOpt.get();
			System.out.println("Consultando un solo ordenador:");
			System.out.println(laptop);
		} else {
			System.out.println("No se ha encontrado el ordenador");
		}

		// MODIFICAR UN REGISTRO CONCRETO
		laptop2.setColor("Amarillo pollo");
		laptopRepository.save(laptop2);
		laptops.get(0).setColor("Naranja");
		laptopRepository.save(laptops.get(0));
		Optional<Laptop> laptopOpt1 = laptopRepository.findById(1L);
		if (laptopOpt1.isPresent()) {
			Laptop laptop = laptopOpt1.get();
			laptop.setColor("Azul cielo");
			laptop.setRam(laptop.getRam()*3);
			laptop.setCores(8);
			System.out.println(laptop);
		}

		// ELIMINAR UN REGISTRO CONCRETO
		Optional<Laptop> laptopOpt2 = laptopRepository.findById(1L);
		if (laptopOpt2.isPresent()) {
			laptopRepository.deleteById(1L);
		}

		// ELIMINAR TODOS LOS REGISTROS
		laptopRepository.deleteAll();

	}

	 */


