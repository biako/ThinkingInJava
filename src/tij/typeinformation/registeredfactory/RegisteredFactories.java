package tij.typeinformation.registeredfactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Created by Xiaolong on 12/26/2016.
 *
 * Thinking in Java p414
 *
 * In this example, the base class Part contains a List of factory
 * objects. Factories for types that should be produced by the
 * createRandom() method are "registered" with the
 * base class by adding them to the partFactories List:
 */

class Part {
    public String toString() {
        return getClass().getSimpleName();
    }

    static List<Factory<? extends Part>> partFactories =
            new ArrayList<>();

    static {
    // Collections.addAll() gives an "unchecked generic
    // array creation ... for varargs parameter" warning.
        partFactories.add(new FuelFilter.Factory());
        partFactories.add(new AirFilter.Factory());
        partFactories.add(new CabinAirFilter.Factory());
        partFactories.add(new OilFilter.Factory());
        partFactories.add(new FanBelt.Factory());
        partFactories.add(new PowerSteeringBelt.Factory());
        partFactories.add(new GeneratorBelt.Factory());
    }

    private static Random rand = new Random(47);

    public static Part createRandom() {
        int n = rand.nextInt(partFactories.size());
        return partFactories.get(n).create();
    }
}

class Filter extends Part {
}

class FuelFilter extends Filter {
    // Create a Class Factory for each specific type:
    public static class Factory
            implements tij.typeinformation.registeredfactory.Factory<FuelFilter> {
        public FuelFilter create() {
            return new FuelFilter();
        }
    }
}

class AirFilter extends Filter {
    public static class Factory
            implements tij.typeinformation.registeredfactory.Factory<AirFilter> {
        public AirFilter create() {
            return new AirFilter();
        }
    }
}

class CabinAirFilter extends Filter {
    public static class Factory
            implements tij.typeinformation.registeredfactory.Factory<CabinAirFilter> {
        public CabinAirFilter create() {
            return new CabinAirFilter();
        }
    }
}

class OilFilter extends Filter {
    public static class Factory
            implements tij.typeinformation.registeredfactory.Factory<OilFilter> {
        public OilFilter create() {
            return new OilFilter();
        }
    }
}

class Belt extends Part {
}

class FanBelt extends Belt {
    public static class Factory
            implements tij.typeinformation.registeredfactory.Factory<FanBelt> {
        public FanBelt create() {
            return new FanBelt();
        }
    }
}

class GeneratorBelt extends Belt {
    public static class Factory
            implements tij.typeinformation.registeredfactory.Factory<GeneratorBelt> {
        public GeneratorBelt create() {
            return new GeneratorBelt();
        }
    }
}

class PowerSteeringBelt extends Belt {
    public static class Factory
            implements tij.typeinformation.registeredfactory.Factory<PowerSteeringBelt> {
        public PowerSteeringBelt create() {
            return new PowerSteeringBelt();
        }
    }
}

public class RegisteredFactories {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++)
            System.out.println(Part.createRandom());
    }
}
