package DAO;

import model.Pet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PetDAO {

    private final Map<Integer, Pet> petMap = new HashMap<>();
    private int nextId = 1;

    public void adicionarPet(Pet pet) {
        pet.setId(nextId);
        proximoId();
        petMap.put(pet.getId(), pet);
    }

    private void proximoId() {
        this.nextId++;
    }

    public void removerPet(int id) {
        petMap.remove(id);
    }

    public Pet buscarPetPorId(int id) {
        return petMap.get(id);
    }

    public List<Pet> listarPets() {
        return new ArrayList<>(petMap.values());
    }
}
