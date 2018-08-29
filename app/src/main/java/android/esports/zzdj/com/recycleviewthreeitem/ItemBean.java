package android.esports.zzdj.com.recycleviewthreeitem;

public class ItemBean {
    private boolean isSelect;//是否选中
    private String content;//内容

    public ItemBean() {
    }

    public ItemBean(boolean isSelect, String content) {
        this.isSelect = isSelect;
        this.content = content;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ItemBean{" +
                "isSelect=" + isSelect +
                ", content='" + content + '\'' +
                '}';
    }
}
