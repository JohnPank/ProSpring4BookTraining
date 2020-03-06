package com.johnpank.prospring4.chapter14.services;



import com.johnpank.prospring4.chapter14.Rule;
import com.johnpank.prospring4.chapter14.interfaces.RuleEngine;
import com.johnpank.prospring4.chapter14.interfaces.RuleFactory;
import com.johnpank.prospring4.chapter14.interfaces.UnitService;
import com.johnpank.prospring4.chapter14.model.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("unitService")
public class UnitServiceImpl implements UnitService {

    @Autowired
    RuleFactory ruleFactory;

    @Autowired
    RuleEngine ruleEngine;

    @Override
    public void applyRule(Unit unit) {
        Rule unitCategoryRule = ruleFactory.getUnitCategoryRule();
        ruleEngine.run(unitCategoryRule, unit);
    }
}
