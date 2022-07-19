package nc.vo.so.m30;

public class PagingParamsVO {
    //开始日期
    private String startDate;
    //结束日期
    private String endDate;
    //项目分期编码
    private String projectStageCode;
    //公司编码
    private String companyCode;
    //当前页
    private Integer pageIndex;
    //页总量
    private Integer pageSize;
    //总页数
    private Integer pageCount;
    //科目类型
    private String accountType;
    //汇总/明细
    private String dataType;

    public PagingParamsVO(String startDate, String endDate, String projectStageCode, String companyCode, Integer pageIndex, Integer pageSize, Integer pageCount, String accountType, String dataType) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.projectStageCode = projectStageCode;
        this.companyCode = companyCode;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.pageCount = pageCount;
        this.accountType = accountType;
        this.dataType = dataType;
    }
    public PagingParamsVO(){
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

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
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
        return "MYParamsVO{" +
                "StartTime='" + startDate + '\'' +
                ", EndYear='" + endDate + '\'' +
                ", projectCode='" + projectStageCode + '\'' +
                ", companyCode='" + companyCode + '\'' +
                ", pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", totalData=" + pageCount +
                ", accountType='" + accountType + '\'' +
                ", dataType='" + dataType + '\'' +
                '}';
    }
}