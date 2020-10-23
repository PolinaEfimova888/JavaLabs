package zxc;

import java.util.Objects;

abstract class Instrument implements Comparable<Instrument>{
    String model;

    public Instrument(String model) {
        this.model = model;
    }

    abstract int getPrice();
    @Override
    public int compareTo(Instrument instrument)
    {
        if (instrument == null)
            return 1;
        if (this.getPrice() > instrument.getPrice())
            return 1;
        else if (this.getPrice() < instrument.getPrice())
            return -1;
        else return 0;
    }

    public boolean equals(Instrument instrument) {
        return (this.model == instrument.model && this.getPrice()==instrument.getPrice());
    }

    public void compare(Instrument instrument) {
        int k = compareTo(instrument);
        if (k == 0){
            System.out.println("Инструменты стоят одинаково");
        }
        else if (k == 1){
            System.out.println("Первый инстурмент дороже");
        }
        else if (k == -1){
            System.out.println("Второй инстурмент дороже");
        }
    }
    public void equal(Instrument instrument) {
        if (equals(instrument)) {
            System.out.println("Одинаковые инструменты");
        } else System.out.println("Разные инструменты");
    }
}

