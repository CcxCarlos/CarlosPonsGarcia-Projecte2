package net.jaumebalmes.cpons.basicform.formulari.controller;

import net.jaumebalmes.cpons.basicform.formulari.entitats.Alumne;
import net.jaumebalmes.cpons.basicform.formulari.entitats.Empresa;
import net.jaumebalmes.cpons.basicform.formulari.repositoris.AlumneDAO;
import net.jaumebalmes.cpons.basicform.formulari.repositoris.EmpresaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/alumnes")
public class AlumneControlador {
    @Autowired
    AlumneDAO alumneRepo;

    @Autowired
    EmpresaDAO empresaDAO;


    @GetMapping
    public String alumnes(Model model){
        model.addAttribute("alumnes", alumneRepo.findAll());
        return "alumnes/llista-alumnes";
    }

    @PostMapping("/alta")
    public String altaAlumne(@RequestParam("idEmpresa") long idEmpresa, Alumne alumne, Model model, Errors errors) {
        if(errors.hasErrors()) return "errors/page-not-found";

        if (alumneRepo.existsByDni(alumne.getDni())) {
            model.addAttribute("msj", "L'alumne amb el DNI " + alumne.getDni() + " ja " +
                    "existeix");
            return "alumnes/nouAlumne";
        }
        addEmpresa(alumne, (idEmpresa==-1) ? null : empresaDAO.findById(idEmpresa).get());
        return "redirect:/api/alumnes";
    }

    @GetMapping("/new")
    public String mostrarFormulariAlumne(Model model) {

        Alumne alumne = new Alumne();
        model.addAttribute("alumne", alumne);
        model.addAttribute("empreses", empresaDAO.findAll());

        return "alumnes/nouAlumne";
    }
    @GetMapping("/{id}")
    public String obtenerEstudiantPorId(@PathVariable("id") long id, Model model) {

        model.addAttribute("alumne", alumneRepo.findById(id).get());

        return "alumnes/perfil-alumne";
    }

    @GetMapping("/{id}/change-enterprise")
    public String afegirEmpresa(@PathVariable("id") long id, Model model) {
        model.addAttribute("alumne", alumneRepo.findById(id).get());
        model.addAttribute("empreses", empresaDAO.findAll());

        return "alumnes/change-enterprise";
    }
    @PostMapping("/{id}/added-enterprise")
    public String addedEmpresa(@PathVariable("id") long id, @RequestParam("idEmpresa") long idEmpresa, Model model) {
        addEmpresa(alumneRepo.findById(id).get(), (idEmpresa==-1) ? null : empresaDAO.findById(idEmpresa).get());
        return "redirect:/api/alumnes/" + id;
    }

    private void addEmpresa(Alumne alumne, Empresa empresa){
        System.out.println(empresa);
        alumne.setEmpresa(empresa);
        alumneRepo.save(alumne);
    }
}