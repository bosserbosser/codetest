
// covariant
class Item<A> {
    private A _x = null;
    public A get() { return _x; }
    public Item<A> set(A _x) { this._x = _x; return this; }
}

class Human {}
class Man extends Human {}

class Main {
    public static void main(String []args) {
        Man[] arr1 = new Man[1];
        Human[] arr2 = arr1;
        arr2[0] = new Human();
    }
}

