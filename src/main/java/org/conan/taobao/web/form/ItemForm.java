package org.conan.taobao.web.form;

import org.conan.taobao.ad.model.ItemDTO;
import org.conan.taobao.base.util.MyDate;

public class ItemForm extends ItemDTO {

    private static final long serialVersionUID = 1L;

    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDtimeString() {
        return MyDate.datetimeString5(this.getDtime());
    }

}
