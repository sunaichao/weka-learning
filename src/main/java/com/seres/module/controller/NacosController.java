package com.seres.module.controller;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.NacosServiceManager;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class NacosController {

    @Autowired
    NacosDiscoveryProperties nacosDiscoveryProperties;

    @Autowired
    NacosServiceManager nacosRegistration;

    /**
     * 服务注册接口
     *
     * @return
     */
    @GetMapping(value = "/nacos/register")
    public String registerInstance() {
        String serviceName = nacosDiscoveryProperties.getService();
        String clusterName = nacosDiscoveryProperties.getClusterName();
        String ip = nacosDiscoveryProperties.getIp();
        int port = nacosDiscoveryProperties.getPort();
        log.info("register from nacos, serviceName:{}, clusterName:{}, ip:{}, port:{}", serviceName, clusterName, ip, port);
        try {
            nacosRegistration.getNamingService(nacosDiscoveryProperties.getNacosProperties()).registerInstance(serviceName, ip, port, clusterName);
        } catch (NacosException e) {
            log.warn("register from nacos error", e);
            return "error";
        }
        return "success";
    }

    @GetMapping(value = "/nacos/deregister")
    public String deregisterInstance() {
        String serviceName = nacosDiscoveryProperties.getService();
        String clusterName = nacosDiscoveryProperties.getClusterName();
        String ip = nacosDiscoveryProperties.getIp();
        int port = nacosDiscoveryProperties.getPort();
        log.info("deregister from nacos, serviceName:{}, clusterName:{}, ip:{}, port:{}", serviceName, clusterName, ip, port);
        try {
            NamingService service = nacosRegistration.getNamingService(nacosDiscoveryProperties.getNacosProperties());
            service.deregisterInstance(serviceName, ip, port, clusterName);
        } catch (NacosException e) {
            log.warn("deregister from nacos error", e);
            return "error";
        }
        return "success";
    }
}
