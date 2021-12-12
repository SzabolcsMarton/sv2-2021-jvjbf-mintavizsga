package aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {

    private static final int ENVIROMENT = 5;
    public static final int CAPACITY = 20;
    private List<Fish> fishes = new ArrayList<>();

    public void addFish(Fish fish){
        if((fishes.size() +1) * ENVIROMENT <= CAPACITY){
            fishes.add(fish);
        }else {
            throw new IllegalStateException("Can not add fish because there is no more space.");
        }

    }

    public void feed(){
        for(Fish actual : fishes){
           actual.feed();
        }
    }

    public void removeFish(int maxWeight){
        List<Fish>fishToRemove = new ArrayList<>();
        for(Fish actual : fishes){
            if(actual.getWeight() > maxWeight){
                fishToRemove.add(actual);
            }
        }
        fishes.removeAll(fishToRemove);
    }

    public List<String> getStatus(){
        List<String> result = new ArrayList<>();
        for(Fish actual : fishes){
            result.add(actual.getStatus());
        }
        return result;
    }

    public int getNumberOfFishWithMemoryLoss(){
        int count = 0;
        for (Fish actual : fishes){
            if(actual.hasMemoryLoss()){
                count++;
            }
        }
        return count;
    }

    public boolean isThereFishWithGivenColor(String color){
        boolean result = false;
        for (Fish actual : fishes){
            if(actual.getColor().equals(color)){
                result = true;
            }
        }
        return result;
    }

    public Fish getSmallestFish(){
        Fish fish = fishes.get(0);
        for (Fish actual : fishes){
            if(actual.getWeight() < fish.getWeight()){
                fish = actual;
            }
        }
        return fish;
    }
}
