package com.pedroavila.rest;

import com.pedroavila.features.branchOffices.create.CreateBranchOffice;
import com.pedroavila.features.branchOffices.create.CreateBranchOfficeCommad;
import com.pedroavila.features.branchOffices.create.CreateBranchOfficeResult;
import com.pedroavila.features.branchOffices.get.GetBranchOffice;
import com.pedroavila.features.branchOffices.get.GetBranchOfficeQuery;
import com.pedroavila.features.branchOffices.get.GetBranchOfficeResult;
import com.pedroavila.models.BranchOffice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/branchoffices")
public class BranchOfficeController {

    private final CreateBranchOffice createBranchOffice;
    private final GetBranchOffice getBranchOffice;

    @Autowired
    public BranchOfficeController(CreateBranchOffice createBranchOffice, GetBranchOffice getBranchOffice) {
        this.createBranchOffice = createBranchOffice;
        this.getBranchOffice = getBranchOffice;
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getAllById(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(new CustomResponse<GetBranchOfficeResult>(HttpStatus.OK.value(), getBranchOffice.getAll(new GetBranchOfficeQuery(id))));
    }

    @PostMapping
    public ResponseEntity<?> createBranchOffice(@Valid @RequestBody CreateBranchOfficeCommad dto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new CustomResponse<CreateBranchOfficeResult>(HttpStatus.CREATED.value(), createBranchOffice.save(dto)));
    }
}
