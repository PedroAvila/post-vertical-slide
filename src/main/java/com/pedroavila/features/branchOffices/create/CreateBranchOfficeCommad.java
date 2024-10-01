package com.pedroavila.features.branchOffices.create;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateBranchOfficeCommad(
        @Min(value = 1, message = "El ID de la compañía debe ser mayor que 0")
        int companyId,

        @NotBlank
        String name,

        @NotBlank
        String address,

        @NotBlank
        @Size(max = 10, message = "El número de teléfono no puede tener más de 10 caracteres")
        String phone
) { }
