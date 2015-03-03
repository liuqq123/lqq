package com.lqq.impl;

import com.lqq.Performer;

/**
 * Created by Administrator on 2015/3/3.
 */
public class Juggler implements Performer {
    private int beanBags = 3;

    public Juggler() {
    }

    public Juggler(int beanBags) {
        this.beanBags = beanBags;
    }

    @Override
    public void perform() {
        System.out.println("JUGGLING " + beanBags + " BEANBAGS");
    }
}
