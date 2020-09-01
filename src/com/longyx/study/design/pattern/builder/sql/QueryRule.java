package com.spdb.study.design.pattern.builder.sql;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 该类用于构造查询条件
 * @author Mr.Longyx
 * @date 2020年07月05日 13:20
 */
public class QueryRule implements Serializable {
    private static final long serialVersionUID = -9171195689734322793L;

    public static final int ASC_ORDER = 101;
    public static final int DESC_ORDER = 102;
    public static final int LIKE = 1;
    public static final int IN = 2;
    public static final int NOTIN = 3;
    public static final int BETWEEN = 4;
    public static final int EQ = 5;
    public static final int NOTEQ = 6;
    public static final int GT = 7;
    public static final int GE = 8;
    public static final int LT = 9;
    public static final int LE = 10;
    public static final int ISNULL = 11;
    public static final int ISNOTNULL = 12;
    public static final int ISEMPTY = 13;
    public static final int ISNOTEMPTY = 14;
    public static final int AND = 201;
    private static final int OR = 202;
    private List<Rule> rules = new ArrayList<> ();

    private List<QueryRule> queryRules = new ArrayList<> ();

    private String propertyName;

    private QueryRule(){}

    private QueryRule(String propertyName){
        this.propertyName = propertyName;
    }

    public static QueryRule getInstance(){
        return new QueryRule();
    }

    /**
     * 添加升序规则
     * @author Mr.Longyx
     * @date 2020/7/5 13:40
     */
    public QueryRule addAscOrder(String propertyName){
        this.rules.add(new Rule(ASC_ORDER, propertyName));
        return this;
    }

    /**
     * 添加降序规则
     * @author Mr.Longyx
     * @date 2020/7/5 13:41
     */
    private QueryRule addDescOrder(String propertyName){
        this.rules.add(new Rule(DESC_ORDER, propertyName));
        return this;
    }

    /**
     * 添加判NULL规则
     * @author Mr.Longyx
     * @date 2020/7/5 13:42
     */
    public QueryRule andIsNull(String propertyName){
        this.rules.add(new Rule(ISNULL, propertyName));
        return this;
    }

    /**
     * 添加判非NULL规则
     * @author Mr.Longyx
     * @date 2020/7/5 13:43
     */
    public QueryRule andIsNotNull(String propertyName){
        this.rules.add(new Rule(ISNOTNULL, propertyName));
        return this;
    }
    /**
     * 添加判空规则
     * @author Mr.Longyx
     * @date 2020/7/5 13:45
     */
    public QueryRule andIsEmpty(String propertyName){
        this.rules.add(new Rule(ISEMPTY, propertyName));
        return this;
    }

    /**
     * 添加判非空判断
     * @author Mr.Longyx
     * @date 2020/7/5 13:46
     */
    public QueryRule andIsNotEmpty(String propName){
        this.rules.add(new Rule(ISNOTEMPTY, propName));
        return this;
    }

    /**
     * 添加模糊查询判断
     * @author Mr.Longyx
     * @date 2020/7/5 13:48
     */
    public QueryRule andLike(String propertyName, Object value){
        this.rules.add(new Rule(EQ, propertyName, new Object[] { value}) .setAndOr(AND));
        return this;
    }

    /**
     * 添加等值查询判断
     * @author Mr.Longyx
     * @date 2020/7/5 13:50
     */
    public QueryRule andEqual(String propertyName, Object value) {
        this.rules.add(new Rule(EQ, propertyName, new Object[] { value }).setAndOr(AND));
        return this;
    }

    public QueryRule andBetween(String propertyName, Object... values) {
        this.rules.add(new Rule(BETWEEN, propertyName, values).setAndOr(AND));
        return this;
    }

    public QueryRule andIn(String propertyName, List<Object> values) {
        this.rules.add(new Rule(IN, propertyName, new Object[] { values }).setAndOr(AND));
        return this;
    }

    public QueryRule andIn(String propertyName, Object... values) {
        this.rules.add(new Rule(IN, propertyName, values).setAndOr(AND));
        return this;
    }

    public QueryRule andNotIn(String propertyName, List<Object> values) {
        this.rules.add(new Rule(NOTIN, propertyName, new Object[] { values }).setAndOr(AND));
        return this;
    }

    public QueryRule orNotIn(String propertyName, Object... values) {
        this.rules.add(new Rule(NOTIN, propertyName, values).setAndOr(OR));
        return this;
    }


    public QueryRule andNotEqual(String propertyName, Object value) {
        this.rules.add(new Rule(NOTEQ, propertyName, new Object[] { value }).setAndOr(AND));
        return this;
    }

    public QueryRule andGreaterThan(String propertyName, Object value) {
        this.rules.add(new Rule(GT, propertyName, new Object[] { value }).setAndOr(AND));
        return this;
    }

    public QueryRule andGreaterEqual(String propertyName, Object value) {
        this.rules.add(new Rule(GE, propertyName, new Object[] { value }).setAndOr(AND));
        return this;
    }

    public QueryRule andLessThan(String propertyName, Object value) {
        this.rules.add(new Rule(LT, propertyName, new Object[] { value }).setAndOr(AND));
        return this;
    }

    public QueryRule andLessEqual(String propertyName, Object value) {
        this.rules.add(new Rule(LE, propertyName, new Object[] { value }).setAndOr(AND));
        return this;
    }


    public QueryRule orIsNull(String propertyName) {
        this.rules.add(new Rule(ISNULL, propertyName).setAndOr(OR));
        return this;
    }

    public QueryRule orIsNotNull(String propertyName) {
        this.rules.add(new Rule(ISNOTNULL, propertyName).setAndOr(OR));
        return this;
    }

    public QueryRule orIsEmpty(String propertyName) {
        this.rules.add(new Rule(ISEMPTY, propertyName).setAndOr(OR));
        return this;
    }

    public QueryRule orIsNotEmpty(String propertyName) {
        this.rules.add(new Rule(ISNOTEMPTY, propertyName).setAndOr(OR));
        return this;
    }

    public QueryRule orLike(String propertyName, Object value) {
        this.rules.add(new Rule(LIKE, propertyName, new Object[] { value }).setAndOr(OR));
        return this;
    }

    public QueryRule orEqual(String propertyName, Object value) {
        this.rules.add(new Rule(EQ, propertyName, new Object[] { value }).setAndOr(OR));
        return this;
    }

    public QueryRule orBetween(String propertyName, Object... values) {
        this.rules.add(new Rule(BETWEEN, propertyName, values).setAndOr(OR));
        return this;
    }

    public QueryRule orIn(String propertyName, List<Object> values) {
        this.rules.add(new Rule(IN, propertyName, new Object[] { values }).setAndOr(OR));
        return this;
    }

    public QueryRule orIn(String propertyName, Object... values) {
        this.rules.add(new Rule(IN, propertyName, values).setAndOr(OR));
        return this;
    }

    public QueryRule orNotEqual(String propertyName, Object value) {
        this.rules.add(new Rule(NOTEQ, propertyName, new Object[] { value }).setAndOr(OR));
        return this;
    }

    public QueryRule orGreaterThan(String propertyName, Object value) {
        this.rules.add(new Rule(GT, propertyName, new Object[] { value }).setAndOr(OR));
        return this;
    }

    public QueryRule orGreaterEqual(String propertyName, Object value) {
        this.rules.add(new Rule(GE, propertyName, new Object[] { value }).setAndOr(OR));
        return this;
    }

    public QueryRule orLessThan(String propertyName, Object value) {
        this.rules.add(new Rule(LT, propertyName, new Object[] { value }).setAndOr(OR));
        return this;
    }

    public QueryRule orLessEqual(String propertyName, Object value) {
        this.rules.add(new Rule(LE, propertyName, new Object[] { value }).setAndOr(OR));
        return this;
    }


    public List<Rule> getRules() {
        return this.rules;
    }

    public List<QueryRule> getQueryRules() {
        return this.queryRules;
    }

    public String getPropertyName() {
        return this.propertyName;
    }


    protected class Rule implements Serializable {

        private static final long serialVersionUID = -5230193582457541541L;
        /**
         * 规则类型
         * @author Mr.Longyx
         * @date 2020/7/5 13:31
         */
        private int type;
        private String property_name;
        private Object[] values;
        private int andOr = AND;

        public Rule(int paramInt, String paramString){
            this.property_name = paramString;
            this.type = paramInt;
        }

        public Rule(int paramInt, String paramString, Object[] paramArrayOfObject){
            this.property_name = paramString;
            this.values = paramArrayOfObject;
            this.type = paramInt;
        }

        public Rule setAndOr(int andOr){
            this.andOr = andOr;
            return this;
        }
        public int getAndOr(){
            return this.andOr;
        }

        public Object[] getValues(){
            return this.values;
        }
        public int getType(){
            return this.type;
        }
        public String getPropertyName() {
            return this.property_name;
        }
    }
}
