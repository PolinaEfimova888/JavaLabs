package zxc;

public class Guitar extends Instrument{
    int price;
    int tuningPrice;

    public Guitar(String model,int price, int tuningPrice) {
        super(model);
        this.price = price;
        this.tuningPrice = tuningPrice;
    }

    @Override
    int getPrice() {
        return this.price+this.tuningPrice;
    }

    @Override
    public String toString() {
        return "Гитара:\n" +
                "\tцена настройки: " + tuningPrice+'\n' +
                "\tцена гитары: " + price+'\n' +
                "\tитоговая цена: "+this.getPrice()+'\n';
    }
}
