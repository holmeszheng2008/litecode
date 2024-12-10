package queue_stack.monotonic;

import java.util.LinkedList;

// 735. Asteroid Collision

// If run in orbits
public class Solution735 {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < asteroids.length; i++){
            int value = asteroids[i];
            if(list.isEmpty()){
                list.addLast(value);
            } else {
                if(value > 0){
                    list.addLast(value);
                } else {
                    int top = list.getLast();
                    if(top < 0) {
                        list.addLast(value);
                    } else {
                        if(top > Math.abs(value)) {
                            continue;
                        } else if (top < Math.abs(value)) {
                            list.removeLast();
                            i--;
                        } else {
                            list.removeLast();
                        }
                    }
                }
            }
        }

        if(list.isEmpty() || list.getFirst() > 0){
            return list.stream().mapToInt(n -> n).toArray();
        }

        while(true){
            int first = list.getFirst();
            int last = list.getLast();
            if((first ^ last) > 0){
                break;
            }
            if(Math.abs(first) > Math.abs(last)){
                list.removeLast();
            } else if (Math.abs(first) < Math.abs(last)) {
                list.removeFirst();
            } else {
                list.removeLast();
                list.removeFirst();
            }
            if(list.isEmpty()){
                break;
            }
        }

        return list.stream().mapToInt(n -> n).toArray();
    }
}


class Solution735_attempt1 {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < asteroids.length; i++){
            int value = asteroids[i];
            if(list.isEmpty()){
                list.addLast(value);
            } else {
                if(value > 0){
                    list.addLast(value);
                } else {
                    int top = list.getLast();
                    if(top < 0) {
                        list.addLast(value);
                    } else {
                        if(top > Math.abs(value)) {
                            continue;
                        } else if (top < Math.abs(value)) {
                            list.removeLast();
                            i--;
                        } else {
                            list.removeLast();
                        }
                    }
                }
            }
        }

        return list.stream().mapToInt(n -> n).toArray();
    }
}

class Solution735_attempt2 {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < asteroids.length; i++){
            int asteroid = asteroids[i];
            if(list.isEmpty()){
                list.add(asteroid);
            } else if (asteroid > 0) {
                list.add(asteroid);
            } else if (asteroid < 0){
                int top = list.getLast();
                if(top < 0){
                    list.add(asteroid);
                } else {
                    if(top == -asteroid){
                        list.removeLast();
                    } else if (top > -asteroid){

                    } else {
                        list.removeLast();
                        i--;
                    }
                }
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}