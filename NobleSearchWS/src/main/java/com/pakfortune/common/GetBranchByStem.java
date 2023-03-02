package com.pakfortune.common;

import com.pakfortune.model.element.Branch;
import com.pakfortune.model.element.Stem;

import static java.lang.Math.abs;

public class GetBranchByStem extends LookupImpl {

    public String calculate(String stem, String location) {
        FiveTigerHop ft = new FiveTigerHop();
        // 取地支序數
        int branchOrdinal = getIfPresent(Branch.class, location).ordinal();
        // 由序數計算飛遁天干
        int numOfJump = (ft.hop(stem).ordinal() +
                (abs(branchOrdinal - Branch.寅.ordinal()) % Branch.values().length)) % Stem.values().length;

        return Stem.values()[numOfJump].name() + location;
    }
}
