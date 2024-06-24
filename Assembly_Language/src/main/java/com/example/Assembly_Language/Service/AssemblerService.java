package com.example.Assembly_Language.Service;

import com.example.Assembly_Language.Model.ProgramResult;
import com.example.Assembly_Language.Repository.ProgramResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AssemblerService {

    @Autowired
    private ProgramResultRepository repository;

    public ProgramResult executeInstructions(String program) {
        String[] lines = program.split("\n");
        Map<String, Integer> registers = new HashMap<>();
        String result = "No SHOW instruction found";

        for (String line : lines) {
            line = line.trim();
            if (line.startsWith("MV")) {
                executeMV(line, registers);
            } else if (line.startsWith("ADD")) {
                executeADD(line, registers);
            } else if (line.startsWith("SHOW")) {
                result = executeSHOW(line, registers);
            }
        }

        ProgramResult programResult = new ProgramResult();
        programResult.setProgram(program);
        programResult.setResult(result);

        return repository.save(programResult);
    }

    private void executeMV(String line, Map<String, Integer> registers) {
        String[] parts = line.split(" ");
        String register = parts[1].replace(",", "");
        int value = Integer.parseInt(parts[2].replace("#", ""));
        registers.put(register, value);
    }

    private void executeADD(String line, Map<String, Integer> registers) {
        String[] parts = line.split(" ");
        String reg1 = parts[1].replace(",", "");
        String reg2 = parts[2];

        if (reg2.startsWith("#")) {
            int value = Integer.parseInt(reg2.replace("#", ""));
            registers.put(reg1, registers.getOrDefault(reg1, 0) + value);
        } else {
            registers.put(reg1, registers.getOrDefault(reg1, 0) + registers.getOrDefault(reg2, 0));
        }
    }

    private String executeSHOW(String line, Map<String, Integer> registers) {
        String[] parts = line.split(" ");
        String register = parts[1];
        return String.valueOf(registers.getOrDefault(register, 0));
    }
}
