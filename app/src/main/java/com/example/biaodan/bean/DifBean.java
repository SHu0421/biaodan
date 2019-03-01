package com.example.biaodan.bean;

import java.util.List;

/**
 * 用于adapter的bean
 */
public class DifBean {

    public List<ItemBean> item;

    public static class ItemBean {
        /**
         * id : 10001
         * username : 杜甫
         * email : xianxin@layui.com
         * sex : 男
         * city : 浙江杭州
         * sign : 点击此处，显示更多。当内容超出时，点击单元格会自动显示更多内容。
         * experience : 116
         * ip : 192.168.0.8
         * logins : 108
         * joinTime : 2016-10-14
         */

        public String id;
        public String username;
        public String email;
        public String sex;
        public String city;
        public String sign;
        public String experience;
        public String ip;
        public String logins;
        public String joinTime;
        public List<ItemBean> item;
    }
}
