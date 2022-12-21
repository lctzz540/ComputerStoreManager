package lct.store.models;

public class Laptop extends Product {
    private String CPU;
    private String RAM;
    private String ROM;
    private String VGA;
    private String MONITOR_SIZE;
    private String MONITOR_RESOLUTION;

    /**
     * @param BrandName
     * @param CPU
     * @param RAM
     * @param ROM
     * @param VGA
     * @param MONITOR_SIZE
     * @param MONITOR_RESOLUTION
     * @param amount
     */
    public Laptop(){};
    public Laptop(String model, String BrandName, String CPU, String RAM, String ROM, String VGA, String MONITOR_SIZE,
            String MONITOR_RESOLUTION, long price, long amount) {
        this.model = model;
        this.BrandName = BrandName;
        this.CPU = CPU;
        this.RAM = RAM;
        this.ROM = ROM;
        this.VGA = VGA;
        this.MONITOR_SIZE = MONITOR_SIZE;
        this.MONITOR_RESOLUTION = MONITOR_RESOLUTION;
        this.price = price;
        this.amount = amount;
    }

    // Getter Methods
    
    public String getCPU() {
        return CPU;
    }

    public String getRAM() {
        return RAM;
    }

    public String getROM() {
        return ROM;
    }

    public String getVGA() {
        return VGA;
    }

    public String getMONITOR_SIZE() {
        return MONITOR_SIZE;
    }

    public String getMONITOR_RESOLUTION() {
        return MONITOR_RESOLUTION;
    }

    @Override
    public long getAmount() {
        return amount;
    }

    // Setter Methods

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public void setROM(String ROM) {
        this.ROM = ROM;
    }

    public void setVGA(String VGA) {
        this.VGA = VGA;
    }

    public void setMONITOR_SIZE(String MONITOR_SIZE) {
        this.MONITOR_SIZE = MONITOR_SIZE;
    }

    public void setMONITOR_RESOLUTION(String MONITOR_RESOLUTION) {
        this.MONITOR_RESOLUTION = MONITOR_RESOLUTION;
    }

    public void setBrandName(String brandName) {
        this.BrandName = brandName;
    }
    // Sell, import
    /**
     * @param sellamount
     */
    @Override
    public void sellProduct(long sellamount) {
        this.amount = this.amount - sellamount;
    }

    /**
     * @param importamount
     */
    @Override
    public void importProduct(long importamount) {
        this.amount = this.amount + importamount;
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
    public String[] showKindOFComponent(){
        String[] kindofcomponent = {"BrandName", "CPU", "RAM", "ROM", "VGA", "MONITOR_SIZE", "MONITOR_RESOLUTION"};
        return kindofcomponent;
    }
}