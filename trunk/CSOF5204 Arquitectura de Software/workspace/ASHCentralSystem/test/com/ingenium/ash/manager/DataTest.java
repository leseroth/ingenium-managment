/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ingenium.ash.manager;

import com.ingenium.ash.bo.Rule;
import com.ingenium.ash.cache.CacheRules;
import com.ingenium.ash.cache.RuleHouse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author admin
 */
public class DataTest {

    public DataTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void loadData() {
        RuleHouse rh = new RuleHouse(1,1,Byte.parseByte("00000001", 2));
        CacheRules.putRule(rh);
    }
}