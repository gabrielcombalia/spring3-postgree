package com.example.amigostutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/trabalhador")
public class AmigosTutorialApplication {

    private final TrabalhadorRepository trabalhadorRepository;

    public AmigosTutorialApplication(TrabalhadorRepository trabalhadorRepository) {
        this.trabalhadorRepository = trabalhadorRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(AmigosTutorialApplication.class, args);
    }

    @GetMapping
    public List<Trabalhador> getTrabalhador() {
//        return List.of();
        return trabalhadorRepository.findAll();
    }

    record NewTrabalhadorRequest (
            String nome,
            String profissao,
            Integer idade

    ) {}

    @PostMapping
    public void addTrabalhador(@RequestBody NewTrabalhadorRequest request) {
        Trabalhador trabalhador = new Trabalhador();
        trabalhador.setNome(request.nome);
        trabalhador.setIdade(request.idade);
        trabalhador.setProfissao(request.profissao);
        trabalhadorRepository.save(trabalhador);

    }

    @DeleteMapping("/deleta/{trabalhadorID}")
    public void deletaTrabalhador(@PathVariable("trabalhadorID") Integer id) {
        trabalhadorRepository.deleteById(id);
    }

//    @PutMapping("/altera/{trabalhadorID}")
//    public void deletaTrabalhador(@RequestBody("trabalhadorID") Integer id) {
//
//        trabalhadorRepository.save()
//    }

}
