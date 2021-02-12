package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudCargoService {

    private final CargoRepository cargoRepository;

    public CrudCargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public void inicial(Scanner scanner){
        salvar(scanner);
    }

    public void salvar(Scanner scanner){
        System.out.println("Descrição do cargo:");
        String decricao = scanner.next();
        Cargo cargo = new Cargo();
        cargo.setDescricao(decricao);
        cargoRepository.save(cargo);
        System.out.println("Salvo!");

    }


}