package com.tripoin.pos.rest.desktop.endpoint.impl;

import com.tripoin.pos.shared.data.DataSourceParam;
import com.tripoin.pos.rest.desktop.endpoint.ITesterDataSourceEndPoint;
import com.tripoin.pos.rest.desktop.util.TesterDS;
import com.tripoin.pos.shared.data.util.IPropertyModifier;
import com.tripoin.scaffolding.data.constant.EResponseCode;
import com.tripoin.scaffolding.data.dto.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 11/3/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
public class TesterDataSourceEndPointImpl implements ITesterDataSourceEndPoint {

    @Autowired
    private TesterDS testerDS;

    @Autowired
    IPropertyModifier propertyModifier;

    @Override
    public ResponseData test() {
        DataSourceParam dataSourceParam = propertyModifier.loadDataSourceSetting();
        ResponseData responseData = new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg());
        testerDS.setParam(dataSourceParam);
        if (testerDS.testMysqlConnection() == 1){
            responseData = new ResponseData(EResponseCode.RC_SUCCESS.getResponseCode(), EResponseCode.RC_SUCCESS.getResponseMsg());
        }
        return responseData;
    }
}
