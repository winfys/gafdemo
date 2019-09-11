package groovy.delegate

import groovy.pogo.Rule
import groovy.pogo.RuleSet

/**
 * Created by luomingxing on 2019/9/9.
 */
class RuleSetDelegate extends BaseDelegate{

    RuleSetDelegate(RuleSet ruleSet){
        this.rule = ruleSet
    }

    def methodMissing(String name, Object args) {
        if('rule' == name){
            def ruleClosure = args[0]
            def rule = new Rule()
            ruleClosure.delegate = new RuleDelegate(rule)
            ruleClosure.resolveStrategy = Closure.DELEGATE_FIRST
            ruleClosure()
            this.rule.ruleMap[rule.code] = rule
        }

    }
}

