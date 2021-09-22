package custommap;

public class Demo {

    public static void main(String[] args) {
        CustomMap customMap = new CustomMap();
        customMap.put("19", "Abc");
        customMap.put("21", "test");
        customMap.put("38", "xyz");
        customMap.put("38", "temp");
        customMap.put("38", "temp2");
        customMap.put("63", "tests");
        System.out.println(customMap.get("19"));
        System.out.println(customMap.get("38"));
        System.out.println(customMap.get("63"));
        System.out.println(customMap.get("29"));

        int sum_given = 15;


        /*
        sum_given = starting_number +...+ ending_number => (k+1) consecutive numbers
        sum_given = starting_number +...+ (starting_number+ k)
        sum_given = ( starting_number * k ) + (0+1+2+..+k)

         */
    }


}


//docker run --volume ~/repo/lichocker/lila: /home/lichess/projects/lila --publish 80:80 --publish 9663:9663 --name lichess --interactive --tty brandone211/lichess