package hu.nive.ujratervezes.zarovizsga.cleaning;

import java.util.*;

public class CleaningService {

    private List<Cleanable> cleanables = new ArrayList<>();

    public void add(Cleanable cleanable) {
        cleanables.add(cleanable);
    }

    public int cleanAll() {
        int price = 0;
        for (Cleanable cleanable : cleanables) {
            price += cleanable.clean();
        }
        cleanables.clear();
        return price;
    }

    public int cleanOnlyOffices() {
        int price = 0;
        for (Iterator<Cleanable> iterator = cleanables.iterator(); iterator.hasNext();) {
            Cleanable cleanable = iterator.next();
            if (cleanable instanceof Office) {
                price += cleanable.clean();
                iterator.remove();
            }
        }
        return price;
    }

    public List<Cleanable> findByAddressPart(String address) {
        List<Cleanable> result = new ArrayList<>();
        for (Cleanable cleanable : cleanables) {
            if (cleanable.getAddress().contains(address)) {
                result.add(cleanable);
            }
        }
        return result;
    }

    public String getAddresses() {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (Cleanable cleanable : cleanables) {
            if (first) {
                sb.append(cleanable.getAddress());
                first = false;
            } else {
                sb.append(", ").append(cleanable.getAddress());
            }
        }
        return sb.toString();
    }

    public List<Cleanable> getCleanables() {
        return cleanables;
    }
}
