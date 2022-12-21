package lct.store.models;

abstract class Product {
    protected String model;
    protected long amount;
    protected long price;
    protected String BrandName;
    public String getModel(){
        return this.model;    
    };
    public String getBrandName(){
        return this.BrandName;
    };
    public abstract void sellProduct(long sellamount);
    public abstract void importProduct(long importamount);
    public abstract long getAmount();
    public abstract long getPrice();
    public abstract void setPrice(long newPrice);
    public abstract String[] showKindOFComponent();
}