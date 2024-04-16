import DAO.PetDAO;
import controller.PetController;
import model.Pet;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Criar instância do DAO e Controller
        PetDAO petDAO = new PetDAO();
        PetController petController = new PetController(petDAO);

        // Menu de opções
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("");
            System.out.println("------ MENU ------");
            System.out.println("1. Adicionar Pet");
            System.out.println("2. Editar Pet por ID");
            System.out.println("3. Remover Pet por ID");
            System.out.println("4. Buscar Pet por ID");
            System.out.println("5. Listar Pets");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do pet: ");
                    scanner.nextLine(); // Consumir a quebra de linha após o próximoInt()
                    String nome = scanner.nextLine();
                    petController.adicionarPet(nome);
                    System.out.println("|");
                    System.out.println("Pet adicionado com sucesso!");
                    break;
                case 2:
                    System.out.print("Digite o ID do pet que deseja editar: ");
                    int idEdicao = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha após o próximoInt()
                    Pet petParaEditar = petController.buscarPetPorId(idEdicao);
                    if (petParaEditar != null) {
                        System.out.print("Digite o novo nome do pet: ");
                        String novoNome = scanner.nextLine();
                        petParaEditar.setNome(novoNome);
                        System.out.println("|");
                        System.out.println("Pet editado com sucesso!");
                    } else {
                        System.out.println("|");
                        System.out.println("Nenhum pet encontrado com o ID informado.");
                    }
                    break;
                case 3:
                    System.out.print("Digite o ID do pet que deseja excluir: ");
                    int idExclusao = scanner.nextInt();
                    Pet petParaExcluir = petController.buscarPetPorId(idExclusao);
                    if (petParaExcluir != null) {
                        petController.removerPet(petParaExcluir.getId());
                        System.out.println("|");
                        System.out.println("Pet removido com sucesso!");
                    } else {
                        System.out.println("|");
                        System.out.println("Nenhum pet encontrado com o ID informado.");
                    }
                    break;
                case 4:
                    System.out.print("Digite o ID do pet: ");
                    int idBusca = scanner.nextInt();
                    Pet petEncontrado = petController.buscarPetPorId(idBusca);
                    if (petEncontrado != null) {
                        System.out.println("|");
                        System.out.println("Pet encontrado: " + petEncontrado.getNome());
                    } else {
                        System.out.println("|");
                        System.out.println("Nenhum pet encontrado com o ID informado.");
                    }
                    break;
                case 5:
                    List<Pet> pets = petController.listarPets();
                    System.out.println("Lista de pets:");
                    if (!pets.isEmpty()) {
                        System.out.println("|");
                        for (Pet pet : pets) {
                            System.out.println("ID: " + pet.getId() + ", Nome: " + pet.getNome());
                        }
                    }
                    else {
                        System.out.println("|");
                        System.out.println("Nenhum pet encontrado.");
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
        scanner.close();
    }
}
