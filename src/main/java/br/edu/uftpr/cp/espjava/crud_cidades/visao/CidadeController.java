package br.edu.uftpr.cp.espjava.crud_cidades.visao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;


@Controller
public class CidadeController {

    private Set<Cidade> cidades;

    public CidadeController(){
        cidades = new HashSet<>();
    }

    @GetMapping("/") 
    public String listar(Model memoria){

        memoria.addAttribute("listaCidades", cidades);
        
        return "/crud";
    }

    @PostMapping("/criar")
    public String criar(Cidade cidade) {
        
        cidades.add(cidade);
        return "redirect:/";
    }   

}
