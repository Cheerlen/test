package com.wsgc.ml.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import com.wsgc.ml.ModelSelector;
import com.wsgc.ml.ModelSelector.EventData;
import com.wsgc.ml.ModelSelector.SessionData;


public class ModelSelectorImpl implements ModelSelector {

    public void updateConfig(byte[] trainedModelBytes ) {
        // TODO Auto-generated method stub

        InputStream modelStream = new ByteArrayInputStream(trainedModelBytes);


    }

    public String selectModel(EventData[] eventDataList_last30Days, SessionData sessionData) {
        // TODO Auto-generated method stub

        return eventDataList_last30Days == null || eventDataList_last30Days.length == 0 ? "BB.MOD.GRP.AFF.QNT"
                : eventDataList_last30Days[eventDataList_last30Days.length - 1].getProductId();
    }
}
