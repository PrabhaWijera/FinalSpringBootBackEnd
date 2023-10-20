package com.example.prabhash.guideserver.fiegn;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("GUIDE-SERVER")
public interface GuideInterface {

}
