package pl.mateusz.utilities;

import java.text.DecimalFormat;

public class InvoiceUtilities {

    public float nettoAmount(float nettoValue, int quantity) {
        return nettoValue * quantity;
    }

    public String vatTax(float netto, int taxValue) {
        DecimalFormat df = new DecimalFormat("0.00");
        float tax = taxValue * 0.01f;
        return df.format(Math.round(netto * tax));
    }

    public String grossValue(float netto, int quantity, int taxValue) {
        DecimalFormat df = new DecimalFormat("0.00");
        float tax = (taxValue * 0.01f) + 1.00f;
        float amount = Math.round(netto * quantity);
        return df.format(Math.round(amount * tax));
    }

    public String numberInWorlds(float netto, int quantity, int taxValue) {
        String[] units = {"", "jeden ", "dwa ", "trzy ", "cztery ", "pięć ", "sześć ", "siedem ", "osiem ", "dziewięć "};
        String[] dozens = {"", "jedenaście ", "dwanaście ", "trzynaście ", "czternaście ", "piętnaście ", "szesnaście ", "siedemnaście ", "osiemnaście ", "dziewiętnaście "};
        String[] tens = {"", "dziesięć ", "dwadzieścia ", "trzydzieści ", "czterdzieści ", "pięćdziesiąt ", "sześćdziesiąt ", "siedemdziesiąt","osiemdziesiąt ", "dziewięćdziesiąt "};
        String[] hundreds = {"","sto ", "dwieście ", "trzysta ", "czterysta ", "pięćset ", "sześćset ", "siedemset ", "osiemset ", "dziewięćset "};
        String[][] groups = {{"","",""},
                {"tysiąc ", "tysiące ", "tysięcy "},
                {"milion ", "miliony ", "milionów "}};
        String symbol = "";
        String inWorlds = "";
        long u = 0, d = 0, t = 0, h = 0, g = 0, e = 0;

        float tax = (taxValue * 0.01f) + 1.00f;
        float amount = netto * quantity;
        amount = amount * tax;
        System.out.println(amount);

        long value = (long) amount;

        System.out.println(value);

        if(value < 0) {
            symbol = " minus";
            value = - value;
        }

        while(value!=0) {
            u = value % 10;
            t = value % 100/10;
            h = value % 1000/100;

            if (t == 1 & u > 0) {
                d = u;
                u = 0;
                t = 0;
            } else {
                d = 0;
            }

            if (u == 1 && h + t + d == 0 ) {
                e = 1;
                if (t + h == 0 && g > 0) {
                    u = 0;
                    inWorlds = groups[(int) g][(int) e] + inWorlds;
                }
            } else if ( u >= 2 && u <= 4 ) {
                e = 1;
            } else {
                e = 2;
            }

            if (u + d + t + h > 0) {
                inWorlds = hundreds[(int) h] + tens[(int) t] + dozens[(int) d] + units[(int) u] + groups[(int) g][(int) e];
            }

            value /= 1000;
            g++;
        }
        inWorlds = symbol + inWorlds;
        return String.valueOf(inWorlds);
    }
}
