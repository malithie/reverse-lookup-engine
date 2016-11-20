package lk.uom.cse.msc.rle.finder.impl;

import lk.uom.cse.msc.rle.finder.PolicyFinder;

import java.util.HashMap;
import java.util.Map;

public class PolicyFinderImpl implements PolicyFinder {

    private Map<String, Object> policies;

    public PolicyFinderImpl(Map<String, Object> policies) {
        this.policies = new HashMap<String, Object>(policies);
    }

    @Override
    public Object lookup(String id) {
        return policies.get(id);
    }

}
