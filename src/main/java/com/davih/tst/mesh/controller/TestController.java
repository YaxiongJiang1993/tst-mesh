package com.davih.tst.mesh.controller;

import io.fabric8.kubernetes.client.KubernetesClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/mesh/test")
public class TestController {

    private final KubernetesClient k8sClient;

    public TestController(@Lazy KubernetesClient k8sClient) {
        this.k8sClient = k8sClient;
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

}
