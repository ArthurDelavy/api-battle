package com.ong.acolhepatinhas.api.auth.DTO;

import io.swagger.v3.oas.annotations.media.Schema;

public record TokenResponse(

    @Schema(example = "Yhue38493...", description = "Token JWT")
    String accessToken
) {
}
