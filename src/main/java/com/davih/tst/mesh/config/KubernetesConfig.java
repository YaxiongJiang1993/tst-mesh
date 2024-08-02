package com.davih.tst.mesh.config;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Configuration
public class KubernetesConfig {

    @Bean
    public static KubernetesClient k8sClient() {
        String kubeConfig = "apiVersion: v1\n" +
                "clusters:\n" +
                "- cluster:\n" +
                "    certificate-authority-data: LS0tLS1CRUdJTiBDRVJUSUZJQ0FURS0tLS0tCk1JSURCVENDQWUyZ0F3SUJBZ0lJSjdiTi9OR1k5bFV3RFFZSktvWklodmNOQVFFTEJRQXdGVEVUTUJFR0ExVUUKQXhNS2EzVmlaWEp1WlhSbGN6QWVGdzB5TkRBek1qRXdOVFEwTkRSYUZ3MHpOREF6TVRrd05UUTVORFJhTUJVeApFekFSQmdOVkJBTVRDbXQxWW1WeWJtVjBaWE13Z2dFaU1BMEdDU3FHU0liM0RRRUJBUVVBQTRJQkR3QXdnZ0VLCkFvSUJBUUM2clhNNEFTcERXVFdBcjU5YmUwMHBtanQzUnFndzNJeUc1a1ZjZlZGaWpCNE03VjlOV1VVU1BkbE4KZmFKZWNSZEFwMTA0bmhuNjYvMUV5U211eFRkNDh0Q0xvdG5jdkorRE9uVHByVDRXOWJGcXZPVjg3SklhZk9xbgpBWkFWaVE5TnBiSlFvakdZdE42YnNhWTRRY0pJTVlTTVlJazBOWWZwTW5RZ1JmcnNtWkJwWVVTRk5STVdwbmZPClBJT21pVjVYcGxXM3NXUlcxMW5zWTEyWDNGV2dIcVBEbVprVzdYbXp5MnpST3VYUytQMURFc1F2RG5aQzdUV1EKN0dLd21KKzUyZVc3OXY1c0lZVTViR2l2YmJlalEzWVJGUzJlaUROMjdGdngwcXloUzhPSVBwMmZra1luWllRcApMdmpwdEdYVUFCZUJkZ05JVEtaWXJCVEdJMFY3QWdNQkFBR2pXVEJYTUE0R0ExVWREd0VCL3dRRUF3SUNwREFQCkJnTlZIUk1CQWY4RUJUQURBUUgvTUIwR0ExVWREZ1FXQkJTVGJ0K0pLdVMwcStMUTJ2VHZ4dUVYN1h1MWJ6QVYKQmdOVkhSRUVEakFNZ2dwcmRXSmxjbTVsZEdWek1BMEdDU3FHU0liM0RRRUJDd1VBQTRJQkFRQVIwL296L1FKaQpxcko4cUlIa2pOSWRhdmdESS96bkNmNXhQdGdRcjVsWGwyQjZEeC9NVmZmbDI2TEpxSXlXYnVvTEFTelZHcXljClVIMk94WDZNaGhoeCtuZVE0WnJnVnBtQ1k1c0djcWV1dUMrYWNONnpuUlI1UlFVVWE4TkJjQTZRMDVZWTZUakoKdTlYUHRrS1hGTVluSkR5bUdvU3ZYc0FDZ29OMkJMM0Y0YWVFMDZodUV1Qzd0VTFpN2RtYjBQbUJHdUpRRzJqbgpoaXlpM2lBZGFLOXNlcnVIZjk0TFJFc05QVW13NXNwYzJOcVNJZWF6SDZ6OHpqazY2ZTBpUlB3N04ySEJvTWROCi81M0NtbjBQa2VGSWkwWEJSNjlZOUdySTU1ckJQdm5YUTlnYlBnSlFyK3VMM25ydFM0OFdGRWJvZlVjaFlxMkkKcFFDNzJDNGsrUnN4Ci0tLS0tRU5EIENFUlRJRklDQVRFLS0tLS0K\n" +
                "    server: https://D5E69005403C73A8233C6852E4BEBAD6.gr7.us-west-2.eks.amazonaws.com\n" +
                "  name: arn:aws:eks:us-west-2:382715584039:cluster/bigdata-mkt\n" +
                "contexts:\n" +
                "- context:\n" +
                "    cluster: arn:aws:eks:us-west-2:382715584039:cluster/bigdata-mkt\n" +
                "    user: arn:aws:eks:us-west-2:382715584039:cluster/bigdata-mkt\n" +
                "  name: arn:aws:eks:us-west-2:382715584039:cluster/bigdata-mkt\n" +
                "current-context: arn:aws:eks:us-west-2:382715584039:cluster/bigdata-mkt\n" +
                "kind: Config\n" +
                "preferences: {}\n" +
                "users:\n" +
                "- name: arn:aws:eks:us-west-2:382715584039:cluster/bigdata-mkt\n" +
                "  user:\n" +
                "    exec:\n" +
                "      apiVersion: client.authentication.k8s.io/v1beta1\n" +
                "      args:\n" +
                "      - --region\n" +
                "      - us-west-2\n" +
                "      - eks\n" +
                "      - get-token\n" +
                "      - --cluster-name\n" +
                "      - bigdata-mkt\n" +
                "      - --output\n" +
                "      - json\n" +
                "      command: aws\n" +
                "\n";
        Config cfg = Config.fromKubeconfig(kubeConfig);
        cfg.setConnectionTimeout(2000);
        cfg.setRequestTimeout(60000);

        DefaultKubernetesClient client = new DefaultKubernetesClient(cfg);

        return client;
    }

    public static void main(String[] args) {
        try {
            String kubeconfig = new String(Files.readAllBytes(Paths.get("/home/david/test/config")));
            System.out.println(kubeconfig);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
