package com.rafiandamira.Gudangproject.service.framework;

import com.rafiandamira.Gudangproject.entity.PasswordResetToken;

public interface PasswordResetTokenService {
    PasswordResetToken findByToken(String token);

    PasswordResetToken save(PasswordResetToken passwordResetToken);
}

