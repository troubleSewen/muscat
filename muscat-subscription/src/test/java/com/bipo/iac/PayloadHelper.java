package com.bipo.iac;

import com.bipo.iac.dto.RegistrationDTO;

public class PayloadHelper {

    public static RegistrationDTO fakeRegistrationDTO() {
        return new RegistrationDTO(
                    "Company name",
                    "10~20",
                    "No. 89, Taixing Rd, Jingan, Shanghai",
                    "Hilary Lu",
                    "123456",
                    "18000000009");
    }
}
