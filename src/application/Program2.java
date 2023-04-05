package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		int opcao;
		do {
			System.out.println("============ MENU ============");
			System.out.println("1 - Incluir Departamento");
			System.out.println("2 - Imprimir Departamento");
			System.out.println("3 - Atualizar Nome do Departamento");
			System.out.println("4 - Imprimir todo os Departamentos Cadastrado");
			System.out.println("5 - Excluir tabela pelo Id");
			System.out.println("0 - Sair");
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

	/*
	 * System.out.println();
	 * System.out.println("=== TEST #2: seller findByDepartment ==="); Department
	 * department = new Department(2, null); List<Seller> list =
	 * sellerDao.findByDepartment(department); for (Seller obj : list) {
	 * System.out.println(obj); }
	 */

}
