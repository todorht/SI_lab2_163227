import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    //T1=22,40,60; t2=17,23,21; t3=23,14,32
    private List<Time> createList(Time time1, Time time2, Time time3){
        List<Time> timesList = new ArrayList<>();
        timesList.add(time1);
        timesList.add(time2);
        timesList.add(time3);
        return timesList;
    }

    public static List<Integer> result = new ArrayList<>();

    @BeforeAll
    public static void init(){
        result.add(52830);
        result.add(62601);
        result.add(83672);
    }

    @Test
    void everyBranchAndStatementTest(){
        RuntimeException ex;
        //1
        assertEquals(new ArrayList<>(), SILab2.function(new ArrayList<>()));

        //2
        ex = assertThrows(RuntimeException.class,
                ()->SILab2.function(createList(new Time(22,44,60),
                        new Time(17,23,21),
                        new Time(23,14,32))));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        //3
        ex = assertThrows(RuntimeException.class,
                ()->SILab2.function(createList(new Time(-25,40,30),
                        new Time(17,23,21),
                        new Time(23,14,32))));
        assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));

        //4
        ex = assertThrows(RuntimeException.class,
                ()->SILab2.function(createList(new Time(14,40,30),
                        new Time(17,23,21),
                        new Time(24,-14,32))));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));

        //5
        ex = assertThrows(RuntimeException.class,
                ()->SILab2.function(createList(new Time(14,40,30),
                        new Time(24,0,0),
                        new Time(25,0,0))));
        assertTrue(ex.getMessage().contains("The hours are grater than the maximum"));

        //7
        assertEquals(result,SILab2.function(createList(new Time(14,40,30),
                new Time(17,23,21),
                new Time(23,14,32))));

        //6
        ex = assertThrows(RuntimeException.class,
                ()->SILab2.function(createList(new Time(14,-10,30),
                        new Time(24,0,0),
                        new Time(25,0,0))));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));

    }
}