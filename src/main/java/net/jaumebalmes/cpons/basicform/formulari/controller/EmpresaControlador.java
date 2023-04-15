package net.jaumebalmes.cpons.basicform.formulari.controller;

import net.jaumebalmes.cpons.basicform.formulari.entitats.Empresa;
import net.jaumebalmes.cpons.basicform.formulari.repositoris.EmpresaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/empreses")
public class EmpresaControlador {
    @Autowired
    EmpresaDAO empresaRepo;

    @GetMapping
    public String empreses(Model model){
        model.addAttribute("empreses", empresaRepo.findAll());

        return "empreses/llista-empreses";

    }

    @PostMapping("/alta")
    public String altaEmpresa(Empresa empresa, Model model, Errors errors) {
        if(errors.hasErrors()) return "errors/page-not-found";
        if (empresaRepo.existsByCif(empresa.getCif())) {
            model.addAttribute("msj", "L'empresa amb el CIF " + empresa.getCif() + " ja " +
                    "existeix");
            return "empreses/novaEmpresa";
        }
        empresaRepo.save(empresa);
        return "redirect:/api/empreses";
    }

    @GetMapping("/new")
    public String mostrarFormulariEmpresa(Model model) {

        Empresa empresa = new Empresa();
        model.addAttribute("empresa", empresa);

        return "empreses/novaEmpresa";
    }

    @GetMapping("/{id}")
    public String obtenerEstudiantPorId(@PathVariable("id") long id, Model model) {

        model.addAttribute("empresa", empresaRepo.findById(id).get());

        return "empreses/perfil-empresa";
    }
}

