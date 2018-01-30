package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CustomerAccount {
    private String rid;
    private String companyName;
    private String companyScale;
    private String companyAddress;
    private Date submitDate;

    public CustomerAccount(String companyName, String companyScale,
                           String companyAddress) {
        this.companyName = companyName;
        this.companyScale = companyScale;
        this.companyAddress = companyAddress;
        this.submitDate = Calendar.getInstance().getTime();

        this.rid = String.format(this.companyName, 4) + getSubmitDate();
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getRid() {
        return rid;
    }

    public String getSubmitDate() {
        SimpleDateFormat dateFormatFull = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormatFull.format(submitDate);
    }
}
