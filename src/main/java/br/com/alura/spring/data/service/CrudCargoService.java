package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudCargoService {

    private final CargoRepository cargoRepository;
    private boolean system = true;

    public CrudCargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public void inicial(Scanner scanner){

        while(system){
            System.out.println("O QUE VOCÊ QUER FAZER?");
            System.out.println("0 - Sair");
            System.out.println("1 - Salvar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Visualizar");
            System.out.println("4 - Deletar");

            int escolha = scanner.nextInt();

            switch (escolha){
                case 1:
                    salvar(scanner);
                    break;
                case 2:
                    atualizar(scanner);
                    break;
                case 3:
                    visualizar();
                    break;
                case 4:
                    excluir(scanner);
                    break;
                default:
                    system = false;
            }
        }
    }

    public void salvar(Scanner scanner){
        System.out.println("Descrição do cargo:");
        scanner.nextLine();
        String decricao = scanner.nextLine();
        Cargo cargo = new Cargo();
        cargo.setDescricao(decricao);
        cargoRepository.save(cargo);
        System.out.println("Salvo!");
    }

    public void atualizar(Scanner scanner){
        System.out.println("Informar Id:");
        Integer id = scanner.nextInt();
        System.out.println("DESCRICAO DO CARGO");
        String descricao = scanner.next();
        Cargo cargo = new Cargo();
        cargo.setId(id);
        cargo.setDescricao(descricao);
        cargoRepository.save(cargo);
        System.out.println("ATUALIZAÇÃO OK!");
    }
    
    public void excluir(Scanner scanner){
        System.out.println("INFORMAR O ID");
        Integer id = scanner.nextInt();
        cargoRepository.deleteById(id);
        System.out.println("DELETADO COM SUCESSO");
    }

    public void visualizar(){
        Iterable<Cargo> cargos = cargoRepository.findAll();
        cargos.forEach(cargo -> System.out.println(cargo));
    }





}
