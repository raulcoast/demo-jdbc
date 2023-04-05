package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int opcao;
		do {
			System.out.println("============ MENU ============");
			System.out.println("1 - Menu Vendedor");
			System.out.println("2 - Menu Departamento");
			System.out.println("0 - Sair");
			System.out.print("Escolha uma opção: ");
			opcao = sc.nextInt();
			System.out.println();

			switch (opcao) {
								
			case 1:
				
				SellerDao sellerDao = DaoFactory.createSellerDao();
				DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
				
				do {
					System.out.println("============ MENU ============");
					System.out.println("1 - Incluir Vendedor");
					System.out.println("2 - Imprimir Vendedor pelo Id");
					System.out.println("3 - Atualizar Nome do Vendedor");
					System.out.println("4 - Imprimir Todos os Vendedores Cadastrado");
					System.out.println("5 - Imprimir Vendedor pelo Departamento");
					System.out.println("6 - Excluir Vendedor pelo Id");
					System.out.println("9 - Voltar");
					System.out.print("Escolha uma opção: ");
					opcao = sc.nextInt();
					System.out.println();

					switch (opcao) {

					case 1:
						System.out.println();
						System.out.println("=== TEST #1: seller insert ===");
						System.out.print("Nome do Vendedor: ");
						sc.nextLine();
						String name = sc.nextLine();
						System.out.print("E-mail: ");
						String email = sc.nextLine();
						System.out.print("Data de nascimento: ");
						//Date date = sc.next();
						System.out.print("Salario: ");
						double baseSalary = sc.nextDouble();
						System.out.println("Informe o numero do departamento #:");
						System.out.println("Lista do Departamento");
						List<Department> list = departmentDao.findAll();
						for (Department obj : list) {
							System.out.println(obj);
						}
						System.out.println("===============================");
						int department1 = sc.nextInt();
						Department department = new Department(department1, null);
						Seller newSeller = new Seller(null, name, email, new Date(), baseSalary, department);
						sellerDao.insert(newSeller);
						System.out.println("Insertd! New id =" + newSeller.getId());
						break;
					
					case 2:
						System.out.println("=== TEST #2: seller findById ===");
						System.out.print("Informe o Id do Vendedor: ");
						int id = sc.nextInt();
						Seller seller = sellerDao.findById(id);
						System.out.println(seller);
						System.out.println("===============================");
						System.out.println();
						break;
						
					case 3:
						System.out.println();
						System.out.println("=== TEST #3: seller update ===");
						System.out.print("Informe o Id do Vendedor: ");
						id = sc.nextInt();
						seller = sellerDao.findById(id);
						System.out.print("Informe o novo nome do vendedor para o Id informado: ");
						sc.nextLine();
						name = sc.nextLine();
						seller.setName(name);
						sellerDao.update(seller);
						System.out.println("Update completed");
						System.out.println("===============================");
						System.out.println();
					
					case 4:
						System.out.println();
						System.out.println("=== TEST #4: seller findAll ===");
						List<Seller> list1 = sellerDao.findAll();
						for (Seller obj : list1) {
							System.out.println(obj);
						}
						System.out.println("===============================");
						System.out.println();
						break;
					
					case 5:
						System.out.println();
						System.out.println("=== TEST #5: seller findByDepartment ===");
						System.out.println("Lista do Departamento");
						List<Department> list2 = departmentDao.findAll();
						for (Department obj : list2) {
							System.out.println(obj);
						}
						System.out.println("===============================");
						System.out.print("Informe o Id do Departamento: ");
						id = sc.nextInt();
						department = new Department(id, null);
						List<Seller> list3 = sellerDao.findByDepartment(department);
						for (Seller obj : list3) {
							System.out.println(obj);
						}
						System.out.println("===============================");
						System.out.println();
						break;
						
					case 6:
						System.out.println();
						System.out.println("=== TEST #5: seller delete ===");
						System.out.print("Enter id for delete test: ");
						id = sc.nextInt();
						sellerDao.deleteById(id);
						System.out.println("Delete completed");
						System.out.println("===============================");
						System.out.println();
						break;
						
					default:
						System.out.println("===============================");
						break;
					}

				} while (opcao != 9);
				System.out.println("Voltar");
				break;
			
			case 2:
				
				departmentDao = DaoFactory.createDepartmentDao();

				do {
					System.out.println("============ MENU ============");
					System.out.println("1 - Incluir Departamento");
					System.out.println("2 - Imprimir Departamento");
					System.out.println("3 - Atualizar Nome do Departamento");
					System.out.println("4 - Imprimir todos os Departamentos Cadastrado");
					System.out.println("5 - Excluir Departamento pelo Id");
					System.out.println("9 - Voltar");
					System.out.print("Escolha uma opção: ");
					opcao = sc.nextInt();
					System.out.println();

					switch (opcao) {

					case 1:
						System.out.println();
						System.out.println("=== TEST #1: seller insert ===");
						System.out.print("Digite o nome do departamento a incluir: ");
						sc.nextLine();
						String name = sc.nextLine();
						Department newDepartment = new Department(null, name);
						departmentDao.insert(newDepartment);
						System.out.println("Insertd! New id =" + newDepartment.getId());
						System.out.println("===============================");
						System.out.println();
						break;

					case 2:
						System.out.println("=== TEST #2: Department findById ===");
						System.out.print("Digite o id: ");
						int id = sc.nextInt();
						Department department = departmentDao.findById(id);
						System.out.println(department);
						System.out.println("===============================");
						System.out.println();
						break;

					case 3:
						System.out.println();
						System.out.println("=== TEST #3: seller update ===");
						System.out.print("Digite o id: ");
						id = sc.nextInt();
						department = departmentDao.findById(id);
						System.out.print("Digite novo nome do departamento: ");
						sc.nextLine();
						name = sc.nextLine();
						department.setName(name);
						departmentDao.update(department);
						System.out.println("Update completed");
						System.out.println();
						System.out.println("=== TEST #3: after update ===");
						department = departmentDao.findById(id);
						System.out.println(department);
						System.out.println("===============================");
						System.out.println();
						break;

					case 4:
						System.out.println();
						System.out.println("=== TEST #4: seller findAll ===");
						List<Department> list = departmentDao.findAll();
						for (Department obj : list) {
							System.out.println(obj);
						}
						System.out.println("===============================");
						System.out.println();
						break;

					case 5:
						System.out.println();
						System.out.println("=== TEST #5: seller delete ===");
						System.out.print("Enter id for delete test: ");
						id = sc.nextInt();
						departmentDao.deleteById(id);
						System.out.println("Delete completed");
						System.out.println("===============================");
						System.out.println();
						break;

					default:
						System.out.println("===============================");
						break;
					}

				} while (opcao != 9);
				System.out.println("Voltar");
				break;				
			
			case 0:
				// Sair
				System.out.println("Encerrando o programa...");
				break;

			default:
				System.out.println("Opção inválida!");
				System.out.println("===============================");
				System.out.println();
				break;
			}

		} while (opcao != 0);

		sc.close();
		
	}
}
