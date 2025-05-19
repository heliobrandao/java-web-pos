package br.edu.uftpr.cp.espjava.crud_cidades.visao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;
import org.springframework.web.bind.annotation.RequestBody;



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

    @GetMapping("/excluir")
    public String excluir(
        @RequestParam String nome,
        @RequestParam String estado){
        cidades.removeIf(cidade -> {
            return cidade.getNome().equals(nome) && 
            cidade.getEstado().equals(estado);
        });
        return "redirect:/";
    }

    @GetMapping("/preparaAlterar")
    public String preparaAlterar(
        @RequestParam String nome,
        @RequestParam String estado,
        Model memoria){
        
        var cidadeAtual = cidades
            .stream()
            .filter(cidade -> 
                cidade.getNome().equals(nome) && 
                cidade.getEstado().equals(estado))
            .findAny();
        
        if(cidadeAtual.isPresent()){
            memoria.addAttribute("cidadeAtual", cidadeAtual.get());
            memoria.addAttribute("listaCidades", cidades);
        }
        
        return "/crud";
    }

    @PostMapping("/alterar")
    public String alterar(
        @RequestParam String nomeAtual,
        @RequestParam String estadoAtual,
        Cidade cidade
    ){

        cidades.removeIf(cidadeAtual -> 
                            cidadeAtual.getNome().equals(nomeAtual) && 
                            cidadeAtual.getEstado().equals(estadoAtual)
        );

        criar(cidade);
        
        return "redirect:/";
    }
}
