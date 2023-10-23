package com.example.prabhash.guideserver.fiegn;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("guide-service")
public interface GuideInterface {

}
