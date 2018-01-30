package dto;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CustomerAccountDTO {
    private final String rid;
    private final String companyName;
    private final String companyScale;
    private final String companyAddress;
    private final Date submitDate;

    public CustomerAccountDTO(String companyName, String companyScale,
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
