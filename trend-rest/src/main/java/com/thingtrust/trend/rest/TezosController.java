package com.thingtrust.trend.rest;

import com.thingtrust.trend.common.model.ResponseResult;
import com.thingtrust.trend.common.mybatis.pager.PageInfo;
import com.thingtrust.trend.entity.BalanceEmtity;
import com.thingtrust.trend.service.TezosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/tezos")
@Slf4j
public class TezosController {
    @Autowired
    private TezosService tezosService;

    @GetMapping("/query-balance")
    public ResponseResult queryBalance(final String address) {
        final BalanceEmtity balanceEmtity = tezosService.queryBalance(address);
        return ResponseResult.success(balanceEmtity);
    }

    @GetMapping("/baking-history")
    public ResponseResult bakingHistory(final int p, final int number, final String address) {
        final PageInfo pageInfo = tezosService.bakingHistory(p, number, address);
        return ResponseResult.success(pageInfo);
    }


    @GetMapping("/endor-history")
    public ResponseResult endorHistory(final int p, final int number, final String address) {
        final PageInfo pageInfo = tezosService.endorsementHistory(p, number, address);
        return ResponseResult.success(pageInfo);
    }


    @GetMapping("/baking-rights")
    public ResponseResult bakingRights(final int p, final int number, final String address, final int cycle) {
        final PageInfo pageInfo = tezosService.queryBakingRights(p, number, address, cycle);
        return ResponseResult.success(pageInfo);
    }


    @GetMapping("/cycle-details")
    public ResponseResult cycle(final int p, final int number, final String address, final int cycle) {
        final PageInfo pageInfo = tezosService.CycleDetails(p, number, address, cycle);
        return ResponseResult.success(pageInfo);
    }

    @GetMapping("/endor-rights")
    public ResponseResult endorRights(final int p, final int number, final String address, final int cycle) {
        final PageInfo pageInfo = tezosService.endorsementRights(p, number, address, cycle);
        return ResponseResult.success(pageInfo);
    }

    @GetMapping("/endor-cycle")
    public ResponseResult endorCycle(final int p, final int number, final String address, final int cycle) {
        final PageInfo pageInfo = tezosService.EndorCycle(p, number, address, cycle);
        return ResponseResult.success(pageInfo);
    }


}
