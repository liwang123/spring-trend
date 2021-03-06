package com.thingtrust.trend.rest;

import com.thingtrust.trend.common.model.ResponseResult;
import com.thingtrust.trend.common.mybatis.pager.PageInfo;
import com.thingtrust.trend.dto.TezosStatusDTO;
import com.thingtrust.trend.entity.BalanceEmtity;
import com.thingtrust.trend.service.TezosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/list-tezos")
    public ResponseResult listTezos(final int index, final int length, final String address, final Integer cycle, final Integer status) {
        final PageInfo pageInfo = tezosService.listTezos(index, length, address, cycle, status);
        return ResponseResult.success(pageInfo);
    }

    @GetMapping("/set-fee")
    public ResponseResult setFee(final int cycle, final int fee) {
        final int i = tezosService.setFee(cycle, fee);
        return ResponseResult.success(i);
    }


    @PostMapping("/send-payment")
    public ResponseResult sendPayment(final Integer[] ids) {
        tezosService.sendPayment(ids);
        return ResponseResult.success();
    }

    @GetMapping("/query-status")
    public ResponseResult queryStatus(final Integer[] ids) {
        final List<TezosStatusDTO> tezosStatusDTOList = tezosService.queryStatus(ids);
        return ResponseResult.success(tezosStatusDTOList);
    }


}
