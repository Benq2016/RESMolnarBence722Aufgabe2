package src;

import src.Domain.Produkte;
import src.Repository.Repository;
import src.Repository.inMemoryRepo;

import java.util.List;

public class Controller {
    Repository<Produkte> produkteRepository = new inMemoryRepo<>();

    Produkte createProdukt(String name, Integer price, String univerzum) {
        Produkte produkt = new Produkte(name, price, univerzum);
        produkteRepository.add(produkt);
        return produkt;
    }

    void removeProdukt(String name){
        produkteRepository.remove(name);
    }

    Produkte updateProduct(String name, Integer price, String univerzum) {
        Produkte produkt = new Produkte(name, price, univerzum);
        produkteRepository.update(produkt);
        return produkt;
    }

    Produkte getProdukt(String name){
        return produkteRepository.get(name);
    }

    /**
     * Retrieves all the medicines available in the repository.
     * @return a list of all Produkte objects from the repository
     */
    List<Produkte> getAllProdukten(){
        return produkteRepository.getAll();
    }
}