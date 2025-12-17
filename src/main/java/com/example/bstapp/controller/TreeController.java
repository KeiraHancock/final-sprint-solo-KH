package com.example.bstapp.controller;

import com.example.bstapp.repo.TreeResultRepository;
import com.example.bstapp.service.TreeService;
import com.example.bstapp.service.TreeDtos.TreeResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TreeController {

    private final TreeService service;
    private final TreeResultRepository repo;

    public TreeController(TreeService service, TreeResultRepository repo) {
        this.service = service;
        this.repo = repo;
    }

    @GetMapping("/enter-numbers")
    public String enter() {
        return "enter-numbers";
    }

    @PostMapping("/process-numbers")
    @ResponseBody
    public TreeResponse process(
            @RequestParam("numbers") String numbers,
            @RequestParam(value = "balanced", defaultValue = "false") boolean balanced
    ) throws Exception {
        return service.process(numbers, balanced);
    }

    @GetMapping("/previous-trees")
    public String previous(Model model) {
        model.addAttribute("results", repo.findAll());
        return "previous-trees";
    }
}
