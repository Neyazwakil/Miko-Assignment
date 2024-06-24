package com.example.Assembly_Language.Repository;

;
import com.example.Assembly_Language.Model.ProgramResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramResultRepository extends JpaRepository<ProgramResult, Long> {
}
