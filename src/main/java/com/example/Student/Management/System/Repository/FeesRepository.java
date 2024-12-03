package com.example.Student.Management.System.Repository;

import com.example.Student.Management.System.Model.FeesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeesRepository extends JpaRepository<FeesModel,Long> {


}
