package com.pedroavila.features.branchOffices.get;

import com.pedroavila.models.BranchOffice;

import java.util.List;

public record GetBranchOfficeResult(List<BranchOffice> branchOffices) {
}
