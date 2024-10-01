package com.pedroavila.features.branchOffices.create;

import java.util.Date;

public record CreateBranchOfficeResult(int id, int companyId, int code, String name, String address, String phone, int status, Date creationDate) {
}
