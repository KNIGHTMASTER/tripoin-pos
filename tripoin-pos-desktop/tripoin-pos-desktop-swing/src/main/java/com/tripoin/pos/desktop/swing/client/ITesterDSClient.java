package com.tripoin.pos.desktop.swing.client;

import retrofit2.http.GET;

/**
 * Created on 11/3/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface ITesterDSClient {

    @GET("/datasource/test")
    public Integer getTestResult();
}
