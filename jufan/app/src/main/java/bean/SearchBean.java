package bean;

import java.util.List;

/**
 * Created by wanghongra on 2016/10/8.
 */

public class SearchBean {


    /**
     * state : 0
     * message : SUCCESS
     * content : {"data":[{"uid":91780475,"level":46,"nickname":"哲哲","headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160810/20a44d49a1b359a89092.jpg","out_amount":38026,"attention":false},{"uid":500150290,"level":26,"nickname":"西游\u2026\u2026齐天大圣","headImgSmall":"http://resource.jufan.tv/jufan/userhead20160926/d59f0bc3d2d234d48243.png","out_amount":34951,"attention":false},{"uid":500011615,"level":43,"nickname":"红领巾＆","headImgSmall":"http://resource.jufan.tv/jufan/userhead20161006/c0b6408bba8c218b3930.png","out_amount":34910,"attention":false},{"uid":88687783,"level":23,"nickname":"大白","headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160513/cc7313ba435273094ba5.jpg","out_amount":27245,"attention":false},{"uid":500150972,"level":21,"nickname":"阿黄","headImgSmall":"http://resource.jufan.tv/jufan/userhead20161001/89a170f93938fe7f2274.jpg","out_amount":24686,"attention":false},{"uid":88587232,"level":49,"nickname":"隔壁老王","headImgSmall":"http://resource.jufan.tv/jufan/userhead20160930/d0b3088571195d1310ba.jpg","out_amount":23283,"attention":false},{"uid":500160213,"level":22,"nickname":"孤独终老.","headImgSmall":"http://resource.jufan.tv/jufan/userhead20160924/d5195dde078c00886c8e.png","out_amount":20945,"attention":false},{"uid":500150931,"level":21,"nickname":"饕餮","headImgSmall":"http://resource.jufan.tv/jufan/userhead20160923/30c9264d6c11a652b3c8.jpg","out_amount":20404,"attention":false},{"uid":85578673,"level":20,"nickname":"0724","headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160807/26f8129c8ec8111f9538.png","out_amount":19976,"attention":false},{"uid":88262301,"level":18,"nickname":"胖子","headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160623/70e09269e8e7ef045842.jpg","out_amount":16353,"attention":false},{"uid":500251904,"level":16,"nickname":"Jet","headImgSmall":"http://wx.qlogo.cn/mmopen/s1dJzIlHYqgmpUowHOhLdOrvEMM8tSicz4WicHGTVJ7dWfQSMnNjERYt3ZHJMnfzhIRd4cSB7sBxeuXia8UBwtpQj6oUkWmSZ5z/64","out_amount":14960,"attention":false},{"uid":94623507,"level":40,"nickname":"海華","headImgSmall":"http://resource.jufan.tv/jufan/userhead20160924/bf4f0f3067106cbf87cd.png","out_amount":12651,"attention":false},{"uid":500097628,"level":16,"nickname":"韩风","headImgSmall":"http://q.qlogo.cn/qqapp/1105125329/4D189C3FB2816FDCACAB931DC4F40AA4/100","out_amount":12546,"attention":false},{"uid":500240770,"level":14,"nickname":"随风","headImgSmall":"http://q.qlogo.cn/qqapp/1105125329/C7D5C072203FACFA15AFEC2B42263500/40","out_amount":11039,"attention":false},{"uid":86469099,"level":32,"nickname":"杜冷叮","headImgSmall":"http://resource.jufan.tv/jufan/userhead20160819/7f25474bef83dbb5e2a6.png","out_amount":9972,"attention":false}],"page_count":14}
     */

    private int state;
    private String message;
    /**
     * data : [{"uid":91780475,"level":46,"nickname":"哲哲","headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160810/20a44d49a1b359a89092.jpg","out_amount":38026,"attention":false},{"uid":500150290,"level":26,"nickname":"西游\u2026\u2026齐天大圣","headImgSmall":"http://resource.jufan.tv/jufan/userhead20160926/d59f0bc3d2d234d48243.png","out_amount":34951,"attention":false},{"uid":500011615,"level":43,"nickname":"红领巾＆","headImgSmall":"http://resource.jufan.tv/jufan/userhead20161006/c0b6408bba8c218b3930.png","out_amount":34910,"attention":false},{"uid":88687783,"level":23,"nickname":"大白","headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160513/cc7313ba435273094ba5.jpg","out_amount":27245,"attention":false},{"uid":500150972,"level":21,"nickname":"阿黄","headImgSmall":"http://resource.jufan.tv/jufan/userhead20161001/89a170f93938fe7f2274.jpg","out_amount":24686,"attention":false},{"uid":88587232,"level":49,"nickname":"隔壁老王","headImgSmall":"http://resource.jufan.tv/jufan/userhead20160930/d0b3088571195d1310ba.jpg","out_amount":23283,"attention":false},{"uid":500160213,"level":22,"nickname":"孤独终老.","headImgSmall":"http://resource.jufan.tv/jufan/userhead20160924/d5195dde078c00886c8e.png","out_amount":20945,"attention":false},{"uid":500150931,"level":21,"nickname":"饕餮","headImgSmall":"http://resource.jufan.tv/jufan/userhead20160923/30c9264d6c11a652b3c8.jpg","out_amount":20404,"attention":false},{"uid":85578673,"level":20,"nickname":"0724","headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160807/26f8129c8ec8111f9538.png","out_amount":19976,"attention":false},{"uid":88262301,"level":18,"nickname":"胖子","headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160623/70e09269e8e7ef045842.jpg","out_amount":16353,"attention":false},{"uid":500251904,"level":16,"nickname":"Jet","headImgSmall":"http://wx.qlogo.cn/mmopen/s1dJzIlHYqgmpUowHOhLdOrvEMM8tSicz4WicHGTVJ7dWfQSMnNjERYt3ZHJMnfzhIRd4cSB7sBxeuXia8UBwtpQj6oUkWmSZ5z/64","out_amount":14960,"attention":false},{"uid":94623507,"level":40,"nickname":"海華","headImgSmall":"http://resource.jufan.tv/jufan/userhead20160924/bf4f0f3067106cbf87cd.png","out_amount":12651,"attention":false},{"uid":500097628,"level":16,"nickname":"韩风","headImgSmall":"http://q.qlogo.cn/qqapp/1105125329/4D189C3FB2816FDCACAB931DC4F40AA4/100","out_amount":12546,"attention":false},{"uid":500240770,"level":14,"nickname":"随风","headImgSmall":"http://q.qlogo.cn/qqapp/1105125329/C7D5C072203FACFA15AFEC2B42263500/40","out_amount":11039,"attention":false},{"uid":86469099,"level":32,"nickname":"杜冷叮","headImgSmall":"http://resource.jufan.tv/jufan/userhead20160819/7f25474bef83dbb5e2a6.png","out_amount":9972,"attention":false}]
     * page_count : 14
     */

    private ContentBean content;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ContentBean getContent() {
        return content;
    }

    public void setContent(ContentBean content) {
        this.content = content;
    }

    public static class ContentBean {
        private int page_count;
        /**
         * uid : 91780475
         * level : 46
         * nickname : 哲哲
         * headImgSmall : http://resource.jufan.tv/jufan/userhead/20160810/20a44d49a1b359a89092.jpg
         * out_amount : 38026
         * attention : false
         */

        private List<DataBean> data;

        public int getPage_count() {
            return page_count;
        }

        public void setPage_count(int page_count) {
            this.page_count = page_count;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            private int uid;
            private int level;
            private String nickname;
            private String headImgSmall;
            private int out_amount;
            private boolean attention;

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getHeadImgSmall() {
                return headImgSmall;
            }

            public void setHeadImgSmall(String headImgSmall) {
                this.headImgSmall = headImgSmall;
            }

            public int getOut_amount() {
                return out_amount;
            }

            public void setOut_amount(int out_amount) {
                this.out_amount = out_amount;
            }

            public boolean isAttention() {
                return attention;
            }

            public void setAttention(boolean attention) {
                this.attention = attention;
            }
        }
    }
}
