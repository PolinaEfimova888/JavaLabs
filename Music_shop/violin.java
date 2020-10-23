package zxc;

public class Violin extends Instrument{
    int price;
    int accessPrice;

    public Violin(String model,int price, int accessPrice) {
        super(model);
        this.price = price;
        this.accessPrice = accessPrice;
    }

    @Override
    int getPrice() {
        return this.price+this.accessPrice;
    }

    @Override
    public String toString() {
        return "Скрипка:\n" +
                "\tцена аксессуаров: " + accessPrice+'\n' +
                "\tцена скрипки: " + price+'\n' +
                "\tитоговая цена: "+this.getPrice()+'\n';
    }
}
