package sample;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nirbelelti on 07/09/15.
 */
public class Fields {


    private Integer fieldId = 0;

    private    Map<Integer, String> move = new HashMap<Integer, String>();

    public Integer getFieldId() {
        return fieldId;
    }

    public void setFieldId(Integer fieldId) {
        this.fieldId = fieldId;
    }

    @Override
    public String toString() {
        return "Fields{" +
                "fieldId=" + fieldId +
                '}';
    }
}










