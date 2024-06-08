package com.oceanguard.controller;

import com.oceanguard.models.Observation;
import com.oceanguard.repository.ObservationRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/observations")
public class ObservationController {

    private final ObservationRepository observationRepository;

    @Autowired
    public ObservationController(ObservationRepository observationRepository) {
        this.observationRepository = observationRepository;
    }

    @GetMapping("/new")
    public String showObservationForm(Model model) {
        model.addAttribute("observation", new Observation());
        return "new_observation";
    }

    @PostMapping("/add")
    public String addObservation(@ModelAttribute("observation") Observation observation, RedirectAttributes redirectAttributes) {
        try {
            // Validação dos dados
            if (observation.getName() == null || observation.getName().isEmpty()) {
                throw new IllegalArgumentException("Nome da observação é obrigatório.");
            }

            // Salvando a observação no banco de dados
            observationRepository.save(observation);

            // Mensagem de feedback
            redirectAttributes.addFlashAttribute("successMessage", "Observação adicionada com sucesso.");
        } catch (IllegalArgumentException e) {
            // Tratamento de exceções
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        } catch (Exception e) {
            // Tratamento de exceções genéricas
            redirectAttributes.addFlashAttribute("errorMessage", "Erro ao adicionar observação.");
        }

        // Redirecionamento para a página inicial
        return "redirect:/";
    }
}
