package com.johnpank.prospring4.chapter14.interfaces;


import com.johnpank.prospring4.chapter14.Rule;

public interface RuleEngine {
    void run(Rule rule, Object object);
}
