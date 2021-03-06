/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker-com*/
package com.salesdb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wavemaker.runtime.data.dao.query.WMQueryExecutor;
import com.wavemaker.runtime.data.export.ExportOptions;
import com.wavemaker.runtime.data.model.QueryProcedureInput;

import com.salesdb.models.query.*;

@Service
public class SalesdbQueryExecutorServiceImpl_V1 implements SalesdbQueryExecutorService_V1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(SalesdbQueryExecutorServiceImpl.class);

    @Autowired
    @Qualifier("salesdbWMQueryExecutor")
    private WMQueryExecutor queryExecutor;

    @Transactional(value = "salesdbTransactionManager", readOnly = true)
    @Override
    public Page<Object> executeTopTrendingProducts(Pageable pageable) {
        Map params = new HashMap(0);


        return queryExecutor.executeNamedQuery("topTrendingProducts", params, Object.class, pageable);
    }

}