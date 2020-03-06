package com.johnpank.prospring4.chapter14

import com.johnpank.prospring4.chapter14.interfaces.RuleFactory
import org.springframework.stereotype.Component

@Component("ruleFactory")
class RuleFactoryImpl implements RuleFactory{
    Closure force =
            {
                armor, attack ->
                    return armor * attack}

    @Override
    Rule getUnitCategoryRule() {
        Rule rule = new Rule()
        rule.singlehit = true
        rule.conditions = [{object, param -> force(object.armor, object.attack) >= param},{object, param -> force(object.armor, object.attack) <= param}]
        rule.actions = [{object, param -> object.categry = param}]
        rule.parameters [
                [0, 10, 'peon']
                [10, 100, 'warrior']
                [100, 500, 'tank']
                [500, 10000, 'HERO']
        ]
        return rule

    }
}
