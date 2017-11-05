package com.tripoin.pos.desktop.swing.client.impl;

import com.tripoin.pos.desktop.swing.client.ARetrofitRestClient;
import com.tripoin.pos.desktop.swing.client.ITesterDSClient;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created on 11/3/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class TesterDSClientImpl extends ARetrofitRestClient implements ITesterDSClient {

    private ITesterDSClient testerDSClient;

    @PostConstruct
    @Override
    public void initComponents() {
        testerDSClient = retrofitFactory.getRetrofit().create(ITesterDSClient.class);
    }

    @Override
    public Integer getTestResult() {
        return testerDSClient.getTestResult();
    }
}
