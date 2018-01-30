package service;

import model.CustomerAccount;
import model.EndUserAccount;

public interface AccountService {
    public EndUserAccount findUserByMobileNo(String mobileNo);

    public EndUserAccount findUserByUserName(String userName);

    public void saveUser(EndUserAccount user);

    public void saveCustomer(CustomerAccount customer);
}