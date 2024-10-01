package com.pedroavila.features.branchOffices.get;

import com.pedroavila.repository.BranchOfficeRepository;
import org.springframework.stereotype.Service;

@Service
public class GetBranchOfficeImpl implements GetBranchOffice {

    private final BranchOfficeRepository branchOfficeRepository;

    public GetBranchOfficeImpl(BranchOfficeRepository branchOfficeRepository) {
        this.branchOfficeRepository = branchOfficeRepository;
    }

    @Override
    public GetBranchOfficeResult getAll(GetBranchOfficeQuery query) {

        var result = branchOfficeRepository.findByCompanyId(query.id());
        return new GetBranchOfficeResult(result);
    }
}
