package controller;

import DAO.PetDAO;
import model.Pet;

import java.util.List;

public class PetController {

    private final PetDAO petDAO;

    public PetController(PetDAO petDAO) {
        this.petDAO = petDAO;
    }

    public void adicionarPet(String nome) {
        Pet pet = new Pet(nome);
        petDAO.adicionarPet(pet);
    }

    public void removerPet(int id) {
        petDAO.removerPet(id);
    }

    public Pet buscarPetPorId(int id) {
        return petDAO.buscarPetPorId(id);
    }

    public List<Pet> listarPets() {
        return petDAO.listarPets();
    }

}
