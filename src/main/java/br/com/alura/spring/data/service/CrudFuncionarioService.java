package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.UnidadeDeTrabalho;
import br.com.alura.spring.data.repository.CargoRepository;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import br.com.alura.spring.data.repository.UnidadeDeTrabalhoRepository;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.emitter.ScalarAnalysis;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

@Service
public class CrudFuncionarioService {

    public final FuncionarioRepository funcionarioRepository;
    public final CargoRepository cargoRepository;
    public final UnidadeDeTrabalhoRepository unidadeDeTrabalhoRepository;

    private Boolean system = true;

    public final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public CrudFuncionarioService(FuncionarioRepository funcionarioRepository, CargoRepository cargoRepository, UnidadeDeTrabalhoRepository unidadeDeTrabalhoRepository) {
        this.funcionarioRepository = funcionarioRepository;
        this.cargoRepository = cargoRepository;
        this.unidadeDeTrabalhoRepository = unidadeDeTrabalhoRepository;
    }

    public void inicial(Scanner scanner){

    }

    public void salvar(Scanner scanner){

        System.out.println("NOME:");
        scanner.nextLine();
        String nome = scanner.nextLine();

        System.out.println("CPF:");
        String cpf = scanner.next();

        System.out.println("SALÁRIO:");
        Double salario = scanner.nextDouble();

        System.out.println("DATA DE CONTRATACAO:");
        String dataContratacao = sdf.format(scanner.next());

        System.out.println("DIGITE O ID DO CARGO:");
        Integer id = scanner.nextInt();

        List<UnidadeDeTrabalho> unidades = un

    }
}
