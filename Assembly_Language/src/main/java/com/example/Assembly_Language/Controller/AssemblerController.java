package com.example.Assembly_Language.Controller;

import com.example.Assembly_Language.Model.ProgramResult;

import com.example.Assembly_Language.Service.AssemblerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AssemblerController {

    @Autowired
    private AssemblerService assemblerService;

    @PostMapping("/execute")
    public ProgramResult executeInstructions(@RequestBody String program) {
        return assemblerService.executeInstructions(program);
    }
}
