package org.achteins81.springmvc.response;

import java.util.Map;

/**
 * AJAX请求的Response
 *
 * @author Achteins-81
 * @since 2023-04-12
 */
public class AjaxResponse {
    /**
     * 返回数据信息存储对象
     */
    private Map<String, Object> data;

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
