package com.tripoin.pos.rest.desktop.endpoint;

import com.tripoin.scaffolding.data.dto.ResponseData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created on 11/3/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RequestMapping("/datasource")
public interface ITesterDataSourceEndPoint {

    @ResponseBody
    @GetMapping(
            value = {"/test"},
            produces = {"application/json"}
    )
    public ResponseData test();
}
