//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package nc.pubitf.so.m30.api.rest;

import java.util.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import nc.bs.framework.common.NCLocator;
import nc.bs.framework.server.ISecurityTokenCallback;
import nc.itf.uap.IUAPQueryBS;
import nc.jdbc.framework.processor.ColumnProcessor;
import nc.jdbc.framework.processor.MapListProcessor;
import nc.pubitf.so.pub.api.rest.AbstractSORestResource;
import nc.vo.pub.BusinessException;
import nc.vo.scmpub.api.rest.utils.RestUtils;
import nc.vo.so.m30.PagingParamsVO;
import nc.vo.so.m30.QueryCountVO;
import org.json.JSONString;

@Path("service")
public class YSaleOrderResource extends AbstractSORestResource {
    static {
        VIEW_NAME = "view_aurora_mxb";
    }
    //视图
    private static final String VIEW_NAME;

    @POST
    @Path("getSelfHoldingData")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public JSONString getSelfHoldingData(JSONObject json) throws BusinessException {
        List tempList = new ArrayList();
        Map<String, List> returnDataMap = new HashMap<String, List>();
        try {
            RestUtils.initInvocationInfo();
            PagingParamsVO pagingParamsVO = new Gson().fromJson(json.toString(), PagingParamsVO.class);
            //获取分页前的数据总量
            int totalData = getCount(json, new QueryCountVO());
            if (pagingParamsVO.getPageIndex() <= 0 || pagingParamsVO.getPageSize() <= 0) {
                return RestUtils.toJSONString(new String("页码值或页总量输入有误！"));
            } else if (totalData == 0) {
                return RestUtils.toJSONString(new String("查询到的数据量为0"));
            } else if (pagingParamsVO.getPageIndex() > (totalData / pagingParamsVO.getPageSize())) {
                //访问页数超过总页数，页码不存在
                return RestUtils.toJSONString(new String("访问页数超过总页数，页码不存在"));
            } else if (pagingParamsVO.getPageIndex() <= (totalData / pagingParamsVO.getPageSize())) {
                NCLocator.getInstance().lookup(ISecurityTokenCallback.class).token("NCSystem".getBytes(), "pfxx".getBytes());
                StringBuilder whereClause = new StringBuilder();
                whereClause.append(" WHERE yearmonth >= '").append(pagingParamsVO.getStartDate());
                whereClause.append("' and yearmonth <= '").append(pagingParamsVO.getEndDate());
                whereClause.append("' and projectstagecode = '").append(pagingParamsVO.getProjectStageCode());
                whereClause.append("' and code = '").append(pagingParamsVO.getCompanyCode());
                whereClause.append("' and kmlx = '").append(pagingParamsVO.getAccountType()).append("'");
//            whereClause.append(" and datatype = ").append(queryCountVO.getDataType());

                //分页
                String sql = "SELECT * FROM (SELECT t.*,rownum rn FROM(select * from " + VIEW_NAME + whereClause + " )t )WHERE rn BETWEEN (" + pagingParamsVO.getPageIndex() + "-1)*" + pagingParamsVO.getPageSize() + "+1 AND " + pagingParamsVO.getPageIndex() * pagingParamsVO.getPageSize();
                IUAPQueryBS bs = NCLocator.getInstance().lookup(IUAPQueryBS.class);
                List<Map<String, String>> queryList = (List<Map<String, String>>) bs.executeQuery(sql, new MapListProcessor());
                //组装接口的返回值
                for (Map<String, String> map : queryList) {
                    Map<String, String> tempMap = new LinkedHashMap<String, String>();
                    String retProjectStageGUID = map.get("projectstageguid");
                    tempMap.put("ProjectStageGUID", retProjectStageGUID);
                    String retProjectStageName = map.get("projectstagename");
                    tempMap.put("ProjectStageName", retProjectStageName);
                    String retProjectStageCode = map.get("projectstagecode");
                    tempMap.put("ProjectStageCode", retProjectStageCode);
                    String retItemName = map.get("itemname");
                    tempMap.put("ItemName", retItemName);
                    //ItemValue对应的值为BigDecimal型，直接转String会报错
                    Object object = map.get("itemvalue");
                    String retItemValue = String.valueOf(object);
                    tempMap.put("ItemValue", retItemValue);
                    String retYearMonth = map.get("yearmonth");
                    tempMap.put("YearMonth", retYearMonth);
                    tempList.add(tempMap);
                }
                returnDataMap.put("Data", tempList);
                return tempList == null ? RestUtils.toJSONString(new String("查询数据为空")) : RestUtils.toJSONString(returnDataMap);
            }
        } catch (Exception e) {
            return RestUtils.toJSONString("操作异常，报错信息如下：" + e.getMessage());
        }
        return tempList == null ? RestUtils.toJSONString(new String("查询数据为空")) : RestUtils.toJSONString(returnDataMap);
    }

    @POST
    @Path("getSelfHoldingDataCount")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public JSONString getSelfHoldingDataCount(JSONObject json) throws BusinessException {
        Map<String, Integer> totalDataMap = new HashMap<String, Integer>(1);
        Map<String, Map> returnDataMap = new HashMap<String, Map>(1);
        try {
            RestUtils.initInvocationInfo();
            totalDataMap.put("TotalData", getCount(json, new QueryCountVO()));
            returnDataMap.put("Data", totalDataMap);
        } catch (Exception e) {
            return RestUtils.toJSONString("操作异常，报错信息如下：" + e.getMessage());
        }
        return RestUtils.toJSONString(returnDataMap);
    }

    private int getCount(JSONObject json, Object obj) throws BusinessException {
        Integer dataCounts = -1;
        if (obj instanceof QueryCountVO) {
            NCLocator.getInstance().lookup(ISecurityTokenCallback.class).token("NCSystem".getBytes(), "pfxx".getBytes());
            QueryCountVO queryCountVO = new Gson().fromJson(json.toString(), QueryCountVO.class);
            StringBuilder whereClause = new StringBuilder();
            whereClause.append(" WHERE yearmonth >= '").append(queryCountVO.getStartDate());
            whereClause.append("' and yearmonth <= '").append(queryCountVO.getEndDate());
            whereClause.append("' and projectstagecode = '").append(queryCountVO.getProjectStageCode());
            whereClause.append("' and code = '").append(queryCountVO.getCompanyCode());
            whereClause.append("' and kmlx = '").append(queryCountVO.getAccountType()).append("'");
//            whereClause.append(" and datatype = ").append(queryCountVO.getDataType());
            String sql = "SELECT COUNT(*) FROM " + VIEW_NAME + whereClause;
            IUAPQueryBS bs = NCLocator.getInstance().lookup(IUAPQueryBS.class);
            dataCounts = (Integer) bs.executeQuery(sql, new ColumnProcessor());
        }
        return dataCounts.intValue();
    }
}
