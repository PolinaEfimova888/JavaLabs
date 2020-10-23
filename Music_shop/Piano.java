package zxc;

public class Piano extends Instrument{
    int deliveryPrice;
    int price;

    public Piano(String model,int price, int deliveryPrice) {
        super(model);
        this.price = price;
        this.deliveryPrice = deliveryPrice;
    }

    @Override
    int getPrice() {
        return this.price+this.deliveryPrice;
    }

    @Override
    public String toString() {
        return "Пианино:\n" +
                "\tцена доставки: " + deliveryPrice+'\n' +
                "\tцена пианино: " + price+'\n' +
                "\tитоговая цена: "+this.getPrice()+'\n';
    }
}
