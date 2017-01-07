package tij.container2.filling.abstractclass;

import java.util.*;

/**
 * Created by Xiaolong on 1/7/2017.
 *
 * Thinking in Java p573-577
 *
 *
 * FlyweightMap must implement the entrySet() method, which requires
 * both a custom Set implementation and a custom Map.Entry class.
 *
 * Here’s part of the flyweight: each Map.Entry object simply stores its index,
 * rather than the actual key and value. When you call getKey( ) or getValue( ),
 * it uses the index to return the appropriate DATA element.
 *
 * The EntrySet ensures that its size is no bigger than DATA.
 *
 * You can see the other part of the flyweight implemented in EntrySet.Iterator.
 * Instead of creating a Map.Entry object for each data pair in DATA,
 * there’s only one Map.Entry object per iterator.

 * The Entry object is used as a window into the data;
 * it only contains an index into the static array of strings.

 * Every time you call next( ) for the iterator, the index in the Entry is incremented

 * so that it points to the next element pair, and then that Iterator’s single Entry object
 * is returned from next( ).

 * The select( ) method produces a FlyweightMap containing an EntrySet of the desired size,
 * and this is used in the overloaded capitals( ) and names( ) methods that you see demonstrated in main( ).
 *
 *
 *
 */
public class Countires {

    // The two-dimensional array of String DATA is public so it can be used elsewhere.
    public static final String[][] DATA = {
// Africa
            {"ALGERIA","Algiers"}, {"ANGOLA","Luanda"},
            {"BENIN","Porto-Novo"}, {"BOTSWANA","Gaberone"},
            {"BURKINA FASO","Ouagadougou"},
            {"BURUNDI","Bujumbura"},
            {"CAMEROON","Yaounde"}, {"CAPE VERDE","Praia"},
            {"CENTRAL AFRICAN REPUBLIC","Bangui"},
            {"CHAD","N'djamena"}, {"COMOROS","Moroni"},
            {"CONGO","Brazzaville"}, {"DJIBOUTI","Dijibouti"},
            {"EGYPT","Cairo"}, {"EQUATORIAL GUINEA","Malabo"},
            {"ERITREA","Asmara"}, {"ETHIOPIA","Addis Ababa"},
            {"GABON","Libreville"}, {"THE GAMBIA","Banjul"},
            {"GHANA","Accra"}, {"GUINEA","Conakry"},
            {"BISSAU","Bissau"},
            {"COTE D’IVOIR (IVORY COAST)","Yamoussoukro"},
            {"KENYA","Nairobi"}, {"LESOTHO","Maseru"},
            {"LIBERIA","Monrovia"}, {"LIBYA","Tripoli"},
            {"MADAGASCAR","Antananarivo"}, {"MALAWI","Lilongwe"},
            {"MALI","Bamako"}, {"MAURITANIA","Nouakchott"},
            {"MAURITIUS","Port Louis"}, {"MOROCCO","Rabat"},
            {"MOZAMBIQUE","Maputo"}, {"NAMIBIA","Windhoek"},
            {"NIGER","Niamey"}, {"NIGERIA","Abuja"},
            {"RWANDA","Kigali"},
            {"SAO TOME E PRINCIPE","Sao Tome"},
            {"SENEGAL","Dakar"}, {"SEYCHELLES","Victoria"},
            {"SIERRA LEONE","Freetown"}, {"SOMALIA","Mogadishu"},
            {"SOUTH AFRICA","Pretoria/Cape Town"},
            {"SUDAN","Khartoum"},
            {"SWAZILAND","Mbabane"}, {"TANZANIA","Dodoma"},
            {"TOGO","Lome"}, {"TUNISIA","Tunis"},
            {"UGANDA","Kampala"},
            {"DEMOCRATIC REPUBLIC OF THE CONGO (ZAIRE)",
                    "Kinshasa"},
            {"ZAMBIA","Lusaka"}, {"ZIMBABWE","Harare"},
// Asia
            {"AFGHANISTAN","Kabul"}, {"BAHRAIN","Manama"},
            {"BANGLADESH","Dhaka"}, {"BHUTAN","Thimphu"},
            {"BRUNEI","Bandar Seri Begawan"},
            {"CAMBODIA","Phnom Penh"},
            {"CHINA","Beijing"}, {"CYPRUS","Nicosia"},
            {"INDIA","New Delhi"}, {"INDONESIA","Jakarta"},
            {"IRAN","Tehran"}, {"IRAQ","Baghdad"},
            {"ISRAEL","Jerusalem"}, {"JAPAN","Tokyo"},
            {"JORDAN","Amman"}, {"KUWAIT","Kuwait City"},
            {"LAOS","Vientiane"}, {"LEBANON","Beirut"},
            {"MALAYSIA","Kuala Lumpur"}, {"THE MALDIVES","Male"},
            {"MONGOLIA","Ulan Bator"},
            {"MYANMAR (BURMA)","Rangoon"},
            {"NEPAL","Katmandu"}, {"NORTH KOREA","P’yongyang"},
            {"OMAN","Muscat"}, {"PAKISTAN","Islamabad"},
            {"PHILIPPINES","Manila"}, {"QATAR","Doha"},
            {"SAUDI ARABIA","Riyadh"}, {"SINGAPORE","Singapore"},
            {"SOUTH KOREA","Seoul"}, {"SRI LANKA","Colombo"},
            {"SYRIA","Damascus"},
            {"TAIWAN (REPUBLIC OF CHINA)","Taipei"},
            {"THAILAND","Bangkok"}, {"TURKEY","Ankara"},
            {"UNITED ARAB EMIRATES","Abu Dhabi"},
            {"VIETNAM","Hanoi"}, {"YEMEN","Sana’a"},
// Australia and Oceania
            {"AUSTRALIA","Canberra"}, {"FIJI","Suva"},
            {"KIRIBATI","Bairiki"},
            {"MARSHALL ISLANDS","Dalap-Uliga-Darrit"},
            {"MICRONESIA","Palikir"}, {"NAURU","Yaren"},
            {"NEW ZEALAND","Wellington"}, {"PALAU","Koror"},
            {"PAPUA NEW GUINEA","Port Moresby"},
            {"SOLOMON ISLANDS","Honaira"}, {"TONGA","Nuku’alofa"},
            {"TUVALU","Fongafale"}, {"VANUATU","< Port-Vila"},
            {"WESTERN SAMOA","Apia"},
// Eastern Europe and former USSR
            {"ARMENIA","Yerevan"}, {"AZERBAIJAN","Baku"},
            {"BELARUS (BYELORUSSIA)","Minsk"},
            {"BULGARIA","Sofia"}, {"GEORGIA","Tbilisi"},
            {"KAZAKSTAN","Almaty"}, {"KYRGYZSTAN","Alma-Ata"},
            {"MOLDOVA","Chisinau"}, {"RUSSIA","Moscow"},
            {"TAJIKISTAN","Dushanbe"}, {"TURKMENISTAN","Ashkabad"},
            {"UKRAINE","Kyiv"}, {"UZBEKISTAN","Tashkent"},
// Europe
            {"ALBANIA","Tirana"}, {"ANDORRA","Andorra la Vella"},
            {"AUSTRIA","Vienna"}, {"BELGIUM","Brussels"},
            {"BOSNIA","-"}, {"HERZEGOVINA","Sarajevo"},
            {"CROATIA","Zagreb"}, {"CZECH REPUBLIC","Prague"},
            {"DENMARK","Copenhagen"}, {"ESTONIA","Tallinn"},
            {"FINLAND","Helsinki"}, {"FRANCE","Paris"},
            {"GERMANY","Berlin"}, {"GREECE","Athens"},
            {"HUNGARY","Budapest"}, {"ICELAND","Reykjavik"},
            {"IRELAND","Dublin"}, {"ITALY","Rome"},
            {"LATVIA","Riga"}, {"LIECHTENSTEIN","Vaduz"},
            {"LITHUANIA","Vilnius"}, {"LUXEMBOURG","Luxembourg"},
            {"MACEDONIA","Skopje"}, {"MALTA","Valletta"},
            {"MONACO","Monaco"}, {"MONTENEGRO","Podgorica"},
            {"THE NETHERLANDS","Amsterdam"}, {"NORWAY","Oslo"},
            {"POLAND","Warsaw"}, {"PORTUGAL","Lisbon"},
            {"ROMANIA","Bucharest"}, {"SAN MARINO","San Marino"},
            {"SERBIA","Belgrade"}, {"SLOVAKIA","Bratislava"},
            {"SLOVENIA","Ljuijana"}, {"SPAIN","Madrid"},
            {"SWEDEN","Stockholm"}, {"SWITZERLAND","Berne"},
            {"UNITED KINGDOM","London"}, {"VATICAN CITY","---"},
// North and Central America
            {"ANTIGUA AND BARBUDA","Saint John’s"},
            {"BAHAMAS","Nassau"},
            {"BARBADOS","Bridgetown"}, {"BELIZE","Belmopan"},
            {"CANADA","Ottawa"}, {"COSTA RICA","San Jose"},
            {"CUBA","Havana"}, {"DOMINICA","Roseau"},
            {"DOMINICAN REPUBLIC","Santo Domingo"},
            {"EL SALVADOR","San Salvador"},
            {"GRENADA","Saint George’s"},
            {"GUATEMALA","Guatemala City"},
            {"HAITI","Port-au-Prince"},
            {"HONDURAS","Tegucigalpa"}, {"JAMAICA","Kingston"},
            {"MEXICO","Mexico City"}, {"NICARAGUA","Managua"},
            {"PANAMA","Panama City"}, {"ST. KITTS","-"},
            {"NEVIS","Basseterre"}, {"ST. LUCIA","Castries"},
            {"ST. VINCENT AND THE GRENADINES","Kingstown"},
            {"UNITED STATES OF AMERICA","Washington, D.C."},
// South America
            {"ARGENTINA","Buenos Aires"},
            {"BOLIVIA","Sucre (legal)/La Paz(administrative)"},
            {"BRAZIL","Brasilia"}, {"CHILE","Santiago"},
            {"COLOMBIA","Bogota"}, {"ECUADOR","Quito"},
            {"GUYANA","Georgetown"}, {"PARAGUAY","Asuncion"},
            {"PERU","Lima"}, {"SURINAME","Paramaribo"},
            {"TRINIDAD AND TOBAGO","Port of Spain"},
            {"URUGUAY","Montevideo"}, {"VENEZUELA","Caracas"},
    };



    private static class FlyweightMap extends AbstractMap<String,String> {

        //   FlyweightMap must implement the entrySet() method, which requires
        //   both a custom Set implementation and a custom Map.Entry class.
        //   Here’s part of the flyweight: each Map.Entry object simply stores its index,
        //   rather than the actual key and value. When you call getKey( ) or getValue( ),
        //   it uses the index to return the appropriate DATA element.

        private static class Entry implements Map.Entry<String,String> {
            // Use index number to get the key and value
            // Index is assigned by the constructor of Entry(int index)
            int index;
            Entry(int index) { this.index = index; }

            public boolean equals(Object o) {
                return DATA[index][0].equals(o);
            }
            // DATA[index][0] is the key
            public String getKey() { return DATA[index][0]; }
            // DATA[index][1] is the value
            public String getValue() { return DATA[index][1]; }
            public String setValue(String value) {
                throw new UnsupportedOperationException();
            }
            public int hashCode() {
                return DATA[index][0].hashCode();
            }
        }


        // Use AbstractSet by implementing size() & iterator()
        // EntrySet will store the entries in the Map in a Set
        // EntrySet(int size) is used to return the entries of a given size
        static class EntrySet extends AbstractSet<Map.Entry<String,String>> {
            private int size;

            // Will return the Set of the given size
            EntrySet(int size) {
                if(size < 0)
                    this.size = 0;
                    // Can't be any bigger than the array:
                else if(size > DATA.length)
                    this.size = DATA.length;
                else
                    this.size = size;
            }

            public int size() { return size; }

            private class Iter implements Iterator<Map.Entry<String,String>> {
                // Only one Entry object per Iterator:
                private Entry entry = new Entry(-1);
                public boolean hasNext() {
                    return entry.index < size - 1;
                }
                public Map.Entry<String,String> next() {
                    entry.index++;
                    return entry;
                }
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            }

            public Iterator<Map.Entry<String,String>> iterator() {
                return new Iter();
            }
        }

        // Entries contain the entire key-value pairs as a Set
        private static Set<Map.Entry<String,String>> entries =
                new EntrySet(DATA.length);
        @Override
        // Override the entrySet() method
        // Returning entire entries as a Set
        public Set<Map.Entry<String,String>> entrySet() {
            return entries;
        }
    }



    // The select() method produces a FlyweightMap containing an EntrySet of the desired size,
    // and this is used in the overloaded capitals() and names() methods that you see demonstrated in main().
    // Create a partial map of 'size' countries:
    static Map<String,String> select(final int size) {
        return new FlyweightMap() {
            @Override
            // Returning entries of the given size, will call the constructor EntrySet(int size)
            public Set<Map.Entry<String,String>> entrySet() {
                return new EntrySet(size);
            }
        };
    }



    // static FlyweightMap containing the entire map (country names as key and capitals as value)
    static Map<String,String> map = new FlyweightMap();
    // The entire map:
    public static Map<String,String> capitals() {
        return map;
    }
    // A partial map:
    public static Map<String,String> capitals(int size) {
        return select(size);
    }


    // names contain all the names:
    static List<String> names = new ArrayList<>(map.keySet()); // Only has map's key (i.e. Country names)
    // All the names:
    public static List<String> names() { return names; }
    // A partial list: (the keyset() of the partial map)
    public static List<String> names(int size) {
        return new ArrayList<>(select(size).keySet());
    }


    public static void main(String[] args) {
        // Getting all or a given size
        System.out.println(capitals());
        System.out.println(names());
        System.out.println(capitals(10));
        System.out.println(names(10));

        // Getting the country-capital pairs
        System.out.println(new HashMap<String,String>(capitals(3)));
        System.out.println(new LinkedHashMap<String,String>(capitals(3)));
        System.out.println(new TreeMap<String,String>(capitals(3)));
        System.out.println(new Hashtable<String,String>(capitals(3)));

        // Only getting the country names
        System.out.println(new HashSet<String>(names(6)));
        System.out.println(new LinkedHashSet<String>(names(6)));
        System.out.println(new TreeSet<String>(names(6)));
        System.out.println(new ArrayList<String>(names(6)));
        System.out.println(new LinkedList<String>(names(6)));
        System.out.println(capitals().get("BRAZIL"));
    }
}