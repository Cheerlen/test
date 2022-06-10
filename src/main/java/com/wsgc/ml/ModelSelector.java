package com.wsgc.ml;

import java.io.InputStream;
import java.util.List;

public interface ModelSelector {

    // init or update ModelSelector's configuration. thread safe???
    public void updateConfig(byte[] trainedModelBytes);

    // returns model in the form of dataset name
    public String selectModel(EventData[] eventDataList_last30Days, SessionData sessionData);

    public static class EventData {
        private String productId; // from FE
        private String eventDateTime; // UTC: 2022-05-09T18:17:26Z; from FE
        private String eventType; // from FE; possible values: carted; uncarted; purchased; (viewed, for RVI)

        // the following is to come from a dataset; mapped from productId
        private String[] productType;
        private String[] primaryCat;

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public String getEventDateTime() {
            return eventDateTime;
        }

        public void setEventDateTime(String eventDateTime) {
            this.eventDateTime = eventDateTime;
        }

        public String getEventType() {
            return eventType;
        }

        public void setEventType(String eventType) {
            this.eventType = eventType;
        }

        public String[] getProductType() {
            return productType;
        }

        public void setProductType(String[] productType) {
            this.productType = productType;
        }

        public String[] getPrimaryCat() {
            return primaryCat;
        }

        public void setPrimaryCat(String[] primaryCat) {
            this.primaryCat = primaryCat;
        }

    }

    public static class SessionData {
        private String userAgent; // from FE
        private String[] geoDma; // new datafeed; mapped from zip; eg: 28117 -> [517, 511, 514]

        // to be extracted from Adobe; as is. from FE
        private String prop1; //product detail:upholstery pip
        private String prop19; //product detail:piped-cushy-super-sectional-set
        private String eVar9; // external campaign referral, may need to be cached in FE
        private String eVar12; // PLA^Google^Furniture > Lounge Furniture^5160696_14728146868, may need to be cached in FE
        private String eVar15; // non-internal ad cm_ree, may need to be cached in FE
        private String eVar24; // More than 30 days, may need to be cached in FE
        private String eVar27; //non-search
        private String eVar44; //Repeat
        private String eVar113; //catalogId=9&sku=5160696&cm_ven=PLA&cm_cat=Google&cm_pla=Furniture%20%3E%20Lounge%20Furniture&region_id=820120&cm_ite=5160696_14728146868&gclid=EAIaIQobChMIla7CjPTV9wIVgRx9Ch2sgwtWEAQYAiABEgIv0PD_BwE
        private String browserTime; // 10/4/2022 14:49:1 2 420, UTC
        private String screenResolution; // 1680x1050

        public String getUserAgent() {
            return userAgent;
        }

        public void setUserAgent(String userAgent) {
            this.userAgent = userAgent;
        }

        public String[] getGeoDma() {
            return geoDma;
        }

        public void setGeoDma(String[] geoDma) {
            this.geoDma = geoDma;
        }

        public String getProp1() {
            return prop1;
        }

        public void setProp1(String prop1) {
            this.prop1 = prop1;
        }

        public String getProp19() {
            return prop19;
        }

        public void setProp19(String prop19) {
            this.prop19 = prop19;
        }

        public String geteVar9() {
            return eVar9;
        }

        public void seteVar9(String eVar9) {
            this.eVar9 = eVar9;
        }

        public String geteVar12() {
            return eVar12;
        }

        public void seteVar12(String eVar12) {
            this.eVar12 = eVar12;
        }

        public String geteVar15() {
            return eVar15;
        }

        public void seteVar15(String eVar15) {
            this.eVar15 = eVar15;
        }

        public String geteVar24() {
            return eVar24;
        }

        public void seteVar24(String eVar24) {
            this.eVar24 = eVar24;
        }

        public String geteVar27() {
            return eVar27;
        }

        public void seteVar27(String eVar27) {
            this.eVar27 = eVar27;
        }

        public String geteVar44() {
            return eVar44;
        }

        public void seteVar44(String eVar44) {
            this.eVar44 = eVar44;
        }

        public String geteVar113() {
            return eVar113;
        }

        public void seteVar113(String eVar113) {
            this.eVar113 = eVar113;
        }

        public String getBrowserTime() {
            return browserTime;
        }

        public void setBrowserTime(String browserTime) {
            this.browserTime = browserTime;
        }

        public String getScreenResolution() {
            return screenResolution;
        }

        public void setScreenResolution(String screenResolution) {
            this.screenResolution = screenResolution;
        }

    }
}