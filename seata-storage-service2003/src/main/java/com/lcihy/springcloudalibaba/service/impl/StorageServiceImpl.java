package com.lcihy.springcloudalibaba.service.impl;

import com.lcihy.springcloudalibaba.dao.StorageDao;
import com.lcihy.springcloudalibaba.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorageServiceImpl implements StorageService {
    private final Logger logger = LoggerFactory.getLogger(StorageServiceImpl.class);
    @Autowired
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        logger.info("storage-service扣减库存");
        storageDao.decrease(productId,count);
        logger.info("storage-service扣减结束");
    }
}
