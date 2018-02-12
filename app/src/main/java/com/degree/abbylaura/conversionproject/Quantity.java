package com.degree.abbylaura.conversionproject;

import java.text.DecimalFormat;

/**
 * Created by abbylaura on 02/02/2018.
 */

public class Quantity {

    final double value;
    final Unit unit;


    //Enumerated types use a constant key to represent a value


    public static enum Unit{
        tsp(1.0d), tbsp(0.3333d), cup(0.0208d), oz(0.1666d),
        pint(0.0104d), quart(0.0052d), gallon(0.0013d), pound(0.0125d),
        ml(4.9289d), litre(0.0049d), mg(5687.5d), kg(0.0057d);

        //tsp will be base unit of measure
        final static Unit baseUnit = tsp;

        //hold number of tsp from original unit, stored in:
        final double byBaseUnit;

        private Unit(double inTsp){
            this.byBaseUnit = inTsp;
        }

        public double toBaseUnit(double value){
            return value / byBaseUnit;
        }

        public double fromBaseUnit(double value){
            return value * byBaseUnit;
        }
    }

    public Quantity(double value, Unit unit){
        super();
        this.value = value;
        this.unit = unit;
    }

    public Quantity to(Unit newUnit){
        Unit oldUnit = this.unit;
        return new
                Quantity(newUnit.fromBaseUnit(oldUnit.toBaseUnit(value)), newUnit);


    }
     @Override
    public String toString(){
         DecimalFormat df = new DecimalFormat("#.0000"); //limit to 4dp
         return df.format(value) + " " + unit.name();
     }

}
