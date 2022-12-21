package lct.store.models;

public class Keyboard extends Product {
    private float Type;
    private String Switch;
    private String Keycap;
    private boolean Hotswap;
    
    public Keyboard(){};
    public Keyboard(String model, String BrandName, float Type, String Switch, String Keycap, Boolean Hotswap, long amount, long price) {
        this.model = model;
        this.BrandName = BrandName;
        this.Type = Type;
        this.Switch = Switch;
        this.Keycap = Keycap;
        this.Hotswap = Hotswap;
        this.amount = amount;
        this.price = price;

    };

    // Getter Methods

    public String getBrandName() {
        return BrandName;
    }

    public float getType() {
        return Type;
    }

    public String getSwitch() {
        return Switch;
    }

    public String getKeycap() {
        return Keycap;
    }

    public boolean getHotswap() {
        return Hotswap;
    }

    // Setter Methods

    public void setBrandName(String BrandName) {
        this.BrandName = BrandName;
    }

    public void setType(float Type) {
        this.Type = Type;
    }

    public void setSwitch(String Switch) {
        this.Switch = Switch;
    }

    public void setKeycap(String Keycap) {
        this.Keycap = Keycap;
    }

    public void setHotswap(boolean Hotswap) {
        this.Hotswap = Hotswap;
    }

    @Override
    public void sellProduct(long sellamount) {
        // TODO Auto-generated method stub
        this.amount = this.amount - sellamount;

    }

    @Override
    public void importProduct(long importamount) {
        // TODO Auto-generated method stub
        this.amount = this.amount + importamount;

    }

    @Override
    public long getAmount() {
        // TODO Auto-generated method stub
        return amount;
    }

    @Override
    public long getPrice() {
        // TODO Auto-generated method stub
        return price;
    }

    @Override
    public void setPrice(long newPrice) {
        // TODO Auto-generated method stub
        this.price = newPrice;
    }
    @Override
    public String[] showKindOFComponent() {
        // TODO Auto-generated method stub
        String[] kindofcomponent = {"BrandName", "Type", "Switch", "Keycap", "Hotswap"};
        return kindofcomponent;
    }
}
