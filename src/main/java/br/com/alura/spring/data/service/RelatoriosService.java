package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Service
public class RelatoriosService {

    private Boolean system = true;

    private final DateTimeFormatter dtf= DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final FuncionarioRepository funcionarioRepository;

    @Autowired
    public RelatoriosService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void inicial(Scanner scanner) {
        while(system) {
            System.out.println("Qual acao de cargo deseja executar");
            System.out.println("0 - Sair");
            System.out.println("1 - Buscar Funcionario");
            System.out.println("2 - Buscar Funcionario por nome");
            System.out.println("3 - Buscar Funcionario por data de contratacao");

            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    buscaFuncionarioNome(scanner);
                    break;
                case 2:
                    buscaFuncionarioNomeSararioMaiorData(scanner);
                    break;
                case 3:
                    buscaFuncionarioDataContratacao(scanner);
                    break;
                default:
                    system = false;
                    break;
            }

        }

    }

    public void buscaFuncionarioNome(Scanner scanner){
        System.out.println("Qual Nome deseja pesquisar?");
        String nome = scanner.next();

        List<Funcionario> funcionarioList = funcionarioRepository.findByNome(nome);
        funcionarioList.forEach(System.out::println);
    }

    private void buscaFuncionarioNomeSararioMaiorData(Scanner scanner){
        System.out.println("Qual nome deseja pesquisar:");
        String nome = scanner.next();

        System.out.println("Qual data de contratacao deseja pesquisar:");
        String data = scanner.next();
        LocalDate localDate = LocalDate.parse(data,dtf);

        System.out.println("Qual salario deseja pesquisar:");
        Double salario = scanner.nextDouble();

        List<Funcionario> funcionarioList = funcionarioRepository
                .findNomeSalarioMaiorDataContratacao(nome,salario,localDate);
        funcionarioList.forEach(System.out::println);
    }

    private void buscaFuncionarioDataContratacao(Scanner scanner){
        System.out.println("Qual data de contratacao deseja pesquisar:");
        String data = scanner.next();
        LocalDate localDate = LocalDate.parse(data,dtf);

        List<Funcionario> funcionarioList = funcionarioRepository.findContratacaoMaior(localDate);
        funcionarioList.forEach(System.out::println);
    }
}
