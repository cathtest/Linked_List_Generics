public class Linked {

    Flower firstFlower;
    Flower lastFlower;

    public void first(FlowerType flowerType) {

        Flower theNewFlower = new Flower(flowerType);



        if (isEmpty()) {

            lastFlower = theNewFlower;

        } else {

            firstFlower.previous = theNewFlower;

        }

        theNewFlower.next = firstFlower;

        firstFlower = theNewFlower;

    }

    public void last(FlowerType flowerType) {

        Flower theNewFlower = new Flower(flowerType);



        if (isEmpty()) {

            firstFlower = theNewFlower;

        } else {


            lastFlower.next = theNewFlower;

            theNewFlower.previous = lastFlower;

        }

        lastFlower = theNewFlower;

    }


    public static void main(String[] args) {


        Linked theLinkedList = new Linked();


        theLinkedList.first(new FlowerType <String> ("Roses are red"));
        theLinkedList.first(new FlowerType <String>("Violets are blue"));
        theLinkedList.first(new FlowerType<String> ("Daffodils are unknown"));
        theLinkedList.last(new FlowerType<String> ("Daisies are rosy"));
        theLinkedList.last(new FlowerType<String> ("Daisies are rosy"));

        FlowerType<String> fl = new FlowerType<String>("Test");

        String s = fl.getob();



        theLinkedList.first(new FlowerType<String> (s));

        theLinkedList.display();

        System.out.println("\n");

        FlowersIt flowers = new FlowersIt(theLinkedList);

        flowers.currentFlower.display();

        System.out.println(flowers.hasNext());

        flowers.next();

        flowers.currentFlower.display();

        flowers.remove();

        flowers.currentFlower.display();


    }


    public boolean isEmpty() {

        return (firstFlower == null);

    }



    public void display() {

        Flower theLink = firstFlower;

        while (theLink != null) {

            theLink.display();

            System.out.println("Next Flower: " + theLink.next);

            theLink = theLink.next;

            System.out.println();

        }

    }

}

class Flower {

    public FlowerType flowerType;


    public Flower next;

    public Flower previous;

    public Flower(FlowerType flowerType) {

        this.flowerType = flowerType;


    }

    public void display() {

        System.out.println(flowerType + ": "  + " Happy Flowers Store");

    }


}



class FlowersIt {

    Flower currentFlower;
    Flower previousFlower;

    Linked theFlowers;



    FlowersIt(Linked theFlowers) {

        this.theFlowers = theFlowers;

        currentFlower = theFlowers.firstFlower;
        previousFlower = theFlowers.lastFlower;

    }

    public boolean hasNext() {

        if (currentFlower.next != null) {

            return true;

        }

        return false;

    }

    public Flower next() {

        if (hasNext()) {

            previousFlower = currentFlower;
            currentFlower = currentFlower.next;

            return currentFlower;

        }

        return null;

    }

    public void remove() {



        if (previousFlower == null) {

            theFlowers.firstFlower = currentFlower.next;

        } else {
            previousFlower.next = currentFlower.next;



            if (currentFlower.next == null) {


                currentFlower = theFlowers.firstFlower;
                previousFlower = null;

            } else {

                currentFlower = currentFlower.next;

            }

        }

    }

}
