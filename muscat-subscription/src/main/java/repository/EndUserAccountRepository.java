package repository;

import model.EndUserAccount;
import org.springframework.stereotype.Repository;

@Repository("EndUserAccountRepository")
public interface EndUserAccountRepository {
    EndUserAccount findByMobileNo(String mobileNo);

    EndUserAccount findByUsername(String username);
}