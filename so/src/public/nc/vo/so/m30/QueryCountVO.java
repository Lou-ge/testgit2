package nc.vo.so.m30;

public class QueryCountVO {
    //开始日期
    private String startDate;
    //结束日期
    private String endDate;
    //项目分期编码
    private String projectStageCode;
    //公司编码
    private String companyCode;
    //科目类型
    private String accountType;
    //汇总/明细
    private String dataType;

    public QueryCountVO(){
    }
    public QueryCountVO(String startDate, String endDate, String projectStageCode, String companyCode, String accountType, String dataType) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.projectStageCode = projectStageCode;
        this.companyCode = companyCode;
        this.accountType = accountType;
        this.dataType = dataType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getProjectStageCode() {
        return projectStageCode;
    }

    public void setProjectStageCode(String projectStageCode) {
        this.projectStageCode = projectStageCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @Override
    public String toString() {
        return "QueryCountVO{" +
                "startTime='" + startDate + '\'' +
                ", endYear='" + endDate + '\'' +
                ", projectCode='" + projectStageCode + '\'' +
                ", companyCode='" + companyCode + '\'' +
                ", accountType='" + accountType + '\'' +
                ", dataType='" + dataType + '\'' +
                '}';
    }
}
