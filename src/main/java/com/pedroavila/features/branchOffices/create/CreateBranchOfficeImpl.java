package com.pedroavila.features.branchOffices.create;

import com.pedroavila.repository.BranchOfficeRepository;
import com.pedroavila.models.BranchOffice;
import com.pedroavila.models.enums.StatusBranchOffice;
import com.pedroavila.operations.common.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class CreateBranchOfficeImpl implements CreateBranchOffice {

    private final BranchOfficeRepository branchOfficeRepository;

    public CreateBranchOfficeImpl(BranchOfficeRepository branchOfficeRepository) {
        this.branchOfficeRepository = branchOfficeRepository;
    }

    @Transactional
    @Override
    public CreateBranchOfficeResult save(CreateBranchOfficeCommad command) {

        var branch = new BranchOffice();
        branch.setCompanyId(command.companyId());
        branch.setName(command.name());
        branch.setAddress(command.address());
        branch.setPhone(command.phone());
        branch.setCode(branchOfficeRepository.generarCodigo(branch.getCompanyId()));
        branch.setStatus(StatusBranchOffice.ENABLED.getValue());
        branch.setCreationDate(new Date());

        boolean existName = branchOfficeRepository.existsByCompanyIdAndName(branch.getCompanyId(), branch.getName());
        if (existName)
            throw new BusinessException("El nombre de la sucursal ya existe", HttpStatus.BAD_REQUEST.value());

        branchOfficeRepository.save(branch);
        return new CreateBranchOfficeResult(branch.getId(), branch.getCompanyId(), branch.getCode(),
                branch.getName(), branch.getAddress(), branch.getPhone(), branch.getStatus(), branch.getCreationDate());
    }
}
