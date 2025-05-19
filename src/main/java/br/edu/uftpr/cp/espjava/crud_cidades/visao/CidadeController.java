package br.edu.uftpr.cp.espjava.crud_cidades.visao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import java.util.Set;


@Controller
public class CidadeController {

    @GetMapping("/") 
    public String listar(Model memoria){

        var cidades = Set.of(
            new Cidade("Londrina", "PR"),
            new Cidade("Maringá", "PR"),
            new Cidade("Curitiba", "PR"),
            new Cidade("São Paulo", "SP")
        );

        memoria.addAttribute("cidades", cidades);
        
        return "/crud";
    }
}
