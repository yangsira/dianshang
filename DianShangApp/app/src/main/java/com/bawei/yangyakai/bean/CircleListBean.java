package com.bawei.yangyakai.bean;

import java.util.List;

/**
 * @Author：杨
 * @E-mail： 15001194794@163.com
 * @Date：2019/5/4 16:15
 * @Description：描述信息
 */
public class CircleListBean {

    /**
     * result : [{"commodityId":13,"content":"王耀","createTime":1556922592000,"greatNum":1,"headPic":"http://mobile.bwstudent.com/images/small/default/user.jpg","id":879,"image":"http://mobile.bwstudent.com/images/small/circle_pic/2019-05-03/8621520190503172952.jpg","nickName":"uW_16L70","userId":725,"whetherGreat":2},{"commodityId":13,"content":"王耀","createTime":1556922466000,"greatNum":1,"headPic":"http://mobile.bwstudent.com/images/small/default/user.jpg","id":878,"image":"http://mobile.bwstudent.com/images/small/circle_pic/2019-05-03/5147220190503172746.jpg","nickName":"uW_16L70","userId":725,"whetherGreat":2},{"commodityId":13,"content":"王耀","createTime":1556922444000,"greatNum":0,"headPic":"http://mobile.bwstudent.com/images/small/default/user.jpg","id":877,"image":"http://mobile.bwstudent.com/images/small/circle_pic/2019-05-03/3029520190503172724.jpg","nickName":"uW_16L70","userId":725,"whetherGreat":2},{"commodityId":13,"content":"王耀威","createTime":1556921849000,"greatNum":0,"headPic":"http://mobile.bwstudent.com/images/small/default/user.jpg","id":876,"image":"http://mobile.bwstudent.com/images/small/circle_pic/2019-05-03/9635820190503171729.jpg","nickName":"uW_16L70","userId":725,"whetherGreat":2},{"commodityId":13,"content":"刘江","createTime":1556920880000,"greatNum":1,"headPic":"http://mobile.bwstudent.com/images/small/default/user.jpg","id":875,"image":"http://mobile.bwstudent.com/images/small/circle_pic/2019-05-03/9267020190503170120.jpg","nickName":"uW_16L70","userId":725,"whetherGreat":2}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * commodityId : 13
         * content : 王耀
         * createTime : 1556922592000
         * greatNum : 1
         * headPic : http://mobile.bwstudent.com/images/small/default/user.jpg
         * id : 879
         * image : http://mobile.bwstudent.com/images/small/circle_pic/2019-05-03/8621520190503172952.jpg
         * nickName : uW_16L70
         * userId : 725
         * whetherGreat : 2
         */

        private int commodityId;
        private String content;
        private long createTime;
        private int greatNum;
        private String headPic;
        private int id;
        private String image;
        private String nickName;
        private int userId;
        private int whetherGreat;

        public int getCommodityId() {
            return commodityId;
        }

        public void setCommodityId(int commodityId) {
            this.commodityId = commodityId;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getGreatNum() {
            return greatNum;
        }

        public void setGreatNum(int greatNum) {
            this.greatNum = greatNum;
        }

        public String getHeadPic() {
            return headPic;
        }

        public void setHeadPic(String headPic) {
            this.headPic = headPic;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getWhetherGreat() {
            return whetherGreat;
        }

        public void setWhetherGreat(int whetherGreat) {
            this.whetherGreat = whetherGreat;
        }
    }
}
