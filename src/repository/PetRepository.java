package repository;

import model.Pet;

import java.util.List;

public interface PetRepository {

    void adicionarPet(Pet pet);
    Pet buscarPetPorId(int id);
    List<Pet> listarPets();
}
