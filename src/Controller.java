package src;

import src.Domain.Characteren;
import src.Domain.Produkte;
import src.Repository.Repository;
import src.Repository.inMemoryRepo;

import java.util.List;

public class Controller {
    Repository<Characteren> characterenRepo = new inMemoryRepo<>();
    Repository<Produkte> produkteRepository = new inMemoryRepo<>();

    Produkte createProdukt(String name, Double price, String univerzum) {
        Produkte produkt = new Produkte(name, price, univerzum);
        produkteRepository.add(produkt);
        return produkt;
    }

    void removeProdukt(String name){
        produkteRepository.remove(name);
    }

    Produkte updateProduct(String name, Double price, String univerzum) {
        Produkte produkt = new Produkte(name, price, univerzum);
        produkteRepository.update(produkt);
        return produkt;
    }

    Produkte getProdukt(String name){
        return produkteRepository.get(name);
    }

    /**
     * Retrieves all the products available in the repository.
     * @return a list of all Produkte objects from the repository
     */
    List<Produkte> getAllProdukten(){
        return produkteRepository.getAll();
    }


    Characteren createCharacter(Integer id, String name, String region, List<Produkte> produkteList) {
        Characteren characteren = new Characteren(id, name, region, produkteList);
        characterenRepo.add(characteren);
        return characteren;
    }

    /**
     * Removes a character from the repository using their unique identifier.
     * @param name the unique identifier of the character to be removed
     */
    void removeCharacteren(String name){
        characterenRepo.remove(name);
    }

    /**
     * Updates an existing character's details and saves the updated information into the repository.
     * @param id the unique identifier of the character to update
     * @param name the new name of the character
     * @param region the new diagnosis of the character
     * @param produkteList the new list of products of the character
     * @return the updated Characteren object
     */
    Characteren updateCharacteren(Integer id, String name, String region, List<Produkte> produkteList) {
        Characteren characteren = new Characteren(id, name, region, produkteList);
        characterenRepo.update(characteren);
        return characteren;
    }

    Characteren getCharacteren(String name){
        return characterenRepo.get(name);
    }

    /**
     * Retrieves a list of all characters from the repository.
     * @return a list of Characteren objects representing all characters in the repository
     */
    List<Characteren> getAllCharacteren(){
        return characterenRepo.getAll();
    }

    List<Characteren> filterRegion(String region){
        return getAllCharacteren()
                .stream()
                .filter(characteren-> characteren.getRegion().equalsIgnoreCase(region))
                .toList();
    }

    List<Characteren> getCharacterenMitProdukteAufUniverzum(String univerzum){
        return getAllCharacteren()
                .stream()
                .filter(patienten -> patienten.getProdukteList().stream()
                        .anyMatch(medikamente -> medikamente.getUniverzum().equalsIgnoreCase(univerzum))
                )
                .toList();
    }

    List<Produkte> getProdukteSortedNachPreis(Characteren characteren, String sort){
        return characteren.getProdukteList()
                .stream()
                .sorted((m1, m2)->sort.equalsIgnoreCase("asc") ?
                        Double.compare(m1.getPrice(), m2.getPrice()) :
                        Double.compare(m2.getPrice(), m1.getPrice()))
                .toList();
    }

}